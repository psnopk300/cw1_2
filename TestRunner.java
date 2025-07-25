import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Running tests for Dec2Hex...\n");

        Result result = JUnitCore.runClasses(Dec2HexTest.class);

        if (result.wasSuccessful()) {
            System.out.println("✅ All tests passed.");
            System.out.println("\nSummary:");
            System.out.println("Tests run: " + result.getRunCount());
            System.out.println("Failures : " + result.getFailureCount());
            System.exit(0); // ✅ Success
        } else {
            System.out.println("❌ Some tests failed:");
            for (Failure failure : result.getFailures()) {
                System.out.println("- " + failure.toString());
            }
            System.out.println("\nSummary:");
            System.out.println("Tests run: " + result.getRunCount());
            System.out.println("Failures : " + result.getFailureCount());
            System.exit(1); // ❌ Failure
        }
    }
}




