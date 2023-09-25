package com.interview.coffeeshop.menu.repository;

import com.interview.coffeeshop.menu.entity.DrinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<DrinkEntity, UUID> {

    List<DrinkEntity> findByTenantAndShopId(String tenant, UUID shopId);

    Optional<DrinkEntity> findByTenantAndId(String tenant, UUID id);
}
