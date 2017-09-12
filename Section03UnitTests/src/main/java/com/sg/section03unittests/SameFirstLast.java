/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

/**
 *
 * @author apprentice
 */
public class SameFirstLast {
     // Given an array of ints, return true if the array is length 
    // 1 or more, and the first element and the last element are equal. 
    //
    // sameFirstLast({1, 2, 3}) -> false
    // sameFirstLast({1, 2, 3, 1}) -> true
    // sameFirstLast({1, 2, 1}) -> true
    public boolean sameFirstLast(int[] numbers) {
        
        int i = 0;
        boolean truthTeller = false;
        int myArray[] = new int[i];
        int num1 = 0;
        int num2 = 0;
        
        if((num1 == num2) && (myArray.length >= 1)){
            truthTeller = true;
        } else {
            truthTeller = false;
        }
        
        return truthTeller;
    }
}
