import java.util.ArrayList;
import java.util.List;

// Class representing a max heap with CRUD operations
class MaxHeapCRUD {
    private List<Integer> heap;

    // Constructor initializes an empty list for the heap
    public MaxHeapCRUD() {
        this.heap = new ArrayList<>();
    }

    // Move the element up the heap until the heap property is restored
    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) >= heap.get(index)) {
                break;
            }
            // Swap the current element with its parent
            int temp = heap.get(parent);
            heap.set(parent, heap.get(index));
            heap.set(index, temp);
            index = parent;
        }
    }

    // Ensure the heap property is maintained starting from the given index
    private void maxHeapify(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        // Check if the left child is larger than the current largest element
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        // Check if the right child is larger than the current largest element
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If the largest element is not the current index, swap and continue heapifying
        if (largest != index) {
            int temp = heap.get(largest);
            heap.set(largest, heap.get(index));
            heap.set(index, temp);
            maxHeapify(largest);
        }
    }

    // Add a new element to the heap and percolate it up to maintain the heap property
    public void insert(int val) {
        heap.add(val);
        percolateUp(heap.size() - 1);
    }

    // Return the maximum element in the heap (root of the heap)
    public int getMax() {
        if (heap.size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    // Update the value, percolate up, and max heapify to maintain the heap property
    public void update(int oldVal, int newVal) {
        int index = heap.indexOf(oldVal);
        if (index != -1) {
            heap.set(index, newVal);
            percolateUp(index);
            maxHeapify(index);
        } else {
            System.out.println("Value not in heap");
        }
    }

    // Replace the root with the last element, pop the last element, and max heapify
    public void deleteMax() {
        if (heap.size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        heap.set(0, heap.remove(heap.size() - 1));
        maxHeapify(0);
    }

    // Print all values in the heap
    public void printHeap() {
        for (int i : heap) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Main method demonstrating usage of the MaxHeapCRUD class
    public static void main(String[] args) {
        MaxHeapCRUD heap = new MaxHeapCRUD();

        heap.insert(12);
        heap.insert(10);
        heap.insert(52);
        heap.insert(100);
        heap.insert(50);

        System.out.print("All values in heap: ");
        heap.printHeap();

        System.out.println("Max Value: " + heap.getMax());

        heap.update(12, 5);

        System.out.println("Max Value after update: " + heap.getMax());

        heap.deleteMax();

        System.out.println("Max Value after deletion: " + heap.getMax());

        System.out.print("All values in heap: ");
        heap.printHeap();
    }
}