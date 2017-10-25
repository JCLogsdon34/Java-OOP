package com.sg.vendingmachine.ui;

public class VendingMachineInvalidItemCodeException extends Exception{
    
    public VendingMachineInvalidItemCodeException(String message) {
        super(message);
    }

    public VendingMachineInvalidItemCodeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
