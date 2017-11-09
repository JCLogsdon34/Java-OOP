
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;


public class Item {

    public String itemName;
    public BigDecimal itemPrice;
    public String itemCode;
    public int itemInventory;
    
    @Override
    public String toString() {
        return "|Name: " + itemName + " |Code: " + itemCode + " " + "|Item Price" + itemPrice;
    }
    
    public Item(String itemCode) {
        this.itemCode = itemCode;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }
    
    public String getItemCode() {
        return itemCode;
    }
    
    public void setItemInventory(int itemInventory) {
        this.itemInventory = itemInventory;
    }

    public int getItemInventory() {
        return itemInventory;
    }
}
