package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VendingMachineServiceLayerImplTest {

    VendingMachineDao dao = new VendingMachineDaoStubImpl();
    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
    VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, auditDao);
    Change change;
            
    public VendingMachineServiceLayerImplTest() {

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

    @Test
    public void testCheckTheCash() throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        String userPayment = "3.05";
        String itemCode = "W63";

        String itemPrice = service.getItemPriceByCode(itemCode);

        BigDecimal userPaid = new BigDecimal(userPayment);
        BigDecimal itemWorth = new BigDecimal(itemPrice);

        assertEquals(userPaid, itemWorth);
    }

    @Test
    public void testNotEnoughCash() throws
            VendingMachineDataValidationException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        String userPayment = ("2.05");
        String itemCode1 = "W63";
        String itemPrice1;
        BigDecimal userRefund;

        itemPrice1 = service.getItemPriceByCode(itemCode1);

        try {
            userRefund = service.checkTheCash(userPayment, itemPrice1);
            fail("expected VendingMachineInsufficientFundsException was not thrown");
        } catch (VendingMachineInsufficientFundsException e) {
        }
    }
/*
    @Test
    public void TestGetCoinWorth() {

        BigDecimal itemRefund = null;
        BigDecimal
        Map<Coins, Integer> cashMoney = new HashMap<>();
        

        cashMoney = change.getCoinWorth(itemRefund);
        
        assertEquals();
    }
*/
    @Test
    public void testReturnChange() throws
            VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        BigDecimal itemRefund;
        BigDecimal itemRefund1;
        String itemPrice = "1.25";
        String itemPaid = "1.50";
        String itemPrice1 = "1.05";
        String itemPaid1 = "1.30";

        Map<Coins, Integer> cashRefund = new HashMap<>();
        Map<Coins, Integer> cashRefund1 = new HashMap<>();

        itemRefund = service.checkTheCash(itemPrice, itemPaid);
        cashRefund = service.returnChange(itemRefund);

        itemRefund1 = service.checkTheCash(itemPrice1, itemPaid1);
        cashRefund1 = service.returnChange(itemRefund1);

        assertEquals(cashRefund, cashRefund1);
    }

    @Test
    public void testGetAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        assertEquals(5, service.getAllItems().size());
    }

    @Test
    public void testGetItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "W63";
        Item item = new Item(itemCode);

        item = service.getItem(itemCode);

        assertNotNull(item);
    }

    @Test
    public void testGetItemNothing() throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {
        String itemCode1 = "JJ2";
        Item item = new Item(itemCode1);

        try {
            item = service.getItem(itemCode1);
            fail("Bad item code did not cause VendingMachineDataValidationException"
                    + "to be thrown");
        } catch (VendingMachineDataValidationException e) {
        }

    }

    @Test
    public void testGetItemPriceByCode() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        String itemPrice;
        String itemPriceExpected = "3.05";
        String itemCode = "G93";

        itemPrice = service.getItemPriceByCode(itemCode);

        assertEquals(itemPrice, itemPriceExpected);
    }
}
