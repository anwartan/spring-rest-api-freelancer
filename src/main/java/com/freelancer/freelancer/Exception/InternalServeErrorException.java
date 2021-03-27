package com.freelancer.freelancer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InternalServeErrorException extends Exception {
    public InternalServeErrorException() {
    }

    public InternalServeErrorException(String message) {
        super(message);
    }
}
