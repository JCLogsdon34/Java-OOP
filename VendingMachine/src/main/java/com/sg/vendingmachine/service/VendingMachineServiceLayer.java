
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;

public interface VendingMachineServiceLayer {
    
    
    
    void vendItem(Item itemCode) throws
          //  VendingMachineDuplicateIdException,
           VendingMachineDataValidationException,
            VendingMachinePersistenceException;   
 
    List<Item> getAllItems() throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException; 
 
    Item getItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException; 

    Item removeItem(String itemCode) throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException; 
            
    
}
