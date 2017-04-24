/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoOrDoNot;

import java.util.Scanner;

public class DoOrDoNot {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Should I do it? (y/n) ");
        boolean doIt;
        
        if (input.next().equals("y")) { //if y, then the bool is true and it prnts I did it.
            doIt = true; // DO IT!
        } else { // bool is false and it does it anyway
            doIt = false; // DONT YOU DARE!
        }

        boolean iDidIt = false;

        /*do {
            iDidIt = true;
            break;
        } while (doIt);

        if (doIt && iDidIt) {
            System.out.println("I did it!");
        } else if (!doIt && iDidIt) {
            System.out.println("I know you said not to ... but I totally did anyways.");
        } else {
            System.out.println("Don't look at me, I didn't do anything!"); */
        if(doIt = true){
            
         while(doIt){
             if(doIt && iDidIt){
            System.out.println("I did it!");
            break;
            } 
         }
         if(!doIt && iDidIt){  
            while(!doIt && iDidIt){
        System.out.println("I know you said not to ... "
                + "but I totally did anyways.");
            }
        }else {
            System.out.println("Don't look at me, I didn't do anything!");
            
         }
        }
    }
}
