
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.List;


public interface VendingMachineDao {  
    
    Item getItemPrice(String itemCode, Item item)
            throws  VendingMachinePersistenceException;
    
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItem(String itemCode)
            throws VendingMachinePersistenceException;

    Item viewItem(String itemCode)
            throws VendingMachinePersistenceException;
    
    Item updateItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException;
   
}
