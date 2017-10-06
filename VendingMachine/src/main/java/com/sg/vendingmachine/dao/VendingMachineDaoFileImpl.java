package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException {

        Item primoItem = new Item();
        String itemPrice;

        Items.get(itemCode);

        // for (String key : Items.keySet()) {
        // if (key.contains(itemCode)) {
        itemPrice = primoItem.itemPrice;
        // }
        //   }
        return itemPrice;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {

        loadItems();
        ArrayList<Item> arrayList = new ArrayList<>(Items.values());
        return arrayList;
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
    public String vendAndUpdateItem(String itemCode, Item item)
            throws VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        loadItems();

        String itemInventory;
        String itemInventoryUpdated;
        BigDecimal itemInventoryParsed;
        BigDecimal itemParsedUpdate;
        Item newItem;
        MathContext mc = new MathContext(1);
        //  newItem = Items.get(itemCode);

        newItem = Items.get(itemCode);
        itemInventory = newItem.getItemInventory();

        itemInventoryParsed = new BigDecimal(itemInventory);

        if (itemInventoryParsed.compareTo(BigDecimal.ZERO) < 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        }
        // itemParsedUpdate = itemInventoryParsed - 1;
        itemParsedUpdate = itemInventoryParsed.subtract(itemInventoryParsed, mc);

        itemInventoryUpdated = String.valueOf(itemParsedUpdate);
        item.setItemInventory(itemInventoryUpdated);
        Items.put(itemInventoryUpdated, item);
        writeItems();
        return itemInventoryUpdated;
    }

    private Map<String, Item> Items = new HashMap<>();

    public static final String ITEMS_FILE = "Items.txt";
    public static final String DELIMITER = "::";

    public void loadItems()
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
        
        currentTokens = new String[]{};
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);
            currentItem = new Item();
            currentItem.setItemCode(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(currentTokens[2]);
            currentItem.setItemInventory(currentTokens[3]);

            Items.put(currentItem.getItemCode(), currentItem);
        
        }
        scanner.close();
    }

    public void writeItems() throws VendingMachinePersistenceException {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemCode()
                    + currentItem.getItemName()
                    + currentItem.getItemPrice()
                    + currentItem.getItemInventory());
            out.flush();
        }
        out.close();
    }
}
