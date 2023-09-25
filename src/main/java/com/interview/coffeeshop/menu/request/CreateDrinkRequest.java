package com.interview.coffeeshop.menu.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateDrinkRequest {

    @NotBlank
    private String name;

    @NotNull
    private Long price;

    private Integer discountByPercent;
    private Boolean isOutOfStock;
}
