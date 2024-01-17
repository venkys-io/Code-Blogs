import java.util.Scanner;

public class shufflestring {

    // Function to shuffle the characters of a string based on provided indices
    public static String shuffleString(String str, int[] indices) {
        int n = str.length();
        char[] result = new char[n];

        // Iterate through the indices and assign characters from the input string to
        // the corresponding positions
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str.charAt(index);
        }

        // Convert the character array back to a string and return the result
        return new String(result);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Custom Example
            System.out.print("Enter the string: ");
            String customString = scanner.nextLine();

            System.out.print("Enter the indices separated by space: ");
            String[] indicesInput = scanner.nextLine().split(" ");
            int[] customIndices = new int[indicesInput.length];

            // Convert the array of strings to an array of integers
            for (int i = 0; i < indicesInput.length; i++) {
                customIndices[i] = Integer.parseInt(indicesInput[i]);
            }

            System.out.print("Enter the expected output: ");
            String expectedOutput = scanner.nextLine();

            // Call the shuffleString function with the custom string and indices
            String customOutput = shuffleString(customString, customIndices);
            System.out.println("Custom Example Result: " + customOutput);

            // Check if the custom output matches the expected output and provide feedback
            if (customOutput.equals(expectedOutput)) {
                System.out.println("Test case passed.");
            } else {
                System.out.println("Test case failed.");
            }
        } catch (NumberFormatException e) {
            // Handle NumberFormatException if the user enters non-integer values for
            // indices
            e.printStackTrace();
        }
    }
}

// Enter the string: hello
// Enter the indices separated by space: 4 1 3 2 0
// Enter the expected output: oellh
// Custom Example Result: oellh
// Test case passed.