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
public class CountXXTest {
    
    private CountXX countXX = new CountXX();
    
    public CountXXTest() {
        
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

    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3
    
    @Test
    public void testFirstString() {
        String str = "abcxx";
        int expectedResult = 1;
        
       assertEquals(expectedResult, countXX.countXX(str));
       
    }
    
    @Test
    public void testSecondString() {
        String str = "xxx";
        int expectedResult = 2;
        
       assertEquals(expectedResult, countXX.countXX(str));      
    }
    
    @Test
    public void testThirdString() {
        String str = "xxxx";
        int expectedResult = 3;
        
       assertEquals(expectedResult, countXX.countXX(str));
       
    }
}
