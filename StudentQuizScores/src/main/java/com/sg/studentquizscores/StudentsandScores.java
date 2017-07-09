/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class StudentsandScores {

    public static void main(String[] args) {
        
        boolean userWork = false;
        String userResponse;
        String nameOfStudent = null;
        String examScore = null;
        Scanner inputReader = new Scanner(System.in);
        
HashMap<String, ArrayList<String>> quizscores = new HashMap<>();

        Set<String> keys = quizscores.keySet();
     
        

        ArrayList<String> studentscores = new ArrayList<>();
  
        StudentsData myStudentsData = new StudentsData();
        myStudentsData.print();

        myStudentsData.getUserDirections();
        
        do {

            System.out.println("Do you want to add, remove, or view student informtation? Or"
                    + "would you like to exit the program?");
            userResponse = inputReader.next();
            if (userResponse.equals("Exit")) {
                userWork = true;
            }
            if (userResponse.equals("add")) {
                
                myStudentsData.getStudents();
                
                quizscores.put(nameOfStudent , studentscores);
            
            } else if (userResponse.equals("remove")) {
                
                myStudentsData.getStudents();
                
                quizscores.remove(nameOfStudent , studentscores);
                
                studentscores.remove(examScore);
                
            } else if (userResponse.equals("view")) {
                System.out.println("Enter a choice of the following"
                        + " all entries or a certain student?");
                userResponse = inputReader.nextLine();
                if (userResponse.equals("all entries")) {
                    for (String k : keys) {
                        Iterator<String> iter = studentscores.iterator();
                        while (iter.hasNext()) {
                            String current = iter.next();
                            
                            studentscores.size();
                            
                            System.out.println("Student: " + nameOfStudent + "Scores" + quizscores.get(current));
                        }
                    }
                    if (userResponse.equals("a certain student")) {
                        System.out.println("Please enter the first and last name of the student");
                        nameOfStudent = inputReader.nextLine();

                        quizscores.get(nameOfStudent + ".");
                        System.out.println("Student: " + nameOfStudent + " " + quizscores.get(nameOfStudent));
                    }
                }
            }
        } while (userWork = false);
    }
}
