package com.chemicaltools.chemicaltools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CSVValidationException extends RuntimeException {
    public CSVValidationException(String message) {
        super(message);
    }
}
