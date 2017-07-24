package com.sg.dvdlibrary.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        double readDouble;
        Scanner inputReader = new Scanner(System.in);
        readDouble = inputReader.nextDouble();
        return readDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double readDouble;
        Scanner inputReader = new Scanner(System.in);
        boolean keepGoing = false;
        do {
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
        Scanner inputReader = new Scanner(System.in);

        myInt = inputReader.nextInt();
        return myInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner inputReader = new Scanner(System.in);
        boolean keepGoing = false;
        int myInt;

        do {
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
        Scanner inputReader = new Scanner(System.in);
        readLong = inputReader.nextLong();
        return readLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long readLong;
        Scanner inputReader = new Scanner(System.in);
        boolean keepGoing = false;
        do {
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
        Scanner inputReader = new Scanner(System.in);
        prompt = inputReader.nextLine();
        return prompt;
    }
}
