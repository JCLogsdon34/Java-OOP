/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.mavenproject1;


public class WaitAWhile {
    public static void main(String[] args){

        int timeNow = 5;
        int bedTime = 12;
//I changed bedTime to 11 and it printed out 11, time to go to bed.
// I changed it to 12 too and it made 12:00pm print out time for bed
        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
            //infinite loop happens if timeNow is commented out
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}
