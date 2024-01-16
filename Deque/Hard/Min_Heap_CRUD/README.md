# Problem Statement

Implementation of a Min Heap, a fundamental data structure with applications in various algorithms. The focus will be on creating a Min Heap and performing basic `CRUD (Create, Read, Update, Delete)` operations on it. The implementations will be provided in three popular programming languages: Python, Java, and C++.

## Introduction

Min Heap is a binary heap with the unique property that the key at each node is less than or equal to the keys of its children. This characteristic ensures that the minimum element is always at the root, making it efficient for finding the smallest element in constant time. Understanding how to implement and manipulate a Min Heap is fundamental for algorithm design and optimization.

## Overview

### Python Implementation

Let's start by exploring the Python implementation. Python's `heapq` module provides a convenient way to create a Min Heap. We'll create a `MinHeap` class with methods for insertion, extracting the minimum value, getting the minimum value, updating a key, and deleting a key.

### Java Implementation

In the Java implementation, we'll utilize the `PriorityQueue` class to implement the Min Heap. The `MinHeap` class will include methods for the same CRUD operations. Java's syntax and approach may differ from Python, providing a diverse perspective on solving the same problem.

### C++ Implementation

Moving on to C++, we'll use a combination of `std::vector` and algorithms from the C++ Standard Template Library (STL) to implement the Min Heap. The `MinHeap` class will mirror the operations performed in Python and Java, showcasing how the principles translate across languages.

## Code

### Python Code

```python
""" Copyrights to venkys.io
For more information, visit https://venkys.io 

Space complexity: O(n)
Time complexity
- Insertion: O(log n)
- Extraction of Minimum: O(log n)
- Getting Minimum: O(1)
- Updating Key: O(n)
- Deleting Key : O(n) """

import heapq
import sys

class MinHeap:
    def __init__(self):
        """
        Initialize an empty MinHeap.

        Attributes:
        - heap: A list to store elements in heap order.
        """
        self.heap = []

    def insert(self, value):
        """
        Insert a value into the MinHeap.

        Parameters:
        - value: The value to be inserted.
        """
        heapq.heappush(self.heap, value)

    def extract_min(self):
        """
        Extract the minimum value from the MinHeap.

        Returns:
        - The minimum value if the heap is not empty, otherwise None.
        """
        if self.heap:
            return heapq.heappop(self.heap)
        return None

    def get_min(self):
        """
        Get the minimum value from the MinHeap without removing it.

        Returns:
        - The minimum value if the heap is not empty, otherwise None.
        """
        return self.heap[0] if self.heap else None

    def update_key(self, old_value, new_value):
        """
        Update a key in the MinHeap with a new value.

        Parameters:
        - old_value: The value to be updated.
        - new_value: The new value to replace the old value.
        """
        if old_value in self.heap:
            index = self.heap.index(old_value)
            self.heap[index] = new_value
            heapq.heapify(self.heap)

    def delete_key(self, value):
        """
        Delete a key from the MinHeap.

        Parameters:
        - value: The value to be deleted.
        """
        if value in self.heap:
            self.heap.remove(value)
            heapq.heapify(self.heap)

def main():
    min_heap = MinHeap()

    try:
        # Read input values from STDIN
        input_values = input("Enter space-separated values: ").split()

        # Check for null values or empty input
        if not input_values:
            raise ValueError("Error: Input values are missing.")

        # Convert input values to integers
        values = map(int, input_values)

        # Insert values into the MinHeap
        for value in values:
            min_heap.insert(value)

        print("Min Heap:", min_heap.heap)

        min_value = min_heap.extract_min()
        if min_value is not None:
            print("Extracted Min Value:", min_value)
            print("Updated Min Heap:", min_heap.heap)

        min_value = min_heap.get_min()
        if min_value is not None:
            print("Min Value:", min_value)

        # Update a key in the MinHeap
        old_value = int(input("Enter the value to be updated: "))
        new_value = int(input("Enter the new value: "))
        min_heap.update_key(old_value, new_value)
        print("Updated Min Heap:", min_heap.heap)

        # Delete a key from the MinHeap
        value_to_delete = int(input("Enter the value to be deleted: "))
        min_heap.delete_key(value_to_delete)
        print("Heap after deleting {}: {}".format(value_to_delete, min_heap.heap))

    except ValueError as e:
        print(str(e))

if __name__ == "__main__":
    main()

```

### Java Code

