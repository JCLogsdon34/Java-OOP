
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.util.List;


public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;       
        
    }
    
    @Override
    public void createItem(Item item)  throws           
            VendingMachineDataValidationException,
            VendingMachinePersistenceException {

      /*  if (dao.getItem(item.getItemName()) != null) {
            throw new VendingMachineDuplicateIdException(
                    "ERROR: Could not create Dvd.  Dvd title"
                    + item.getItemName()
                    + " already exists");
        } */
 //       validateItemData(item);
   //     dao.addItem(item.getItemName(), item); 
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemName) throws VendingMachinePersistenceException {
        return dao.getItem(itemName);
    }

    @Override
    public Item removeItem(String itemName) throws VendingMachinePersistenceException {
        Item removedItem = dao.removeItem(itemName);
        return dao.removeItem(itemName);
    }
    
      private void validateItenData(Item item) throws
            VendingMachineDataValidationException {

       /* if (item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getItemPrice() == null
                || item.getItemPrice().trim().length() == 0
                || item.getItemInventory() == null
                || item.getItemInventory().trim().length() == 0
                || item.getItemCode() == null
                || item.getItemCode().trim().length() == 0) {   */

            throw new VendingMachineDataValidationException(
                    "");
        }
    }

