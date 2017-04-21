/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guess;

import java.util.Scanner;

public class GuessMe {
    public static void main(String[] args){
        int number = 42;
        int guess;
        
        Scanner inputReader = new Scanner(System.in);
        
        
        System.out.println("I've choosen a number. I bet you can't guess it!");
        
        guess = inputReader.nextInt();
        
        if(guess == 42) {
            System.out.println("Wow! Nice guess! That was it.");
        }
        
        if (number < guess) {
            System.out.println("Ha! Nice try, too low! I choose 42!");
        }
        if (number > guess) {
            System.out.println("Too bad, way too high, I choose 42!");
        }
    }
}
