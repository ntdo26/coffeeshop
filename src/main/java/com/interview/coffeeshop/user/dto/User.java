package com.interview.coffeeshop.user.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String tenant;
    private String userId;
    private String userName;
}
