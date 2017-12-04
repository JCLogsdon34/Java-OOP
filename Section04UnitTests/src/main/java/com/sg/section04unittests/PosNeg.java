
package com.sg.section04unittests;


public class PosNeg {
      // Given two int values, return true if one is negative and 
    // one is positive. Except if the parameter "negative" is 
    // true, then return true only if both are negative. 
    //
    // posNeg(1, -1, false) -> true
    // posNeg(-1, 1, false) -> true
    // posNeg(-4, -5, true) -> true
    public boolean posNeg(int a, int b, boolean negative) {
       boolean result = false;
       
       if(negative == false){
       if((a >= 1) && (b <= 1)){   
               result = true;
           }
       } else if((a <= 1) && (b >= 1)){
               result = true;
           }
       if(negative == true){
           if((a >= 1) && (b >= 1)){   
               result = true;
           }
       } else if((a >= 1) && (b >= 1)){
               result = true;
           }
       return result;
       }
    }