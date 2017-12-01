package com.sg.flooringmastery.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.math.RoundingMode.HALF_UP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserIoConsoleImpl implements UserIo {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public LocalDate readLocalDate(String msg) {
        Scanner inputReader = new Scanner(System.in);
        String userChoices = null;
        System.out.println(msg);
        userChoices = inputReader.next();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate parsedDate = LocalDate.parse(userChoices, dateFormat);
        return parsedDate;
    }

    @Override
    public BigDecimal readBigDecimal(String msg) {
        String moneyInput = null;
        BigDecimal moneyInserted = new BigDecimal("0").setScale(2, RoundingMode.HALF_UP);
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Please enter the area you want us to lay flooring for");
        try{
        moneyInput = inputReader.nextLine();
        boolean numberTeller = false;
        do {
            if (moneyInput.matches(".*\\d+.*")) {
                moneyInserted = new BigDecimal(moneyInput).setScale(2, RoundingMode.HALF_UP);
                numberTeller = true;
                return moneyInserted;
            } else {
                numberTeller = false;
            }
        } while (numberTeller == false);
        }catch(InputMismatchException e){
                throw new FlooringInvalidEntryException("Invalid input");
            }
        return moneyInserted;
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
        String number;
        int myInt;
        Scanner inputReader = new Scanner(System.in);
        System.out.println(userPrompt);
        try {
            number = inputReader.nextLine();
            myInt = Integer.parseInt(number);
            return myInt;
        } catch (InputMismatchException e) {
            throw new FlooringInvalidEntryException("Invalid input");
        }
    }

    @Override
    public int readInt(String userPrompt, int min, int max) {
        Scanner inputReader = new Scanner(System.in);
        boolean keepGoing = true;
        String newString = null;
        int myInt = 0;

        System.out.println(userPrompt);
        try {
            newString = inputReader.next();
            myInt = Integer.parseInt(newString);
        } catch (InputMismatchException e) {
            throw new FlooringInvalidEntryException("Invalid input");
        }
        if (myInt > 6 || myInt < 1) {
            keepGoing = true;
        } else {
            keepGoing = false;
            return myInt;
        }

        return myInt;
    }

    @Override
    public long readLong(String prompt) {
        long readLong;
        Scanner inputReader = new Scanner(System.in);
        System.out.println(prompt);
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
        String userSentence = null;
        Scanner inputReader = new Scanner(System.in);
        System.out.println(prompt);
        userSentence = inputReader.nextLine();
        return userSentence;
    }
}
