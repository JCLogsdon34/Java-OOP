
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public interface FlooringServiceLayer {
    
    Order addOrder(LocalDate dates, Order currentOrder) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException;
    
    Order getOneOrder(List<Order> newList, int orderNumber) throws FlooringPersistenceException;
    
    Order updateAnOrder(LocalDate date, Order currentOrder)
            throws FlooringPersistenceException;
    
    Order  getOrderForEdit(List<Order> orderToday, int orderNumber)
            throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException;

    
    BigDecimal getTotalSineTax(BigDecimal totalMaterial, BigDecimal totalLabor);
    
    BigDecimal getTaxesForOrder(Tax currentTax, BigDecimal totalSineTax);
    
    BigDecimal getLabor(Product currentProduct, BigDecimal area);
    
    BigDecimal getMaterial(Product currentProduct, BigDecimal area);
    
    BigDecimal getOrderCapitalCost(BigDecimal taxAmount, BigDecimal totalSineTax) throws
            FlooringPersistenceException;

    List<Order> getOrder(LocalDate date) throws
            FlooringPersistenceException,
            FlooringNoOrdersForThatDateException;
    
    Collection<Tax> getAllTaxes()throws
            FlooringPersistenceException;

    Order removeOrder(LocalDate date, int orderNumber) throws
            FlooringPersistenceException,
            FlooringNoOrdersForThatDateException;
  
    Collection<Product> getAllTheProducts()
            throws FlooringPersistenceException;
    
    int getNewOrderNumber()
            throws FlooringPersistenceException;
    
    void saveOrder()throws 
            FlooringPersistenceException;
}
