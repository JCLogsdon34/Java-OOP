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
    
    YoAbba yoAbba = new YoAbba();
    
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
        String stringA ="Hi";
        String stringB ="Bye";
        assertEquals(expectedResultA,yoAbba.abba(stringA,stringB));
    }
    
    @Test
    public void testYoAliceAbba(){
        String expectedResult = "YoAliceAliceYo";
        String stringA ="Yo";
        String stringB ="Alice";
        assertEquals(expectedResult,yoAbba.abba(stringA,stringB));
        
    }
    
    @Test
    public void testWhatUpAbba(){
        String expectedResult ="WhatUpUpWhat";
        String stringA ="What";
        String stringB ="Up";
        assertEquals(expectedResult,yoAbba.abba(stringA,stringB));
        
    }
    /////Comments
}
