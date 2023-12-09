# Array Heap Sort

## Introduction to Array Heap Sort

Heap Sort is a comparison-based sorting algorithm that uses a binary heap data structure. It divides the input into a sorted and an unsorted region, and iteratively shrinks the unsorted region by extracting the largest element and moving that to the sorted region. The heap is updated after each extraction to maintain the heap property. Once all elements have been moved from the unsorted region to the sorted region, the algorithm stops.

## Overview of Array Heap Sort

Array Heap Sort is a variant of the Heap Sort algorithm that operates directly on an array. It first transforms the array into a max heap structure, where the maximum heap property is maintained. The maximum element, which is at the root of the heap, is then swapped with the last element of the array, effectively moving it from the unsorted section of the array to the sorted section. The heap size is reduced by one and the max heap property is restored. This process is repeated until all elements in the array are sorted. The advantage of this method is that it does not require any additional space as it sorts in place, making it a space-efficient solution.

## Code

```python
#Copy rights to venkys.io
#For more information visit https://venkys.io
#Python program to perform Array Heap Sort
#Stable:No
#Inplace:Yes
#Adaptive:No
#Space complexity: O(1)
#Time complexity:O(nlogn)
# Function to maintain max heap properties
def VSDmaxHeapify(arr,size,i):

    #declare current element index is largest element
    large=i 

    #find index of left child
    leftchild=(2*i)+1 

    #find index of right child
    rightchild=(2*i)+2 

    # check largest element between left child and current element
    if leftchild<size and arr[i]<arr[leftchild]:
        large=leftchild
    
    # check largest element between right child and large element
    if rightchild<size and arr[large]<arr[rightchild]:
        large=rightchild
    
    # if large element is not current element 
    # swap current element with large element 
    # heapify the the current array
    if large!=i:
        arr[large],arr[i]=arr[i],arr[large]
        VSDmaxHeapify(arr,size,large)

# Function to maintain max heap properties
def VSDminHeapify(arr,size,i):
    
    #Declare the current element index as smallest
    small=i

    #Find the index of leftchild element
    leftchild=(2*i)+1

    #Find the index of rightchild element
    rightchild=(2*i)+2

    #Check the smallest element between leftchild and current element
    if leftchild<size and arr[i]>arr[leftchild]:
        small=leftchild
    
    #Check the smallest element between rightchild and smallest element
    if rightchild<size and arr[small]>arr[rightchild]:
        small=rightchild
    
    # If smallest element is not current element
    # Swap the smallest element and current element
    # Heapify the current array
    if small!=i:
        arr[small],arr[i]=arr[i],arr[small]
        VSDminHeapify(arr,size,small)

# Function to insert elements into max heap
def insert(array,num):
    if len(array)==0:
        array.append(num)
    else:
        array.append(num)
        for i in range(len(array)):
            VSDmaxHeapify(array,len(array),i)

# Function to sort the given array using maxheap in ascending order
def VSDMaxheapsort(array):
    size=len(array)

    # Heapify the given array into maxheap
    for i in range((size//2)-1,-1,-1):
        VSDmaxHeapify(array,size,i)

    # Find the max element in array
    # Swap the max element with last index element 
    # Decrease the last index by 1
    # Heapify the current array upto last index
    for i in range(size-1,0,-1):
        array[i],array[0]=array[0],array[i]
        VSDmaxHeapify(array,i,0)
  

# Function to sort the given array using minheap in descending order
def VSDMinheapsort(array):
    size=len(array)

    # Heapify the given array into min heap
    for i in range((size//2)-1,-1,-1):
        VSDminHeapify(array,size,i)
    
    # Find the min element in array
    # Swap the min element with last index element
    # Decrease the last index by 1
    # Heapify the current array upto last index
    for i in range(size-1,-1,-1):
        array[0],array[i]=array[i],array[0]
        VSDminHeapify(array,i,0)

#Fucntion to print array
def printarray(array):

    for i in array:
        print(i,end=" ")
    print()

if __name__=="__main__":
    arr=[5,2, 9, 12, 54, 31, 65, 31, 45, 65]
    print("Sorted array using maxheapsort:")
    VSDMaxheapsort(arr)
    printarray(arr)
    print("Sorted array using minheapsort:")
    VSDMinheapsort(arr)
    printarray(arr)
```

## Step-by-Step Explanation

