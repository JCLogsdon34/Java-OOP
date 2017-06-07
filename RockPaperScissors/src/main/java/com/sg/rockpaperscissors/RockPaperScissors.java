/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    
    public void getRockPaperScissors(){
        int userRounds = 0;
        String rounds = null;
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        int userChoice;
        String stringChoice;
        int computerChoice;
        int win = 0;
        int tie = 0;
        int lose = 0;
        String playAgain;
        boolean userAnswer = false;

        Scanner inputReader = new Scanner(System.in);
        Random compSelection = new Random();

        do {
            while (userRounds < 1 || userRounds > 10) {
                System.out.println("Please enter a number of rounds between one and"
                        + " ten.");
                rounds = inputReader.nextLine();
                userRounds = Integer.parseInt(rounds);
            }
            for (int i = userRounds; i > 0; i--) {
                System.out.println("Please enter a number to choose either "
                        + "rock (1), paper(2), or scissors(3)");
                stringChoice = inputReader.nextLine();
                userChoice = Integer.parseInt(stringChoice);
                computerChoice = compSelection.nextInt(3) + 1;

                switch (userChoice) {
                    case 1:
                        if (computerChoice == scissors) {
                            win++;
                            System.out.println("You win! Rock beats scissors");
                        } else if (computerChoice == paper) {
                            lose++;
                            System.out.println("You lose! Paper beats rock :( ");
                        } else if (computerChoice == rock) {
                            tie++;
                            System.out.println("Tie! You both chose rock");
                        }
                        break;
                    case 2:
                        if (computerChoice == rock) {
                            win++;
                            System.out.println("You win! Paper beats rock");
                        } else if (computerChoice == scissors) {
                            lose++;
                            System.out.println("You lose! Scissors beats paper! :( ");
                        } else if (computerChoice == paper) {
                            tie++;
                            System.out.println("Tie! You both chose paper");
                        }
                        break;
                    case 3:
                        if (computerChoice == paper) {
                            win++;
                            System.out.println("You win! Scisors beats paper");
                        } else if (computerChoice == rock) {
                            lose++;
                            System.out.println("You lose! Rock beats scissors :( ");
                        } else if (computerChoice == scissors) {
                            tie++;
                            System.out.println("Tie! You both chose scissors");
                        }
                        break;
                    default:
                        System.out.println("Improper input! Please enter (1) Rock, (2) Paper, or (3) Scissors.");
                        break;
                }
            }
            if (win > lose) {
                System.out.println(" You won more games!");
                System.out.println("Want to play again? Enter (y) for yes or (n) for no.");
                playAgain = inputReader.nextLine();

                if (playAgain.equals("n")) {
                    userAnswer = true;
                } else if (playAgain.equals("y")) {
                    userAnswer = false;
                    win = 0;
                    lose = 0;
                    tie = 0;
                }
            }
            if (lose > tie) {
                System.out.println(" You lost more games! Bummer!");
                userAnswer = true;
            } else if (tie > lose) {
                System.out.println(" You won and lost an equal amount of games.");
                userAnswer = true;
            }
        } while (userAnswer == false);
        System.out.println("You won " + win + " times, "
                + "lost " + lose + " and tied " + tie + " time(s)."
                + " You did all of this in " + rounds + " rounds of playing.");
        System.out.println("That was fun, thanks for playing.");
    }
}
