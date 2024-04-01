// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for ThreeNumberSum

import java.util.Arrays;
import java.util.Scanner;

public class TripletSum {//the function tripletsum is defined.
    public static void findTriplets(int[] nums, int target) {
        // Sort the array for easier triplet identification
        Arrays.sort(nums);

        // Loop through the array to find triplets
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    System.out.println("Triplet found: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {//The **main** method initializes a **Scanner** object to take user input.
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the size of the array: ");
        //The size of the array is given.
        int size = scanner.nextInt();

        int[] nums = new int[size];
        // System.out.println("Enter the elements of the array:");
        //The elements to be entered into array.
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // System.out.print("Enter the target sum: ");
        //The target is to be entered.
        int targetSum = scanner.nextInt();

        System.out.println(targetSum);//It prints the triplet with the sum.
        findTriplets(nums, targetSum);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
