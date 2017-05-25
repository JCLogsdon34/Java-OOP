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
        int rounds;
        int userRounds;
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

        System.out.println("Please enter a number of rounds between one and"
                + " ten.");

        for (userRounds = inputReader.nextInt(); userRounds > 0; userRounds--) {
            if (((userRounds > 10) || (userRounds < 1))) {
                System.out.println("Please enter a number of rounds between one and"
                        + " ten.");
            } else if (((userRounds > 0) || (userRounds < 11))) {
                do {
                    System.out.println("Please enter a number to choose either "
                            + "rock (1), paper(2), or scissors(3)");
                    userChoice = inputReader.nextInt();
                    computerChoice = compSelection.nextInt(3) + 1;

                    switch (userChoice) {
                        case 0:
                            if (userChoice == rock) {
                                if (computerChoice == scissors) {
                                    win++;
                                    System.out.println("You win! Rock beats scissors");
                                } else if (computerChoice == paper) {
                                    lose++;
                                    System.out.println("You lose! Paper beats rock :( ");
                                } else {
                                    tie++;
                                    System.out.println("Tie! You both chose rock");
                                }
                            }
                            break;
                        case 1:
                            if (userChoice == paper) {
                                if (computerChoice == rock) {
                                    win++;
                                    System.out.println("You win! Paper beats rock");
                                } else if (computerChoice == scissors) {
                                    lose++;
                                    System.out.println("You lose! Scissors beats paper! :( ");
                                } else {
                                    tie++;
                                    System.out.println("Tie! You both chose paper");
                                }
                            }
                            break;
                        case 2:
                            if (userChoice == scissors) {
                                if (computerChoice == paper) {
                                    win++;
                                    System.out.println("You win! Scissors beats paper");
                                } else if (computerChoice == rock) {
                                    lose++;
                                    System.out.println("You lose! Rock beats scissors :( ");
                                } else {
                                    tie++;
                                    System.out.println("Tie! You both chose scissors");
                                }
                            }
                            break;
                    }
                    break;
                } while (userRounds > 0);
                
                rounds = win + lose + tie;
                System.out.println("You won " + win + " times, "
                        + "lost " + lose + "and tied " + tie + " time(s)."
                        + " You did all of this in " + rounds + " rounds of playing.");
                if (win > lose) {
                    System.out.println(" You won more games!");
                    System.out.println("Want to play again? Enter 1 for yes or 0 for no.");
                    playAgain = inputReader.nextInt();
                    if (playAgain == 1) {
                        playAgain += userRounds;
                        break;
                    } else if (playAgain != 1) {
                        System.out.println("That was fun, thanks for playing.");
                        break;
                    } else {
                        System.out.println("Please enter 1 for yes or 0 for no.");
                    }
                } else if (win < lose) {
                    System.out.println(" You lost more games! Bummer!");
                } else if (win == lose) {
                    System.out.println(" You won and lost an equal amount of games.");
                }

            }
        }
    }
}
