/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.userio;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class userIoMethods {

    public class UserIoMethods implements UserIO {
        //it may be you do need another class. Use these methods to call the methods
        //in that new class. Call them like objects, just as you did in Simple Calculator

        @Override
        public void print(String message) {
            System.out.println("Hello and welcome to the interface");
        }

        @Override
        public double readDouble(String prompt) {
            double readDouble;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number");
            readDouble = inputReader.nextDouble();
            return readDouble;
        }

        @Override
        public double readDouble(String prompt, double min, double max) {
            double readDouble;
            Scanner inputReader = new Scanner(System.in);
            boolean keepGoing = true;

            do {
                System.out.println("Please enter a number between 10 - 20");
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

        @Override
        public float readFloat(String prompt) {
            float readFloat;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number (a float)");
            readFloat = inputReader.nextFloat();
            return readFloat;
        }

        @Override
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

        @Override
        public int readInt(String userPrompt) {
            int myInt;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number");
            myInt = inputReader.nextInt();
            return myInt;
        }

        @Override
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

        @Override
        public long readLong(String prompt) {
            long readLong;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number(long)");
            readLong = inputReader.nextLong();

            return readLong;
        }

        @Override
        public long readLong(String prompt, long min, long max) {
            long readLong;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a number(long) between (-100) - 200");
            readLong = inputReader.nextLong();

            return readLong;
        }

        @Override
        public String readString(String prompt) {
            String userSentence;
            Scanner inputReader = new Scanner(System.in);

            System.out.println("Please enter a sentence");
            userSentence = inputReader.nextLine();

            return userSentence;
        }
    }
}
