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
import com.sg.flooringmastery.ui.FlooringInvalidEntryException;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlooringController {

    FlooringView view;
    private FlooringServiceLayer service;

    public FlooringController(FlooringServiceLayer service,
            FlooringView view) {  
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
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

    private int getMenuSelection() throws FlooringPersistenceException, FlooringInvalidEntryException {
        return view.printMenuAndGetSelection();
    }

    private void addOrder() throws
            FlooringDataValidationException,
            FlooringDuplicateOrderException,
            FlooringPersistenceException,
            FlooringInvalidEntryException{

        Order currentOrder = new Order();
        Tax currentTax = new Tax();
        Product currentProduct = new Product();
        view.displayAddBanner();
        int orderNumber;
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
        BigDecimal totalMaterial = service.getMaterial(currentProduct, area).setScale(2, HALF_UP);
        BigDecimal totalLabor = service.getLabor(currentProduct, area).setScale(2, HALF_UP);
        BigDecimal totalSineTax = service.getTotalSineTax(totalMaterial, totalLabor).setScale(2, HALF_UP);
        BigDecimal taxAmount = service.getTaxesForOrder(currentTax, totalSineTax).setScale(2, HALF_UP);
        currentTax.setTaxAmount(taxAmount);
        BigDecimal total = service.getOrderCapitalCost(taxAmount, totalSineTax).setScale(2, HALF_UP);

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
        } else if (youSure != true) {
            view.displayUnknownCommandBanner();
        }
    }

    private void displayOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        LocalDate date = null;
        List <Order> newList = new ArrayList<>();

        view.displayDisplayOrderBanner();
        date=view.getOrderDate();
        
        newList=service.getOrder(date);
        if(!newList.isEmpty()){
        view.displayOrderByDateList(newList);
        } else {
            System.out.print("No order for that date");
        }
    }

    private void removeOrder() throws FlooringPersistenceException, FlooringDuplicateOrderException, FlooringDataValidationException {
        try {
            LocalDate date;
            List<Order> newList;
            Order currentOrder = new Order();
            int orderNumber;
            boolean youSure;

            view.displayRemoveBanner();
            date = view.getOrderDate();
            orderNumber = view.getOrderNumberChoice();
            newList = service.getOrder(date);
            currentOrder = service.getOrderForEdit(date, newList, orderNumber);

            view.displayOrder(currentOrder);
            youSure = view.getAssurance();
            if (youSure == true) {
                service.removeOrder(date, newList, orderNumber);
                view.displayRemoveOrderSuccessBanner();
                
            } else if (youSure != true) {
                view.displayUnknownCommandBanner();
            }
        } catch (FlooringNoOrdersForThatDateException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void editOrder() throws FlooringPersistenceException, FlooringDuplicateOrderException, FlooringDataValidationException {
        try {
            boolean youSure = false;
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
            currentOrder = service.getOrderForEdit(date, orderToday, orderNumber);
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