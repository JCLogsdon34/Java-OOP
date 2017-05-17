/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.heartconcept;

import java.util.Scanner;

public class HeartConcept {

    public static void main(String[] args) {
        int userAge;
        int targetHeartRate;
        int minHeartRate;
        float maxHeartRate;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("What is your age ? ");
        userAge = inputReader.nextByte();

        targetHeartRate = (220 - userAge);
        minHeartRate = targetHeartRate / 2;
        maxHeartRate = targetHeartRate * .85f;

        System.out.println("Your target maximum heart rate should be " + targetHeartRate + " .");
        System.out.println("Your target heart rate zone should be between " + minHeartRate + " " + "and"
                + " " + maxHeartRate + ".");
    }
}
