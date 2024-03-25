//Copyrights to venkys.io
//For more programs visit venkys.io 
//Java program for ValidPalindrome
import java.util.Scanner;
public class Main {

    // Function to check if a given string is a palindrome
    static boolean isPalindrome(String s) {
        String rev = "";

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // Check if the character is a lowercase letter (ASCII values 97 to 122)
            if (ch >= 97 && ch <= 122)
                rev += ch + "";
            // Check if the character is an uppercase letter (ASCII values 65 to 90)
            else if (ch >= 65 && ch <= 90)
                // Convert the uppercase letter to lowercase and add it to the 'rev' string
                rev += (char) (ch + 32) + "";
        }

        // Initialize two pointers for comparing characters from both ends of the 'rev' string
        int i = 0, j = rev.length() - 1;

        // Iterate until the pointers meet in the middle
        while (i < j)
            // Compare characters at the current positions, and move the pointers accordingly
            if (rev.charAt(i++) != rev.charAt(j--))
                return false;

        // If the loop completes without finding any mismatches, the string is a palindrome
        return true;
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input from the user
        String inputString = scanner.nextLine();

        // Close the scanner to prevent resource leaks
        scanner.close();


        // Check if the string is a palindrome using the isPalindrome function
        if (isPalindrome(s))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
}
