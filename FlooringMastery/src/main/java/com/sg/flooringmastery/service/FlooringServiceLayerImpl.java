
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dao.FlooringProductDao;
import com.sg.flooringmastery.dao.FlooringProductDaoImpl;
import com.sg.flooringmastery.dao.FlooringTaxDao;
import com.sg.flooringmastery.dao.FlooringTaxDaoImpl;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;


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
    public void addOrder(Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {

        if (daoOrder.getOrder(order.getOrderNumber()) != null) {
            throw new FlooringDuplicateOrderException(
                    "ERROR: Could not create Order.  Order number"
                    + order.getOrderNumber()
                    + " already exists");
        }
        validateOrderData(order);
        
        order.addOrder(order.getOrderNumber(), order);
/*
        auditDao.writeAuditEntry(
                "Dvd " + dvd.getDvdTitle() + " CREATED.");
*/
    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        return daoOrder.getAllOrdersByDate();
    }

    @Override
    public Order getOrder(int orderNumber, LocalDate date) throws FlooringPersistenceException {
        return daoOrder.getOrder(LocalDate date, int orderNumber);
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
