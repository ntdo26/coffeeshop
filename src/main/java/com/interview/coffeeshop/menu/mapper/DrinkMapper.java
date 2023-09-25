package com.interview.coffeeshop.menu.mapper;


import com.interview.coffeeshop.menu.dto.Drink;
import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.menu.request.CreateDrinkRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DrinkMapper {

    Drink fromEntity(DrinkEntity drinkEntity);

    DrinkEntity fromRequest(CreateDrinkRequest request);
}
