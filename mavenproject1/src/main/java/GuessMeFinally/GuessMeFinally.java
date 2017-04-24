/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMeFinally;

import java.util.Scanner;

public class GuessMeFinally {
    public static void main(String[] args){
        int number = 42;
        int guess;
        
        Scanner inputReader = new Scanner(System.in);
        
        
        System.out.println("I've choosen a number. I bet you can't guess it!");
        
        guess = inputReader.nextInt();
        
        if(guess != 42){
            while(number > guess) {
                 System.out.println("Ha! Nice try, too low!");
                    System.out.println("Give it another try!");
                        guess = inputReader.nextInt();
        } 
            while (number < guess) {
                System.out.println("Too bad, way too high!t");
                    System.out.println("Give it another try!");
                        guess = inputReader.nextInt();
                        }
                   }
        if(guess == 42) {
            System.out.println("Wow! Nice guess! That was it. 42.");
            }
        }  
    }



