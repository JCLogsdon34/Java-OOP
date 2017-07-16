
package com.sg.dvdlibrary.ui;

import java.util.Scanner;


public class UserIOConsoleImpl implements UserIO {
    
       
        @Override
        public void print(String msg) {
 
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
            boolean keepGoing = false;

            do {
                System.out.println("Please enter a number between 10 - 20");
                readDouble = inputReader.nextDouble();
                if (readDouble > 20 || readDouble < 10) {
                    keepGoing = false;
                } else {
                    keepGoing = true;

                }
            } while (keepGoing = false);
            return readDouble;
        }

        @Override
        public float readFloat(String prompt) {
            float readFloat;
            Scanner inputReader = new Scanner(System.in);

            readFloat = inputReader.nextFloat();
            return readFloat;
        }

        @Override
        public float readFloat(String prompt, float min, float max) {
            float readFloat;
            Scanner inputReader = new Scanner(System.in);
            boolean keepGoing = false;

            do {
                readFloat = inputReader.nextFloat();
                if (readFloat > 1.618 || readFloat < 3.14) {
                    keepGoing = false;
                } else {
                    keepGoing = true;

                    return readFloat;
                }
            } while (keepGoing = false);
            return readFloat;
        }

        @Override
        public int readInt(String userPrompt) {
            int myInt;
            Scanner inputReader = new Scanner(System.in);

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
            boolean keepGoing = false;
            do {
                System.out.println("Please enter a number(long) between (-100) - 200");
                readLong = inputReader.nextLong();
                if (readLong > 5 || readLong < 1) {
                    keepGoing = false;
                } else {
                    keepGoing = true;
                    
                }
            } while (keepGoing = false);
            
            return readLong;
        }

        @Override
        public String readString(String prompt) {
            String userSentence;
            Scanner inputReader = new Scanner(System.in);

            userSentence = inputReader.nextLine();

            return userSentence;
        }
}
