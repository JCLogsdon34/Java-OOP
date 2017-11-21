package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
import java.util.List;

public interface FlooringProductDao {

    List<Product> getAllProducts()
            throws FlooringPersistenceException;

    Product getProductByType(String productType)
            throws FlooringPersistenceException;

    BigDecimal getProductCostPerSqFt(String productType, Product product)
            throws FlooringPersistenceException;

    BigDecimal getLaborCostPerSqFt(String productType, Product product)
            throws FlooringPersistenceException;
    
    void loadProduct() throws FlooringPersistenceException;
    
    void writeProduct() throws FlooringPersistenceException;
}
