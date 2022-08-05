package com.thoughtworks.training.exception;

public class CompanyNotFoundException extends RuntimeException {
    private final String message;

    public CompanyNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
