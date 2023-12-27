package com.example.demo4.service;

import org.springframework.validation.BindingResult;

import com.example.demo4.exception.ValidationFailedException;

public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}