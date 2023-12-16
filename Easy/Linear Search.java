public class LinearSearch {

    // Function to perform linear search in an array
    static void linearSearch(int[] array, int element) {
        // Check for null or empty array
        if (array == null || array.length == 0) {
            System.out.println("Invalid input array");
            return;
        }

        // Iterate through the array to find the element
        for (int idx = 0; idx < array.length; idx++) {
            // If the element is found, print its index and exit the function
            if (array[idx] == element) {
                System.out.printf("The element %d found at index %d in the given array%n", element, idx);
                return;
            }
        }
        // If the element is not found in the array, print a message
        System.out.printf("The element %d not found in the given array%n", element);
    }

    public static void main(String[] args) {
        // Test array and target element
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 10;

        // Perform linear search on the array for the target element
        linearSearch(arr, target);
    }
}
