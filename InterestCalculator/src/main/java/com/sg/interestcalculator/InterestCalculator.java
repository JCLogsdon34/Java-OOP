package com.sg.interestcalculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class InterestCalculator {

    public void getInterestCalculator() {

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

        System.out.println("You have a starting balance of " + principle);

        BigDecimal divider = myMath.calculate(MathOperator.DIVIDE, interestRate, Divisor);
        BigDecimal adder = myMath.calculate(MathOperator.PLUS, Adder, divider);
        BigDecimal quarterBalance1 = myMath.calculate(MathOperator.MULTIPLY, principle, adder);

        BigDecimal divider2 = myMath.calculate(MathOperator.DIVIDE, interestRate, Divisor);
        BigDecimal adder2 = myMath.calculate(MathOperator.PLUS, adder, divider2);
        BigDecimal quarterBalance2 = myMath.calculate(MathOperator.MULTIPLY, quarterBalance1, adder2);

        BigDecimal divider3 = myMath.calculate(MathOperator.DIVIDE, interestRate, Divisor);
        BigDecimal adder3 = myMath.calculate(MathOperator.PLUS, Adder, divider3);
        BigDecimal quarterBalance3 = myMath.calculate(MathOperator.MULTIPLY, quarterBalance2, adder3);

        BigDecimal divider4 = myMath.calculate(MathOperator.DIVIDE, interestRate, Divisor);
        BigDecimal adder4 = myMath.calculate(MathOperator.PLUS, Adder, divider4);
        BigDecimal quarterBalance4 = myMath.calculate(MathOperator.MULTIPLY, quarterBalance3, adder4);

        BigDecimal interestTotal = myMath.calculate(MathOperator.MINUS, quarterBalance4, principle);

        System.out.println(" Quarter1: " + quarterBalance1 + " Quarter2: " + quarterBalance2
                + " Quarter3: " + quarterBalance3 + " Quarter4: " + quarterBalance4
                + " Year: " + numberOfYears + " Total Interest: " + interestTotal + ".");
    }  //try one year at a time, then add
}
