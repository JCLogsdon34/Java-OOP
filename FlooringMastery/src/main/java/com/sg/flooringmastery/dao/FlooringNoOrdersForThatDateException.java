
package com.sg.flooringmastery.dao;


public class FlooringNoOrdersForThatDateException extends Exception{

    public FlooringNoOrdersForThatDateException(String message) {
        super(message);
    }

    public FlooringNoOrdersForThatDateException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
