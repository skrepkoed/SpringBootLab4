package com.example.demo4.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo4.exception.ValidationFailedException;
@Service
public class RequestValidationService implements ValidationService  {
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
