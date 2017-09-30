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

    public void checkTheCash(int itemPaid, Item currentItem) throws VendingMachineInsufficientFundsException,
            VendingMachinePersistenceException, VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        boolean vendThis = false;
        Item itemPrice;
        String chosenItem;
        //chosenItem = getItem(itemCode);

        itemPrice = getItemPrice(itemCode);

        while (vendThis == false) {
            //change this, it can not talk to the view directly  
            int whichOption = 0;
            whichOption = change.getCashInfo(itemPaid, itemPrice);
            change.getEachInPennies(itemPaid);

            //move to change    
            Switch(whichOption) {
            
            case 1:
                 if(whichOption = 1);
              vendThis = true;
              vendItem(itemCode);             
                break;
            case 2:   
            whichOption = 2;
            if (itemPaid < itemPrice) {
                throw new VendingMachineInsufficientFundsException(
                        "ERROR: Could not vend.  Money"
                        + bigPaid
                        + " paid was not sufficient");
                vendThis = false;
            }
                break;
            case 3:
            whichOption = 3;
             if (itemPaid > itemPrice) {
                refundMoney(bigPaid, itemPrice);
                vendThis = true;
                break;
            }
            default:
                throw new VendingMachineInsufficientFundsException(
                        "ERROR: Could not vend.  Money"
                        + bigPaid
                        + " paid was not sufficient");
                vendThis = false;
                break;
            }
        }
    }

    //use to update inventory and vend
    @Override
    public void vendItem(String itemCode)
            throws VendingMachineDataValidationException,
            VendingMachinePersistenceException, VendingMachineNoItemInInventoryException {
        int itemInventory = 0;
        Item chosenItem = null;

        if (itemInventory == 0) {
            throw new VendingMachineNoItemInInventoryException(
                    "ERROR: Could not vend.  Item"
                    + chosenItem
                    + " is sold out");
        } else if (itemInventory > 0) {
            itemInventory = itemInventory - 1;
            /* validateItemData(itemCode);
            
        dao.addItem(itemCode.getItemCode(), itemCode);   */

            //       view.displayItem(itemCode);
            //change these no view          
        }
        chosenItem = dao.updateItem(itemCode);
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

    public int refundMoney(int itemPaid, String itemPrice) {
        int itemPriceInt;
        int amountRefunded = 0;

        itemPriceInt = Integer.parseInt(itemPrice);
        return amountRefunded;
    }
}
