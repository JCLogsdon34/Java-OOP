package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import static com.sg.vendingmachine.service.Change.coinsOut;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
    VendingMachineDao dao = new VendingMachineDaoFileImpl();


    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public BigDecimal checkTheCash(BigDecimal itemPriceBig, BigDecimal itemMoneyBig)
            throws VendingMachineInsufficientFundsException {
       BigDecimal itemRefund;
            itemRefund = itemMoneyBig.subtract(itemPriceBig); 
       if (itemRefund.compareTo(BigDecimal.ZERO) < 0) {
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemRefund
                    + " paid was not sufficient");
        }
     return itemRefund; 
       }

    @Override
    public List<String> returnChange(BigDecimal itemPrice, BigDecimal itemMoney)
            throws VendingMachineInsufficientFundsException {
        List<String> changeRefund = new ArrayList<>();
        changeRefund = coinsOut(itemPrice, itemMoney);
       /* auditDao.writeAuditEntry(
                "Money " + changeRefund + " returned as change to user.");
       */
        return changeRefund;
    }

    @Override
    public int vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException,
            VendingMachineNoItemInInventoryException {
        Item currentItem;
        int itemInventory;
        currentItem = getItem(itemCode);
        validateItemData(itemCode);
        itemInventory = dao.vendAndUpdateItem(itemCode, currentItem);
        /*auditDao.writeAuditEntry(
                "Item " + currentItem.getItemCode() + " Inventory Sent for Vending.");
        */
        return itemInventory;
    }

    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException{
        validateItemData(itemCode);
        return dao.getItem(itemCode);
    }

    @Override
    public BigDecimal getItemPriceByCode(String itemCode) {
        return dao.getItemPriceByCode(itemCode);
    }

    private void validateItemData(String itemCode) throws
            VendingMachineDataValidationException {
        if (itemCode == null
                || itemCode.trim().length() == 0)
            throw new VendingMachineDataValidationException(
                    "Error: Invalid Item Code Entry, try again");
        }
}