package com.example.springannotations.exception;

public class StudentNotFound extends Throwable {
    public StudentNotFound(String s) {
        super(s);
    }
}
