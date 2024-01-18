# Quick sort
Quick sort is a popular sorting algorithm that follows the divide-and-conquer approach. It is efficient for large datasets and has an average time complexity of O(n log n).
The algorithm works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The process is then repeated recursively for the sub-arrays until the entire array is sorted.
Quick sort is known for its simplicity and effectiveness, making it a commonly used sorting algorithm in various programming languages.

## Overview
 Divide :The algorithm divides the array into two partitions or subarrays. This is typically done by selecting a "pivot" element from the array.

Partition: Rearrange the elements in the array such that all elements less than the pivot are on the left side, and all elements greater than the pivot are on the right side. The pivot itself is placed in its final position.

Conquer: Recursively apply the QuickSort algorithm to the subarrays on the left and right of the pivot.

Combine: The sorted subarrays are combined to produce the final sorted array.

The key to the efficiency of QuickSort lies in the partitioning step. Choosing a good pivot is crucial. Common strategies include selecting the first or last element as the pivot, or choosing a random element. The goal is to have a pivot that roughly divides the array into two equal parts.
## Code in Python
```
#  Copyrights to venkys.io
#  For more information, visit https://venkys.io

def quicksort(arr, l, r):
    # Base case: If there is more than one element in the array
    if l < r:
        # Choose the pivot index
        p = l + (r - l) // 2
        pivot = arr[p]
        i = l
        j = r

        # Partition the array around the pivot
        while i <= j:
            while arr[i] < pivot:
                i += 1
            while arr[j] > pivot:
                j -= 1

            if i <= j:
                # Swap elements at positions i and j
                if arr[i] == pivot:
                    p = j
                if arr[j] == pivot:
                    p = i
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1

        # Recursively sort the subarrays
        quicksort(arr, l, p)
        quicksort(arr, p + 1, r)

if __name__ == "__main__":
    # Get input from the user
    n = int(input("Enter the number of elements: "))
    arr = list(map(int, input("Enter the elements separated by space: ").split()))

    # Perform quicksort
    quicksort(arr, 0, len(arr) - 1)

    # Display the sorted array
    print("Sorted array:", *arr)

```
## Step by Step Explanation
- Function Definition (def quicksort(arr, l, r):): Defines the quicksort function that will be used to sort the array.
- Input Section (if __name__ == "__main__":): Checks if the script is being run as the main program.
- User Input (n = int(input("Enter the number of elements: ")) and arr = list(map(int, input("Enter the elements separated by space: ").split()))): Prompts the user to input the number of elements and the array.
- Function Call (quicksort(arr, 0, len(arr) - 1)): Calls the quicksort function with the user-input array and indices.
- Print Sorted Array (print("Sorted Array:", *arr)): Prints the sorted array after the quicksort algorithm is applied. The *arr syntax is used to unpack the array elements for printing.

The quicksort function follows the standard steps of the quicksort algorithm, including choosing a pivot, partitioning the array, and recursively sorting the subarrays. The user input section ensures that the script can be used to sort any array provided by the user.
## Test case 1
- Input: Empty array
- n = 0
- arr = []
-  Expected Output: Empty Array
## Test case 2
- Input: Unsorted array 
- n = 7
- arr = [2, 24, 12, 96, 456, 899, 34]
- Expected Output: [2, 12, 24, 34, 96, 456, 899]
## Test case 3 
- Input: Unsorted array 
- n = 5
arr = [1, 2, 3, 4, -5]
- Expected Output:Input Array: [-5,1, 2, 3, 4,]



