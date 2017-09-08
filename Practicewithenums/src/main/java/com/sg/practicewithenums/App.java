/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practicewithenums;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class App {
    
   
    public static void main(String[] args){
        Scanner inputReader = new Scanner(System.in);
        String userOpp;
        
        int operand1;
        int operand2;
        
        System.out.println("Please enter the first number you want to use.");
        operand1 = inputReader.nextInt();
        System.out.println("Please enter the second number you want to use.");
        operand2 = inputReader.nextInt();

        
        IntMath mathInt = new IntMath();
        
         mathInt.mathityMath(operand1 , operand2);
       
        
      //  mathInt.calculate(MathOperator operator, operand1, operand2);
    }
    
}
