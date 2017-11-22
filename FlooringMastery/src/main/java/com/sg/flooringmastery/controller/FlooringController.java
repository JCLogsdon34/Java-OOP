package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringDataValidationException;
import com.sg.flooringmastery.service.FlooringDuplicateOrderException;
import com.sg.flooringmastery.ui.FlooringView;
import com.sg.flooringmastery.service.FlooringServiceLayer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        int menuSelection = 0;

        while (keepGoing) {
          /*      try {
                loadEverything();              
            } catch (FlooringPersistenceException e) {
                view.displayErrorMessage(e.getMessage());
            }
             */
            try {
                menuSelection = getMenuSelection();
            } catch (FlooringPersistenceException e) {
                view.displayErrorMessage(e.getMessage());
            }

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
                    } catch (FlooringDataValidationException | FlooringDuplicateOrderException | FlooringPersistenceException e) {
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
                    view.displayExitBanner();
                    exitMessage();
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
                    break;
            }
        }
    }

    private int getMenuSelection() throws FlooringPersistenceException {
        return view.printMenuAndGetSelection();
    }

    private void loadEverything() throws FlooringPersistenceException {
        service.loadTheOrders();
    }

    private void addOrder() throws
            FlooringDataValidationException,
            FlooringDuplicateOrderException,
            FlooringPersistenceException {

        Order newOrder = new Order();
        Order newerOrder = new Order();
        Order newestOrder = new Order();
        view.displayAddBanner();
        boolean hasErrors = false;
        boolean youSure = false;
        Collection <Tax> taxInfo;
        Collection<Product> productInfo;
        do {
            taxInfo = service.getAllTaxes();
            productInfo = service.getAllTheProducts();
            LocalDate dates = LocalDate.now();     
            newOrder = view.getNewOrderInfo(taxInfo, productInfo); 
            newOrder = service.getNewOrderNumber(newOrder);
            newOrder = service.getOrderCapitalCost(newOrder, taxInfo, productInfo);
            view.displayOrder(newOrder);
            youSure = view.getAssurance();
            if (youSure == true) {
                service.addOrder(dates, newOrder);
                view.displayOrderPlacedBanner();
                view.displayOrderSuccessBanner();
                hasErrors = true;
            } else if (youSure == false) {
                view.displayUnknownCommandBanner();
            }
        } while (hasErrors == false);
        
    }

    private void displayOrder() throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        LocalDate date;
        List<Order> newList = new ArrayList<>();

        view.displayDisplayOrderBanner();
        date = view.getOrderDate();
        newList = service.getOrder(date);
        if (newList.isEmpty()) {
            throw new FlooringOrdersForThatDateException("No Orders for that date");
        }
        view.displayOrderByDateList(newList);
    }

    private void removeOrder() throws FlooringPersistenceException {
        try {
            LocalDate date;
            Order order;
            int orderNumber;
            view.displayRemoveBanner();
            date = view.getOrderDate();
            orderNumber = view.getOrderNumberChoice();
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
        service.saveOrder();
        view.displaySaveBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