```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(n)
/*Time complexity
- Insertion: O(log n)
- Extraction of Minimum: O(log n)
- Getting Minimum: O(1)
- Updating Key: O(n)
- Deleting Key : O(n)*/

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * The MinHeap class represents a minimum heap implemented using a PriorityQueue in Java.
 */
public class MinHeap {
    private PriorityQueue<Integer> heap;

    /**
     * Constructs a new MinHeap with an empty PriorityQueue.
     */
    public MinHeap() {
        this.heap = new PriorityQueue<>();
    }

    /**
     * Inserts a value into the MinHeap.
     *
     * @param value The value to be inserted.
     */
    public void insert(int value) {
        heap.add(value);
    }

    /**
     * Extracts and returns the minimum value from the MinHeap.
     *
     * @return The minimum value if the heap is not empty, otherwise null.
     */
    public Integer extractMin() {
        return heap.poll();
    }

    /**
     * Returns the minimum value from the MinHeap without removing it.
     *
     * @return The minimum value if the heap is not empty, otherwise null.
     */
    public Integer getMin() {
        return heap.peek();
    }

    /**
     * Updates a key in the MinHeap with a new value.
     *
     * @param oldValue The value to be updated.
     * @param newValue The new value to replace the old value.
     */
    public void updateKey(int oldValue, int newValue) {
        heap.remove(oldValue);
        heap.add(newValue);
    }

    /**
     * Deletes a key from the MinHeap.
     *
     * @param value The value to be deleted.
     */
    public void deleteKey(int value) {
        heap.remove(value);
    }

    /**
     * Gets the current state of the MinHeap.
     *
     * @return A string representation of the MinHeap.
     */
    public String getHeapState() {
        return heap.toString();
    }

    /**
     * The main method for demonstrating the usage of the MinHeap class.
     */
    public static void main(String[] args) {
        // Create a new MinHeap instance
        MinHeap minHeap = new MinHeap();

        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter space-separated values
            System.out.println("Enter space-separated values (or press Enter to finish):");
            String inputLine = scanner.nextLine();

            // Check if the input is null or empty
            if (inputLine == null || inputLine.trim().isEmpty()) {
                System.out.println("Error: Input values are missing or empty.");
                return;
            }

            // Split the input values and insert them into the MinHeap
            String[] inputValues = inputLine.split("\\s+");
            for (String inputValue : inputValues) {
                try {
                    int value = Integer.parseInt(inputValue);
                    minHeap.insert(value);
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid integer value - " + inputValue);
                    return;
                }
            }

            // Display the initial Min Heap
            System.out.println("Min Heap: " + minHeap.getHeapState());

            // Extract and display the minimum value
            Integer minValue = minHeap.extractMin();
            if (minValue != null) {
                System.out.println("Extracted Min Value: " + minValue);
                System.out.println("Updated Min Heap: " + minHeap.getHeapState());
            }

            // Display the current minimum value without removing it
            Integer min = minHeap.getMin();
            if (min != null) {
                System.out.println("Min Value: " + min);
            }

            // Update a key in the MinHeap
            System.out.print("Enter the value to be updated: ");
            int oldValue;
            try {
                oldValue = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Invalid input for updating value.");
                return;
            }

            System.out.print("Enter the new value: ");
            int newValue;
            try {
                newValue = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Invalid input for new value.");
                return;
            }

            minHeap.updateKey(oldValue, newValue);
            System.out.println("Updated Min Heap: " + minHeap.getHeapState());

            // Delete a key from the MinHeap
            System.out.print("Enter the value to be deleted: ");
            int valueToDelete;
            try {
                valueToDelete = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Invalid input for deleting value.");
                return;
            }

            minHeap.deleteKey(valueToDelete);
            System.out.println("Heap after deleting " + valueToDelete + ": " + minHeap.getHeapState());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

```

### C++ Code

