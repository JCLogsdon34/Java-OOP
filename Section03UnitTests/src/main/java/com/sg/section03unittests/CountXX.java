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

        int index = str.indexOf("xx");
        int numOfX = 0;

        while (index != -1) {
            numOfX++;
            str = str.substring(index + 1);
            index = str.indexOf("xx");
        }
        return numOfX;
    }
}
