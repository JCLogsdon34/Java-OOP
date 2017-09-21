/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apprentice
 */
public class SumDoubleTest {
    
    private SumDouble sumDouble = new SumDouble();
    
    public SumDoubleTest() {
        
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

          // Given two int values, return their sum. However, if the two 
    // values are the same, then return double their sum. 
    //
    // sumDouble(1, 2) -> 3
    // sumDouble(3, 2) -> 5
    // sumDouble(2, 2) -> 8
    
    @Test
    public void testSomeMethodFirst() {
        int a = 1;
        int b = 2;
        int expectedResult = 3;
        assertEquals(expectedResult, sumDouble.sumDouble(a,b));
    }
    
    @Test
    public void testSomeMethodSecond() {
        int a = 3;
        int b = 2;
        int expectedResult = 5;
        assertEquals(expectedResult, sumDouble.sumDouble(a,b));
    }
    
    @Test
    public void testSomeMethodThird() {
        int a = 2;
        int b = 2;
        int expectedResult = 8;
        assertEquals(expectedResult, sumDouble.sumDouble(a,b));
    }
    /////Comments
}
