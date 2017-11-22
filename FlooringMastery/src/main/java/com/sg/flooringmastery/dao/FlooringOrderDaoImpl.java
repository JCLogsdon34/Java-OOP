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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringOrderDaoImpl implements FlooringOrderDao {

    public FlooringOrderDaoImpl() {

    }
    
    @Override
    public Order getOrderForEdit(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        loadOrder();
        Order currentOrder;
        List<Order> newOrder = new ArrayList<>(orders.get(date));
        newOrder = orders.get(date);
        currentOrder = newOrder.get(orderNumber);
        return currentOrder;
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
        writeOrder();
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        Order order = new Order();
        loadOrder();
        //       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        //     String dateForFile = date.format(formatter);
        //    String stringDate = dateForFile.replace("-", "");
        List<Order> newList = new ArrayList<>();
        newList = getOrder(date);
        order = newList.remove(orderNumber);
        ordersList.remove(order);
        orders.remove(date, ordersList);
        order = orders.remove(date).remove(orderNumber);
        //     listOfOrdersByDate.delete();
        return order;
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        List<Order> newList = new ArrayList<>();
        String stringDate = dateForFile.replace("-", "");
        newList.add(currentOrder);
        orders.put(date, newList);
        return currentOrder;
    }

    @Override
    public List<Order> getAllOrdersByDate() throws FlooringPersistenceException {
        loadOrder();
        return new ArrayList<>();
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        loadOrder();
        List<Order> newOrder = new ArrayList<>(orders.get(date));
        newOrder = orders.get(date);
        return newOrder;
    }

    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public File theOrders = new File(filePath);
    public File[] listOfOrdersByDate = theOrders.listFiles();
    public ArrayList<String> orderFiles = new ArrayList<>();
    public ArrayList<Integer> orderNums = new ArrayList<>();
    public List<Order> ordersList = new ArrayList<>();
    public int orderNumber = 1;
    public String ORDERS_FILE;
    public Map<LocalDate, List<Order>> orders = new HashMap<>();
    public static final String DELIMITER = ",";

    @Override
    public int getNewOrderNumber() {
        int num;
        int newOrderNumber;
        num = orderNums.size();
        if (num <= 0) {
            orderNums.add(1);
            num = num + orderNums.size();
            newOrderNumber = num + 1;
        }
        newOrderNumber = num + 1;
        orderNums.add(newOrderNumber);
        return newOrderNumber;
    }

    private void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;
        Order currentOrder;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        for (int i = 0; i < listOfOrdersByDate.length; i++) {

            if (listOfOrdersByDate[i].exists()) {
                String theFileWanted = listOfOrdersByDate[i].getName();

                if ((theFileWanted.startsWith("Orders_")) && (theFileWanted.endsWith(".txt"))) {
                    ORDERS_FILE = theFileWanted;
                    try {
                        scanner = new Scanner(
                                new BufferedReader(
                                        new FileReader(theFileWanted)));
                    } catch (FileNotFoundException e) {
                        throw new FlooringPersistenceException("-_- Could not load order data.", e);
                    }
                    String newDate = theFileWanted.substring(7, theFileWanted.length() - 4);
                    String newerDate = newDate.substring(0, 2);
                    String newerDate1 = newDate.substring(2, 4);
                    String newerDate2 = newDate.substring(4, 8);
                    String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;
                    String currentLine;
                    String[] currentTokens;
                    while (scanner.hasNextLine()) {
                        currentLine = scanner.nextLine();
                        currentTokens = currentLine.split(DELIMITER);
                        currentOrder = new Order();
                        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber(Integer.parseInt((currentTokens[0])));
                        currentOrder.setCustomerName(currentTokens[1]);
                        currentOrder.getTax().setState(currentTokens[2]);
                        currentOrder.getTax().setTaxRate(new BigDecimal(currentTokens[3]));
                        currentOrder.getProduct().setProductType(currentTokens[4]);
                        currentOrder.setArea(new BigDecimal(currentTokens[5]));
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(currentTokens[6]));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(currentTokens[7]));
                        currentOrder.setMaterialCost(new BigDecimal(currentTokens[8]));
                        currentOrder.setLaborCost(new BigDecimal(currentTokens[9]));
                        currentOrder.getTax().setTaxAmount(new BigDecimal(currentTokens[10]));
                        currentOrder.setTotal(new BigDecimal(currentTokens[11]));

                        ordersList.add(currentOrder);
                        orders.put(currentOrder.getOrderDate(), ordersList);
                    }
                    scanner.close();
                }
            }
        }
    }

    public Set<LocalDate> keys = orders.keySet();

    private void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
             
        for (String names : orderFiles) {
            for (Iterator<LocalDate> it = keys.iterator(); it.hasNext();) {
                
                LocalDate desiredOrderDate = it.next();
                List<Order> theOrder = orders.get(desiredOrderDate);
                String dateForFile = desiredOrderDate.format(formatter);
                String stringDate = dateForFile.replace("-", "");
                
            
                ORDERS_FILE = "Orders_"+stringDate+".txt";
                try {
                    out = new PrintWriter(new FileWriter(ORDERS_FILE));
                } catch (IOException e) {
                    throw new FlooringPersistenceException(
                            "Could not save Order data.", e);
                }
                Order currentOrder = theOrder.get(orderNumber);
                String anOrder = currentOrder.getOrderDate().toString();
                String myOrder = anOrder.replace("-", "");
                String theFilesName = "Orders_"+myOrder+"txt";
                if (theFilesName.equals(ORDERS_FILE)) {
                    out.println(currentOrder.getOrderNumber() + DELIMITER
                            + currentOrder.getCustomerName() + DELIMITER
                            + currentOrder.getTax().getState() + DELIMITER
                            + currentOrder.getTax().getTaxRate() + DELIMITER
                            + currentOrder.getProduct().getProductType() + DELIMITER
                            + currentOrder.getArea() + DELIMITER
                            + currentOrder.getProduct().getProductCostPerSqFt() + DELIMITER
                            + currentOrder.getProduct().getLaborCostPerSqFt() + DELIMITER
                            + currentOrder.getMaterialCost() + DELIMITER
                            + currentOrder.getLaborCost() + DELIMITER
                            + currentOrder.getTax().getTaxAmount() + DELIMITER
                            + currentOrder.getTotal() + DELIMITER);
                    orderFiles.add(ORDERS_FILE);
                    out.flush();
                }
                out.close();
            }
        }
    }
}