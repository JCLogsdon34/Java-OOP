/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.passingtheturingtest;

import java.util.Scanner;

public class PassingTheTuringTest {
    public static void main(String[] args){
        
        String name;
        String color;
        String food;
        int number;

        Scanner inputReader = new Scanner(System.in);
       
        System.out.print(" What is your name? ");
        name = inputReader.nextLine();
        System.out.print(" I'm Chris. ");
        
        System.out.print(" Hello " + name + ", What is your favorite color? ");
        color = inputReader.nextLine();
        System.out.print(" oh " + color + " I like red ");
        
        System.out.print(" Ok, what is your favorite food? ");
        food = inputReader.nextLine();
        System.out.print(food + " Oh I like that, but mine is gyro. ");
        
        System.out.print(" Alright, lastly what is your favorite number? ");
        number = inputReader.nextInt();
        System.out.print(number +" huh, mine is 42, the meaning of everything.");
        
        System.out.println(" Goodbye, nice taking to ya buddy! ");
        
    }
}
