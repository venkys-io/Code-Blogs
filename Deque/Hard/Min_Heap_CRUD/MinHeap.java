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