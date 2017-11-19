package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringDataValidationException;
import com.sg.flooringmastery.service.FlooringDuplicateOrderException;
import com.sg.flooringmastery.ui.FlooringView;
import com.sg.flooringmastery.service.FlooringServiceLayer;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        while (keepGoing = true) {
            menuSelection = getMenuSelection();
            switch (menuSelection) {
                case 1:
                    try {
                        displayOrder();
                    } catch (FlooringPersistenceException | FlooringOrdersForThatDateException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        addOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    } catch (FlooringDataValidationException | FlooringDuplicateOrderException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
                    break;
                case 3: {
                    try {
                        editOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    }
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

    private void addOrder() throws FlooringPersistenceException, FlooringDataValidationException, FlooringDuplicateOrderException {
        Order newOrder;
        view.displayAddBanner();
        boolean hasErrors = false;
        boolean youSure = false;
        do {
            newOrder = view.getNewOrderInfo();
            newOrder = service.getOrderCapitalCost(newOrder);
            view.displayOrder(newOrder);
            youSure = view.getAssurance();
            if (youSure == true) {
                service.addOrder(newOrder);
                view.displayOrderPlacedBanner();
                view.displayOrderSuccessBanner();
                hasErrors = true;
            } else {
                view.displayUnknownCommandBanner();
            }

        } while (hasErrors = false);
    }

    private void displayOrder() throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        int orderNumber;
        LocalDate date;
        Order order;
        List<Order> newList;
        view.displayDisplayOrderBanner();
        date = view.getOrderDate();
        newList = service.getOrder(date);
        if (!newList.isEmpty()) {
            view.displayOrderByDateList(newList);
        }
    }

    private void removeOrder() throws FlooringPersistenceException {
        try {
            LocalDate date;
            Order order;
            int orderNumber;
            view.displayRemoveBanner();
            date = view.getOrderDate();
            orderNumber = view.getOrderNumber();
            service.removeOrder(date, orderNumber);
            view.displayRemoveOrderSuccessBanner();
        } catch (FlooringOrdersForThatDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editOrder() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void saveOrder() throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
