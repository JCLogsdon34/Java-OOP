package com.sg.vendingmachine.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {


    public int getCashInfo(String itemPaid, String itemPrice)
            throws VendingMachineInsufficientFundsException {

        int itemRefund;
        int itemPaidParsed = Integer.parseInt(itemPaid);
        int itemPriceParsed = Integer.parseInt(itemPrice);
        
        itemPaidParsed = itemPaidParsed * 100;
        itemPriceParsed = itemPriceParsed * 100;
        itemRefund = itemPaidParsed - itemPriceParsed;

        return itemRefund;
    }

    public int getQuarters(int itemRefund) {
        int quartersOut;
        int quarters = 25;

        quartersOut = itemRefund % quarters;
        itemRefund = itemRefund - quartersOut;

        return quartersOut;
    }

    public int getDimes(int itemRefund) {
        int dimesOut;
        int dimes = 10;
        dimesOut = itemRefund % dimes;
        itemRefund = itemRefund - dimesOut;

        return dimesOut;
    }

    public int getNickels(int itemRefund) {
        int nickelsOut;
        int nickels = 5;
        nickelsOut = itemRefund % nickels;

        return nickelsOut;
    }

    public int getPennies(int itemRefund) {
        int penniesOut;
        int pennies = 1;
        penniesOut = itemRefund % pennies;
        itemRefund = itemRefund - penniesOut;

        return penniesOut;
    }

    public List<String> coinsOut(int itemRefund) {
        List<String> coinsOut = new ArrayList<>(itemRefund);

        String quarter = "Quarter";
        String dime = "Dime";
        String nickel = "nickel";
        String penny = "penny";


        int quartersOut;
        int dimesOut;
        int nickelsOut;
        int penniesOut;

        quartersOut = getQuarters(itemRefund);
        dimesOut = getDimes(itemRefund);
        nickelsOut = getNickels(itemRefund);
        penniesOut = getPennies(itemRefund);

        if(quartersOut > 0) {
            coinsOut.add(quarter);
        } else if (dimesOut > 0) {
            coinsOut.add(dime);
        }else if (nickelsOut > 0) {
            coinsOut.add(nickel);
        }else if (penniesOut > 0) {
            coinsOut.add(penny);
        }
        return coinsOut;
    }
}
