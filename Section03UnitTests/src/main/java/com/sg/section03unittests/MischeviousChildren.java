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
        boolean wellAreWe;

        if (((aSmile = true) && (bSmile = true) || (aSmile = false) && (bSmile = false))) {
            wellAreWe = true;
        } else {
      //  if ((aSmile = true) && (bSmile = false) || (aSmile = false) && (bSmile = true)) {
            wellAreWe = false;
        }

        return wellAreWe;
    }
}
