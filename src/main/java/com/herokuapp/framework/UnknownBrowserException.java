package com.herokuapp.framework;

public class UnknownBrowserException extends RuntimeException {
    public UnknownBrowserException(String message) {
        super(message);
    }
}
