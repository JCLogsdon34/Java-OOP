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
public class YoAbbaTest {
    
    YoAbba abba = new YoAbba();
    
    public YoAbbaTest() {
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

    // Given two Strings, a and b, return the result of putting 
    // them together in the order abba, e.g. "Hi" and "Bye" 
    // returns "HiByeByeHi". 
    //
    // abba("Hi", "Bye") -> "HiByeByeHi"
    // abba("Yo", "Alice") -> "YoAliceAliceYo"
    // abba("What", "Up") -> "WhatUpUpWhat"
    @Test
    public void testHiByeAbba() {
        String expectedResultA = "HiByeByeHi";
        assertEquals(expectedResultA, abba.abba("HiBye", "ByeHi"));
    }
    
    @Test
    public void testYoAliceAbba(){
        String expectedResult = "YoAliceAliceYo";
        assertEquals(expectedResult, abba.abba("YoAlice", "AliceYo"));
        
    }
    
    @Test
    public void testWhatUpAbba(){
        String expectedResult = "WhatUpUpWhat";
        assertEquals(expectedResult, abba.abba("WhatUp", "UpWhat"));
        
    }
    
}
