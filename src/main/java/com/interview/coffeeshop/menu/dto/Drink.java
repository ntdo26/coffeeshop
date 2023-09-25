package com.interview.coffeeshop.menu.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Drink {

    private UUID id;
    private String name;
    private String tenant;
    private String price;
    private Integer discountByPercent;
    private Boolean isOutOfStock;
    // time to prepare drink;
    private int minutesForPreparing;
}
