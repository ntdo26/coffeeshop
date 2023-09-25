package com.interview.coffeeshop.menu.converter;

import com.interview.coffeeshop.menu.dto.Drink;
import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.menu.mapper.DrinkMapper;
import com.interview.coffeeshop.menu.request.CreateDrinkRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DrinkConverter {

    @Autowired
    private final DrinkMapper drinkMapper;

    public Drink fromEntity(DrinkEntity item) {
        return drinkMapper.fromEntity(item);
    }

    public DrinkEntity fromRequest(CreateDrinkRequest item) {
        return drinkMapper.fromRequest(item);
    }
}
