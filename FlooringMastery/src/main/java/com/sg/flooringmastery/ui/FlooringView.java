package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
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

    public Order getNewOrderInfo(Collection<Tax> taxInfo, Collection<Product> productInfo) {
        Order currentOrder = new Order();
        boolean newInput;
        String theOrderDate;
        String myState;
        do {
            String customerName;
            customerName = io.readString("Please enter customer's name");
            if (customerName != null && !customerName.isEmpty()) {
                currentOrder.setCustomerName(customerName);
                newInput = true;
            } else {
                newInput = false;
            }
        } while (newInput = false);

        for (Tax ta : taxInfo) {
            io.print(ta.getState());
        }
        myState = io.readString("Please enter from the above postal abreiviations "
                + " the state in which we will be working.");
        Tax t = new Tax();
        t.setState(myState);
        for (Iterator<Tax> it = taxInfo.iterator(); it.hasNext();) {
            t = it.next();
            if (t.getState().equals(myState)) {
                t.getTaxRate();
                BigDecimal tax = t.getTaxRate();
                t.setTaxRate(tax);
                currentOrder.setTax(t);
            }
        }

        for (Product stuff : productInfo) {
            io.print(stuff.getProductType());
        }

        String myProduct = io.readString("Please select from the above product types: ");
        Product p = new Product();
        p.setProductType(myProduct);
        for (Iterator<Product> it = productInfo.iterator(); it.hasNext();) {
            p = it.next();
            if (p.getProductType().equals(myProduct)) {
                p.getLaborCostPerSqFt();
                p.getProductCostPerSqFt();
                BigDecimal prodCost = p.getProductCostPerSqFt();
                BigDecimal labCost = p.getLaborCostPerSqFt();
                p.setProductCostPerSqFt(prodCost);
                p.setLaborCostPerSqFt(labCost);
                currentOrder.setProduct(p);
            }
        }

        BigDecimal area = io.readBigDecimal("Please enter the area you want us to lay flooring for");
        currentOrder.setArea(area);

        return currentOrder;
    }

    public void displayOrderMap(Map<LocalDate, List<Order>> lambdaOrderMap) {
        List<Order> orderList;
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

    public boolean getAssurance() {
        String assurance;
        boolean certain = false;
        assurance = io.readString("Are you sure you want to proceed?");
        if (assurance.equals("y")) {
            certain = false;
        } else if (!assurance.equals("y")) {
            certain = true;
        }
        return certain;
    }

    public LocalDate getOrderDate() {
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
