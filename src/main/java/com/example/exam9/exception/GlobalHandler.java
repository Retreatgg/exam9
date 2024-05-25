package com.example.exam9.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String notFoundHandler() {
        return "errors/error";
    }
}
