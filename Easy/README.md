# LINEAR SEARCH

Linear search is like looking for a specific thing in a room by checking each item, one by one, until you find what you're looking for or realize it's not there.

# Explanation Steps

        (1) Think of a room filled with items (an array with elements).
        (2) You're given a specific item you want to find in the room (the target element).
        (3) You start looking from one side of the room (the beginning of the array).
        (4) You check each item (element) one by one.
        (5) For each item, you compare it with the one you're looking for.
        (6) If you find the item you're looking for, you stop searching and say you found it.
        (7) If you haven't found it, you keep checking the next items.
        (8) You continue until you've checked every item in the room.
        (9) If you found your item, you know where it is (the index in the array). If you checked everything and didn't find it, you know it's not there.

# Advantages of linear search
        - Simplicity
        - Applicability
        - Ease of Implementation
        - Memory Efficiency
        - Optimal for Small Lists

# Drawbacks of Linear Search:
        - Linear search has a time complexity of O(N), 
        - which in turn makes it slow for large datasets.
        - Not suitable for large arrays.

# use Linear Search :
        - When we are dealing with a small dataset.
        - When you are searching for a dataset stored in contiguous memory.
        - Debugging and Verification
        - User Interface (UI) Elements
        - data Valdation
        - Sequential File Search
         Online search Engines 


# Overview of Linear Search Algorithm
Linear search is a simple searching algorithm that sequentially checks each element in a list or an 
array until a match is found or the entire list has been traversed. It's also known as a sequential search.

# Code for Linear Search in Pyhton, Java and C++

     python     

```python
# Function to perform linear search in a list
def linear_search(array, element):
    # Check for empty or None array
    if array is None or not array:
        print("Invalid input array")
        return

    # Iterate through the array to find the element
    for idx, val in enumerate(array):
        # If the element is found, print its index and exit the function
        if val == element:
            print(f"The element {element} found at index {idx} in the given array")
            return
    
    # If the element is not found in the array, print a message
    print(f"The element {element} not found in the given array")

# Test list and target element
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 10

# Perform linear search on the list for the target element
linear_search(arr, target)
```


# Explanation of the Code
    - Function Definition:
        The linear_search function takes in two parameters: array (the list to be searched) and element (the value being searched for).
    - Iterating through the List:
        It uses a for loop with enumerate to iterate through each element in the list array.
        enumerate allows simultaneous access to both the index (idx) and the value (val) of each element in the list.
    - Checking for a Match:
        Inside the loop, it checks if the current element val matches the element being searched for.
        If a match is found, it prints a message indicating the element and its index and returns from the function, ending the search.
    - Completion of Loop:
        If the loop completes without finding a match (i.e., the return statement is not triggered), it implies that the element is not present in the list.
        In that case, it prints a message indicating that the element is not found in the given array.
    - Test Drive Code:
        The arr variable holds the list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], and target is set to 10, which is the element being searched for.
    - Function Call:
        The linear_search function is called with the array arr and the target target as arguments to search for the element in the list.

# Time Complexity and Space Complexity
    - Time Complexity:
        In the worst-case scenario, the linear search algorithm has a time complexity of O(n), where n is the number of elements in the list. This is because it might need to traverse the entire list to find the element or determine that it's not present.
        The average and best-case time complexities are also O(n) since the search might terminate at any position in the list.
    - Space Complexity:
        The space complexity of the linear search algorithm is O(1) since it doesn't require any extra space proportional to the input size. It only uses a few variables for iteration and comparison.
        
# JAVA CODE 

```java
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
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;

        // Perform linear search on the array for the target element
        linearSearch(arr, target);
    }
}
```


# Explanation of the Code
    - Function Definition:
        The linearSearch method is static and void, taking two parameters: array (the array to be searched) and element (the value being searched for).
    - Iterating through the Array:
        It uses a for loop to iterate through each element in the array array.
        The loop runs from index 0 to the length of the array (array.length - 1).
    - Checking for a Match:
        Inside the loop, it checks if the current element at index idx matches the element being searched for.
        If a match is found, it prints a message indicating the element and its index and returns from the method, terminating the search.
    - Completion of Loop:
        If the loop completes without finding a match, it implies that the element is not present in the array.
        In that case, it prints a message indicating that the element is not found in the given array.
    - Test Drive Code:
        The main method initializes an array arr with values [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], and target is set to 10, which is the element being searched for.
    - Function Call:
        The linearSearch method is called with the array arr and the target target as arguments to search for the element in the array.


# C++ Code

'''
```c++
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
```
''' 


# Explanation of the Code
    - Function Definition:
        The linearSearch function takes three parameters: arr (the array to be searched), size (the size of the array), and element (the value being searched for).
    - Iterating through the Array:
        It uses a for loop to iterate through each element in the array arr.
        The loop runs from index 0 to size - 1, where size represents the length of the array.
    - Checking for a Match:
        Inside the loop, it checks if the current element at index idx matches the element being searched for.
        If a match is found, it prints a message indicating the element and its index and returns from the function, terminating the search.
    - Completion of Loop:
        If the loop completes without finding a match, it implies that the element is not present in the array.
        In that case, it prints a message indicating that the element is not found in the given array.
    - Test Drive Code:
        The main function initializes an array arr with values [1, 2, 3, 4, 5, 6, 7, 8, 9, 10].
        The size of the array is calculated using sizeof(arr) / sizeof(arr[0]) to ensure the accurate size is passed to the function.
        target is set to 10, which is the element being searched for.
    - Function Call:
        The linearSearch function is called with the array arr, its size size, and the target target as arguments to search for the element in the array.


# Real-world Applications
    - Database Operations:
        Linear search can be used in databases for basic search operations on unsorted datasets.
        Finding Elements in Lists or Arrays:
        It's applicable in scenarios where finding a specific element in a collection of data is required.
    - Simple Search Operations:
        Linear search can be applied in various programming scenarios where a basic search operation is needed and the dataset isn't too large.
    - Handling Small Lists or Arrays:
        It's efficient for small lists or arrays where the overhead of implementing complex search algorithms might not be justified.
        Linear search, although straightforward, serves as a fundamental algorithmic concept and is often used as a starting point for understanding more complex searching algorithms.


