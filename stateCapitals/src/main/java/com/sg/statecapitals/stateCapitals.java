/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class stateCapitals {

    public static void main(String[] args) {
       
        Map<String, String> stateCapitals = new HashMap<>();

        stateCapitals.put("Kentucky ", "Frankfort");

        stateCapitals.put("Tennessee", "Nashville");

        stateCapitals.put("Virginia", "Richmond");

        stateCapitals.put("North Carolina", "Raleigh");

        stateCapitals.put("Louisiana", "Baton Rouge");

        System.out.println("My HashMap size is: " + stateCapitals.size());

        Set<String> keys = stateCapitals.keySet();
        System.out.println("State Names: ");
        for (String statesNames : keys) {

            System.out.println(statesNames);
        }
        //Collection<String> stateNames = statesNames.keys();
        Collection<String> capitalNames = stateCapitals.values();
        System.out.println("Capitals: ");
        for (String caps : capitalNames) {

            System.out.println(caps);
        }
        
        System.out.println("States and their Capitals:");
        for (String stateNames : keys) {

            System.out.println(stateNames + " | " + stateCapitals.get(stateNames));

        }
    }
}
