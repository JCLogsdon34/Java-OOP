
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;


public class Tax {
    public BigDecimal taxRate;
    public String state;
    
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
}
