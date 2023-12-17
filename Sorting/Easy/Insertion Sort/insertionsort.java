/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

Java program to sort a given array in order using Insertion sort algorithm.*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1)

//Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

import java.util.Scanner;
public class insertionsort{
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i]; //key-> temporary variable,stores value of the current element being compared
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
				System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        insertionSort(array);
        printArray(array);
    }
}