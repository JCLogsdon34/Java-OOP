/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

public class PlayOutside {
    // The children in Cleveland spend most of the day playing outside. 
    // In particular, they play if the temperature is between 60 and 90 
    // (inclusive). Unless it is summer, then the upper limit is 100 
    // instead of 90. Given an int temperature and a boolean isSummer, 
    // return true if the children play and false otherwise. 
    //
    // playOutside(70, false) → true
    // playOutside(95, false) → false
    // playOutside(95, true) → true

    public boolean playOutside(int temp, boolean isSummer) {
        boolean playOutside = false;
        if (isSummer = true) {
            if ((temp >= 60) || (temp <= 100)) {
                playOutside = true;
            }
        } else if (isSummer = false) {
            if ((temp >= 60) || (temp <= 90)) {
                playOutside = true;
            } else {
                playOutside = false;
            }
        }
        return playOutside;
    }
    /////Comments
}
