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
            throws VendingMachinePersistenceException {
      String itemPrice = null;
      Item currentItem;
        try {
            loadItems();
        } catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }
 
        currentItem = items.get(itemCode);
        itemPrice = items.get(itemCode).getItemPrice();
      return itemPrice;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {

        try {
            loadItems();
        } catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        return new ArrayList<>(items.values());
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException {
       
        try {
            loadItems();
        } catch (FileNotFoundException e) {
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
       // writeItems();
        return currentItem;
    }
    
    @Override
    public void vendAndUpdateItem(String itemCode, Item currentItem)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {        
        String itemInventory;
        int itemInventoryParsed;
        Item updatedItem = null;  
        currentItem = getItem(itemCode);
        try {
            loadItems();
        } catch (FileNotFoundException e) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, e);
        }    
        
        itemInventory = items.get(itemCode).getItemInventory();
        itemInventoryParsed = Integer.parseInt(itemInventory);
        if (itemInventoryParsed == 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item"
                    + currentItem
                    + " is sold out");
        } else if (itemInventoryParsed > 0) {
            itemInventoryParsed = itemInventoryParsed - 1;
        }
        items.put(itemCode, updatedItem);
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
      // customer does not need to see the inventory
           currentItem.setItemInventory(currentTokens[3]);
            items.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }

    private void writeItems()
            throws VendingMachinePersistenceException {

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException e) {
            throw new VendingMachinePersistenceException(
                    "Could not save item data.", e);
        }
        
        //maybe itemCode and itemName should be static
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemName() + DELIMITER
                   + currentItem.getItemInventory() + DELIMITER);
            out.flush();
        }
        out.close();
    }
}
// currentTokens holds each of the parts of the currentLine after it has
// been split on our DELIMITER
// NOTE FOR APPRENTICES: In our case we use :: as our delimiter.  If
// currentLine looks like this:
// 1234::Joe::Smith::Java-September2013
// then currentTokens will be a string array that looks like this:__________________________________
// |    |   |     |                  |
// |1234|Joe|Smith|Java-September2013|
// |    |   |     |                  |
// -----------------------------------
//  [0]  [1]  [2]         [3]
// Go through ROSTER_FILE line by line, decoding each line into a 
// Item object.
// Process while we have more lines in the file
// Create a new Item object and put it into the map of items
// NOTE FOR APPRENTICES: We are going to use the student id
// which is currentTokens[0] as the map key for our student object.
// We also have to pass the item id into the Item constructor

/**
 * Writes all students in the roster out to a ROSTER_FILE. See loadInventory for
 * file format.
 *
 * @throws VendingMachineDaoException if an error occurs writing to the file
 */
// Write out the Item objects to the Items file.
// NOTE TO THE APPRENTICES: We could just grab the student map,
// get the Collection of Items and iterate over them but we've
// already created a method that gets a List of Items so
// we'll reuse it.
            
