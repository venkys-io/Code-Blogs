import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// MaxHeapCRUD class representing a max heap with CRUD operations
public class MaxHeapCRUD {
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
        if (heap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return heap.get(0);
    }

    // Delete the element at the specified index from the heap
    public void delete(int index) {
        if (index < 0 || index >= heap.size()) {
            throw new RuntimeException("Invalid index");
        }
        // Swap the element with the last element
        heap.set(index, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        // Max heapify to maintain the heap property
        maxHeapify(index);
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

        // Insert, delete, fetch, and print elements into/from the heap using user input
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Insert element");
                System.out.println("2. Get max element");
                System.out.println("3. Delete element at index");
                System.out.println("4. Print heap");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter an integer to insert into the heap: ");
                            heap.insert(scanner.nextInt());
                            break;
                        case 2:
                            try {
                                System.out.println("Max Value: " + heap.getMax());
                            } catch (RuntimeException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.print("Enter the index to delete: ");
                            int deleteIndex = scanner.nextInt();
                            try {
                                heap.delete(deleteIndex);
                                System.out.println("Element at index " + deleteIndex + " deleted");
                            } catch (RuntimeException e) {
                                System.err.println(e.getMessage());
                            }
                            break;
                        case 4:
                            System.out.print("All values in heap: ");
                            heap.printHeap();
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            System.exit(0);
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    // Clear the scanner buffer to avoid an infinite loop on invalid input
                    scanner.next();
                }
            }
        }
    }
}
