/* Copyrights to venkys.io */
/* For more programs, visit venkys.io */
/* Java program for Radix sort */

// Stable: Yes
// Inplace: No
// Adaptive: No

// Space complexity: O(n) where n = number of elements in the input array

// Time Complexity: O(d*(n+k)) / O(n+k) in simplified version
// n=no. of elements
// k= range of input values
// d= no. of digits in maximum value

import java.util.InputMismatchException;// Importing InputMismatchException class for handling input errors
import java.util.Scanner; // Importing Scanner class from java.util package for user input

public class RadixSort {

    static int output[]; // Sorted output array

    // Function to sort radixes
    public static void VSDRadix(int n, int[] a, int digits) {
        int k = 0;// Initialize the digit position to the least significant digit
        int temp[] = new int[n]; // Temporary array to hold radixes
        while (k < digits) { // Loop until all digits are processed
            for (int i = 0; i < n; i++) {
                if (k > 0)
                    // Extract the k-th digit using modulo and division
                    temp[i] = (int) ((a[i] / Math.pow(10, k)) % 10);
                else
                    // For the least significant digit, use modulo only
                    temp[i] = a[i] % 10;
            }
            // Perform counting sort based on the current digit
            VSDcountingsort(n, a, temp);
            k++; // Move to the next digit
        }
    }

    // Function to perform counting sort on radixes
    public static void VSDcountingsort(int n, int[] a, int temp[]) {
        int[] count = new int[10];// Create an array to store the count of occurrences of each radix.
        output = new int[n];// Create an array to store the sorted output.

        // Initializing all the elements of counting array to zero
        for (int i = 0; i < count.length; i++)
            count[i] = 0;

        // Storing the count of occurrences of each element from the input array to count array
        for (int i = 0; i < n; i++) {
            count[temp[i]]++;
        }

        // Computing cumulative sum from count array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Sorting radixes. Traverse the input array backward. 
        //For each element, use the count array to determine its position in the sorted output array.
        for (int i = n - 1; i >= 0; i--) {
            output[count[temp[i]] - 1] = a[i];
            count[temp[i]]--;//Decrease the count of that radix in the count array.
        }

        // Copy the sorted output array back to the original array.
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    // Function to count maximum number of digits
    public static int VSDdigitcount(int max) {
        int d = 0;// Initialize the digit count to 0
        while (max > 0) {
            d++; // Increment the digit count for each digit
            max = max / 10; // Remove the last digit by dividing the number by 10
        }
        return d; // Return the final count of digits
    }

    // Function to get maximum element in the array
    public static int VSDMax(int n, int[] a) {
        int max = 0;
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the current max
            if (a[i] > max) {
                // If yes, update max to the current element
                max = a[i];
            }
        }
        // Return the maximum element found in the array
        return max;
    }

    // Function to print the output
    public static void VSDprintOutput(int n, int[] a) {
        System.out.println("The sorted array is:");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        // Create a Scanner object to read user input from the console.
        Scanner scanner = new Scanner(System.in);
        try {
            // Prompt the user to enter the size of the array.
            System.out.print("Enter the size of the array: ");
            // Initialize n to null to validate user input.
            Integer n = null;
             // Continue prompting the user until a valid positive integer is entered for the array size.
            while (n == null || n <= 0) {
                try {
                    // Attempt to read an integer from the user input.
                    n = scanner.nextInt();
                    // Check if the entered size is not positive.
                    if (n <= 0) {
                        System.out.println("Invalid size. Please enter a positive integer.");
                    }
                } catch (InputMismatchException e) {
                    // Handle the case where a non-integer value is entered.
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();// Clear the buffer to prevent an infinite loop.
                }
            }

            // Create an array to store the elements of the array.
            int[] a = new int[n];
            
            // Prompt the user to enter the elements of the array.
            System.out.println("Enter the elements of the array:");
            // Iterate through each element of the array and input values from the user.
            for (int i = 0; i < n; i++) {
                // Use a loop to handle invalid input until a valid integer is entered.
                while (true) {
                    if (scanner.hasNextInt()) {
                        // If the entered value is an integer, assign it to the array.
                        a[i] = scanner.nextInt();
                        break; // Exit the loop as a valid integer is obtained.
                    } else {
                        // Display an error message for invalid input and clear the buffer.
                        System.out.println("Invalid input. Please enter valid integers.");
                        scanner.nextLine();// Clear the buffer to avoid an infinite loop.
                    }
                }
            }
            // Find the maximum element in the array
            int max = VSDMax(n, a);
            
            // Count the number of digits in the maximum element.
            int d = VSDdigitcount(max);
            
            // Perform Radix Sort on the array.
            VSDRadix(n, a, d);
            
            // Print the sorted array.
            VSDprintOutput(n, a);
        } finally {
            // Close the scanner to avoid resource leaks.
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
