package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import com.sg.flooringmastery.service.FlooringDataValidationException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FlooringView {

    private UserIo io;

    public FlooringView(UserIo io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() throws FlooringInvalidEntryException{
        io.print("<<Flooring Main Menu>>");
        io.print("1. Display Orders");
        io.print("2. Add An Order");
        io.print("3. Edit An Order");
        io.print("4. Remove An Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices.");
    }

    public Order getEdits(Order currentOrder, Collection<Tax> taxInfo, Collection<Product> productInfo) {
        boolean newInput;
        boolean keepOn;
        String originalName = currentOrder.getCustomerName();
        String customerName;
        Tax currentTax = new Tax();
        Product currentProduct = new Product();

        io.print(currentOrder.getCustomerName());
        customerName = io.readString("Please enter customer's name");

        if (customerName == null || (originalName.equalsIgnoreCase(customerName))) {
            io.print("No changes, got it");
        } else if (!originalName.equalsIgnoreCase(customerName)) {
            currentOrder.setCustomerName(customerName);
        }

        String stateTax = currentOrder.getTax().getState();
        String newTax;

        io.print(currentOrder.getTax().getState());

        io.print("The above was your State choice");
        taxInfo.stream().map((ta) -> (ta.getState())).forEach((stateChoice) -> {
            io.print(stateChoice);
        });

        newTax = io.readString("Please enter your changes regarding the state we will be working.");
     
        if (!stateTax.equalsIgnoreCase(newTax)) {
            currentTax = getTaxInformation(taxInfo);
            currentOrder.setTax(currentTax);
        } else if ((stateTax.equalsIgnoreCase(newTax) || newTax == null)) {
            io.print("No changes made");
        }

        io.print(currentOrder.getArea().toString());
        BigDecimal oldArea = currentOrder.getArea();

        BigDecimal newArea = io.readBigDecimal("Please enter your changes to the area");
        if (oldArea.equals(newArea) || newArea == null) {
            io.print("No changes here");
        } else if (!oldArea.equals(newArea)) {
            currentOrder.setArea(newArea);
        }

        io.print(currentOrder.getProduct().getProductType());

        String originalProduct = currentOrder.getProduct().getProductType();
        String newProduct;
        newProduct = io.readString("Please enter any changes you want to make to your product choice");
        
        if (newProduct.equalsIgnoreCase(originalProduct) || newProduct == null) {
            io.print("No changes made");
        } else if (!newProduct.equalsIgnoreCase(originalProduct)) {
            currentProduct = getProductInformation(productInfo);
            currentOrder.setProduct(currentProduct);
        }
        return currentOrder;
    }

    public void displayOrder(Order currentOrder) {
        if (currentOrder != null) {
            io.print(String.valueOf(currentOrder.getOrderNumber()));
            io.print(currentOrder.getCustomerName());
            io.print(currentOrder.getTax().getState());
            io.print(currentOrder.getTax().getTaxRate().toString());
            io.print(currentOrder.getTax().getTaxAmount().toString());
            io.print(currentOrder.getArea().toString());
            io.print(currentOrder.getProduct().getProductType());
            io.print(currentOrder.getProduct().getProductCostPerSqFt().toString());
            io.print(currentOrder.getProduct().getLaborCostPerSqFt().toString());
            io.print(currentOrder.getMaterialCost().toString());
            io.print(currentOrder.getLaborCost().toString());
            io.print(currentOrder.getTotal().toString());
            io.print("");
        } else {
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayOrderByDateList(List<Order> orderList) {
        orderList.stream().forEach((Order currentOrder) -> {
            io.print(String.valueOf(currentOrder.getOrderDate()));
            io.print(String.valueOf(currentOrder.getOrderNumber()));
            io.print(currentOrder.getCustomerName());
            io.print(currentOrder.getTax().getState());
            io.print(currentOrder.getTax().getTaxRate().toString());
            io.print(currentOrder.getProduct().getProductType());
            io.print(currentOrder.getProduct().getProductCostPerSqFt().toString());
            io.print(currentOrder.getProduct().getLaborCostPerSqFt().toString());
            io.print(currentOrder.getArea().toString());
            io.print(currentOrder.getMaterialCost().toString());
            io.print(currentOrder.getLaborCost().toString());
            io.print(currentOrder.getTotal().toString());
        });
        io.readString("Please hit enter to continue.");
    }

    public String getNewOrderNameInfo() {
        boolean newInput;

        String customerName;
        customerName = io.readString("Please enter customer's name");
        if (customerName != null && !customerName.isEmpty()) {
            newInput = true;
        } else {
            newInput = false;
        }
        return customerName;
    }

    public Tax getTaxInformation(Collection<Tax> taxInfo) {
        boolean stateTeller = false;
        Tax currentTax = new Tax();
        String myState;
        do{
        taxInfo.stream().map((ta) -> (ta.getState())).forEach((stateChoice) -> {
            io.print(stateChoice);
        });

        io.print("These are the states we work in right now");
        myState = io.readString("Please enter from your choice from "
                + "these postal abreiviations: ");
        
            for (Tax s : taxInfo) {

                String stateChoice = s.getState();
                if (s.getState().contentEquals(myState)) {
                   
                    stateTeller = true;
                }
            }
        } while (stateTeller == false);
        currentTax.setState(myState);
      
        
        for (Iterator<Tax> it = taxInfo.iterator(); it.hasNext();) {
            Tax ts = it.next();
            if (ts.getState().equals(myState)) {
                BigDecimal taxs = ts.getTaxRate();
                currentTax.setTaxRate(taxs);
            }
        }
        return currentTax;
    }

    public Product getProductInformation(Collection<Product> productInfo) {
        Product currentProduct = new Product();
        boolean isLeft = false;
        
        do{
        for (Product stuff : productInfo) {
            io.print(stuff.getProductType());
        }
        io.print("These are the product types we offer: ");
        String myProduct = io.readString("Please select from the above product types: ");
        
      
            for (Product ps : productInfo) {
                String myP = ps.getProductType();
                if (ps.getProductType().contentEquals(myProduct))  {
                    currentProduct.setProductType(myProduct);
                   isLeft = true;              
                }
            }
                
        
 
        for (Iterator<Product> it = productInfo.iterator(); it.hasNext();) {
            Product ps = it.next();
            if (ps.getProductType().equals(myProduct)) {
                BigDecimal prodCost = ps.getProductCostPerSqFt();
                BigDecimal labCost = ps.getLaborCostPerSqFt();
                currentProduct.setProductCostPerSqFt(prodCost);
                currentProduct.setLaborCostPerSqFt(labCost);
            }
        }
        } while (isLeft == false);
        return currentProduct;
    }

   
    public BigDecimal getArea() throws FlooringInvalidEntryException {
        BigDecimal area = io.readBigDecimal("Please enter the area you want us to lay flooring for");
        return area;
    }

    public void displayOrderMap(Map<LocalDate, List<Order>> lambdaOrderMap) {
        List<Order> orderList;
        LocalDate date;
        lambdaOrderMap.entrySet().stream().forEach((Map.Entry<LocalDate, List<Order>> e) -> {
            io.print(e.getKey() + " " + e.getValue());
        });
    }

    public int getOrderNumberChoice() throws FlooringInvalidEntryException {
        String order;
        order = io.readString("Please enter an order number");
        int orderNumber;
        orderNumber = Integer.parseInt(order);
   
        return orderNumber;
    }

    public boolean getAssurance() {
        String assurance;
        boolean youSure = false;
        assurance = io.readString("Are you sure you want to proceed? Y/N ");

        if (assurance.equalsIgnoreCase("y")) {
            youSure = true;
        } else if (assurance.equalsIgnoreCase("n")) {
            youSure = false;
        }
        return youSure;
    }

    public LocalDate getOrderDate() throws FlooringInvalidEntryException {
        LocalDate date;
        
        date = io.readLocalDate("Please enter the date of your order");
       
        return date;
    }

    public void displayAddBanner() {
        io.print("=== Place Order ===");
    }

    public void displayOrderSuccessBanner() {
        io.readString(
                "Order successfully placed.  Please hit enter to continue");
    }

    public void displayRemoveBanner() {
        io.print("=== Remove Order ===");
    }

    public void displayRemoveOrderSuccessBanner() {
        io.readString(
                "Order successfully removed.  Please hit enter to continue");
    }

    public void displayDisplayOrderBanner() {
        io.print("=== Display Order ===");
    }

    public void displaySaveBanner() {
        io.print("=== Save Successful ===");
    }

    public void displayOrderPlacedBanner() {
        io.print("=== Order Successful ===");
    }

    public void displayEditOrderBanner() {
        io.print("=== Edit an Order ===");
    }

    public void displayEditSuccessBanner() {
        io.print("=== Order Edits Successful ===");
    }

    public void displayOrderTotalBanner() {
        io.print("=== Order Total ===");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
