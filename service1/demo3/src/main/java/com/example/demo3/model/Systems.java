package com.example.demo3.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Systems {
    ERP("ERP"),
    CRM("CRM"),
    WMS("WMS"),
    System1("System1"),
    System2("System2");

    private final String name;

    Systems(String name){
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
    @JsonCreator
    public static Systems fromValue(String string) throws IllegalArgumentException{
        for (Systems systems : values()) {
            if(systems.name.equalsIgnoreCase(string)){
                return systems;
            }
        }throw new IllegalArgumentException("Unknown System"+string);
    }
}
