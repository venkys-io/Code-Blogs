/*Copyrights to venkys.io
For more information, visit https://venkys.io"/

C++ program to sort a given array in order using Shell sort algorithm. */

// Stable: No
// Inplace: Yes
// Adaptive: Yes

// Space complexity: O(1) - sorts in place

// Time Complexity: O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

#include<iostream>
#include<vector> // Container to hold elements
#include<string> // String representation for input
#include<sstream> // To convert string input into integer
using namespace std; // Namespace identifies the code as part of the standard library

// Function to perform Shell Sort on the given array
void shellSort(int arr[], int n) {
    int shellsize = 8;

    // Iterate through decreasing gap sizes until the gap is 1
    while (shellsize >= 1) {
        for (int i = shellsize, k = 0; i < n && k < shellsize;) {
            int key = arr[i];
            int j = i - shellsize;

            // Compare and shift elements to make room for the key
            for (; j >= 0; j -= shellsize) {
                if (arr[j] > key) {
                    arr[j + shellsize] = arr[j];
                } else {
                    break;
                }
            }

            // Insert the key at the correct position in the sorted sequence
            arr[j + shellsize] = key;

            // Update indices for the next iteration
            if (i + shellsize >= n) {
                k += 1;
                i = k + shellsize;
            } else {
                i += shellsize;
            }
        }

        // Reduce the gap size for the next iteration
        shellsize = shellsize / 2;
    }

    // Print the sorted array
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

int main() {
    string input;

    // Prompt the user to enter the elements separated by space
    cout << "Enter the elements separated by space: ";

    // Read the entire line of input
    getline(cin, input);

    // If the input is empty, print an error message and exit
    if (input.empty()) {
        cout << "Error: Empty input. Please provide elements to sort." << endl;
        return 1; // Return 1 to indicate an error
    }

    // Parse the input string and convert it into an array of integers
    stringstream ss(input);
    vector<int> elements;
    int num;

    // Continue parsing until the end of the stringstream
    while (ss >> num) {
        elements.push_back(num);
    }

    // If the parsed elements vector is empty, print an error message and exit
    if (elements.empty()) {
        cout << "Error: No valid integers found in the input. Please provide valid elements." << endl;
        return 1; // Return 1 to indicate an error
    }

    int n = elements.size();

    // If the array size is less than or equal to 0, print an error message and exit
    if (n <= 0) {
        cout << "Error: Invalid array size. Please enter a positive integer for the array size." << endl;
        return 1; // Return 1 to indicate an error
    }

    int arr[n];

    // Copy elements from the vector to the array
    for (int i = 0; i < n; i++) {
        arr[i] = elements[i];
    }

    // Call the shellSort function to sort the array
    shellSort(arr, n);

    return 0; // Return 0 to indicate successful execution of the program
}
