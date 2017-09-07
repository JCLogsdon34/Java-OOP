/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dto.AddressBook;
import com.sg.addressbook.dao.AddressBookDaoPersistenceException;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AddressBookServiceLayer {
        void createAddress(AddressBook address) throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException;
 
    List<AddressBook> getAllAddresses() throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException;
    
    AddressBook getAddress(String addressTitle) throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException;
 
    AddressBook removeAddress(String addressTitle) throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException;
    
}
