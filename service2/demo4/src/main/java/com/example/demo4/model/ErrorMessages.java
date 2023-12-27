package com.example.demo4.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorMessages {
    EMPTY(""),VALIDATION("Ошибка валидации"),
    UNSUPPORTED("Произошла непредвиденная ошибка"),
    UNKNOWN("Неподдерживаемая ошибка");

    private final String description;
    
    ErrorMessages(String description){
        this.description=description;
    }

    public String toString(){
        return description;
    }

    @JsonValue
    public String getName(){
        return description;
    }
}
