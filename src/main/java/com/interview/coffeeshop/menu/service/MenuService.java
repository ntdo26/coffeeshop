package com.interview.coffeeshop.menu.service;

import com.interview.coffeeshop.common.exception.ErrorCode;
import com.interview.coffeeshop.common.exception.ServiceException;
import com.interview.coffeeshop.menu.converter.DrinkConverter;
import com.interview.coffeeshop.menu.dto.Drink;
import com.interview.coffeeshop.menu.entity.DrinkEntity;
import com.interview.coffeeshop.menu.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final DrinkRepository drinkRepository;
    private final DrinkConverter drinkConverter;

    public List<Drink> getDrinks(String tenant, UUID shopId) {
        var entities = drinkRepository.findByTenantAndShopId(tenant, shopId);
        return entities.stream().map(drinkConverter::fromEntity).toList();
    }

    public DrinkEntity findByTenantAndId(String tenantId, UUID id) {
        return drinkRepository
                .findByTenantAndId(tenantId, id)
                .orElseThrow(() -> new ServiceException(ErrorCode.DRINK_404_001));
    }
}
