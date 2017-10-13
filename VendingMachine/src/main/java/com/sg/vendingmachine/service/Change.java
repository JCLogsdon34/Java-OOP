package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Change {

    public int getQuarters(int coinWorthInt) {
        int quartersOut = 0;
        int quarters = 25;
        quartersOut = (int) (coinWorthInt / quarters);
        return quartersOut;
    }

    public int getDimes(int coinWorthInt) {
        int dimesOut = 0;
        int dimes = 10;
        dimesOut = (int) (coinWorthInt / dimes);
        return dimesOut;
    }

    public int getNickels(int coinWorthInt) {
        int nickelsOut = 0;
        int nickels = 5;
        nickelsOut = (int) (coinWorthInt / nickels);
        return nickelsOut;
    }

    public List<String> coinsOut(String itemPrice, String itemMoney) {

        int coinWorthInt;
        double coinsWorth = Double.parseDouble(itemMoney);
        double priceWorth = Double.parseDouble(itemPrice);

        Double coinWorth = coinsWorth - priceWorth;
        if ((coinsWorth - priceWorth) <= 0) {
            coinsWorth = Double.parseDouble(itemMoney);
        }

        String quarter = "Quarter";
        String dime = "Dime";
        String nickel = "Nickel";
        String penny = "Penny";
        int quartersOut = 0;
        int dimesOut = 0;
        int nickelsOut = 0;
        int penniesOut = 0;
        int pennies = 1;
        boolean runIn = false;
        List<String> coinsOut = new ArrayList<>();
        
        coinWorthInt = (int) (coinWorth * 100);
        do{   
        if(coinWorthInt > 0){
            runIn = false;
            
            quartersOut = getQuarters(coinWorthInt);
            do {                
                coinsOut.add(quarter);
                quartersOut = quartersOut - 1;
                coinWorthInt = coinWorthInt - 25;
            } while (quartersOut > 0);
            
            dimesOut = getDimes(coinWorthInt);
            if(dimesOut > 0){       
                dimesOut = dimesOut - 1;
                coinsOut.add(dime);               
                coinWorthInt = coinWorthInt - 10;
            } 

            nickelsOut = getNickels(coinWorthInt);
            if (nickelsOut > 0){
                nickelsOut = nickelsOut - 1;
                coinsOut.add(nickel);       
                coinWorthInt = coinWorthInt - 5;
            } 
           
            penniesOut = (int) (coinWorthInt / pennies);
            do{           
                penniesOut = penniesOut - 1;
                coinsOut.add(penny);              
                coinWorthInt = coinWorthInt - 1;
            }while(penniesOut > 0);
        }else {
            runIn = true;
        }
        }while(runIn == false);
        return coinsOut;
    }
}