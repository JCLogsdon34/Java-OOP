
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;


public interface VendingMachineDao {  
    Item addItem(String itemCode, Item item)
            throws  VendingMachinePersistenceException;
    
    List<Item> getAllItems()
            throws VendingMachinePersistenceException;
    
    Item getItem(String itemCode)
            throws VendingMachinePersistenceException;

    Item viewItem(String itemCode)
            throws VendingMachinePersistenceException;
    
    Item updateItem(String itemName)
            throws VendingMachinePersistenceException;
}
