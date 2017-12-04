/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InsertWordTest {

    InsertWord wordUp = new InsertWord();

    public InsertWordTest() {
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

    // Given an "out" String length 4, such as "<<>>", and a 
    // word, return a new String where the word is in the middle 
    // of the out String, e.g. "<<word>>".
    //
    // Hint: SubStrings are your friend here 
    //
    // insertWord("<<>>", "Yay") -> "<<Yay>>"
    // insertWord("<<>>", "WooHoo") -> "<<WooHoo>>"
    // insertWord("[[]]", "word") -> "[[word]]"
    @Test
    public void testSomeMethod() {
        String word = "Yay";
        String container = "<<>>";
        String expectedResult = "<<Yay>>";
        assertEquals(expectedResult, wordUp.insertWord(container, word));
    }

    @Test
    public void testInsertWord() {
        String word = "WooHooo";
        String container = "<<>>";
        String expectedResult = "<<WooHoo>>";
        assertEquals(expectedResult, wordUp.insertWord(container, word));
    }

    @Test
    public void testLastMethod() {
        String word = "word";
        String container = "[[]]";
        String expectedResult = "[[word]]";
        assertEquals(expectedResult, wordUp.insertWord(container, word));
    }
}
