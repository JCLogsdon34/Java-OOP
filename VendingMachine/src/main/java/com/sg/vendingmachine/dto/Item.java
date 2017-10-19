
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;


public class Item {

    public String itemName;
    public BigDecimal itemPrice;
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

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemPrice() {
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
