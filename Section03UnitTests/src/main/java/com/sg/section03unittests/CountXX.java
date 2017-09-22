/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

public class CountXX {
    // Count the number of "xx" in the given String. We'll say 
    // that overlapping is allowed, so "xxx" contains 2 "xx".  
    //
    // countXX("abcxx") -> 1
    // countXX("xxx") -> 2
    // countXX("xxxx") -> 3

    public int countXX(String str) {

        int i;
        char myChar = 'x';
        // char myChars = (char) (myChar + myChar);;
        int numOfX = 0;
        String twoX = "xx";

        //     char myNewChar = (char) (myChar + myChar);
      //  for (i = 0; i <= str.length(); i++) {

            numOfX = str.indexOf(twoX, myChar);
            numOfX = twoX.length();
               numOfX = numOfX + 1;
            numOfX++;
      //  }
      //    numOfX = numOfX + 1;              
        return numOfX;
    }
}
