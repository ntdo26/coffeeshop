package com.interview.coffeeshop.order.converter;

import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.order.mapper.OrderMapper;
import com.interview.coffeeshop.order.request.CreateOrderRequest;
import com.interview.coffeeshop.queue.dto.QueuePosition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderConverter {

    @Autowired
    private final OrderMapper orderMapper;

    public Order fromEntity(OrderEntity item) {
        return orderMapper.fromEntity(item);
    }

    public Order fromEntity(OrderEntity item, QueuePosition queuePosition) {
        var order = orderMapper.fromEntity(item);
        order.setPosition(queuePosition.getPosition());
        order.setWaitingTime(queuePosition.getTotalWaitingTime());
        return order;
    }

    public OrderEntity fromRequest(CreateOrderRequest item) {
        return orderMapper.fromRequest(item);
    }
}
