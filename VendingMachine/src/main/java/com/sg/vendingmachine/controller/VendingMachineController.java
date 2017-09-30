package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineInsufficientFundsException;
import com.sg.vendingmachine.service.VendingMachineNoItemInInventoryException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIoConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineController {

    VendingMachineView myView;
//    VendingMachineDao dao;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView myView) {
        this.myView = myView;
        //    this.dao = dao;
        this.service = service;
    }

    private UserIO io = new UserIoConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            service.getAllItems();
        } catch (VendingMachinePersistenceException | VendingMachineDataValidationException e) {
            Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
        }

        try {
            while (keepGoing) {

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
                        getAdminOptions();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachinePersistenceException | VendingMachineDaoException e) {
            myView.displayErrorMessage(e.getMessage());
        } catch (VendingMachineDataValidationException e) {
            Logger.getLogger(VendingMachineController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private int getMenuSelection()
            throws VendingMachineDaoException, VendingMachinePersistenceException {
        return myView.printMenuAndGetSelection();
    }

    private void listItems()
            throws VendingMachineDaoException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        //     view.displayDisplayAllBanner();
        List<Item> itemList = service.getAllItems();
        myView.displayItemList(itemList);
    }

    private void purchaseItem() throws VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        myView.displayVendItemBanner();
        String itemCode;
        Item currentItem;
        itemCode = myView.getItemCodeChoice();    
        if (itemCode != null) {
            throw new VendingMachinePersistenceException(
                    "ERROR: Could not vend.  Item"
                    + itemCode
                    + " code is invalid");
        }
        itemCode = myView.getItemByCode();
        currentItem = service.getItem(itemCode);
        BigDecimal itemPaid = myView.getPayment();
                   service.checkTheCash(itemPaid, currentItem);
        
        
        myView.displayVendSuccessBanner();
    }

    private void vendItem()
            throws VendingMachineDaoException,
            VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineNoItemInInventoryException,
            VendingMachineInsufficientFundsException {

        Item chosenItem;
        //combine with purchase item

        chosenItem = myView.getItemByCode();
        service.getItem(chosenItem);
        service.vendItem(chosenItem);
        //   myView.displayItem(itemCode);
    }

    private void viewItem()
            throws VendingMachineDaoException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        myView.displayDisplayItemBanner();
        String itemCode;
        Item currentItem;
        itemCode = myView.getItemByCode();
        currentItem = service.getItem(itemCode);
        myView.displayItem(currentItem);
        //   service.purchaseItem(itemCode);
        //    view.displayVendingSuccessBanner();
    }

    private void getAdminOptions()
            throws VendingMachineDaoException, VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        int optionChoice;
        String itemCode = null;
        Item currentItem = null;
        int itemInventory;
        List<Item> itemList = service.getAllItems();
        myView.displayAdminOptionsBanner();
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);

        optionChoice = myView.getItemForAdminOptions(itemCode, currentItem);
        //write this menu down in the view 

        myView.displayAdminChangeSuccessBanner();

    }

    private void unknownCommand() {
        myView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        myView.displayExitBanner();
    }

}
