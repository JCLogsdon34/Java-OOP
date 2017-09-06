/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.addressbook.service;

import com.sg.addressbook.dao.AddressBookDaoPersistenceException;
import com.sg.addressbook.dto.AddressBook;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class AddressBookServiceLayerTest {
    
    public AddressBookServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testCreateAddress() throws Exception {
    }

    /**
     * Test of getAllAddresses method, of class AddressBookServiceLayer.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
    }

    /**
     * Test of getAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testGetAddress() throws Exception {
    }

    /**
     * Test of removeAddress method, of class AddressBookServiceLayer.
     */
    @Test
    public void testRemoveAddress() throws Exception {
    }

    public class AddressBookServiceLayerImpl implements AddressBookServiceLayer {

        public void createAddress(AddressBook address) throws AddressBookDuplicateIdException, AddressBookDataValidationException, AddressBookDaoPersistenceException {
        }

        public List<AddressBook> getAllAddresses() throws AddressBookDaoPersistenceException {
            return null;
        }

        public AddressBook getAddress(String addressTitle) throws AddressBookDaoPersistenceException {
            return null;
        }

        public AddressBook removeAddress(String addressTitle) throws AddressBookDaoPersistenceException {
            return null;
        }
    }
    
}
