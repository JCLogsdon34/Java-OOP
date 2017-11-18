package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringOrderDaoImpl implements FlooringOrderDao {
    
    

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order addOrder(LocalDate date, Order order) throws FlooringPersistenceException {
        loadOrder();
        order.setOrderDate(date);
        order.setOrderNumber(orderNumber);

        List<Order> newList = new ArrayList<Order>();
        Order newOrder = null;

        Set<LocalDate> key = orders.keySet();
        //      Collection<List> value = ordersList.values();     
        //  newOrder = orderData.get();
        //  orderData.keySet();

        newList.add(order);
        newList = orders.put(date, newList);
        orderNumber++;
        return order;
    }

    @Override
    public List<Order> getAllOrdersByDate() throws FlooringPersistenceException {
        loadOrder();
        //  orders.get()
        return new ArrayList<>();
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
         loadOrder();

        List<Order> myList = new ArrayList<>();
        Set<LocalDate> keys = orders.keySet();
        Collection<List<Order>> newList = orders.values();
        for (List<Order> m : newList) {
            //for(LocalDate k : keys){
            
           if(m.isEmpty()){
               throw new FlooringOrdersForThatDateException
                       ("No Orders for that date");
           }
        }
          return myList;
    }
    //use a string for ORDERS_FILE
    //move the following line to the UserIo

    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public int orderNumber = 0;
    public String ORDERS_FILE = "ORDERS_MMDDYYYY.txt";
    // Set<LocalDate>
    
    List<Order> ordersList = new ArrayList<>();
    Map<LocalDate, List<Order>> orders = new HashMap<>();
    public static final String DELIMITER = "::";

    public void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;
        Order currentOrder;

        File theOrders = new File(filePath);
        File[] listOfOrdersByDate = theOrders.listFiles();
        for (int i = 0; i < listOfOrdersByDate.length; i++) {
            if (listOfOrdersByDate[i].isFile()) {
                String theFileWanted = listOfOrdersByDate[i].getName();
                if ((theFileWanted.startsWith("Orders_")) && (theFileWanted.endsWith(".txt"))) {

                    try {
                        scanner = new Scanner(
                                new BufferedReader(
                                        new FileReader(listOfOrdersByDate[i])));
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
                        currentOrder.setCustomerName(currentTokens[1]);
                        currentOrder.getTax().setState(currentTokens[2]);
                        currentOrder.getTax().setTaxRate(new BigDecimal(currentTokens[3]));
                        currentOrder.getProduct().setProductType(currentTokens[4]);
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(currentTokens[5]));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(currentTokens[6]));
                        currentOrder.setArea(new BigDecimal(currentTokens[7]));
                        currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
                        currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
                        currentOrder.setTotal(new BigDecimal(currentTokens[10]));

                        orders.put(currentOrder.getOrderDate(), ordersList);
                    }
                    scanner.close();
                }
            }
        }

    }

    public void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;
        /*     Order theOrder = null;
        String myDate = theOrder.getOrderDate().toString();
        ArrayList<LocalDate> orderDates;
        for(int i = 0; i < orderDates.size(); i++){
            if(orderDates.get(i).equalsIgnoreCase(myDate)){
         */
        try {
            out = new PrintWriter(new FileWriter(ORDERS_FILE));
        } catch (IOException e) {
            throw new FlooringPersistenceException(
                    "Could not save Order data.", e);
        }

        List<Order> orderList = this.getAllOrdersByDate();
        orderList.stream().map((currentOrder) -> {
            out.println(currentOrder.getOrderNumber() + DELIMITER
                    + currentOrder.getCustomerName() + DELIMITER
                    + currentOrder.tax.getState() + DELIMITER
                    + currentOrder.tax.getTaxRate() + DELIMITER
                    + currentOrder.product.getProductType() + DELIMITER
                    + currentOrder.product.getProductCostPerSqFt() + DELIMITER
                    + currentOrder.product.getLaborCostPerSqFt() + DELIMITER
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
