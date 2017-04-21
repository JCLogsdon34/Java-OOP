/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.menuofchampions;

/**
 *
 * @author apprentice
 */
public class MenuofChampions {
    public static void main(String[] args){
        String name;
        String today;
        String item1, item2, item3;
        double  price1, price2, price3;
        
        
        name = "Chris's Turkish Eats";
        today ="The Specials today are . . .";
        item1 = "Giro";
        item2 ="Vriam";
        item3="Saganaki";
        price1 = 5.00;
        price2 = 7.00;
        price3 = 4.50;
        
        System.out.println("\t" + name);
        
        System.out.println("\t" + today);
        
                
    
        
        System.out.print(item1 +" " + "$" + price1 + "\t");
      
        System.out.print(item2 +" " + "$" + price2 + "\t");
      
        System.out.print(item3 +" " + "$" + price3 + "\t");
        
    }
}
