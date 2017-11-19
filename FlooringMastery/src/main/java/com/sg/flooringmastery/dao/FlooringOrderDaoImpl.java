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

    public FlooringOrderDaoImpl() {

    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        Order order;
        order = orders.get(date).remove(orderNumber);
   //     listOfOrdersByDate.delete();
        return order;
    }

    @Override
    public Order addOrder(LocalDate date, Order order) throws FlooringPersistenceException {
        loadOrder();
    //    order.setOrderDate(date);
        
   //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
     //   String dateForFile = date.format(formatter);

   //     LocalDate date = LocalDate.parse(numberYear, formatter);
  //      currentOrder.setOrderDate(date);

        order.setOrderNumber(orderNumber);

        List<Order> newList = new ArrayList<Order>();
        Order newOrder = null;

        Set<LocalDate> key = orders.keySet();
        //      Collection<List> value = ordersList.values();     
        //  newOrder = orderData.get();
        //  orderData.keySet();

        newList.add(order);
        orders.put(date, newList);
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
        List<Order> newList = orders.get(date);
                if (newList.isEmpty()) {
                    throw new FlooringOrdersForThatDateException("No Orders for that date");     
            }
        return newList;
    }
    //use a string for ORDERS_FILE
    //move the following line to the UserIo
    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public File theOrders = new File(filePath);
    public File[] listOfOrdersByDate = theOrders.listFiles();
    public HashMap<String, String> orderFiles = new HashMap();
    public Set<String> fileNames = orderFiles.keySet();
    public ArrayList<Integer> orderNums = new ArrayList<>();
    public List<Order> ordersList = new ArrayList<>();
    public int orderNumber = 1;
    public Set<LocalDate> keys = orders.keySet();
    public String ORDERS_FILE;
    public static Map<LocalDate, List<Order>> orders = new HashMap<>();
    public static final String DELIMITER = "::";

    public void loadOrder() throws FlooringPersistenceException {
        Scanner scanner;
        Order currentOrder;

        for (int i = 0; i < listOfOrdersByDate.length; i++) {

            if (listOfOrdersByDate[i].exists()) {
                String theFileWanted = listOfOrdersByDate[i].getName();
                

                if ((theFileWanted.startsWith("Orders_")) && (theFileWanted.endsWith(".txt"))) {
                    ORDERS_FILE = theFileWanted;
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

                        orders.put(currentOrder.getOrderDate(), ordersList);
                    }
                    scanner.close();
                }
            }
        }

    }

    public void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;

        for (String names : fileNames) {
            for (LocalDate desiredOrderDate : keys) {

                List<Order> theOrder = orders.get(desiredOrderDate);
                String dateNow = orderFiles.get(names);
                ORDERS_FILE = dateNow;
                try {
                out = new PrintWriter(new FileWriter(ORDERS_FILE));
            } catch (IOException e) {
                throw new FlooringPersistenceException(
                        "Could not save Order data.", e);
            }
                
                
                Order currentOrder = theOrder.get(orderNumber);
                String theFilesName = "Orders_"+ currentOrder.getOrderDate().toString()+"txt";
                if (theFilesName.equals(dateNow)) {
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
                    out.flush();
                }
                out.close();
            }
        }
    }
}
