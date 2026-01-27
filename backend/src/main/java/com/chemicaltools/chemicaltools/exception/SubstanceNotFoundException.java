package com.chemicaltools.chemicaltools.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SubstanceNotFoundException extends RuntimeException {
    public SubstanceNotFoundException(String message) {
        super(message);
    }
}
