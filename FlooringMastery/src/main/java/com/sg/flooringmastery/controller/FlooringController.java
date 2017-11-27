package com.sg.flooringmastery.controller;

import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringDataValidationException;
import com.sg.flooringmastery.service.FlooringDuplicateOrderException;
import com.sg.flooringmastery.ui.FlooringView;
import com.sg.flooringmastery.service.FlooringServiceLayer;
import java.math.BigDecimal;
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
    
    public String selectMode(){
        String mode = null;
        mode = view.getMode();
        return mode;
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
                    } catch (FlooringPersistenceException | FlooringNoOrdersForThatDateException e) {
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
                    } catch (FlooringDuplicateOrderException | FlooringDataValidationException e) {
                        view.displayErrorMessage(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        removeOrder();
                    } catch (FlooringPersistenceException e) {
                        view.displayErrorMessage(e.getMessage());
                    } catch (FlooringDuplicateOrderException | FlooringDataValidationException e) {
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

        Order currentOrder = new Order();
        Tax currentTax = new Tax();
        Product currentProduct = new Product();
        view.displayAddBanner();
        int orderNumber;
        boolean hasErrors = false;
        boolean youSure = false;
        String customerName;

        Collection<Tax> taxInfo;
        Collection<Product> productInfo;

        taxInfo = service.getAllTaxes();
        productInfo = service.getAllTheProducts();
        LocalDate dates = LocalDate.now();
        orderNumber = service.getNewOrderNumber();
        customerName = view.getNewOrderNameInfo();
        currentTax = view.getTaxInformation(taxInfo);
        currentProduct = view.getProductInformation(productInfo);
        BigDecimal area = view.getArea();
        BigDecimal totalMaterial = service.getMaterial(currentProduct, area);
        BigDecimal totalLabor = service.getLabor(currentProduct, area);
        BigDecimal totalSineTax = service.getTotalSineTax(totalMaterial, totalLabor);
        BigDecimal taxAmount = service.getTaxesForOrder(currentTax, totalSineTax);
        currentTax.setTaxAmount(taxAmount);
        BigDecimal total = service.getOrderCapitalCost(taxAmount, totalSineTax);

        currentOrder.setOrderDate(dates);
        currentOrder.setOrderNumber(orderNumber);
        currentOrder.setCustomerName(customerName);
        currentOrder.setArea(area);
        currentOrder.setTax(currentTax);
        currentOrder.setProduct(currentProduct);
        currentOrder.setMaterialCost(totalMaterial);
        currentOrder.setLaborCost(totalLabor);
        currentOrder.setTotal(total);

        view.displayOrder(currentOrder);
        youSure = view.getAssurance();
        if (youSure == true) {
            service.addOrder(dates, currentOrder);
            view.displayOrderPlacedBanner();
            view.displayOrderSuccessBanner();
            //               hasErrors = true;
        } else if (youSure != true) {
            view.displayUnknownCommandBanner();
        }
    }

    private void displayOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        LocalDate date;
        List <Order> newList = new ArrayList<>();

        view.displayDisplayOrderBanner();
        date = view.getOrderDate();
        
        newList = service.getOrder(date);
        if(!newList.isEmpty()){
        view.displayOrderByDateList(newList);
        } else if (newList.isEmpty()){
            System.out.print("No order for that date");
        }
    }

    private void removeOrder() throws FlooringPersistenceException, FlooringDuplicateOrderException, FlooringDataValidationException {
        try {
            LocalDate date;
            List<Order> newList;
            Order currentOrder;
            int orderNumber;
            boolean youSure;

            view.displayRemoveBanner();
            date = view.getOrderDate();
            orderNumber = view.getOrderNumberChoice();
            newList = service.getOrder(date);
            currentOrder = service.getOneOrder(newList, orderNumber);

            view.displayOrder(currentOrder);
            youSure = view.getAssurance();
            if (youSure == true) {
                service.addOrder(date, currentOrder);
                view.displayRemoveOrderSuccessBanner();
            } else if (youSure != true) {
                view.displayUnknownCommandBanner();
            }
            service.removeOrder(date, orderNumber);
        } catch (FlooringNoOrdersForThatDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editOrder() throws FlooringPersistenceException, FlooringDuplicateOrderException, FlooringDataValidationException {
        try {
            Tax currentTax;
            Product currentProduct;
            boolean hasErrors = false;
            boolean youSure = false;
            String customerName;
            Collection<Tax> taxInfo;
            Collection<Product> productInfo;
            LocalDate date;
            Order currentOrder;
            int orderNumber;
            List<Order> orderToday = new ArrayList<>();

            view.displayEditOrderBanner();
            taxInfo = service.getAllTaxes();
            productInfo = service.getAllTheProducts();
            date = view.getOrderDate();
            orderToday = service.getOrder(date);
            orderNumber = view.getOrderNumberChoice();
            currentOrder = service.getOrderForEdit(orderToday, orderNumber);
            currentOrder = view.getEdits(currentOrder, taxInfo, productInfo);

            youSure = view.getAssurance();
            if (youSure == true) {
                service.updateAnOrder(date, currentOrder);
                view.displayOrderPlacedBanner();
            } else if (youSure != true) {
                view.displayUnknownCommandBanner();
            }

        } catch (FlooringNoOrdersForThatDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.displayEditSuccessBanner();
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
