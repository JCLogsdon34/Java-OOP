
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import java.util.List;


public interface VendingMachineDao {
    
    Item addItem(String itemName, Item item)
            throws VendingMachineDaoException,
            VendingMachinePersistenceException;
    
    List<Item> getAllItems()
            throws VendingMachineDaoException,
            VendingMachinePersistenceException;
    
    Item getItem(String itemName)
            throws VendingMachineDaoException,
            VendingMachinePersistenceException;

    Item removeItem(String itemName)
            throws VendingMachineDaoException,
            VendingMachinePersistenceException;

}
