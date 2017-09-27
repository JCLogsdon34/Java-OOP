
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;

public interface VendingMachineServiceLayer {
    
    void createItem(Item item) throws
          //  VendingMachineDuplicateIdException,
           VendingMachineDataValidationException,
            VendingMachinePersistenceException; 
 
    List<Item> getAllItems() throws
            VendingMachinePersistenceException; 
 
    Item getItem(String itemName) throws
            VendingMachinePersistenceException; 

    Item removeItem(String itemName) throws
            VendingMachinePersistenceException; 
            
    
}
