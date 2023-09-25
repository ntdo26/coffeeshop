package com.interview.coffeeshop.brand.service;

import com.interview.coffeeshop.brand.converter.BrandConverter;
import com.interview.coffeeshop.brand.dto.Brand;
import com.interview.coffeeshop.brand.entity.BrandEntity;
import com.interview.coffeeshop.brand.repository.BrandRepository;
import com.interview.coffeeshop.brand.request.CreateBrandReq;
import com.interview.coffeeshop.common.exception.ErrorCode;
import com.interview.coffeeshop.common.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    public UUID createNewBrand(CreateBrandReq createBrandReq) {
        return brandRepository.save(brandConverter.fromRequest(createBrandReq)).getId();
    }

    public List<Brand> getBrands() {
        return brandRepository
                .findAll()
                .stream()
                .map(brandConverter::fromEntity)
                .toList();
    }

    public BrandEntity getBrandByTenant(String tenant) {
        return brandRepository
                .findOneByCode(tenant)
                .orElseThrow(() -> new ServiceException(ErrorCode.BRAND_404_001));
    }
}
