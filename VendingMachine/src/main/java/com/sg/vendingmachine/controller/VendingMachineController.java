package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.VendingMachineInvalidItemCodeException;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;

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
            } catch (VendingMachinePersistenceException e) {
                myView.displayErrorMessage(e.getMessage());
            }
            try {
                menuSelection = getMenuSelection();
            } catch (VendingMachineDaoException | VendingMachinePersistenceException e) {
                myView.displayErrorMessage(e.getMessage());
            }

            switch (menuSelection) {
                case 1: {
                    try {
                        listItems();
                    } catch (VendingMachinePersistenceException e) {
                       myView.displayErrorMessage(e.getMessage());
                    }
                }
                break;
                case 2: {
                    try {
                        purchaseItem();
                    } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoItemInInventoryException | VendingMachineDaoException | VendingMachineInvalidItemCodeException e) {
                       myView.displayErrorMessage(e.getMessage());
                    }
                }
                break;
                case 3: {
                    try {
                        viewItem();
                    } catch (VendingMachinePersistenceException | VendingMachineDataValidationException | VendingMachineInvalidItemCodeException e) {
                       myView.displayErrorMessage(e.getMessage());
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
            throws VendingMachinePersistenceException{

        myView.displayDisplayItemBanner();
        List<Item> itemList = service.getAllItems();
        myView.displayItemList(itemList);
    }

    private void purchaseItem() 
            throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInInventoryException,
            VendingMachineDaoException,
            VendingMachineInvalidItemCodeException {

        List <String> cashRefund;
        String itemCode;
        Item currentItem;
        BigDecimal itemPrice;
        BigDecimal itemMoneyParsed;
        BigDecimal userRefund;

        listItems();
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayPriceItemBanner();
        itemPrice = service.getItemPriceByCode(itemCode);     
        itemMoneyParsed = myView.getPayment(itemPrice);
  
        userRefund = service.checkTheCash(itemPrice, itemMoneyParsed);   
        if(itemMoneyParsed.compareTo(itemPrice) < 0){
            myView.displayNotEnoughMessage(itemMoneyParsed);
        }else if(itemMoneyParsed.compareTo(itemPrice) >= 0){
        cashRefund = service.returnChange(itemPrice, itemMoneyParsed);
        myView.refundMoney(cashRefund);
        myView.displayVendingItem();
        service.vendItem(itemCode);
        myView.displayItem(currentItem);
        myView.displayVendSuccessBanner();
        exitMessage();
        }
    }

    private void viewItem()
            throws VendingMachinePersistenceException,
            VendingMachineInvalidItemCodeException,
            VendingMachineDataValidationException{

        myView.displayDisplayItemBanner();
        String itemCode;
        Item currentItem;
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayItem(currentItem);
    }

    private void unknownCommand() {
        myView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        myView.displayExitBanner();
    }
}