package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import static com.sg.vendingmachine.service.Coins.DIME;
import static com.sg.vendingmachine.service.Coins.NICKEL;
import static com.sg.vendingmachine.service.Coins.PENNY;
import static com.sg.vendingmachine.service.Coins.QUARTER;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Change {
    
    private final Map<Coins, Integer> changeWorth = getCoins();

    /*  public void getChange() {
        this.changeWorth = new changeWorth;   
    }
     */
    private static Map<Coins, Integer> getCoins() {
        Map<Coins, Integer> cashMoney = new HashMap<>();
        for (Coins x : Coins.values()) {
            cashMoney.put(x, 0);
        }
        return cashMoney;
    }

    public void getCoins(Coins denomination, int worth) {
        changeWorth.put(denomination, worth + getMoneyIn(denomination));
    }

    public int getMoneyIn(Coins denomination) {
        return changeWorth.get(denomination);
    }

    public Map<Coins, Integer> getCoinWorth(int itemRefund) {
        List<Coins> denomination = Arrays.asList(Coins.values());

        Map<Coins, Integer> cashMoney = new HashMap<>();
        cashMoney.put(QUARTER, 25);
        cashMoney.put(DIME, 10);
        cashMoney.put(NICKEL, 5);
        cashMoney.put(PENNY, 1);

        for (Coins x : denomination) {
           while((getMoneyIn(x) > -1) && (itemRefund > x.valueInPennies));               
               itemRefund = itemRefund % x.valueInPennies;
                cashMoney.put(x, cashMoney.get(x) + 1);
                getCoins(x, -1);
        }
        return cashMoney;
    }
    
    public int getCashInfo(String itemPaid, String itemPrice) {
        int itemPriceInt;
        int itemPaidInt;
        int itemRefund;
        
        itemPriceInt = Integer.parseInt(itemPrice);
        itemPaidInt = Integer.parseInt(itemPrice);
        
        itemRefund = itemPaidInt - itemPriceInt;
        
        return itemRefund;
    }

}
