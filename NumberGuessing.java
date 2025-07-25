// NumberGuessing.java
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NumberGuessing {

private static final Logger logger = Logger.getLogger(NumberGuessing.class.getName());

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
    if (logger.isLoggable(Level.INFO)) {
    logger.info("A number is chosen between 1 and 100.");
    logger.info(String.format("You have %d attempts to guess the correct number.", maxAttempts));
    }
    int attemptsUsed = 0;

    while (attemptsUsed < maxAttempts) {
        logger.info("Enter your guess: ");

        if (!sc.hasNextInt()) {
            logger.warning("Invalid input. Please enter an integer.");
            sc.next();  // consume invalid input
            continue;   // don't increase attemptsUsed
        }

        int guess = sc.nextInt();
        attemptsUsed++;

        if (guess == number) {
            logger.info("Congratulations! You guessed the correct number.");
            return attemptsUsed;
        } else if (guess < number) {
            if (logger.isLoggable(Level.INFO)) {
    logger.info(String.format("The number is greater than %d", guess));
}
        } else {
            if (logger.isLoggable(Level.INFO)) {
    logger.info(String.format("The number is less than %d", guess));
}
        }
    }

    if (logger.isLoggable(Level.INFO)) {
    logger.info(String.format("You've exhausted all attempts. The correct number was: %d", number));
}
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

