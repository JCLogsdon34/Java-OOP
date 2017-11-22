
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public interface FlooringServiceLayer {
    
    void addOrder(LocalDate dates, Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException;
    
    Order getOrderCapitalCost(Order order, Collection<Tax> taxInfo, Collection<Product> productInfo) throws
            FlooringPersistenceException;

    List<Order> getOrder(LocalDate date) throws
            FlooringPersistenceException,
            FlooringOrdersForThatDateException;
    
    Collection<Tax> getAllTaxes()throws
            FlooringPersistenceException;

    Order removeOrder(LocalDate date, int orderNumber) throws
            FlooringPersistenceException,
            FlooringOrdersForThatDateException;
  
    Collection<Product> getAllTheProducts()
            throws FlooringPersistenceException;
    
    Order getNewOrderNumber(Order newOrder)
            throws FlooringPersistenceException;
    
    void saveOrder()throws 
            FlooringPersistenceException;
    
    void loadTheOrders()throws
            FlooringPersistenceException;
}
