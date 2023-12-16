#include <iostream>

// Function to perform linear search in an array
void linearSearch(int arr[], int size, int element) {
    // Check for null array or non-positive size
    if (arr == nullptr || size <= 0) {
        std::cout << "Invalid input array" << std::endl;
        return;
    }

    // Iterate through the array to find the element
    for (int idx = 0; idx < size; idx++) {
        // If the element is found, print its index and exit the function
        if (arr[idx] == element) {
            std::cout << "The element " << element << " found at index " << idx << " in the given array" << std::endl;
            return;
        }
    }
    // If the element is not found in the array, print a message
    std::cout << "The element " << element << " not found in the given array" << std::endl;
}

int main() {
    // Test array and target element
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size = sizeof(arr) / sizeof(arr[0]);
    int target = 10;

    // Perform linear search on the array for the target element
    linearSearch(arr, size, target);
    return 0;
}
