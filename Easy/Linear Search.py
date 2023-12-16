# Python Code 

# Function to search for an element using linear search
# Takes an array and the element to find as parameters
def linear_search(array, element):
    for idx, val in enumerate(array):  # Using enumerate for a more Pythonic way to iterate with index
        if val == element:
            print(f"The element {element} found at index {idx} in the given array")
            return  # No need to continue searching if the element is found
    else:
        print(f"The element {element} not found in the given array")

# Test drive code
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
target = 10
linear_search(arr, target)
