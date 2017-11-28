package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringAuditDao;
import com.sg.flooringmastery.dao.FlooringDaoOrderTraining;
import com.sg.flooringmastery.dao.FlooringDaoOrderTrainingImpl;
import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
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
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    
    FlooringOrderDao daoOrder = new FlooringOrderDaoImpl();
    FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    FlooringTaxDao daoTax = new FlooringTaxDaoImpl();
    FlooringDaoOrderTraining daoOrderTraining = new FlooringDaoOrderTrainingImpl();
    

    public FlooringServiceLayerImpl(FlooringOrderDao daoOrder,
            FlooringProductDao daoProduct, FlooringTaxDao daoTax,
            FlooringDaoOrderTraining daoOrderTraining) throws FlooringPersistenceException {
        this.daoOrder = daoOrder;
        this.daoProduct = daoProduct;
        this.daoTax = daoTax;
        this.daoOrderTraining = daoOrderTraining;
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
        BigDecimal productCostPerSqFt = currentProduct.getProductCostPerSqFt().setScale(2, HALF_UP);
        BigDecimal totalMaterial = productCostPerSqFt.multiply(area).setScale(2, HALF_UP);
        return totalMaterial;
    }
    
    @Override
    public BigDecimal getLabor(Product currentProduct, BigDecimal area){
        BigDecimal laborCostPerSqFt = currentProduct.getLaborCostPerSqFt().setScale(2, HALF_UP);
        BigDecimal totalLabor = laborCostPerSqFt.multiply(area).setScale(2, HALF_UP);
        return totalLabor;
    }
    
    @Override
    public BigDecimal getTotalSineTax(BigDecimal totalMaterial, BigDecimal totalLabor){
        
        BigDecimal totalSineTax = totalLabor.add(totalMaterial).setScale(2, HALF_UP);
        return totalSineTax;
    }
    
    @Override
    public BigDecimal getTaxesForOrder(Tax currentTax, BigDecimal totalSineTax){
        BigDecimal taxRate = currentTax.getTaxRate().setScale(2, HALF_UP);
        BigDecimal taxAmount = totalSineTax.multiply(taxRate).setScale(2, HALF_UP);
        return taxAmount;
    }
    @Override
    public BigDecimal getOrderCapitalCost(BigDecimal taxAmount, BigDecimal totalSineTax) {
        BigDecimal total = totalSineTax.add(taxAmount).setScale(2, HALF_UP);
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
    public Order getOrderForEdit(LocalDate date, List<Order> orderToday, int orderNumber) throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        return daoOrder.getOrderForEdit(date, orderToday, orderNumber);
    }
    
    @Override
    public Order updateAnOrder(LocalDate date, Order currentOrder)throws FlooringPersistenceException{
        return daoOrder.updateAnOrder(date, currentOrder);
    }
}