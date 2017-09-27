
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIoConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;


public class VendingMachineController {
    VendingMachineView view;
    VendingMachineDao dao;

    public VendingMachineController(VendingMachineDao dao, VendingMachineView view) {
        this.view = view;
        this.dao = dao;
    }

    private UserIO io = new UserIoConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listItems();
                        break;
                    case 2:
                        vendItem();
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
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection()
            throws VendingMachineDaoException , VendingMachinePersistenceException{
        return view.printMenuAndGetSelection();
    }


    private void listItems()
            throws VendingMachineDaoException, VendingMachinePersistenceException {
   //     view.displayDisplayAllBanner();
        List<Item> itemList = dao.getAllItems();
        view.displayItemList(itemList);
    }

    private void vendItem() 
            throws VendingMachineDaoException, VendingMachinePersistenceException {
 //       view.displayDisplayStudentBanner();
        String itemChoice = view.getItemCode();
        Item itemCode = dao.getItem(itemChoice);
        view.displayItem(itemCode);
        //not sure about this one
    }

    private void viewItem()
            throws VendingMachineDaoException, VendingMachinePersistenceException {
    //    view.displayRemoveStudentBanner();
        String itemCode = view.getItemCodeChoice();
        dao.viewItem(itemCode);
    //    view.displayVendingSuccessBanner();
    }
    
    private void machineMoney() throws VendingMachineDaoException, VendingMachinePersistenceException {
        BigDecimal allMoneyInMachine;
        Item itemInventory;
        
        List<Item> itemList = dao.getAllItems();
        
        
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
