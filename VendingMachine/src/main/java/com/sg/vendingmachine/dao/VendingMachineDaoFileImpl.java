
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineDaoFileImpl implements VendingMachineDao {

    @Override
    public Item addItem(String itemName, Item item) 
            throws VendingMachineDaoException {
        Item newItem = item.put(itemName, item);
        writeRoster();
        return newItem;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachineDaoException {
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>(item.values());
    }

    @Override
    public Item getItem(String itemName)
            throws VendingMachineDaoException, 
            VendingMachinePersistenceException{
        try {
            loadRoster();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VendingMachineDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item.get(itemName);
    }

    @Override
    public Item removeItem(String itemName)
            throws VendingMachineDaoException {
        Item removedItem = item.remove(itemName);
        writeRoster();
        return removedItem;
    }

    private Map<String, Item> item = new HashMap<>();

    public static final String ROSTER_FILE = "item.txt";
    public static final String DELIMITER = "::";

    private void loadRoster() 
            throws VendingMachineDaoException, FileNotFoundException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new VendingMachineDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        String currentLine;
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
        String[] currentTokens;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Item object.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
    
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // Create a new Item object and put it into the map of items
            // NOTE FOR APPRENTICES: We are going to use the student id
            // which is currentTokens[0] as the map key for our student object.
            // We also have to pass the item id into the Item constructor
            Item currentItem = new Item(currentTokens[0]);
            // Set the remaining vlaues on currentStudent manually
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemPrice(currentTokens[2]);
            currentItem.setItemCode(currentTokens[3]);
              // Or in this case itemName
            // Put currentStudent into the map using studentID as the key
            item.put(currentItem.getItemName(), currentItem);
        }
        scanner.close();
    }
    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadInventory
     * for file format.
     * @throws VendingMachineDaoException if an error occurs writing to the file
     */
    private void writeRoster() 
            throws VendingMachineDaoException {
       
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new VendingMachineDaoException(
                    "Could not save item data.", e);
        }
        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            out.println(currentItem.getItemName() + DELIMITER
                    + currentItem.getItemPrice() + DELIMITER
                    + currentItem.getItemInventory() + DELIMITER
                    + currentItem.getItemCode());
            out.flush();
        }
        out.close();
    }
}
