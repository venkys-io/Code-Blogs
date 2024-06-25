import java.util.Scanner;

public class Main {

    /**
     * Converts a string to an integer.
     *
     * @param s The input string.
     * @return The converted integer, or Integer.MIN_VALUE/Integer.MAX_VALUE in case of overflow.
     */
    static int atoi(String s) {
        // Check for null or empty string
        if (s == null || s.isEmpty()) {
            System.err.println("Error: Input string is null or empty.");
            return 0;  // You can choose an appropriate value in case of an error.
        }

        int num = 0, i = 0, sign = 1;

        // Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '+') ? 1 : -1;
            i++;
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            // Check for overflow
            if ((num > Integer.MAX_VALUE / 10) || ((num == Integer.MAX_VALUE / 10) && (digit > 7))) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update the result
            num = (num * 10) + digit;
            i++;
        }

        return num * sign;
    }

    public static void main(String[] args) {
        // Prompt the user for input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call the atoi function and print the result
        int result = atoi(input);
        System.out.println("Converted integer: " + result);
    }
}
