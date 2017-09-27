
package com.sg.vendingmachine.service;


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
        return quarter;
    }
     
    public void setNickel(int nickel) {
        this.nickel = nickel;
    }

    public int getNickel() {
        return nickel;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }

    public int getDime() {
        return dime;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }

    public int getPenny() {
        return penny;
    }
    
    public void setEachInPennies(int quarter, int nichel, int dime){
        penny = (int) .01;
        quarter = (penny * 25);
        nichel = (penny * 5);
        dime = (penny * 10);  
        
    }
    
    public int getEachInPennies(){
        
        
        return eachInPennies;
    }
}
