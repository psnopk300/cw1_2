// NumberGuessing.java
import java.util.Scanner;
import java.util.logging.Logger;

public class NumberGuessing {

    private int number;
    private int maxAttempts;

    public NumberGuessing(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        // random number between 1 and 100
        this.number = 1 + (int)(100 * Math.random());
    }

    // For testing, allow injecting number:
    public NumberGuessing(int maxAttempts, int number) {
        this.maxAttempts = maxAttempts;
        this.number = number;
    }

    // Game method which reads from scanner and returns number of attempts used
    public int play(Scanner sc) {
    logger.info("A number is chosen between 1 and 100.");
    System.out.println("You have " + maxAttempts + " attempts to guess the correct number.");

    int attemptsUsed = 0;

    while (attemptsUsed < maxAttempts) {
        System.out.print("Enter your guess: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            sc.next();  // consume invalid input
            continue;   // don't increase attemptsUsed
        }

        int guess = sc.nextInt();
        attemptsUsed++;

        if (guess == number) {
            System.out.println("Congratulations! You guessed the correct number.");
            return attemptsUsed;
        } else if (guess < number) {
            System.out.println("The number is greater than " + guess);
        } else {
            System.out.println("The number is less than " + guess);
        }
    }

    System.out.println("You've exhausted all attempts. The correct number was: " + number);
    return attemptsUsed;
}

    // main method to run game normally
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberGuessing game = new NumberGuessing(5);
        game.play(sc);
        sc.close();
    }
}

