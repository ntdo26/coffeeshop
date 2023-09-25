package com.interview.coffeeshop.brand.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBrandReq {

    @NotBlank
    private String brandCode;

    @NotBlank
    private String brandName;
}
