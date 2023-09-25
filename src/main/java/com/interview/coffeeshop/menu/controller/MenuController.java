package com.interview.coffeeshop.menu.controller;

import com.interview.coffeeshop.menu.dto.Drink;
import com.interview.coffeeshop.menu.request.CreateDrinkRequest;
import com.interview.coffeeshop.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/shops/{id}/drinks")
    public List<Drink> getMenu(@RequestHeader("tenant") String tenant,
                               @PathVariable("id") UUID id) {
        return menuService.getDrinks(tenant, id);
    }
}
