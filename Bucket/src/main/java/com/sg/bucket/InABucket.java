/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bucket;

/**
 *
 * @author apprentice
 */
public class InABucket {
    public static void main(String[] args){
        //you can declare all kinds of variables
        String walrus;
        double piesEaten;
        float weightofTeacupPig;
        int grainofSand;
        
        //But declaring them just sets up the space for data
        //to use the variable, you have to PUT data IN first!!
        walrus ="Sir Leroy Jenkins III";
        piesEaten=42.1;
        weightofTeacupPig=5;
        grainofSand=44;
        
        System.out.println("Meet my pet walrus, " + walrus);
        System.out.print("he was bitterly hungry today, and ate this many pies");
        System.out.println(piesEaten);
        System.out.print("The Tea Cup Pig weighs" + weightofTeacupPig);
        System.out.print("The number of grains of sand on that pig's feet is " + grainofSand);
    }
}
