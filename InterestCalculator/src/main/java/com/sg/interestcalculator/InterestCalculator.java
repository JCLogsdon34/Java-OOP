/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.interestcalculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class InterestCalculator {

    public void getInterestCalculator(){
        
        BigDecimalMath myMath = new BigDecimalMath();

        Scanner inputReader = new Scanner(System.in);
        
        BigDecimal Divisor = new BigDecimal("100");
        BigDecimal Adder = new BigDecimal("1");

        System.out.println("Please enter the following:");

        System.out.println("Interest Rate: ");
        String interestRateString = inputReader.nextLine();
        BigDecimal interestRate = new BigDecimal(interestRateString);

        System.out.println("Principle: ");
        String principleString = inputReader.nextLine();
        BigDecimal principle = new BigDecimal(principleString);
       
        
        System.out.println("Years in the fund: ");
       String numberOfYearsString = inputReader.nextLine();
       BigDecimal numberOfYears = new BigDecimal(numberOfYearsString);
        //float oneYear;
        System.out.println("You have a starting balance of " + principle);
        //public static double interestCalculator(double prinicple, double interestRate, double numberOfYears) {
        
        /*
        BigDecimal op1 = new BigDecimal("10");
        //BigDecimal op2 = new BigDecimal("3");
        BigDecimal op2 = new BigDecimal("6");
        
        System.out.println(myMath.calculate(MathOperator.PLUS, op1, op2));
        System.out.println(myMath.calculate(MathOperator.MINUS, op1, op2));
        System.out.println(myMath.calculate(MathOperator.MULTIPLY, op1, op2));
        System.out.println(myMath.calculate(MathOperator.DIVIDE, op1, op2));
        */

       /* for (int i = 0; i <= numberOfYears; i++) {

            for (int j = 1; j <= 4; j++) {

                do {  */
          //          float quarterBalance1 = (float) (principle * (1 + (interestRate / 100)));
//float mathDivision = (myMath.calculate(MathOperator.Divide,interestRate,100)); 
//float mathAddition = (myMath.calculate(MathOperator.Add, 1, (myMath.calculate(MathOperator.Divide,interestRate,100))));
BigDecimal quarterBalance1 = 
        new BigDecimal((((myMath.calculate(MathOperator.MULTIPLY, principle, 
        (myMath.calculate(MathOperator.PLUS, Adder, 
                (myMath.calculate(MathOperator.DIVIDE,interestRate, Divisor)))))))));

BigDecimal quarterBalance2 =  new BigDecimal(((quarterBalance1) 
        (Adder + (interestRate / Divisor)));

BigDecimal quarterBalance3 = ((quarterBalance2) * (Adder + (interestRate / Divisor)));
BigDecimal quarterBalance4 =  ((quarterBalance3) * (Adder + (interestRate / Divisor)));
BigDecimal oneYear =  (quarterBalance4);
                    //float newBalance = oneYear * numberOfYears;
BigDecimal interestTotal = quarterBalance4 - principle;

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
