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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlooringOrderDaoImpl implements FlooringOrderDao {

    private String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    private File theOrders = new File(filePath);
    private File[] listOfOrdersByDate;
    private static Map<String, List<Order>> ordersMap;
    private static String ORDERS_FILE;

    public FlooringOrderDaoImpl() {
        ordersMap = new HashMap<String, List<Order>>();
        theOrders = new File(filePath);
        listOfOrdersByDate = theOrders.listFiles();
    }

    private static final String DELIMITER = ",";
    private static ArrayList<Integer> orderNums = new ArrayList<>();

    @Override
    public Order getOrderForEdit(LocalDate date, List<Order> newList, int orderNumber) throws FlooringPersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + newerDate1 + newerDate2;
        loadOrder(theDateNow);
        Order currentOrder = new Order();
        newList.equals(ordersMap.get(theDateNow));
        newList.equals(newList.add(currentOrder));

        currentOrder = newList.get(orderNumber);

        return currentOrder;
    }

    @Override
    public Order updateAnOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        List<Order> newList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + newerDate1 + newerDate2;
        newList.equals(ordersMap.get(theDateNow));
        newList.equals(newList.add(currentOrder));
        ordersMap.equals(ordersMap.put(date.toString(), newList));
        return currentOrder;
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
        //  loadOrder();
        try {
            writeOrder();
        } catch (FlooringNoOrdersForThatDateException e) {
            System.out.println("No orders to save for today");
        }
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        Order currentOrder = new Order();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;

        loadOrder(theDateNow);
        currentOrder = ordersMap.get(theDateNow).get(orderNumber);
        ordersMap.equals(ordersMap.remove(theDateNow).remove(orderNumber));
        return currentOrder;
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        List<Order> orderList = new ArrayList<>();
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + newerDate1 + newerDate2;

        //      loadOrder(myOrder);
        orderList.equals(ordersMap.get(myOrder));
        orderList.equals(orderList.add(currentOrder));
        ordersMap.equals(ordersMap.put(myOrder, orderList));
        return currentOrder;
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        List<Order> newOrder = new ArrayList<>();
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        loadOrder(myOrder);

        newOrder = ordersMap.get(myOrder);
        return newOrder;
    }
    
    public Set<String> getDates(){
        return ordersMap.keySet();
    }
    
    public Collection<List<Order>> getList(){
        return ordersMap.values();
    }
    public List<Order> getAllOrders()
            throws FlooringDaoException {
            if(getList() != null){
                
  
            }
        return new ArrayList<>();
    }

    @Override
    public int getNewOrderNumber() {
        int num = 0;
        int newOrderNumber = 0;
        do {
            orderNums.add(1);
        } while (orderNums.size() <= 0);
        num = orderNums.size() + 1;
        newOrderNumber = num + 1;
        orderNums.add(newOrderNumber);
        return newOrderNumber;
    }

    public void loadOrder(String theDate) throws FlooringPersistenceException {
        Scanner scanner;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String newerDate = theDate.substring(0, 2);
        String newerDate1 = theDate.substring(2, 4);
        String newerDate2 = theDate.substring(4, 8);

        String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;

        try {
            String myFile = "Orders_" + theDate + ".txt";
            ORDERS_FILE = "Orders_" + theDate + ".txt";
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(myFile)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load order data.", e);
        }

        String currentLine;
        String[] currentTokens = new String[]{};
        Order currentOrder = new Order();
        List<Order> currentDay = new ArrayList<>();
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
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
            currentDay.add(currentOrder);

            ordersMap.put(theDate, currentDay);
        }
        scanner.close();
    }

    public void writeOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        PrintWriter out;
        listOfOrdersByDate = theOrders.listFiles();
        //  String myOrder = dates.replace("-", "");
        //        String orderIWant = "Orders_" + dates + ".txt";

    //    Order currentOrder = new Order();
        
        Set<String> date = ordersMap.keySet();
        

        for (String day : date) {
            ORDERS_FILE = "Orders_" + day + ".txt";
            try {
                out = new PrintWriter(new FileWriter(ORDERS_FILE));
            } catch (IOException e) {
                throw new FlooringPersistenceException(
                        "Could not save Order data.", e);
            }
            /*      for (int k = 0; k < currentDay.size(); k++) {
               List<Order> orders = new ArrayList<>(k);
                        orders.equals(k);
                        currentOrder.equals(orders.get(k));
             */
            Collection<List<Order>> currentDay = ordersMap.values();
            for(List<Order> current : currentDay){
            for(Order currentOrder : ordersMap.get(day)){
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
            out.flush();
            out.close();
        }
    }
    }
}