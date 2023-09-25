package com.interview.coffeeshop.brand.mapper;


import com.interview.coffeeshop.brand.dto.Brand;
import com.interview.coffeeshop.brand.entity.BrandEntity;
import com.interview.coffeeshop.brand.request.CreateBrandReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    Brand fromEntity(BrandEntity itemEntity);

    @Mapping(source = "brandName", target = "name")
    @Mapping(source = "brandCode", target = "code")
    BrandEntity fromRequest(CreateBrandReq shopReq);
}
