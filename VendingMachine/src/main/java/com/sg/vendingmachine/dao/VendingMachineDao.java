
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.List;


public interface VendingMachineDao {  
    //this one did contain Item item in the parameter
    Item getItemPrice(String itemCode)
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