```cpp
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(n)
/*Time complexity
- Insertion: O(log n)
- Extraction of Minimum: O(log n)
- Getting Minimum: O(1)
- Updating Key: O(n)
- Deleting Key : O(n)*/

#include <iostream>
#include <vector>
#include <algorithm>

class MinHeap {
private:
    std::vector<int> heap;

public:
    void insert(int value) {
        heap.push_back(value);
        std::push_heap(heap.begin(), heap.end(), std::greater<int>());
    }

    int extractMin() {
        if (!heap.empty()) {
            int minVal = heap.front();
            std::pop_heap(heap.begin(), heap.end(), std::greater<int>());
            heap.pop_back();
            return minVal;
        }
        return -1; // or any appropriate value to indicate an empty heap
    }

    int getMin() const {
        return heap.empty() ? -1 : heap.front();
    }

    void updateKey(int oldValue, int newValue) {
        auto it = std::find(heap.begin(), heap.end(), oldValue);
        if (it != heap.end()) {
            *it = newValue;
            std::make_heap(heap.begin(), heap.end(), std::greater<int>());
        }
    }

    void deleteKey(int value) {
        auto it = std::find(heap.begin(), heap.end(), value);
        if (it != heap.end()) {
            heap.erase(it);
            std::make_heap(heap.begin(), heap.end(), std::greater<int>());
        }
    }

    // Adding a getter method for the heap
    const std::vector<int>& getHeap() const {
        return heap;
    }
};

int main() {
    MinHeap minHeap;

    int value;
    std::cout << "Enter space-separated values (or press Enter to finish): ";

    // Read values from STDIN and insert into the heap
    while (std::cin >> value) {
        minHeap.insert(value);
    }

    std::cout << "Min Heap: ";
    for (int val : minHeap.getHeap()) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

    // Check if the heap is not empty before extracting the minimum value
    if (!minHeap.getHeap().empty()) {
        int minValue = minHeap.extractMin();
        std::cout << "Extracted Min Value: " << minValue << std::endl;

        std::cout << "Updated Min Heap: ";
        for (int val : minHeap.getHeap()) {
            std::cout << val << " ";
        }
        std::cout << std::endl;

        int min = minHeap.getMin();
        std::cout << "Min Value: " << min << std::endl;

        int oldValue, newValue;
        std::cout << "Enter the value to be updated: ";
        if (std::cin >> oldValue) {
            std::cout << "Enter the new value: ";
            if (std::cin >> newValue) {
                minHeap.updateKey(oldValue, newValue);
                std::cout << "Updated Min Heap: ";
                for (int val : minHeap.getHeap()) {
                    std::cout << val << " ";
                }
                std::cout << std::endl;
            } else {
                std::cerr << "Error: Invalid input for new value." << std::endl;
            }
        } else {
            std::cerr << "Error: Invalid input for updating value." << std::endl;
        }

        int valueToDelete;
        std::cout << "Enter the value to be deleted: ";
        if (std::cin >> valueToDelete) {
            minHeap.deleteKey(valueToDelete);
            std::cout << "Heap after deleting " << valueToDelete << ": ";
            for (int val : minHeap.getHeap()) {
                std::cout << val << " ";
            }
            std::cout << std::endl;
        } else {
            std::cerr << "Error: Invalid input for deleting value." << std::endl;
        }
    } else {
        std::cerr << "Error: The heap is empty." << std::endl;
    }

    return 0;
}
```

## Step-by-Step Explanation

### Insertion

The insertion operation involves adding a new element to the Min Heap. Python uses `heapq.heappush`, Java uses `heap.add`, and C++ uses `push_back` followed by `std::push_heap`.

### Extracting the Minimum

Extracting the minimum value removes and returns the root element (the minimum) from the heap. Python uses `heapq.heappop`, Java uses `heap.poll`, and C++ uses `std::pop_heap` followed by `heap.pop_back`.

### Getting the Minimum

Getting the minimum value retrieves the root element without removing it. Python and Java use indexing or `peek` methods, while C++ uses `front`.

### Updating a Key

Updating a key involves modifying an existing value in the heap. Python and Java use built-in methods or functions, while C++ uses `std::find` to locate the value and then modifies it.

### Deleting a Key

Deleting a key removes a specific element from the heap. Python and Java use `remove` or `removeIf`, and in C++, `std::find` is used followed by `erase`.

## Time and Space Complexity Analysis

The time complexity of basic Min Heap operations is crucial for understanding its efficiency. In general:

- **Insertion**: O(log n)
- **Extraction of Minimum**: O(log n)
- **Getting Minimum**: O(1)
- **Updating Key**: O(n)
- **Deleting Key**: O(n)

The space complexity is **O(n)** as it depends on the number of elements in the heap.

## Real-World Applications

Min Heaps find applications in various real-world scenarios, including:

1. **Dijkstra's Algorithm**: Finding the shortest path in a graph.
2. **Huffman Coding**: Data compression algorithms.
3. **Task Scheduling**: Scheduling tasks based on priority.
4. **Network Routing Protocols**: Optimizing data routing in computer networks.

Understanding Min Heaps and their applications is essential for any programmer or computer scientist, as they form the backbone of many efficient algorithms. The ability to implement and manipulate Min Heaps in different programming languages demonstrates a versatile skill set that can be applied across various domains.

