
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringAuditDao;
import com.sg.flooringmastery.dao.FlooringDaoOrderStubImpl;
import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
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
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


public class FlooringServiceLayerStub implements FlooringServiceLayerTraining {

    public FlooringOrderDao daoOrder= new FlooringDaoOrderStubImpl();
    FlooringProductDao daoProduct;
    FlooringTaxDao daoTax;
    FlooringAuditDao auditDao;

    public FlooringServiceLayerStub(FlooringProductDao daoProduct, FlooringTaxDao daoTax, FlooringAuditDao auditDao) throws FlooringPersistenceException {
        this.daoOrder = new FlooringDaoOrderStubImpl();
        this.daoTax = new FlooringTaxDaoImpl();
        this.daoProduct = new FlooringProductDaoImpl();
        this.daoProduct = daoProduct;
        this.daoTax = daoTax;
        this.auditDao = auditDao;
    }


    @Override
    public Order addOrder(LocalDate dates, Order currentOrder) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {

        validateOrderData(currentOrder);

        return daoOrder.addOrder(dates, currentOrder);
    }

    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException {
        return daoOrder.getOrder(date);
    }

    @Override
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
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
    
    

    private void validateOrderData(Order currentOrder) throws
            FlooringDataValidationException {

        if (currentOrder.getOrderDate() == null
                || currentOrder.getOrderNumber() == 0
                || currentOrder.getArea() == null
                || currentOrder.getArea() == ZERO
                || currentOrder.getTax().getState().length() > 2 
                || currentOrder.getTax().getState() == null
                || currentOrder.getProduct().getProductType().length() > 8) {

            throw new FlooringDataValidationException(
                    "ERROR: All fields [Order number, order Date"
                    + " product type, state, and area] are required.");
        }
    }

    @Override
    public Collection<Tax> getAllTaxes() throws FlooringPersistenceException {
        return daoTax.getAllTaxes();
    }

    @Override
    public Order getOrderForEdit(List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        return daoOrder.getOrderForEdit(orderToday, orderNumber);
    }
    
    @Override
    public Order updateAnOrder(LocalDate date, Order currentOrder)throws FlooringPersistenceException{
        return daoOrder.updateAnOrder(date, currentOrder);
    }
}
