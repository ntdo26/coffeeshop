package com.interview.coffeeshop.order.controller;

import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.dto.OrderResponse;
import com.interview.coffeeshop.order.request.CreateOrderRequest;
import com.interview.coffeeshop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/{code}")
    public Order getOrder(@RequestHeader("tenant") String tenant,
                               @PathVariable("code") String code) {
        return orderService.getOrder(tenant, code);
    }

    @PostMapping("/items/{id}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse orderDrink(@RequestHeader("tenant") String tenant,
                                    @PathVariable("id") UUID id) {
        return orderService.createOrder(tenant, id);
    }
}
