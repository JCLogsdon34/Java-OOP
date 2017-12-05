
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StringSplosionTest {
    
    StringSplosion s = new StringSplosion();
    
    public StringSplosionTest() {
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

      // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    
    @Test
    public void testStringSplosion() {
        String a = "Code";
        String expectedResult = "CCoCodCode";
        assertEquals(expectedResult, s.stringSplosion(a));
    }
    
    @Test
    public void testStringSplosionTheSecond() {
        String a = "abc";
        String expectedResult = "aababc";
        assertEquals(expectedResult, s.stringSplosion(a));
    }
    
     @Test
    public void testStringSplosionTheThird() {
        String a = "ab";
        String expectedResult = "aab";
        assertEquals(expectedResult, s.stringSplosion(a));
    }   
}
