/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BewareTheKraken;

import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args){
        
        Scanner inputReader = new Scanner(System.in);
        
         System.out.println("Already, get those flippers and wetsuit on -"
                 + " we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;

        // Turns out the ocean is only so deep, 36200 at the deepest survey,
        // so if we reach the bottom ... we should probably stop.
        while(depthDivedInFt < 36200){ //when I set this to ==36200, it did not run
                                        //I also tried settign it to zero, and it printed that we went down 100ft
            System.out.println("So far, we've swam " + depthDivedInFt + 
                    " feet");
            while(depthDivedInFt == 11000){
                System.out.println("Oh look, a clownfish!");
                break;
            }
           while(depthDivedInFt == 13000){
               System.out.println(" Are you all tired? Want to surface? (y/n)");
        String goUp = inputReader.nextLine();
            if(goUp.equals("y")){
                System.out.println("Sure, let's go on up.");
                System.out.println("Swimming cramps are bad!");
                break;
            }else if(goUp.equals("n")){
                System.out.println("Ok, onwards . . . or you know, downwards."
                        + "Whatever, its is hard to tell in the Ocean!");
                break;
                }
            }
            while(depthDivedInFt == 15000){
                System.out.println("Look, a shark!");
                break;
            }
            while(depthDivedInFt == 18000){
               System.out.println("Look, a Scylla! All thsoe heads are ugly!");
               break;
            }
            
            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            // I can swim, really fast! 500ft at a time!
            depthDivedInFt += 1000;
      
        System.out.println("We ended up swimming " + depthDivedInFt 
                + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
    }
}
