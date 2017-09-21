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


public class ParrotTroubleTest {
    
    private ParrotTrouble parrotTrouble = new ParrotTrouble();
    
    public ParrotTroubleTest() {
        
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

    // We have a loud talking parrot. The "hour" parameter is the 
    // current hour time in the range 0..23. We are in trouble if 
    // the parrot is talking and the hour is before 7 or after 20. 
    // Return true if we are in trouble. 
    //
    // parrotTrouble(true, 6) -> true
    // parrotTrouble(true, 7) -> false
    // parrotTrouble(false, 6) -> false
    
    @Test
    public void testParrotTroubleFirst() {
        boolean expectedResult = true;
        boolean birdTrouble = true;
        int hour = 6;
        
       assertEquals(expectedResult,parrotTrouble.parrotTrouble(birdTrouble, hour));
    }
    
    @Test
    public void testParrotTroubleSecond() {
        boolean expectedResult = false;
        boolean birdTrouble = true;
        int hour = 7;
        
        assertEquals(expectedResult,parrotTrouble.parrotTrouble(birdTrouble, hour));       
    }
    
    @Test
    public void testParrotTroubleThird() {
        boolean expectedResult = false;
        boolean birdTrouble = false;
        int hour = 6;
        
        assertEquals(expectedResult,parrotTrouble.parrotTrouble(birdTrouble, hour));       
    }
    /////Comments
}
