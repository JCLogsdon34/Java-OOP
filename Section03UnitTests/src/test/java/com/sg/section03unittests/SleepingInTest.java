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
public class SleepingInTest {
    
    private SleepingIn sleepingin = new SleepingIn();
    
    public SleepingInTest() {
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

     // The parameter weekday is true if it is a weekday, and the 
    // parameter vacation is true if we are on vacation. We sleep 
    // in if it is not a weekday or we're on vacation. Return true 
    // if we sleep in. 
    //
    // canSleepIn(false, false) -> true
    // canSleepIn(true, false) -> false
    // canSleepIn(false, true) -> true
    
    @Test
    public void testFalseFalse() {
        boolean expectedResult = false;
       assertTrue(sleepingin.canSleepIn(expectedResult, false));
    }
    
     @Test
    public void testTrueFalse() {
        boolean expectedResult = true;
       assertTrue(sleepingin.canSleepIn(expectedResult, false));
    }
    
     @Test
    public void testTrueTrue() {
        boolean expectedResult = true;
       assertTrue(sleepingin.canSleepIn(expectedResult, true));
    }
    /////Comments
}
