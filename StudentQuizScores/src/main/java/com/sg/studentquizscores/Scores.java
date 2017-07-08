/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class Scores {
    public static void main(String[] args){
        boolean userWork = false;
        String userResponse;
        String nameOfStudent;
        int examScore;
        
        //myScores.chrisObject();
        Scanner inputReader = new Scanner(System.in);
        
        
        
        Map<String, Object> quizscores = new HashMap<>();
        //make Integer an Object
        
        Set<String> keys = quizscores.keySet();
        do{
            
            System.out.println("Do you want to add, remove, or view student informtation?");
            userResponse = inputReader.nextLine();
            if(userResponse.equals("add")){
               System.out.println("Please enter the first and last name of the student");
                nameOfStudent = inputReader.nextLine();
                System.out.println("Please enter that student's exam score");
                examScore = inputReader.nextInt();  
                
                quizscores.put(nameOfStudent, examScore);
                
                
            }else if(userResponse.equals("remove")){
                System.out.println("Please enter the first and last name of the student");
                nameOfStudent = inputReader.nextLine();
                System.out.println("Please enter that student's exam score");
                examScore = inputReader.nextInt();  
                
                quizscores.remove(nameOfStudent);
                quizscores.remove(examScore);
            }else if(userResponse.equals("view")){
                System.out.println("Enter a choice of the following"
                        + " all entries or a certain student?");
                userResponse = inputReader.nextLine();
                if(userResponse.equals("all entries")){
                    for (String k : keys){
                        System.out.println("Student: " + k + "Scores" + quizscores.get(k));
                    }
                }else if(userResponse.equals("a certain student")){
                    System.out.println("Please enter the first and last name of the student");
                    nameOfStudent = inputReader.nextLine();
                }
            }
            
        }while(userWork = false);
        

}
    }

