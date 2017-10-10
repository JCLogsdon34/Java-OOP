package com.sg.vendingmachine.service;

public class VendingMachineNoItemInInventoryException extends Exception {

    public VendingMachineNoItemInInventoryException(String message) {
        super(message);
    }

    public VendingMachineNoItemInInventoryException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
