package com.interview.coffeeshop.brand.controller;

import com.interview.coffeeshop.brand.dto.Brand;
import com.interview.coffeeshop.brand.request.CreateBrandReq;
import com.interview.coffeeshop.brand.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public UUID createNewBrand(@RequestBody CreateBrandReq createBrandReq) {
//        return brandService.createNewBrand(createBrandReq);
//    }

    @GetMapping
    public List<Brand> getBrands() {
        return brandService.getBrands();
    }
}
