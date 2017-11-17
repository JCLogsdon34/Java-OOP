
package com.sg.flooringmastery.dao;


public class FlooringOrdersForThatDateException extends Exception{

    public FlooringOrdersForThatDateException(String message) {
        super(message);
    }

    public FlooringOrdersForThatDateException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
