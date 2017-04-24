/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaybeLovesMe;

import java.util.Random;

public class MaybeLovesMe {
    public static void main(String[] args){
        
        Random Randomizer = new Random();
        
        System.out.println("Well, here we go.");
        int limit = 13;
        
        int num = Randomizer.nextInt(89) + limit;
       
        
            while(num > limit){
                if(num%2 == 0){
                    System.out.println("He loves me");
                }
                else{
                    System.out.println("He loves me not");
                    
                } 
                num--;
            }
            if(num % 2 != 0){
                System.out.println("Oh wow! It really loves me!");
            } else if (num % 2 == 0){
                System.out.println("Bummer! That is too bad!");
            }
        }       

}
