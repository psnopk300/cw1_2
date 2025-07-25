package com.example.numberguessing;

import java.util.Scanner;
import java.util.Random;
import java.util.logging.Logger;

public class NumberGuessing {

    private static final Logger logger = Logger.getLogger(NumberGuessing.class.getName());

    private int number;
    private int maxAttempts;

    public NumberGuessing(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        Random rand = new Random();
        this.number = 1 + rand.nextInt(100); // random number between 1 and 100
    }

    // For testing: allow setting the number directly
    public NumberGuessing(int maxAttempts, int number) {
        this.maxAttempts = maxAttempts;
        this.number = number;
    }

    public int play(Scanner sc) {
        logger.info("A number is chosen between 1 and 100.");
        logger.info("You have " + maxAttempts + " attempts to guess the correct number.");

        int attemptsUsed = 0;

        while (attemptsUsed < maxAttempts) {
            logger.info("Enter your guess: ");

            if (!sc.hasNextInt()) {
                logger.warning("Invalid input. Please enter an integer.");
                if (sc.hasNext()) {
                    sc.next();
                } else {
                    logger.warning("No more input. Ending game.");
                    break;
                }
                continue;
            }

            int guess = sc.nextInt();
            attemptsUsed++;

            if (guess == number) {
                logger.info("Congratulations! You guessed the correct number.");
                return attemptsUsed;
            } else if (guess < number) {
                logger.info("The number is greater than " + guess);
            } else {
                logger.info("The number is less than " + guess);
            }
        }

        logger.info("You've exhausted all attempts. The correct number was: " + number);
        return attemptsUsed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberGuessing game = new NumberGuessing(5);
        game.play(sc);
        sc.close();
    }
}

