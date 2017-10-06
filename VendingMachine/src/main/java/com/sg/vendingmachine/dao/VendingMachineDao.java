
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.math.BigDecimal;
import java.util.List;


public interface VendingMachineDao {  


    String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException;
    
    List<Item> getAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;
    
    Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;

    Item viewItem(String itemCode)
            throws VendingMachinePersistenceException;
    
    String vendAndUpdateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException;
   
}
