/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MakePiTest {
    
    private MakePi makePi = new MakePi();
    
    public MakePiTest() {
        
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

     // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3, 1, 4}
    @Test
    public void testMakePi() {
        int pi = 3;
        int [] expectedResult = {3,1,4};
        
        Assert.assertEquals(expectedResult, makePi.makePi(pi));
    }
    ///Comments
}
