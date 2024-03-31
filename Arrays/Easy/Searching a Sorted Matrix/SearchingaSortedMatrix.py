# Copyrights to venkys.io
# For more programs visit venkys.io 
# Python program for Searching a sorted Matrix

# time complexity:O(m*n)
# space complexity:O(1)

# Define a function named searchMatrix that takes a 2D matrix and a target integer as input
def searchMatrix(matrix, target: int):
    # Get the number of rows in the matrix
    rows = len(matrix)
    # Get the number of columns in the matrix
    cols = len(matrix[0])
    # Calculate the total number of elements in the matrix
    items = rows * cols
    # Initialize low and high for binary search
    low = 0
    high = items - 1
    
    # Perform binary search on the matrix
    while low <= high:
        # Calculate the middle index
        mid = (low + high) // 2
        # Calculate the element at the middle index in the matrix
        temp = matrix[mid // cols][mid % cols]
        
        # Check if the target is equal to the middle element
        if temp == target:
            return True
        # If the target is less than the middle element, update the high index
        elif target < temp:
            high = mid - 1
        # If the target is greater than the middle element, update the low index
        else:
            low = mid + 1
    
    # If the target is not found, return False
    return False

#test drive code:
if __name__ == "__main__":
    # Matrix
    rows, cols = map(int, input().split())

    # Initialize an empty matrix
    matrix = []

    # Input each row of the matrix
    for _ in range(rows):
        row = list(map(int, input().split()))
        matrix.append(row)
    # Target integer
    target = 3
    # Check if the target is found in the matrix using the searchMatrix function
    if searchMatrix(matrix, target):
        print("True")
    else:
        print("False")

```

The output of the above test case

```output
    3 is found in the matrix
```
