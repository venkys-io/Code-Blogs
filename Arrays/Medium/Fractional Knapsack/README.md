# Fractional Knapsack

Fractional Knapsack is a classic problem in the field of algorithms and optimization. It is a variation of the Knapsack problem, where the goal is to maximize the total value of items selected, given a constraint on the total weight of those items. It specifically falls under the broader category of dynamic programming and greedy algorithms.

## introduction

The Fractional Knapsack problem involves a set of items, each characterized by both a weight and a value. The challenge is to fill a knapsack with a maximum weight capacity while maximizing the total value of the items inside. What makes this problem intriguing is the ability to break items into fractions, allowing for a more flexible and nuanced approach to resource optimization.

One of the striking features of the Fractional Knapsack algorithm is its use of a greedy approach. By prioritizing items based on their value-to-weight ratios, the algorithm makes locally optimal choices at each step, aiming for a globally optimal solution. It is a valuable algorithm in resource optimization scenarios.

## Greddy Algorithm

Greedy Algorithm specifically designed for solving the Fractional Knapsack Problem. The core of the algorithm is based on making locally optimal choices (choosing items with the highest profit-to-weight ratio at each step).

Firstly, Items are sorted based on their profit-to-weight ratios in descending order, then the algorithm iterates through the sorted items. At each step, it considers adding the entire item if there is enough capacity in the knapsack. If there isn't enough capacity, it adds a fraction of the item to maximize the total profit without exceeding the knapsack's capacity.

Lastly, the result is the maximum achievable profit based on the greedy selection of items. The crucial point is that it makes locally optimal choices, hoping that the choices lead to a globally optimal solution for the entire knapsack problem.

## Python Code

```python
# Copyrights to venkys.io
# For more programs visit venkys.io
# Python program for Fractional Knapsack

# Function to calculate P/W ratio
def VSDcalculatepwratio(n, m, p, w):
    # Create a 2D array to store profit, weight, and profit-to-weight ratio
    ratioarray = [[0 for i in range(3)] for i in range(n)]
    
    # Calculate and populate the array
    for i in range(n):
        # Profit
        ratioarray[i][0] = p[i]
        # Weight
        ratioarray[i][1] = w[i]  
        # Profit-to-Weight ratio
        ratioarray[i][2] = p[i] / w[i]  

    # Return the array sorted in descending order based on profit-to-weight ratio
    return sorted(ratioarray, reverse=True, key=lambda x: x[2])

# Function to find maximum profit possible
def VSDknapsack(sortedarray, n, m):
    i = result = 0
    
    # Iterate until the knapsack is full
    while m > 0:
        if m - sortedarray[i][1] >= 0:
            # Add the entire item to the knapsack
            result += sortedarray[i][0] 
            # Reduce knapsack capacity
            m = m - sortedarray[i][1] 
        else:
            # Add a fraction of the item to fill the remaining capacity
            result += sortedarray[i][2] * m
            # Knapsack is full
            m = 0  
        i += 1
    # Return the maximum profit as a formatted string
    return "{:.2f}".format(result)

# Function to print array
def VSDprint(sortedarray, n):
    print("\nProfits:")
    for i in range(n):
        # Print profit of each item
        print(sortedarray[i][0], end="  ")
    print("\nweights:")
    for i in range(n):
        # Print weight of each item
        print(sortedarray[i][1], end="  ")
    print("\nP/W ratio:")
    for i in range(n):
        # Print profit-to-weight ratio of each item
        print(sortedarray[i][2], end="  ")
    print("\n")

# Main Function
if __name__ == "__main__":
    n = 7
    capacity = 15
    profits = [5, 10, 15, 7, 8, 9, 4]
    weights = [1, 3, 5, 4, 1, 3, 2]
    
    # Calculate and sort the array based on profit-to-weight ratio
    arr = VSDcalculatepwratio(n, capacity, profits, weights)
    
    # Find and print the maximum profit
    result = VSDknapsack(arr, n, capacity)
    VSDprint(arr, n)
    print("maximum profit is :", result)

```

## Java Code

```java
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
        int n = 7;
        int capacity = 15;
        int[] profits = {5, 10, 15, 7, 8, 9, 4};
        int[] weights = {1, 3, 5, 4, 1, 3, 2};
        
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
        System.out.printf("The maximum profit is %.2f", result);
    }
}
```

## C++ Code

```c++
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for FractionalKnapsack

#include<bits/stdc++.h>

using namespace std;

// Struct to represent items in the knapsack
struct Node
{
    int profit;
    int weight;
    float ratio;
    
    // Overloading < operator for sorting based on profit-to-weight ratio
    bool operator < (const Node& n1) const {
        return n1.ratio < ratio;
    };
};

// Function to perform fractional knapsack
float knapsack(vector<Node> arr, int n, int m) {
    // Initialize variables for loop control and the final result
    int i = 0, result = 0;

    // Continue the loop until the knapsack is full (m > 0)
    while (m > 0) {
        // If the entire item can be added to the knapsack
        if (m - arr[i].weight >= 0) {
            // Add the entire profit of the item to the result
            result += arr[i].profit;
            // Reduce the knapsack capacity by the weight of the added item
            m = m - arr[i].weight;
        } else {
            // If only a fraction of the item can be added to fill the remaining capacity
            // Add a fraction of the profit to the result
            result += arr[i].ratio * m;
            // Knapsack is now full, so set m to 0 to exit the loop
            m = 0;
        }
        // Move to the next item in the sorted array
        i++;
    }

    // Return the final result, which represents the maximum profit
    return result;
}
int main() {
    // Initialize variables for the number of items, knapsack capacity, profits, and weights
    int n = 7;
    int capacity = 15;
    int profits[] = {5, 10, 15, 7, 8, 9, 4};
    int weights[] = {1, 3, 5, 4, 1, 3, 2};
    
    // Create a vector to store Node objects representing items in the knapsack
    vector<Node> arr;

    // Populate the vector with Node objects created from profit, weight, and ratio
    for (int i = 0; i < n; i++) {
        Node node;
        node.profit = profits[i];
        node.weight = weights[i];
        node.ratio = (float)profits[i] / weights[i];
        arr.push_back(node);
    }

    // Sort the vector based on profit-to-weight ratio using the overloaded < operator
    sort(arr.begin(), arr.end());

    // Call the knapsack function to find the maximum profit
    float result = knapsack(arr, n, capacity);

    // Print the maximum profit to the console
    printf("The Maximum profit is %.2f", result);

    return 0;
}
```

## Time and Space Complexity Analysis

* All three implementations have a time complexity O(n logn), where 'n' is the number of items in the knapsack problem. The dominant factor in time complexity is the sorting of items based on their profit-to-weight ratio.

* The space complexity is O(n), the space complexity is mainly determined by the storage of items.
