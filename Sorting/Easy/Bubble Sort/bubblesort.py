'''Copyrights to venkys.io
For more programs visit venkys.io 
Python program for Bubble sort'''
#Stable: Yes
#Inplace: Yes
#Adaptive: No
#Time Complexity: Best case - O(n), Average and worst case - O(n^2)
#Space Complexity: O(1)
def bubbleSort(array):
    n=len(array)
    for i in range(n):
        for j in range(0,n-i-1):
            if array[j]>array[j+1]:
                array[j],array[j+1]=array[j+1],array[j]
    return array

if __name__=="__main__":
    array = list(map(int, input("Enter the array elements separated by space: ").split()))
    print(bubbleSort(array))
