/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.practice3;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DontForgetToStoreIt {
    public static void main(String[] args){
        
        int meaningOfLifeAndEverything = 42;
        double pi = 3.14159;
        String yourCheese, yourColor;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.print("Give me pi to at least 5 decimals: ");
        pi = inputReader.nextDouble();
        
        System.out.print("What is the meaning of lfe, the universe, &" +
        "everything?");
        
        meaningOfLifeAndEverything = inputReader.nextInt();
        
        System.out.print("What is your favorite kind of cheese?");
        yourCheese = inputReader.nextLine();
        
        
        System.out.println("Do you like the color red or blue more ?");
        yourColor = inputReader.nextLine();
    }
}
