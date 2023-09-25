package com.interview.coffeeshop.brand.repository;

import com.interview.coffeeshop.brand.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, UUID> {

    Optional<BrandEntity> findOneByCode(String tenant);
}
