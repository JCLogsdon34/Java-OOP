package com.sg.section04unittests;

/**
 *
 * @author apprentice
 */
public class CaughtSpeeding {

    // You are driving a little too fast, and a police 
    // officer stops you. Write code to compute the 
    // result, encoded as an int value: 0=no ticket, 
    // 1=small ticket, 2=big ticket. If speed is 60 or 
    // less, the result is 0. If speed is between 61 
    // and 80 inclusive, the result is 1. If speed is 
    // 81 or more, the result is 2. Unless it is your 
    // birthday -- on that day, your speed can be 5 
    // higher in all cases. 
    //
    // caughtSpeeding(60, false) → 0
    // caughtSpeeding(65, false) → 1
    //caughtSpeeding(65, true) → 0
    public int caughtSpeeding(int speed, boolean isBirthday) {
        int ticket = 0;
        if (isBirthday == false) {
            if (speed < 61) {
                ticket = 0;
            } else if (speed > 60) {
                if (speed < 81) {
                    ticket = 1;
                } else {
                    ticket = 2;
                }
            }
        } else if (isBirthday == true) {
            if (speed < 66) {
                ticket = 0;
            } else if (speed > 65) {
                if (speed < 86) {
                    ticket = 1;
                } else {
                    ticket = 2;
                }
            }
        }
        return ticket;
    }
}
