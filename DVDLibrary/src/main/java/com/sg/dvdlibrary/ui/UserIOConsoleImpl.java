package com.sg.dvdlibrary.ui;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public double readDouble(String prompt) {
        Scanner inputReader = new Scanner(System.in);
        double readDouble;
        System.out.println(prompt);
        readDouble = inputReader.nextDouble();
        return readDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double readDouble;
        Scanner inputReader = new Scanner(System.in);
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
        Scanner inputReader = new Scanner(System.in);
        float readFloat;
        System.out.println(prompt);
        readFloat = inputReader.nextFloat();
        return readFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float readFloat;
        Scanner inputReader = new Scanner(System.in);
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
        int myInt = 0;
        Scanner inputReader = new Scanner(System.in);
        System.out.println(prompt);
        if (inputReader.hasNextLine()) {
            myInt = inputReader.nextInt();
        }
        return myInt;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        Scanner inputReader = new Scanner(System.in);
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
        long userChoices = 0;
        Scanner inputReader = new Scanner(System.in);
        System.out.println(prompt);
        if (inputReader.hasNextLine()) {
            userChoices = inputReader.nextLong();
            inputReader.close();
        }
        readLong = inputReader.nextLong();
        return readLong;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long userChoices = 0;
        long readLong;
        Scanner inputReader = new Scanner(System.in);
        boolean keepGoing = false;
        do {
            System.out.println(prompt);
            if (inputReader.hasNextLine()) {
                userChoices = inputReader.nextLong();
                inputReader.close();
            }
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
        String userChoices;
        System.out.println(prompt);
        userChoices = inputReader.nextLine();
        return userChoices;
    }

    @Override
    public LocalDate readLocalDate(String msg) {
      Scanner inputReader = new Scanner(System.in);
      String userChoices = null;
      System.out.println(msg);
        userChoices = inputReader.next();
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("mm-dd-yyyy");
      LocalDate parsedDate = LocalDate.parse(userChoices, dateFormat);
      
        return parsedDate;
    }
}
