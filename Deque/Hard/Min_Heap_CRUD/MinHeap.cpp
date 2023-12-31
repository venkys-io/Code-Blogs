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