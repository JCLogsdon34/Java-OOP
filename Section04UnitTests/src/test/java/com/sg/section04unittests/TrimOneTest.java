
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TrimOneTest {
    
    TrimOne one = new TrimOne();
    
    public TrimOneTest() {
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

           // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    
    @Test
    public void testTrimOne() {
        String input = "Hello";
        String expectedResult = "ell";
        assertEquals(expectedResult, one.trimOne(input));
    }
 
    @Test
    public void testTrimOneTheSecond() {
        String input = "java";
        String expectedResult = "av";
        assertEquals(expectedResult, one.trimOne(input));
    }
    
    @Test
    public void testTrimOneTheThird() {
        String input = "coding";
        String expectedResult = "odin";
        assertEquals(expectedResult, one.trimOne(input));
    }
    
}
