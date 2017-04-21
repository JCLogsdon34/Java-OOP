/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.adder;

import java.util.Scanner;

public class BestAdderEver {
    public static void main(String[] args){
        int Fig;
        int Grape;
        int Olive;
        int Price;
        
        Scanner inputReader = new Scanner(System.in);
      
        
    System.out.println("How much is a Fig worth? ");
    Fig = inputReader.nextByte();
    
    System.out.println("How much is a Grape worth? ");
    Grape = inputReader.nextByte();
    
    System.out.println("How much is a an Olive worth? ");
    Olive = inputReader.nextByte();
    
    System.out.println(Fig + Grape + Olive);       
    Price = (Fig + Grape + Olive);
    
    }
}
