package com.thoughtworks.training.advice;

import com.thoughtworks.training.exception.CompanyNotFoundException;
import com.thoughtworks.training.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorResponse handleNotFound(EmployeeNotFoundException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CompanyNotFoundException.class)
    public ErrorResponse handleNotFound(CompanyNotFoundException exception) {
        return new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.name());
    }
}
