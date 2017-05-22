/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.summativesums;

public class summativeSums {

    public static void main(String[] args) {

        int[] firstArray = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] secondArray = {999, -60, -77, 14, 160, 301};
        int[] thirdArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};

        System.out.println("The sum of the first Array is: " + addSumm(firstArray) + ".");
        System.out.println("The sum of the second Array is: " + addSumm(secondArray) + ".");
        System.out.println("The sum of the third Array is: " + addSumm(thirdArray) + ".");
    }

    static int addSumm(int[] anArray) {

        int summAdder = 0;
        for (int i = 0; i < anArray.length; i++) {
            summAdder += anArray[i];
        }
        return summAdder;
    }
}