package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringAuditDao;
import com.sg.flooringmastery.dao.FlooringAuditDaoImpl;
import com.sg.flooringmastery.dao.FlooringDaoOrderStub;
import com.sg.flooringmastery.dao.FlooringDaoOrderStubImpl;
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
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringServiceLayerImplTest {

    FlooringDaoOrderStub daoOrder = new FlooringDaoOrderStubImpl();
    FlooringTaxDao daoTax = new FlooringTaxDaoImpl();
    FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    FlooringAuditDao auditDao = new FlooringAuditDaoImpl();

    FlooringServiceLayerTraining service;

    public FlooringServiceLayerImplTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("service", FlooringServiceLayerTraining.class);
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException {

        //  List<Order>orderList = daoOrder.getOrder();
        //    for(Order currentOrder : orderList) {
        //      daoOrder.removeOrder(currentOrder.getOrderDate(), currentOrder.getOrderNumber());
        //}
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLoadTheOrders() throws FlooringPersistenceException {

    }

    @Test
    public void testAddOrder() throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
          currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = service.getNewOrderNumber();
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Crockett");
        currentOrder.getTax().setState("TN");
        currentOrder.getTax().setTaxRate(new BigDecimal(6.75));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal(11));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
        currentOrder.setMaterialCost(new BigDecimal(55));
        currentOrder.setLaborCost(new BigDecimal(44));
        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
        currentOrder.setTotal(new BigDecimal(22.11));

        daoOrder.addOrder(myDate, currentOrder);

        Order order = service.addOrder(myDate, currentOrder);
        Order fromDao = daoOrder.addOrder(myDate, currentOrder);

        assertEquals(order, fromDao);
    }

    @Test
    public void testAddInvalidOrder() throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        Order currentOrder = new Order();
         currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = service.getNewOrderNumber();
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Crockett");
        currentOrder.getTax().setState("WVA");
        currentOrder.getTax().setTaxRate(new BigDecimal(6.75));
        currentOrder.getProduct().setProductType("Venetian Marble");
        currentOrder.setArea(new BigDecimal(11));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
        currentOrder.setMaterialCost(new BigDecimal(55));
        currentOrder.setLaborCost(new BigDecimal(44));
        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
        currentOrder.setTotal(new BigDecimal(22.11));
        try {
            service.addOrder(myDate, currentOrder);
            fail("Expected FlooringDataValidationException was not thrown");
        } catch (FlooringDataValidationException e) {
            return;
        }
    }

    @Test
    public void testGetOrder() throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "11-25-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        Order currentOrder = new Order();
        
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));

        List<Order> servList = service.getOrder(myDate);
        List<Order> fromDao = daoOrder.getOrder(myDate);
        
        int orderNumber = servList.size();
        int expectedOrderNumber = fromDao.size();
        
        assertEquals(orderNumber, expectedOrderNumber);
    }

    @Test
    public void testRemoveOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "11-25-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        String orderNumberS = "3";
        int orderNumber = Integer.parseInt(orderNumberS);
        Order myOrder = daoOrder.removeOrder(myDate, orderNumber);
        Order servOrder = service.removeOrder(myDate, orderNumber);
        String customerName = myOrder.getCustomerName();
        String expectedResult = servOrder.getCustomerName();
        assertEquals(customerName, expectedResult);
    }

    @Test
    public void testGetTotalSineTax() {

    }

    @Test
    public void testGetTaxesForOrder() {

    }

    @Test
    public void testGetOrderCapitalCost() {

    }

    @Test
    public void testGetNewOrderNumber() throws FlooringPersistenceException {

    }

    @Test
    public void testSaveOrder() {

    }

    @Test
    public void testGetAllTaxes() throws FlooringPersistenceException {
        Collection<Tax> fromServiceLayer = service.getAllTaxes();
        String states = "KY";
        Order currentOrder = new Order();

        for (Iterator<Tax> it = fromServiceLayer.iterator(); it.hasNext();) {
            Tax ts = it.next();
            if (ts.getState().equals(states)) {
                BigDecimal taxs = ts.getTaxRate();
                currentOrder.getTax().setTaxRate(taxs);
            }
        }

        Collection<Tax> fromDao = daoTax.getAllTaxes();
        Order myOrder = new Order();
        String state = "KY";
        for (Iterator<Tax> it = fromDao.iterator(); it.hasNext();) {
            Tax ts = it.next();
            if (ts.getState().equals(state)) {
                BigDecimal tax = ts.getTaxRate();
                myOrder.getTax().setTaxRate(tax);
            }
        }
        BigDecimal expectedResult = currentOrder.getTax().getTaxRate();
        BigDecimal myResult = myOrder.getTax().getTaxRate();
        assertEquals(expectedResult, myResult);
    }

    @Test
    public void testGetAllProducts() throws FlooringPersistenceException {
        Collection<Product> fromDao = daoProduct.getAllProducts();
        BigDecimal expectedResult;
        Order newOrder = new Order();
        String myProduct = "Wood";
        for (Iterator<Product> it = fromDao.iterator(); it.hasNext();) {
            Product ps = it.next();
            if (ps.getProductType().equals(myProduct)) {
                BigDecimal prodCost = ps.getProductCostPerSqFt();
                BigDecimal labCost = ps.getLaborCostPerSqFt();
                newOrder.getProduct().setProductCostPerSqFt(prodCost);
                newOrder.getProduct().setLaborCostPerSqFt(labCost);
            }
        }
        BigDecimal theResult;
        String theProduct = "Wood";
        Order currentOrder = new Order();
        Collection<Product> fromServiceLayer = service.getAllTheProducts();
        for (Iterator<Product> il = fromServiceLayer.iterator(); il.hasNext();) {
            Product pl = il.next();
            if (pl.getProductType().equals(theProduct)) {
                BigDecimal prodCost = pl.getProductCostPerSqFt();
                BigDecimal labCost = pl.getLaborCostPerSqFt();
                currentOrder.getProduct().setProductCostPerSqFt(prodCost);
                currentOrder.getProduct().setLaborCostPerSqFt(labCost);
            }
        }
        theResult = currentOrder.getProduct().getProductCostPerSqFt();
        expectedResult = newOrder.getProduct().getProductCostPerSqFt();
        assertEquals(expectedResult, theResult);
    }

    @Test
    public void testGetOrderForEdit() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "06-01-2013";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        //   currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
      //  int orderNumber = service.getNewOrderNumber();
        currentOrder.setOrderNumber((1));
        currentOrder.setCustomerName("Wise");
        currentOrder.getTax().setState("OH");
        currentOrder.getTax().setTaxRate(new BigDecimal(5.25));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal(11));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
        currentOrder.setMaterialCost(new BigDecimal(55));
        currentOrder.setLaborCost(new BigDecimal(44));
        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
        currentOrder.setTotal(new BigDecimal(22.11));

        List<Order> myOrders = new ArrayList<>();
        myOrders.add(currentOrder);
        daoOrder.addOrder(myDate, currentOrder);

        Order fromDao = daoOrder.getOrderForEdit(myOrders, 1);
        Order fromServ = service.getOrderForEdit(myOrders, 1);
             
        fromDao.setArea(BigDecimal.ONE);
        BigDecimal result = fromDao.getArea();
        fromServ.setArea(BigDecimal.ONE);
        BigDecimal myResult = fromServ.getArea();
        assertEquals(result, myResult);
    }

    @Test
    public void testUpdateAnOrder() {

    }

    @Test
    public void testGetOneOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "06-01-2013";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        //   currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
        int orderNumber = 1;
        currentOrder.setOrderNumber((orderNumber));
        currentOrder.setCustomerName("Wise");
        currentOrder.getTax().setState("OH");
        currentOrder.getTax().setTaxRate(new BigDecimal(6.25));
        currentOrder.getProduct().setProductType("Wood");
        currentOrder.setArea(new BigDecimal(100.00));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(5.15));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(4.75));
        currentOrder.setMaterialCost(new BigDecimal(515.00));
        currentOrder.setLaborCost(new BigDecimal(475.00));
        currentOrder.getTax().setTaxAmount(new BigDecimal(61.88));
        currentOrder.setTotal(new BigDecimal(1051.88));
        
        daoOrder.addOrder(myDate, currentOrder);
        
        List<Order> anOrder = new ArrayList<>();
        anOrder.add(currentOrder);
        Order fromServ = service.getOrderForEdit(anOrder, orderNumber);
        Order fromDao = daoOrder.getOrderForEdit(anOrder, orderNumber);
        BigDecimal fromS = fromServ.getArea();
        BigDecimal fromD = fromDao.getArea();
        assertEquals(fromS, fromD);
    }
}
