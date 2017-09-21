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
public class MischeviousChildrenTest {
    
    public MischeviousChildren badKids = new MischeviousChildren();
    
    public MischeviousChildrenTest() {
        
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

    // We have two children, a and b, and the parameters aSmile and 
    // bSmile indicate if each is smiling. We are in trouble if they 
    // are both smiling or if neither of them is smiling. Return true 
    // if we are in trouble. 
    //
    // areWeInTrouble(true, true) -> true
    // areWeInTrouble(false, false) -> true
    // areWeInTrouble(true, false) -> false
    @Test
    public void tryTrueTrue(){
        boolean firstBool = true;
        boolean secondBool = true;
        boolean expectedResult = true;
        assertEquals(expectedResult,badKids.areWeInTrouble(firstBool, secondBool));
    }
    @Test
    public void tryFalseFalse(){
    
        boolean firstBool = false;
        boolean secondBool = false;
        boolean expectedResult = true;
        assertEquals(expectedResult,badKids.areWeInTrouble(firstBool, secondBool));
    }
    @Test
    public void tryTrueFalse(){

        boolean firstBool = true;
        boolean secondBool = false;
        boolean expectedResult = false;
        assertEquals(expectedResult,badKids.areWeInTrouble(firstBool, secondBool));
    }
    /////Comments
}
