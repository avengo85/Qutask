package com.herokuapp.framework;

public class UnknownPropertyException extends RuntimeException {
    public UnknownPropertyException(String message) {
        super(message);
    }
}
