/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dontforgettosaveit2;

import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class DontForgetToSaveIt {
    public static void main(String[] args){
        
        int meaningOfLifeAndEverything; 
        double pi;
        String cheese;
        String color;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Give me pi to at least 5 decimals: ");
        inputReader.nextDouble();
        pi = 3.14159;
        
        System.out.print("What is the meaning of lfe, the universe, & " +
        "everything?");
        inputReader.nextInt(); 
        meaningOfLifeAndEverything = 42;
        
        System.out.println("What is your favorite kind of cheese? \t");
        cheese = inputReader.nextLine();
        
        System.out.println("Do you like the color red or blue more? ");
        color = inputReader.nextLine();
        
        System.out.println("Ooh, " + color + " " + cheese + "sounds "
                + "delicious!");
        System.out.println("The circumstance of life is "
         +(2 * pi * meaningOfLifeAndEverything));
    }

}
