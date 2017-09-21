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
        int numOfX = 0;
        char character = 'x';
        int length = str.length();

        for (i = 0; i < length; i++) {
            while (i <= length) {
                if (str.charAt(i) == character) {
                    numOfX = numOfX + 1;
                }
            }
        }
        if (numOfX % 3 == 0) {
            numOfX = numOfX - 1;
        } else if (numOfX % 2 == 0) {
            numOfX = numOfX - 1;
        }
        return numOfX;
        /////Comments
    }
}
