package com.vastika.training.capstone.suchanaapi.exceptions;

import lombok.Getter;

@Getter
public class SuchanaApiException extends RuntimeException {
    private String message;
    private int code;

    public SuchanaApiException() {
        super();
    }

    public SuchanaApiException(String message, int code) {
        this(message, code, null);
    }

    public SuchanaApiException(String message, int code, Throwable throwable) {
        super(throwable);
        this.message = message;
        this.code = code;
    }
}
