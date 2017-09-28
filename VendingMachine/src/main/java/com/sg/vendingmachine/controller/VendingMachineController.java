package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
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
        //     this.dao = dao;
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
                        machineMoney();
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

    private void purchaseItem() {
        myView.getItemCodeChoice();
        myView.getItemCode();
    }

    private void vendItem()
            //Tie everything together here I think
            throws VendingMachineDaoException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        //       view.displayDisplayStudentBanner();

        String itemChoice = myView.getItemCode();
        Item itemCode = service.getItem(itemChoice);
     //   myView.displayItem(itemCode);
        //not sure about this one
    }

    private void viewItem()
            throws VendingMachineDaoException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        //    view.displayRemoveStudentBanner();
        String itemCode = myView.getItemCodeChoice();
        //   service.purchaseItem(itemCode);
        //    view.displayVendingSuccessBanner();
    }

    private void machineMoney()
            throws VendingMachineDaoException, VendingMachinePersistenceException,
            VendingMachineDataValidationException {
        String optionChoice;
        String itemCode = null;
        Item currentItem = null;
        BigDecimal allMoneyInMachine;
        int itemInventory;
        List<Item> itemList = service.getAllItems();
        myView.displayAdminOptionsBanner();
        itemCode = myView.getItemCode();
        currentItem = service.getItem(itemCode);
        optionChoice = myView.getItemForAdminOptions(itemCode, currentItem);
        currentItem = service.getItem(itemCode);

        myView.displayAdminChangeSuccessBanner();

    }

    private void unknownCommand() {
        myView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        myView.displayExitBanner();
    }

}
