
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LongInMiddleTest {
    
    LongInMiddle mid = new LongInMiddle();
    
    public LongInMiddleTest() {
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

     // Given 2 Strings, a and b, return a String of the form 
    // short+long+short, with the shorter String on the outside 
    // and the longer String on the inside. The Strings will not 
    // be the same length, but they may be empty (length 0). 
    //
    // longInMiddle("Hello", "hi") -> "hiHellohi"
    // longInMiddle("hi", "Hello") -> "hiHellohi"
    // longInMiddle("aaa", "b") -> "baaab"
    @Test
    public void testLongInMiddle() {
        String a = "Hello";
        String b = "hi";
        String expectedResult = "hiHellohi";
        assertEquals(expectedResult, mid.longInMiddle(a, b));
    }
    
    @Test
    public void testLongInMiddleTheSecond() {
        String a = "hi";
        String b = "Hello";
        String expectedResult = "hiHellohi";
        assertEquals(expectedResult, mid.longInMiddle(a, b));
    }
    
     @Test
    public void testLongInMiddleTheThird() {
        String a = "aaa";
        String b = "b";
        String expectedResult = "baaab";
        assertEquals(expectedResult, mid.longInMiddle(a, b));
    }
}
