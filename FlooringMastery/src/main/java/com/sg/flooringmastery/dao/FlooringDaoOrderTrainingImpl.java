package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlooringDaoOrderTrainingImpl implements FlooringOrderDao {

    private static Map<String, List<Order>> ordersMap = new HashMap<String, List<Order>>();
    private static ArrayList<Integer> orderNums = new ArrayList<>();

       @Override
    public Order addOrder(LocalDate date, Order currentOrder) throws FlooringPersistenceException, FlooringDaoException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        List<Order> orderList = new ArrayList<>();
        if (ordersMap.get(myOrder) == null) {
            orderList.add(currentOrder);
        } else {
            orderList = new ArrayList<>(ordersMap.get(myOrder));
        }
        ordersMap.put(myOrder, orderList);
        return currentOrder;
    }

   @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        return new ArrayList<>(ordersMap.get(myOrder));
    }

    @Override
    public Order getOrderForEdit(LocalDate date, List<Order> newList, int orderNumber) throws FlooringPersistenceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + newerDate1 + newerDate2;
        int newListLength = newList.size();
        newList = ordersMap.get(theDateNow);
        for (int i = 0; i < newListLength; i++) {
            if (newList.get(i).getOrderNumber() == orderNumber) {
                return newList.get(i);
            }
        }
        return null;
    }

      @Override
    public Order removeOrder(LocalDate date, List<Order> newList, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String dateForFile = date.format(formatter);
        String myOrder = dateForFile.replace("-", "");
        String newerDate = myOrder.substring(0, 2);
        String newerDate1 = myOrder.substring(2, 4);
        String newerDate2 = myOrder.substring(4, 8);
        String theDateNow = newerDate + "-" + newerDate1 + "-" + newerDate2;
         
         int newListLength = newList.size();
        newList = ordersMap.get(theDateNow);
        for (int i = 0; i < newListLength; i++) {
            if (newList.get(i).getOrderNumber() == orderNumber) {         
                 newList.remove(i);
                ordersMap.put(myOrder, newList);
                return newList.get(i);
            }     
    }
        return null;
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


    @Override
    public void saveOrder() throws FlooringPersistenceException {
    }
}
