/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.morebuckets;

/**
 *
 * @author apprentice
 */
public class MoreBucketsMoreFun {
    public static void main(String[] args){
        int butterflies, beetles, bugs;
        String color, size, shape, thing;
        double number; //the double causes the number of bugs to stay the same
        
        butterflies = 2;
        beetles = 4;
        
        bugs= butterflies + beetles;
        System.out.println("There are only " + butterflies + "butterflies,");
        System.out.println("but " + bugs + "bugs total.");
        
        System.out.println("Uh oh, my dog ate one.");
        butterflies--; //Decrement
        System.out.println("Now there are only " + butterflies + "butterflies left.");
        
        System.out.println("But still " + bugs + " bugs left, wait a minute!!");
        System.out.println("Maybe I just counted wrong . . . ");
               
    }
}
