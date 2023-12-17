'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using Shell sort algorithm.'''

# Stable : No
# Inplace : Yes
# Adaptive : Yes

# Space complexity: O(1)

#Time Complexity:O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

def VSDShellSort(arr,n):
    shellsize=8
    while(shellsize>=1):
        i=shellsize
        k=0 
        while(i<n and k<shellsize):
            key=arr[i]
            j=i-shellsize
            while j>=0:
                if(arr[j]>key):
                    arr[j+shellsize]=arr[j]
                else:
                    break
                j-=shellsize
            arr[j+shellsize]=key
            if(i+shellsize)>=n:
                k+=1
                i=k+shellsize
            else:
                i+=shellsize
        shellsize=shellsize//2
    print(*arr,sep=" ")

if __name__=="__main__":
   n = int(input("Enter the number of elements: "))
   arr = list(map(int, input("Enter the elements").split()))
   VSDShellSort(arr, n)
