
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;


public interface FlooringServiceLayer {
    
    void addOrder(Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException;
    
    Order getOrderCapitalCost(Order order) throws
            FlooringDataValidationException;

    List<Order> getOrder(LocalDate date) throws
            FlooringPersistenceException,
            FlooringOrdersForThatDateException;

    Order removeOrder(int orderNumber, LocalDate date) throws
            FlooringPersistenceException;
}
