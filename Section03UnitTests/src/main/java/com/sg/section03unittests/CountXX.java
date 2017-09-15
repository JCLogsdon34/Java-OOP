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

        String xERS = "x";
        int numOfX = 0;
        int indexOfXX = str.indexOf(xERS);
        if (indexOfXX > 0) {
            // for (int i = 0; i <= str.length(); i++) {
            do {
                str = str.substring(indexOfXX + 1);
                indexOfXX = str.indexOf(xERS);
                numOfX++;
                indexOfXX = str.indexOf(numOfX, indexOfXX);
            }while (indexOfXX != -1);
        }
        return numOfX;
    }
}