## code in Java
```
// Copyrights to venkys.io
// For more information, visit https://venkys.io

import java.util.Scanner;

public class Main {

    public static void VSDquicksort(int a[], int l, int r) {
        if (l < r) {
            int p = l + (r - l) / 2; // Taking index of pivot as the mid element of array
            int pivot = a[p]; // Taking pivot element
            int i = l, j = r; // Remembering initial array indices

            // Placing pivot at the right place
            while (l < r) {
                if (a[l] >= pivot && a[r] <= pivot) {
                    if (a[l] == pivot)
                        p = r; // When the place of pivot is changed, noting its index
                    if (a[r] == pivot)
                        p = l;
                    VSDswapElementsAt(a, l, r);
                    r--;
                } else if (a[l] > pivot && a[r] > pivot)
                    r--;
                else
                    l++;
            }

            // Recursively sorting remaining elements in the array
            VSDquicksort(a, i, p);
            VSDquicksort(a, p + 1, j);
        }
    }

    // Function to swap the elements of the array
    public static void VSDswapElementsAt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Function to print output
    public static void VSDprintOutput(int[] a) {
        System.out.println("The sorted order is:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.print("Enter the elements separated by space: ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        VSDquicksort(a, 0, n - 1);
        VSDprintOutput(a);
    }
}

```
## Step by Step Explanation
- Import Scanner:

import java.util.Scanner;: Import the Scanner class to get user input.
- Main Class:

- public class Main { /* ... */ }: Define the main class.
- QuickSort Method (VSDquicksort):

Perform QuickSort on the array.
Partition the array based on a pivot element.
Recursively sort subarrays.
- Swap Elements Method (VSDswapElementsAt):

Swap elements at two given indices in the array.
- Print Output Method (VSDprintOutput):

- Print the sorted array.
Main Method (main):

Create a Scanner object for user input.
Prompt the user for the number of elements and array elements.
Call VSDquicksort to sort the array.
Call VSDprintOutput to print the sorted array.
## Test case 1
- Input: Empty array
- n = 0
- arr = []
-  Expected Output: Empty Array
## Test case 2
- Input: Unsorted array 
- n = 7
- arr = [2, 24, 12, 96, 456, 899, 34]
- Expected Output: [2, 12, 24, 34, 96, 456, 899]
## Test case 3 
- Input: Unsorted array 
- n = 5
arr = [1, 2, 3, 4, -5]
- Expected Output:Input Array: [-5,1, 2, 3, 4,]

## code in C++
```
 // Copyrights to venkys.io
// For more information, visit https://venkys.io


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


```

## Step by Step Explanation
- Include iostream:

#include<iostream>: Include the iostream library for input and output.
- Swap Function:

void swap(int arr[], int i, int j): Function to swap elements at two indices in the array.
- QuickSort Function (quicksort):

Perform QuickSort on the array.
Partition the array based on a pivot element.
Recursively sort subarrays.
- Main Function:

- int main() { /* ... */ }: 

Main function, the entry point of the program.
Prompt the user for the number of elements.
User input for array elements.
Call quicksort to sort the array.
Print the sorted array.

Both codes perform the QuickSort algorithm on an array of user-input elements and print the sorted result. The Java code uses the Scanner class for input, while the C++ code uses cin and cout for input and output.
## Test case 1
- Input: Empty array
- n = 0
- arr = []
-  Expected Output: Empty Array
## Test case 2
- Input: Unsorted array 
- n = 7
- arr = [2, 24, 12, 96, 456, 899, 34]
- Expected Output: [2, 12, 24, 34, 96, 456, 899]
## Test case 3 
- Input: Unsorted array 
- n = 5
arr = [1, 2, 3, 4, -5]
- Expected Output:Input Array: [-5,1, 2, 3, 4,]
## Time and space complexity
### Time Complexity:

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n^2)

### Space Complexity:

Best Case: O(log n)

Average Case: O(log n)

Worst Case: O(n)
## Real time application
- Search Engines:

Quicksort is employed in the indexing and searching processes of search engines. Efficient sorting is crucial for quickly retrieving relevant search results.

- E-commerce Platforms:

In e-commerce systems, Quicksort can be used for sorting product listings based on various criteria such as price, popularity, or customer ratings.

- Telecommunications:

Quicksort is used in telecommunications for tasks like call routing and managing network data. Sorting helps optimize the routing of calls and the processing of data.

- Flight Scheduling and Air Traffic Control:

In the aviation industry, Quicksort can be utilized to sort and manage flight schedules efficiently. It helps in optimizing air traffic control systems and managing flight data.