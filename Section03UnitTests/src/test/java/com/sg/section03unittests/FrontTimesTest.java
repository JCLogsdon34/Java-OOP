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
public class FrontTimesTest {
    
    FrontTimes frontTimes = new FrontTimes();
    
    public FrontTimesTest() {
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
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    @Test
    public void testTry2Choclate() {
       String expectedResultHere = "ChoCho";
       // include a var for the front three
       //this test fails
       assertEquals(expectedResultHere, frontTimes.frontTimes("Chocolate", 2));
    }
    
    @Test
    public void testTry3Choclate() {
       String expectedResultHere = "ChoChoCho";
       
       assertEquals(expectedResultHere, frontTimes.frontTimes("Chocolate", 3));
    }
    
    @Test
    public void testTry3Abc() {
       String expectedResultHere = "AbcAbcAbc";
       
       assertEquals(expectedResultHere, frontTimes.frontTimes("Abc", 3));
    }
    ///Comments
}
