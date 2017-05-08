/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.doggenetics;

import java.util.Scanner;
import java.util.Random;

public class DogGenetics {

    public static void main(String[] args) {
        String name;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Hello! Would you mind giving us your dog's name?");
        name = inputReader.nextLine();

        System.out.println("Well, I have this reliable DNA report"
                + " about " + name + "'s very dignified background.");

        Random theGeneGenie = new Random();

        int Dachshund = theGeneGenie.nextInt(101);
        int Corgi = theGeneGenie.nextInt(101 - Dachshund);
        int Dalmation = theGeneGenie.nextInt(101 - Dachshund - Corgi);
        int Wolfhound = theGeneGenie.nextInt(101 - Dachshund - Corgi - Dalmation);
        int Mastiff = theGeneGenie.nextInt(101 - Dachshund - Corgi
                - Dalmation - Wolfhound);

        System.out.println("It turns out, " + name + " is a percent of"
                + "these following breeds: ");
        System.out.println(Dachshund + "% Dachsund");
        System.out.println(Corgi + "% Corgi");
        System.out.println(Dalmation + "% Dalmation");
        System.out.println(Wolfhound + "% Wolfhound");
        System.out.println(Mastiff + "% Mastiff");

        System.out.println(" How Distinguished! ");
    }
}
