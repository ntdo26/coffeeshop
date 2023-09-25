package com.interview.coffeeshop.shop.repository;

import com.interview.coffeeshop.shop.entity.ShopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShopRepository extends JpaRepository<ShopEntity, UUID> {

    List<ShopEntity> findByTenant(String tenant);
}
