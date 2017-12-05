
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class RotateLeftTest {
    
    RotateLeft left = new RotateLeft();
    
    public RotateLeftTest() {
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

     // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    
    @Test
    public void testRotateLeft() {
        int[] expectedResult = {2, 3, 1};
        int[] a = {1, 2, 3};
        assertArrayEquals(expectedResult, left.rotateLeft(a));
    }
    
    @Test
    public void testRotateLeftTheSecond() {
        int[] expectedResult = {11,5,9};
        int[] a = {5,11,9};
        assertArrayEquals(expectedResult, left.rotateLeft(a));
    }
    
    @Test
    public void testRotateLeftTheThird() {
        int[] expectedResult = {0,0,7};
        int[] a = {7,0,0};
        assertArrayEquals(expectedResult, left.rotateLeft(a));
    }
}
