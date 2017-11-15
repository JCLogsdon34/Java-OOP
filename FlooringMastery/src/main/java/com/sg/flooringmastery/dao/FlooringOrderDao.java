
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;


public interface FlooringOrderDao {
    
    Order addOrder(LocalDate date, Order order)
            throws FlooringPersistenceException;

    List<Order> getAllOrders(LocalDate date, int orderNumber)
            throws FlooringPersistenceException; 
    
    Order getOrder(LocalDate date, int orderNumber)
            throws FlooringPersistenceException;
    
    Order removeOrder(LocalDate date, int orderNumber)
            throws FlooringPersistenceException;   
}
