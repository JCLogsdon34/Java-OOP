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
public class PlayOutsideTest {
    
    private PlayOutside playOutside = new PlayOutside();
    
    public PlayOutsideTest() {
        
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

    // The children in Cleveland spend most of the day playing outside. 
    // In particular, they play if the temperature is between 60 and 90 
    // (inclusive). Unless it is summer, then the upper limit is 100 
    // instead of 90. Given an int temperature and a boolean isSummer, 
    // return true if the children play and false otherwise. 
    //
    // playOutside(70, false) → true
    // playOutside(95, false) → false
    // playOutside(95, true) → true
    
    @Test
    public void testPlayOutsideFirst() {
       boolean expectedResult = true;
       boolean isSummer = true;
       int temp = 70;
       assertTrue(playOutside.playOutside(temp,expectedResult));
    }
    
    @Test
    public void testPlayOutsideSecond() {
       boolean expectedResult = false;
       boolean isSummer = false;
       int temp = 95;
       assertTrue(playOutside.playOutside(temp,expectedResult));
    }
    
    @Test
    public void testPlayOutsideThird() {
       boolean expectedResult = true;
       boolean isSummer = true;
       int temp = 95;
       assertTrue(playOutside.playOutside(temp,expectedResult));
    }
    
}
