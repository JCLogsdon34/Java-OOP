
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachineDaoException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIoConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
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
                        createItem();
                        break;
                    case 3:
                        viewItem();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (VendingMachineDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }


    private void listStudents() throws VendingMachineDaoException {
   //     view.displayDisplayAllBanner();
        List<Item> itemList = dao.getAllItems();
        view.displayItemList(itemList);
    }

    private void viewItem() throws VendingMachineDaoException {
 //       view.displayDisplayStudentBanner();
        String itemChoice = view.getItemChoice();
        Item item = dao.getItem(itemChoice);
        view.displayItem(itemChoice);
        //not sure about this one
    }

    private void removeItem() throws VendingMachineDaoException {
    //    view.displayRemoveStudentBanner();
        String itemName = view.getItemNameChoice();
        dao.removeItem(itemName);
    //    view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
