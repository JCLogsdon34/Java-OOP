
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlooringOrderDaoStubImpl implements FlooringOrderDao {
    
    Order oneOrder;
    private static Map<String, List<Order>> ordersMap;
    private static String ORDER_FILE;
    
    public FlooringOrderDaoStubImpl(){
        ordersMap = new HashMap<String, List<Order>>();
        List<Order> theList = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 4;
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Crockett");
        currentOrder.getTax().setState("TN");
        currentOrder.getTax().setTaxRate(new BigDecimal(6.75));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal(11));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
        currentOrder.setMaterialCost(new BigDecimal(55));
        currentOrder.setLaborCost(new BigDecimal(44));
        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
        currentOrder.setTotal(new BigDecimal(22.11));
        theList.add(currentOrder);
        ordersMap.put(myOrder , theList);
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
      if(date.equals(oneOrder.getOrderDate())){
            return oneOrder;
        } else {
            return null;
        }
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        List<Order> newOrder = new ArrayList<>();
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");

        newOrder = ordersMap.get(myOrder);
        return newOrder;
    }

    @Override
    public Order getOrderForEdit(LocalDate date, List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        Order currentOrder = new Order();
        List<Order> orderList = new ArrayList<>();
        orderList.equals(ordersMap.get(myOrder));
        orderList.equals(orderList.add(oneOrder));
        currentOrder = orderList.get(orderNumber);
        return currentOrder;
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
       DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
          myDate = currentOrder.getOrderDate();
        if((myDate.equals(oneOrder.getOrderDate()))){
        oneOrder = ordersMap.get(myOrder).get(orderNumber);
        ordersMap.equals(ordersMap.remove(myOrder).remove(orderNumber));
            return oneOrder;
       }     
        else {
            return null;
        }
    }

    @Override
    public int getNewOrderNumber() throws FlooringPersistenceException {
        return oneOrder.getOrderNumber();
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
        LocalDate date = oneOrder.getOrderDate();
        List<Order> newList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + newerDate1 + newerDate2;
        ORDER_FILE = "Orders_" + myOrder + ".txt";
        String DELIMITER = ",";
        Order currentOrder = new Order();
         PrintWriter out;
        try {
                out = new PrintWriter(new FileWriter(ORDER_FILE));
            } catch (IOException e) {
                throw new FlooringPersistenceException(
                        "Could not save Order data.", e);
            }
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
                
                out.flush();
                out.close();
                
    }
    
}
