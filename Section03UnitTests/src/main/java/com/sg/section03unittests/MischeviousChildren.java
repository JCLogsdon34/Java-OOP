/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

public class MischeviousChildren {
     // We have two children, a and b, and the parameters aSmile and 
    // bSmile indicate if each is smiling. We are in trouble if they 
    // are both smiling or if neither of them is smiling. Return true 
    // if we are in trouble. 
    //
    // areWeInTrouble(true, true) -> true
    // areWeInTrouble(false, false) -> true
    // areWeInTrouble(true, false) -> false
    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
            if ((aSmile = true) && (bSmile = true)) {
                return true;
                 } else if ((aSmile = true) && (bSmile = false)) {
                    return false;
            }
             if ((aSmile = false) && (bSmile = false)) {
                return true;
             } else if ((aSmile = true) && (bSmile = false)) {
            return false;
             }
    }
}
