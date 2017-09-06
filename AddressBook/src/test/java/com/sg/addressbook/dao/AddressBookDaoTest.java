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
    
    public AddressBookDaoTest() {
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
     * Test of addAddress method, of class AddressBookDao.
     */
    @Test
    public void testAddAddress() throws Exception {
    }

    /**
     * Test of getAllAddresses method, of class AddressBookDao.
     */
    @Test
    public void testGetAllAddresses() throws Exception {
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
    }

    public class AddressBookDaoImpl implements AddressBookDao {

        public AddressBook addAddress(String addressTitle, AddressBook address) throws AddressBookDaoException {
            return null;
        }

        public List<AddressBook> getAllAddresses() throws AddressBookDaoException {
            return null;
        }

        public AddressBook getAddress(String addressTitle) throws AddressBookDaoException {
            return null;
        }

        public AddressBook removeAddress(String addressTitle) throws AddressBookDaoException {
            return null;
        }
    }
    
}
