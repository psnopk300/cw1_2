import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running tests...");
        Result result = JUnitCore.runClasses(NumberGuessingTest.class);

        if (result.wasSuccessful()) {
            System.out.println("✅ All tests passed.");
            System.exit(0);
        } else {
            System.out.println("❌ Test failures:");
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
            System.exit(1);
        }
    }
}
