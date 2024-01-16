'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using Shell sort algorithm.'''

# Stable : No
# Inplace : Yes
# Adaptive : Yes

# Space complexity: O(1)

#Time Complexity:O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

def VSDShellSort(arr,n):
    shellsize=8  # Initialize the initial gap size for Shell Sort
    while(shellsize>=1):# Continue the loop until the gap size becomes 1
        i=shellsize
        k=0
        while(i<n and k<shellsize): # Iterate through the array with the current gap size
            key=arr[i] # Store the current element as the key
            j=i-shellsize  # Start comparing with the element 'shellsize' positions before the current element
            while j>=0:
                if(arr[j]>key):
                    arr[j+shellsize]=arr[j] # Shift elements greater than the key to the right
                else:
                    break
                j-=shellsize
            arr[j+shellsize]=key # Insert the key at its correct position in the sorted sequence
            if(i+shellsize)>=n:
                k+=1
                i=k+shellsize # Move to the next group of elements for comparison
            else:
                i+=shellsize
        shellsize=shellsize//2 # Reduce the gap size by half in each iteration
    print(*arr,sep=" ")  # Print the sorted array


def main():
    try:
        # Input the number of elements
        n = int(input("Enter the number of elements: "))
        # Check if the entered number of elements is not a positive integer
        if n <= 0:
            raise ValueError("Number of elements should be a positive integer.")

        # Input the elements of the array and convert them to integers
        arr = list(map(int, input("Enter the elements separated by space: ").split()))

        # Check if the number of elements entered matches the specified count
        if len(arr) != n:
            raise ValueError("Number of elements entered doesn't match the specified count.")

        # Call the VSDShellSort function to sort the array
        VSDShellSort(arr, n)

    except ValueError as e:
        # Handle the case where an error occurs (e.g., non-integer input)
        print(f"Error: {e}")

# Check if the script is executed as the main program
if __name__ == "__main__":
    main()
