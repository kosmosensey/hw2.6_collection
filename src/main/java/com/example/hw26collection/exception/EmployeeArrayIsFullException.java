package com.example.hw26collection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeArrayIsFullException extends RuntimeException {
    public EmployeeArrayIsFullException(String message) {
        super(message);
    }
}
