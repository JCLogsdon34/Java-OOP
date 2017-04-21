/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YourLifeInMovies;

import java.util.Scanner;

public class YourLifeInMovies {
    public static void main(String[] args){
        int userAge;
        
    Scanner inputReader = new Scanner(System.in);
    
        System.out.println("How old are you?");
        userAge = inputReader.nextInt();
        
        if(userAge < 12) {
            System.out.println("Pixar's Up. Wow, that was half a decade ago");
        } else if (userAge < 22) {
            System.out.println("Can you believe that Harry Potter came out"
                    + "15 years ago");
        }else if (userAge < 32) {
            System.out.println("Space Jam did not come out laste decade"
                    + "but the one before that");
        }else if (userAge < 42) {
            System.out.println("You know, Jurassic Park came out closer"
                    + "to the kunar landing");
        }
        else if (userAge < 52) {
            System.out.println("MASH has been aroudn nearly half a century");
        }
    }
}
