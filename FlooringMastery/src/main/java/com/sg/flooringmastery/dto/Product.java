
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;


public class Product {
    
    public String productType;
    public BigDecimal productCostPerSqFt;
    public BigDecimal laborCostPerSqFt;
    
    public String getProductType() {
        return productType;
    }
    
    public void setProductType(String productType) {
        this.productType = productType;
    }
    
    public BigDecimal getProductCostPerSqFt() {
        return productCostPerSqFt;
    }
    
    public void setProductCostPerSqFt(BigDecimal productCostPerSqFt) {
        this.productCostPerSqFt = productCostPerSqFt;
    }
    
    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }
    
    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }
}
