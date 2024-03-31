# Copyrights to venkys.io
# For more programs visit venkys.io
# Python program for PrefixSum

def prefixSum(arr):
    # Iterate through the array starting from index 1
    for i in range(1, len(arr)):
        # Update each element by adding the value of the preceding element
        arr[i] += arr[i - 1]
    # Print the resulting array after the prefix sum calculation
    print(*arr)

if __name__ == "__main__":
    # Read input from stdin
    input_str = input()

    # Convert the input string to an array (list) of integers
    arr = [int(num) for num in input_str.split()]

    # Call the prefixSum function with the input array
    prefixSum(arr)
