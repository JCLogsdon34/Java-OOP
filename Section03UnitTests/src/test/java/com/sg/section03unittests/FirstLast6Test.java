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
public class FirstLast6Test {
    
    private FirstLast6 firstLast6 = new FirstLast6();
    
    public FirstLast6Test() {
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

     // Given an array of ints, return true if 6 appears as either the 
    // first or last element in the array. The array will be length 1 or more. 
    //
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false
    @Test
    public void testFirstArray() {
  
        int [] thisArray = new int[] {1,2,6};
       
        int [] expectedResult = thisArray;
        assertTrue(firstLast6.firstLast6(expectedResult));
        
      /*  
Your expected result needs to be the array you expect to come back. 
The assert true will compare the two things you passed in, so those two things 
should be the same type. You currently are passing in a boolean and comparing that
to an array. Also, you don't need the [] on thisArray when you pass it into the 
method firstLast6. */
        
    }
    
    @Test
    public void testSecondArray() {
  
        int [] thisArray = new int[] {6,1,2,3};
       
        int [] expectedResult = thisArray;
        assertTrue(firstLast6.firstLast6(expectedResult));
    }
    
    @Test
    public void testThirdArray() {
  
        int [] thisArray = new int[] {13,6,1,2,3};
       
        int [] expectedResult = thisArray;
        
        assertTrue(firstLast6.firstLast6(expectedResult));
        
    }
}
