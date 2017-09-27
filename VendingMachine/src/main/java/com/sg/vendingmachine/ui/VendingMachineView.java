
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.util.List;


public class VendingMachineView {
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. Create New Item");  //this will need to change
        io.print("3. View an Item");
        io.print("4. Remove an item");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Item getNewItemInfo() {
        ///use thi smethod for vending
        String itemName = io.readString("Please enter Item's code");
        String itemPrice = io.readString("Please enter First Name");
        String itemInventory = io.readString("Please enter Last Name");
        String itemCode = io.readString("Please enter Cohort");
        Item currentStudent = new Item();
        currentStudent.setItemName(itemName);
        currentStudent.setItemPrice(itemPrice);
        currentStudent.setItemInventory();
        return currentItem;
    }

    ////change this too
    public void displayCreateItemBanner() {
        io.print("=== Create Item ===");
    }

    ///change this one too
    public void displayCreateSuccessBanner() {
        io.readString(
                "Item successfully created.  Please hit enter to continue");
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getStudentCode() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }

    public String getItemCodeChoice() {
        return io.readString("Please enter the Item Code.");
    }

    public void displayItem(Item item) {
        if (item != null) {
            io.print(item.getItemCode());
            io.print(item.getItemName() + " " + item.getItemPrice());
            io.print(item.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveItemBanner() {
        io.print("=== Remove Item ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Item successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayDisplayAllBanner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
