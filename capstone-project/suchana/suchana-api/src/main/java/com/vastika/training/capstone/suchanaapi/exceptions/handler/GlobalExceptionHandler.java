package com.vastika.training.capstone.suchanaapi.exceptions.handler;

import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaApiException;
import com.vastika.training.capstone.suchanaapi.exceptions.SuchanaDataException;
import com.vastika.training.capstone.suchanaapi.models.dtos.ApiError;
import com.vastika.training.capstone.suchanaapi.models.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * AOP implementation for global exception handling
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SuchanaApiException.class)
    public ResponseEntity<ErrorResponse> handleSuchanaApiException(SuchanaApiException apiException) {
        String message = apiException.getMessage();
        int code = apiException.getCode();

        ApiError apiError = new ApiError(message, code);

        List<ApiError> errors = new ArrayList<>();
        errors.add(apiError);

        ErrorResponse response = new ErrorResponse("Suchana API Error!", errors);

        return new ResponseEntity<>(response, HttpStatus.resolve(code));
    }

    @ExceptionHandler(SuchanaDataException.class)
    public ResponseEntity<ErrorResponse> handleSuchanaDataException(SuchanaDataException dataException) {
        List<FieldError> fieldErrors = dataException.getErrors();

        List<ApiError> errors = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            errors.add(new ApiError(fieldError.getField() + ": " +
            fieldError.getDefaultMessage(), 400));
        }

        ErrorResponse response = new ErrorResponse("Suchana API Error!", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
