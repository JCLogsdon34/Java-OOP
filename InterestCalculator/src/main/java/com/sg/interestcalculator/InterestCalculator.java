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

            //float total;
            for (int j = 1; j <= 4; j++) {
                float quarterBalance = (float) (principle * (interestRate / 100));
                float oneYear = (float) (quarterBalance * 3);
                //float newBalance = oneYear * numberOfYears;
                float interestTotal = (float) principle - oneYear;

                System.out.println("month: " + j + " Quarter: " + quarterBalance
                        + " Year: " + oneYear + "Total Interest: " + interestTotal + ".");
            }
            float newBalance = (float) ((principle * (1 + (interestRate / 100)) * numberOfYears));
            System.out.println("your balance at " + numberOfYears
                    + "years is: " + newBalance);

            //try one year at a time, then add
        }
    }
}
