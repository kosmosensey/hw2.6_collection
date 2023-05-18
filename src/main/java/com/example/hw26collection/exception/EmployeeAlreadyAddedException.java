package com.example.hw26collection.exception;


public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String massage) {
        super(massage);
    }
}
