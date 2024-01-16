import java.util.Scanner;

public class KMPAlgorithm {

    // Function to compute the prefix function (π) for the pattern 'p'
    public static int[] computePrefixFunction(String p) {
        int m = p.length();
        int[] π = new int[m];   // Initialize an array to store the prefix function values
        int k = 0;              // Initialize a variable for matching characters

        // Iterate through the pattern to compute the prefix function
        for (int q = 1; q < m; ++q) {
            // Update the matching character index while it's not zero and characters mismatch
            while (k > 0 && p.charAt(k) != p.charAt(q)) {
                k = π[k - 1];
            }
            // If characters match, increment the matching character index
            if (p.charAt(k) == p.charAt(q)) {
                k += 1;
            }
            // Store the current matching character index in the prefix function array
            π[q] = k;
        }

        return π;
    }

    // Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
    public static void kmpMatcher(String t, String p) {
        int n = t.length();      // Length of the text
        int m = p.length();      // Length of the pattern
        int[] π = computePrefixFunction(p);  // Compute the prefix function for the pattern
        int q = 0;               // Initialize a variable for matching characters

        // Iterate through the text to find occurrences of the pattern
        for (int i = 0; i < n; ++i) {
            // Update the matching character index while it's not zero and characters mismatch
            while (q > 0 && p.charAt(q) != t.charAt(i)) {
                q = π[q - 1];
            }
            // If characters match, increment the matching character index
            if (p.charAt(q) == t.charAt(i)) {
                q += 1;
            }
            // If the entire pattern is matched, print the occurrence
            if (q == m) {
                System.out.println("Pattern occurs with shift " + (i - m + 1));
                q = π[q - 1];  // Look for the next match
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input with null safety
            System.out.print("Enter the text: ");
            String text = scanner.nextLine();
            System.out.print("Enter the pattern: ");
            String pattern = scanner.nextLine();

            // Check if input is not empty and contains only alphabetical characters
            if (!text.isEmpty() && !pattern.isEmpty() && Character.isLetter(text.charAt(0))
                    && Character.isLetter(pattern.charAt(0))) {
                kmpMatcher(text, pattern);
            } else {
                System.out.println("Please enter valid alphabetic text and pattern.");
            }
        }
    }
}
