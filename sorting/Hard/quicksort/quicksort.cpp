#include<iostream>

using namespace std;

// Function to swap elements in an array
void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// Function to perform QuickSort
void quicksort(int arr[], int l, int r) {
    if (l < r) {
        int p = l + (r - l) / 2; // Calculate pivot index
        int pivot = arr[p]; // Get pivot element
        int i = l, j = r; // Initialize indices

        // Partitioning
        while (l < r) {
            if (arr[l] > pivot && arr[r] <= pivot) {
                if (arr[l] == pivot) p = r; // Update pivot index if needed
                if (arr[r] == pivot) p = l;
                swap(arr, l, r); // Swap elements
                r--;
            } else if (arr[l] > pivot && arr[r] > pivot) r--;
            else l++;
        }

        // Recursively sort remaining elements
        quicksort(arr, i, p);
        quicksort(arr, p + 1, j);
    }
}

// Main function
int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    int arr[n];

    // User input for array elements
    cout << "Enter the elements separated by space: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // Perform QuickSort on the array
    quicksort(arr, 0, n - 1);

    // Print the sorted array
    cout << "The sorted order is: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}
