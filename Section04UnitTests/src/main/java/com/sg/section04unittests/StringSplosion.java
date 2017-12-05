
package com.sg.section04unittests;


public class StringSplosion {
        // Given a non-empty String like "Code" return a String like 
    // “CCoCodCode".  (first char, first two, first 3, etc)
    //
    // stringSplosion("Code") -> "CCoCodCode"
    // stringSplosion("abc") -> "aababc"
    // stringSplosion("ab") -> "aab"
    public String stringSplosion(String str) {

        String a = str.substring(0, 1);
        String b = str.substring(0, 2);
        String c = str.substring(0, 3);
        String newString = a + b + c + str;
        
        return newString;
    }
}
