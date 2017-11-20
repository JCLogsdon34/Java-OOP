
package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
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

        return io.readInt("Please select from the above choices.");
    }
    
    public void displayOrder(Order currentOrder) {
        if (currentOrder != null) {
            io.print(String.valueOf(currentOrder.getOrderNumber()));
            io.print(currentOrder.getCustomerName());
            io.print(currentOrder.getTax().getState());
            io.print(currentOrder.getTax().getTaxRate().toString());
            io.print(currentOrder.getArea().toString());
            io.print(currentOrder.getProduct().getProductType());
            io.print(currentOrder.getProduct().getProductCostPerSqFt().toString());
            io.print(currentOrder.getProduct().getLaborCostPerSqFt().toString());
            io.print(currentOrder.getMaterialCost().toString());
            io.print(currentOrder.getLaborCost().toString());
            io.print(currentOrder.getTax().getTaxAmount().toString());
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
        
        String state = io.readString("Please enter the state in which we will work"
                + " OH, TN, KY, IN");
        currentOrder.getTax().setState(state);
        BigDecimal theTax = currentOrder.getTax().getTaxRate();
        currentOrder.getTax().setTaxRate(theTax);
        String productType = io.readString("Please select a product type: Laminate, Tile, or Wood.");
        currentOrder.getProduct().setProductType(productType);
        BigDecimal materialCost = currentOrder.getProduct().getProductCostPerSqFt();
        currentOrder.getProduct().setProductCostPerSqFt(materialCost);
        BigDecimal laborCost = currentOrder.getProduct().getLaborCostPerSqFt();
        currentOrder.getProduct().setLaborCostPerSqFt(laborCost);
        BigDecimal area = io.readBigDecimal("Please enter the area you want us to lay flooring for");
        currentOrder.setArea(area);
        return currentOrder;
    }
    
    public void displayOrderMap(Map<LocalDate, List<Order>> lambdaOrderMap) {
        List <Order> orderList;
        LocalDate date;
        lambdaOrderMap.entrySet().stream().forEach((Map.Entry<LocalDate, List<Order>> e) -> {
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
        LocalDate date;
        date = io.readLocalDate("Please enter the date of your order");      
       return date;
    }
    
    public int getOrderNumber(){
        int orderNumber;
        String input;
         input = io.readString("Please enter the date of your order");
         orderNumber = Integer.parseInt(input);
         return orderNumber;
    }
    
    public void displayAddBanner(){
        io.print("=== Place Order ===");
    }
    
    public void displayOrderSuccessBanner() {
        io.readString(
                "Order successfully placed.  Please hit enter to continue");
    }
    
    public void displayRemoveBanner(){
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
