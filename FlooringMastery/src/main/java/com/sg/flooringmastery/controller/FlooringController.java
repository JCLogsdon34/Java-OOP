
package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringDataValidationException;
import com.sg.flooringmastery.service.FlooringDuplicateOrderException;
import com.sg.flooringmastery.ui.FlooringView;
import com.sg.flooringmastery.service.FlooringServiceLayer;
import java.time.LocalDate;


public class FlooringController {
    
    FlooringView view;
    private FlooringServiceLayer service;

    public FlooringController(FlooringServiceLayer service,
            FlooringView view) {
        this.view = view;
        this.service = service;
    }
    
     public void run() {
        boolean keepGoing = true;
        int menuSelection;

        while (keepGoing) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    try {
                        displayOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        addOrder();
                    } catch (FlooringPersistenceException | FlooringDuplicateIdException | FlooringDataValidationException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        editOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        removeOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        saveOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    break;
            }
        }
        exitMessage();
    }
     
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
     private void addOrder() throws FlooringPersistenceException {
        Order newOrder;
        view.displayAddBanner();
        boolean hasErrors = false;
        boolean youSure = false;
        do {
            newOrder = view.getNewOrderInfo();
            youSure = view.getAssurance();
            if(youSure == false){
            try {
                service.addOrder(newOrder);
                view.displayOrderPlacedBanner();
                view.displayOrderSuccessBanner();
                hasErrors = false;        
            } catch (FlooringDuplicateOrderException | FlooringDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
            } else {
                view.displayUnknownCommandBanner();
            }
        } while (hasErrors);
    }
     
     private void displayOrder() throws FlooringPersistenceException {
        int orderNumber;
        LocalDate date;
        Order order;
        view.displayDisplayOrderBanner();
        orderNumber = view.getOrderNumberChoice();
        date = view.getOrderDate();
        order = service.getOrder(orderNumber, date);
        view.displayOrder(order);
    }
     
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
