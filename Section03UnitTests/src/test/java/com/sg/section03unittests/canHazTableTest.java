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


public class canHazTableTest {
    
    canHazTable shallowEatery = new canHazTable();
    
    public canHazTableTest() {
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
// You and your date are trying to get a table at a restaurant. 
    // The parameter "you" is the stylishness of your clothes, in 
    // the range 0..10, and "date" is the stylishness of your date's 
    // clothes. The result getting the table is encoded as an int 
    // value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
    // 8 or more, then the result is 2 (yes). With the exception that if 
    // either of you has style of 2 or less, then the result is 0 (no). 
    // Otherwise the result is 1 (maybe). 
    //
    // canHazTable(5, 10) → 2
    // canHazTable(5, 2) → 0
    // canHazTable(5, 5) → 1
    @Test
    public void test5And10() {
      
    int expectedResult = 2;
        assertEquals(expectedResult, shallowEatery.canHazTable(5, 10));
    
    }
    
    @Test
    public void test5And2() {
      
    int expectedResult = 0;
        assertEquals(expectedResult, shallowEatery.canHazTable(5, 2));
    }
    
    @Test
    public void test5And5() {
      
    int expectedResult = 1;
        assertEquals(expectedResult, shallowEatery.canHazTable(5, 5));
    }
}
