/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FieldDay;

import java.util.Scanner;


public class FieldDay {
    public static void main(String[] args){               
        String userSurname;
        String s1 = "Baggins";
        String s2 = "Dresden";
        String s3 = "Howl";
        String s4 = "Potter";
        String s5 = "Vimes";
        int studentCompare;
    
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Hello and welcome to Field Day. "
                + "What is your last name, please?");
        userSurname = inputReader.nextLine();
        
                //userSurname.compareTo(s1);
                //userSurname.compareTo(s2); //assign vars and put in ifs
                //userSurname.compareTo(s3);
                //userSurname.compareTo(s4);
                //userSurname.compareTo(s5);
    
                
                
            if(userSurname.compareTo(s1) < 0){
                   System.out.println("Aha! You're on the team 'Red Dragons;");
                }
            else if(userSurname.compareTo(s2) < 0){
                  System.out.println("Aha! You're on the team 'Dark Wizards'");
                }
            else if(userSurname.compareTo(s3) < 0){
                 System.out.println("Aha! You're on the team 'Moving Castles'");
                }
            else if(userSurname.compareTo(s4) < 0){
                System.out.println("Aha! You're on the team 'Golden Snitches'");
                }
            else if(userSurname.compareTo(s5) < 0){
                  System.out.println("Aha! You're on the team 'Night Guards'");
                }
            else{
                   System.out.println("Aha! You're on the team 'Black Holes'");
                }    
                
        System.out.println("Good luck in the games!");
    }
}
