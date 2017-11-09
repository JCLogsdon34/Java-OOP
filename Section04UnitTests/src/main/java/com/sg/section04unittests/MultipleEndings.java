package com.sg.section04unittests;

// Given a String, return a new String made of 3 copies 
// of the last 2 chars of the original String. The String 
// length will be at least 2. 
//
// multipleEndings("Hello") -> "lololo"
// multipleEndings("ab") -> "ababab"
// multipleEndings("Hi") -> "HiHiHi"
public class MultipleEndings {

    public String multipleEndings(String str) {
         //use str.length();
        //use str = str.subString(int, int);

       String expectations;
        String sFW = str.substring(0, Math.min(str.length(), 2));
        // include in this that we always use the first three chars
        
            expectations = sFW + sFW;
            System.out.println(sFW + sFW);
        
        return expectations;
    }
}
