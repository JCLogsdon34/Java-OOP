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
public class Diff21Test {
    
    private Diff21 diff21 = new Diff21();
    
    public Diff21Test() {
        
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

        // Given an int n, return the absolute value of the difference 
    // between n and 21, except return double the absolute value 
    // of the difference if n is over 21. 
    //
    // diff21(23) -> 4
    // diff21(10) -> 11
    
    @Test
    public void testSomeMethod23() {
        int expectedResult = 4;
        int n = 23;
        
        assertEquals(expectedResult, diff21.diff21(n));
    }
    
    @Test
    public void testSomeMethod10() {
        int expectedResult = 11;
        int n = 10;
        
        assertEquals(expectedResult, diff21.diff21(n));
    }
    ///Comments
}
