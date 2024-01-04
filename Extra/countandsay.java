import java.util.Scanner;

class Solution {
    // Method to generate the Count and Say sequence for a given n
    public String countAndSay(int n) {
        // Base case: If n is 1, return the base sequence "1"
        if (n == 1) {
            return "1";
        }

        // Recursively call countAndSay for (n - 1) to get the previous sequence
        String prev = countAndSay(n - 1);
        StringBuilder result = new StringBuilder(); // StringBuilder to store the result
        int count = 1; // Initialize count of consecutive digits

        // Loop through the previous sequence to generate the current sequence
        for (int i = 1; i < prev.length(); i++) {
            // Compare current digit with the previous one
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++; // If the current digit is the same as the previous one, increase the count
            } else {
                // If it's different, append the count and the digit to the result, then reset the count
                result.append(count).append(prev.charAt(i - 1));
                count = 1; // Reset count for the new digit
            }
        }

        // Add the count and the last digit after the loop ends
        result.append(count).append(prev.charAt(prev.length() - 1));

        return result.toString(); // Return the generated sequence
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value for n: ");
        int n = scanner.nextInt();

        // Generate the Count and Say sequence for input n and print the result
        String output = solution.countAndSay(n);
        System.out.println("Result: " + output);

        scanner.close();
    }
}
