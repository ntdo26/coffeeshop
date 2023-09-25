package com.interview.coffeeshop.shop.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateShopReq {

    @NotBlank
    private String location;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private int numberOfQueues;

    @NotBlank
    private int maximumSizeOfQueues;

    @NotBlank
    private int openingTime;

    @NotBlank
    private int closeTime;

    private Boolean isClosed;
}
