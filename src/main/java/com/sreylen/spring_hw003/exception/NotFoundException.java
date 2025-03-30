package com.sreylen.spring_hw003.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message + "Not found");
    }
}