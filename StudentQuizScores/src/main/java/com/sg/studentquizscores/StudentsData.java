/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author apprentice
 */
public class StudentsData {
    public class userMethods implements studentquizscoresUserIO {

        public String print() {
            String message = "Hello and welcome to the interface";
            return message;
        }

        public String getStudents(String nameOfStudent, String examScore) {
            boolean userWork = false;
            String message = null;
            String userResponse;
          
            Scanner inputReader = new Scanner(System.in);

            HashMap<String, ArrayList<String>> quizscores = new HashMap<String, ArrayList<String>>();           

            Set<String> keys = quizscores.keySet();

            do {

                System.out.println("Do you want to add, remove, or view student informtation?");
                userResponse = inputReader.next();
                if (userResponse.equals("add")) {
                    System.out.println("Please enter the first and last name of the student");
                    nameOfStudent = inputReader.nextLine();
                    System.out.println("Please enter that student's exam score");
                    examScore = inputReader.nextLine();

                    // studentscores.add(nameOfStudent);
                    quizscores.put(nameOfStudent, new ArrayList<String>());

                } else if (userResponse.equals("remove")) {
                    System.out.println("Please enter the first and last name of the student");
                    nameOfStudent = inputReader.nextLine();
                    System.out.println("Please enter that student's exam score");
                    examScore = inputReader.nextLine();

                    quizscores.remove(nameOfStudent);
                    quizscores.remove(examScore);
                } else if (userResponse.equals("view")) {
                    System.out.println("Enter a choice of the following"
                            + " all entries or a certain student?");
                    userResponse = inputReader.nextLine();
                    if (userResponse.equals("all entries")) {
                        for (String k : keys) {
                            System.out.println("Student: " + k + "Scores" + quizscores.get(k));
                        }
                    } else if (userResponse.equals("a certain student")) {
                        System.out.println("Please enter the first and last name of the student");
                        nameOfStudent = inputReader.nextLine();
                        
                        quizscores.get(nameOfStudent + ".");    
                            System.out.println("Student: " + nameOfStudent + " " +  quizscores.get(nameOfStudent));
                        
                    }
                }

            } while (userWork = false);
            return message;
        }

        public String getStudentScores(String nameOfStudent, String examScore) {
            String message = null;
            ArrayList<String> studentscores = new ArrayList<>();

            Iterator<String> iter = studentscores.iterator();

            while (iter.hasNext()) {
                String current = iter.next();
                System.out.println(current);

                studentscores.size();
            }
            return nameOfStudent + examScore;
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

    }

}


