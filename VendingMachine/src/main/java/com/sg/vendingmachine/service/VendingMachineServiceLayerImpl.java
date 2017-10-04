package com.sg.vendingmachine.service;

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

    VendingMachineDao dao;
    VendingMachineView view;
    Change change;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;
    }

    @Override
    public int checkTheCash(BigDecimal itemPrice, BigDecimal itemPaid)
            throws VendingMachineInsufficientFundsException {
        int notEnough = 0;
        if (itemPaid.compareTo(itemPrice) < 0) {
            notEnough = -1;
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemPaid
                    + " paid was not sufficient");
        } else if (itemPaid.compareTo(itemPrice) > 0) {
            notEnough = 1;
        }
        return notEnough;
    }

    @Override
    public Map<Coins, Integer> returnChange(String itemPaid, String itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        Map<Coins, Integer> cashRefund = new HashMap<>();

        int itemRefund = change.getCashInfo(itemPrice, itemPaid);
        cashRefund = change.getCoinWorth(itemRefund);

        return cashRefund;
    }

    /*   @Override
    public int vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, VendingMachineNoItemInInventoryException {
        
        Item currentItem;
        int itemInventory = 0;
        currentItem = getItem(itemCode);
            /* validateItemData(itemCode);
            
        dao.addItem(itemCode.getItemCode(), itemCode);          
        return itemInventory;
    }
     */
    @Override
    public List<Item> getAllItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        try {
            //validateItemData(itemCode);
            dao.getAllItems();

        } catch (VendingMachinePersistenceException e) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemCode)
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {
 
        return dao.getItem(itemCode);
    }

    private void validateItemData(Item currentItem) throws
            VendingMachineDataValidationException,
            VendingMachineDataValidationException {

        if (currentItem.getItemCode() == null
                || currentItem.getItemCode().trim().length() == 0) 
                
            throw new VendingMachineDataValidationException(
                    "Invalid Code Entry, try again");
        }
    }

