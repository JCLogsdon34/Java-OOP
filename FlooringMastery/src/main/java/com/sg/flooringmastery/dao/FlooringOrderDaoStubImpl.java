
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FlooringOrderDaoStubImpl implements FlooringOrderDao {
    
    Order oneOrder = new Order();
    private static Map<String, List<Order>> ordersMap;
    
    public FlooringOrderDaoStubImpl(){
        ordersMap = new HashMap<String, List<Order>>();
        List<Order> theList = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
       
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          oneOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 4;
        oneOrder.setOrderNumber((orderNumber));
        oneOrder.setCustomerName("Crockett");
        oneOrder.getTax().setState("TN");
        oneOrder.getTax().setTaxRate(new BigDecimal("6.75").setScale(2, HALF_UP));
        oneOrder.getProduct().setProductType("Wood");
        oneOrder.setArea(new BigDecimal("11").setScale(2, HALF_UP));
        oneOrder.getProduct().setProductCostPerSqFt(new BigDecimal("55").setScale(2, HALF_UP));
        oneOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("22").setScale(2, HALF_UP));
        oneOrder.setMaterialCost(new BigDecimal("55").setScale(2, HALF_UP));
        oneOrder.setLaborCost(new BigDecimal("44").setScale(2, HALF_UP));
        oneOrder.getTax().setTaxAmount(new BigDecimal("322").setScale(2, HALF_UP));
        oneOrder.setTotal(new BigDecimal("22.11").setScale(2, HALF_UP));
        theList.add(oneOrder);
        ordersMap.put(myOrder , theList);
    }

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        
        
        if(myOrder == String.valueOf(oneOrder.getOrderDate())){
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

        return ordersMap.get(myOrder);
    }

    @Override
    public Order getOrderForEdit(LocalDate date, List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        List<Order> orderList = new ArrayList<>(ordersMap.get(myOrder));;
        orderList.add(oneOrder);
        return oneOrder;
    }

    @Override
    public Order removeOrder(LocalDate date, List<Order> newList, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
       DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
          myDate = currentOrder.getOrderDate();
        if((myDate == oneOrder.getOrderDate())){
        oneOrder = ordersMap.get(myOrder).get(orderNumber);
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
        newList = ordersMap.get(theDateNow);
        newList.add(currentOrder);
        ordersMap.put(date.toString(), newList);
        return currentOrder;
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
 
    }
}
