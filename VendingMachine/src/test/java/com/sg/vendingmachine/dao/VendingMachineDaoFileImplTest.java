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
            throws VendingMachinePersistenceException {

        String itemCode = "L31";
        String expectedResult = "1.25";

        assertEquals(expectedResult, dao.getItemPriceByCode(itemCode));
    }

    @Test
    public void testGetAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        assertEquals(5, dao.getAllItems().size());
    }

    @Test
    public void testGetItem()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        String itemCode = "V61";
        Item item = new Item(itemCode);
        item = dao.getItem(itemCode);

        assertEquals(item.itemInventory, dao.getItem(itemCode).itemInventory);
    }

    @Test
    public void testViewItem() throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "V61";
        String itemName = "Dr.Enuf";

        assertEquals(itemName, dao.viewItem(itemCode).getItemName());
    }

    @Test
    public void testVendAndUpdateItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        String itemCode1 = "R45";
        String itemCode2 = "V61";

        Item newItem = new Item(itemCode1);

        newItem = dao.getItem(itemCode1);

        assertEquals(4, dao.vendAndUpdateItem(itemCode1, newItem));
    }
}
/*
Ale-8-1::1.25::R45::5
Cheer-Wine::1.25::L31::5
Coca-Cola::1.00::H29::5
Double-Cola::1.25::G93::5
Dr.Enuf::1.25::V61::5
 */
