/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DogGenetics;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args){
        String name;
        
        
        Scanner inputReader = new Scanner(System.in);
        
    System.out.println("What is your dog's name");
        name = inputReader.nextLine();
    System.out.println("Well then, I have this highly reliable "
            + "report on" + name + "'s prestigious background right here.");
        
    Random Randomizer = new Random();
        
    int Dachsund = Randomizer.nextInt(11)+ 10;
    int Corgi = Randomizer.nextInt(11 - Dachsund) + 10;
    int Akita = Randomizer.nextInt(11 - Dachsund - Corgi) + 10;
    int Wolf = Randomizer.nextInt(11 - Dachsund - Corgi - Akita) + 10;
    int Mutt = Randomizer.nextInt(11 - Dachsund - Corgi - Akita - Wolf) + 10;
    
    System.out.println(name + " is the following: ");
    System.out.println(Dachsund + " Dachshund");
    System.out.println(Corgi + " Corgi");
    System.out.println(Akita + " Akita");
    System.out.println(Wolf + " Wolf");
    System.out.println(Mutt + " Mutt");
    }
}
