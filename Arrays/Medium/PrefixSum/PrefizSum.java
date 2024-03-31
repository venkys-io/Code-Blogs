// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for PrefixSum

import java.util.Scanner;

public class PrefixSum {
    // Step 1: Define a class named PrefixSum

    // Step 2: Define a method named prefixSum that takes an integer array as a parameter
    public static void prefixSum(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // Step 3: Iterate through the array starting from index 1
            arr[i] += arr[i - 1];
            // Step 4: Update each element in the array to be the sum of its current value and the previous element
        }
        for (int num : arr) {
            // Step 5: Iterate through the updated array
            System.out.print(num + " ");
            // Step 6: Print each element followed by a space
        }
        System.out.println();
        // Step 7: Print a new line after printing all elements
    }

    // Step 8: Define the main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the number of elements for the array: ");
        int numElements = scanner.nextInt();

        int[] arr = new int[numElements];
        // Step 9: Create an integer array named arr with user-input values
        // System.out.print("Enter the elements of the array separated by space: ");
        for (int i = 0; i < numElements; i++) {
            arr[i] = scanner.nextInt();
        }

        prefixSum(arr);
        // Step 10: Call the prefixSum method with the array arr as an argument
    }
}
