import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class NumberGuessingTest {

    NumberGuessing game;

    @Before
    public void setUp() {
        // Inject number 42 to guess, max 5 attempts
        game = new NumberGuessing(5, 42);
    }

    @Test
    public void testCorrectGuessOnFirstTry() {
        String input = "42\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int attempts = game.play(sc);
        assertEquals("Should guess correctly in 1 attempt", 1, attempts);
    }

    @Test
    public void testGuessTooLowThenCorrect() {
        String input = "10\n42\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int attempts = game.play(sc);
        assertEquals("Should guess correctly in 2 attempts", 2, attempts);
    }

    @Test
    public void testInvalidInputHandling() {
        String input = "abc\n42\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int attempts = game.play(sc);
        assertEquals("Invalid input should not count, guess success in 2nd valid attempt", 1, attempts);
    }

    @Test
    public void testFailToGuess() {
        // All guesses wrong, max 5 attempts
        String input = "1\n2\n3\n4\n5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        int attempts = game.play(sc);
        assertEquals("Should use all 5 attempts", 5, attempts);
    }
}

