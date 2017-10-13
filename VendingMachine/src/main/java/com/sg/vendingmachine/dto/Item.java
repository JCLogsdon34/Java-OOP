
package com.sg.vendingmachine.dto;

import java.util.Objects;


public class Item {

    public String itemName;
    public String itemPrice;   
    public String itemCode;
    public String itemInventory;
    
    public Item(String itemCode) {
        this.itemCode = itemCode;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPrice() {
        return itemPrice;
    }
    
    public String getItemCode() {
        return itemCode;
    }
    
    public void setItemInventory(String itemInventory) {
        this.itemInventory = itemInventory;
    }

    public String getItemInventory() {
        return itemInventory;
    }
}
