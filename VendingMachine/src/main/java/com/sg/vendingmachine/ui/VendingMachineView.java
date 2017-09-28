
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.time.LocalDate;
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
  //      io.print("3. View an Item");
        io.print("3. Administrator Only Options");
        io.print("4. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }
  
    public Item getItemCode(String itemCode) {
        ///use thi smethod for vending
        Item itemCode1 = null;
        Item currentItem = new Item();
        //set equal to an item already present
        
        
        for (currentItem :  itemCode) {
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
        return itemCode1;
        //currentItem;
    }
    
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

    
     public Item getItemForAdminOptions(String itemCode, Item currentItem) {
        boolean keepOnKeepingOn = true;
        int userSelection;
        String itemName;
        int itemInventory;
        BigDecimal moneyInMachine;
        
        while (keepOnKeepingOn) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Look at money collected "
                    + "(2)Inventories"
             //       + "(3)Change Price"
                    + "(3)Leave Menu"        
            );
            switch (userSelection) {
                case 1:
                    moneyInMachine = io.readBigDecimal("Please enter your desired changes for the Release Date");
                 //   currentItem.setItemInventory;
                    //add way to empty money from machine
                    io.print("Your change to the Money in the machine has been noted");
                    break;
                case 2:
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
              /*  case 3:
                    boolean inputValidate;
                    do {
                        directorsName = io.readString("Please enter your desired changes for the Director's Name");
                        if (directorsName != null && !directorsName.isEmpty()) {
                            currentItem.setDirectorsName(directorsName);
                            io.print("Your change to the Director's Name has been noted");
                            inputValidate = true;
                        } else {
                            inputValidate = false;
                        }
                    } while (inputValidate == false); 
                    break;    
                case 4:
                    boolean inputBool;
                    do {
                        userRating = io.readString("Please enter your desired changes for User Notes");
                        if (userRating != null && !userRating.isEmpty()) {
                            currentItem.setUserRating(userRating);
                            io.print("Your change to the User Notes have been noted");
                            inputBool = true;
                        } else {
                            inputBool = false;
                        }
                    } while (inputBool == false);
                    break;  */
                case 3:
                    keepOnKeepingOn = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return currentItem;
    }
/*
    public void displayItem(String itemCode) {
        if (itemCode != null) {
            io.print(item.getItemCode() + " ");
            io.print(item.getItemName() + " " + item.getItemPrice());
  //          io.print(item.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    } */
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
