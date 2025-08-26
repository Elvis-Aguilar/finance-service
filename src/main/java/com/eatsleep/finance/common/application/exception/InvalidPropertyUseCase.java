package com.eatsleep.finance.common.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class InvalidPropertyUseCase extends RuntimeException {
    public InvalidPropertyUseCase(String message) {
        super(message);
    }
}
