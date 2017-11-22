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
import java.time.LocalDate;
import java.util.Collection;
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
    public void addOrder(LocalDate dates, Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException {

        validateOrderData(order);
        try {
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
    public Collection<Product> getAllTheProducts() throws FlooringPersistenceException{
        return daoProduct.getAllProducts();
    }

    @Override
    public Order getOrderCapitalCost(Order order, Collection<Tax> taxInfo, Collection<Product> productInfo) {
        
        BigDecimal myMaterial = ZERO;
        BigDecimal myLabor = ZERO;
        BigDecimal myArea = ZERO;
        BigDecimal totalMaterial = ZERO;
        BigDecimal totalLabor = ZERO;
        BigDecimal total = ZERO;
        BigDecimal taxRate = ZERO;
        BigDecimal taxAmount = ZERO;    
        BigDecimal totalSineTax = ZERO;
                      
        myMaterial = order.getProduct().getProductCostPerSqFt();
        myLabor = order.getProduct().getLaborCostPerSqFt();
        myArea = order.getArea();
        totalMaterial = totalMaterial.add(myArea.multiply(myMaterial));
        totalLabor = totalLabor.add(myArea.multiply(myLabor));
        totalSineTax = totalMaterial.add(totalLabor);
        
        taxAmount = totalSineTax.multiply(taxRate);
        total = totalSineTax.add(taxAmount);
       
        order.setMaterialCost(totalMaterial);
        order.setLaborCost(totalLabor);
        order.getTax().setTaxAmount(taxAmount);
        order.setTotal(total);
        return order;
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

    @Override
    public Collection<Tax> getAllTaxes() throws FlooringPersistenceException {
        return daoTax.getAllTaxes();
    }
}