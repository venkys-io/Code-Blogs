# Function to maintain max heap properties
# Function to maintain max heap properties
def VSDmaxHeapify(arr, size, i):
    # Declare current element index as largest element
    large = i

    # Find index of left child
    leftchild = (2 * i) + 1

    # Find index of right child
    rightchild = (2 * i) + 2

    # Check largest element between left child and current element
    if leftchild < size and arr[i] < arr[leftchild]:
        large = leftchild

    # Check largest element between right child and large element
    if rightchild < size and arr[large] < arr[rightchild]:
        large = rightchild

    # If large element is not the current element
    # Swap current element with large element
    # Heapify the current array
    if large != i:
        arr[large], arr[i] = arr[i], arr[large]
        VSDmaxHeapify(arr, size, large)


# Function to maintain min heap properties
def VSDminHeapify(arr, size, i):
    # Declare current element index as smallest
    small = i

    # Find index of left child
    leftchild = (2 * i) + 1

    # Find index of right child
    rightchild = (2 * i) + 2

    # Check smallest element between left child and current element
    if leftchild < size and arr[i] > arr[leftchild]:
        small = leftchild

    # Check smallest element between right child and smallest element
    if rightchild < size and arr[small] > arr[rightchild]:
        small = rightchild

    # If smallest element is not the current element
    # Swap smallest element and current element
    # Heapify the current array
    if small != i:
        arr[small], arr[i] = arr[i], arr[small]
        VSDminHeapify(arr, size, small)


# Function to insert elements into max heap
def insert(array, num):
    if len(array) == 0:
        array.append(num)
    else:
        array.append(num)
        for i in range(len(array)):
            VSDmaxHeapify(array, len(array), i)


# Function to sort the given array using max heap in ascending order
def VSDMaxheapsort(array):
    size = len(array)

    # Heapify the given array into max heap
    for i in range((size // 2) - 1, -1, -1):
        VSDmaxHeapify(array, size, i)

    # Find the max element in array
    # Swap the max element with last index element
    # Decrease the last index by 1
    # Heapify the current array up to the last index
    for i in range(size - 1, 0, -1):
        array[i], array[0] = array[0], array[i]
        VSDmaxHeapify(array, i, 0)


# Function to sort the given array using min heap in descending order
def VSDMinheapsort(array):
    size = len(array)

    # Heapify the given array into min heap
    for i in range((size // 2) - 1, -1, -1):
        VSDminHeapify(array, size, i)

    # Find the min element in array
    # Swap the min element with last index element
    # Decrease the last index by 1
    # Heapify the current array up to the last index
    for i in range(size - 1, -1, -1):
        array[0], array[i] = array[i], array[0]
        VSDminHeapify(array, i, 0)


# Function to print array
def printarray(array):
    for i in array:
        print(i, end=" ")
    print()


if __name__ == "__main__":
    # Taking user input for the array
    user_input = input("Enter numbers separated by spaces: ")
    arr = list(map(int, user_input.split()))

    print("Original array:")
    printarray(arr)

    # Sorting in ascending order using max heap sort
    VSDMaxheapsort(arr)
    print("Sorted array in ascending order:")
    printarray(arr)

    # Sorting in descending order using min heap sort
    VSDMinheapsort(arr)
    print("Sorted array in descending order:")
    printarray(arr)
