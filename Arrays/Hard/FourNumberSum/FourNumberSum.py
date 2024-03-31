# Copyrights to venkys.io
# For more programs visit venkys.io 
# Python program for FourNumberSum

#Time Complexity : O(n^k-1)
#Space Complexity : O(n^k-1)+O(k)

def twosum(arr, target):
    """
    Helper function for finding pairs that sum up to the target.
    """
    res = []
    low, high = 0, len(arr) - 1

    while low < high:
        # Calculate the current sum of elements at low and high indices
        cursum = arr[low] + arr[high]
        
        # Check conditions to adjust low and high indices
        if cursum < target or (low > 0 and arr[low] == arr[low - 1]):
            low += 1
        elif cursum > target or (high < len(arr) - 1 and arr[high] == arr[high + 1]):
            high -= 1
        else:
            # Append the pair to the result and move indices
            res.append([arr[low], arr[high]])
            low += 1
            high -= 1
    return res


def ksum(arr, target, k):
    """
    Main function for finding k elements that sum up to the target.
    """
    res = []
    if not arr:
        # Return an empty list if the input array is empty
        return res

    avg = target // k

    # Check if the average is outside the range of the array
    if avg < arr[0] or avg > arr[-1]:
        return res

    if k == 2:
        # If k is 2, call the twosum function
        return twosum(arr, target)
    
    for i in range(len(arr)):
        # Iterate through the array and avoid duplicate elements
        if i == 0 or arr[i - 1] != arr[i]:
            # Recursive call to find (k-1)-sum in the rest of the array
            for s in ksum(arr[i + 1:], target - arr[i], k - 1):
                # Append the current element to the solution
                res.append([arr[i]] + s)
    return res
if __name__ == "__main__":
    # Read the array from STDIN
    arr_input = input()
    target_input = input()
    k_input = input()

    # Check if inputs are provided
    if not arr_input or not target_input or not k_input:
        print("Please provide valid inputs.")
        exit()

    try:
        # Convert inputs to the required types
        arr = list(map(int, arr_input.split()))
        target = int(target_input)
        k = int(k_input)
    except ValueError:
        print("Invalid input. Please enter valid numbers.")
        exit()

    arr.sort()
    # Call the ksum function with the input values
    result = ksum(arr, target, k)

    # Print the result
    print(result)
