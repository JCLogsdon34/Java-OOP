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
    
    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public File theOrders = new File(filePath);
    public File[] listOfOrdersByDate = theOrders.listFiles();
    private HashMap<LocalDate, List<Order>> ordersMap = new HashMap<>();
    private HashMap<String, HashMap<LocalDate, List<Order>>> allByFileName = new HashMap<>();
    public List<Order> ordersList = new ArrayList<>();

    public FlooringOrderDaoImpl() {
        allByFileName = new HashMap<>();
    }

    @Override
    public Order getOneOrder(List<Order> newList, int orderNumber) throws FlooringPersistenceException {
        loadOrder();
        Order currentOrder;
        currentOrder = newList.get(orderNumber);
        return currentOrder;
    }

    @Override
    public Order getOrderForEdit(List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        loadOrder();
        Order currentOrder = ordersList.get(orderNumber);
        ordersList.remove(orderNumber);
        return currentOrder;
    }

    @Override
    public Order updateAnOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        loadOrder();
        List<Order> newList = ordersMap.get(date);

        newList.add(currentOrder);
        ordersMap.put(date, newList);
        return currentOrder;
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
        loadOrder();
        writeOrder();
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        Order order = new Order();
        loadOrder();
        //       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        //     String dateForFile = date.format(formatter);
        //    String stringDate = dateForFile.replace("-", "");

        List<Order> newList = getOrder(date);
        order = newList.get(orderNumber);
        ordersList.remove(order);
        order = ordersMap.remove(date).remove(orderNumber);
        return order;
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        loadOrder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        List<Order> newList = new ArrayList<>();
        String stringDate = dateForFile.replace("-", "");
        newList.add(currentOrder);
        ordersMap.put(date, newList);
        return currentOrder;
    }

    @Override
    public List<Order> getAllOrdersByDate() throws FlooringPersistenceException {
        loadOrder();
        return new ArrayList<>();
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        loadOrder();
        List<Order> newOrder = new ArrayList<>();
        newOrder = ordersMap.get(date);
        return newOrder;
    }

    
    public String ORDERS_FILE;
    public static final String DELIMITER = ",";

    public static ArrayList<Integer> orderNums = new ArrayList<>();

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
                                        new FileReader(ORDERS_FILE)));
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

                        orderNums.add(currentOrder.getOrderNumber());
                        ordersList.add(currentOrder);
                        ordersMap.put(currentOrder.getOrderDate(), ordersList);
                        allByFileName.put(newDate, ordersMap);
                    }
                    scanner.close();
                }
            }
        }
    }

    public Set<String> getKey() {
        return allByFileName.keySet();
    }
    
    public Set<LocalDate> getOtherKey(){
        return ordersMap.keySet();
    }

    public Collection<List<Order>> getValue(LocalDate date) {
        Collection<List<Order>> currentOrder;
        currentOrder = ordersMap.values();
        return currentOrder;
    }

    private void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        
        for (String names : getKey()) {
            Order currentOrder = new Order();
                
                List<Order> orders = ordersMap.get(currentOrder.getOrderDate());
                
                String dateForFile = desiredOrderDate.format(formatter);
                String newDate = dateForFile.substring(7, dateForFile.length() - 4);
                String newerDate = newDate.substring(0, 2);
                String newerDate1 = newDate.substring(2, 4);
                String newerDate2 = newDate.substring(4, 8);
                String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;

                File brandNewFile = new File("Orders_" + theDateNow + ".txt");

                try {
                    out = new PrintWriter(new FileWriter(brandNewFile));
                } catch (IOException e) {
                    throw new FlooringPersistenceException(
                            "Could not save Order data.", e);
                }
                
                currentOrder = theOrder.get(currentOrder.getOrderNumber());
/*                String anOrder = currentOrder.getOrderDate().toString();
                String myOrder = anOrder.replace("-", "");
                String theFilesName = "Orders_" + myOrder + "txt";
*/
                //use fileMap keyset right here
                if (getKey().equals(brandNewFile)) {
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
                    allByFileName.put(brandNewFile.toString(), ordersMap);
                    // listOfOrdersByDate.put(orderFiles);
                    out.flush();
                }
                out.close();
            }
        }
    }
}
