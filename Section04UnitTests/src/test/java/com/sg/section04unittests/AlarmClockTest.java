
package com.sg.section04unittests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AlarmClockTest {
    
    AlarmClock clock = new AlarmClock();
    
    public AlarmClockTest() {
        
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
    // Given a day of the week encoded as 
    // 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating 
    // if we are on vacation, return a String of the form "7:00" 
    // indicating when the alarm clock should ring. Weekdays, the 
    // alarm should be "7:00" and on the weekend it should be "10:00". 
    // Unless we are on vacation -- then on weekdays it should be 
    // “10:00" and weekends it should be "off". 
    //
    // alarmClock(1, false) → "7:00"
    // alarmClock(5, false) → "7:00"
    // alarmClock(0, false) → "10:00"
    
    @Test
    public void testSomeMethod() {
        int day = 1;
        boolean vacation = false;
        String expectedResult = "7:00am";
        
        assertEquals(expectedResult, clock.alarmClock(day, vacation));
    }


    @Test
    public void testAlarmClock() {
        int day = 5;
        boolean vacation = false;
        String expectedResult = "7:00am";
        
        assertEquals(expectedResult, clock.alarmClock(day, vacation));
    }
    
    @Test
    public void testClock() {
        int day = 0;
        boolean vacation = false;
        String expectedResult = "10:00am";
        
        assertEquals(expectedResult, clock.alarmClock(day, vacation));
    }
    
}
