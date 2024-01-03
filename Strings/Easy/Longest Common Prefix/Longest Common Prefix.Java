import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(strings);

        // Compare the first and last strings in the sorted array
        String firstString = strings[0];
        String lastString = strings[strings.length - 1];

        StringBuilder prefix = new StringBuilder();
        int minLength = Math.min(firstString.length(), lastString.length());

        for (int i = 0; i < minLength; i++) {
            if (firstString.charAt(i) == lastString.charAt(i)) {
                prefix.append(firstString.charAt(i));
            } else {
                break;
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] inputStrings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            inputStrings[i] = scanner.nextLine();
        }

        String result = longestCommonPrefix(inputStrings);

        if (!result.isEmpty()) {
            System.out.println("Longest common prefix: " + result);
        } else {
            System.out.println("No common prefix.");
        }
    }
}
