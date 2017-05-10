/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        int rounds = 0;
        int userRounds = 0;
        int choice;
        int rock = 1;      //make this a switch statement
        int paper = 2;
        int scissors = 3;
        int computer;
        int win = 0;
        int tie = 0;
        int lose = 0;

        String again;
        Scanner inputReader = new Scanner(System.in);
        Random compChoice = new Random();

        while (((userRounds > 10) || (userRounds < 1))) {
            System.out.println("Please enter a number of rounds between one and"
                    + "ten.");

            userRounds = inputReader.nextInt();
        }
        for (int i = 0; i < userRounds; i++) {
            rounds++;
            System.out.println("Please enter a number to choose either "
                    + "rock (1), paper(2), or scissors(3)");
            choice = inputReader.nextInt();

            computer = compChoice.nextInt(3) + 1;

            if (choice == rock) {
                if (computer == scissors) {
                    win++;

                    System.out.println("You win! Rock beats scissors");
                    System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                            + rounds + " rounds of playing.");
                } else if (computer == paper) {
                    lose++;

                    System.out.println("You lose! Paper beats rock :( ");
                    System.out.println("Tough luck! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                            + rounds + " rounds of playing.");

                } else if (choice == scissors) {
                    if (computer == paper) {
                        win++;

                        System.out.println("You win! Scissors beats paper");
                        System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                + rounds + " rounds of playing.");

                    } else if (computer == rock) {
                        lose++;

                        System.out.println("You lose! Rock beats scissors :( ");
                        System.out.println("Tough luck! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                + rounds + " rounds of playing.");

                    }
                } else if (choice == paper) {
                    if (computer == rock) {
                        win++;

                        System.out.println("You win! Paper beats rock");
                        System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                + rounds + " rounds of playing.");
                        System.out.println("Lets go again! Please enter a number to choose either "
                                + "rock (1), paper(2), or scissors(3)");
                    } else if (computer == scissors) {
                        lose++;

                        System.out.println("You lose! Scissors beats paper! :( ");
                        System.out.println("Tough luck!That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                + rounds + " rounds of playing.");
                        System.out.println("Lets go again! Please enter a number to choose either "
                                + "rock (1), paper(2), or scissors(3)");
                    }

                }
                if (choice == computer) {
                    if (choice == paper) {
                        tie++;
                        System.out.println("Tie! You both chose paper");
                        System.out.println("That makes for " + win + " wins"
                                + lose + " loss(es) and " + tie + " ties in "
                                + rounds + " rounds of playing.");
                    } else if (choice == rock) {
                        tie++;
                        System.out.println("Tie! You both chose rock");
                        System.out.println("That makes for " + win + " wins"
                                + lose + " loss(es) and " + tie + " ties in "
                                + rounds + " rounds of playing.");
                    } else if (choice == scissors) {
                        tie++;
                        System.out.println("Tie! You both chose paper");
                        System.out.println("That makes for " + win + " wins"
                                + lose + " loss(es) and " + tie + " ties in "
                                + rounds + " rounds of playing.");

                    }
                }
            }
            while (userRounds == 0) {
                if (win > lose) {
                    System.out.println(" You won more games!");
                    System.out.println("You won " + win + " times, "
                            + "lost " + lose + "and tied " + tie + " ."
                            + " You did all of this in " + rounds + " rounds of playing.");
                } else if (win < lose) {
                    System.out.println(" You lost more games! Bummer!");
                    System.out.println("You lost " + lose + " times, "
                            + "won " + win + "and tied " + tie + " ."
                            + " You did all of this in " + rounds + " rounds of playing.");
                } else if (win == lose) {
                    System.out.println(" You won and lost an equal amoutn of games.");
                    System.out.println("You won " + win + " times, "
                            + "lost " + lose + "and tied " + tie + " ."
                            + " You did all of this in " + rounds + " rounds of playing.");
                }

            }
            do {
                System.out.println("Want to play again?");
                again = inputReader.nextLine();
                if (again.equals("yes")) {
                    System.out.print("How may rounds do you want to play");
                    userRounds = inputReader.nextInt();
                } else if (again.equals("no")) {
                    System.out.println("That was fun, thanks for playing.");

                }
            } while (userRounds == 0);
        }
    }
}
