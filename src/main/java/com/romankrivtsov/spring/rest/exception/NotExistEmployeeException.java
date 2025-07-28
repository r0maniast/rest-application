package com.romankrivtsov.spring.rest.exception;

public class NotExistEmployeeException extends RuntimeException{

    public NotExistEmployeeException(String message) {
        super(message);
    }
}
