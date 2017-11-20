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
    public void saveOrder() throws FlooringPersistenceException {
        loadOrder();
        writeOrder();
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        Order order;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String stringDate = dateForFile.replace("-", "");
        order = orders.get(date).remove(orderNumber);
        //     listOfOrdersByDate.delete();
        return order;
    }

    @Override
    public Order addOrder(LocalDate date, Order order) throws FlooringPersistenceException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        List<Order> newList = new ArrayList<>();
        String stringDate = dateForFile.replace("-", "");

        //  newOrder = orderData.get();
        //  orderData.keySet();
        newList.add(order);
        orders.put(date, newList);
        return order;
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
  /*      for(int i = 0; i < newOrder.size(); i++){
            newList.add(newOrder.get(i));     
    }
*/
        return newOrder;
    }
    
    public String filePath = "/home/apprentice/chris-logsdon-individual-work/FlooringMastery";
    public File theOrders = new File(filePath);
    public File[] listOfOrdersByDate = theOrders.listFiles();
    public HashMap<String, String> orderFiles = new HashMap();
    public Set<String> fileNames = orderFiles.keySet();
    public ArrayList<Integer> orderNums = new ArrayList<>();
    public List<Order> ordersList = new ArrayList<>();
    public int orderNumber = 1;
    public String ORDERS_FILE; // "Orders_06012013.txt";
    public Map<LocalDate, List<Order>> orders = new HashMap<>();
    public static final String DELIMITER = ",";
    public Set<LocalDate> keys = orders.keySet();
    
    public LocalDate[] getAllTheOrders(){
        LocalDate[] kArray = new LocalDate[keys.size()];
        kArray = keys.toArray(new LocalDate[keys.size()]);
        return kArray;
    }
    
    @Override
    public Order getNewOrderNumber(Order newOrder){
        int num;
        int newOrderNumber;
        num = orderNums.size();
        if(num <= 0){
            orderNums.add(1);
            num = orderNums.size();
            newOrderNumber = num + 1;
        } else{
        newOrderNumber = num + 1;
        newOrder.setOrderNumber(newOrderNumber);
        orderNums.add(newOrderNumber);
        }
        return newOrder;
    }

    @Override
    public void loadOrder() throws FlooringPersistenceException {
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
                    String newerDate = newDate.substring(0,2);
                    String newerDate1 = newDate.substring(2,4);
                    String newerDate2 = newDate.substring(4,8);
                    String theDateNow = newerDate+"-"+newerDate1+"-"+newerDate2;
                    String currentLine;
                    String[] currentTokens;
                    while (scanner.hasNextLine()) {
                        currentLine = scanner.nextLine();
                        currentTokens = currentLine.split(DELIMITER);
                        currentOrder = new Order();
                        currentOrder.getProduct();
                        currentOrder.getTax();
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
                        //add a step to add order(s) to list, then the map
                        ordersList.add(currentOrder);
                        orders.put(currentOrder.getOrderDate(), ordersList);
                    }
                    scanner.close();
                }
            }
        }
    }

    private void writeOrder() throws FlooringPersistenceException {
        PrintWriter out;

        for (String names : fileNames) {
            for (Iterator<LocalDate> it = keys.iterator(); it.hasNext();) {
                LocalDate desiredOrderDate = it.next();
                List<Order> theOrder = orders.get(desiredOrderDate);
                String dateNow = orderFiles.get(names);
                ORDERS_FILE = "Orders_"+dateNow+".txt";
                try {
                    out = new PrintWriter(new FileWriter(ORDERS_FILE));
                } catch (IOException e) {
                    throw new FlooringPersistenceException(
                            "Could not save Order data.", e);
                }
                Order currentOrder = theOrder.get(orderNumber);
                String theFilesName = "Orders_" + currentOrder.getOrderDate().toString() + "txt";
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
               //     ordersList.add(currentOrder);
                    out.flush();
                }
                out.close();
            }
        }
    }
}