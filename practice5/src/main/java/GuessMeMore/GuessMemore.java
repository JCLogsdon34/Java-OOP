/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMeMore;

import java.util.Scanner;
import java.util.Random;

public class GuessMemore {
    public static void main(String[] args){
     byte guess;
    
        Scanner inputReader = new Scanner(System.in);
        
        Random Randomizer = new Random();
        
        System.out.println("Hey, I choose another number for you to guess.");
        System.out.println("This one is between -100 and 100");
        System.out.println("Go ahead, take a guess");
        guess = inputReader.nextByte();
        
        int num = Randomizer.nextInt(101) - 201;
        
        System.out.println("The number is " + num);
        
        if(guess == num){
            System.out.println("Yay! You got it!");
        } else if (guess > num){
            System.out.println("Too high!");
        } else if (guess < num){
            System.out.println("To low!");
        }
        
    }
    
}
