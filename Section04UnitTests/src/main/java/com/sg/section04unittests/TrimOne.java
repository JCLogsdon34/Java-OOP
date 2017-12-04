
package com.sg.section04unittests;


public class TrimOne {
        // Given a String, return a version without the first and 
    // last char, so "Hello" yields "ell". The String length will be at least 2. 
    //
    // trimOne("Hello") -> "ell"
    // trimOne("java") -> "av"
    // trimOne("coding") -> "odin"
    
    public String trimOne(String str) {
        String expectations;
        String sFW = str.substring(1, Math.min(str.length(), 1));
        
        return sFW;
    }
}
