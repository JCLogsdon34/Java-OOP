
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface FlooringOrderDao {
    
    Order addOrder(LocalDate date, Order order)
            throws FlooringPersistenceException;

    List<Order> getAllOrdersByDate()
            throws FlooringPersistenceException; 
    
    List<Order> getOrder(LocalDate date)
            throws FlooringPersistenceException,
            FlooringOrdersForThatDateException;
    
    Order removeOrder(LocalDate date, int orderNumber)
            throws FlooringPersistenceException
            ,FlooringOrdersForThatDateException; 
    
    Set<LocalDate> getAllDates();
    
    void loadOrder()throws FlooringPersistenceException;
    
    void saveOrder()throws FlooringPersistenceException;
}
