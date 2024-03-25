import java.util.Scanner;

public class BasicCalculator {

    // Function to add two numbers
    public static double add(double x, double y) {
        return x + y;
    }

    // Function to subtract two numbers
    public static double subtract(double x, double y) {
        return x - y;
    }

    // Function to multiply two numbers
    public static double multiply(double x, double y) {
        return x * y;
    }

    // Function to divide two numbers
    public static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Error: Cannot divide by zero!");
            return 0;  // You can customize the return value for division by zero
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for the operator
        // System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Step 2: Prompt the user for the first number
        // System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Step 3: Prompt the user for the second number
        // System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;

        // Step 4: Perform the selected operation using a switch statement
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                // Step 5: Handle invalid operator
                System.out.println("Error: Invalid operator");
                return;  // Exit program
        }

        // Step 6: Display the result
        System.out.println(result);

        // Step 7: Close the scanner
        scanner.close();
    }
}
