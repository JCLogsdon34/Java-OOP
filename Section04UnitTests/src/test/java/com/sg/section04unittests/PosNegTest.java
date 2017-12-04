
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PosNegTest {
    
    PosNeg pos = new PosNeg();
    
    public PosNegTest() {
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

     // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    
    @Test
    public void testPosNeg() {
        int a = 1;
        int b = -1;
        boolean negative = false;
        assertTrue(pos.posNeg(a, b, negative));
    }
    
    @Test
    public void testPosNegTheSecond() {
        int a = -1;
        int b = 1;
        boolean negative = false;
        assertTrue(pos.posNeg(a, b, negative));
    }
    
    @Test
    public void testPosNegTheThird() {
        int a = -4;
        int b = -5;
        boolean negative = true;
        assertTrue(pos.posNeg(a, b, negative));
    }
}
