
package com.sg.section04unittests;


public class NearHundred {
        // Given an int n, return true if it is within 10 of 100 
    // or 200.
    // Hint: Check out the Math class for absolute value
    //
    // nearHundred(103) -> true
    // nearHundred(90) -> true
    // nearHundred(89) -> false
    
    public boolean nearHundred(int n) {
        boolean inRange = false;
        
        if((Math.abs(n) >= 90) && (Math.abs(n) <= 100)){
          inRange = true;
    } else if ((Math.abs(n) >= 190) && (Math.abs(n) <= 200)){
        inRange = true;
    } else {
        inRange = false;
    }
        return inRange;
    }
}
