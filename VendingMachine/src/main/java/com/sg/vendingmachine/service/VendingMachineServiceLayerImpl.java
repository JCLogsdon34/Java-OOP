package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineAuditDaoImpl;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.math.RoundingMode.HALF_UP;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    Change change = new Change();

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public BigDecimal checkTheCash(BigDecimal itemPriceBig, BigDecimal itemMoneyBig)
            throws
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException {

       BigDecimal itemRefund;
       BigDecimal refundScale;
            
            itemRefund = itemMoneyBig.subtract(itemPriceBig); 
            refundScale = itemRefund.setScale( 2, RoundingMode.HALF_UP);
       if (itemRefund.compareTo(BigDecimal.ZERO) < 1) {
           
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemRefund
                    + " paid was not sufficient");
        }
     return refundScale; 
       }

    @Override
    public List<String> returnChange(BigDecimal itemPrice, BigDecimal itemMoney)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        List<String> changeRefund = new ArrayList<>();

        changeRefund = change.coinsOut(itemPrice, itemMoney);
        
        auditDao.writeAuditEntry(
                "Money " + changeRefund + " returned as change to user.");

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
    public BigDecimal getItemPriceByCode(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {

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
