/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HighRoller;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args){
        int sides;
        
        Random diceRoller = new Random();
        Scanner inputReader = new Scanner(System.in);
        
       

        System.out.println("TIME TO ROOOOOOLL THE DICE!");
        System.out.println("How man sides does that die of your have?");
        sides = inputReader.nextInt();
        
        
         int rollResult = diceRoller.nextInt(21) + 1;
       
        

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch!");
        } else{
            System.out.println("I rolled a " + rollResult);
        }
    }
}
