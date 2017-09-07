/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.dao;

import com.sg.addressbook.dto.AddressBook;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AddressBookDaoTest {
    
    
    private AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        List<AddressBook> addressList = dao.getAllAddresses();
        for(AddressBook address : addressList){
            dao.removeAddress(address.getAddressTitle());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void AddGetAddress() throws Exception {
        AddressBook address = new AddressBook();
        address.setAddressTitle("555");
        address.setStreetName("Lava Way West");
        address.setOccupantFirstName("Chris");
        address.setOccupantLastName("Logsdon");
        address.setAddressState("Indiana");
        
        dao.addAddress(address.getAddressTitle(), address); 
        
        AddressBook fromDao = dao.getAddress(address.getAddressTitle());
        
        assertEquals(address, fromDao);
    }
    
    @Test
    public void testAddAddress() throws Exception {
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
        AddressBook address1 = new AddressBook();
        address1.setAddressTitle("555");
        address1.setStreetName("Lava Way West");
        address1.setOccupantFirstName("Chris");
        address1.setOccupantLastName("Logsdon");
        address1.setAddressState("Indiana");
        
        dao.addAddress(address1.getAddressTitle(), address1); 
        
        AddressBook address2 = new AddressBook();
        address2.setAddressTitle("1060");
        address2.setStreetName("West Addison");
        address2.setOccupantFirstName("Wrigley");
        address2.setOccupantLastName("Field");
        address2.setAddressState("Illinois");
        
        dao.addAddress(address2.getAddressTitle(), address2);
        assertEquals(2, dao.getAllAddresses().size());
    }

    /**
     * Test of getAddress method, of class AddressBookDao.
     */
    @Test
    public void testGetAddress() throws Exception {
    }

    /**
     * Test of removeAddress method, of class AddressBookDao.
     */
    @Test
    public void testRemoveAddress() throws Exception {
        AddressBook address1 = new AddressBook();
        address1.setAddressTitle("555");
        address1.setStreetName("Lava Way West");
        address1.setOccupantFirstName("Chris");
        address1.setOccupantLastName("Logsdon");
        address1.setAddressState("Indiana");
        
        dao.addAddress(address1.getAddressTitle(), address1); 
        
        AddressBook address2 = new AddressBook();
        address2.setAddressTitle("1060");
        address2.setStreetName("West Addison");
        address2.setOccupantFirstName("Wrigley");
        address2.setOccupantLastName("Field");
        address2.setAddressState("Illinois");
        
        dao.addAddress(address2.getAddressTitle(), address2);
        
        dao.removeAddress(address1.getAddressTitle());
        assertEquals(1, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address1.getAddressTitle()));
        
        dao.removeAddress(address2.getAddressTitle());
        assertEquals(0, dao.getAllAddresses().size());
        assertNull(dao.getAddress(address2.getAddressTitle()));
    }
}
