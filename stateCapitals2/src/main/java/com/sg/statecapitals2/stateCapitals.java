/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.statecapitals2;

import java.util.Scanner;

public class stateCapitals {

    Scanner inputReader = new Scanner(System.in);

    public String Frankfort() {

        String name = "Frankfort";
        int sqMiles = 18;
        int population = 25527;
        return name +  sqMiles  + population;

    }

    public String Nashville() {
        String name = "| Nashville";
        int sqMiles = 527;
        int population = 65217;
        return name +  sqMiles  + population;
    }

    public String Richmond() {
        String name = "| Richmond";
        int sqMiles = 570;
         int population = 22317;
       return name +  sqMiles  + population;
    }

    public String Raleigh() {
        String name = "| Raleigh";
        int sqMiles = 145;
        int population = 403892;
        return name +  sqMiles  + population;
    }

    public String BatonRouge() {
        String name = "| Baton Rouge";
        int sqMiles = 77;
        int population = 227715;
        return name +  sqMiles  + population;
    }

    public int userInput() {
        int userPop;
        String userNumber;
        System.out.println("Plase enter a population number to determine which state statistics to print");
        userNumber = inputReader.nextLine();
        userPop = Integer.parseInt(userNumber);
        return userPop;
    }
}
