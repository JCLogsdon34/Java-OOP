/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section04unittests;

import java.util.logging.Level;
import java.util.logging.Logger;


public class AlarmClock {
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
    public String alarmClock(int day, boolean vacation) {
        int hour = 0;
        

        String alarm = null;
        
         if (day <= 0) {
            if(vacation == true){
                 alarm = "off";
            }else {
                alarm = "10:00am";
            }
            
         }else if ((day >= 1) && (day <= 6)){
            if (vacation == true) {
                 alarm = "10:00am";
                 
            }  else if (vacation == false){
                alarm = "7:00am";
            }
        }else if (day > 6){
                if(vacation == true){
                    alarm = "off";
                }else{ 
                    alarm = "10:00am";
            }
         } else {
            System.out.println("Invalid input");
        }
        return alarm;
    }
}