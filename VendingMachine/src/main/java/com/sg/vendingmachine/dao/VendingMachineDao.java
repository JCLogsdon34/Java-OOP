
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.List;


public interface VendingMachineDao {  
    //this one did contain Item item in the parameter
    String getItemPrice(String itemCode)
            throws  VendingMachinePersistenceException;
    
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItem(String itemCode)
            throws VendingMachinePersistenceException;

    Item viewItem(String itemCode)
            throws VendingMachinePersistenceException;
    
    void updateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;
   
}
