/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineDaoFileImplTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoFileImplTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Item> itemList = dao.getAllItems();
        for (Item currentItem : itemList) {
            dao.getItem(currentItem.getItemCode());
        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetItemPrice()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDaoException{

     String itemCode = "L31";
   //String testPrice;
     String expectedResult = "1.25"; 
   //Item currentItem = new Item();
     
    // currentItem = dao.getItem(itemCode);
       
    // testPrice = dao.getItemPrice(itemCode);
     
        assertEquals(expectedResult, dao.getItemPrice(itemCode));
    }

    @Test
    public void testGetAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException{
     
        assertEquals(5, dao.getAllItems().size());
    }

    @Test
    public void testGetItem() 
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException
            {
        String itemCode = "V61";
        Item primoItem = new Item();
    //    String itemName = "Dr.Enuf";
        primoItem = dao.getItem(itemCode);

        assertEquals(primoItem, dao.getItem(itemCode));

    }
  
    @Test
    public void testViewItem() throws VendingMachinePersistenceException, 
            VendingMachineDataValidationException, 
            VendingMachineNoItemInInventoryException {
       // String itemCode = "V61";
       Item newItem = dao.getItem("V61");
        
        assertEquals(newItem, dao.viewItem("V61"));
    }

    @Test
    public void testVendAndUpdateItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException{
        
        String itemCode1 = "R45";
        String itemCode2 = "V61";
        String itemInventory1 = null;
        String itemInventory2 = null;
        String expectedResult = "4";
        Item newItem = new Item();
        Item primoItem = new Item();

        newItem = dao.getItem(itemCode1);
        dao.vendAndUpdateItem(itemCode1, newItem);
        itemInventory1 = dao.getItem(itemCode1).getItemInventory();
        int itemInventoryI = Integer.parseInt(itemInventory1);
        
        primoItem = dao.getItem(itemCode2);
        dao.vendAndUpdateItem(itemCode2, primoItem);
        itemInventory2 = dao.getItem(itemCode2).getItemInventory();
        int itemInventoryII = Integer.parseInt(itemInventory2);

        assertEquals(itemInventoryI, itemInventoryII);
    }
}
