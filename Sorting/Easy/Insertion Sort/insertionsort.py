'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using Insertion sort algorithm.'''

# Stable : Yes
# Inplace : Yes
# Adaptive : Yes

# Space complexity: O(1)

#Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

def VSDInsertionSort(arr,n):
		'''
    Function to perform Insertion Sort on the given array.

    Parameters:
    arr (list): The input list to be sorted.
    n (int): The length of the array.

    Returns:
    None. Prints the sorted array.
    '''
    for i in range(1,n):
        temp=arr[i]
        j=i
        while j>0 and arr[j-1]>temp:
            arr[j]=arr[j-1]
            j-=1
        arr[j]=temp
		#Print the Sorted array
    print("Sorted Array:", *arr,sep=" ")

def main():
    '''
    Main function to take user input and call the Insertion Sort function.
    '''
    try:
        n = int(input("Enter the size of the array: "))
        if n <= 0:
            print("Invalid size. Please enter a positive integer.")
            return

        arr = list(map(int, input("Enter the elements of the array separated by space: ").split()))

        if len(arr) != n:
            print("Number of elements entered does not match the specified size.")
            return

        VSDInsertionSort(arr, n)

    except ValueError:
        print("Invalid input. Please enter valid integers.")

if __name__ == "__main__":
    # Running the main function
    main()
