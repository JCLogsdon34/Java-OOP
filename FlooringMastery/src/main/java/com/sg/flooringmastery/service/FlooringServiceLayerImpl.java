
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
      
        validateOrderData(order);
        LocalDate dates = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMDDYYYY");
        String text = dates.format(dateFormat);
        LocalDate date = LocalDate.parse(text, dateFormat);
      //  String myDate = date.format(dateFormat);

    //    int orderNumber = daoOrder.getNewOrderNumber(order);        
        daoOrder.addOrder(date, order);
    }
  /*  
    public int getNewOrderNumber(Order order) {
        int orderNumber = orderData.size() + 1;
        orderNumber = getOrderNumber();
        return orderNumber;
    }
*/
    @Override
    public List<Order> getOrder(LocalDate date) throws FlooringPersistenceException,
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
    public Order removeOrder(LocalDate date, int orderNumber) throws FlooringPersistenceException, FlooringOrdersForThatDateException {
       return daoOrder.removeOrder(date, orderNumber);
    }

    @Override
    public Order getOrderCapitalCost(Order order) throws FlooringDataValidationException {
      BigDecimal myMaterial = order.getProduct().getProductCostPerSqFt();
      order.getProduct().setProductCostPerSqFt(myMaterial);
      BigDecimal myLabor = order.getProduct().getLaborCostPerSqFt();
      order.getProduct().setProductCostPerSqFt(myLabor);
      BigDecimal myArea = order.getArea();
      BigDecimal taxRate = order.getTax().getTaxRate();
      
      BigDecimal totalMaterial = myArea.multiply(myMaterial);
      BigDecimal totalLabor = myArea.multiply(myLabor);
      
      BigDecimal total = totalMaterial.add(totalLabor);
      
      order.setMaterialCost(totalMaterial);
      order.setLaborCost(totalLabor);
        try {
            BigDecimal taxAmount = getTaxForOrder(total, taxRate);
            total = total.add(taxAmount);
            order.getTax().setTaxAmount(taxAmount);
        } catch (FlooringPersistenceException e) {
            System.out.println("Could not look up data");
        }
      order.setTotal(total);
      return order;
    }
    
    public BigDecimal getTaxForOrder(BigDecimal total, BigDecimal taxRate) throws FlooringPersistenceException{
        return daoTax.getTaxAmount(total, taxRate);
    }
    
}
