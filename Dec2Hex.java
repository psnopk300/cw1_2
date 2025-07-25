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

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Error: No input provided. Please provide an integer.");
            return;
        }

        try {
            int num = Integer.parseInt(args[0]);
            System.out.println("Converting the Decimal Value " + num + " to Hex...");
            Dec2Hex converter = new Dec2Hex();
            String result = converter.convert(num);
            System.out.println("Hexadecimal representation is: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. '" + args[0] + "' is not a valid integer.");
        }
    }
}

