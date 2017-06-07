/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.factorizer;

import java.util.Scanner;

public class Factorizer {

    public void getFactor(){
        int userNumber;
        int i =1;
        int factors;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Please enter a number");
        userNumber = inputReader.nextInt();

        System.out.println("You chose the number " + userNumber);

        factors = userNumber / i;
        /*factors = userNumber/i;
               
                if(factors == userNumber){
                   System.out.println("Your number is a perfect number");
               } else {
                   System.out.println("Your number is not perfect");
               }*/
        
        for (i = 1; i <= userNumber; i++) {
            if (userNumber % i == 0) {
                factors = userNumber / i;
            System.out.println(factors);
            
            }            
             if(factors == userNumber) {

                        System.out.println("Your number is a perfect number");
                            break;
                    }else if (factors != userNumber){
                        System.out.println("Your number is not perfect");
                           break;
                    }
            if(userNumber % 2 == 0){
                       System.out.println("This is not a prime number");
                        break;
                     }else if(userNumber % 2 != 0){
                    System.out.println("This is a prime numbner");
                    break;
                }
        }
    }

}
