package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    Item onlyItem;
    List<Item> itemList = new ArrayList<>();

    public VendingMachineDaoStubImpl() {
        onlyItem = new Item("W63");
        onlyItem.setItemName("Samuel L. Jackson");
        onlyItem.setItemPrice("3.05");
        onlyItem.setItemInventory("5");

        itemList.add(onlyItem);
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        if (itemCode.equals(onlyItem.getItemCode())) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public int vendAndUpdateItem(String itemCode, Item item)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDataValidationException {
        String itemInventory;
        String itemInventoryUpdated;
        int itemInventoryParsed;
        int itemParsedUpdate;

        item = getItem(itemCode);
        itemInventory = item.getItemInventory();

        itemInventoryParsed = Integer.parseInt(itemInventory);

        if (itemInventoryParsed < 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        }

        itemParsedUpdate = (itemInventoryParsed - 1);

        itemInventoryUpdated = String.valueOf(itemParsedUpdate);
        item.setItemInventory(itemInventoryUpdated);

        if (itemCode.equals(onlyItem.getItemCode())) {

            return itemInventoryParsed;
        } else {
            return 0;
        }
    }

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        Item item = new Item(itemCode);

        item = getItem(itemCode);
// NPE checked
        return item.itemPrice;
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineNoItemInInventoryException {

        return itemList;
    }

    @Override
    public Item viewItem(String itemCode) throws VendingMachinePersistenceException {
        Item item;
        item = itemList.get(0);
        return onlyItem;
    }
}
