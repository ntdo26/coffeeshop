package com.interview.coffeeshop.shop.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Shop {

    private UUID id;
    private String location;
    private String phoneNumber;
    private int numberOfQueues;
    private int maximumSizeOfQueues;
    private int openingTime;
    private int closeTime;
    private Boolean isClosed;
}
