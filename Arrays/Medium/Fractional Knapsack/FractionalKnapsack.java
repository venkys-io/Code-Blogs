// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for FractionalKnapsack

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Node class to represent items in the knapsack
class Node  {
    // Comparator for sorting Nodes based on profit-to-weight ratio
    public static class OrderByRatio implements Comparator<Node> {
        @Override
        public int compare(Node n1, Node n2) {
            return n1.ratio > n2.ratio ? -1 : (n1.ratio < n2.ratio ? 1 : 0);
        }
    }

    int profit, weight;
    float ratio;

    Node(int profit, int weight, float ratio) {
        this.profit = profit;
        this.weight = weight;
        this.ratio = ratio;
    }
}

public class Main {
    // Function to perform fractional knapsack
    static float knapsack(ArrayList<Node> arr, int n, int m) {
    // Initialize variables for loop control and the final result
        int i = 0, result = 0;

        // Continue the loop until the knapsack is full (m > 0)
        while (m > 0) {
            // If the entire item can be added to the knapsack
            if (m - arr.get(i).weight >= 0) {
                // Add the entire profit of the item to the result
                result += arr.get(i).profit;
                // Reduce the knapsack capacity by the weight of the added item
                m = m - arr.get(i).weight;
            } 
            else {
                // If only a fraction of the item can be added to fill the remaining capacity
                // Add a fraction of the profit to the result
                result += arr.get(i).ratio * m;
                // Knapsack is now full, so set m to 0 to exit the loop
                m = 0;
            }
            // Move to the next item in the sorted array
            i += 1;
            }
        // Return the final result, which represents the maximum profit
        return result;
    }

    public static void main(String[] args) {
        // ArrayList to store items in the knapsack
        ArrayList<Node> sack = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input the number of items and the capacity of the knapsack
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();

        // Initialize arrays to store profits and weights of items
        int[] profits = new int[n];
        int[] weights = new int[n];

        // Input profits of items
        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
        }

        // Input weights of items
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }
        
        // Populate the sack ArrayList with Node objects
        for (int i = 0; i < n; i++) {
            float ratio = (float) profits[i] / weights[i];
            Node node = new Node(profits[i], weights[i], ratio);
            sack.add(node);
        }

        // Sort the sack ArrayList based on profit-to-weight ratio
        Collections.sort(sack, new Node.OrderByRatio());

        // Call the knapsack function to find the maximum profit
        float result = knapsack(sack, n, capacity);

        // Print the maximum profit
        System.out.printf( result);
    }
}
