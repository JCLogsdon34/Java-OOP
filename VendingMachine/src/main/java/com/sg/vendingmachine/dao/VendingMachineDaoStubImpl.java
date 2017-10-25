package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    Item secondOnlyItem;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        BigDecimal itemPrice = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);
        onlyItem = new Item("W63");
        onlyItem.setItemName("Samuel L. Jackson");
        onlyItem.setItemPrice(itemPrice);
        onlyItem.setItemInventory(5);
        
        itemList.add(onlyItem);
        BigDecimal itemPrice1 = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);
        secondOnlyItem = new Item("W64");
        secondOnlyItem.setItemName("Samuel L. Jackson Ale");
        secondOnlyItem.setItemPrice(itemPrice1);
        secondOnlyItem.setItemInventory(0);
        itemList.add(secondOnlyItem);
    }

    @Override
    public Item getItem(String itemCode)
            throws 
            VendingMachineDataValidationException {
        if (itemCode.equals(onlyItem.getItemCode())) {
            return onlyItem;
        } else if (itemCode.equals(secondOnlyItem.getItemCode())){
            return secondOnlyItem;
        }else{
            throw new VendingMachineDataValidationException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is an invalid code");
        }
    }

    @Override
    public int vendAndUpdateItem(String itemCode, Item item)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {
        int itemInventory;
        int itemParsedUpdate;

             
        try {
            item = getItem(itemCode);
        } catch (VendingMachineDataValidationException e) {
            Logger.getLogger(VendingMachineDaoStubImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (itemCode.equals(onlyItem.getItemCode())) {
                item = onlyItem;
        } else if (itemCode.equals(secondOnlyItem.getItemCode())){
                item = secondOnlyItem;
        }  
        try {
            item = getItem(itemCode);
        } catch (VendingMachineDataValidationException e) {
            Logger.getLogger(VendingMachineDaoStubImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        itemInventory = item.getItemInventory();
        if (itemInventory <= 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        } 
        itemParsedUpdate = (itemInventory - 1);
            item.setItemInventory(itemParsedUpdate);
            itemList.add(item);
            return itemParsedUpdate;
    }

    @Override
    public BigDecimal getItemPriceByCode(String itemCode){
        Item item = new Item(itemCode);
        try {
            item = getItem(itemCode);
        } catch (VendingMachineDataValidationException e) {
            Logger.getLogger(VendingMachineDaoStubImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return item.itemPrice;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException{
        return itemList;
    }

    @Override
    public Item viewItem(String itemCode) throws VendingMachinePersistenceException {
        Item item = new Item(itemCode);
        if (itemCode.equals(onlyItem.getItemCode())) {
               item = itemList.get(0);
        } else if (itemCode.equals(secondOnlyItem.getItemCode())){
               item = itemList.get(1);
        }
        return item;
    }
}
