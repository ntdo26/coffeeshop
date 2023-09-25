package com.interview.coffeeshop.brand.converter;

import com.interview.coffeeshop.brand.dto.Brand;
import com.interview.coffeeshop.brand.entity.BrandEntity;
import com.interview.coffeeshop.brand.mapper.BrandMapper;
import com.interview.coffeeshop.brand.request.CreateBrandReq;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BrandConverter {

    @Autowired
    private final BrandMapper brandMapper;

    public Brand fromEntity(BrandEntity item) {
        return brandMapper.fromEntity(item);
    }

    public BrandEntity fromRequest(CreateBrandReq req) {
        return brandMapper.fromRequest(req);
    }
}
