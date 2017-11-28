package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlooringDaoOrderTrainingImpl implements FlooringDaoOrderTraining {

    private static Map<String, List<Order>> ordersMap = new HashMap<String, List<Order>>();
    private static ArrayList<Integer> orderNums = new ArrayList<>();

    @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);       
        String theDateNow = newerDate + newerDate1 + newerDate2;
        
        List<Order> orderList = new ArrayList<>();
        orderList.equals(ordersMap.get(theDateNow));
        orderList.equals(orderList.add(currentOrder));
        ordersMap.equals(ordersMap.put(theDateNow, orderList));
        return currentOrder;
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        List<Order> newOrder = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);       
        String theDateNow = newerDate + newerDate1 + newerDate2;
        
        newOrder.equals(ordersMap.get(theDateNow));
        return newOrder;
    }

    @Override
    public Order getOrderForEdit(List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        Order currentOrder = new Order();
        
        currentOrder.equals(orderToday.get(orderNumber));
        return currentOrder;
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
        String theDateNow = newerDate + newerDate1 + newerDate2;
        
        currentOrder.equals(ordersMap.get(theDateNow).get(orderNumber));
        ordersMap.equals(ordersMap.remove(theDateNow).remove(orderNumber));
        return currentOrder;
    }

    @Override
    public int getNewOrderNumber() throws FlooringPersistenceException {
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
        ordersMap.equals(ordersMap.put(theDateNow, newList));
        return currentOrder;
    }
}
