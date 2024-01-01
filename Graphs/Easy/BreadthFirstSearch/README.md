# Exploring Graph Algorithms:Breadth-First Search

Today, we dive into the fascinating world of graph algorithms and uncover one of their most captivating mysteries – Breadth-First search(BFS). Get ready to embark on an adventure that will challenge your mind and leave you with newfound insights into the power of graphs!

## Introduction to graph algorithms

Graph algorithms are a crucial tool in computer science, used to solve a variety of problems related to graphs. A graph is a data structure consisting of nodes (also known as vertices) and edges that connect them. These algorithms are designed specifically for graphs and are essential in solving complex problems that involve large amounts of interconnected data.

There are many graph algorithms, each with its purpose and methodology. Some of the most commonly used ones include Depth-First Search (DFS), Breadth-First Search (BFS), Dijkstra's algorithm, Prim's algorithm, and Kruskal's algorithm.

Graph algorithms have various applications across various fields, such as network routing, social media analysis, recommendation systems, image segmentation, etc. They can help us understand the underlying structure and relationships within data sets by analyzing their connectivity patterns.

One of the fundamental tasks in graph theory is breadth first search in a [graph.In](http://graph.In) this blog post,we will learn how to use breadth-first.

## Breath-first search

Breadth-First Search (BFS) is a graph traversal algorithm used to explore and search for nodes or vertices in a graph or tree data structure. It operates in a systematic and orderly manner, starting from a selected source node and moving outward through the graph, exploring nodes layer by layer. BFS is often employed in a variety of applications, including finding the shortest path, solving puzzles, and network analysis.

BFS is a versatile and widely used algorithm in computer science and is fundamental in many graph-related problems. It is contrasted with Depth-First Search (DFS), which explores as far as possible along one branch of the graph before backtracking. Depending on the specific problem and the nature of the graph, one of these two algorithms may be more suitable than the other.

BFS is a foundational algorithm with a wide range of practical applications across different domains, including computer science, network analysis, web technology, artificial intelligence, and problem-solving. Its ability to explore graphs in a systematic and level-by-level manner makes it a valuable tool for various tasks that involve graph traversal and pathfinding.

## Overview of breadth-first search algorithm

Breadth-First Search (BFS) is a versatile graph traversal algorithm used to explore and analyze graphs or trees in a systematic and orderly manner. It operates by starting from a chosen source node and then progressively explores nodes in layers, moving outwards level by level. BFS utilizes a queue data structure to maintain the order of node exploration, ensuring that nodes are visited in the order they were discovered. This algorithm is particularly well-suited for scenarios where the goal is to find the shortest path between two nodes in an unweighted graph. It offers guaranteed completeness, meaning it will discover all reachable nodes and locate the shortest path if one exists.

BFS has a broad range of practical applications, making it a fundamental tool in computer science and related fields. It is commonly used in network routing to find efficient paths in computer networks, in web crawling for indexing and navigating web pages, and in various puzzle-solving tasks, such as mazes and the Eight-Puzzle. Additionally, BFS is crucial in network analysis to determine connectivity and find connected components within graphs. Understanding and mastering BFS is essential for any programmer or computer scientist, as it provides a foundational building block for more complex algorithms and problem-solving in graph-related domains.

## CODE

### ***Python code:***

```python
# Copyrights to venkys.io for more information, visit https://venkys.io
# Iterative Binary Search Function method Python Implementation  
# It returns index of n in given list1 if present,   
# else returns -1   
def binary_search(list1, n):  
    low = 0  
    high = len(list1) - 1  
    mid = 0  
  
    while low <= high:  
        # for get integer result   
        mid = (high + low) // 2  
  
        # If n is greater, compared to the left of mid    
        if list1[mid] < n:  
            low = mid + 1  
  
        # If n is smaller, compare to the right of mid   
        elif list1[mid] > n:  
            high = mid - 1  
  
        # If n is present at mid
        else:  
            return mid  
  
    # element was not present in the list, return -1  
    return -1  
  
  
# Initial list1  
list1 = [12, 24, 32, 39, 45, 50, 54]  
n = 45  
  
# Function call   
result = binary_search(list1, n)  
  
if result != -1:  
    print("Element is present at index", str(result))  
else:  
    print("Element is not present in list1")
```

## Step-by-step explanation

- We have created a function called binary_search() function which takes two arguments - a list to be sorted and a number to be searched.
- We have declared two variables to store the lowest and highest values in the list. The low is assigned initial value to 0, high to **l**en(list1) - 1 and mid as 0.
- Next, we have declared the **while** loop with the condition that the **lowest** is equal and smaller than the **highest** The while loop will iterate if the number has not been found yet.
- In the while loop, we find the mid value and compare the index value to the number we are searching for.
- If the value of the mid-index is smaller than **n**, we increase the mid value by 1 and assign it to The search moves to the left side.
- Otherwise, decrease the mid value and assign it to the **high**. The search moves to the right side.
- If the n is equal to the mid value then return **mid**.
- This will happen until the **low** is equal and smaller than the **high**.
- If we reach at the end of the function, then the element is not present in the list. We return -1 to the calling function.

### ***Java code:***

```java
// Copyrights to venkys.io. For more information, visit https://venkys.io

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Array of buckets to hold sorted elements
    static ArrayList<Integer>[] temp = new ArrayList[10];

    // Function to perform bucket sort
    public static void VSDSort(int n, int[] arr) {
        // Creating buckets to hold a certain range of numbers
        for (int i = 0; i < 10; i++) {
            temp[i] = new ArrayList<Integer>();
        }

        // Arranging input numbers into appropriate buckets in a sorted order using
        // insertion sort
        for (int i = 0; i < arr.length; i++) {
            int t = arr[i] / 10; // Determine the bucket index
            int element = arr[i];

            if (temp[t].isEmpty())
                temp[t].add(element);
            else if (element > temp[t].get(temp[t].size() - 1))
                temp[t].add(element);
            else if (element < temp[t].get(0)) {
                // Insert at the beginning of the bucket
                for (int j = temp[t].size() - 1; j >= 0; j--) {
                    if (j + 1 == temp[t].size())
                        temp[t].add(j + 1, temp[t].get(j));
                    else
                        temp[t].set(j + 1, temp[t].get(j));
                }
                temp[t].set(0, element);
            } else {
                // Insert in the middle of the bucket
                for (int j = 0; j < temp[t].size(); j++) {
                    if (element > temp[t].get(j) && element < temp[t].get(j + 1)) {
                        for (int k = temp[t].size() - 1; k >= j; k--) {
                            if (k + 1 == temp[t].size())
                                temp[t].add(k + 1, temp[t].get(k));
                            else
                                temp[t].set(k + 1, temp[t].get(k));
                        }
                        temp[t].set(j + 1, element);
                    }
                }
            }
        }
    }

    // Function to print the sorted output
    public static void VSDprintOutput() {
        System.out.println("The sorted order is:");
        for (int i = 0; i < temp.length; i++) {
            for (int k = 0; k < temp[i].size(); k++) {
                System.out.print(temp[i].get(k) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Read the number of elements from the user
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            int[] a = new int[n];

            // Read the elements from the user
            System.out.print("Enter the elements separated by space: ");
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // Perform bucket sort
            VSDSort(n, a);

            // Print the sorted output
            VSDprintOutput();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

```

## Step-by-step explanation:

- Static int binarySearch(int[] arr,int target): This function takes a sorted array (arr) and a target value (target) as parameters and returns the index of the target value in the array. If the target is not present, it returns -1.
- int low=0: Initialize the low index to the beginning of the array.
- int hight=arr.length-1 : Initialize the high index to the end of the array.
- The [while (low≤high)] loop continues until the low index is greater than the high index.
- mid=(low+high)/2: Calculate the middle index to divide the array into two halves.
- Check if the target is equal to the element at the middle index:
    - If yes, return the middle index.
    - If no, adjust the low and high indices based on whether the target is greater or smaller than the middle element.
- If the target is greater, ignore the left half by setting  low=mid+1.
- If the target is smaller, ignore the right half by setting high=mid-1.
- If the target is not found after the loop, return -1.
- The main method demonstrates how to use the binary search function with a sample sorted array and a target value. It prints the index if the target is found and a message if it is not found.

### ***Cpp code:***

```cpp
// Copyrights to venkys.io. For more information, visit https://venkys.io

#include<iostream>
#include<vector>
#include<algorithm> // Include the algorithm header for the sort function

using namespace std;

// Function to find the minimum value in the array
int findMin(int arr[], int n) {
    int mini = arr[0];
    for (int i = 0; i < n; i++) {
        if (arr[i] < mini)
            mini = arr[i];
    }
    return mini;
}

// Function to find the maximum value in the array
int findMax(int arr[], int n) {
    int maxi = arr[0];
    for (int i = 0; i < n; i++) {
        if (arr[i] > maxi)
            maxi = arr[i];
    }
    return maxi;
}

// Bucket Sort function
void bucketSort(int arr[], int n) {
    // Step 1: Find the minimum and maximum values in the array
    int mini = findMin(arr, n);
    int maxi = findMax(arr, n);

    // Step 2: Create a vector of vectors to represent the buckets
    vector<vector<int>> bucket(n);

    // Step 3: Distribute elements into buckets
    for (int i = 0; i < n; i++) {
        // Calculate the index for each element in the array
        int j = n * (arr[i] - mini) / (maxi + 1 - mini);
        bucket[j].push_back(arr[i]);
    }

    // Step 4: Sort each individual bucket
    int index = 0;
    for (int j = 0; j < n; j++) {
        vector<int>& bj = bucket[j]; // Reference to the bucket vector
        sort(bj.begin(), bj.end());

        // Step 5: Concatenate sorted buckets to obtain the final sorted array
        for (int k = 0; k < bj.size(); k++) {
            arr[index++] = bj.at(k);
        }
    }
}

int main() {
    // Step 6: Example usage in the main function
    cout << "Enter the number of elements: ";
    int n;
    cin >> n;

    int arr[n];

    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Step 7: Apply Bucket Sort
    bucketSort(arr, n);

    // Step 8: Print the sorted array
    cout << "Sorted Array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}

```

## Step-by-step explanation:

- #include<bits/stdc++.h>: Include the necessary header for input and output operations.
- using namespace std;: Declare the usage of the standard namespace.
- int binarySearch(int arr[],int n,int target): This function takes a sorted array (arr), a target value (target), and the size of the array (size) as parameters and returns the index of the target value in the array. If the target is not present, it returns -1.
- int low=0;  : Initialize the low index to the beginning of the array.
- (int high=size-1;) : Initialize the high index to the end of the array.
- The while(low≤high): loop continues until the low index is greater than the high index.
- mid=(low+high)/2: Calculate the middle index to divide the array into two halves.
- Check if the target is equal to the element at the middle index:
    - If yes, return the middle index.
    - If no, adjust the low and high indices based on whether the target is greater or smaller than the middle element
- If the target is greater, ignore the left half by setting low=mid+1.
- If the target is smaller, ignore the right half by setting high=mid-1.
- If the target is not found after the loop, return -1.
- The main function demonstrates how to use the binary search function with a sample sorted array, its size, and a target value. It prints the index if the target is found and a message if it is not found.

## Time and Space complexity analysis

To analyze the efficiency of an algorithm, we consider its time and space complexity. Time complexity refers to the time it takes for an algorithm to run, while space complexity refers to the amount of memory or storage space required by an algorithm.

The time complexity of the binary search algorithm is O(log n)**.** The best-case time complexity would be O(1) when the central index would directly match the desired value. Binary search algorithm time complexity worst case differs from that. The worst-case scenario could be the values at either the extremity of the list or those not on the list.

In the worse case binary search algorithm complexity, the values are present in such a way that either they are at the extremity of the list or are not present in the list at all. Below is a brief description of how to find worse case complexity of the binary search.

The equation T(n)= T(n/2)+1 is known as the recurrence relation for binary search.

To perform time complexity of binary search analysis, we apply the master theorem to the equation and get O(log n).

Worse case complexity of the binary search is often easier to compute but carries the drawback of being too much pessimistic.

## Real-world applications of binary search algorithm

1. **Searching in Databases:** Binary search is commonly used in databases to quickly locate a particular record based on a sorted key. This is especially efficient when dealing with large datasets.
2. **Sorting Algorithms:** Binary search is at the core of many sorting algorithms, like quicksort. It helps divide and conquer by efficiently finding the position of elements in a sorted array.
3. **File Systems:** Binary search is used in file systems to locate a specific file among a sorted list of files. This speeds up file retrieval operations.
4. **Finding Square Roots:** In mathematical computations, binary search can be used to find the square root of a number with a high degree of precision.
5. **Game Development:** Binary search is employed in certain game algorithms, like pathfinding or finding a particular item in a sorted list.
6. **Networking and IP Routing:** Binary search is used in networking for IP routing tables. It helps quickly determine the route to forward a packet based on the destination IP address.
7. **Text Editors:** In text editors, binary search can be used to quickly find and navigate to a specific line or character in a large document.
8. **Genetics and Bioinformatics:** Binary search is utilized in searching and analyzing DNA sequences. It helps locate specific patterns or genes efficiently.

These applications showcase the versatility and efficiency of binary search in solving various real-world problems