1. The code begins with two functions, `VSDmaxHeapify` and `VSDminHeapify`, which help maintain the max heap and min heap properties, respectively. These functions are used to rearrange the elements of the array such that the parent node is always greater (max heapify) or smaller (min heapify) than its child nodes.
2. The `insert` function is used to insert elements into the max heap. It appends the new element to the end of the array and then rearranges the heap to maintain the max heap property.
3. The `VSDMaxheapsort` function is used to sort the array in ascending order. It first transforms the array into a max heap. Then, it swaps the first element (which is the maximum in a max heap) with the last element of the array, effectively moving it to the sorted section of the array. The size of the heap is then reduced by one and the max heap property is restored. This process is repeated until all elements are sorted.
4. The `VSDMinheapsort` function works similarly to `VSDMaxheapsort`, but it sorts the array in descending order using a min heap.
5. The `printarray` function is used to print the array after it has been sorted.
6. In the main function, an array is defined and then sorted using both `VSDMaxheapsort` and `VSDMinheapsort`. The sorted arrays are then printed to the console.

## Code

```java
//Copy rights to venkys.io
//For more information visit https://venkys.io
//Java program to perform Array Heap Sort
//Stable:No
//Inplace:Yes
//Adaptive:No
//Space complexity: O(1)
//Time complexity:O(nlogn)
public class Main {
    // Function to swap two elements in an array
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    // Function to perform max heapify operation on a node in max heap
    static void VSDmaxheapify(int[] arr,int n,int i){
        int large=i;
        int leftchild=(2*i)+1;
        int rightchild=(2*i)+2;
        if (leftchild<n && arr[i]<arr[leftchild]){

            large=leftchild;
        }
        if (rightchild<n && arr[large]<arr[rightchild]){
            large=rightchild;
        }
        if (large!=i){
            swap(arr,i,large);
            VSDmaxheapify(arr,n,large);
        }
    }
    // Function to perform min heapify operation on a node in min heap
    static void VSDminheapify(int[] arr,int n,int i){
        int small=i;
        int leftchild=(2*i)+1;
        int rightchild=(2*i)+2;

        if(leftchild<n && arr[i]>arr[leftchild]){
            small=leftchild;
        }
        if(rightchild<n && arr[small]>arr[rightchild]){
            small=rightchild;
        }
        if(small!=i){
            swap(arr,small,i);
            VSDminheapify(arr, n, small);
        }
    }
    // Function to perform max heap sort on an array
    static void VSDMaxheapsort(int[] arr){
        int n=arr.length;
        // Build max heap
        for(int i=(n/2)-1;i>=0;i--){
            VSDmaxheapify(arr, n, i);
        }
        // Extract elements from the max heap
        for(int i=n-1;i>0;i--){
            swap(arr,i,0);
            VSDmaxheapify(arr, i, 0);
        }
    }
    //Function to perform min heap sort on an array
    static void VSDMinheapsort(int[] arr){
        int n=arr.length;
        // Build min heap
        for(int i=(n/2)-1;i>=0;i--){
            VSDminheapify(arr, n, i);
        }
        // Extract elements from the min heap
        for(int i=n-1;i>0;i--){
            swap(arr,i,0);
            VSDminheapify(arr, i, 0);
        }
    }
    // Function to print the elements of an array
    static void printarray(int[] arr){
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int[] arr={5,2, 9, 12, 54, 31, 65, 31, 45, 65};
        // Sorting array using max heap sort
        System.out.println("Sorted array using maxheapsort:");
        VSDMaxheapsort(arr);
        printarray(arr);
        // Sorting array using min heap sort
        System.out.println("Sorted array using minheapsort:");
        VSDMinheapsort(arr);
        printarray(arr)   ; 
    }
    
}
```

## Step-by-Step Explanation

1. The Java code begins with the `swap` function which is used to swap the elements of the array.
2. The `VSDmaxheapify` and `VSDminheapify` functions are used to maintain the max heap and min heap properties respectively. They rearrange the elements of the array such that the parent node is always greater (max heapify) or smaller (min heapify) than its child nodes.
3. `VSDMaxheapsort` function is used to sort the array in ascending order. It first transforms the array into a max heap. Then, it swaps the first element (which is the maximum in a max heap) with the last element of the array, effectively moving it to the sorted section of the array. The size of the heap is then reduced by one and the max heap property is restored. This process is repeated until all elements are sorted.
4. `VSDMinheapsort` function works similarly to `VSDMaxheapsort`, but it sorts the array in descending order using a min heap.
5. The `printarray` function is used to print the array after it has been sorted.
6. In the main function, an array is defined and then sorted using both `VSDMaxheapsort` and `VSDMinheapsort`. The sorted arrays are then printed to the console.

## Code

