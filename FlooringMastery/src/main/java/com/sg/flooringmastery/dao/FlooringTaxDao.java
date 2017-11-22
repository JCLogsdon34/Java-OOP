package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Tax;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Collection;

public interface FlooringTaxDao {

    Collection<Tax> getAllTaxes()
            throws FlooringPersistenceException;

    BigDecimal getTax(String state)
            throws FlooringPersistenceException;
    
    void loadTax() throws FlooringPersistenceException, FileNotFoundException;
    
}
