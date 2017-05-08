/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        float interestRate;
        float principle;
        float numberOfYears;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Please enter the following:");

        System.out.println("Interest Rate: ");
        interestRate = inputReader.nextFloat();

        System.out.println("Principle: ");
        principle = inputReader.nextFloat();

        System.out.println("Years in the fund: ");
        numberOfYears = inputReader.nextFloat();

        //float oneYear;
        System.out.println("You have a starting balance of " + principle);
        //public static double interestCalculator(double prinicple, double interestRate, double numberOfYears) {
        for (int i = 0; i <= numberOfYears; i++) {

            for (int j = 1; j <= 4; j++) {

                do {
                    float quarterBalance1 = (float) (principle * (1 + (interestRate / 100)));

                    float quarterBalance2 = (float) ((quarterBalance1) * (1 + (interestRate / 100)));

                    float quarterBalance3 = (float) ((quarterBalance2) * (1 + (interestRate / 100)));
                    float quarterBalance4 = (float) ((quarterBalance3) * (1 + (interestRate / 100)));
                    float oneYear = (float) (quarterBalance4);
                    //float newBalance = oneYear * numberOfYears;
                    float interestTotal = (float) quarterBalance4 - principle;

                    System.out.println(" Quarter1: " + quarterBalance1 + " Quarter2: " + quarterBalance2
                            + " Quarter3: " + quarterBalance3 + " Quarter1: " + quarterBalance4
                            + " Year: " + oneYear + " Total Interest: " + interestTotal + ".");
                    break;
                } while (j == 4);
                float newBalance = (float) ((principle * (1 + ((interestRate / 100)) * numberOfYears)));
                do {
                    System.out.println("your balance at " + numberOfYears
                            + "years is: " + newBalance);
                    break;
                } while (i == numberOfYears);

            }  //try one year at a time, then add
        }
    }
}
