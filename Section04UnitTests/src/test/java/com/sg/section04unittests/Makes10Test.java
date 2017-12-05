
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class Makes10Test {
    
    Makes10 ten = new Makes10();
    
    public Makes10Test() {
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

        // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true
    
    @Test
    public void testMakes10() {
        int a = 9;
        int b = 10;
        assertTrue(ten.makes10(a, b));
    }
    
     @Test
    public void testMakes10TheSecond() {
        int a = 9;
        int b = 9;
        assertFalse(ten.makes10(a, b));
    }
    
     @Test
    public void testMakes10TheThird() {
        int a = 1;
        int b = 9;
        assertTrue(ten.makes10(a, b));
    }
}
