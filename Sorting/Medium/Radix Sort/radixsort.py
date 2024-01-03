'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using radix sort algorithm.'''

# Stable : Yes
# Inplace : Yes
# Adaptive : No

# Space complexity: O(n+k) where
  # n = number of elements in the input array
  # k = range of input values (number of unique digits)

#Time Complexity: O(d*(n+k)) /O(n+k) in simplified version
  # n=no. of elements
  # k= range of input values
  # d= no. of digits in maximum value

"""
    Perform counting sort on the array based on the given exponent.

    Parameters:
    arr (list): The input list to be sorted.
    exp (int): The exponent used for counting sort.

    Returns:
    None. Modifies the input array in-place.
    """
def counting_sort(arr, exp):
    n = len(arr)
    # Initialize an output array with zeros
    output = [0] * n
    # Initialize a count array to store the count of occurrences for each digit (0 to 9)
    count = [0] * 10

    # Count occurrences of each digit based on the given exponent
    for i in range(n):
        index = arr[i] // exp
        count[index % 10] += 1

    # Modify the count array to store the cumulative count of occurrences
    for i in range(1, 10):
        count[i] += count[i - 1]

    # Build the output array using the count information
    i = n - 1
    while i >= 0:
        index = arr[i] // exp
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    # Copy the sorted elements from the output array to the original array
    for i in range(n):
        arr[i] = output[i]

"""
    Perform radix sort on the given array.

    Parameters:
    arr (list): The input list to be sorted.

    Returns:
    list: The sorted array.
    """
def radix_sort(arr):
    # Find the maximum number in the array to determine the number of digits in it
    max_num = max(arr)
    # Initialize the exponent (exp) to the least significant digit
    exp = 1
    # Loop until all digits are processed, from the least significant to the most significant
    while max_num // exp > 0:
        # Call the counting_sort function to sort the array based on the current exponent
        counting_sort(arr, exp)
        # Move to the next significant digit by multiplying the exponent by 10
        exp *= 10
    # Return the sorted array
    return arr


def main():
    try:
        arr = list(map(int, input("Enter the elements of the array separated by space: ").split()))
        # Check if the array is empty, and raise a ValueError if it is
        if len(arr) == 0:
            raise ValueError("Array is empty.")

        print('The given array is', arr)# Display the original array
        sorted_arr = radix_sort(arr.copy())  # Sorting a copy to keep the original array intact
        print('The sorted order is:', sorted_arr) # Display the sorted array

    except ValueError as e:
         # Handle ValueError exceptions (e.g., empty array)
        print(f"Error: {e}")

# Check if the script is being run as the main program
if __name__ == "__main__":
    main()
