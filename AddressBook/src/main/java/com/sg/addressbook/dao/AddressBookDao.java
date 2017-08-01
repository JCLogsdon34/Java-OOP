
package com.sg.addressbook.dao;

import java.util.List;


public interface AddressBookDao {
    
    Address addAddress(String addressTitle, Address address)
            throws AddressBookDaoException;

    List<Address> getAllAddresses()
            throws AddressBookDaoException;

    Address getAddress(String addressTitle)
            throws AddressBookDaoException;

    Address removeAddress(String addressTitle)
            throws AddressBookDaoException;
}
