package com.thoughtworks.training.advice;

public class ErrorResponse {
    private final String message;
    private final String status;

    public ErrorResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
