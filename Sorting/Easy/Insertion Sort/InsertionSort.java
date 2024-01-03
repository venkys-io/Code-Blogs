/* Copyrights to venkys.io
For more information, visit https://venkys.io */
//Java program to sort a given array in order using Insertion sort algorithm.*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1)

//Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

import java.util.InputMismatchException; // Importing InputMismatchException class for handling input errors
import java.util.Scanner; // Importing scanner class from java.util package for user input

public class InsertionSort {

    // Function to perform Insertion Sort on the given array
    public static void insertionSort(int[] array) {
        int n = array.length;
        // Traverse through each element of the array
        for (int i = 1; i < n; ++i) {
            int key = array[i];// Store the current element to be inserted
            int j = i - 1;
            // Move elements greater than key to the right until a smaller or equal element is found,
            // or until the beginning of the array is reached.
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // Shift the current element to the right, creating space for key.
                j = j - 1;// Move to the previous position in the array to compare and potentially shift again.
            }
            array[j + 1] = key; // Insert the stored element at its correct position
    }
        }
    

    // Function to print the elements of the array
    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input the size of the array
            Integer n = null;
            // Keep prompting the user until a valid positive integer is entered for the array size
            while (n == null || n <= 0) {
                System.out.print("Enter the size of the array: ");
                try {
                    // Attempt to read an integer from the user input
                    n = scanner.nextInt();
                    // Check if the entered size is not positive
                    if (n <= 0) {
                        System.out.println("Invalid size. Please enter a positive integer.");
                    }
                } catch (InputMismatchException e) {
                    // Handle the case where a non-integer value is entered
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); // Clear the buffer to prevent an infinite loop
                }
            }
            // Create an array to store the elements of the array.
            int[] array = new int[n];

            // Prompt the user to enter the elements of the array.
            System.out.println("Enter the elements of the array:");
            // Iterate through each element of the array and input values from the user.
            for (int i = 0; i < n; i++) {
                // Use a loop to handle invalid input until a valid integer is entered.
                while (true) {
                    if (scanner.hasNextInt()) {
                        // If the entered value is an integer, assign it to the array.
                        array[i] = scanner.nextInt();
                        break; // Exit the loop as a valid integer is obtained.
                    } else {
                        // Display an error message for invalid input and clear the buffer.
                        System.out.println("Invalid input. Please enter valid integers.");
                        scanner.nextLine(); // Clear the buffer to avoid an infinite loop.
                    }
                }
            }

            // Perform Insertion Sort
            insertionSort(array);

            // Print the sorted array
            System.out.println("Sorted Array:");
            printArray(array);
        } finally {
            // Close the scanner to avoid resource leak
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
