package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.util.List;

public interface FlooringTaxDao {

    List<Tax> getTaxesByState()
            throws FlooringPersistenceException;

    BigDecimal getTax(String state)
            throws FlooringPersistenceException;
    
    void loadTax() throws FlooringPersistenceException;
    
    void writeTax() throws FlooringPersistenceException;
}
