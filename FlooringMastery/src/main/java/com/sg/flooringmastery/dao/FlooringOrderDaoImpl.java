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

    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public File theOrders = new File(filePath);
    public File[] listOfOrdersByDate;
    //  private HashMap<LocalDate, List<Order>> anOrder;
    //these three were static
    public static Map<LocalDate, List<Order>> ordersMap;
    public static List<Order> ordersList;

    public FlooringOrderDaoImpl() {
        ordersList = new ArrayList<Order>();
        ordersMap = new HashMap<LocalDate, List<Order>>();
        theOrders = new File(filePath);
        listOfOrdersByDate = theOrders.listFiles();
    }

    public String ORDERS_FILE;
    public static final String DELIMITER = ",";
    private static ArrayList<Integer> orderNums = new ArrayList<>();

    @Override
    public Order getOneOrder(List<Order> newList, int orderNumber) throws FlooringPersistenceException {
        loadOrder();
        Order currentOrder;
        currentOrder = newList.get(orderNumber);
        return currentOrder;
    }

    @Override
    public Order getOrderForEdit(List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        //loadOrder();
        Order currentOrder = ordersList.get(orderNumber);
        return currentOrder;
    }

    @Override
    public Order updateAnOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
       // loadOrder();
        List<Order> newList = ordersMap.get(date);

        newList.add(currentOrder);
        ordersList.add(currentOrder);
        ordersMap.put(date, newList);
        return currentOrder;
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
          loadOrder();
        try {
            writeOrder();
        } catch (FlooringNoOrdersForThatDateException e) {
            System.out.println("No orders to save for today");
        }
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        Order currentOrder = new Order();
          // loadOrder();
    //    currentOrder = ordersList.get(orderNumber);
        currentOrder = ordersMap.get(date).get(orderNumber);
        ordersMap.remove(date).remove(orderNumber);
 //       ordersList.remove(orderNumber);
        return currentOrder;
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        //loadOrder();
        ordersList.add(currentOrder);      
        List<Order> orderList = ordersMap.get(date);
        orderList.equals(orderList.add(currentOrder));
        ordersMap.put(date, orderList);
        return currentOrder;
    }

    @Override
    public List<Order> getAllOrdersByDate() throws FlooringPersistenceException {
        loadOrder();
        return ordersList;
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        loadOrder();
        List<Order> newOrder = ordersMap.get(date);
        
        return newOrder;
    }

    @Override
    public int getNewOrderNumber() {
        int num = 0;
        int newOrderNumber = 0;        
        do{
            orderNums.add(1);
        }while (orderNums.size() <= 0);       
        num = orderNums.size() + 1;
        newOrderNumber = num + 1;
        orderNums.add(newOrderNumber);
        return newOrderNumber;
    }

    public void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;
        Order currentOrder;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        for (int i = 0; i < listOfOrdersByDate.length; i++) {

            if (listOfOrdersByDate[i] != null) {

                String theFileWanted = listOfOrdersByDate[i].getName();
                if ((theFileWanted.startsWith("Orders_")) && (theFileWanted.endsWith(".txt"))) {

                    String newDate = theFileWanted.substring(7, theFileWanted.length() - 4);

                    if ((theFileWanted.contains(newDate))) {
                        String newerDate = newDate.substring(0, 2);
                        String newerDate1 = newDate.substring(2, 4);
                        String newerDate2 = newDate.substring(4, 8);
                        String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;

                        try {
                            scanner = new Scanner(
                                    new BufferedReader(
                                            new FileReader(theFileWanted)));
                        } catch (FileNotFoundException e) {
                            throw new FlooringPersistenceException("-_- Could not load order data.", e);
                        }

                        String currentLine;
                        String[] currentTokens = new String[]{};
                        while (scanner.hasNextLine()) {
                         
                            currentLine = scanner.nextLine();
                            currentTokens = currentLine.split(DELIMITER);
                            currentOrder = new Order();
                            currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                  //          LocalDate myDate = currentOrder.getOrderDate();
                            List<Order> currentDay = new ArrayList<>();
//                            currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
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
                            currentDay.add(currentOrder);
                            ordersList.add(currentOrder);

                            //     ordersMap.put(currentOrder.getOrderDate(), ordersList);
                            ordersMap.put(currentOrder.getOrderDate(), currentDay);
                        }
                        scanner.close();
                    }
                }
            }
        }
    }

    public void writeOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        PrintWriter out;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        for (LocalDate myDate : ordersMap.keySet()) {

            String dateForFile = myDate.format(formatter);
            String myOrder = dateForFile.replace("-", "");
            String newerDate = myOrder.substring(0, 2);
            String newerDate1 = myOrder.substring(2, 4);
            String newerDate2 = myOrder.substring(4, 8);
            String theDateNow = newerDate + newerDate1 + newerDate2;

            String orderIWant = "Orders_" + theDateNow + ".txt";
            ORDERS_FILE = orderIWant;
            for (int i = 0; i < listOfOrdersByDate.length; i++) {
                
                String ordersDate = listOfOrdersByDate[i].getName();
                if ((ordersDate).equals(orderIWant)) {
                    File theFile = new File(ordersDate);
                    ORDERS_FILE = theFile.toString();
                } else {
                    File brandNewFile = new File(orderIWant);
                    ORDERS_FILE = brandNewFile.toString();
                    try {
                        out = new PrintWriter(new FileWriter(ORDERS_FILE));
                    } catch (IOException e) {
                        throw new FlooringPersistenceException(
                                "Could not save Order data.", e);
                    }
                    //   List<Order> currentDay = this.getOrder(myDate);
                    Order currentOrder = new Order();
                    
                    List<Order> currentDay = ordersMap.get(myDate);
                    for (int k = 0; k < currentDay.size(); k++) {
                        currentOrder = currentDay.get(k);
                        if (currentOrder.getOrderDate().equals(myDate)) {
                            //use fileMap keyset right here
                            //currentOrder.getOrderDate() + DELIMITER +
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
                                    + currentOrder.getTotal());
                        }
                    }
                    out.flush();
                    out.close();
                }
            }
        }
    }
}