/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class AddressBookDaoStubImpl implements AddressBookDao {
    
    AddressBook onlyAddress;
    
    List <AddressBook> addressList = new ArrayList<>();
    
    public void AddressBookDaoStubImpl() {
        onlyAddress = new AddressBook();
        onlyAddress.setAddressTitle("345");
        onlyAddress.setStreetName("Wilson Rd");
        onlyAddress.setOccupantFirstName("Mark");
        onlyAddress.setOccupantLastName("Smithson");
        onlyAddress.setAddressState("Missouri");
        
        addressList.add(onlyAddress);
    }

    @Override
    public AddressBook addAddress(String addressTitle, AddressBook address) throws AddressBookDaoException {
        if(addressTitle.equals(onlyAddress.getAddressTitle())){
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public List<AddressBook> getAllAddresses() throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AddressBook getAddress(String addressTitle) throws AddressBookDaoException {
        if(addressTitle.equals(onlyAddress.getAddressTitle())){
            return onlyAddress;
        } else {
            return null;
        }
    }

    @Override
    public AddressBook removeAddress(String addressTitle) throws AddressBookDaoException {
      if(addressTitle.equals(onlyAddress.getAddressTitle())){
            return onlyAddress;
        } else {
            return null;
        }
    } 
}
