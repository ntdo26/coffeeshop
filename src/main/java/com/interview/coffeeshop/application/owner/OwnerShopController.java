package com.interview.coffeeshop.application.owner;

import com.interview.coffeeshop.order.dto.Order;
import com.interview.coffeeshop.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/owner")
@RequiredArgsConstructor
public class OwnerShopController {

    private final OrderService orderService;

    @RequestMapping("/shops/{shopId}/orders")
    public List<Order> getOrdersInQueue(@RequestHeader("tenant") String tenant,
                                 @PathVariable("shopId") UUID shopId) {
        return orderService.getOrders(tenant, shopId);
    }
}
