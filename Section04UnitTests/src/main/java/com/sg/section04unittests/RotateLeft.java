
package com.sg.section04unittests;


public class RotateLeft {
        // Given an array of ints, return an array with the elements 
    // “rotated left" so {1, 2, 3} yields {2, 3, 1}. 
    //
    // rotateLeft({1, 2, 3}) -> {2, 3, 1}
    // rotateLeft({5, 11, 9}) -> {11, 9, 5}
    // rotateLeft({7, 0, 0}) -> {0, 0, 7}
    public int[] rotateLeft(int[] numbers) {      
        int a = numbers[0];
        int b = numbers[1];
        int c = numbers[2];
        int [] left = {b,c,a};
        
        return left;
    }
}
