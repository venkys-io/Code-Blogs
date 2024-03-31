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
