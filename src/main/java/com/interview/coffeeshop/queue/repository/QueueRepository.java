package com.interview.coffeeshop.queue.repository;

import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.entity.OrderEntity;
import com.interview.coffeeshop.queue.entity.QueueEntity;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QueueRepository extends JpaRepository<QueueEntity, UUID> {

    List<QueueEntity> findByTenantAndShop(String tenant, ShopEntity shop);

    Optional<QueueEntity> findTopByShopOrderByPositionDesc(ShopEntity shop);

}
