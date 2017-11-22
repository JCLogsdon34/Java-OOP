package com.sg.flooringmastery.dto;

import java.math.BigDecimal;

public class Tax {
    
    public String state;
    public BigDecimal taxRate;
    public BigDecimal taxAmount;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }
}
