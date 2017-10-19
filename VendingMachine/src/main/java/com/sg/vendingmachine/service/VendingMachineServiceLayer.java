package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {

    String vendItem(String itemCode) throws
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;

    List<Item> getAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;

    Item getItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;
    
    BigDecimal getItemPriceByCode(String itemCode) 
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    List<String> returnChange(BigDecimal itemMoney, BigDecimal itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;

    BigDecimal checkTheCash(BigDecimal itemMoneyBig, BigDecimal itemPriceBig)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException;
}
