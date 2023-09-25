package com.interview.coffeeshop.user.converter;

import com.interview.coffeeshop.user.dto.User;
import com.interview.coffeeshop.user.entity.UserEntity;
import com.interview.coffeeshop.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

    @Autowired
    private final UserMapper userMapper;

    public User fromEntity(UserEntity item) {
        return userMapper.fromEntity(item);
    }

}
