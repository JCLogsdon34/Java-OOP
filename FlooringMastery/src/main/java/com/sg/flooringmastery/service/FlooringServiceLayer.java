
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public interface FlooringServiceLayer {
    
    void addOrder(LocalDate dates, Order currentOrder) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException;
    
    Order  getOrderForEdit(LocalDate date, int orderNumber)
            throws FlooringPersistenceException,
            FlooringOrdersForThatDateException;
    
    BigDecimal getTotalSineTax(BigDecimal totalMaterial, BigDecimal totalLabor);
    
    BigDecimal getTaxesForOrder(Tax currentTax, BigDecimal totalSineTax);
    
    BigDecimal getLabor(Product currentProduct, BigDecimal area);
    
    BigDecimal getMaterial(Product currentProduct, BigDecimal area);
    
    BigDecimal getOrderCapitalCost(BigDecimal taxAmount, BigDecimal totalSineTax) throws
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
    
    int getNewOrderNumber()
            throws FlooringPersistenceException;
    
    void saveOrder()throws 
            FlooringPersistenceException;
    
    void loadTheOrders()throws
            FlooringPersistenceException;
}
