/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.orderthings;

/**
 *
 * @author apprentice
 */
public class TheorderofThings {
    public static void main(String[] args){
        double number;
        String opinion, size, age, shape, color, origin, material, purpose;
        String noun;
        
        number = 5.0;
        opinion = "AWESOME";
        size = "teensy-weensy";
        age = "new";
        shape = "oblong";
        color = "BRIGHT yellow";
        origin = "AlphaCenturian";
        material="platinum";
        purpose="good";
        
        noun="dragons";
      //Using + with strings , this concatonates, does not add.
      System.out.println(number + " " + opinion + " " + material + " " + age + " " + 
      shape + " " + origin + " "+ color + " " + size + " " + purpose + " " 
      + noun);
      
    }
}
