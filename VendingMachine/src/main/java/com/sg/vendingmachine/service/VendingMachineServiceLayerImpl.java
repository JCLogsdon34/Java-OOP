package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    Change change = new Change();

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public int checkTheCash(String itemMoney, String itemPrice)
            throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException {

        /////throws NumberFormatException
        int itemRefund;

        itemRefund = change.getCashInfo(itemPrice, itemMoney);

        List<String> coinsRefund = new ArrayList<>(itemRefund);
        if (itemRefund < 0) {
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemRefund
                    + " paid was not sufficient");
        }
        auditDao.writeAuditEntry(
                "Money " + itemRefund + " returned as change to user.");

        return itemRefund;
    }

    @Override
    public List<String> returnChange(int userRefund)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        List<String> changeRefund = new ArrayList<>(userRefund);
        //out of memory java heap space
        changeRefund = change.coinsOut(userRefund);

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
        validateItemData(itemCode);
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

        validateItemData(itemCode);

        return dao.getItem(itemCode);
    }

    @Override
    public String getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        return dao.getItemPriceByCode(itemCode);
    }

    private void validateItemData(String itemCode) throws
            VendingMachineDataValidationException {

        if (itemCode == null
                || itemCode.trim().length() == 0
                || itemCode.length() > 3) {
            //improve this
            throw new VendingMachineDataValidationException(
                    "Error: Invalid Item Code Entry, try again");
        }
    }
}
