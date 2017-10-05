package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.Coins;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIoConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private UserIO io = new UserIoConsoleImpl();

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
                listItems();
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        purchaseItem();
                        break;
                    case 3:
                        viewItem();
                        break;
                    case 4:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException | VendingMachineDaoException e) {
            myView.displayErrorMessage(e.getMessage());
        } catch (VendingMachineDataValidationException | VendingMachineInsufficientFundsException | VendingMachineNoItemInInventoryException e) {
            Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private int getMenuSelection()
            throws VendingMachineDaoException, VendingMachinePersistenceException {
        return myView.printMenuAndGetSelection();
    }

    private void listItems()
            throws VendingMachineDaoException,
            VendingMachinePersistenceException,
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

        Map<Coins, Integer> cashRefund = new HashMap<>();
        String itemCode;
        Item currentItem;
        String itemMoney;
        String itemPrice;
        int notEnough;

        // the item choice section
        listItems();
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayPriceItemBanner();
        itemPrice = service.getItemPriceByCode(itemCode);

 // payment section
        itemMoney = myView.getPayment(itemPrice);
        service.checkTheCash(itemPrice, itemMoney);
        myView.refundMoney(cashRefund);
        myView.displayNoChangeBanner();
// Vend Item section 
        myView.displayVendingItem();
        service.vendItem(itemCode);
        myView.displayItem(currentItem);
        myView.displayVendSuccessBanner();
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
