
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;


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
}
