/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;


import java.util.Scanner;



public class stateCapitals {
    public static void main(String[] args){
        int sqMiles;
        String userNumber;
        Scanner inputReader = new Scanner(System.in);
        
        Capital myCapital = new Capital();
         myCapital.getCapital();
         
 
           System.out.println("Plase enter a population number to determine which state statistics to print");
            userNumber = inputReader.nextLine();
            sqMiles = Integer.parseInt(userNumber);
    
}
    }

