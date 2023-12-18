import functools as f

# Custom comparison function for sorting strings
def compare(x, y):
    return (x < y) - (x > y)

# Function to find the largest number by concatenating elements of the list
def largestNumber(nums):
    # Convert the list of integers to a list of strings
    arr = list(map(str, nums))
    
    # Sort the list of strings using a custom comparison function
    arr.sort(key=f.cmp_to_key(lambda x, y: compare(x + y, y + x)))

    # Join the sorted strings, remove leading zeros, or return "0" if the result is empty
    return "".join(arr).lstrip("0") or "0"

# Main block
if __name__ == "__main__":
    # Convert the input string to a list of integers
    nums=[int(x) for x in input("Enter multiple value: ").split(" ")]
    # print the list
    print(nums)
    # Call the function and print the result
    result = largestNumber(nums)
    print(f"The largest number is: {result}")
