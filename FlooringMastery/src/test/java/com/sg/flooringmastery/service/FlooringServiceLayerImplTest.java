package com.sg.flooringmastery.service;

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
import com.sg.flooringmastery.dao.FlooringDaoOrderTrainingImpl;
import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
import com.sg.flooringmastery.dao.FlooringOrderDaoStubImpl;

public class FlooringServiceLayerImplTest {

    private FlooringOrderDao daoOrder = new FlooringOrderDaoStubImpl();
    private FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    private FlooringTaxDao daoTax = new FlooringTaxDaoImpl();

    private FlooringServiceLayer service;
           

    public FlooringServiceLayerImplTest() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("service", FlooringServiceLayerImpl.class);
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
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
          List<Order>orderList = daoOrder.getOrder(myDate);
          orderList.add(currentOrder);
            for(Order myOrder : orderList) {
              daoOrder.removeOrder(currentOrder.getOrderDate(), currentOrder.getOrderNumber());
        }
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
        String date = "01-12-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        LocalDate late = LocalDate.parse(date, dateFormat);
        String orderNumberString = "3";
        int orderNumber = Integer.parseInt(orderNumberString);

        Order currentOrder = service.removeOrder(myDate, orderNumber);
        assertNotNull(currentOrder);
        Order myOrder = service.removeOrder(late, orderNumber);
        assertNull(myOrder);
    }
    
    @Test
    public void getMaterial() {
        Product currentProduct = new Product();
        currentProduct.setProductType("Wood");
        BigDecimal area = new BigDecimal("12").setScale(2, HALF_UP);
        BigDecimal productCostPerSqFt = currentProduct.getProductCostPerSqFt().setScale(2, HALF_UP);
        BigDecimal totalMaterial = productCostPerSqFt.multiply(area).setScale(2, HALF_UP);
        
       // BigDecimal expectedMaterial = new BigDecimal("")
    }

    @Test
    public void getLabor() {
        Product currentProduct = new Product();
        currentProduct.setProductType("Wood");
        BigDecimal area = new BigDecimal("12").setScale(2, HALF_UP);
        BigDecimal laborCostPerSqFt = currentProduct.getLaborCostPerSqFt().setScale(2, HALF_UP);
        BigDecimal totalLabor = laborCostPerSqFt.multiply(area).setScale(2, HALF_UP);
 
    }

    @Test
    public void testGetTotalSineTax() {
        BigDecimal expectedResult = new BigDecimal("15").setScale(2, HALF_UP);
        BigDecimal totalLabor = new BigDecimal("10").setScale(2, HALF_UP);
        BigDecimal totalMaterial = new BigDecimal("5").setScale(2, HALF_UP);
        BigDecimal totalSineTax = totalLabor.add(totalMaterial).setScale(2, HALF_UP);
        assertEquals(expectedResult, totalSineTax);
    }

    @Test
    public void testGetTaxesForOrder() {
        Tax currentTax = new Tax();
        currentTax.setState("KY");
        BigDecimal totalSineTax= new BigDecimal("10").setScale(2, HALF_UP);
        BigDecimal expectedResult = new BigDecimal("57.50").setScale(2, HALF_UP);
        BigDecimal taxRate = currentTax.getTaxRate().setScale(2, HALF_UP);
        BigDecimal taxAmount = totalSineTax.multiply(taxRate).setScale(2, HALF_UP);
        assertEquals(expectedResult, taxAmount);
    }

    @Test
    public void testGetOrderCapitalCost() {
        BigDecimal expectedResult = new BigDecimal("12").setScale(2, HALF_UP);
        BigDecimal totalSineTax= new BigDecimal("10").setScale(2, HALF_UP);
        BigDecimal taxAmount = new BigDecimal("2").setScale(2, HALF_UP);
        BigDecimal total = totalSineTax.add(taxAmount).setScale(2, HALF_UP);
        assertEquals(expectedResult, total);
    }

    @Test
    public void testGetNewOrderNumber() throws FlooringPersistenceException {
        int expectedResult = 4;
        int orderNumber = daoOrder.getNewOrderNumber();
        assertEquals(expectedResult, orderNumber);
    }

    @Test
    public void testSaveOrder() throws FlooringPersistenceException {
        daoOrder.saveOrder();
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

        Order fromDao = daoOrder.getOrderForEdit(myDate, myOrders, 1);
        Order fromServ = service.getOrderForEdit(myDate, myOrders, 1);
             
        fromDao.setArea(BigDecimal.ONE);
        BigDecimal result = fromDao.getArea();
        fromServ.setArea(BigDecimal.ONE);
        BigDecimal myResult = fromServ.getArea();
        assertEquals(result, myResult);
    }

    @Test
    public void testUpdateAnOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
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
        Order fromServ = service.getOrderForEdit(myDate, anOrder, orderNumber);
        Order fromDao = daoOrder.getOrderForEdit(myDate, anOrder, orderNumber);
        
         currentOrder.setCustomerName("John");
        
        Order fromSer = service.updateAnOrder(myDate, currentOrder);
        Order fromDaoOrder = daoOrder.updateAnOrder(myDate, currentOrder);
        
        BigDecimal fromS = fromServ.getArea();
        BigDecimal fromD = fromDao.getArea();
        assertEquals(fromS, fromD);
    }
}
