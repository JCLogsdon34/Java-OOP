package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao;
    VendingMachineDao dao;
    Change change;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public BigDecimal checkTheCash(String itemMoney, String itemPrice)
            throws 
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException {

        Map<Coins, Integer> cashRefund = new HashMap<>();

        BigDecimal itemPaidBig = new BigDecimal(itemMoney);
        BigDecimal itemPriceBig = new BigDecimal(itemPrice);
        BigDecimal userRefund = null;

            /////still throws NPE 
            userRefund = change.getCashInfo(itemPriceBig, itemPaidBig);

        auditDao.writeAuditEntry(
                "Money " + cashRefund + " returned as change to user.");

        return userRefund;
    }

    @Override
    public Map<Coins, Integer> returnChange(BigDecimal userRefund)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        Map<Coins, Integer> changeRefund = new HashMap<>();
        //NPE still thrown
        changeRefund = change.getCoinWorth(userRefund);

        return changeRefund;
    }

    @Override
    public String vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {

        Item currentItem;
        int itemInventory;
        String itemInventoryString;

        currentItem = getItem(itemCode);
        validateItemData(currentItem);
        itemInventory = dao.vendAndUpdateItem(itemCode, currentItem);
        itemInventoryString = Integer.toString(itemInventory);

        auditDao.writeAuditEntry(
                "Item " + currentItem.getItemCode() + " Inventory Sent for Vending.");
        return itemInventoryString;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        return dao.getItem(itemCode);
    }

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        //throws NPE
        return dao.getItemPriceByCode(itemCode);
    }

    private void validateItemData(Item item) throws
            VendingMachineDataValidationException {

        if (item.getItemCode() == null
                || item.getItemCode().trim().length() == 0) {
            throw new VendingMachineDataValidationException(
                    "Error: Invalid Item Code Entry, try again");
        }
    }
}
