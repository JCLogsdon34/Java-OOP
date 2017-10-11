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
        
        Map<Coins, Integer> cashMoney = new HashMap<>();
        cashMoney.put(QUARTER, 25);
        cashMoney.put(DIME, 10);
        cashMoney.put(NICKEL, 5);
        cashMoney.put(PENNY, 1);

        BigDecimal quartersOut;
        BigDecimal dimesOut;
        BigDecimal nickelsOut;
        BigDecimal penniesOut;

        BigDecimal quarters = new BigDecimal(25);
        BigDecimal dimes = new BigDecimal(10);
        BigDecimal nickels = new BigDecimal(5);
        BigDecimal pennies = new BigDecimal(1);

        quartersOut = itemRefund.remainder(quarters);
        itemRefund = itemRefund.subtract(quartersOut);

        dimesOut = itemRefund.remainder(dimes);
        itemRefund = itemRefund.subtract(dimesOut);

        nickelsOut = itemRefund.remainder(nickels);
        itemRefund = itemRefund.subtract(nickelsOut);

        penniesOut = itemRefund.remainder(pennies);
        itemRefund = itemRefund.subtract(penniesOut);

        for (Coins x : denomination) {
            BigDecimal coinage = new BigDecimal(x.valueInPennies);
            do {
                cashMoney.put(x, cashMoney.get(x) + 1);
                getCoins(x, 0);
            } while (itemRefund.compareTo(coinage) > -1);
        }
        return cashMoney;
    }

    public BigDecimal getCashInfo(BigDecimal itemPaidBig, BigDecimal itemPriceBig)
            throws VendingMachineInsufficientFundsException {

        BigDecimal itemRefund;

        if (itemPaidBig.compareTo(itemPriceBig) < 0) {
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemPaidBig
                    + " paid was not sufficient");
        } else {
            itemRefund = itemPaidBig.subtract(itemPriceBig);
        }
        return itemRefund;
    }
}
