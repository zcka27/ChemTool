package com.chemicaltools.chemicaltools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TemperatureOutRangeException extends RuntimeException {
    public TemperatureOutRangeException(String message) {
        super(message);
    }
}
