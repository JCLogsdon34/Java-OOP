package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
import com.sg.flooringmastery.dao.FlooringOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dao.FlooringProductDao;
import com.sg.flooringmastery.dao.FlooringProductDaoImpl;
import com.sg.flooringmastery.dao.FlooringTaxDao;
import com.sg.flooringmastery.dao.FlooringTaxDaoImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.math.MathContext;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    
    FlooringOrderDao daoOrder = new FlooringOrderDaoImpl();
    FlooringProductDao daoProduct;
    FlooringTaxDao daoTax;

    public FlooringServiceLayerImpl(FlooringOrderDao daoOrder,
            FlooringProductDao daoProduct, FlooringTaxDao daoTax) throws FlooringPersistenceException {
        this.daoTax = new FlooringTaxDaoImpl();
        this.daoProduct = new FlooringProductDaoImpl();
        this.daoOrder = daoOrder;
        this.daoProduct = daoProduct;
        this.daoTax = daoTax;
    }

    @Override
    public void loadTheOrders() throws FlooringPersistenceException {
/*        daoProduct.loadProduct();
        daoTax.loadTax();
        daoOrder.loadOrder();
*/
    }

    @Override
    public void addOrder(LocalDate dates, Order currentOrder) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException {

        validateOrderData(currentOrder);
        try {
            daoOrder.addOrder(dates, currentOrder);
        } catch (FlooringPersistenceException e) {
            System.out.println("Could not load date");
        }
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException,
            FlooringOrdersForThatDateException {
        return daoOrder.getOrder(date);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        return daoOrder.removeOrder(date, orderNumber);
    }
    
    @Override
    public Collection<Product> getAllTheProducts() throws FlooringPersistenceException{
        return daoProduct.getAllProducts();
    }

    @Override
    public BigDecimal getMaterial(Product currentProduct, BigDecimal area){
        BigDecimal productCostPerSqFt = currentProduct.getProductCostPerSqFt();
        BigDecimal totalMaterial = productCostPerSqFt.multiply(area);
        return totalMaterial;
    }
    
    @Override
    public BigDecimal getLabor(Product currentProduct, BigDecimal area){
        BigDecimal laborCostPerSqFt = currentProduct.getLaborCostPerSqFt();
        BigDecimal totalLabor = laborCostPerSqFt.multiply(area);
        return totalLabor;
    }
    
    @Override
    public BigDecimal getTotalSineTax(BigDecimal totalMaterial, BigDecimal totalLabor){
        
        BigDecimal totalSineTax = totalLabor.add(totalMaterial);
        return totalSineTax;
    }
    
    @Override
    public BigDecimal getTaxesForOrder(Tax currentTax, BigDecimal totalSineTax){
        BigDecimal taxRate = currentTax.getTaxRate();
        BigDecimal taxAmount = totalSineTax.multiply(taxRate);
        return taxAmount;
    }
    @Override
    public BigDecimal getOrderCapitalCost(BigDecimal taxAmount, BigDecimal totalSineTax) {
        BigDecimal total = totalSineTax.add(taxAmount);
        return total;
    }

    @Override
    public int getNewOrderNumber() throws FlooringPersistenceException {
        return daoOrder.getNewOrderNumber();
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
        daoOrder.saveOrder();
    }
    
    

    private void validateOrderData(Order currentOrder) throws
            FlooringDataValidationException {

        if (currentOrder.getOrderDate() == null
                || currentOrder.getOrderNumber() == 0
                || currentOrder.getArea() == null) {

            throw new FlooringDataValidationException(
                    "ERROR: All fields [Order number, order Date, customer name"
                    + " product type, state, and area] are required.");
        }
    }

    @Override
    public Collection<Tax> getAllTaxes() throws FlooringPersistenceException {
        return daoTax.getAllTaxes();
    }

    @Override
    public Order getOrderForEdit(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
        return daoOrder.getOrderForEdit(date, orderNumber);
    }
}