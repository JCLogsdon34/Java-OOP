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
        int userRounds;
        String rounds;
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
        //do-loop encompass everything until the end, triggered by boolean.
// Or statement oin out loop to loo again
        do {
            System.out.println("Please enter a number of rounds between one and"
                    + " ten.");
            rounds = inputReader.nextLine();
            userRounds = Integer.parseInt(rounds); 
        } while (((userRounds > 10) && (userRounds < 1)));

        for (int i = userRounds; i > 0; i--) { 
            do {
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
                        if (userChoice > 3) {
                            System.out.println("Improper input! Please enter (1) Rock, (2) Paper, or (3) Scissors.");
                        }
                        break;
                }

                System.out.println("You won " + win + " times, "
                        + "lost " + lose + " and tied " + tie + " time(s)."
                        + " You did all of this in " + i + " rounds of playing.");
                if (win > lose) {
                    System.out.println(" You won more games!");
                    System.out.println("Want to play again? Enter (y) for yes or (n) for no.");
                    playAgain = inputReader.nextLine();
                    if(playAgain.equals("y")){
                       userAnswer = true;
                    }else{
                        userAnswer = false;

                        System.out.println("That was fun, thanks for playing.");
                    } 
                }
                break;
            } while (i > 0);
        }
        if (win < lose) {
            System.out.println(" You lost more games! Bummer!");
        } else if (win == lose) {
            System.out.println(" You won and lost an equal amount of games.");
        }

    }
}
