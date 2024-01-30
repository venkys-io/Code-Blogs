import java.util.Scanner;

public class WildcardMatching {

    public static boolean isMatch(String input, String pattern, int i, int j, int[][] memo) {
        // Base case
        if (i == input.length() && j == pattern.length()) {
            return true;
        }

        // Check if the result for the current state is already memoized
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        // Handle wildcard '*' in the pattern
        if (j < pattern.length() && pattern.charAt(j) == '*') {
            int rememberWildcardPosition = j;
            int rememberInputPosition = i;

            // Try matching '*' with different lengths of characters in the input
            while (i < input.length()) {
                if (isMatch(input, pattern, i, j + 1, memo)) {
                    memo[rememberInputPosition][rememberWildcardPosition] = 1;
                    return true;
                }
                i++;
            }

            // Backtrack if no match is found
            j = rememberWildcardPosition;
            i = rememberInputPosition;
        }

        // Match characters or handle wildcard '*' recursively
        if (i < input.length() && j < pattern.length() && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '*')) {
            boolean result = isMatch(input, pattern, i + 1, j + 1, memo);
            memo[i][j] = result ? 1 : 0;
            return result;
        }

        // No match found for the current state
        memo[i][j] = 0;
        return false;
    }

    public static boolean wildcardMatch(String input, String pattern) {
        int[][] memo = new int[input.length() + 1][pattern.length() + 1];
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= pattern.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return isMatch(input, pattern, 0, 0, memo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        // Perform wildcard matching
        if (wildcardMatch(input, pattern)) {
            System.out.printf("The string \"%s\" matches the pattern \"%s\".%n", input, pattern);
        } else {
            System.out.printf("No match found for the string \"%s\" and pattern \"%s\".%n", input, pattern);
        }
    }
}
