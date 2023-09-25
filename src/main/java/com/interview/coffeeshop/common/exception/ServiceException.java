package com.interview.coffeeshop.common.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {

    private ErrorCode errorCode;

    public ServiceException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }
}
