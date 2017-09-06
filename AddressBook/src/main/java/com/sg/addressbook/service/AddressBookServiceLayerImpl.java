/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookAuditDao;
import com.sg.addressbook.dao.AddressBookDao;
import com.sg.addressbook.dao.AddressBookDaoException;
import com.sg.addressbook.dao.AddressBookDaoPersistenceException;
import com.sg.addressbook.dto.AddressBook;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apprentice
 */
public class AddressBookServiceLayerImpl implements
        AddressBookServiceLayer {

    AddressBookDao dao;
    private AddressBookAuditDao auditDao;

    public AddressBookServiceLayerImpl(AddressBookDao dao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createAddress(AddressBook address) throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException {

        try {
            if (dao.getAddress(address.getAddressTitle()) != null) {
                throw new AddressBookDuplicateIdException(
                        "ERROR: Could not create Address.  That address"
                                + address.getAddressTitle()
                                + " already exists");
            } else {
                validateAddressData(address);
                try {
                    dao.addAddress(address.getAddressTitle(), address);
                } catch (AddressBookDaoException ex) {                  
                }
                
                auditDao.writeAuditEntry(
                        "Address " + address.getAddressTitle() + " CREATED.");
            }
        } catch (AddressBookDaoException e) {
           
        }
    }

    @Override
    public List<AddressBook> getAllAddresses() throws
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException{
            return dao.getAllAddresses();
    }

    @Override
    public AddressBook getAddress(String addressTitle) throws 
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException {
        return dao.getAddress(addressTitle);
    }

    @Override
    public AddressBook removeAddress(String addressTitle) throws 
            AddressBookDuplicateIdException,
            AddressBookDataValidationException,
            AddressBookDaoPersistenceException,
            AddressBookDaoException {
        AddressBook removedAddress = dao.removeAddress(addressTitle);

    auditDao.writeAuditEntry("Address " + addressTitle+ " REMOVED.");
        return dao.removeAddress(addressTitle);
    }

    private void validateAddressData(AddressBook address) throws
            AddressBookDataValidationException {

        if (address.getAddressTitle() == null
                || address.getAddressTitle().trim().length() == 0
                || address.getStreetName() == null
                || address.getStreetName().trim().length() == 0
                || address.getOccupantFirstName() == null
                || address.getOccupantFirstName().trim().length() == 0
                || address.getOccupantLastName() == null
                || address.getOccupantLastName().trim().length() == 0
                || address.getAddressState() == null
                || address.getAddressState().trim().length() == 0) {

            throw new AddressBookDataValidationException(
                    "ERROR: All fields [House Number"
                    + " Street Name, First Name, Last Name, and State are required.");
        }
    }
}
