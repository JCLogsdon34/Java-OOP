package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringDaoException;
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

    private static FlooringOrderDao daoOrder = new FlooringOrderDaoStubImpl();
    private static FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    private static FlooringTaxDao daoTax = new FlooringTaxDaoImpl();

    private static FlooringServiceLayer service;

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
    public void setUp() {
        
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
            FlooringPersistenceException,
            FlooringDaoException,
            FlooringNoOrdersForThatDateException {
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
        Order mine = new Order();
        List<Order> theOrder = new ArrayList<>(service.getOrder(myDate));
        daoOrder.addOrder(myDate, currentOrder);
        mine = theOrder.get(0);
        
        String expectedName = "Crockett";
        assertEquals(expectedName, String.valueOf(mine.getCustomerName()));
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
        currentOrder.getTax().setTaxRate(new BigDecimal("6.75").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductType("Carpet");
        currentOrder.setArea(new BigDecimal("11").setScale(2, HALF_UP));
        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("22").setScale(2, HALF_UP));
        currentOrder.setMaterialCost(new BigDecimal("55").setScale(2, HALF_UP));
        currentOrder.setLaborCost(new BigDecimal("44").setScale(2, HALF_UP));
        currentOrder.getTax().setTaxAmount(new BigDecimal("322").setScale(2, HALF_UP));
        currentOrder.setTotal(new BigDecimal("22.11").setScale(2, HALF_UP));
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
        String theDateNow = "01-12-2017";
        LocalDate myDate = LocalDate.parse(theDateNow, dateFormat);
        Order currentOrder = new Order();

        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));

        List<Order> servList = daoOrder.getOrder(myDate);
        
        servList.stream().forEach((Order order) -> {
            String name = order.getCustomerName();
        
        String expectedName = "Crockett";

        assertEquals(expectedName, name);
                });
    }

    @Test
    public void getMaterial() throws FlooringPersistenceException {
        Product currentProduct = new Product();
        String myProduct = "Wood";
        Collection<Product> prod = daoProduct.getAllProducts();
        currentProduct.setProductType(myProduct);
        BigDecimal area = new BigDecimal("12").setScale(2, HALF_UP);
        for (Iterator<Product> it = prod.iterator(); it.hasNext();) {
            Product ps = it.next();
            if (ps.getProductType().equals(myProduct)) {
                BigDecimal prodCost = ps.getProductCostPerSqFt();
                BigDecimal labCost = ps.getLaborCostPerSqFt();
                currentProduct.setProductCostPerSqFt(prodCost);
                currentProduct.setLaborCostPerSqFt(labCost);

                BigDecimal productCostPerSqFt = currentProduct.getProductCostPerSqFt().setScale(2, HALF_UP);
                BigDecimal totalMaterial = productCostPerSqFt.multiply(area).setScale(2, HALF_UP);
                BigDecimal expectedResult = new BigDecimal("61.8").setScale(2, HALF_UP);
                assertEquals(totalMaterial, expectedResult);
            }
        }
    }

    @Test
    public void getLabor() throws FlooringPersistenceException {
        Product currentProduct = new Product();
        String myProduct = "Wood";
        Collection<Product> prod = daoProduct.getAllProducts();
        currentProduct.setProductType(myProduct);
        BigDecimal area = new BigDecimal("12").setScale(2, HALF_UP);
        for (Iterator<Product> it = prod.iterator(); it.hasNext();) {
            Product ps = it.next();
            if (ps.getProductType().equals(myProduct)) {
                BigDecimal prodCost = ps.getProductCostPerSqFt().setScale(2, HALF_UP);
                BigDecimal labCost = ps.getLaborCostPerSqFt().setScale(2, HALF_UP);
                currentProduct.setProductCostPerSqFt(prodCost);
                currentProduct.setLaborCostPerSqFt(labCost);

                BigDecimal laborCostPerSqFt = currentProduct.getLaborCostPerSqFt().setScale(2, HALF_UP);
                BigDecimal totalLabor = laborCostPerSqFt.multiply(area).setScale(2, HALF_UP);
                BigDecimal expectedResult = new BigDecimal("57").setScale(2, HALF_UP);
                assertEquals(totalLabor, expectedResult);
            }
        }
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
    public void testGetTaxesForOrder() throws FlooringPersistenceException {
        Tax currentTax = new Tax();
        Collection<Tax> fromServiceLayer = daoTax.getAllTaxes();
        String state = "KY";
        currentTax.setState(state);
        for (Iterator<Tax> it = fromServiceLayer.iterator(); it.hasNext();) {
            Tax ts = it.next();
            if (ts.getState().equals(state)) {
                BigDecimal taxs = ts.getTaxRate();
                currentTax.setTaxRate(taxs);
          
        BigDecimal totalSineTax = new BigDecimal("10").setScale(2, HALF_UP);
        BigDecimal expectedResult = new BigDecimal("57.50").setScale(2, HALF_UP);
        BigDecimal taxRate = currentTax.getTaxRate().setScale(2, HALF_UP);
        BigDecimal taxAmount = totalSineTax.multiply(taxRate).setScale(2, HALF_UP);
        assertEquals(expectedResult, taxAmount);
    }
        }
    }

    @Test
    public void testGetOrderCapitalCost() {
        BigDecimal expectedResult = new BigDecimal("12").setScale(2, HALF_UP);
        BigDecimal totalSineTax = new BigDecimal("10").setScale(2, HALF_UP);
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
    public void testGetAllTaxes() throws FlooringPersistenceException {
        Collection<Tax> fromServiceLayer = service.getAllTaxes();
        String states = "KY";
        Order currentOrder = new Order();
        
        for (Iterator<Tax> it = fromServiceLayer.iterator(); it.hasNext();) {
            Tax ts = it.next();
            if (ts.getState().equals(states)) {
                BigDecimal taxs = ts.getTaxRate();
                currentOrder.getTax().setTaxRate(taxs);
          
        BigDecimal expectedResult = new BigDecimal("5.75").setScale(2, HALF_UP);
        BigDecimal myResult = currentOrder.getTax().getTaxRate().setScale(2, HALF_UP);
        assertEquals(expectedResult, myResult);
            }
        }
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
    public void testGetOrderForEdit() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException, FlooringDaoException {
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
        Order fromServ = service.getOrderForEdit(myDate, anOrder, orderNumber);

        currentOrder.setCustomerName("John");
        BigDecimal fromS = fromServ.getArea().setScale(2, HALF_UP);
        BigDecimal expectedResult = new BigDecimal("11").setScale(2, HALF_UP);
        assertEquals(fromS, expectedResult);
    }
}