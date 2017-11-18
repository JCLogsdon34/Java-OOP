
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


public class FlooringView {
    
    private UserIo io;

    public FlooringView(UserIo io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("<<Flooring Main Menu>>");
        io.print("1. Display Orders");
        io.print("2. Add An Order");
        io.print("3. Edit An Order");
        io.print("4. Remove An Order");
        io.print("5. Save Current Work");
        io.print("6. Quit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }
    
    public void displayOrder(Order currentOrder) {
        if (currentOrder != null) {
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
            io.print("");
        } else {
            io.print("No such order.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayOrderByDateList(List<Order> orderList) {
        orderList.stream().forEach((Order currentOrder) -> {
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
    
    public Order getNewOrderInfo() {
        Order currentOrder = new Order();
        Tax currentTax = new Tax();
        Product currentProduct = new Product();
        boolean newInput;
        String theOrderDate;
        do {
            String customerName;
            customerName = io.readString("Please enter customer's name");
            if (customerName != null && !customerName.isEmpty()) {
                currentOrder.setCustomerName(customerName);
                newInput = true;
            } else {
                newInput = false;
            }
        } while (newInput == false);
        
        String numberYear = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        numberYear = io.readString("Please enter a transaction date MM-dd-yyyy");
        LocalDate date = LocalDate.parse(numberYear, formatter);
        currentOrder.setOrderDate(date);
        String state = io.readString("Please enter the state in which we will work"
                + "OH, TN, KY, IN");
        currentOrder.getTax().setState(state);
        BigDecimal theTax = currentOrder.getTax().getTaxRate();
        currentOrder.getTax().setTaxRate(theTax);
        String productType = io.readString("Please enter the product's type");
        currentOrder.getProduct().setProductType(productType);
        BigDecimal materialCost = currentOrder.getProduct().getProductCostPerSqFt();
        currentOrder.getProduct().setProductCostPerSqFt(materialCost);
        BigDecimal laborCost = currentOrder.getProduct().getLaborCostPerSqFt();
        currentOrder.getProduct().setLaborCostPerSqFt(laborCost);
        BigDecimal area = io.readBigDecimal("Please enter the area you want us to lay flooring for");
        currentOrder.setArea(area);
        return currentOrder;
    }
    
    public void displayOrderMap(Map<String, List<Order>> lambdaOrderMap) {
        List <Order> orderList;
        lambdaOrderMap.entrySet().stream().forEach((Map.Entry<String, List<Order>> e) -> {
            io.print(e.getKey() + " " + e.getValue());
        });
    }

    public int getOrderNumberChoice() {
        String order;
        order = io.readString("Please enter an order number");
         int orderNumber;
         orderNumber = Integer.parseInt(order);
         return orderNumber;
    }
    
    public boolean getAssurance(){
        String assurance;
        boolean certain = false;
        assurance = io.readString("Are you sure you want to proceed?");
        if(assurance.equals("y")){
            certain = false;
        } else if(!assurance.equals("y")) {
            certain = true;
        } 
        return certain;
        }
    
    public LocalDate getOrderDate(){
        return io.readLocalDate("Please enter the date of your order");
    }
    
    public void displayAddBanner(){
        io.print("=== Place Order ===");
    }
    
    public void displayOrderSuccessBanner() {
        io.readString(
                "Order successfully placed.  Please hit enter to continue");
    }

    public void displayDisplayOrderBanner() {
        io.print("=== Display Order ===");
    }

    public void displayOrderPlacedBanner() {
        io.print("=== Order Successful ===");
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
