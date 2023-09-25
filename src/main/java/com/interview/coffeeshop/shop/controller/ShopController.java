package com.interview.coffeeshop.shop.controller;

import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.shop.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UUID createNewShop(@RequestHeader("tenant") String tenant,
//                              @RequestBody CreateShopReq createShopReq) {
//        return shopService.createNewShop(tenant, createShopReq);
//    }

    @GetMapping
    public List<Shop> getShops(@RequestHeader("tenant") String tenant) {
        return shopService.getShops(tenant);
    }
}
