package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import static java.math.BigDecimal.ONE;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Change {

    public BigDecimal getQuarters(BigDecimal coinWorthBig) {
        BigDecimal quartersOut = BigDecimal.ZERO;
        BigDecimal quarters = new BigDecimal(.25);
        quartersOut = (coinWorthBig.divide(quarters, 2, RoundingMode.HALF_UP));
        return quartersOut;
    }

    public BigDecimal getDimes(BigDecimal coinWorthBig) {
        BigDecimal dimesOut = BigDecimal.ZERO;
        BigDecimal dimes = new BigDecimal(.10);
        dimesOut = (coinWorthBig.divide(dimes, 2, RoundingMode.HALF_UP));
        return dimesOut;
    }

    public BigDecimal getNickels(BigDecimal coinWorthBig) {
        BigDecimal nickelsOut = BigDecimal.ZERO;
        BigDecimal nickels = new BigDecimal(.5);
        nickelsOut =  (coinWorthBig.divide(nickels, 2, RoundingMode.HALF_UP));
        return nickelsOut;
    }
    
    public BigDecimal getPennies(BigDecimal coinWorthBig) {
        BigDecimal penniesOut = BigDecimal.ZERO;
        BigDecimal pennies = new BigDecimal(.01);
        penniesOut = (coinWorthBig.divide(pennies, 2, RoundingMode.HALF_UP));
        return penniesOut;
    }

    public List<String> coinsOut(BigDecimal itemPrice, BigDecimal itemMoney) {

        BigDecimal coinWorthBig = BigDecimal.ZERO;


        coinWorthBig = itemMoney.subtract(itemPrice);

        String quarter = "Quarter";
        String dime = "Dime";
        String nickel = "Nickel";
        String penny = "Penny";
        BigDecimal quartersOut = BigDecimal.ZERO;
        BigDecimal dimesOut = BigDecimal.ZERO;
        BigDecimal nickelsOut = BigDecimal.ZERO;
        BigDecimal penniesOut = BigDecimal.ZERO;
        BigDecimal pennies = new BigDecimal(.01);
        BigDecimal nickels = new BigDecimal(.05);
        BigDecimal dimes = new BigDecimal(.10);
        BigDecimal quarters = new BigDecimal(.25);
        boolean runIn = false;
        List<String> coinsOut = new ArrayList<>();
        
        do{   
        if(coinWorthBig.compareTo(BigDecimal.ZERO) > 0){
            runIn = false;
            
            quartersOut = getQuarters(coinWorthBig);
            do {                
                coinsOut.add(quarter);
                quartersOut = quartersOut.subtract(ONE);
                coinWorthBig = coinWorthBig.subtract(quarters);
            } while (quartersOut.compareTo(BigDecimal.ZERO) > 0);
            
            dimesOut = getDimes(coinWorthBig);
            if(dimesOut.compareTo(BigDecimal.ZERO) > 0){       
                dimesOut = dimesOut.subtract(ONE);
                coinsOut.add(dime);               
                coinWorthBig = coinWorthBig.subtract(dimes);
            } 

            nickelsOut = getNickels(coinWorthBig);
            if (nickelsOut.compareTo(BigDecimal.ZERO) > 0){
                nickelsOut = nickelsOut.subtract(ONE);
                coinsOut.add(nickel);       
                coinWorthBig = coinWorthBig.subtract(nickels);
            } 
           
            penniesOut = getPennies(coinWorthBig);
            do{           
                penniesOut = penniesOut.subtract(ONE);
                coinsOut.add(penny);              
                coinWorthBig = coinWorthBig.subtract(pennies);
            }while(penniesOut.compareTo(BigDecimal.ZERO) > 0);
        }else {
            runIn = true;
        }
        }while(runIn == false);
        return coinsOut;
    }
}