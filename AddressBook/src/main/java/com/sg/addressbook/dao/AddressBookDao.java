
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;


public interface AddressBookDao {
    
    AddressBook addAddress(String addressTitle, AddressBook address)
            throws AddressBookDaoException;

    List<AddressBook> getAllAddresses()
            throws AddressBookDaoException;

    AddressBook getAddress(String addressTitle)
            throws AddressBookDaoException;

    AddressBook removeAddress(String addressTitle)
            throws AddressBookDaoException;
}
