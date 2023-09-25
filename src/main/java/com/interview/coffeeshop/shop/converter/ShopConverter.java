package com.interview.coffeeshop.shop.converter;

import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.shop.entity.ShopEntity;
import com.interview.coffeeshop.shop.mapper.ShopMapper;
import com.interview.coffeeshop.shop.request.CreateShopReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopConverter {

    @Autowired
    private final ShopMapper shopMapper;

    public Shop fromEntity(ShopEntity item) {
        return shopMapper.fromEntity(item);
    }

    public ShopEntity fromRequest(String tenant, CreateShopReq createShopReq) {
        var entity = shopMapper.fromEntity(createShopReq);
        entity.setTenant(tenant);
        return entity;
    }
}
