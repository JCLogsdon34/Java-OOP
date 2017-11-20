
package com.sg.flooringmastery.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Order {
    
  
    public LocalDate orderDate;
    public int orderNumber;  
    public String customerName;
    public Tax tax = new Tax();
    public Product product = new Product();
    public BigDecimal area;
    public BigDecimal materialCost;
    public BigDecimal laborCost;
    public BigDecimal total;
    
   
    
/*   public Order(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    
*/ 
    public Order(){
        this.tax = new Tax();
        this.product = new Product();
    }
    
    public LocalDate getOrderDate(){
        return orderDate;
    }
   
    public void setOrderDate(LocalDate orderDate){
        this.orderDate = orderDate;
    }

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

    public Tax getTax() {
        return tax;
    }
    
    public void setTax(Tax tax) {
        this.tax = tax;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
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
