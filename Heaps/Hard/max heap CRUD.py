class MaxHeap:
    def __init__(self):
        # Initialize an empty list to represent the heap
        self.heap = []

    def percolate_up(self, index):
        # Move the element up the heap until the heap property is restored
        while index > 0:
            parent = (index - 1) // 2
            if self.heap[parent] >= self.heap[index]:
                break
            # Swap the current element with its parent
            self.heap[parent], self.heap[index] = self.heap[index], self.heap[parent]
            index = parent

    def max_heapify(self, index):
        # Ensure the heap property is maintained starting from the given index
        left = 2 * index + 1
        right = 2 * index + 2
        largest = index

        # Check if the left child is larger than the current largest element
        if left < len(self.heap) and self.heap[left] > self.heap[largest]:
            largest = left
        # Check if the right child is larger than the current largest element
        if right < len(self.heap) and self.heap[right] > self.heap[largest]:
            largest = right

        # If the largest element is not the current index, swap and continue heapifying
        if largest != index:
            self.heap[largest], self.heap[index] = self.heap[index], self.heap[largest]
            self.max_heapify(largest)

    def insert(self, val):
        # Add a new element to the heap and percolate it up to maintain the heap property
        self.heap.append(val)
        self.percolate_up(len(self.heap) - 1)

    def get_max(self):
        # Return the maximum element in the heap (root of the heap)
        if len(self.heap) == 0:
            raise Exception("Heap is empty")
        return self.heap[0]

    def update(self, old_val, new_val):
        try:
            # Find the index of the old value in the heap
            index = self.heap.index(old_val)
            # Update the value, percolate up, and max heapify to maintain the heap property
            self.heap[index] = new_val
            self.percolate_up(index)
            self.max_heapify(index)
        except ValueError:
            print("Value not in heap")

    def delete_max(self):
        if len(self.heap) == 0:
            raise Exception("Heap is empty")
        # Replace the root with the last element, pop the last element, and max heapify
        self.heap[0] = self.heap.pop()
        self.max_heapify(0)

    def print_heap(self):
        # Print all values in the heap
        print(" ".join(map(str, self.heap)))

def main():
    # Initialize max heap
    heap = MaxHeap()

    # Insert elements into heap
    heap.insert(12)
    heap.insert(10)
    heap.insert(-10)
    heap.insert(100)

    # Print all values in heap
    heap.print_heap()

    # Get max value in heap
    print("Max Value:", heap.get_max())

    # Update value in heap
    heap.update(12, 5)
    print("Max Value after update:", heap.get_max())

    # Delete max value from heap
    heap.delete_max()
    print("Max Value after deletion:", heap.get_max())

    # Print all values in heap after deletion
    heap.print_heap()