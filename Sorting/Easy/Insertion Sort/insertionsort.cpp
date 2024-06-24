/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// C++ program to sort a given array in order using Insertion sort algorithm.

// Stable: Yes
// Inplace: Yes
// Adaptive: Yes
// Space complexity: O(1)
// Time Complexity: O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

#include<iostream>
// Include the input/output stream header file

using namespace std;
// Define the standard namespace for input/output operations

// Function to perform Insertion Sort on an array
void VSDInsertionSort(int arr[], int n) {
	// Iterate through each element of the array
    for (int i = 1; i < n; i++) {
        int temp = arr[i]; // Store the current element to be inserted
        int j = i;
        
		// Move elements greater than temp to the right until a smaller or equal element is found,
		// or until the beginning of the array is reached.
        while (j > 0 && arr[j - 1] > temp) {
            arr[j] = arr[j - 1]; // Shift the current element to the right, creating space for temp.
            j--;// Move to the previous position in the array to compare and potentially shift again.
        }
        arr[j] = temp; // Insert the stored element at its correct position
    }
    
    // Print the sorted array
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
    // Move to the next line after printing all elements
}

int main() {
    int n;

    cout << "Enter the size of the array: ";
    if (!(cin >> n)) {
        // Check if the input for array size is not an integer
        cout << "Error: Please enter a valid integer for the array size." << endl;
        return 1;
        // Return 1 to indicate an error
    }

    if (n <= 0) {
        // Check for non-positive array size
        cout << "Error: Array size must be a positive integer." << endl;
        return 1;
        // Return 1 to indicate an error
    }

    int arr[n];

    cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++) {
        if (!(cin >> arr[i])) {
            // Check if the input for array elements is not an integer
            cout << "Error: Please enter valid integers for array elements." << endl;
            return 1;
            // Return 1 to indicate an error
        }
    }

    VSDInsertionSort(arr, n);
    // Call the VSDInsertionSort function to sort the array
    return 0;
    // Return 0 to indicate successful execution of the program
}
