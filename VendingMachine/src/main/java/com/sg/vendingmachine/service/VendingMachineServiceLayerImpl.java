package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public String vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, 
            VendingMachineNoItemInInventoryException {
        
        Item currentItem;
        String itemInventory;
        
        currentItem = getItem(itemCode);
        validateItemData(currentItem);
        itemInventory = dao.vendAndUpdateItem(itemCode, currentItem);           
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
        
        itemPrice = dao.getItemPriceByCode(itemCode);
        return itemPrice;
    }

    private void validateItemData(Item item) throws
            VendingMachineDataValidationException {

        if (item.getItemCode() == null
                || item.getItemCode().trim().length() == 0) 
                
            throw new VendingMachineDataValidationException(
                    "Invalid Code Entry, try again");
        }
    }

