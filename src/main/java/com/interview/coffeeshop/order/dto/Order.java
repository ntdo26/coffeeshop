package com.interview.coffeeshop.order.dto;

import com.interview.coffeeshop.menu.dto.Drink;
import com.interview.coffeeshop.order.entity.OrderStatus;
import com.interview.coffeeshop.shop.dto.Shop;
import com.interview.coffeeshop.user.dto.User;
import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private UUID id;
    private String tenant;
    private String code;
    private Shop shop;
    private Drink drink;
    private User user;
    private String price;
    private OrderStatus status;
    private int position;
    private int waitingTime;
}
