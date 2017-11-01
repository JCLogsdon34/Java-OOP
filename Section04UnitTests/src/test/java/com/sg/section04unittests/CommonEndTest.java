
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CommonEndTest {
    
    private CommonEnd commonEnd = new CommonEnd();
    
    public CommonEndTest() {
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
// commonEnd({1, 2, 3}, {7, 3}) -> true
// commonEnd({1, 2, 3}, {7, 3, 2}) -> false
// commonEnd({1, 2, 3}, {1, 3}) -> true
    @Test
    public void testFirstMethod() {
      int[] myArray = {1, 2, 3};
      int[] mySecondArray = {7, 3};
        boolean expectedResult = true;

        assertEquals(expectedResult, commonEnd.commonEnd(myArray, mySecondArray));
    }
    
    @Test
    public void testSecondMethod() {
      int[] myArray = {1, 2, 3};
      int[] mySecondArray = {7, 3, 2};
        boolean expectedResult = false;

        assertEquals(expectedResult, commonEnd.commonEnd(myArray, mySecondArray));
    }
    
    @Test
    public void testThirdMethod() {
      int[] myArray = {1, 2, 3};
      int[] mySecondArray = {1, 3};
        boolean expectedResult = true;

        assertEquals(expectedResult, commonEnd.commonEnd(myArray, mySecondArray));
    }
}
