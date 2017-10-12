package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineController {

    VendingMachineView myView;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service,
            VendingMachineView myView) {
        this.myView = myView;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            try {
                listItems();
            } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineNoItemInInventoryException e) {
                Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
            }
            try {
                menuSelection = getMenuSelection();
            } catch (VendingMachineDaoException | VendingMachinePersistenceException e) {
                Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
            }

            switch (menuSelection) {
                case 1: {
                    try {
                        listItems();
                    } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineNoItemInInventoryException e) {
                        Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                break;
                case 2: {
                    try {
                        purchaseItem();
                    } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoItemInInventoryException | VendingMachineDaoException e) {
                        Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                break;
                case 3: {
                    try {
                        viewItem();
                    } catch (VendingMachineDaoException | VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineNoItemInInventoryException e) {
                        Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
                break;
                case 4:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }
        exitMessage();

    }

    private int getMenuSelection()
            throws VendingMachineDaoException,
            VendingMachinePersistenceException {

        return myView.printMenuAndGetSelection();
    }

    private void listItems()
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        myView.displayDisplayItemBanner();
        List<Item> itemList = service.getAllItems();
        myView.displayItemList(itemList);
    }

    private void purchaseItem() throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDaoException {

        List <String> cashRefund;
        String itemCode;
        Item currentItem;
        String itemMoney;
        String itemPrice;
        int userRefund;

        // the item choice section
        listItems();
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayPriceItemBanner();
        itemPrice = service.getItemPriceByCode(itemCode);
        itemMoney = myView.getPayment(itemPrice);
        
        // payment section 
        userRefund = service.checkTheCash(itemPrice, itemMoney);
     //   do{
 
     //       itemMoney = myView.getPayment(itemPrice);
      //      userRefund = service.checkTheCash(itemPrice, itemMoney);   
     //   } while (userRefund < 0);
        cashRefund = service.returnChange(userRefund);
        myView.refundMoney(cashRefund);
        myView.displayNoChangeBanner();
// Vend Item section 
        myView.displayVendingItem();
        service.vendItem(itemCode);
        myView.displayItem(currentItem);
        myView.displayVendSuccessBanner();
        exitMessage();
    }

    private void viewItem()
            throws VendingMachineDaoException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException {

        myView.displayDisplayItemBanner();
        String itemCode;
        Item currentItem;
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayItem(currentItem);
        //   service.purchaseItem(itemCode);
        //    view.displayVendingSuccessBanner();
    }

    private void unknownCommand() {
        myView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        myView.displayExitBanner();
    }

}
