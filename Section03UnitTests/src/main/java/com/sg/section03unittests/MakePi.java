/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.section03unittests;

public class MakePi {

    /*public enum piMaker{
         PI;
    } */
    // Return an int array length n containing the first n digits of pi.
    //
    // makePi(3) -> {3,1 4,1,5,9,2,6,5,3,5,9}
    public int[] makePi(int n) {
        int i = 0;
        int piArray[] = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int piForDisplay[] = new int[n];

        i = piArray[i];
        for (i = 0; i <= piArray.length; i++) {
            if(i < n){
            piForDisplay[i] = piArray[i];            
            }
        }
        return piForDisplay;
    }
}
