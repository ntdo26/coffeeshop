package com.interview.coffeeshop.shop.service;

import com.interview.coffeeshop.shop.converter.ShopConverter;
import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.shop.repository.ShopRepository;
import com.interview.coffeeshop.shop.request.CreateShopReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopConverter shopConverter;

    public UUID createNewShop(String tenant, CreateShopReq createShopReq) {
        var entity = shopConverter.fromRequest(tenant, createShopReq);
        return shopRepository.save(entity).getId();
    }

    public List<Shop> getShops(String tenant) {
        return shopRepository
                .findByTenant(tenant)
                .stream()
                .map(shopConverter::fromEntity)
                .toList();
    }
}
