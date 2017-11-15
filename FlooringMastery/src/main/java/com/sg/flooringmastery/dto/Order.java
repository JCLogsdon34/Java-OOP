
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;


public class Order {
    
    public int orderNumber;
    public String customerName;
    public Product product;
    public Tax tax;
    public BigDecimal area;
    public BigDecimal materialCost;
    public BigDecimal laborCost;
    public BigDecimal total;
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Tax getTax() {
        return tax;
    }
    
    public void setTax(Tax tax) {
        this.tax = tax;
    }
    
    public BigDecimal getArea() {
        return area;
    }
    
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }
    
    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }
    
    public BigDecimal getLaborCost() {
        return laborCost;
    }
    
    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }
    
    public BigDecimal getTotal() {
        return total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
}
