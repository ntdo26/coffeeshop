package com.interview.coffeeshop.queue.service;

import com.interview.coffeeshop.common.exception.ErrorCode;
import com.interview.coffeeshop.common.exception.ServiceException;
import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.queue.dto.QueuePosition;
import com.interview.coffeeshop.queue.entity.QueueEntity;
import com.interview.coffeeshop.queue.repository.QueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueueService {

    private final QueueRepository queueRepository;

    public QueuePosition getQueuePosition(String tenant, OrderEntity order) {
        var shop = order.getShop();
        var queues = queueRepository.findByTenantAndShop(tenant, shop);
        return getQueuePosition(order, queues);
    }

    public QueuePosition getQueuePosition(OrderEntity order, List<QueueEntity> queues) {
        var currentPositionOpt = queues.stream().filter(item -> order.getId().equals(item.getOrder().getId())).findFirst();
        int currentPosition;
        if (currentPositionOpt.isEmpty()) {
            throw new ServiceException(ErrorCode.QUEUE_400_001);
        } else {
            currentPosition = currentPositionOpt.get().getPosition();
        }
        var previousOrders = queues.stream().filter(item -> currentPosition > item.getPosition()).map(QueueEntity::getOrder).toList();
        int totalWaitingTime = previousOrders.stream().mapToInt(element -> element.getDrink().getMinutesForPreparing()).sum() + order.getDrink().getMinutesForPreparing();
        return QueuePosition.builder()
                .totalWaitingTime(totalWaitingTime)
                .position(currentPosition)
                .build();
    }

    public void deleteItemInQueue(QueueEntity queue) {
        queueRepository.delete(queue);
    }

    public int newOrder(String tenant, OrderEntity orderEntity) {
        var maxPositionOrderOpt = queueRepository.findTopByShopOrderByPositionDesc(orderEntity.getShop());
        int currentMaxPosition = 0;
        if (maxPositionOrderOpt.isPresent()) {
            currentMaxPosition = maxPositionOrderOpt.get().getPosition();
        }
        QueueEntity queueEntity = QueueEntity
                .builder()
                .tenant(tenant)
                .order(orderEntity)
                .shop(orderEntity.getShop())
                .position(currentMaxPosition + 1)
                .build();
        return queueRepository.save(queueEntity).getPosition();
    }
}
