// Java Code

public class LinearSearch {

    // Function to search for an element using linear search
    // Takes an array and the element to find as parameters
    static void linearSearch(int[] array, int element) {
        for (int idx = 0; idx < array.length; idx++) {
            if (array[idx] == element) {
                System.out.printf("The element %d found at index %d in the given array%n", element, idx);
                return;  // No need to continue searching if the element is found
            }
        }
        System.out.printf("The element %d not found in the given array%n", element);
    }

    // Test drive code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        linearSearch(arr, target);
    }
}
