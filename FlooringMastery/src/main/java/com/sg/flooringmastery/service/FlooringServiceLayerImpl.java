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
import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlooringServiceLayerImpl implements FlooringServiceLayer {

    FlooringOrderDao daoOrder = new FlooringOrderDaoImpl();
    FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    FlooringTaxDao daoTax = new FlooringTaxDaoImpl();

    public FlooringServiceLayerImpl(FlooringOrderDao daoOrder,
            FlooringProductDao daoProduct, FlooringTaxDao daoTax) {
        this.daoOrder = daoOrder;
        this.daoProduct = daoProduct;
        this.daoTax = daoTax;
    }

    @Override
    public void loadTheOrders() throws FlooringPersistenceException {
        daoProduct.loadProduct();
        daoTax.loadTax();
        daoOrder.loadOrder();
    }

    @Override
    public void addOrder(Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException {

        validateOrderData(order);
        LocalDate dates = LocalDate.now();

        try {
            //    int orderNumber = daoOrder.getNewOrderNumber(order);
            daoOrder.addOrder(dates, order);
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
    public Order getOrderCapitalCost(Order order) {
        String productType = order.getProduct().getProductType();
        String state = order.getTax().getState();
        BigDecimal myMaterial = ZERO;
        BigDecimal myLabor = ZERO;
        BigDecimal myArea = ZERO;
        BigDecimal totalMaterial = ZERO;
        BigDecimal totalLabor = ZERO;
        BigDecimal total = ZERO;
        BigDecimal taxRate = ZERO;
        BigDecimal taxAmount = ZERO;
        
        try {
            daoProduct.loadProduct();
            daoTax.loadTax();
            myMaterial = myMaterial.add(daoProduct.getProductCostPerSqFt(productType));
            myLabor = myLabor.add(daoProduct.getLaborCostPerSqFt(productType));
            myArea = myArea.add(order.getArea());
            totalMaterial = totalMaterial.add(myArea.multiply(myMaterial));
            totalLabor = totalLabor.add(myArea.multiply(myLabor));
            total = totalMaterial.add(totalLabor);
            taxRate = taxRate.add(daoTax.getTax(state));
            taxAmount = taxAmount.add(getTaxForOrder(total, taxRate));
            total = total.add(taxAmount);
        } catch (FlooringPersistenceException e) {
            System.out.println("Could not load data");
        }
        order.getProduct().setProductCostPerSqFt(myMaterial);
        order.getProduct().setProductCostPerSqFt(myLabor);
        order.setMaterialCost(totalMaterial);
        order.setLaborCost(totalLabor);
        order.getTax().setTaxAmount(taxAmount);
        order.setTotal(total);
        return order;
    }

    public BigDecimal getTaxForOrder(BigDecimal total, BigDecimal taxRate) throws FlooringPersistenceException {
        return daoTax.getTaxAmount(total, taxRate);
    }

    @Override
    public Order getNewOrderNumber(Order newOrder) throws FlooringPersistenceException {
        return daoOrder.getNewOrderNumber(newOrder);
    }

    @Override
    public void saveOrder() throws FlooringPersistenceException {
        daoOrder.saveOrder();
    }

    private void validateOrderData(Order order) throws
            FlooringDataValidationException {

        if (order.getOrderDate() == null
                || order.getOrderNumber() == 0
                || order.getArea() == null) {

            throw new FlooringDataValidationException(
                    "ERROR: All fields [Order number, order Date, customer name"
                    + " product type, state, and area] are required.");
        }
    }
}
