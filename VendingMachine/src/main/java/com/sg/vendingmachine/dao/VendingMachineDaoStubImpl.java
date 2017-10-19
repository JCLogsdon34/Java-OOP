package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    Item secondOnlyItem;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        BigDecimal itemPrice = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);
        onlyItem = new Item("W63");
        onlyItem.setItemName("Samuel L. Jackson");
        onlyItem.setItemPrice(itemPrice);
        onlyItem.setItemInventory("5");

        itemList.add(onlyItem);
        BigDecimal itemPrice1 = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);
        secondOnlyItem = new Item("W64");
        secondOnlyItem.setItemName("Samuel L. Jackson Ale");
        secondOnlyItem.setItemPrice(itemPrice1);
        secondOnlyItem.setItemInventory("0");
        
        itemList.add(secondOnlyItem);
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
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
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
        String itemInventory;
        String itemInventoryUpdated;
        int itemInventoryParsed;
        int itemParsedUpdate;

             
        item = getItem(itemCode);
        if (itemCode.equals(onlyItem.getItemCode())) {
                item = onlyItem;
        } else if (itemCode.equals(secondOnlyItem.getItemCode())){
                item = secondOnlyItem;
        }  
        item = getItem(itemCode);
        itemInventory = item.getItemInventory();
        itemInventoryParsed = Integer.parseInt(itemInventory);

     
        if (itemInventoryParsed <= 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        } 
        itemParsedUpdate = (itemInventoryParsed - 1);
        itemInventoryUpdated = String.valueOf(itemParsedUpdate);

            item.setItemInventory(itemInventoryUpdated);
            itemList.add(item);
            return itemInventoryParsed;
    }

    @Override
    public BigDecimal getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        Item item = new Item(itemCode);
        item = getItem(itemCode);
        return item.itemPrice;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineNoItemInInventoryException {

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
