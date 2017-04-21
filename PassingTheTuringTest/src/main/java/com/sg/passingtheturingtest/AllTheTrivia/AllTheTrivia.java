/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.passingtheturingtest.AllTheTrivia;

import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args){
   String city;
   String person;
   String region;
   int number;
   
   Scanner inputReader = new Scanner(System.in);
   
   System.out.println("What city did Zorba the Greek learn Turkish songs?");
   city = inputReader.nextLine();
   
   System.out.println("What was the name of the slave Nero fell in love with?");
   person = inputReader.nextLine();
   
   System.out.println("What region were the Claudii family from?");
   region = inputReader.nextLine();
   
   System.out.println("How many sons did Marc Antony have by Octavia");
   number = inputReader.nextInt();
   
   System.out.println("So, " + person + "is from " + region);
   System.out.println( city + " is where Zorba had his " + number + "son");
   System.out.println("Octavia had "+ region + ", who was fathered by Zorba");
   System.out.println("For some reason none of that sounds quite right . . .");
           }
}
