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

        while (((userRounds > 10) || (userRounds < 1))) {
            System.out.println("Please enter a number of rounds between one and"
                    + " ten.");
            userRounds = inputReader.nextInt();

            while (userRounds > 0) {
                userRounds--;
                System.out.println("Please enter a number to choose either "
                        + "rock (1), paper(2), or scissors(3)");
                userChoice = inputReader.nextInt();

                computerChoice = compSelection.nextInt(3) + 1;

                switch (userChoice) {
                    case 0:
                        while (userChoice == rock) {
                            if (computerChoice == scissors) {
                                win++;

                                System.out.println("You win! Rock beats scissors");
                                System.out.println("That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            } else if (computerChoice == paper) {
                                lose++;

                                System.out.println("You lose! Paper beats rock :( ");
                                System.out.println("That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            }
                        }break;
                    case 1:
                        while (userChoice == scissors) {
                            if (computerChoice == paper) {
                                win++;

                                System.out.println("You win! Scissors beats paper");
                                System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");

                            } else if (computerChoice == rock) {
                                lose++;

                                System.out.println("You lose! Rock beats scissors :( ");
                                System.out.println("Tough luck! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            }                           
                        }break;
                    case 2:
                        while (userChoice == paper) {
                            if (computerChoice == rock) {
                                win++;

                                System.out.println("You win! Paper beats rock");
                                System.out.println("Wow! That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                                System.out.println("Lets go again! Please enter a number to choose either "
                                        + "rock (1), paper(2), or scissors(3)");
                            } else if (computerChoice == scissors) {
                                lose++;

                                System.out.println("You lose! Scissors beats paper! :( ");
                                System.out.println("Tough luck!That makes for " + win + " wins," + lose + "loss(es), and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                                System.out.println("Lets go again! Please enter a number to choose either "
                                        + "rock (1), paper(2), or scissors(3)");
                            }
                        }break;
                    case 3:
                        while (userChoice == computerChoice) {
                            if (userChoice == paper) {
                                tie++;
                                System.out.println("Tie! You both chose paper");
                                System.out.println("That makes for " + win + " wins"
                                        + lose + " loss(es) and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            } else if (userChoice == rock) {
                                tie++;
                                System.out.println("Tie! You both chose rock");
                                System.out.println("That makes for " + win + " wins"
                                        + lose + " loss(es) and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            } else if (userChoice == scissors) {
                                tie++;
                                System.out.println("Tie! You both chose paper");
                                System.out.println("That makes for " + win + " wins"
                                        + lose + " loss(es) and " + tie + " ties in "
                                        + rounds + " rounds of playing.");
                            }
                           
                        }break;                   
                }
                while (userRounds == 0) {
                    rounds = win + lose + tie;

                    if (win > lose) {
                        System.out.println(" You won more games!");
                        System.out.println("You won " + win + " times, "
                                + "lost " + lose + "and tied " + tie + " time(s)."
                                + " You did all of this in " + rounds + " rounds of playing.");
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
                    System.out.println("Want to play again? (1 for yes and 2 for no)");
                    playAgain = inputReader.nextInt();
                    switch (playAgain) {
                        case 1:
                            if (playAgain == 1) {
                                do {
                                    userRounds += newUserRounds;
                                    System.out.print("How may rounds do you want to play?");
                                    newUserRounds = inputReader.nextInt();
                                    userRounds += newUserRounds;
                                    break;
                                } while (userRounds <= 0);
                            }break;
                        case 2:
                            if (playAgain == 2) {
                                System.out.println("That was fun, thanks for playing.");
                            }break;
                        case 3:
                            if ((playAgain != 1) || (playAgain != 2)) {
                                System.out.println("Please enter either 1 for yes and 2 for no");
                            }break;
                    }
                }
                break;
            }
        }
    }
}
