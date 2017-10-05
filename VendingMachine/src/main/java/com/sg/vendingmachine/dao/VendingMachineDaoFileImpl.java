package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException {

        Item primoItem = new Item();
        String itemPrice = null;

        Items.get(itemCode);
        Items.keySet();
        for (String key : Items.keySet()) {
            if (key.contains(itemCode)) {
                primoItem = getItem(key);
                // itemPrice = getItem(itemCode);
                itemPrice = primoItem.itemPrice;
            }
        }
        return itemPrice;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {

        loadItems();

        return new ArrayList<>(Items.values());
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException {

        loadItems();

        return Items.get(itemCode);
    }

    @Override
    public Item viewItem(String itemCode)
            throws VendingMachinePersistenceException {

        loadItems();

        Item currentItem = Items.get(itemCode);
        return currentItem;
    }

    @Override
    public void vendAndUpdateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        String itemInventory;
        String itemInventoryUpdated;
        int itemInventoryParsed = 0;
        int itemParsedUpdate;
        //currentItem = getItem(itemCode);

        loadItems();

        Set<String> keys = Items.keySet();
        for (String k : keys) {
                Items.get(k);
                itemInventory = Items.get(itemCode).getItemInventory();
                itemInventoryParsed = Integer.parseInt(itemInventory);
            
        }
        if (itemInventoryParsed < 1) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        } 
            itemParsedUpdate = itemInventoryParsed - 1;
            itemInventoryUpdated = Integer.toString(itemParsedUpdate);
            Items.put(itemCode, currentItem);
            writeItems();
    }

    private Map<String, Item> Items = new HashMap<>();

    public static final String ITEMS_FILE = "Items.txt";
    public static final String DELIMITER = "::";

    private void loadItems()
            throws VendingMachinePersistenceException {

        Scanner scanner;
        Item currentItem;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load Item data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentItem = new Item();
            currentItem.setItemName(currentTokens[0]);
            currentItem.setItemPrice(currentTokens[1]);
            currentItem.setItemCode(currentTokens[2]);
            currentItem.setItemInventory(currentTokens[3]);
            Items.put(currentItem.getItemCode(), currentItem);
        }
        scanner.close();
    }

    private void writeItems() throws VendingMachinePersistenceException {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemName() + DELIMITER
                    + currentItem.getItemCode() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemInventory() + DELIMITER);
            out.flush();
        }
        out.close();
    }
}
