package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.Coins;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        io.print("4. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public String getPayment(String itemPrice) {
        io.print(itemPrice + "is the cost of that item");
        String itemPay = io.readString("Please enter the cost of that item in coins");
        return itemPay;
    }

    public void displayItemList(List<Item> itemList) {
        for (Item currentItem : itemList) {
            io.print(currentItem.getItemCode() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayItem(Item currentItem) {
        if (currentItem != null) {
            Item viewItem = new Item();
            io.print(currentItem.getItemName());
            io.print(currentItem.getItemCode());
            io.print(currentItem.getItemCode());
            io.print(currentItem.getItemPrice());
            io.print(currentItem.getItemInventory());
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void refundMoney(Map<Coins, Integer> cashRefund)
            throws VendingMachineInsufficientFundsException {
        if(cashRefund == null){
              displayNoChangeBanner();
        }
        io.print("Your refund is: " + cashRefund + ".");
    }

    public void displayVendSuccessBanner() {
        io.readString(
                "Item successfully vended.  Please hit enter to continue");
    }

    public String getItemCodeChoice() throws VendingMachinePersistenceException {
        String itemEntry;
        String itemCode;
        itemEntry = io.readString("Please enter the Item Code.");
        if (itemEntry == null) {
            throw new VendingMachinePersistenceException(
                    "ERROR: Could not vend.  Item"
                    + itemEntry
                    + " code is invalid");
        }
        itemCode = itemEntry.toUpperCase();
        return itemCode;
    }

    public void displayPaymentSuccessBanner() {
        io.readString("Money successfully paid. Please hit enter to continue.");
    }

    public void displayDisplayItemBanner() {
        io.print("=== Display Item ===");
    }

    public void displayVendingItem() {
        io.print("=== Vending In Progress ===");
    }

    public void displayVendItemBanner() {
        io.print("=== Vend Item Successful ===");
    }

    public void displayAdminOptionsBanner() {
        io.print("=== Administrative Options ===");
    }

    public void displayAdminChangeSuccessBanner() {
        io.print("=== Changes Successful ===");
    }

    public void displayPriceItemBanner() {
        io.print("=== Item Price ===");
    }

    public void displayNoChangeBanner() {
        io.print("No change due");
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
}
