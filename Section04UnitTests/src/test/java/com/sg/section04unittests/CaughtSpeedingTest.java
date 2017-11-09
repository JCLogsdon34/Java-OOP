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

/**
 *
 * @author apprentice
 */
public class CaughtSpeedingTest {
    
    CaughtSpeeding speeding = new CaughtSpeeding();
    
    public CaughtSpeedingTest() {
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
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    @Test
    public void test60False() {
        int expectedResult = 0;
        int speed= 60;
        boolean isBirthday = false;
        assertEquals(expectedResult, speeding.caughtSpeeding(speed, isBirthday));
    }

    @Test
    public void test65False() {
        int expectedResult = 1;
        int speed= 65;
        boolean isBirthday = false;
        assertEquals(expectedResult, speeding.caughtSpeeding(speed, isBirthday));
    }

    @Test
    public void test65True() {
        int expectedResult = 0;
        int speed= 65;
        boolean isBirthday = true;
        assertEquals(expectedResult, speeding.caughtSpeeding(speed, isBirthday));
    }
    //From the code along, they do not pass
}
