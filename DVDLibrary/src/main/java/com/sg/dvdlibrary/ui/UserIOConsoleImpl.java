package com.sg.dvdlibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
    Scanner inputReader = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        double readDouble;
        System.out.println(prompt);
        readDouble = inputReader.nextDouble();
        return readDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double readDouble;

        boolean keepGoing = false;
        do {
            System.out.println(prompt);
            readDouble = inputReader.nextDouble();
            if (readDouble > max || readDouble < min) {
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
        System.out.println(prompt);
        readFloat = inputReader.nextFloat();
        return readFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float readFloat;

        boolean keepGoing = false;
        do {
            System.out.println(prompt);
            readFloat = inputReader.nextFloat();
            if (readFloat > max || readFloat < min) {
                keepGoing = false;
            } else {
                keepGoing = true;
            }
        } while (keepGoing = false);
        return readFloat;
    }

    @Override
    public int readInt(String prompt) {
        int myInt;
        
        System.out.println(prompt);
        myInt = inputReader.nextInt();
        return myInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        boolean keepGoing = false;
        int myInt;

        do {
            System.out.println(prompt);
            myInt = inputReader.nextInt();
            if (myInt > max || myInt < min) {
                keepGoing = false;
            } else {
                keepGoing = true;
            }
        } while (keepGoing = false);
        return myInt;
    }

    @Override
    public long readLong(String prompt) {
        long readLong;

        System.out.println(prompt);
        readLong = inputReader.nextLong();
        return readLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long readLong;
        
        boolean keepGoing = false;
        do {
            System.out.println(prompt);
            readLong = inputReader.nextLong();
            if (readLong > max || readLong < min) {
                keepGoing = false;
            } else {
                keepGoing = true;
            }
        } while (keepGoing = false);
        return readLong;
    }

    @Override
    public String readString(String prompt) {
        String userChoices;
        System.out.println(prompt);
        userChoices = inputReader.nextLine();
        return userChoices;
    }
}
