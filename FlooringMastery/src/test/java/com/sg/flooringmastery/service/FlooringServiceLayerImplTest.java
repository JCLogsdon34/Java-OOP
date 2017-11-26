
package com.sg.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringNoOrdersForThatDateException;
import com.sg.flooringmastery.dao.FlooringOrderDao;
import com.sg.flooringmastery.dao.FlooringOrderDaoImpl;
import com.sg.flooringmastery.dao.FlooringPersistenceException;
import com.sg.flooringmastery.dao.FlooringProductDao;
import com.sg.flooringmastery.dao.FlooringProductDaoImpl;
import com.sg.flooringmastery.dao.FlooringTaxDao;
import com.sg.flooringmastery.dao.FlooringTaxDaoImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
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
    FlooringOrderDao daoOrder = new FlooringOrderDaoImpl();
    FlooringTaxDao daoTax = new FlooringTaxDaoImpl();
    FlooringProductDao daoProduct = new FlooringProductDaoImpl();
    
    FlooringServiceLayer service;
    
     public FlooringServiceLayerImplTest() {
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("applicationContext.xml");
    service = 
        ctx.getBean("service", FlooringServiceLayer.class);
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
    public void testLoadTheOrders() throws FlooringPersistenceException  {
    
    }

    
    @Test
    public void testAddOrder() throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((4));
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
        
        daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        
        Order order = service.addOrder(currentOrder.getOrderDate(), currentOrder);
        Order fromDao = daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        
        assertEquals(order, fromDao); 
    }
    
    @Test
    public void testAddInvalidOrder() throws
            FlooringDuplicateOrderException,
            FlooringDataValidationException,
            FlooringPersistenceException {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((4));
                        currentOrder.setCustomerName("Crockett");
                        currentOrder.getTax().setState("TN");
                        currentOrder.getTax().setTaxRate(new BigDecimal(6.75));
                        currentOrder.getProduct().setProductType("Tile");
                        currentOrder.setArea(new BigDecimal(11));
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
                        currentOrder.setMaterialCost(new BigDecimal(55));
                        currentOrder.setLaborCost(new BigDecimal(44));
                        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
                        currentOrder.setTotal(new BigDecimal(22.11));
        try{
        service.addOrder(currentOrder.getOrderDate(), currentOrder);
        fail("Expected FlooringDataValidationException was not thrown");
        }catch(FlooringDataValidationException e){
            return;
        }
    }
    
    
    
    @Test
    public void testGetOrder() throws FlooringPersistenceException,
            FlooringNoOrdersForThatDateException{
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((4));
                        currentOrder.setCustomerName("Crockett");
                        currentOrder.getTax().setState("TN");
                        currentOrder.getTax().setTaxRate(new BigDecimal(6.75));
                        currentOrder.getProduct().setProductType("Wood");
                        currentOrder.setArea(new BigDecimal(11));
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(15.13));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(12.42));
                        currentOrder.setMaterialCost(new BigDecimal(55));
                        currentOrder.setLaborCost(new BigDecimal(44));
                        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
                        currentOrder.setTotal(new BigDecimal(22.11));
        
        daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        
        List<Order> servList = service.getOrder(currentOrder.getOrderDate());
        List<Order> fromDao = daoOrder.getOrder(currentOrder.getOrderDate());
        
        assertEquals(servList, fromDao); 
    }
    
    @Test
    public void testRemoveOrder() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
   DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((4));
                        currentOrder.setCustomerName("Clay");
                        currentOrder.getTax().setState("KY");
                        currentOrder.getTax().setTaxRate(new BigDecimal(5.75));
                        currentOrder.getProduct().setProductType("Tile");
                        currentOrder.setArea(new BigDecimal(11));
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(55));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22));
                        currentOrder.setMaterialCost(new BigDecimal(55));
                        currentOrder.setLaborCost(new BigDecimal(123));
                        currentOrder.getTax().setTaxAmount(new BigDecimal(32.42));
                        currentOrder.setTotal(new BigDecimal(22.11));
        
        daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        
        LocalDate date = currentOrder.getOrderDate();
        int orderNumber = 4;
        Order myOrder = daoOrder.removeOrder(date, orderNumber);
        Order servOrder = service.removeOrder(date, orderNumber);
        assertEquals(myOrder, servOrder);
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
    public void testSaveOrder()  {
       
    }

    @Test
    public void testGetAllTaxes() throws FlooringPersistenceException  {
        Collection<Tax> fromDao = daoTax.getAllTaxes();
        Collection<Tax> fromServiceLayer = service.getAllTaxes();
        assertEquals(fromDao, fromServiceLayer); 
    }
    
    @Test
    public void testGetAllProducts() throws FlooringPersistenceException {
        Collection<Product> fromDao = daoProduct.getAllProducts();
        Collection<Product> fromServiceLayer = service.getAllTheProducts();
        assertEquals(fromDao, fromServiceLayer);
    }

    
    @Test
    public void testGetOrderForEdit() throws FlooringPersistenceException, FlooringNoOrdersForThatDateException {
         DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((4));
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
        
                        List <Order> myOrders = new ArrayList<>();
                        myOrders.add(currentOrder);
        daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        

       int orderNumber = currentOrder.getOrderNumber();
       Order fromDao = daoOrder.getOrderForEdit(myOrders, orderNumber);
       Order fromServ = service.getOrderForEdit(myOrders, orderNumber);
       
       assertEquals(fromDao, fromServ);
    }

    
    @Test
    public void testUpdateAnOrder()  {
        
    }

  
    @Test
    public void testGetOneOrder() throws FlooringPersistenceException  {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String theDateNow = "01-12-2017";
        Order currentOrder = new Order();
        currentOrder.setOrderDate(LocalDate.parse(theDateNow, dateFormat));
                        currentOrder.setOrderNumber((5));
                        currentOrder.setCustomerName("Breckenridge");
                        currentOrder.getTax().setState("KY");
                        currentOrder.getTax().setTaxRate(new BigDecimal(5.75));
                        currentOrder.getProduct().setProductType("Wood");
                        currentOrder.setArea(new BigDecimal(11));
                        currentOrder.getProduct().setProductCostPerSqFt(new BigDecimal(11));
                        currentOrder.getProduct().setLaborCostPerSqFt(new BigDecimal(22.66));
                        currentOrder.setMaterialCost(new BigDecimal(500));
                        currentOrder.setLaborCost(new BigDecimal(40));
                        currentOrder.getTax().setTaxAmount(new BigDecimal(322));
                        currentOrder.setTotal(new BigDecimal(22.11));
        
                        List <Order> oneOrder = new ArrayList<>();
                        int orderNumber = 5;
                        oneOrder.add(currentOrder);
        daoOrder.addOrder(currentOrder.getOrderDate(), currentOrder);
        
        Order fromServ = service.getOneOrder(oneOrder, orderNumber);
        Order fromDao = daoOrder.getOneOrder(oneOrder, orderNumber);
        assertEquals(fromServ, fromDao);
    }   
}