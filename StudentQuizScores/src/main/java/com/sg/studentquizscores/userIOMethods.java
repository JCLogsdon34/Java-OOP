/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class userIOMethods {
    public class userMethods implements studentquizscoresUserIO {
        
        public void print(String message) {
            message = "Hello and welcome to the interface";
            
        }
        
        int chrisObject (){
            
        int cScores = 0;
        ListofSocres myListofSocres = new ListofSocres();     
        
        myListofSocres.ChrisScores();
       // this.ChrisScores = cScores;
        
        myListofSocres.SavannahScores();
        //this.SavannahScores = sScores;
        return cScores; 
       }
        
        int savannahObject(){
            int sScores = 0;
            ListofSocres myListofSocres = new ListofSocres();
            myListofSocres.SavannahScores();
           //this.SavannahScores = sScores;
           
           return sScores;
        }
       
      
        public double readDouble(String prompt) {
            double readDouble;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number");
            readDouble = inputReader.nextDouble();
            return readDouble;
        }

      
        public double readDouble(String prompt, double min, double max) {
            double readDouble;
            Scanner inputReader = new Scanner(System.in);
            boolean keepGoing = true;

            do {
                System.out.println("Please enter a student whose scores you want to see");
                readDouble = inputReader.nextDouble();
                if (readDouble > 20 || readDouble < 10) {
                    keepGoing = true;
                } else {
                    keepGoing = false;

                    return readDouble;
                }
            } while (keepGoing = true);
            return readDouble;
        }

     
        public float readFloat(String prompt) {
            float readFloat;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number (a float)");
            readFloat = inputReader.nextFloat();
            return readFloat;
        }

        
        public float readFloat(String prompt, float min, float max) {
            float readFloat;
            Scanner inputReader = new Scanner(System.in);
            boolean keepGoing = true;

            do {
                System.out.println("Please enter a number (float) between 1.618 - 3.14");
                readFloat = inputReader.nextFloat();
                if (readFloat > 1.618 || readFloat < 3.14) {
                    keepGoing = true;
                } else {
                    keepGoing = false;

                    return readFloat;
                }
            } while (keepGoing = true);
            return readFloat;
        }

        
        public int readInt(String userPrompt) {
            int myInt;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number");
            myInt = inputReader.nextInt();
            return myInt;
        }

       
        public int readInt(String userPrompt, int min, int max) {
            Scanner inputReader = new Scanner(System.in);
            boolean keepGoing = true;
            int myInt = 0;

            do {
                System.out.println("Please enter a number between 1 - 5");
                myInt = inputReader.nextInt();
                if (myInt > 5 || myInt < 1) {
                    keepGoing = true;
                } else {
                    keepGoing = false;
                    return myInt;
                }
            } while (keepGoing = true);
            return myInt;
        }

       
        public long readLong(String prompt) {
            long readLong;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number(long)");
            readLong = inputReader.nextLong();

            return readLong;
        }

    
        public long readLong(String prompt, long min, long max) {
            long readLong;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number(long) between (-100) - 200");
            readLong = inputReader.nextLong();

            return readLong;
        }

   
        public String readString(String prompt) {
            String userSentence;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a sentence");
            userSentence = inputReader.nextLine();

            return userSentence;
        }
        public int ChrisScores(){
        int L = 100;
        int C = 100;
        int G = 98;
            
        ArrayList<Integer> chrisscores = new ArrayList<>();
        
        chrisscores.add(L);
        
        chrisscores.add(C);
        
        chrisscores.add(G);
        
        Iterator<Integer> iter = chrisscores.iterator();
        
        while(iter.hasNext()){
            int current = iter.next();
            System.out.println(current);
        }
        return L + C + G / chrisscores.size();         
    }
    
    public int SavannahScores(){
        int L = 98;
        int C = 80;
        int G = 93;
        int k = 99;
        
         ArrayList<Integer> savannahscores = new ArrayList<>();
        
        savannahscores.add(L);
        
        savannahscores.add(C);
        
        savannahscores.add(G);
        
        savannahscores.add(k);
        
        Iterator<Integer> iter = savannahscores.iterator();
        
        while(iter.hasNext()){
            int current = iter.next();
            System.out.println(current);
        }
        return L + C + G + k / savannahscores.size();
    }
    }
    
}


