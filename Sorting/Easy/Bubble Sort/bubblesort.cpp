/*Copyrights to venkys.io*/
/*For more programs visit venkys.io */
/*C++ program for Bubble sort*/
//Stable: Yes
//Inplace: Yes
//Adaptive: No
//Time Complexity: Best case - O(n), Average and worst case - O(n^2)
//Space Complexity: O(1)

#include <iostream>
// Include the input/output stream header file

using namespace std;
// Namespace identifies the code is part of the standard library

void swap(int array[], int i, int j)
// Swapping function to swap two elements when compared adjacently through a temporary variable 'temp'
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

// Function to perform bubble sort on an array
void bubbleSort(int array[], int n)
{
    // Check for null or negative array size
    if (array == NULL || n <= 0)
    {
        cerr << "Error: Invalid array size or null pointer. Exiting.\n";
        return;
    }

    // Outer loop: Iterate through each element in the array (except the last one)
    for (int i = 0; i < n - 1; i++)
    {
        // Inner loop: Compare and swap adjacent elements to move the largest element to the end
        for (int j = 0; j < n - i - 1; j++)
        {
            // Check for null pointer in array
            if (array == NULL)
            {
                cerr << "Error: Null pointer in array. Exiting.\n";
                return;
            }

            // Check if the current element is greater than the next element
            if (array[j] > array[j + 1])
            {
                // Swap the current and next elements if they are in the wrong order
                swap(array, j, j + 1);
            }
        }
    }

    // Display the sorted array
    cout << "Sorted Array: ";
    for (int k = 0; k < n; k++)
    {
        cout << array[k] << " "; // Print each element of the sorted array
    }
    cout << endl; // Move to the next line after printing the sorted array
}

int main()
{
    // Prompt the user to enter the size of the array
    cout << "Enter the size of the array: ";
    int n; // Declare a variable 'n' to store the size of the array

    // Check for invalid input (non-numeric or negative size)
    if (!(cin >> n) || n <= 0)
    {
        cerr << "Error: Invalid input for array size. Exiting.\n";
        return 1;
    }

    // Dynamically allocate memory for an integer array of size 'n'
    int *array = new int[n];

    // Prompt the user to enter the elements of the array
    cout << "Enter the elements of the array: ";
    // Loop to read 'n' elements and store them in the dynamically allocated array
    for (int i = 0; i < n; i++)
    {
        // Check for invalid input (non-numeric)
        if (!(cin >> array[i]))
        {
            cerr << "Error: Invalid input for array element. Exiting.\n";
            delete[] array; // Free dynamically allocated memory before exiting
            return 1;
        }
    }

    // Calling the bubble Sort function to sort the array
    bubbleSort(array, n);

    delete[] array; // Freeing allocated memory

    return 0;
}
