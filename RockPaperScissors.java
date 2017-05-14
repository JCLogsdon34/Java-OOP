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
        int userRounds;
        int newUserRounds = 0;
        int userChoice;
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int computerChoice;
        int win = 0;
        int tie = 0;
        int lose = 0;
        int playAgain;

        Scanner inputReader = new Scanner(System.in);
        Random compSelection = new Random();

        do {
            System.out.println("Please enter a number of rounds between one and"
                    + " ten.");
            userRounds = inputReader.nextInt();
            do {
                userRounds--;

                System.out.println("Please enter a number to choose either "
                        + "rock (0), paper(1), or scissors(2)");
                userChoice = inputReader.nextInt();
                computerChoice = compSelection.nextInt(2) + 0;
            } while (userRounds > 0);
            switch (userChoice) {
                case 0:
                    if (computerChoice == 0) {
                        do {
                            win++;
                            System.out.println("You win! Rock beats scissors");
                            System.out.println("That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 0);
                    } else if (computerChoice == 1) {
                        do {
                            lose++;
                            System.out.println("You lose! Paper beats rock :( ");
                            System.out.println("That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 0);
                        break;
                    } else {
                        tie++;
                        System.out.println("Tie! You both chose rock");
                    }
                    break;
                case 1:
                    if (computerChoice == 2) {
                        do {
                            win++;
                            System.out.println("You win! Scissors beats paper");
                            System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 2);
                    } else if (computerChoice == 1) {
                        do {
                            lose++;
                            System.out.println("You lose! Rock beats scissors :( ");
                            System.out.println("Tough luck! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 1);
                    } else if (userChoice == 2) {
                        tie++;
                        System.out.println("Tie! You both chose scissors");
                    }
                    break;
                case 2:
                    if (computerChoice == 1) {
                        do {
                            win++;
                            System.out.println("You win! Paper beats rock");
                            System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 1);
                    } else if (computerChoice == 2) {
                        do {
                            lose++;
                            System.out.println("You lose! Scissors beats paper! :( ");
                            System.out.println("Tough luck!That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                    + rounds + " rounds of playing.");
                            break;
                        } while (computerChoice == 3);
                    } else {
                        tie++;
                        System.out.println("Tie! You both chose paper");
                    }
                    break;
            }
            do {
                rounds = win + lose + tie;
                if (win > lose) {
                    do {
                        System.out.println(" You won more games!");
                        System.out.println("You won " + win + " times, "
                                + "lost " + lose + "and tied " + tie + " time(s)."
                                + " You did all of this in " + rounds + " rounds of playing.");
                        System.out.println("Want to play again? (1 for yes and 0 for no)");
                        playAgain = inputReader.nextInt();
                        if (playAgain == 1) {
                            do {
                                userRounds += newUserRounds;
                                System.out.print("How may rounds do you want to play?");
                                newUserRounds = inputReader.nextInt();
                                userRounds += newUserRounds;
                                break;
                            } while (playAgain >= 1);
                        } else {
                            System.out.println("That was fun, thanks for playing.");
                        }
                        break;
                    } while (userRounds <= 0);
                } else if (win < lose) {
                    System.out.println(" You lost more games! Bummer!");
                    System.out.println("You lost " + lose + " times, "
                            + "won " + win + "and tied " + tie + " ."
                            + " You did all of this in " + rounds + " rounds of playing.");
                } else {
                    System.out.println(" You won and lost an equal amount of games.");
                    System.out.println("You won " + win + " times, "
                            + "lost " + lose + "and tied " + tie + " times(s)."
                            + " You did all of this in " + rounds + " rounds of playing.");
                }
                break;
            } while (userRounds <= 0);
            break;
        } while (((userRounds > 10) || (userRounds < 1)));
    }
}
