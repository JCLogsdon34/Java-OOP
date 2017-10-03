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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendingMachineController {

    VendingMachineView myView;
    VendingMachineDao dao;
    private VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, 
            VendingMachineView myView, VendingMachineDao dao) {
        this.myView = myView;
           this.dao = dao;
        this.service = service;
    }

    private UserIO io = new UserIoConsoleImpl();

    public void run() {
        
        boolean keepGoing = true;
        int menuSelection = 0;

        try {
            while (keepGoing) {
            service.getAllItems();
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
            VendingMachineDataValidationException {
        myView.displayDisplayItemBanner();
        List<Item> itemList = service.getAllItems();
        myView.displayItemList(itemList);
    }

    private void purchaseItem() throws VendingMachinePersistenceException,
            VendingMachineDataValidationException,
            VendingMachineInsufficientFundsException,
            VendingMachineNoItemInInventoryException {
        
        myView.displayVendItemBanner();
         Map<Coins, Integer> cashRefund = new HashMap<>();
        String itemCode;
        Item currentItem;
        String itemMoney;
        String itemPrice;
        int notEnough;
        int userRefundInt;
 
        
 // the item choice section
        itemCode = myView.getItemCodeChoice();    
        if (itemCode == null) {
            throw new VendingMachinePersistenceException(
                    "ERROR: Could not vend.  Item"
                    + itemCode
                    + " code is invalid");
        } else {                

        currentItem = service.getItem(itemCode);
        myView.displayPriceItemBanner();    
        itemPrice = dao.getItemPrice(itemCode);  
        
 // payment section
        itemMoney = myView.getPayment(itemPrice);

        BigDecimal itemPayment = new BigDecimal(itemMoney);
        BigDecimal itemPriceBig = new BigDecimal(itemPrice);

        notEnough = service.checkTheCash(itemPriceBig, itemPayment);
            if(notEnough == 1){
                cashRefund = service.returnChange(itemMoney, itemPrice);
                myView.refundMoney(cashRefund);
            } else if ( notEnough == -1){
                userRefundInt = 0;
                BigDecimal userRefund = new BigDecimal(userRefundInt);
                myView.displayNoChangeBanner();
            }    
  // Vend Item section 
        myView.displayVendingItem();
        service.vendItem(itemCode);
      /*
        Blend these two methods somehow
       */      
        dao.updateItem(itemCode, currentItem);
        
        ///write a new method for updateing an item, pull the inventory up
        myView.displayItem(currentItem);         
        myView.displayVendSuccessBanner();
        }
    }

    private void viewItem()
            throws VendingMachineDaoException, VendingMachinePersistenceException, VendingMachineDataValidationException {
        myView.displayDisplayItemBanner();
        String itemCode;
        Item currentItem;
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        myView.displayItem(currentItem);
        //   service.purchaseItem(itemCode);
        //    view.displayVendingSuccessBanner();
    }

    private void getAdminOptions()
            throws VendingMachineDaoException, VendingMachinePersistenceException,
            VendingMachineDataValidationException {

        String itemCode = null;
        Item currentItem = null;
        
        myView.displayAdminOptionsBanner();
        List<Item> itemList = service.getAllItems();       
        itemCode = myView.getItemCodeChoice();
        currentItem = service.getItem(itemCode);
        currentItem = myView.getItemForAdminOptions(itemCode, currentItem);
        myView.displayAdminChangeSuccessBanner();
    }

    private void unknownCommand() {
        myView.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        myView.displayExitBanner();
    }

}
