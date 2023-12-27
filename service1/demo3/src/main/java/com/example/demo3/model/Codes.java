package com.example.demo3.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Codes {
    SUCCESS("success"),
    FAILED("failed");
    public final String name;
    Codes(String name){
        this.name=name;
    }
    @JsonValue
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
