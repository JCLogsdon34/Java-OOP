
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import java.util.List;

public interface VendingMachineServiceLayer {
    
    void createItem(Item item); /*throws
            DvdLibraryDuplicateIdException,
            DvdLibraryDataValidationException,
            DvdLibraryPersistenceException; */
 
    List<Item> getAllItems(); /*throws
            DvdLibraryPersistenceException; */
 
    Item getItem(String itemName); /*throws
            DvdLibraryPersistenceException; */
 
    Item removeItem(String itemName); /* throws
            DvdLibraryPersistenceException; */
            
    
}
