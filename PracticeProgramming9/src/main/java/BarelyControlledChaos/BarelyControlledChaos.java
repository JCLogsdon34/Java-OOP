/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BarelyControlledChaos;

import java.util.Random;

public class BarelyControlledChaos {
    public static void main(String[] args){
        
        Random Randomizer = new Random();
        
        
        int color = color(); // call color method here 
        int animal = animal(); // call animal method again here 
        int colorAgain = colorAgain(); // call color method again here 
        int weight = weight(); // call number method, 
            // with a range between 5 - 200 
        int distance = distance(); // call number method, 
            // with a range between 10 - 20 
        int number = number(); // call number method, 
            // with a range between 10000 - 20000 
        int time = time(); // call number method, 
            // with a range between 2 - 6            
    
        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal 
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over " 
            + number + " " + colorAgain + " poppies for nearly " 
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, " 
            + "let me tell you!");
    }
        // ??? Method 1 ???
    public static int color(){
        Random randomizer = new Random();
        int purple = 4;
        int orange = 3;
        int blue =2;
        int green =1;
        int red = 0;
        int color = randomizer.nextInt((4) -1);
        
            return color;
        }
    public static int animal(){
            Random Randomizer = new Random();
            int cat;
            int dog;
            int worm;
            int fish;
            int rat;
            int animal = Randomizer.nextInt((4) -1); 
            return animal;
    }
    public static int colorAgain(){
        Random randomizer = new Random();
        int purple = 4;
        int orange = 3;
        int blue =2;
        int green =1;
        int red = 0;
        int colorAgain = randomizer.nextInt((4) -1);
        
            return colorAgain;
        }
    public static int weight(){
        Random Randomizer = new Random();
        int number = Randomizer.nextInt((2) -1);
        return number;
        }
    public static int distance(){
        Random Randomizer = new Random();
        int distance = Randomizer.nextInt((2) -1);
        return distance;
        }
    public static int number(){
        Random Randomizer = new Random();
        int number = Randomizer.nextInt((2) -1);
        return number;
        }
    public static int time(){
        Random Randomizer = new Random();
        int time = Randomizer.nextInt((2) -1);
        return time;
        }
    }
    // ??? Method 2 ??? 
    // ??? Method 3 ??? 

