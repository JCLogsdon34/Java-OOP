/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

/**
 *
 * @author apprentice
 */
public class AddressBookDataValidationException extends Exception {
    
    public AddressBookDataValidationException(String message) {
        super(message);
    }

    public AddressBookDataValidationException(String message,
            Throwable cause) {
        super(message, cause);
    }
}
    

