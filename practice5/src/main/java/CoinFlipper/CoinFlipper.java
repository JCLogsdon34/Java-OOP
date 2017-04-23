/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoinFlipper;

import java.util.Scanner;
import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args){
        Random Randomizer = new Random();
        Scanner inputReader= new Scanner(System.in);
        String coin;
       
        
        System.out.println("Heads or tails?");
        coin = inputReader.nextLine();
        
        Boolean side = Randomizer.nextBoolean();
        
        if(side == true){
            System.out.println("Heads!");
            
        } else if (side == false){ 
            System.out.println("Tails");
        }
    }
}
