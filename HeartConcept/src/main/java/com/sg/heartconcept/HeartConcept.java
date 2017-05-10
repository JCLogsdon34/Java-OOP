/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.heartconcept;

import java.util.Scanner;

public class HeartConcept {

    public static void main(String[] args) {
        int age;
        int top;
        int min;
        float max;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("What is your age ? ");
        age = inputReader.nextByte();

        top = (220 - age);
        min = top / 2;
        max = top * .85f;

        System.out.println("Your target maximum heart rate should be " + top + " .");
        System.out.println("Your target heart rate zone should be between " + min + " " + "and"
                + " " + max + ".");
    }
}
