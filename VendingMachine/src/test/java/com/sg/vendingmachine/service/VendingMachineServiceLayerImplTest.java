package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

        BigDecimal itemPayment = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);
        String itemCode = "W63";

        BigDecimal itemPrice = dao.getItemPriceByCode(itemCode).setScale(2, RoundingMode.HALF_UP);

        assertEquals(itemPayment, itemPrice);
    }

    @Test
    public void testNotEnoughCash() throws
            VendingMachineDataValidationException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        BigDecimal userRefund = BigDecimal.ZERO;
        String itemCode = "W63";
        String paid = "2.05";
        String price = "3.05";
        BigDecimal userPayment = new BigDecimal(paid);
        BigDecimal userPrice = new BigDecimal(price);
        Item item = new Item(itemCode);

        try {
            userRefund = service.checkTheCash(userPrice, userPayment);
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
        
        BigDecimal money = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal price = new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP);

        List<String> cashMoney = new ArrayList<>();
        cashMoney = service.returnChange(money, price);
        
        BigDecimal money1 = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal price1 = new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP);
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


        BigDecimal itemPrice = new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemPaid = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemPrice1 = new BigDecimal(1.25).setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemPaid1 = new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemRefund = BigDecimal.ZERO;
        BigDecimal itemRefund1 = BigDecimal.ZERO;
        List<String> cashRefund = new ArrayList<>();

        itemRefund = service.checkTheCash(itemPrice, itemPaid);
        cashRefund = service.returnChange(itemPrice, itemPaid);

        List<String> cashRefund1 = new ArrayList<>();
        itemRefund1 = service.checkTheCash(itemPrice1, itemPaid1);
        cashRefund1 = service.returnChange(itemPrice1, itemPaid1);

        assertEquals(itemRefund, itemRefund1);
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
        String price = "3.05";
        BigDecimal itemPriceExpected = new BigDecimal(price);
        String itemCode = "W63";

        assertEquals(itemPriceExpected, service.getItemPriceByCode(itemCode));
    }
}
