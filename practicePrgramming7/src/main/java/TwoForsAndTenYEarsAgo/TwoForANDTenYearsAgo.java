/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoForsAndTenYEarsAgo;

import java.util.Scanner;

public class TwoForANDTenYearsAgo {
    public static void main(String[] args){
         Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }
//the range in both is 0 up to 10 on the first loop, 10 - 0 in the second
        System.out.println("\nI can count backwards using a different way too...");
//the first makes more sense,as we are counting from year zero to the input 
        for (int i = year; i >= year - 20; i--) {
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}
