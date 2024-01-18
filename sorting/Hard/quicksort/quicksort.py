def quicksort(arr, l, r):
    # Base case: If there is more than one element in the array
    if l < r:
        # Choose the pivot index
        p = l + (r - l) // 2
        pivot = arr[p]
        i = l
        j = r

        # Partition the array around the pivot
        while i <= j:
            while arr[i] < pivot:
                i += 1
            while arr[j] > pivot:
                j -= 1

            if i <= j:
                # Swap elements at positions i and j
                if arr[i] == pivot:
                    p = j
                if arr[j] == pivot:
                    p = i
                arr[i], arr[j] = arr[j], arr[i]
                i += 1
                j -= 1

        # Recursively sort the subarrays
        quicksort(arr, l, p)
        quicksort(arr, p + 1, r)

if __name__ == "__main__":
    # Get input from the user
    n = int(input("Enter the number of elements: "))
    arr = list(map(int, input("Enter the elements separated by space: ").split()))

    # Perform quicksort
    quicksort(arr, 0, len(arr) - 1)

    # Display the sorted array
    print("Sorted array:", *arr)
