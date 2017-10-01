
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
  
    public String getItemByCode() {
        ///use thi smethod for vending
        String itemCode = io.readString("Please enter the Item's code");
        Item currentItem = new Item();
        //set equal to an item already present
        String itemName;
        
        for (currentItem : itemCode) {
            io.print(currentItem.getItemCode() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice() + " "
                    + currentItem.getItemInventory());
        }
  //      String itemInventory = io.readString("Please enter Last Name");
    //    String itemCode = io.readString("Please enter the Item's code");
        
     //   currentItem.setItemName(itemCode);
   //     currentItem.setItemPrice(itemPrice);
     //   currentItem.setItemInventory();
        return itemCode;
        //currentItem;
    }
    
    
    /*
    itemName = io.readString("Please enter the item code for the"
                                + "item whose inventory you want to examine.");
                        
                        itemInventory = io.readInt("Please enter your desired changes for the MPAA Rating");
                        if (itemInventory != 0) {
                            ///print all inventories then a specific one
                            currentItem.setItemInventory(itemInventory);
                            io.print("Your change to the Inventory has been noted");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
    */
    
    public BigDecimal getPayment(){
        String itemPay= io.readString("Please enter the cost of that item");
        BigDecimal itemPaid = new BigDecimal(itemPay);
        
        
        return itemPaid;
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getItemCode() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice());
        }
        io.readString("Please hit enter to continue.");
    }

    
     public int getItemForAdminOptions(String itemCode, Item currentItem) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String itemName;
        int itemInventory = 0;
        
        while (keepOnKeepingOn) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    
                    + "(1)Inventories"
                    + "(2)Leave Menu"        
            );
            
            switch (userSelection) {

                case 1:
                    boolean inputTry;
                    do {
                        itemName = io.readString("Please enter the item code for the"
                                + "item whose inventory you want to examine.");
                        
                        itemInventory = io.readInt("Please enter your desired changes for the MPAA Rating");
                        if (itemInventory != 0) {
                            ///print all inventories then a specific one
                            currentItem.setItemInventory(itemInventory);
                            io.print("Your change to the Inventory has been noted");
                            inputTry = true;
                        } else {
                            inputTry = false;
                        }
                    } while (inputTry == false);
                    break;
                case 2:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return itemInventory;
    }

    public void displayItem(Item currentItem) {
        if (currentItem != null) {
            Item viewItem = new Item();
            io.print(currentItem.getItemName());
            io.print(currentItem.getItemCode());
            io.print(currentItem.getItemCode());
            io.print(currentItem.getItemPrice());
  //          io.print(item.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    } 
     public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }
     
      public void displayVendItemBanner() {
        io.print("=== Vend Item ===");
    }
    
    public void displayAdminOptionsBanner() {
        io.print("=== Administrative Options ===");
    }
    
    public void displayAdminChangeSuccessBanner() {
        io.print("=== Changes Successful ===");
    }

    
    public void displayVendSuccessBanner() {
        io.readString(
                "Item successfully vended.  Please hit enter to continue");
    }

    public String getItemCodeChoice() {
        return io.readString("Please enter the Item Code.");
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
