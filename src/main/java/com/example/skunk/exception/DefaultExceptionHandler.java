package com.example.skunk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.module.ResolutionException;

@RestControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(ResolutionException.class)
    public ResponseEntity<ApiError> handleException(Exception e, HttpServletRequest request){
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                e.getMessage(),
                HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}