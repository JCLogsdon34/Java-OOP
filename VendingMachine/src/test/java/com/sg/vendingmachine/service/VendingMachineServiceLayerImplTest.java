package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
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
    private VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
    private VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, auditDao);

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
        BigDecimal userRefund = new BigDecimal(userPayment);
        String itemCode = "W63";
        BigDecimal userPaymentBig = new BigDecimal(userPayment);
        BigDecimal userPriceBig = new BigDecimal(itemPrice1);
        Item item = new Item(itemCode);

        try {
            userRefund = service.checkTheCash(userPaymentBig, userPriceBig);
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
        
        String money = "1.50";
        String price = "1.25";
        BigDecimal itemRefund = new BigDecimal(money);

        List<String> cashMoney = new ArrayList<>();
        cashMoney = service.returnChange(money, price);
        
        String money1 = "1.50";
        String price1 = "1.25";
        BigDecimal itemRefund1 = new BigDecimal(money1);
        List<String> cashMoney1 = new ArrayList<>();

        cashMoney1 = service.returnChange(money1, price1);

        assertTrue(cashMoney.equals(cashMoney1));

    }

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
        BigDecimal userPaymentBig = new BigDecimal(itemPaid);
        BigDecimal userPriceBig = new BigDecimal(itemPrice);
        String itemPrice1 = "1.25";
        String itemPaid1 = "1.50";
        BigDecimal userPaymentBig1 = new BigDecimal(itemPaid1);
        BigDecimal userPriceBig1 = new BigDecimal(itemPrice1);

        List<String> cashRefund = new ArrayList<>();

        itemRefund = service.checkTheCash(userPriceBig, userPaymentBig);
        cashRefund = service.returnChange(itemPrice, itemPaid);

        List<String> cashRefund1 = new ArrayList<>();
        itemRefund1 = service.checkTheCash(userPriceBig1, userPaymentBig1);
        cashRefund1 = service.returnChange(itemPrice, itemPaid);

        assertEquals(cashRefund, cashRefund1);
    }

    @Test
    public void testGetAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        assertEquals(2, service.getAllItems().size());
    }

    @Test
    public void testGetItem() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemCode = "W63";
        String itemCode1 = "W63";
        String expectedInventory = "5";

        Item item = service.getItem(itemCode1);
        Item item2 = service.getItem(itemCode1);

        assertEquals(item, item2);
    }

    @Test
    public void testGetItemNothing() throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {
        String itemCode1 = "JJF2";
        Item item = new Item(itemCode1);

        try {
            item = service.getItem(itemCode1);
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

        assertEquals(itemPriceExpected, service.getItemPriceByCode(itemCode));
    }
}
