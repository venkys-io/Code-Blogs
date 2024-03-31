// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for Palindrom

// time complexity:O(n)
// space complexity:O(1)

import java.util.Scanner;

public class Main {
    // Function to compute reverse of given string and return boolean value by matching it against the original string
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "");
        // Declare an empty string to store the reversed version
        String rev = "";
        // Loop to iterate through the characters of the string in reverse order
        for (int i = cleanedString.length() - 1; i >= 0; i--) {
            // Concatenate each character to the reversed string
            rev += cleanedString.charAt(i);
        }
        // Check if the reversed string is equal to the original string
        return rev.equals(cleanedString);
    }

    public static void main(String args[]) {
        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter a string: ");
        // Read user input
        String s = scanner.nextLine();

        // Calling the palindrome-checking method and storing the result in a boolean variable
        boolean isPal = isPalindrome(s);

        if (isPal) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Close the scanner
        scanner.close();
    }
}
