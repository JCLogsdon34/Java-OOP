/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

/**
 *
 * @author apprentice
 */
public class Capital {
   // public void getCapital(){
    String name;
    String population;
    String sqMiles;

    //maybe use an ArrayList
    public void getFrankfort() {
        String name = "Frankfort";
        String population = "| Pop: 25,527";
        String sqMiles = "| sqMiles: 14.6";
        System.out.println(name + population + sqMiles);
    }

    public void getNashville() {
        String name = "Nashville";
        String population = "| Pop: 684,410";
        String sqMiles = "| sqMileas: 610";
        System.out.println(name + population + sqMiles);
    }

    public void getRichmond() {
        String name = "Richmond";
        String population = "| Pop: 223,170";
        String sqMiles = "| sqMiles: 570";
        System.out.println(name + population + sqMiles);
    }

    public void getRaleigh() {
        String name = "Raleigh";
        String population = "| Pop: 403,892";
        String sqMiles = "| sqMiles: 145";
        System.out.println(name + population + sqMiles);
    }

    public void getBatonRouge() {
        String name = "BatonRouge ";
        String population = "| Pop: 227,715";
        String sqMiles = "| sqMiles: 77";
        System.out.println(name + population + sqMiles);
    }
}

