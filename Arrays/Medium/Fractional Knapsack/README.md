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
def VSDcalculatepwratio(n, p, w):
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
    while m > 0 and i < n:
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
    n = int(input())
    profits = []
    weights = []

    for i in range(n):
        profit = int(input())
        weight = int(input())
        profits.append(profit)
        weights.append(weight)

    capacity = int(input())

    # Calculate and sort the array based on profit-to-weight ratio
    arr = VSDcalculatepwratio(n, profits, weights)

    # Find and print the maximum profit
    result = VSDknapsack(arr, n, capacity)
    VSDprint(arr, n)
    print(result)

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
```

## C++ Code

```c++
// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for FractionalKnapsack

#include <iostream>
#include <vector>
#include <algorithm>
#include <iomanip>

// Struct to represent items in the knapsack
struct Node
{
    int profit;
    int weight;
    float ratio;

    // Overloading < operator for sorting based on profit-to-weight ratio
    bool operator<(const Node &n1) const
    {
        return n1.ratio < ratio;
    }
};

// Function to perform fractional knapsack
float knapsack(std::vector<Node> arr, int n, int m)
{
    // Initialize variables for loop control and the final result
    int i = 0, result = 0;

    // Continue the loop until the knapsack is full (m > 0)
    while (m > 0)
    {
        // If the entire item can be added to the knapsack
        if (m - arr[i].weight >= 0)
        {
            // Add the entire profit of the item to the result
            result += arr[i].profit;
            // Reduce the knapsack capacity by the weight of the added item
            m = m - arr[i].weight;
        }
        else
        {
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

int main()
{
    // Initialize variables for the number of items, knapsack capacity, profits, and weights
    int n;
    // std::cout << "Enter the number of items: ";
    std::cin >> n;

    std::vector<Node> arr;

    for (int i = 0; i < n; i++)
    {
        Node node;
        // std::cout << "Enter profit for item " << i + 1 << ": ";
        std::cin >> node.profit;

        // std::cout << "Enter weight for item " << i + 1 << ": ";
        std::cin >> node.weight;

        node.ratio = static_cast<float>(node.profit) / node.weight;
        arr.push_back(node);
    }

    int capacity;
    // std::cout << "Enter the knapsack capacity: ";
    std::cin >> capacity;

    // Sort the vector based on profit-to-weight ratio using the overloaded < operator
    std::sort(arr.begin(), arr.end());

    // Call the knapsack function to find the maximum profit
    float result = knapsack(arr, n, capacity);

    // Print the maximum profit to the console
    std::cout <<  std::fixed << std::setprecision(2) << result << std::endl;

    return 0;
}
```

## Time and Space Complexity Analysis

* All three implementations have a time complexity O(n logn), where 'n' is the number of items in the knapsack problem. The dominant factor in time complexity is the sorting of items based on their profit-to-weight ratio.

* The space complexity is O(n), and the space complexity is mainly determined by the storage of items.

## Real-world applications

1. **Financial Portfolio Optimization:**

    * In investment management, Fractional Knapsack optimally allocates funds across diverse assets, considering varying risks and returns, to maximize overall portfolio value within investment constraints.

2. **Inventory Management:**

    * Businesses use Fractional Knapsack to select the most profitable subset of products, balancing factors like shelf life and profit margins, for efficient inventory management and increased profitability.

3. **Project Scheduling:**

    * Fractional Knapsack aids in project management by optimizing task selection based on duration and benefits, ensuring efficient resource utilization and timely project completion.

4. **Data Compression:**

    * In data science, Fractional Knapsack optimizes the selection of features or components for data representation, striking a balance between compression and information retention, especially in bandwidth-limited scenarios.

5. **Cutting Stock Problem in Manufacturing:**

    * Industries optimize raw material cutting using Fractional Knapsacks, minimizing waste and maximizing profit by selecting the most efficient combination of cuts to fulfill orders.

6. **Wireless Communication Networks:**

    * Fractional Knapsack is applied in wireless networks to optimize the transmission of data packets, ensuring the most valuable information is sent within the constraints of available bandwidth for efficient communication.

### Test Cases for Fractional Knapsack

### Test Case 1: Basic Test Case

* **Number of Items:** 5
* **Knapsack Capacity:** 10
* **Profits:** 10, 15, 7, 8, 9
* **Weights:** 2, 3, 5, 7, 1
* **Expected Output:** Maximum profit is 45.67 (or any equivalent value)

**Explanation:** This test case represents a basic scenario with a set of items, each having a profit and weight. The knapsack's capacity is limited, and the goal is to maximize the total profit while considering the weight constraints. The algorithm should select items with the highest value-to-weight ratio to maximize the overall profit within the knapsack capacity.

### Test Case 2: All Items Fit Perfectly

* **Number of Items:** 4
* **Knapsack Capacity:** 20
* **Profits:** 12, 18, 25, 30
* **Weights:** 6, 4, 8, 10
* **Expected Output:** Maximum profit is 85.00 (or any equivalent value)

**Explanation:** In this scenario, all the available items can be accommodated within the knapsack's capacity without exceeding it. The algorithm should select all items to maximize the total profit without any fraction being added.

### Test Case 3: Fractional Selection

* **Number of Items:** 6
* **Knapsack Capacity:** 50
* **Profits:** 20, 30, 10, 15, 8, 5
* **Weights:** 10, 5, 8, 12, 6, 3
* **Expected Output:** Maximum profit is 105.00 (or any equivalent value)

**Explanation:** This test case involves a mix of items with varying profit-to-weight ratios. The knapsack has ample capacity to accommodate some items partially. The algorithm should intelligently select items, either fully or fractionally, to maximize the overall profit within the knapsack's capacity.

### Test Case 4: One Item Only

* **Number of Items:** 1
* **Knapsack Capacity:** 5
* **Profits:** 12
* **Weights:** 8
* **Expected Output:** Maximum profit is 7.50 (or any equivalent value)

**Explanation:** This test focuses on a scenario where there's only one item available, and its weight exceeds the knapsack's capacity. The algorithm should select a fraction of the item to maximize the profit within the capacity constraint.

### Test Case 5: No Capacity

* **Number of Items:** 3
* **Knapsack Capacity:** 0
* **Profits:** 15, 10, 5
* **Weights:** 2, 3, 5
* **Expected Output:** Maximum profit is 0.00

**Explanation:** In this situation, the knapsack's capacity is zero, indicating that no items can be added. The algorithm should output a maximum profit of 0, as no items can be selected.

### Test Case 6: Large Number of Items

* **Number of Items:** 10,000
* **Knapsack Capacity:** 1000
* **Profits:** random values
* **Weights:** random values
* **Expected Output:** Maximum profit based on the generated random values

**Explanation:** This test involves a large number of items and a capacity constraint. Random profit and weight values are generated for this test case to check the algorithm's performance with a significant amount of data.

**Additional Considerations:**

* Test cases with edge conditions like a very small or very large knapsack capacity evaluate how the algorithm handles extreme constraints.
* Test cases where the items are already sorted or reverse-sorted based on their profit-to-weight ratio to validate the algorithm's robustness.
* Cases with negative profits or weights confirm that the algorithm handles such scenarios gracefully.
* Performance testing with larger inputs to evaluate the execution time of the algorithm.

Running these test cases against the Fractional Knapsack algorithm will help ensure its correctness and efficiency in finding the optimal solution for various scenarios.
