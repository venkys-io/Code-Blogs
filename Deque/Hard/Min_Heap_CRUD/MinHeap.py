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
