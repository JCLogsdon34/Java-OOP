/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HiddenNuts;

import java.util.Random;

public class HiddenNuts {
    public static void main(String[] args){
        String[] hidingSpots = new String[100];
        Random squirrel = new Random((100) + 1);
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

		// Nut finding code should go here!
                for(int i =0; i < 101; i++){
                    squirrel.nextInt(hidingSpots.length);
                }
                    System.out.println("Found the nut! it is at" + squirrel);
                    
                }
    }

