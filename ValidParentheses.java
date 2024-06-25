// Copyrights to venkys.io
// For more information, visit https://venkys.io
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input from the user
        String inputString = scanner.nextLine();

        // Check if the input string is valid using the isValid function
        boolean isValid = isValid(inputString);

        // Display the result
        if (isValid)
            System.out.println("True");
        else
            System.out.println("False");

        scanner.close();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
