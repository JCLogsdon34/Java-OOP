package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Item;
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
    public Item addItem(String itemCode, Item item)
            throws VendingMachinePersistenceException {
        Item newItem = null;
        loadItems();
        items.get(itemCode);
        items.keySet();

        newItem = items.put(item.getItemName(), item);
        writeItems();
        return newItem;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {

        loadItems();

        return new ArrayList<>(items.values());
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException {

        loadItems();
        
        return items.get(itemCode);
    }

    @Override
    public Item viewItem(String itemCode)
            throws VendingMachinePersistenceException {
        Item removedItem = items.remove(itemCode);
        writeItems();
        return removedItem;
    }
    
    @Override
    public Item updateItem(String itemName)
            throws VendingMachinePersistenceException {
        Item itemInventory;
        Item updatedItem = null;
        loadItems();
        
        
        writeItems();
        return updatedItem;
    }

    private Map<String, Item> items = new HashMap<>();

    public static final String ITEMS_FILE = "Items.txt";
    public static final String DELIMITER = ":::";

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
                    + currentItem.getItemPrice() + DELIMITER
                    //not sure about showing ItemInventory
                    + currentItem.getItemInventory() + DELIMITER
                    + currentItem.getItemCode() + DELIMITER);
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
            
