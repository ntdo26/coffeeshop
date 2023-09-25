package com.interview.coffeeshop.order.repository;

import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.order.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Optional<OrderEntity> findByTenantAndCode(String tenant, String code);

    List<OrderEntity> findByTenantAndShopIdAndStatusIn(String tenant, UUID uuid, List<OrderStatus> statuses);
}
