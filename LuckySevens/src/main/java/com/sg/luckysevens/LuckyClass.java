/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevens;

import java.util.Random;
import java.util.Scanner;

public class LuckyClass {
    public static void main(String [] args){
        Random clickityClack = new Random((12) + 1);
        Scanner bet = new Scanner(System.in);
               
        int money = 0;
        int topWinnings;
        int rolls;
        //int topRolls = 0;
        int bottomRolls;
        int startingBet;
        

        System.out.println("How many dollars do you want to bet?");
        startingBet = bet.nextInt();
        
        money = startingBet;
        topWinnings = money;
        rolls = 0;


        //i is for the throws of dice
        for(rolls = 0; money > 0; rolls++){
        do{

            //rolls++;
            int dice1 = clickityClack.nextInt(6) + 1;
            int dice2 = clickityClack.nextInt(6) + 1;
            
            
            if(dice1 + dice2 == 7){
                money += 4;
            } else if (dice1 + dice2 != 7){
                 money -= 1;
                 
            }
              if((money == 0) && (rolls != 0)){
               bottomRolls = rolls;
              }
            
          while(money > topWinnings){
            topWinnings = money;
            int topRolls = rolls;
            System.out.println("You topped out at " + topWinnings + "dollars, "
                + "which you gained at " + topRolls + " rolls.");
          }
        
           
        }while(money > 0);
        
        System.out.println("You ran out of money at " + rolls + " rolls!");
        System.out.println(" You should have walked away then and there,"
                + " buddy. Now, Pay up!");
        }
    }
}
