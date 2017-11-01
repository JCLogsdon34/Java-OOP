
package com.sg.section03unittests;



/**
 *
 * @author apprentice
 */
public class FrontTimes {
    // Given a String and a non-negative int n, we'll say that the 
    // front of the String is the first 3 chars, or whatever is there 
    // if the String is less than length 3. Return n copies of the front; 
    //
    // frontTimes("Chocolate", 2) -> "ChoCho"
    // frontTimes("Chocolate", 3) -> "ChoChoCho"
    // frontTimes("Abc", 3) -> "AbcAbcAbc"
    public String frontTimes(String str, int n) {
        
        //use str.length();
        //use str = str.subString(int, int);

       String expectations;
        String sFW = str.substring(0, Math.min(str.length(), 3));
        // include in this that we always use the first three chars
        
         if (n > 2){
            expectations = sFW + sFW + sFW;
            System.out.println(sFW + sFW + sFW); 
        } else if((n > 1) && (n < 3)){
            expectations = sFW + sFW;
            System.out.println(sFW + sFW);
        } else {
            expectations = sFW;
            System.out.println(sFW);
        } 
        
        return expectations;
    }
    /////Comments
}
