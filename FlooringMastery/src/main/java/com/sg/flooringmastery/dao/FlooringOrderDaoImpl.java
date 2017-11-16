
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class FlooringOrderDaoImpl implements FlooringOrderDao {

    @Override
    public Order addOrder(LocalDate date, Order order) throws FlooringPersistenceException {
        Order newOrder = null;
             
            loadOrder();
            orderData.get(date);
            orderData.keySet();
            orderData.keySet().stream().filter((key) -> (key.contains(date))).forEach((_order) -> {
                System.out.println("You already have this Order");
        });
            newOrder = orderData.put(order.getOrderDate(), order);            
            return newOrder;  
    }

    @Override
    public List<Order> getAllOrdersByDate() throws FlooringPersistenceException {
            loadOrder();     
        return new ArrayList<>(orderData.values());
    }

    @Override
    public Order getOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException {
            loadOrder();
            
        return orderData.get(date);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Map<LocalDate, List<Order>> orderData = new HashMap<>();

    public static final String ORDERS_FILE = "Orders_"+LocalDate.now()+".txt";
    public static final String DELIMITER = "::";
    
     public void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;
        Order currentOrder;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDERS_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load order data.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            currentOrder = new Order();
            currentOrder.setOrderNumber(Integer.parseInt((currentTokens[0])));
            currentOrder.setOrderDate(new LocalDate(currentTokens[1]));
            currentOrder.setCustomerName(currentTokens[2]);
            currentOrder.setProduct(currentTokens[3]);
            currentOrder.setTax(currentTokens[4]);
            currentOrder.setArea(new BigDecimal(currentTokens[5]));
            currentOrder.setMaterialCost(new BigDecimal(currentTokens[6]));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[7]));
            currentOrder.setTotal(new BigDecimal(currentTokens[8]));

            orderLibrary.put(currentOrder.getOrderDate(), List<currentOrder>);
        }
        scanner.close();
    }

    public void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ORDERS_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save Order data.", e);
        }
        List<Order> orderList = this.getAllOrdersByDate();
        orderList.stream().map((currentOrder) -> {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getOrderDate() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.getProduct() + DELIMITER
                    + currentOrder.getTax() + DELIMITER
                    + currentOrder.getArea() + DELIMITER
                    + currentOrder.getMaterialCost() + DELIMITER
                    + currentOrder.getLaborCost() + DELIMITER
                    + currentOrder.getTotal() + DELIMITER);      
            return currentOrder;
        }).forEach((_order) -> {
            out.flush();
        });
        
        out.close();
    }
    
}
