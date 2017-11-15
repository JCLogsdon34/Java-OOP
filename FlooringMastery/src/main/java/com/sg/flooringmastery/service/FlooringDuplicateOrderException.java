package com.sg.flooringmastery.service;

public class FlooringDuplicateOrderException extends Exception {

    public FlooringDuplicateOrderException(String message) {
        super(message);
    }

    public FlooringDuplicateOrderException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
