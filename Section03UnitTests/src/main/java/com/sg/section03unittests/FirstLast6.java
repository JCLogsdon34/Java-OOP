/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;


public class FirstLast6 {
        // Given an array of ints, return true if 6 appears as either the 
    // first or last element in the array. The array will be length 1 or more. 
    //
    // firstLast6({1, 2, 6}) -> true
    // firstLast6({6, 1, 2, 3}) -> true
    // firstLast6({13, 6, 1, 2, 3}) -> false
    
    public boolean firstLast6(int[] numbers) {
        // I need an array that I can pass these into

        int i = 0;
        boolean truthTeller = false;
        int myArray[] = new int[i];
        int num1;
        int num2;
        
        num1 = myArray[0]; 
        num2 = myArray[myArray.length - 1];
        
        for(i = 0; i < 4; i++){
            
            if((num1 == 6 )||(num2 == 6)){
                truthTeller = true;
            } else {
                truthTeller = false;
            }
        }
             return truthTeller;   
    }
}
