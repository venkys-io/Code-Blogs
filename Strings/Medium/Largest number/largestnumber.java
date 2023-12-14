import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class largestnumber {

    // Function to find the largest number by concatenating elements of the array
    static String largestNumber(int[] nums) {
        // Convert the array of integers to an ArrayList of strings
        ArrayList<String> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(String.valueOf(i));
        }

        // Define a custom comparator for sorting strings
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // Compare strings based on the concatenated values
                return (str2 + str1).compareTo(str1 + str2);
            }
        };

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
        // Example usage with an array of integers
        int[] nums = { 3, 30, 34, 5, 9 };
        System.out.println(largestNumber(nums));
    }
}
