import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> fourSum(int[] arr, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        if (arr == null || arr.length == 0) {
            System.out.println("Input array is empty or null. Returning empty result.");
            return res;
        }

        int n = arr.length;

        // Sort the input array in ascending order
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            // Reduce the problem to finding a 3-sum
            int target_3 = target - arr[i];

            for (int j = i + 1; j < n; j++) {
                // Reduce the problem to finding a 2-sum
                int target_2 = target_3 - arr[j];

                int front = j + 1;
                int back = n - 1;

                while (front < back) {
                    int two_sum = arr[front] + arr[back];

                    if (two_sum < target_2) front++;
                    else if (two_sum > target_2) back--;
                    else {
                        // Found a valid quadruplet, add to the result
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        res.add(quad);

                        // Move pointers to avoid duplicates
                        while (front < back && arr[front] == quad.get(2)) ++front;
                        while (front < back && arr[back] == quad.get(3)) --back;
                    }
                }

                // Move pointer to avoid duplicates
                while (j + 1 < n && arr[j + 1] == arr[j]) ++j;
            }

            // Move pointer to avoid duplicates
            while (i + 1 < n && arr[i + 1] == arr[i]) ++i;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the array elements from STDIN
        String[] arrString = scanner.nextLine().split("");

        // Check if the input array is empty
        if (arrString.length == 0) {
            System.out.println("Input array is empty. Exiting program.");
            scanner.close();
            return;
        }

        int[] arr = new int[arrString.length];
        try {
            for (int i = 0; i < arrString.length; i++) {
                arr[i] = Integer.parseInt(arrString[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid integers. Exiting program.");
            scanner.close();
            return;
        }

        // Read the target sum from STDIN
        int target;
        try {
            target = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input for target sum. Exiting program.");
            scanner.close();
            return;
        }

        List<List<Integer>> result = fourSum(arr, target);

        // Print the result
        for (List<Integer> quad : result) {
            for (int num : quad) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
