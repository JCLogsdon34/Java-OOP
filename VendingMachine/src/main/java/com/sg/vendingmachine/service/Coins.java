
package com.sg.vendingmachine.service;

import java.util.HashMap;
import java.util.Map;


public enum Coins {
    
    QUARTER (25),
    DIME (10),
    NICKEL (5),
    PENNY (1);
    
    public final int valueInPennies;
    
    Coins(int valueInPennies){
        this.valueInPennies = valueInPennies;
    }   
    Map<Coins, Integer> changeWorth = new HashMap<>();
}
