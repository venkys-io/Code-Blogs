'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using Insertion sort algorithm.'''

# Stable : Yes
# Inplace : Yes
# Adaptive : Yes

# Space complexity: O(1)

#Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

def VSDInsertionSort(arr,n):#parameters are array and length of array

    for i in range(1,n):
        temp=arr[i]
        j=i 
        while j>0 and arr[j-1]>temp:
            arr[j]=arr[j-1] 
            j-=1
        arr[j]=temp 
    print(*arr,sep=" ")

if __name__=="__main__":
    n = int(input("Enter the size of the array: "))
    arr = list(map(int, input("Enter the elements of the array separated by space: ").split()))
    VSDInsertionSort(arr,n)