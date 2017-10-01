package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;

public interface VendingMachineServiceLayer {

    Item vendItem(String itemCode) throws
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;

    List<Item> getAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    Item getItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;
    
    void checkTheCash(BigDecimal itemPaid, Item currentItem, String itemCode) 
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException, 
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;
       
    void getMoneyInMachine(int itemPaid) throws
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;
}
