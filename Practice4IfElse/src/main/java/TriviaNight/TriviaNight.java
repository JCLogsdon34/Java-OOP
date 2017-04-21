/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TriviaNight;

import java.util.Scanner;


public class TriviaNight {
    public static void main(String[] args){
        int questionOne;
        int questionTwo;
        int questionThree;
        int correct;
        String message;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("It is Trivia Night! Are you READY!!");
        
        correct = 0;
        
        System.out.println("First Question:");
        System.out.println("What is the lowest level programming language?"
        + " 1: Source Code " + " 2: Assembly Language " + " 3: C#" +
                " 4: Machine Code");
       questionOne = inputReader.nextInt();
       if(questionOne == 4){
           correct += 1;
       }
       System.out.println("Second Question:");
       System.out.println("Website security CAPCHA forms are descended "
        + "from the work of? " + " 1. Grace Hopper" + " 2. Alan Turing"
        + " 3. Charles Babbage" + "4. Larry Page ");
    questionTwo = inputReader.nextInt();
      if(questionTwo == 2){
          correct += 1;
       }
       System.out.println("Last Question:");
       System.out.println("Which of these sci-fi ships was slated to be  "
+ "replicated in Las Vegas?" + " 1. Serenity" + 
               "2. Battlestar Gallactica "+ " 3. USS Enterprise" 
               + " 4. Millenium Falcon ");
    questionThree = inputReader.nextInt();
      if(questionThree == 3){
          correct += 1;
       }
       
      message = "";
      
       if(correct == 3){
           message = "You got them all! Greeat Job!";
       }else if (correct == 0){
           message = "You did not get a single one!Bummer!";
       }else{
           message = "You got " + correct + " right! Nice!";
       }
       System.out.println(message);
    }
}
