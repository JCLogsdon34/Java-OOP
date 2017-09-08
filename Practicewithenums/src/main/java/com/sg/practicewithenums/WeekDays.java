/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practicewithenums;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WeekDays {
    public enum DaysInAWeeks {
    MONDAY, TUESDAY, WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    }
    public int app(String dayOfWeek){
        int daysTilFriday;
        System.out.println("Please enter a day, and I will tell you how many"
                + "days until Friday");
        Scanner inputReader = new Scanner(System.in);
        dayOfWeek = inputReader.nextLine();
        DaysInAWeeks e = DaysInAWeeks.valueOf(dayOfWeek);
        
        switch(e) {
            case SATURDAY:
                daysTilFriday = 6;
                return daysTilFriday;
            case SUNDAY:
                daysTilFriday = 5;
                return daysTilFriday;
            case MONDAY:
                daysTilFriday = 4;
                return daysTilFriday;
            case TUESDAY:
                daysTilFriday = 3;
                return daysTilFriday;
            case WEDNESDAY:
                daysTilFriday = 2;
                return daysTilFriday;
            case THURSDAY:
                daysTilFriday = 1;
                return daysTilFriday;
            case FRIDAY:
                daysTilFriday = 0;
                return daysTilFriday;
            default:
                throw new UnsupportedOperationException();
        
        }
    }
}
