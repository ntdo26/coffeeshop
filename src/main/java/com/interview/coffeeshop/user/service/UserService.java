package com.interview.coffeeshop.user.service;

import com.interview.coffeeshop.common.exception.ErrorCode;
import com.interview.coffeeshop.common.exception.ServiceException;
import com.interview.coffeeshop.user.entity.UserEntity;
import com.interview.coffeeshop.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity getUserById(String tenant, String userId) {
        return userRepository.findByTenantAndUserId(tenant, userId)
                .orElseThrow(() -> new ServiceException(ErrorCode.RESOURCE_404_001));
    }
}
