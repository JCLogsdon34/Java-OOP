
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
    
/*    public BigDecimal getTaxRateByState(Order order){
        String state = currentTax.getState();
        return daoTax.getTax();
        
    }
    */
    @Override
    public void addOrder(Order order) throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {

/*        if (daoOrder.getOrder(order.getOrderNumber()) != 0) {
            throw new FlooringDuplicateOrderException(
                    "ERROR: Could not create Order.  Order number"
                    + order.getOrderNumber()
                    + " already exists");
        }
*/      
        validateOrderData(order);
    //    int orderNumber = daoOrder.getNewOrderNumber(order);        
        daoOrder.addOrder(order.getOrderDate(), order);
    }
  /*  
    public int getNewOrderNumber(Order order) {
        int orderNumber = orderData.size() + 1;
        orderNumber = getOrderNumber();
        return orderNumber;
    }
*/
    @Override
    public Order getOrder(LocalDate date) throws FlooringPersistenceException,
            FlooringOrdersForThatDateException{
        return daoOrder.getOrder(date);
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
    public Order removeOrder(int orderNumber, LocalDate date) throws FlooringPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
