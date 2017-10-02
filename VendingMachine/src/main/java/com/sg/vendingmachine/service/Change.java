
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;


public class Change {
    public int quarter;
    public int nickel;   ///This needs to be BigDecimal
    public int dime;
    public int penny;
    private int eachInPennies;
    
    
 
    
     public void setQuarter(int quarter) {
        this.quarter = quarter;
    }
     public int getQuarter() {

        int quarterWorth = (25 * penny);
        return quarterWorth;
    }
     
    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    public int getNickel() {
        
        int nickelWorth = (5 * penny);        
        return nickelWorth;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getDime() {
        
        int dimeWorth = (10 * penny);
        return dimeWorth;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    public int getPenny() {
        penny = (int) .01;
        return penny;
    }
    
    public void setEachInPennies(int quarter, int nichel, int dime){
        this.eachInPennies = eachInPennies;         
    }
    
    public int getEachInPennies(){
        
       int nickelWorthPennies = 5;
       int dimeWorthPennies = 10;
       int quarterWorthPennies = 25;
       
       
       
    /*   if(itemPaid % quarter == 0)
      maybe use this to check payment?
      and to check refunds and money Paid */
       
        return eachInPennies;
    }
   
    public int getCashInfo(int itemPaid, Item itemPrice) {
        int whichOption = 0;
        int itemPriceInt;
        
       
        
    /*    int inPennies = itemPaid / penny;
       int inNickels = itemPaid % nickel;
       int inDime = itemPaid % dime;
       int inQuarter = itemPaid % quarter;   */
    
    return whichOption;
    }
}
