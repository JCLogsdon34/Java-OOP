/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KnockKnock;

import java.util.Scanner;

public class KnockKnock {
    public static void main(String[] args){
        
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Knock, knock! Guess who!!");
        String nameGuess = inputReader.nextLine();
        
        /* does not print out Marty McFly */
        /* Again, it will not print out Marty McFly */
        
        if(nameGuess.equals("Marty McFly") || nameGuess.equals("marty mcfly")){
                System.out.println("Hey! Thats right! I''m back!");
                System.out.println(". . . from  the future");
        }else{
            System.out.println("Dude, do I-look-like " + nameGuess + " ?");
        }
    }
}
