/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class StudentsData implements studentquizscoresUserIO {
    

        void print() {
            System.out.println("Hello and welcome to the interface");
        }

        
        public String getUserDirections(){
            String userResponse;
          
            Scanner inputReader = new Scanner(System.in);
            System.out.println("Do you want to add, remove, or view student informtation?");
                userResponse = inputReader.next();
                return userResponse;
        }
      
        public String getStudents() {
            String userResponse;
        String nameOfStudent;
        String examScore;
        
            Scanner inputReader = new Scanner(System.in);
            
            System.out.println("Please enter the first and last name of the student");
                    nameOfStudent = inputReader.nextLine();
                    System.out.println("Please enter that student's exam score");
                    examScore = inputReader.nextLine();
                 
            return nameOfStudent + examScore;
        }   
        
        public String getStudent(){
            String userResponse;
            String nameOfStudent;
          
            Scanner inputReader = new Scanner(System.in);
            
            System.out.println("Please enter the first and last name of the student");
                    nameOfStudent = inputReader.nextLine();
            
            return nameOfStudent;
        }
        
        void Exit (){
            System.out.println("Thank you and goodbye");
        }
    }

