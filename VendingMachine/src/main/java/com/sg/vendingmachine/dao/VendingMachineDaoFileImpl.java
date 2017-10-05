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
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    @Override
    public String getItemPrice(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineDaoException{
            Item currentItem = new Item();
            String itemPrice;
                 
        try {
            loadItems();
        } catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        currentItem = items.get(itemCode);
        itemPrice = currentItem.getItemPrice();

        return itemPrice;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        try {
            loadItems();
        } catch (NullPointerException | FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return new ArrayList<>(items.values());
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {
       
        try {
            loadItems();
        } catch (NullPointerException | FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return items.get(itemCode);       
    }

    
    @Override
    public Item viewItem(String itemCode)
            throws VendingMachinePersistenceException {
        try {
            loadItems();
        } catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        Item currentItem = items.get(itemCode);
        return currentItem;
    }
    
    @Override
    public void vendAndUpdateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {        
        String itemInventory = null;
        int itemInventoryParsed;
      //Item updatedItem = null;  
      //currentItem = getItem(itemCode);
        try {
            loadItems();
        } catch (NullPointerException | FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }  
        
        currentItem = items.get(itemCode);
        itemInventory = currentItem.getItemInventory();
        itemInventoryParsed = Integer.parseInt(itemInventory);
        if (itemInventoryParsed <= 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item"
                    + currentItem.getItemName()
                    + " is sold out");
        }    
        itemInventoryParsed--;
        itemInventory = Integer.toString(itemInventoryParsed);
        items.put(itemCode, currentItem);
        writeItems();
    }

    private Map<String, Item> items = new HashMap<>();

    public static final String ITEMS_FILE = "Items.txt";
    public static final String DELIMITER = "::";

    private void loadItems()
            throws VendingMachinePersistenceException, FileNotFoundException {
        
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
            items.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }

    private void writeItems()
            throws VendingMachinePersistenceException, VendingMachineDataValidationException, VendingMachineNoItemInInventoryException {

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
                   + currentItem.getItemInventory() + DELIMITER);
            out.flush();
        }
        out.close();
    }
}
            
