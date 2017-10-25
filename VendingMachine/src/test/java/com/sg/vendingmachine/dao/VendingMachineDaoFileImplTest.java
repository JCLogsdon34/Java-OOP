package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineDaoFileImplTest {

    private VendingMachineDao dao = new VendingMachineDaoStubImpl();

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
            throws VendingMachinePersistenceException, 
            VendingMachineDataValidationException {
        String itemCode = "W63";
        String price = "3.05";
        BigDecimal expectedResult = new BigDecimal(price);
        assertEquals(expectedResult, dao.getItemPriceByCode(itemCode));
    }

    @Test
    public void testGetAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        assertEquals(2, dao.getAllItems().size());
    }

    @Test
    public void testGetItem()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "W63";
        Item item = new Item(itemCode);
        item = dao.getItem(itemCode);
        assertEquals(item.itemInventory, dao.getItem(itemCode).itemInventory);
    }
    
    @Test
    public void testGetItemNothingHere()
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDataValidationException {
        String itemCode = "W64"; 
        int myInt;
        try{
        myInt = dao.vendAndUpdateItem(itemCode, dao.getItem(itemCode));
        fail("No item in the inventory did not throw");
        }catch(VendingMachineNoItemInInventoryException e){
            return;
        }       
    }

    @Test
    public void testViewItem() throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "W63";
        String itemName = "Samuel L. Jackson";
        assertEquals(itemName, dao.viewItem(itemCode).getItemName());
    }

    @Test
    public void testVendAndUpdateItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode1 = "W63";
        Item newItem = new Item(itemCode1);
        newItem = dao.getItem(itemCode1);
        assertEquals(4, dao.vendAndUpdateItem(itemCode1, newItem));
    }
}