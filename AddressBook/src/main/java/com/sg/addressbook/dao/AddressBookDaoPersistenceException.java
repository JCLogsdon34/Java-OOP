/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoPersistenceException extends Exception {

    public AddressBookDaoPersistenceException(String message) {
        super(message);
    }

    public AddressBookDaoPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
