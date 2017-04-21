/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PickyEater;

import java.util.Scanner;

public class PickyEater {
    public static void main(String[] args){
        
        Scanner inputReader = new Scanner(System.in);
        
        System.out.println("How many times has it been fried (#)");
        int timesFried = inputReader.nextInt();
        
        System.out.println("Does it have spinach in it? (y/n)");
        String hasSpinach = inputReader.next();
        
        System.out.println("Is it covered in cheese? (y/n) ");
        String cheeseCovered = inputReader.next();
        
        System.out.println("How many dabs of butter on top ?(#)");
        int butterDabs = inputReader.nextInt();
        
        System.out.println("Is it covered in choclate? (y/n)");
        String choclateCovered = inputReader.next();
        
        System.out.println("Does it have a funny name? (y/n)");
        String funnyName = inputReader.next();
        
        System.out.println("Is it broccholi? (y/n)");
        String isBroccholi = inputReader.next();
        
     
        
        if (hasSpinach.equals("y") || funnyName.equals("y")){
            System.out.println("There is no way that is getting eaten!");
            }
else if ((timesFried <= 4 && timesFried >= 2) && choclateCovered.equals("y")){
            System.out.println("Oh it is like deep fried snickers. That'll be "
                    + "a hit!");
            } 
        else if ((cheeseCovered.equals("y") || timesFried == 2)){
            System.out.println("Mmmm. Fried cheesey doobles will do it!");
            }
        else if (isBroccholi.equals("y") && (butterDabs >= 6)){
            System.out.println("As long as the green is hidden by cheddar,"
                    + " it'll happen!");
            }
        else {
            System.out.println("Oh, greens go in the garbage!");
            }
    }
}
