package com.interview.coffeeshop.application.customer;

import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.dto.OrderResponse;
import com.interview.coffeeshop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final OrderService orderService;

    @PostMapping("/orders/{code}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelOrder(@RequestHeader("tenant") String tenant,
                             @PathVariable("code") String code) {
        orderService.cancelOrder(tenant, code);
    }


    @GetMapping("/orders/{code}")
    public Order getOrder(@RequestHeader("tenant") String tenant,
                          @PathVariable("code") String code) {
        return orderService.getOrder(tenant, code);
    }

    @PostMapping("/drinks/{id}/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse orderDrink(@RequestHeader("tenant") String tenant,
                                    @PathVariable("id") UUID id) {
        return orderService.createOrder(tenant, id);
    }
}
