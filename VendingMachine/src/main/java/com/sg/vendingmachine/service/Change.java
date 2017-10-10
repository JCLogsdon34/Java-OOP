package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dto.Item;
import static com.sg.vendingmachine.service.Coins.DIME;
import static com.sg.vendingmachine.service.Coins.NICKEL;
import static com.sg.vendingmachine.service.Coins.PENNY;
import static com.sg.vendingmachine.service.Coins.QUARTER;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Change {

    private final Map<Coins, Integer> changeWorth = getCoins();

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

    public Map<Coins, Integer> getCoinWorth(BigDecimal itemRefund) {
        List<Coins> denomination = Arrays.asList(Coins.values());
        BigDecimal quartersOut;
        BigDecimal dimesOut;
        BigDecimal nickelsOut;
        BigDecimal penniesOut;
        BigDecimal changeOut;

        BigDecimal quarters = new BigDecimal(25);
        BigDecimal dimes = new BigDecimal(10);
        BigDecimal nickels = new BigDecimal(5);
        BigDecimal pennies = new BigDecimal(1);
      /*  BigDecimal remainderInQ;
          BigDecimal remainder1 = dimes.remainder(new BigDecimal(10));
        BigDecimal remainder2 = nickels.remainder(new BigDecimal(5));
        BigDecimal remainder3 = pennies.remainder(new BigDecimal(1));
         */
        Map<Coins, Integer> cashMoney = new HashMap<>();
        cashMoney.put(QUARTER, 25);
        cashMoney.put(DIME, 10);
        cashMoney.put(NICKEL, 5);
        cashMoney.put(PENNY, 1);

        for (Coins x : denomination) {

           /* switch(){
                    
            */ 
            while (itemRefund.remainder(quarters).compareTo(BigDecimal.ZERO) == 0) {

                quartersOut = itemRefund.divide(quarters, 2, RoundingMode.HALF_UP);
                cashMoney.put(QUARTER, 25);
            }
            while (itemRefund.remainder(dimes).compareTo(BigDecimal.ZERO) == 0) {

                dimesOut = itemRefund.divide(dimes, 2, RoundingMode.HALF_UP);
                cashMoney.put(DIME, 10);
            }
            while (itemRefund.remainder(nickels).compareTo(BigDecimal.ZERO) == 0) {

                nickelsOut = itemRefund.divide(nickels, 2, RoundingMode.HALF_UP);
                cashMoney.put(NICKEL, 5);
            }
            while (itemRefund.remainder(pennies).compareTo(BigDecimal.ZERO) == 0) {

                penniesOut = itemRefund.divide(pennies, 2, RoundingMode.HALF_UP);
                cashMoney.put(PENNY, 1);
            }

            cashMoney.put(x, cashMoney.get(x) + 1);
            getCoins(x, -1);
        }
        return cashMoney;
    }

    public BigDecimal getCashInfo(String itemPaid, String itemPrice) {

        BigDecimal itemRefund;

        BigDecimal itemPriceBig = new BigDecimal(itemPrice);
        BigDecimal itemPaidBig = new BigDecimal(itemPrice);

        itemRefund = itemPaidBig.subtract(itemPriceBig);
        return itemRefund;
    }

}
