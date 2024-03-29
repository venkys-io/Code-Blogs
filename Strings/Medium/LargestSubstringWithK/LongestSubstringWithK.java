import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithK {

    public static int longestSubstring(String s, int k) {
        // Check if the input string is null or empty
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Counter to track the frequency of characters in the input string
        HashMap<Character, Integer> counter = new HashMap<>();

        // Find the maximum number of distinct characters in the string
        int maxDistinctChars = countDistinctChars(s);

        // Length of the input string
        int n = s.length();

        // Variable to store the final result
        int ans = 0;

        // Iterate over the possible number of distinct characters (num)
        for (int num = 1; num <= maxDistinctChars; num++) {
            // Counter for characters within the current window
            HashMap<Character, Integer> charCount = new HashMap<>();

            // Left pointer for window contraction
            int left = 0;

            // Iterate over the string with the right pointer
            for (int right = 0; right < n; right++) {
                char currentChar = s.charAt(right);

                // Update the count of the current character in the window
                charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

                // Shrink the window if the number of distinct characters exceeds 'num'
                while (charCount.size() > num) {
                    char leftChar = s.charAt(left);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);

                    // Remove the character if its count becomes 0
                    if (charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }

                    // Move the left pointer to shrink the window
                    left++;
                }

                // Update result if all character counts are at least 'k'
                boolean allCountsAtLeastK = charCount.values().stream().allMatch(count -> count >= k);
                if (allCountsAtLeastK) {
                    // Update the length of the longest substring if needed
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }
        // Return the final result
        return ans;
    }

    // Helper function to count the number of distinct characters in the string
    private static int countDistinctChars(String s) {
        // Counter to track the frequency of characters
        HashMap<Character, Integer> counter = new HashMap<>();

        // Iterate over the string and count distinct characters
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        // Return the number of distinct characters
        return counter.size();
    }

    // Main method for testing the function
    public static void main(String[] args) {
        // Take input string and k from the user
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = scanner.nextInt();

        // Print the result of the longestSubstring function
        System.out.println(longestSubstring(string, k));
    }
}
