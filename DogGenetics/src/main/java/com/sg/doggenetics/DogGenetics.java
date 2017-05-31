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

        System.out.println("Well, I have this highly reliable DNA report"
                + " about " + dogName + "'s very dignified background.");

        Random dogGenes = new Random();

        int dachshund = dogGenes.nextInt(101);
        int corgi = dogGenes.nextInt(101 - dachshund);
        int dalmation = dogGenes.nextInt(101 - dachshund - corgi);
        int wolfhound = dogGenes.nextInt(101 - dachshund - corgi - dalmation);
        int mastiff = (100 - dachshund - corgi
                - dalmation - wolfhound);

        System.out.println("It turns out, " + dogName + " is a percent of"
                + " each of the following breeds: ");
        System.out.println(dachshund + "% Dachsund");
        System.out.println(corgi + "% Corgi");
        System.out.println(dalmation + "% Dalmation");
        System.out.println(wolfhound + "% Wolfhound");
        System.out.println(mastiff + "% Mastiff");

        System.out.println(" What a hound!");
    }
}