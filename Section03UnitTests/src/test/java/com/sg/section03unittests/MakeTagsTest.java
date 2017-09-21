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
public class MakeTagsTest {
    
    private MakeTags makeTags = new MakeTags();
    
    public MakeTagsTest() {
        
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

       // The web is built with HTML Strings like "<i>Yay</i>" which 
    // draws Yay as italic text. In this example, the "i" tag makes 
    // <i> and </i> which surround the word "Yay". Given tag and word 
    // Strings, create the HTML String with tags around the word, e.g. 
    // “<i>Yay</i>". 
    //
    // makeTags("i", "Yay") -> "<i>Yay</i>"
    // makeTags("i", "Hello") -> "<i>Hello</i>"
    // makeTags("cite", "Yay") -> "<cite>Yay</cite>"
    
    @Test
    public void testMakeIYay() {
        String expectedResult = "<i>Yay</i>";
        String tag = "i";
        String content = "Yay";
        assertEquals(expectedResult, makeTags.makeTags(tag, content));
    }
    
    @Test
    public void testMakeIHello() {
        String expectedResult = "<i>Hello</i>";
        String tag = "i";
        String content = "Hello";
        assertEquals(expectedResult, makeTags.makeTags(tag, content));
    }
    
    @Test
    public void testMakeIYayCite() {
        String expectedResult = "<cite>Yay</cite>";
        String tag = "cite";
        String content = "Yay";
        assertEquals(expectedResult, makeTags.makeTags(tag, content));
    }
    /////Comments
}