```cpp
/*Copy rights to venkys.io*/
/*For more information visit https://venkys.io */
/*CPP program to perform Array Heap Sort */
/*Stable:No*/
/*Inplace:Yes*/
/*Adaptive:No*/
/*Space complexity: O(1)*/
/*Time complexity:O(nlogn)*/
#include<iostream>

using namespace std;
/* Function to swap two elements in an array */

void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}
/* Function to print the elements of an array */
void printarray(int arr[],int n){
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}
/* Function to perform max heapify operation on a node in max heap */
void VSDmaxheapify(int arr[],int n,int i){
    int large=i;
    int leftchild=(2*i)+1;
    int rightchild=(2*i)+2;
    /* Check if left child is larger than the current root */
    if(leftchild<n && arr[i]<arr[leftchild])
        large=leftchild;
    /* Check if right child is larger than the current root or left child */
    if(rightchild<n && arr[large]<arr[rightchild])
        large=rightchild;
    /* If the largest is not the root, swap and recursively heapify the affected subtree */
    if(large!=i){
        swap(arr,i,large);
        VSDmaxheapify(arr,n,large);
    }
}
/* Function to perform min heapify operation on a node in min heap */
void VSDminheapify(int arr[],int n,int i){
    int small=i;
    int leftchild=(2*i)+1;
    int rightchild=(2*i)+2;
    /* Check if left child is smaller than the current root */
    if(leftchild<n && arr[i]>arr[leftchild]){
        small=leftchild;
    }
    /* Check if right child is smaller than the current root or left child */
    if(rightchild<n && arr[small]>arr[rightchild]){
        small=rightchild;
    }
    /* If the smallest is not the root, swap and recursively heapify the affected subtree */
    if(small!=i){
        swap(arr,small,i);
        VSDminheapify(arr,n,small);
    }
}
/* Function to perform max heap sort on an array */
void VSDMaxheapsort(int arr[],int n){
    /* Build max heap */
    for(int i=(n/2)-1;i>=0;i--){
        VSDmaxheapify(arr,n,i);
    }
    /* Extract elements from the max heap one by one */
    for(int i=n-1;i>0;i--){
        swap(arr,i,0);
        VSDmaxheapify(arr,i,0);
    }
}
/* Function to perform min heap sort on an array */
void VSDMinheapsort(int arr[],int n){
    /* Build min heap */
    for(int i=(n/2)-1;i>=0;i--){
        VSDminheapify(arr,n,i);
    }
    /* Extract elements from the min heap one by one */
    for(int i=n-1;i>0;i--){
        swap(arr,i,0);
        VSDminheapify(arr,i,0);
    }

}
int main(){
    int arr[]={5,2, 9, 12, 54, 31, 65, 31, 45, 65};
    int n=sizeof(arr)/sizeof(arr[0]);
    /* Sorting array using max heap sort */
    VSDMaxheapsort(arr,n);
    printarray(arr,n);
    /* Sorting array using min heap sort */
    VSDMinheapsort(arr,n);
    printarray(arr,n);
    return 0;
}
```

## Step-by-Step Explanation

1. The C++ code starts with the `swap` function which is used to interchange the elements of the array.
2. The `VSDmaxheapify` and `VSDminheapify` functions are used to maintain the max heap and min heap properties respectively. They rearrange the elements of the array such that the parent node is always greater (max heapify) or smaller (min heapify) than its child nodes.
3. `VSDMaxheapsort` function is used to sort the array in ascending order. It first transforms the array into a max heap. Then, it swaps the first element (which is the maximum in a max heap) with the last element of the array, effectively moving it to the sorted section of the array. The size of the heap is then reduced by one and the max heap property is restored. This process is repeated until all elements are sorted.
4. `VSDMinheapsort` function works similarly to `VSDMaxheapsort`, but it sorts the array in descending order using a min heap.
5. The `printarray` function is used to print the array after it has been sorted.
6. In the main function, an array is defined and then sorted using both `VSDMaxheapsort` and `VSDMinheapsort`. The sorted arrays are then printed to the console.

## Time And Space Complexity Analysis

Heap Sort has a time complexity of O(n log n) for both the best case and the worst case. This is because it takes O(log n) time to heapify each of the n elements in the array.

The space complexity of Heap Sort is O(1). This is one of the main advantages of Heap Sort, especially the Array Heap Sort variant. Array Heap Sort operates directly on the array and does not require any additional space, making it a very space-efficient sorting algorithm.

## Real World Applications of Array Heap Sort

Heap sort, including the variant of Array Heap Sort, is used in a wide range of applications due to its efficiency, including:

1. Database systems: Heap Sort is widely used in database systems for sorting large datasets. It's particularly effective when used in conjunction with a binary heap data structure.
2. Priority Queues: Heap Sort is used in priority queues, which are used in scheduling processes in operating systems.
3. Graph Algorithms: Heap Sort is used in graph algorithms such as Dijkstra’s algorithm and Prim’s algorithm to find the shortest path and minimum spanning tree, respectively.
4. Selection Algorithm: The Heap Sort algorithm can be used to find the kth smallest or largest number in an array.
5. Space-restricted scenarios: Given its in-place sorting nature, Heap Sort is also beneficial in scenarios where memory space is a significant constraint.