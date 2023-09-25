package com.interview.coffeeshop.shop.mapper;


import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import com.interview.coffeeshop.shop.request.CreateShopReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShopMapper {
    Shop fromEntity(ShopEntity itemEntity);

    ShopEntity fromEntity(CreateShopReq req);
}
