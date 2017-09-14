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

public class GreatPartyTest {

    GreatParty party = new GreatParty();

    public GreatPartyTest() {
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

    // When squirrels get together for a party, they like to have cigars.
// A squirrel party is successful when the number of cigars is between
// 40 and 60, inclusive. Unless it is the weekend, in which case there 
// is no upper bound on the number of cigars. Return true if the party
// with the given values is successful, or false otherwise.
//
// greatParty(30, false) → false
// greatParty(50, false) → true
// greatParty(70, true) → true
    @Test
    public void test30False() {
        boolean expectedResult = false;
        int cigars = 30;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));
    }

    @Test
    public void test50True() {
        boolean expectedResult = true;
        int cigars = 50;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));
    }

    @Test
    public void test70True() {
        boolean expectedResult = true;
        int cigars = 70;
        boolean isWeekend = true;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));
    }
    //From the code along, they do not pass

    @Test
    public void test39True() {
        boolean expectedResult = true;
        int cigars = 39;
        boolean isWeekend = true;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));
    }

    @Test
    public void test39False() {
        boolean expectedResult = false;
        int cigars = 39;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));
        //assertFalse(party.greatParty(39,false));
    }

    @Test
    public void test40True() {
        boolean expectedResult = true;
        int cigars = 40;
        boolean isWeekend = true;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        // assertTrue(party.greatParty(40, true));
    }

    @Test
    public void test40False() {
        boolean expectedResult = true;
        int cigars = 40;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        //  assertFalse(party.greatParty(40,false));
    }

    @Test
    public void test60True() {

        boolean expectedResult = true;
        int cigars = 60;
        boolean isWeekend = true;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        //   assertTrue(party.greatParty(60, true));
    }

    @Test
    public void test60False() {
        boolean expectedResult = true;
        int cigars = 60;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        // assertFalse(party.greatParty(60,false));
    }

    @Test
    public void test61True() {
        boolean expectedResult = true;
        int cigars = 61;
        boolean isWeekend = true;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        //assertTrue(party.greatParty(61, true));
    }

    @Test
    public void test61False() {
        boolean expectedResult = true;
        int cigars = 61;
        boolean isWeekend = false;
        assertEquals(expectedResult, party.greatParty(cigars, isWeekend));

        //assertFalse(party.greatParty(61,false));
    }

}
