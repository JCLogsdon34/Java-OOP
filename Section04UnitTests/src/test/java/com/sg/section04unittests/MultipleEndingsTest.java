package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MultipleEndingsTest {

    MultipleEndings end = new MultipleEndings();

    public MultipleEndingsTest() {
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

    // Given a String, return a new String made of 3 copies 
// of the last 2 chars of the original String. The String 
// length will be at least 2. 
//
// multipleEndings("Hello") -> "lololo"
// multipleEndings("ab") -> "ababab"
// multipleEndings("Hi") -> "HiHiHi"
    @Test
    public void testHelloMethod() {
        String input = "Hello";
        String expected = "lololo";
        assertEquals(expected, end.multipleEndings(input));
    }

    @Test
    public void testAbMethod() {
        String input = "ab";
        String expected = "ababab";
        assertEquals(expected, end.multipleEndings(input));
    }

    @Test
    public void testHiMethod() {
        String input = "Hi";
        String expected = "HiHiHi";
        assertEquals(expected, end.multipleEndings(input));
    }

}
