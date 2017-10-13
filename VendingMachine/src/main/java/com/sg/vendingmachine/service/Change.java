package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Change {

    public int getQuarters(double itemRefund) {
        int quartersOut = 0;
        int quarters = 25;
        if (itemRefund % quarters == 0) {
            quartersOut = (int) (itemRefund / quarters);
        }
        return quartersOut;
    }

    public int getDimes(double itemRefund) {
        int dimesOut = 0;
        int dimes = 10;
        if (itemRefund % dimes == 0) {
            dimesOut = (int) (itemRefund / dimes);
        }
        return dimesOut;
    }

    public int getNickels(double itemRefund) {
        int nickelsOut = 0;
        int nickels = 5;

        if (itemRefund % nickels == 0) {
            nickelsOut = (int) (itemRefund / nickels);
        }

        return nickelsOut;
    }

    public int getPennies(double itemRefund) {
        int penniesOut = 0;
        int pennies = 1;
        if (itemRefund % pennies == 0) {
            penniesOut = (int) (itemRefund / pennies);
        }
        return penniesOut;
    }

    public List<String> coinsOut(String itemPrice, String itemMoney) {

        double coinsWorth = Double.parseDouble(itemMoney);
        double priceWorth = Double.parseDouble(itemPrice);

        Double coinWorth = coinsWorth - priceWorth;
        if (coinWorth <= 0) {
            coinsWorth = Double.parseDouble(itemMoney);
        }

        Double userRefund = coinWorth * 100;
        Double userRefund1 = coinWorth * 100;
        Double userRefund2 = coinWorth * 100; 
        Double userRefund3 = coinWorth * 100;
        String quarter = "Quarter";
        String dime = "Dime";
        String nickel = "Nickel";
        String penny = "Penny";
        int quartersOut = 0;
        int dimesOut = 0;
        int nickelsOut = 0;
        int penniesOut = 0;
        int quarters = 25;
        int dimes = 10;
        int nickels = 5;
        int pennies = 1;
        double whatsLeft;

        if (userRefund % 25 == 0) {
            quartersOut = getQuarters(userRefund);
            whatsLeft = quartersOut * 100;
            userRefund1 = userRefund - whatsLeft;
        } 
        if (userRefund1 % 10 == 0) {
            dimesOut = getDimes(userRefund);
            whatsLeft = dimesOut * 100;
            userRefund2 = userRefund1 - whatsLeft;
        } 
        if (userRefund2 % 5 == 0) {
            nickelsOut = getNickels(userRefund);
            whatsLeft = nickelsOut * 100;
            userRefund3 = userRefund2 - whatsLeft;
        } 
        if (userRefund3 > 0) {
            penniesOut = getPennies(userRefund);
            whatsLeft = penniesOut * 100;
        }
        int i = 0;
        i = quartersOut + dimesOut + nickelsOut + penniesOut;
        List<String> coinsOut = new ArrayList<>();

        for (int x = 0; x < i; x++) {
            if (penniesOut > 0) {
                coinsOut.add(penny);
            } else if (nickelsOut > 0) {
                coinsOut.add(nickel);
            } else if (dimesOut > 0) {
                coinsOut.add(dime);
            } else if (quartersOut > 0) {
                coinsOut.add(quarter);
            }
        }

        return coinsOut;

    }
}
