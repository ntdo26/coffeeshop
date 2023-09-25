package com.interview.coffeeshop.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    RESOURCE_404_001(HttpStatus.NOT_FOUND, "RESOURCE_001", "resource does not exist"),
    BRAND_404_001(HttpStatus.NOT_FOUND, "BRD_001", "tenant does not exist"),
    DRINK_404_001(HttpStatus.NOT_FOUND, "DRK_001", "drink does not exist"),
    QUEUE_404_001(HttpStatus.NOT_FOUND, "QUE_001", "Resource not found"),
    QUEUE_400_001(HttpStatus.BAD_REQUEST, "QUE_002", "Order is not in queue"),
    ORDER_404_001(HttpStatus.NOT_FOUND, "ORD_001", "order does not exist"),
    ORDER_400_001(HttpStatus.BAD_REQUEST, "ORD_002", "Cannot cancel the order");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
