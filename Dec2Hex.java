public class Dec2Hex {

    public String convert(int number) {
        char[] ch = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String hexadecimal = "";

        if (number == 0) {
            return "0";
        }

        while (number != 0) {
            int rem = number % 16;
            hexadecimal = ch[rem] + hexadecimal;
            number = number / 16;
        }

        return hexadecimal;
    }

    // ✅ New testable method
    public String validateAndConvert(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Error: No input provided. Please provide an integer.";
        }

        try {
            int number = Integer.parseInt(input.trim());
            return convert(number);
        } catch (NumberFormatException e) {
            return "Error: Invalid input. '" + input + "' is not a valid integer.";
        }
    }

    public static void main(String[] args) {
        Dec2Hex converter = new Dec2Hex();

        if (args.length == 0) {
            System.err.println("Error: No input provided. Please provide an integer.");
            return;
        }

        String result = converter.validateAndConvert(args[0]);

        if (result.startsWith("Error:")) {
            System.err.println(result);
        } else {
            System.out.println("Converting the Decimal Value " + args[0] + " to Hex...");
            System.out.println("Hexadecimal representation is: " + result);
        }
    }
}

