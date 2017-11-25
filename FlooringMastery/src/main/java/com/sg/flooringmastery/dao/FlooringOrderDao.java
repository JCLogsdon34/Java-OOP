
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

public interface FlooringOrderDao {
    
    Order addOrder(LocalDate date, Order currentOrder)
            throws FlooringPersistenceException;

    List<Order> getAllOrdersByDate()
            throws FlooringPersistenceException; 
    
    List<Order> getOrder(LocalDate date)
            throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException;
    
    Order getOneOrder(List<Order> newList, int orderNumber)throws FlooringPersistenceException;
    
    Order getOrderForEdit(List <Order> orderToday, int orderNumber) throws
            FlooringPersistenceException, 
            FlooringNoOrdersForThatDateException;
    
    Order removeOrder(LocalDate date, int orderNumber)
            throws FlooringPersistenceException
            ,FlooringNoOrdersForThatDateException; 
    
//    Set<LocalDate> getAllDates();
    int getNewOrderNumber()
            throws FlooringPersistenceException;
    
    Order updateAnOrder(LocalDate date, Order currentOrder)
            throws FlooringPersistenceException;
    
    void saveOrder()throws FlooringPersistenceException;
}
