package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
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

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException{

        Item primoItem = new Item(itemCode);
        String itemPrice;

        primoItem = Items.get(itemCode);

        itemPrice = primoItem.itemPrice;

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

        return Items.get(itemCode);
    }

    @Override
    public int vendAndUpdateItem(String itemCode, Item item)
            throws VendingMachinePersistenceException, 
            VendingMachineNoItemInInventoryException {

        loadItems();

        String itemInventory;
        String itemInventoryUpdated;
        int itemInventoryParsed;
        int itemParsedUpdate;

        item = Items.get(itemCode);

        itemInventory = item.getItemInventory();
        itemInventoryParsed = Integer.parseInt(itemInventory);
         if(itemInventoryParsed < 1){
            throw new VendingMachineNoItemInInventoryException
                ("ERROR: Could not vend.  Item "
                    + itemCode
                    + " is sold out");
        }


        itemParsedUpdate = (itemInventoryParsed - 1);
        itemInventoryUpdated = String.valueOf(itemParsedUpdate);
        item.setItemInventory(itemInventoryUpdated);

        writeItems();
        return itemParsedUpdate;
    }

    private Map<String, Item> Items = new HashMap<>();

    public static final String ITEMS_FILE = "Items.txt";
    public static final String DELIMITER = "::";

    private void loadItems()
            throws VendingMachinePersistenceException {

        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachinePersistenceException(
                    "-_- Could not load Item data into memory.", e);
        }
        String currentLine;
        String[] currentTokens = new String[]{};
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            
            currentTokens = currentLine.split(DELIMITER);
            Item currentItem = new Item(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(currentTokens[2]);
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
            out.println(currentItem.getItemCode() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() +  DELIMITER
                    + currentItem.getItemInventory());
            
            out.flush();
        }
        out.close();
    }
}