import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class romantoint {

    public static int romanToInt(String s) {
        // Define a map mapping Roman numerals to their integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0; // Initialize the result variable to store the total integer value

        // Loop through the Roman numeral string from left to right
        for (int i = 0; i < s.length(); i++) {
            // If the current numeral is smaller than the next numeral, subtract its value
            if (i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                result -= romanMap.get(s.charAt(i));
            } else {
                result += romanMap.get(s.charAt(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try (// Test the function
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a Roman numeral: ");
            String romanNumeral = scanner.nextLine();

            int integerValue = romanToInt(romanNumeral.toUpperCase());
            System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);
        }
    }
}
