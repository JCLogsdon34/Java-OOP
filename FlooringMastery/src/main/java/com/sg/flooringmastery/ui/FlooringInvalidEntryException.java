
package com.sg.flooringmastery.ui;

import java.util.InputMismatchException;


public class FlooringInvalidEntryException extends InputMismatchException {


    public FlooringInvalidEntryException(String message) {
        super(message);
    }

    public FlooringInvalidEntryException(String message, Throwable cause) {
        super(message);
    }
}
