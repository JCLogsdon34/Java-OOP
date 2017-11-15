
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;


public interface FlooringServiceLayer {
    
    void addOrder(Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException;

    List<Order> getAllOrders() throws
            FlooringPersistenceException;

    Order getOrder(int orderNumber, LocalDate date) throws
            FlooringPersistenceException;

    Order removeOrder(int orderNumber, LocalDate date) throws
            FlooringPersistenceException;
}
