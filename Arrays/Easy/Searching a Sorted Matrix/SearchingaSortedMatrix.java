// Copyrights to venkys.io
// For more programs visit venkys.io
// Java program for Searching a sorted Matrix

// time complexity:O(m*n)
// space complexity:O(1)

import java.util.*;
public class Main {
    
    // Function to perform binary search on a sorted matrix
    static boolean searchMatrix(int[][] matrix, int target) {
        // Get the number of rows in the matrix
        int rows = matrix.length;
        // Get the number of columns in the matrix
        int cols = matrix[0].length;
        // Calculate the total number of elements in the matrix
        int items = rows * cols;
        // Initialize low and high for binary search
        int low = 0;
        int high = items - 1;

        // Perform binary search on the matrix
        while (low <= high) {
            // Calculate the middle index
            int mid = (low + high) / 2;
            // Calculate the element at the middle index in the matrix
            int temp = matrix[mid / cols][mid % cols];
            
            // Check if the target is equal to the middle element
            if (temp == target) return true;
            // If the target is less than the middle element, update the high index
            else if (target < temp) high = mid - 1;
            // If the target is greater than the middle element, update the low index
            else low = mid + 1;
        }

        // If the target is not found, return false
        return false;
    }

    // Main method
    public static void main(String[] args) {
        // Matrix
        Scanner scanner = new Scanner(System.in);

        // Input the dimensions of the matrix
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Initialize a 2D array to store the matrix
        int[][] matrix = new int[rows][cols];

        // Input each element of the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Target integer
        int target = 3;

        // Check if the target is found in the matrix using the searchMatrix function
        if (searchMatrix(matrix, target)) System.out.println("Found");
        else System.out.println("Not Found");
    }
}
