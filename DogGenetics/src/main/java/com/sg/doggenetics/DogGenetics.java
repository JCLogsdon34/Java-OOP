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
        String dogName;

        Scanner inputReader = new Scanner(System.in);

        System.out.println("Hello! Would you mind giving us your dog's name?");
        dogName = inputReader.nextLine();

        System.out.println("Well, I have this reliable DNA report"
                + " about " + dogName + "'s very dignified background.");

        Random dogGenes = new Random();

        int Dachshund = dogGenes.nextInt(101);
        int Corgi = dogGenes.nextInt(101 - Dachshund);
        int Dalmation = dogGenes.nextInt(101 - Dachshund - Corgi);
        int Wolfhound = dogGenes.nextInt(101 - Dachshund - Corgi - Dalmation);
        int Mastiff = (100 - Dachshund - Corgi
                - Dalmation - Wolfhound);

        System.out.println("It turns out, " + dogName + " is a percent of"
                + " each of the following breeds: ");
        System.out.println(Dachshund + "% Dachsund");
        System.out.println(Corgi + "% Corgi");
        System.out.println(Dalmation + "% Dalmation");
        System.out.println(Wolfhound + "% Wolfhound");
        System.out.println(Mastiff + "% Mastiff");

        System.out.println(" What a hound! ");
    }
}