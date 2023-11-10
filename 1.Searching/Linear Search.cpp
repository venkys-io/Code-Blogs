// C++ Code

// Function to search for an element using linear search
// Takes an array and the element to find as parameters
void linearSearch(int arr[], int size, int element) {
    for (int idx = 0; idx < size; idx++) {
        if (arr[idx] == element) {
            std::cout << "The element " << element << " found at index " << idx << " in the given array" << std::endl;
            return;  // No need to continue searching if the element is found
        }
    }
    std::cout << "The element " << element << " not found in the given array" << std::endl;
}

// Test drive code
int main() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int size = sizeof(arr) / sizeof(arr[0]);  // Calculate the size of the array
    int target = 10;
    linearSearch(arr, size, target);
    return 0;
}
