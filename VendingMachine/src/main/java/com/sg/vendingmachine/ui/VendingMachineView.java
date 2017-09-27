
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.List;


public class VendingMachineView {
    
    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Items");
        io.print("2. Vend Item");  //this will need to change
        io.print("3. View an Item");
        io.print("4. Administrator Only Options");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public String getItemCode() {
        ///use thi smethod for vending
        String itemCode = io.readString("Please enter Item's code");
        
  //      String itemInventory = io.readString("Please enter Last Name");
    //    String itemCode = io.readString("Please enter the Item's code");
     //   Item currentItem = new Item();
     //   currentItem.setItemName(itemCode);
   //     currentItem.setItemPrice(itemPrice);
     //   currentItem.setItemInventory();
        return itemCode;
        //currentItem;
    }
    
    public  int getPayment(){
        int itemPay= io.readInt("Please enter the cost of that item");
        
        return itemPay;
    }

    ////change this too
    public void displayVendItemBanner() {
        io.print("=== Vend Item ===");
    }

    ///change this one too
    public void displayVendSuccessBanner() {
        io.readString(
                "Item successfully vended.  Please hit enter to continue");
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getItemCode() + ": "
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
            io.print(item.getItemCode() + " ");
            io.print(item.getItemName() + " " + item.getItemPrice());
  //          io.print(item.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayPriceItemBanner() {
        io.print("=== Item Price ===");
    }

    public void displayPaymentSuccessBanner() {
        io.readString("Money successfully paid. Please hit enter to continue.");
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
