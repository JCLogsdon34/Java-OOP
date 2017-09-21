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


public class SayHiTest {
    
    private SayHi sayHi = new SayHi();
    
    public SayHiTest() {
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
    public void testBob() {
        String expectedResult = "HelloBob!";
        String name = "Bob";
        assertEquals(expectedResult, sayHi.sayHi(name));
    }
    
    @Test
    public void testAlice(){
        String expectedResult = "HelloAlice!"; 
        String name = "Alice";
        assertEquals(expectedResult, sayHi.sayHi(name));
    }
    
    @Test
    public void testX(){
        String expectedResult = "HelloX!";
        String name = "X";
        assertEquals(expectedResult, sayHi.sayHi(name));
    }
    /////Comments
}
