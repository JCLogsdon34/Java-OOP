/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Capital {

    public static void main(String[] args){ 

        int sqMiles = 0;
        String userNumber;
        Scanner inputReader = new Scanner(System.in);

        stateCapitals myStateCapitals = new stateCapitals();
        
        Map<String, Integer> stateCapitals = new HashMap<>();
        //make capital an object

        stateCapitals.put("Kentucky ", 33333);

        stateCapitals.put("Tennessee | Nashville | sqMiles: 527 | Pop: ", 65217);

        stateCapitals.put("Virginia | Richmond | sqMiles: 570 | Pop: ", 223170);

        stateCapitals.put("North Carolina | Raleigh | sqMiles: 145 | Pop: ", 403892);

        stateCapitals.put("Louisiana | Baton Rouge| sqMiles: 77 | Pop: ", 227715);

        System.out.println("My HashMap size is: " + stateCapitals.size());

        Set<String> keys = stateCapitals.keySet();
        //System.out.println("State Names: ");
        for (String statesNames : keys) {
            //System.out.println(statesNames);
        }
        //Collection<String> stateNames = statesNames.keys();
        Collection<Integer> capitals = stateCapitals.values();

        for (Integer capPops : capitals) {
            //System.out.println(capPops);
        }

        System.out.println("States and their Capitals:");
        
        for (String stateNames : keys) {

            System.out.println(stateNames + " | " + stateCapitals.get(stateNames));

            Integer kentuckyPop = stateCapitals.get("Kentucky");
            Integer tennesseePop = stateCapitals.get("Tennessee");
            Integer virginiaPop = stateCapitals.get("Virginia");
            Integer northCarolinaPop = stateCapitals.get("North Carolina");
            Integer louisianaPop = stateCapitals.get("Louisiana");

            switch (sqMiles) {
                case 1:
                    if (sqMiles <= 403892) {
                        System.out.println("The states with capitals above your number are: "
                                + kentuckyPop + " " + tennesseePop + " " + virginiaPop + " "
                                + northCarolinaPop + " " + louisianaPop + ".");
                    }
                    break;
                case 2:
                    if (sqMiles <= 227715) {

                        System.out.println("The states with capitals above your number are: "
                                + kentuckyPop + " " + tennesseePop + " " + virginiaPop + " "
                                + " " + louisianaPop + ".");
                    }
                    break;
                case 3:
                    if (sqMiles <= 223170) {
                        System.out.println("The states with capitals above your number are: "
                                + kentuckyPop + " " + tennesseePop + " " + virginiaPop + ".");
                    }
                    break;
                case 4:
                    if (sqMiles <= 65217) {

                        System.out.println("The states with capitals above your number are: "
                                + kentuckyPop + " " + tennesseePop + ".");
                    }
                    break;
                case 5:
                    if (sqMiles < 65217) {
                        System.out.println("The states with capitals above your number are: "
                                + kentuckyPop + ".");
                    }
                    break;
            }

        
        
        }
    }
}
