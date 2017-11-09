/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SumTest {
    
    Sum sum = new Sum();
    
    public SumTest() {
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
   // Given an array of ints, return the sum of all the elements. 
    //
    // sum({1, 2, 3}) -> 6
    // sum({5, 11, 2}) -> 18
    // sum({7, 0, 0}) -> 7
    @Test
    public void testSixMethod() {
        int[] numbers = {1,2,3};
        int expected = 6;
        
        assertEquals(expected, sum.sum(numbers));
    }
    @Test
    public void testEightteenMethod() {
        int[] numbers = {5,11,2};
        int expected = 18;
        
        assertEquals(expected, sum.sum(numbers));
    }
    
    @Test
    public void testSevenMethod() {
        int[] numbers = {7,0,0};
        int expected = 7;
        
        assertEquals(expected, sum.sum(numbers));
    }
    
}
