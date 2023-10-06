package com.example.Test_Service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandled{
    @ExceptionHandler(CustomException.UserNotFoundException.class)
    public ResponseEntity<Object> UserNotFoundException(CustomException.UserNotFoundException ex) {
        // Create a custom error response
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, "Please check user details. If problem persist call our IT Support team.", ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.EmptyFieldException.class)
    public ResponseEntity<Object> EmptyFieldException(CustomException.EmptyFieldException ex) {
        // Create a custom error response
        ApiError apiError = new ApiError(HttpStatus.PARTIAL_CONTENT, "Incomplete Data.", ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.PARTIAL_CONTENT);
    }

}
