
package com.sg.section04unittests;


public class Makes10 {
        // Given two ints, a and b, return true if one if them is 10 
    // or if their sum is 10. 
    //
    // makes10(9, 10) -> true
    // makes10(9, 9) -> false
    // makes10(1, 9) -> true
    public boolean makes10(int a, int b) {
        boolean inRange = false;
        
        if((a == 10) || (b == 10)){
            inRange = true;
        } else if((a == 10) && (b == 10)){
            inRange = true;
        }else if ((a + b) == 10){
            inRange = true;
        } else {
            inRange = false;
        }
        
        return inRange;
    }
}
