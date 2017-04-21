/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.me;

/**
 *
 * @author apprentice
 */
public class AllAboutMe {
    public static void main(String[] args){
        String noun;
        String material;
        int pets;
        Boolean Gnocchi;
        int whistle;
        
        noun = "Chris Logsdon";
        pets = 1;
        material= "Giro";
        Gnocchi = true;
        whistle = 6;
        
        System.out.println("I am " + noun);
        System.out.println("I have " + pets + "pet(s)");
        System.out.println("My favorite food is "+ material);
        System.out.println("It is " + Gnocchi + " that I have eaten Gnocchi");
        System.out.println("I was " + whistle + " years old when i learned to "
            + whistle + "when I learned to whistle");
    }
}
