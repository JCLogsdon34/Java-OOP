
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoStubImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class VendingMachineServiceLayerImplTest {
    
    private VendingMachineServiceLayer service;
    private Change change;
    
    
    public VendingMachineServiceLayerImplTest() {
        
      VendingMachineDao dao = new VendingMachineDaoStubImpl();
        
  //     service = new VendingMachineServiceLayerImpl(dao);
       
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
        
        String userPayment = "1.25";
        String itemCode = "L31";
        String itemPrice;
        Item item = new Item(itemCode);
        
        itemPrice = service.getItemPriceByCode(itemCode);
        
        BigDecimal userPaid = new BigDecimal(userPayment);
        BigDecimal itemWorth = new BigDecimal(itemPrice);
        
        assertEquals(userPaid, itemWorth);
    }
    
    @Test
    public void testNotEnoughCash() throws 
            VendingMachineDataValidationException, 
            VendingMachinePersistenceException{
        
        String userPayment1 = "1.05";
        String itemCode1 = "G93";
        String itemPrice1;
        Item item1 = new Item(itemCode1);
        BigDecimal userRefund;
        
        Map<Coins, Integer> changeRefund = new HashMap<>();
        itemPrice1 = service.getItemPriceByCode(itemCode1);
        
        BigDecimal userPaid1 = new BigDecimal(userPayment1);
        BigDecimal itemWorth1 = new BigDecimal(itemPrice1);
        userRefund = change.getCashInfo(userPayment1, itemPrice1);
         
        
        userRefund = change.getCashInfo(userPayment1, itemPrice1);
        changeRefund = change.getCoinWorth(userRefund);
        fail("expected VendingMachineInsufficientFundsException was not thrown");
        
        assertEquals(userPaid1, itemWorth1);
        
    }

 
    @Test
    public void testReturnChange() throws 
            VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException  {
       
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
            VendingMachineNoItemInInventoryException  {
        String itemCode = "L31";
        Item item = new Item(itemCode);

        assertNotNull(item);
        
        item = service.getItem("H34");
        assertNull(item);
       
    }


    @Test
    public void testGetItemPriceByCode() throws 
            VendingMachinePersistenceException, 
            VendingMachineDataValidationException {
        
    }
    
}
