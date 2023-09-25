package com.interview.coffeeshop.user.repository;

import com.interview.coffeeshop.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByTenantAndUserId(String tenantId, String userId);
}
