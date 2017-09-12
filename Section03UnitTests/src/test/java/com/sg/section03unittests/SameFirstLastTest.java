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
public class SameFirstLastTest {
    
    private SameFirstLast sameFirstLast = new SameFirstLast(); 
    
    public SameFirstLastTest() {
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

  // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    
    @Test
    public void testFirstArray() {
        int [] thisArray = new int[] {1,2,3};
       
        int [] expectedResult = thisArray;
        
        assertTrue(sameFirstLast.sameFirstLast(expectedResult));
        
    }
    
    @Test
    public void testSecondArray() {
        int [] thisArray = new int[] {1,2,3,1};
       
        int [] expectedResult = thisArray;
        
        assertTrue(sameFirstLast.sameFirstLast(expectedResult));
        
    }
    
    @Test
    public void testThirdArray() {
        int [] thisArray = new int[] {1,2,1};
       
        int [] expectedResult = thisArray;
        
        assertTrue(sameFirstLast.sameFirstLast(expectedResult));
        
    }
}
