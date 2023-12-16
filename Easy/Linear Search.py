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