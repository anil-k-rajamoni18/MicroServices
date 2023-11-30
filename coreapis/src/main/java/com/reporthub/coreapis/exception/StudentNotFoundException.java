package com.reporthub.coreapis.exception;

public class StudentNotFoundException extends RuntimeException{
    private String name;
    public StudentNotFoundException(String name){
        this.name = name;
    }
}
