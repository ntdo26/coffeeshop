package com.interview.coffeeshop.brand.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Brand {

    private UUID id;
    private String name;
    private String code;
}
