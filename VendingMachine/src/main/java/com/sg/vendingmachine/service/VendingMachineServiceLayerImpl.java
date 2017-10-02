package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    VendingMachineDao dao;
    VendingMachineView view;
    Change change;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineView view) {
        this.dao = dao;
        this.view = view;
        this.change = change;

    }

    @Override
    public void checkTheCash(int itemPaid, Item currentItem, String itemCode) throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException, VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        boolean vendThis = false;
        Item itemPrice;
        //chosenItem = getItem(itemCode);

        
    }

    @Override
    public Item vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, VendingMachineNoItemInInventoryException {
        Item currentItem;
        int itemInventory = 0;
        currentItem = getItem(itemCode);

        if (itemInventory == 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item"
                    + currentItem
                    + " is sold out");
        } else if (itemInventory > 0) {
            itemInventory = itemInventory - 1;
            /* validateItemData(itemCode);
            
        dao.addItem(itemCode.getItemCode(), itemCode);   */

            //       view.displayItem(itemCode);
            //change these no view          
        }
        return dao.updateItem(currentItem);
    }

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

    private void validateItemData(Item item) throws
            VendingMachineDataValidationException,
            VendingMachineDataValidationException {

        /* if (item.getItemName() == null
                || item.getItemName().trim().length() == 0
                || item.getItemPrice() == null
                || item.getItemPrice().trim().length() == 0
                || item.getItemInventory() == null
                || item.getItemInventory().trim().length() == 0
                || item.getItemCode() == null
                || item.getItemCode().trim().length() == 0) {   */
        throw new VendingMachineDataValidationException(
                "");
    }

    public int refundMoney(String itemPaid, String itemPrice, Item currentItem) throws VendingMachineInsufficientFundsException {
        int itemPriceInt;
        int amountRefunded = 0;
        int itemPaidInt;
        int userRefund;
        boolean vendThis = false;
   //     Item itemPrice;

        itemPaidInt = Integer.parseInt(itemPaid);
        itemPriceInt = Integer.parseInt(itemPrice);
  
        itemPrice = dao.getItemPrice(itemCode);
    //    while (vendThis == false) {
            //change this, it can not talk to the view directly  
            change.getCashInfo(itemPaid, itemPrice);
    //      change.getEachInPennies(itemPaid);
            //move to change    
            if (itemPaidInt < itemPriceInt) {
                throw new VendingMachineInsufficientFundsException(
                        "ERROR: Could not vend.  Money"
                        + itemPaid
                        + " paid was not sufficient");
       //         vendThis = false;
            } else if (itemPaidInt > itemPriceInt) {
 
                userRefund = itemPaidInt - itemPriceInt;
                vendThis = true;
            } else if (itemPaidInt == itemPriceInt){
                vendItem(currentItem);
                vendThis = true;
            }
   //     }
        return amountRefunded;
    }
}
