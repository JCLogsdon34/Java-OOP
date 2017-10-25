package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import static java.math.BigDecimal.TEN;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Change {

    public static int getQuarters(int coinWorthInt) {
        int quartersOut = 0;
        int quarters = 25;
        quartersOut = (int) (coinWorthInt / quarters);
        return quartersOut;
    }

    public static int getDimes(int coinWorthInt) {
        int dimesOut = 0;
        int dimes = 10;
        dimesOut = (int) (coinWorthInt / dimes);
        return dimesOut;
    }

    public static int getNickels(int coinWorthInt) {
        int nickelsOut = 0;
        int nickels = 5;
        nickelsOut = (int) (coinWorthInt / nickels);
        return nickelsOut;
    }

     public static int getPennies(int coinWorthInt) {
        int penniesOut = 0;
        int pennies = 1;
        penniesOut = (int) (coinWorthInt / pennies);
        return penniesOut;
    }
     
    public static List<String> coinsOut(BigDecimal itemPrice, BigDecimal itemMoney) {
        BigDecimal coinWorthBig = BigDecimal.ZERO;
        int coinWorthInt = 0;
        BigDecimal moneyMe = BigDecimal.ZERO;
        moneyMe.setScale(2, RoundingMode.HALF_UP);
        BigDecimal itemRefund = itemMoney.subtract(itemPrice);
        String quarter = "Quarter";
        String dime = "Dime";
        String nickel = "Nickel";
        String penny = "Penny";
        int quartersOut = 0;
        int dimesOut = 0;
        int nickelsOut = 0;
        int penniesOut = 0;
        int pennies = 100;
        boolean runIn = false;
        List<String> coinsOut = new ArrayList<>();
        coinWorthBig = itemRefund.multiply(new BigDecimal(pennies));
        coinWorthInt = coinWorthBig.intValue();
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
           
            penniesOut = getPennies(coinWorthInt);
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