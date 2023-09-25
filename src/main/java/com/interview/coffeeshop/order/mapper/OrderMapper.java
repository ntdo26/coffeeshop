package com.interview.coffeeshop.order.mapper;


import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.order.request.CreateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    Order fromEntity(OrderEntity orderEntity);

    OrderEntity fromRequest(CreateOrderRequest request);
}
