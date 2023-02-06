package com.prosoft;

public class DivByZeroException extends Exception {
    public DivByZeroException() {

    }

    public DivByZeroException(String message) {
        super(message);
    }
}
