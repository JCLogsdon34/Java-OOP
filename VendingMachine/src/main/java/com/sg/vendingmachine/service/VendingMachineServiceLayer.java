package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface VendingMachineServiceLayer {

    int vendItem(String itemCode) throws
            VendingMachineNoItemInInventoryException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException;

    List<Item> getAllItems() throws
            VendingMachinePersistenceException;

    Item getItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException;
    
    BigDecimal getItemPriceByCode(String itemCode);

    List<String> returnChange(BigDecimal itemMoney, BigDecimal itemPrice)
            throws VendingMachineInsufficientFundsException;

    BigDecimal checkTheCash(BigDecimal itemMoneyBig, BigDecimal itemPriceBig)
            throws VendingMachineInsufficientFundsException;
}
