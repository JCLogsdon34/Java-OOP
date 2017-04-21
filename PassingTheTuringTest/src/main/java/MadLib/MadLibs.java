/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MadLib;

import java.util.Scanner;
 
public class MadLibs {
    public static void main(String[] args){
        String noun;
        String adjective;
        String noun2;
        int number;
        String adjective2;
        String plural1;
        String plural2;
        String plural3;
        String verbPresent1;
        String verbPastTenseSame;
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("Please give me a noun");
        noun = inputReader.nextLine();
        
        System.out.println("Please give me an adjective");
        adjective = inputReader.nextLine();
        
        System.out.println("Please give me another noun");
        noun2 = inputReader.nextLine();
        
        System.out.println("Please give me a number");
        number = inputReader.nextInt();
        
        System.out.println("Please give me another adjective");
        adjective2 = inputReader.nextLine();
        
        System.out.println("Please give me a plural noun");
        plural1 = inputReader.nextLine();
        
        System.out.println("Please give me another plural noun");
        plural2 = inputReader.nextLine();
        
        System.out.println("Please give me yet abotherplural noun");
        plural3 = inputReader.nextLine();
        
        System.out.println("Please give me a present tense verb");
        verbPresent1 = inputReader.nextLine();
        
        System.out.println("Please give me the same verb, just in past tense");
        verbPastTenseSame = inputReader.nextLine();
        
        System.out.println(noun + " : the " + adjective + " frontier. These are"
                + "the voyages of the starship " + noun2 + ". Its " + number + 
                " -year mission: to explore strange " + adjective + " " + 
                plural1 + " to seek out " + adjective + " " + 
                plural2 + " and " + adjective +
                plural3 + " , to boldly " + verbPresent1 + " where no one had"
                + verbPastTenseSame + " before. ");
    }
}
