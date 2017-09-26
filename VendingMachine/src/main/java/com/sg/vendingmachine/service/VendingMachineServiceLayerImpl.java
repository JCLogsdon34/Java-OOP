
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dto.Item;
import java.util.List;


public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    

    public VendingMachineServiceLayerImpl(VendingMachineDao dao) {
        this.dao = dao;       
    }
    
    @Override
    public void createItem(Item item){ /*{  throws
            VendingMachineDuplicateIdException,
            VendingMachineDataValidationException,
            VendingMachinePersistenceException 

        if (dao.getItem(item.getItemName()) != null) {
            throw new VendingMachineDuplicateIdException(
                    "ERROR: Could not create Dvd.  Dvd title"
                    + item.getItemName()
                    + " already exists");
        }
        validateItemData(item);
        dao.addItem(item.getItemName(), item); */
    }

    @Override
    public List<Item> getAllItems() { //throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemName) { //throws DvdLibraryPersistenceException {
        return dao.getItem(itemName);
    }

    @Override
    public Item removeDvd(String itemName) { // throws DvdLibraryPersistenceException {
        Item removedItem = dao.removeItem(itemName);
        return dao.removeDvd(itemName);
    }
}
