package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
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
        io.print("2. Vend Item");
        io.print("3. View an Item");
        io.print("4. Exit");

        return io.readInt("Please select from the above choices.", 1, 4);
    }

    public BigDecimal getPayment(BigDecimal itemPrice) {
        io.print(itemPrice + " is the cost of that item");
        BigDecimal itemPay = io.readBigDecimal("Please enter the cost of that item in coins");

        return itemPay;
    }

    public void displayItemList(List<Item> itemList) {
        itemList.stream().forEach((currentItem) -> {
            io.print(currentItem.getItemCode() + ": "
                    + currentItem.getItemName() + " "
                    + currentItem.getItemPrice() + " "
                    + "Number In Stock" + " "
                    + currentItem.getItemInventory());
        });
        io.readString("Please hit enter to continue.");
    }

    public void displayItem(Item currentItem) {
        if (currentItem != null) {
            io.print(currentItem.getItemCode());
            io.print(currentItem.getItemName());
            io.print(currentItem.getItemPrice().toString());
            io.print(String.valueOf(currentItem.getItemInventory()));
            io.print("");
        } else {
            io.print("No such item.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void refundMoney(List<String> cashRefund)
            throws VendingMachineInsufficientFundsException {
        io.print("Your refund is: ");

        cashRefund.stream().forEach((item) -> {
            io.print(item);
        });
        if (cashRefund.isEmpty()) {
            displayNoChangeBanner();
        }
    }

    public void displayVendSuccessBanner() {
        io.readString(
                "Item successfully vended.  Please hit enter to continue");
    }

    public String getItemCodeChoice()
            throws VendingMachineInvalidItemCodeException {
        String itemEntry;
        String itemCode = null;
        boolean newInput;
        do {
            itemEntry = io.readString("Please enter the Item's Code.");
            if ((itemEntry.length() > 3)) {
                throw new VendingMachineInvalidItemCodeException(
                        "ERROR: Could not vend.  Item"
                        + itemEntry
                        + " code is invalid");
            }
            Item currentItem = new Item(itemCode);
            if (!itemEntry.isEmpty()) {
                currentItem.getItemCode();
                newInput = true;
            } else {
                newInput = false;
            }
        } while (newInput == false);
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

    public void displayNotEnoughMessage(BigDecimal itemMoneyParsed) {
        io.print("=== ERROR ===");
        io.print(itemMoneyParsed + " is not enough for that item.");
    }
}
