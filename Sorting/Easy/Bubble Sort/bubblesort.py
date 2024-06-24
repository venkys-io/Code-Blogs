# Copyrights to venkys.io
# For more programs visit venkys.io
# Python program for Bubble sort

# Stable: Yes
# Inplace: Yes
# Adaptive: No
# Time Complexity: Best case - O(n), Average and worst case - O(n^2)
# Space Complexity: O(1)

# Function to perform Bubble Sort on given array
'''
Parameters:
    - array (list): The list to be sorted.

Returns:
    - list: The sorted list.
'''
def bubbleSort(array):
    n = len(array)

    # Traverse through all elements
    for i in range(n):
        # Last i elements are already sorted, so we don't check them
        for j in range(0, n - i - 1):
            # Compare adjacent elements, Swap if the elements found is greater than the next element
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]

    # The sorted array is returned
    return array


def main():
    try:
        # Taking input from the user
        array = list(map(int, input("Enter the array elements separated by space:").split()))

        # Check if the array is empty
        if not array:
            print("Array is empty. No elements to sort.")
            return

        # Calling the bubble Sort Function
        sorted_array = bubbleSort(array)

        # Printing the sorted array
        print("Sorted Array:", sorted_array)

    except ValueError as ve:
        print(f"Error: {ve}")

if __name__ == "__main__":
    main()
