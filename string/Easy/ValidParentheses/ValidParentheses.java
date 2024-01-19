// Copyrights to venkys.io
// For more information, visit https://venkys.io
import java.util.Stack;
import java.util.Scanner;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the string
        System.out.print("Enter a string with parentheses: ");
        String userInput = scanner.nextLine();

        // Call the isValid method with the user input
        boolean result = isValid(userInput);

        // Display the result
        if (result) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to check if parentheses are valid
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an opening parenthesis, push the corresponding closing parenthesis to the stack
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        // If the stack is empty at the end, the parentheses are balanced
        return stack.isEmpty();
    }
}
