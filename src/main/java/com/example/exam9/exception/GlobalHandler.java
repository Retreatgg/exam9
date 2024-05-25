package com.example.exam9.exception;

import org.springframework.ui.Model;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public String notFoundHandler() {
        return "errors/error";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalError(IllegalArgumentException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "errors/illegalError";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validationError(MethodArgumentNotValidException e, Model model) {
        model.addAttribute("errorMessage", e.getBindingResult().getFieldError().getDefaultMessage());
        return "errors/illegalError";
    }
}
