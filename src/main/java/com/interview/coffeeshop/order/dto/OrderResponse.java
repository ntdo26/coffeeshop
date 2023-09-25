package com.interview.coffeeshop.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderResponse {

    private String code;
    private int position;
    private int waitingTime;
}
