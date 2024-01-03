/* Copyrights to venkys.io */
/* For more programs, visit venkys.io */
/* Java program for Shell sort */

// Stable: No
// Inplace: Yes
// Adaptive: Yes

// Space complexity: O(1)

// Time Complexity: O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

import java.util.Scanner; // Importing Scanner class from java.util package for user input

public class ShellSort {
    static int n; // Size of the array
    static int[] arr; // Array of numbers to be sorted

    // Function to perform shell sort
    public static void shellSort() {
        int shellSize = 8; // Initial shell size
        
        // Continue the sorting process until the shell size becomes 0
        while (shellSize >= 1) {
            // Iterate through the array with the current shell size
            for (int i = shellSize, k = 0; i < n && k < shellSize;) {
                int key = arr[i];// Store the current element to be inserted
                int j = i - shellSize; 
                
                // Move elements greater than key to the right until a smaller or equal element is found,
                // or until the beginning of the subarray is reached.
                for (; j >= 0; j -= shellSize) {
                    if (arr[j] > key) {
                        arr[j + shellSize] = arr[j];// Shift the current element to the right
                    } else {
                        break; // Stop shifting if a smaller or equal element is found
                    }
                }
                arr[j + shellSize] = key;// Insert the stored element at its correct position
                
                // Move to the next position in the array considering the shell size
                if (i + shellSize >= n) {
                    k += 1;
                    i = k + shellSize;
                } else {
                    i += shellSize;
                }
            }
            
            // Reduce the shell size for the next iteration
            shellSize = shellSize / 2;
        }
    }

    // Function to print output
    public static void printOutput() {
        System.out.println("The sorted order is:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Create a Scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);

        try {
            // Input the elements separated by space
            System.out.print("Enter the elements separated by space: ");
            // Read the entire line as input.
            String input = scanner.nextLine();

            // Check for null or empty input
            if (input == null || input.trim().isEmpty()) {
                System.out.println("Error: Empty input. Please enter valid elements.");
                return; // Exit the program to handle the error.
            }

            // Split the input string into an array of string elements based on space.
            String[] elements = input.split(" ");
            n = elements.length;// Set the size of the array based on the number of elements.
            arr = new int[n];// Initialize the array to store the parsed integers.

            // Parse input elements to integers
            for (int i = 0; i < n; i++) {
                try {
                    // Parse each element as an integer and assign it to the array.
                    arr[i] = Integer.parseInt(elements[i]);
                } catch (NumberFormatException e) {
                    // Handle the case where an element is not a valid integer.
                    System.out.println("Error: Invalid input. Please enter valid integers.");
                    return;// Exit the program to handle the error.
                }
            }

            // Call the shellSort function to perform the sorting.
            shellSort();

            // Call the printOutput function to display the sorted array.
            printOutput();
        } finally {
            // Close the scanner to avoid resource leaks
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
