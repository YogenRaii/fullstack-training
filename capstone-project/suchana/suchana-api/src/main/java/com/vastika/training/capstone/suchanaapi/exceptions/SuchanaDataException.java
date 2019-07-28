package com.vastika.training.capstone.suchanaapi.exceptions;

import lombok.Getter;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class SuchanaDataException extends RuntimeException {
    private String message;

    private List<FieldError> errors;

    public SuchanaDataException() {
        super();
    }

    public SuchanaDataException(String message, List<FieldError> errors) {
        super(message);
        this.errors = errors;
    }
}
