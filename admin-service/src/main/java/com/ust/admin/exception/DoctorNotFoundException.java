package com.ust.admin.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String s) {
        super(s);
    }
}
