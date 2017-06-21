/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.simplecalculator;

import java.util.Scanner;


public class SimpleCalculator {

    public void getSolution() {
        Scanner inputReader = new Scanner(System.in);
        int firstNumber = 0;
        int secondNumber = 0;
        String userOperand;
        String moreNums;
        boolean calcLoop = false;

        //something more back and forth between classes
        do {
              System.out.println("Please enter your first number.");
            firstNumber = inputReader.nextInt();

            System.out.println("Please enter your second number");
            secondNumber = inputReader.nextInt();

            System.out.println("Please enter your desired operand.");
            userOperand = inputReader.next();

            
            //use a different class, four methods. not cohesive this way

            switch (userOperand) {
                case "+":
                    if (userOperand.equals("+")) {
                        Calculator myCalculator = new Calculator();
                        myCalculator.getSum();
                    }
                    break;
                case "-":
                    if (userOperand.equals("-")) {
                        Calculator myCalculator = new Calculator();
                        myCalculator.getDifference();
                    }
                    break;
                case "/":
                    if (userOperand.equals("/")) {
                        Calculator myCalculator = new Calculator();
                        myCalculator.getQuotiant();
                    }
                    break;
                case "*":
                    if (userOperand.equals("*")) {
                        
                        Calculator myCalculator = new Calculator();
                        myCalculator.getDifference();
                    }
                    break;
                default:
                    System.out.println("Improper input, please start again.");
            }

            System.out.println("Do you have more numbers?");
            moreNums = inputReader.nextLine();

            if (moreNums.equals("n")) {
                calcLoop = true;
            } else if (moreNums.equals("y")) {
                calcLoop = false;
            }
        } while (calcLoop == false);
    }
}
