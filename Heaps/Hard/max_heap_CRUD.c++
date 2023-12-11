#include <iostream>
#include <vector>
#include <algorithm>

class MaxHeap {
private:
    std::vector<int> heap;

    // Move the element up the heap until the heap property is restored
    void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] >= heap[index]) {
                break;
            }
            std::swap(heap[parent], heap[index]);
            index = parent;
        }
    }

    // Ensure the heap property is maintained starting from the given index
    void maxHeapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        // Check if the left child is larger than the current largest element
        if (left < heap.size() && heap[left] > heap[largest]) {
            largest = left;
        }
        // Check if the right child is larger than the current largest element
        if (right < heap.size() && heap[right] > heap[largest]) {
            largest = right;
        }

        // If the largest element is not the current index, swap and continue heapifying
        if (largest != index) {
            std::swap(heap[largest], heap[index]);
            maxHeapify(largest);
        }
    }

public:
    // Add a new element to the heap and percolate it up to maintain the heap property
    void insert(int val) {
        heap.push_back(val);
        percolateUp(heap.size() - 1);
    }

    // Return the maximum element in the heap (root of the heap)
    int getMax() {
        if (heap.size() == 0) {
            throw "Heap is empty";
        }
        return heap[0];
    }

    // Update the value, percolate up, and max heapify to maintain the heap property
    void update(int old_val, int new_val) {
        auto it = std::find(heap.begin(), heap.end(), old_val);
        if (it != heap.end()) {
            *it = new_val;
            percolateUp(it - heap.begin());
            maxHeapify(it - heap.begin());
        } else {
            std::cout << "Value not in heap" << std::endl;
        }
    }

    // Replace the root with the last element, pop the last element, and max heapify
    void deleteMax() {
        if (heap.size() == 0) {
            throw "Heap is empty";
        }
        heap[0] = heap.back();
        heap.pop_back();
        maxHeapify(0);
    }

    // Print all values in the heap
    void printHeap() {
        for (int i : heap) {
            std::cout << i << " ";
        }
        std::cout << std::endl;
    }
};

int main() {
    // Example usage of the MaxHeap class
    MaxHeap heap;

    heap.insert(12);
    heap.insert(10);
    heap.insert(-10);
    heap.insert(100);
    
    std::cout << "All values in heap: ";
    heap.printHeap();

    std::cout << "Max Value: " << heap.getMax() << std::endl;

    heap.update(12, 5);
    std::cout << "Max Value after update: " << heap.getMax() << std::endl;

    heap.deleteMax();
    std::cout << "Max Value after deletion: " << heap.getMax() << std::endl;

    std::cout << "All values in heap: ";
    heap.printHeap();

    return 0;
}
