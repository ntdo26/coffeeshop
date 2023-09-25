package com.interview.coffeeshop.user.mapper;


import com.interview.coffeeshop.user.dto.User;
import com.interview.coffeeshop.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User fromEntity(UserEntity userEntity);
}
