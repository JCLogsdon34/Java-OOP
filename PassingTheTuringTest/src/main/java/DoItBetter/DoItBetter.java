/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoItBetter;

import java.util.Scanner;

public class DoItBetter {
   public static void main(String[] args){
   int number;
   int hotdogs;
   int languages;
   double me;
   
   Scanner inputReader = new Scanner(System.in);
   
   me = (inputReader.nextInt()) +1;
   
   System.out.println("How many miles can you run?");
   number = inputReader.nextInt();
   System.out.println("Oh really, " + number + "I can do " + me );
   
   System.out.println("How many hotdogs can you eat?");
   hotdogs = inputReader.nextInt();
   System.out.println("Well, only " + hotdogs + "I can do " + me);
   
   System.out.println("How many languagfes do you speak?");
   languages = inputReader.nextInt();
   System.out.println("Ha! " + languages + "I know " + me);
   
   
    }
}
