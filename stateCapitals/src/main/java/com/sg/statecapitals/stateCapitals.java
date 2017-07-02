/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;


import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class stateCapitals {
    
    public static void main(String[] args){
        int m = 0;
        int stringKeys = 0;
        //Iterator <String[], String[]> hashIterator = mapSet.iterator(); 
        HashMap<String, String> stateCapitals = new HashMap<>(); 
        
        stateCapitals.put("Kentucky ", "Frankfort");
        
        stateCapitals.put("Tennessee" , "Nashville");
        
        stateCapitals.put("Virginia", "Richmond");
        
        stateCapitals.put("North Carolina", "Raleigh");
        
        stateCapitals.put("Louisiana", "Baton Rouge" );
        
        System.out.println("My HashMap size is: " + stateCapitals.size());
        
        Set<String> keys = stateCapitals.keySet();
        for(String statesNames : keys){
            System.out.println("State Names: ");
            System.out.println(statesNames);
        }
        //Collection<String> stateNames = statesNames.keys();
        Collection<String> capitalNames = stateCapitals.values(); 
        
        for(String caps : capitalNames){
            System.out.println("Capitals: ");
            System.out.println(caps);
        }
   /* for(Map.Entry<String, String> e : map.entrySet()){
        e.getKey();
        e.getValue();
        String statesNames = get.statesName(keys);
        String caps = get.capitalNames(caps);
        System.out.println("States and their Capitals:");
        System.out.println(keys + ":" + capitalNames);
        Iterator<String> iterator = HashMap.iterator(); 
    } */
    }
}
