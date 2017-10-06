
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
    public void testGetItemPriceByCode()
            throws VendingMachinePersistenceException{

     String itemCode = "L31";
   //String testPrice;
     String expectedResult = "1.25"; 
   //Item currentItem = new Item();
     
    // currentItem = dao.getItem(itemCode);
       
    // testPrice = dao.getItemPrice(itemCode);
     
        assertEquals(expectedResult, dao.getItemPriceByCode(itemCode));
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
        String itemInventory1;
        int itemInventoryI;
      //String itemInventory2 = null;
      //String expectedResult = "4";
        Item newItem = new Item();
      //Item primoItem = new Item();

        newItem = dao.getItem(itemCode1);
      
        assertEquals(4, dao.vendAndUpdateItem(itemCode1, newItem));
        /*
        primoItem = dao.getItem(itemCode2);
        dao.vendAndUpdateItem(itemCode2, primoItem);
        itemInventory2 = dao.getItem(itemCode2).getItemInventory();
        int itemInventoryII = Integer.parseInt(itemInventory2);
        */
     //   assertEquals(4, Integer.parseInt(itemInventory1));
    }
}
/*
Ale-8-1::1.25::R45::5
Cheer-Wine::1.25::L31::5
Coca-Cola::1.00::H29::5
Double-Cola::1.25::G93::5
Dr.Enuf::1.25::V61::5
*/
