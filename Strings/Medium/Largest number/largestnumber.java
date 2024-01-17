import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class largestnumber {

    // Function to find the largest number by concatenating elements of the array
    static String largestNumber(int[] nums) {
        // Convert the array of integers to an ArrayList of strings
        ArrayList<String> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(String.valueOf(i));
        }

        // Define a custom comparator for sorting strings
        Comparator<String> comp = (str1, str2) -> (str2 + str1).compareTo(str1 + str2);

        // Sort the ArrayList using the custom comparator
        Collections.sort(arr, comp);

        // Build the result by appending non-zero strings
        StringBuilder ans = new StringBuilder();
        arr.forEach((s) -> {
            if (!s.equals("0")) {
                ans.append(s);
            }
        });

        // Return the result as a string
        return ans.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter the size of the array
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Prompt the user to enter elements of the array
            System.out.println("Enter the elements of the array:");

            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }

            // Find and display the largest number
            System.out.println("The largest number is: " + largestNumber(nums));
        } catch (Exception e) {
            // Handle exceptions such as non-integer input
            e.printStackTrace();
        }
    }
}

// Enter the size of the array: 5
// Enter the elements of the array:
// 21 23 43 9 98
// The largest number is: 998432321