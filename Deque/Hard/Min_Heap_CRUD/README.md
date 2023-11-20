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

class MinHeap:
    def __init__(self):
        self.heap = []

    def insert(self, value):
        heapq.heappush(self.heap, value)

    def extract_min(self):
        if self.heap:
            return heapq.heappop(self.heap)
        return None

    def get_min(self):
        return self.heap[0] if self.heap else None

    def update_key(self, old_value, new_value):
        if old_value in self.heap:
            index = self.heap.index(old_value)
            self.heap[index] = new_value
            heapq.heapify(self.heap)

    def delete_key(self, value):
        if value in self.heap:
            self.heap.remove(value)
            heapq.heapify(self.heap)
# Example usage
min_heap = MinHeap()
min_heap.insert(5)
min_heap.insert(3)
min_heap.insert(8)
min_heap.insert(1)

print("Min Heap:", min_heap.heap)

min_value = min_heap.extract_min()
print("Extracted Min Value:", min_value)
print("Updated Min Heap:", min_heap.heap)

min_value = min_heap.get_min()
print("Min Value:", min_value)

min_heap.update_key(3, 10)
print("Updated Min Heap:", min_heap.heap)

min_heap.delete_key(8)
print("Heap after deleting 8:", min_heap.heap)

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

public class MinHeap {
    private PriorityQueue<Integer> heap;

    public MinHeap() {
        this.heap = new PriorityQueue<>();
    }

    public void insert(int value) {
        heap.add(value);
    }

    public Integer extractMin() {
        return heap.poll();
    }

    public Integer getMin() {
        return heap.peek();
    }

    public void updateKey(int oldValue, int newValue) {
        heap.remove(oldValue);
        heap.add(newValue);
    }

    public void deleteKey(int value) {
        heap.remove(value);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println("Min Heap: " + minHeap.heap);

        Integer minValue = minHeap.extractMin();
        System.out.println("Extracted Min Value: " + minValue);
        System.out.println("Updated Min Heap: " + minHeap.heap);

        Integer min = minHeap.getMin();
        System.out.println("Min Value: " + min);

        minHeap.updateKey(3, 10);
        System.out.println("Updated Min Heap: " + minHeap.heap);

        minHeap.deleteKey(8);
        System.out.println("Heap after deleting 8: " + minHeap.heap);
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
    minHeap.insert(5);
    minHeap.insert(3);
    minHeap.insert(8);
    minHeap.insert(1);

    std::cout << "Min Heap: ";
    for (int val : minHeap.getHeap()) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

    int minValue = minHeap.extractMin();
    std::cout << "Extracted Min Value: " << minValue << std::endl;

    std::cout << "Updated Min Heap: ";
    for (int val : minHeap.getHeap()) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

    int min = minHeap.getMin();
    std::cout << "Min Value: " << min << std::endl;

    minHeap.updateKey(3, 10);
    std::cout << "Updated Min Heap: ";
    for (int val : minHeap.getHeap()) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

    minHeap.deleteKey(8);
    std::cout << "Heap after deleting 8: ";
    for (int val : minHeap.getHeap()) {
        std::cout << val << " ";
    }
    std::cout << std::endl;

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

