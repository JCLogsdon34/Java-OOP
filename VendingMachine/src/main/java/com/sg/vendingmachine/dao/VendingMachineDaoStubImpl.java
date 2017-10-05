
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.ArrayList;
import java.util.List;


public class VendingMachineDaoStubImpl implements VendingMachineDao {
    
    Item onlyItem;
    List <Item> itemList = new ArrayList<>();
    
    public VendingMachineDaoStubImpl() {
        onlyItem = new Item();
        onlyItem.setItemCode("Chef's");
        onlyItem.setItemName("R22");
        onlyItem.setItemPrice("2.00");
        
        itemList.add(onlyItem);
    }


    public Item additem(String itemCode, Item onlyItem)
            throws VendingMachineDaoException {
        if(itemCode.equals(onlyItem.getItemCode())){
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() 
            throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException {

        if(itemCode.equals(onlyItem.getItemCode())){
            return onlyItem;
        } else {
            return null;
        }
    }


    public Item removeItem(String itemCode) 
             throws VendingMachinePersistenceException {
      if(itemCode.equals(onlyItem.getItemCode())){
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public String getItemPrice(String itemCode) throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item viewItem(String itemCode) throws VendingMachinePersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vendAndUpdateItem(String itemCode, Item currentItem) throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineNoItemInInventoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    



