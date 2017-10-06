package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.io.FileNotFoundException;
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
    
    String getItemPriceByCode(String itemCode) 
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    Map<Coins, Integer> returnChange(String itemPaid, String itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;

    void checkTheCash(String itemMoney, String itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException;
}
