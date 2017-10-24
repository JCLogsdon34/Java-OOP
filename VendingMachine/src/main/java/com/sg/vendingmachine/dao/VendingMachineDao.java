
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.math.BigDecimal;
import java.util.List;


public interface VendingMachineDao {  


    BigDecimal getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException;
    
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException;

    Item viewItem(String itemCode)
            throws VendingMachinePersistenceException;
    
    int vendAndUpdateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException;
   
}
