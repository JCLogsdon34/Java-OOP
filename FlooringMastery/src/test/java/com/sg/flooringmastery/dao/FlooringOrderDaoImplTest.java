
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FlooringOrderDaoImplTest {
    
    private static FlooringOrderDao daoOrder;

    
    public FlooringOrderDaoImplTest() {
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    daoOrder = 
        ctx.getBean("daoOrder", FlooringOrderDaoStubImpl.class);
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order oneOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        List<Order> orderList = daoOrder.getOrder(myDate);
        orderList.add(oneOrder);
        for (Order currentOrder : orderList) {
            daoOrder.removeOrder(currentOrder.getOrderDate(), currentOrder.getOrderNumber());
        }
    }
    
    @After
    public void tearDown() {
    }

  

    @Test
    public void testUpdateAnOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException, FlooringDaoException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 1;
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Wise");
        currentOrder.getTax().setState("OH");
        currentOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal("100").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal("5.15").setScale(2, HALF_UP));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, HALF_UP));
        currentOrder.setMaterialCost(new BigDecimal("515").setScale(2, HALF_UP));
        currentOrder.setLaborCost(new BigDecimal("475").setScale(2, HALF_UP));
        currentOrder.getTax().setTaxAmount(new BigDecimal("61.88").setScale(2, HALF_UP));
        currentOrder.setTotal(new BigDecimal("1051.88").setScale(2, HALF_UP));

        daoOrder.addOrder(myDate, currentOrder);

        List<Order> anOrder = new ArrayList<>();
        anOrder.add(currentOrder);
        Order fromServ = daoOrder.getOrderForEdit(myDate, anOrder, orderNumber);

        currentOrder.setCustomerName("John");
        BigDecimal fromS = fromServ.getArea().setScale(2, HALF_UP);
        BigDecimal expectedResult = new BigDecimal("11").setScale(2, HALF_UP);
        assertEquals(fromS, expectedResult);
    }

    
    @Test
    public void testSaveOrder() throws FlooringPersistenceException {
        daoOrder.saveOrder();
    }
@Test
    public void testRemoveOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException, FlooringDaoException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
  
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 4;
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Kenton");
        currentOrder.getTax().setState("TN");
        currentOrder.getTax().setTaxRate(new BigDecimal("6.75").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal("11").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("22").setScale(2, HALF_UP));
        currentOrder.setMaterialCost(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.setLaborCost(new BigDecimal("44").setScale(2, HALF_UP));
        currentOrder.getTax().setTaxAmount(new BigDecimal("322").setScale(2, HALF_UP));
        currentOrder.setTotal(new BigDecimal("22.11").setScale(2, HALF_UP));
        Order mine = new Order();
        List<Order> theOrder = new ArrayList<>(daoOrder.getOrder(myDate));
        Order[] o = new Order[]{daoOrder.addOrder(myDate, currentOrder)};
        Order[] p = new Order[]{daoOrder.removeOrder(myDate, orderNumber)};
        daoOrder.removeOrder(myDate, orderNumber);

        Assert.assertArrayEquals(o, p);
    
    }

    @Test
    public void testAddOrder() throws Exception {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
  
        String dateForFile = myDate.format(dateFormat);
        String myOrder = dateForFile.replace("-", "");
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 4;
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Crockett");
        currentOrder.getTax().setState("TN");
        currentOrder.getTax().setTaxRate(new BigDecimal("6.75").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal("11").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("22").setScale(2, HALF_UP));
        currentOrder.setMaterialCost(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.setLaborCost(new BigDecimal("44").setScale(2, HALF_UP));
        currentOrder.getTax().setTaxAmount(new BigDecimal("322").setScale(2, HALF_UP));
        currentOrder.setTotal(new BigDecimal("22.11").setScale(2, HALF_UP));
        daoOrder.addOrder(myDate, currentOrder);
        Order mine = new Order();
        Order[] a = new Order[]{currentOrder = daoOrder.addOrder(myDate, currentOrder)};
        Order[] b = new Order[]{daoOrder.addOrder(myDate, currentOrder)};

        Assert.assertArrayEquals(a, b);
    }

    @Test
    public void testGetOrder() throws Exception {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        Order currentOrder = new Order();

        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));

        List<Order> servList = new ArrayList<>(daoOrder.getOrder(myDate));
        
        servList.stream().forEach((Order order) -> {
            if(order.getTax().getState() == "TN"){
            String nameState = String.valueOf(order.getTax().getState());
        
        String expectedName = "TN";

        assertEquals(expectedName, nameState);
            }
                });
    }

    @Test
    public void testGetNewOrderNumber() throws FlooringPersistenceException {
      int num = daoOrder.getNewOrderNumber();
      int expectedResult = 4;
      assertEquals(expectedResult, num);
    }
}
