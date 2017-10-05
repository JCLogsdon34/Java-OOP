package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
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
    public void checkTheCash(String itemMoney, String itemPrice)
            throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException, 
            VendingMachineDataValidationException, 
            VendingMachineNoItemInInventoryException {
        
        Map<Coins, Integer> cashRefund = new HashMap<>();
        int notEnough = 0;
        BigDecimal itemPayment = new BigDecimal(itemMoney);
        BigDecimal itemPriceBig = new BigDecimal(itemPrice);
        if (itemPayment.compareTo(itemPriceBig) < 0) {
            notEnough = -1;
            throw new VendingMachineInsufficientFundsException(
                    "ERROR: Could not vend.  Money"
                    + itemMoney
                    + " paid was not sufficient");
            } 
               cashRefund = returnChange(itemMoney, itemPrice);
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

       @Override
    public int vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, 
            VendingMachineNoItemInInventoryException {
        
        Item currentItem;
        int itemInventory = 0;
        
        currentItem = getItem(itemCode);
        validateItemData(currentItem);
        dao.vendAndUpdateItem(itemCode, currentItem);           
        return itemInventory;
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
            VendingMachineDataValidationException{
        String itemPrice = null;
        
        try {          
            itemPrice = dao.getItemPrice(itemCode);                      
        } catch (VendingMachineDaoException e) {
            Logger.getLogger(VendingMachineServiceLayerImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return itemPrice;
    }

    private void validateItemData(Item currentItem) throws
            VendingMachineDataValidationException {

        if (currentItem.getItemCode() == null
                || currentItem.getItemCode().trim().length() == 0) 
                
            throw new VendingMachineDataValidationException(
                    "Invalid Code Entry, try again");
        }
    }

