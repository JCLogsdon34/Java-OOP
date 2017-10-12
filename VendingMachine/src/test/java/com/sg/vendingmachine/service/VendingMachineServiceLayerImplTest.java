package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineServiceLayerImplTest {
    
    private VendingMachineDao dao = new VendingMachineDaoStubImpl();
    private VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
    private VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, auditDao);

    public VendingMachineServiceLayerImplTest() {
     //  service = new VendingMachineServiceLayerImpl(dao, auditDao);
    }
    

    
    @BeforeClass
    public static void setUpClass() {
    /*  Item onlyItem;
        List<Item> itemList = new ArrayList<>();
        onlyItem = new Item("W63");
        onlyItem.setItemName("Samuel L. Jackson");
        onlyItem.setItemPrice("3.05");
        onlyItem.setItemInventory("5");

        itemList.add(onlyItem);
      */
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

    @Test
    public void testCheckTheCash() throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        String userPayment = "3.05";
        String itemCode = "W63";

        String itemPrice = dao.getItemPriceByCode(itemCode);

        BigDecimal userPaid = new BigDecimal(userPayment);
        BigDecimal itemWorth = new BigDecimal(itemPrice);

        assertEquals(userPaid, itemWorth);
    }

    @Test
    public void testNotEnoughCash() throws
            VendingMachineDataValidationException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        String userPayment = "2.05";
        String itemPrice1 = "3.05";
        int userRefund;

        try {
            //throws
            //but throws NFE now
            userRefund = service.checkTheCash(userPayment, itemPrice1);
            fail("expected VendingMachineInsufficientFundsException was not thrown");
        } catch (VendingMachineInsufficientFundsException e) {
            return;
        }
    }

    @Test
    public void TestGetCoinWorth() throws
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException {

        int itemRefund = (int) 1.50;
        List <String> cashMoney = new ArrayList<>(itemRefund);
// out of memory java heap space
        cashMoney = service.returnChange(itemRefund);

        int itemRefund1 = (int) 1.50;
        List <String> cashMoney1 = new ArrayList<>(itemRefund1);

        cashMoney1 = service.returnChange(itemRefund1);

        assertTrue(cashMoney.equals(cashMoney1));
        //assertEquals(cashMoney, cashMoney1);
        //assertTrue(Maps.difference(cashMoney, cashMoney1).areEqual());
    }

    @Test
    public void testReturnChange() throws
            VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        int itemRefund;
        int itemRefund1;
        String itemPrice = "1.25";
        String itemPaid = "1.50";
        String itemPrice1 = "1.05";
        String itemPaid1 = "1.30";

        List<String> cashRefund = new ArrayList<>();

/// NFE throws
        itemRefund = service.checkTheCash(itemPrice, itemPaid);
        cashRefund = service.returnChange(itemRefund);

        List <String> cashRefund1 = new ArrayList<>();
        itemRefund1 = service.checkTheCash(itemPrice1, itemPaid1);
        cashRefund1 = service.returnChange(itemRefund1);

        assertEquals(cashRefund, cashRefund1);
    }

    @Test
    public void testGetAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        assertEquals(1, service.getAllItems().size());
    }

    @Test
    public void testGetItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "L31";
        String expectedInventory = "5";
        Item item = new Item(itemCode);

        item = service.getItem(itemCode);
        //this was a straight fail, Inventory was 5//checked
        ///now this throws NPE
        assertEquals(expectedInventory, service.getItem(itemCode).itemInventory);
    }

    @Test
    public void testGetItemNothing() throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {
        String itemCode1 = "JJF2";

        try {
            //no throws\
            //catch this exception in the service layer
            //still not throwing
            Item item = service.getItem(itemCode1);
            fail("Bad item code did not cause VendingMachineDataValidationException"
                    + "to be thrown");
        } catch (VendingMachineDataValidationException e) {
            return;
        }
    }

    @Test
    public void testGetItemPriceByCode() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        String itemPriceExpected = "3.05";
        String itemCode = "W63";

//checked NPE again
        assertEquals(itemPriceExpected, service.getItemPriceByCode(itemCode));
    }
}
