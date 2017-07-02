/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


/**
 *
 * @author apprentice
 */
public class stateCapitals {
    public static void main(String[] args) {
        HashMap<String, String> stateCapitals = new HashMap<>();
        //make capital an object
       

        
        stateCapitals.put("Kentucky ", "| Frankfort"); 
        
        stateCapitals.put("Tennessee ", "| Nashville"); 
        
        stateCapitals.put("Virginia ", "| Richmond"); 
        
        stateCapitals.put("North Carolina ", "| Raleigh"); 
        
        stateCapitals.put("Louisiana ", "| Baton Rouge"); 
        
        System.out.println("My HashMap size is: " + stateCapitals.size());
          
        Set<String> keys = stateCapitals.keySet();
        System.out.println("State Names: ");
        for(String statesNames : keys){
            System.out.println(statesNames);
        }
        //Collection<String> stateNames = statesNames.keys();
        Collection<String> capitals = stateCapitals.values(); 
        
        for(String caps : capitals){
            System.out.println(caps);
        }
         Capital myCapital = new Capital();
         
     //   System.out.println(myCapital.getFrankfort() + myCapital.getNashville() + myCapital.getRichmond() + myCapital.getRaleigh() +
     //   myCapital.getBatonRouge());
    }
}
