
package com.sg.vendingmachine.dto;


public class Item {

    public String itemCode;
    public String itemName;
    public String itemPrice;   ///This needs to be BigDecimal
    public String itemInventory;
    
    //maybe use an Item getter and setter?
    

     public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
     public String getItemCode() {
        return itemCode;
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
    public void setItemInventory(String itemInventory) {
        this.itemInventory = itemInventory;
    }

    public String getItemInventory() {
        return itemInventory;
    }
    
    /*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.itemName);
        hash = 61 * hash + Objects.hashCode(this.itemPrice);
        hash = 61 * hash + Objects.hashCode(this.itemInventory);
        hash = 61 * hash + Objects.hashCode(this.itemCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemPrice, other.itemPrice)) {
            return false;
        }
        if (!Objects.equals(this.itemInventory, other.itemInventory)) {
            return false;
        }
        if (!Objects.equals(this.itemCode, other.itemCode)) {
            return false;
        }
        return true;
    }
*/
}
