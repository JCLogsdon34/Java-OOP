package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {

    //int vendItem(String itemCode) throws
    //      VendingMachineNoItemInInventoryException,
    //     VendingMachineInsufficientFundsException,
    //   VendingMachineDataValidationException,
    //    VendingMachinePersistenceException;
    
    List<Item> getAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    Item getItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;

    Map<Coins, Integer> returnChange(String itemPaid, String itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;

    int checkTheCash(BigDecimal itemPrice, BigDecimal itemPaid)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException;
}
