package com.interview.coffeeshop.order.service;

import com.interview.coffeeshop.common.exception.ErrorCode;
import com.interview.coffeeshop.common.exception.ServiceException;
import com.interview.coffeeshop.helper.JwtUtils;
import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.menu.service.MenuService;
import com.interview.coffeeshop.order.converter.OrderConverter;
import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.dto.OrderResponse;
import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.order.entity.OrderStatus;
import com.interview.coffeeshop.order.repository.OrderRepository;
import com.interview.coffeeshop.queue.dto.QueuePosition;
import com.interview.coffeeshop.queue.service.QueueService;
import com.interview.coffeeshop.user.entity.UserEntity;
import com.interview.coffeeshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final QueueService queueService;
    private final OrderRepository orderRepository;
    private final MenuService menuService;
    private final UserService userService;
    private final OrderConverter orderConverter;

    public List<Order> getOrders(String tenant, UUID shopId) {
        var orders = orderRepository
                .findByTenantAndShopIdAndStatusIn(tenant, shopId, List.of(OrderStatus.WAITING, OrderStatus.CONFIRMED));
        var ItemsInQueue = orders.stream().map(OrderEntity::getQueue).toList();
        return orders.stream()
                .map(entity -> {
                    var queueInfo = queueService.getQueuePosition(entity, ItemsInQueue);
                    return orderConverter.fromEntity(entity, queueInfo);
                })
                .sorted(Comparator.comparing(Order::getPosition))
                .toList();
    }

    public Order getOrder(String tenant, String code) {
        var order = orderRepository.findByTenantAndCode(tenant, code)
                .orElseThrow(() -> new ServiceException(ErrorCode.ORDER_404_001));
        QueuePosition queuePosition = queueService.getQueuePosition(tenant, order);
        return orderConverter.fromEntity(order, queuePosition);
    }

    @Transactional
    public void cancelOrder(String tenant, String code) {
        var order = orderRepository.findByTenantAndCode(tenant, code)
                .orElseThrow(() -> new ServiceException(ErrorCode.ORDER_404_001));
        if (OrderStatus.WAITING.equals(order.getStatus())) {
            order.setStatus(OrderStatus.CANCELED);
            orderRepository.save(order);
            queueService.deleteItemInQueue(order.getQueue());
            return;
        }
        throw new ServiceException(ErrorCode.ORDER_400_001);
    }

    @Transactional
    public OrderResponse createOrder(String tenant, UUID itemId) {
        DrinkEntity drinkEntity = menuService.findByTenantAndId(tenant, itemId);
        UserEntity userEntity = userService.getUserById(tenant, JwtUtils.getUserId());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCode(RandomStringUtils.randomAlphabetic(6));
        orderEntity.setDrink(drinkEntity);
        orderEntity.setShop(drinkEntity.getShop());
        orderEntity.setPrice(String.valueOf(drinkEntity.discountedPrice()));
        orderEntity.setTenant(tenant);
        orderEntity.setStatus(OrderStatus.WAITING);
        orderEntity.setUser(userEntity);
        OrderEntity ordered = orderRepository.save(orderEntity);

        int position = queueService.newOrder(tenant, ordered);
        QueuePosition queuePosition = queueService.getQueuePosition(tenant, ordered);
        return OrderResponse.builder()
                .position(position)
                .waitingTime(queuePosition.getTotalWaitingTime())
                .code(ordered.getCode())
                .build();
    }
}
