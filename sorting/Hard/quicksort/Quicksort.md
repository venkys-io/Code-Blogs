# Quick sort
Quick sort is a popular sorting algorithm that follows the divide-and-conquer approach. It is efficient for large datasets and has an average time complexity of O(n log n).
The algorithm works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The process is then repeated recursively for the sub-arrays until the entire array is sorted.
Quick sort is known for its simplicity and effectiveness, making it a commonly used sorting algorithm in various programming languages.

## Overview
Divide: The algorithm divides the array into two partitions or subarrays. This is typically done by selecting a "pivot" element from the array.

Partition: Rearrange the elements in the array such that all elements less than the pivot are on the left side, and all elements greater than the pivot are on the right side. The pivot itself is placed in its final position.

Conquer: Recursively apply the QuickSort algorithm to the subarrays on the left and right of the pivot.

Combine: The sorted subarrays are combined to produce the final sorted array.

The key to the efficiency of QuickSort lies in the partitioning step. Choosing a good pivot is crucial. Common strategies include selecting the first or last element as the pivot, or choosing a random element. The goal is to have a pivot that roughly divides the array into two equal parts.
## Code in Python
```

def quicksort(arr,l,r):
    if l<r:
        p=l+(r-l)//2
        pivot=arr[p]
        i=l;j=r 
        while(l<r):
            if(arr[l]>=pivot  and arr[r]<=pivot):
                if(arr[l]==pivot):
                    p=r 
                if (arr[r]==pivot):
                    p=l 
                arr[l],arr[r]=arr[r],arr[l]
                r-=1 
            
            elif (arr[l]>pivot and arr[r]>pivot):
                r-=1 
            else:
                l+=1
        quicksort(arr,l,p)
        quicksort(arr,p+1,j)


if __name__=="__main__":
    n = int(input())
    arr=[int(i) for i in input().split()]
    quicksort(arr,0,len(arr)-1)
    print(*arr,sep=" ")
            
```
## code in Java
```
import java.util.Scanner;
public class Main {
	
	public static void VSDquicksort(int a[],int l,int r) {
		if(l<r) {
			int p=l+(r-l)/2;//Taking index of pivot as the mid element of array
			int pivot=a[p];//Taking pivot element
			int i=l,j=r;//Remembering initial array indices
			//Placing pivot at right place
			while(l<r) {
				if(a[l]>=pivot&&a[r]<=pivot) {
					if(a[l]==pivot)p=r;//When the place of pivot is changed, noting its index
					if(a[r]==pivot)p=l;
					VSDswapElementsAt(a,l,r);
				     r--;
				}
				else if(a[l]>pivot&&a[r]>pivot) r--;
				else l++;
			}
			//Recursively sorting remaining elements in array
			VSDquicksort(a,i,p);
			VSDquicksort(a,p+1,j);
		}
	}
	//Function to swap the elements of array
		public static void VSDswapElementsAt(int[] a,int i,int j) {
				int temp=a[i];
		     	a[i]=a[j];
		     	a[j]=temp;
		}
		
	
	//Function to print output
			public static void VSDprintOutput(int[] a) {
				System.out.println("The sorted order is:");
				for(int i=0;i<a.length;i++) {
					System.out.print(a[i]+" ");
				}
				System.out.println();
			}
public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);
	int n = scanner.nextInt();
	int[] a = new int[n];
	for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }
	VSDquicksort(a,0,n-1);
	VSDprintOutput(a);
}
}
```
## code in C++
```
#include<iostream>

using namespace std;


void swap(int arr[],int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

void quicksort(int arr[],int l,int r){
    if(l<r){
        int p=l+(r-l)/2;
        int pivot=arr[p];
        int i=l,j=r;

        while(l<r){
            if(arr[l]>pivot && arr[r]<=pivot){
                if(arr[l]==pivot) p=r;
                if(arr[r]==pivot) p=l;
                swap(arr,l,r);
                r--;
            }
            else if(arr[l]>pivot && arr[r]>pivot) r--;
            else l++;
        }
        quicksort(arr,i,p);
        quicksort(arr,p+1,j);
    }
}




int main(){
    int n;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    quicksort(arr,0,n-1);
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
    return 0;
}
```
## Code explanation
quicksort is a recursive function that takes an array arr and two indices l and r representing the left and right boundaries of the subarray to be sorted.

The function checks if l is less than r, i.e., if there is more than one element in the subarray. If there's only one element or none, the array is considered sorted, and the function returns without doing anything.

The middle index p is calculated as the floor division of the sum of l and r by 2. The element at this index (arr[p]) is chosen as the pivot.

Two pointers i and j are initialized to l and r respectively.

A while loop is used to partition the array around the pivot. The loop continues until l is not less than r.

Inside the loop, the elements at indices l and r are compared to the pivot. If arr[l] is greater than or equal to the pivot and arr[r] is less than or equal to the pivot, a swap is performed, and l and r are adjusted accordingly.

If both elements are equal to the pivot, the pivot index p is updated to either l or r.

If the elements are greater than the pivot on both sides, the right pointer r is decremented.

If the elements are less than the pivot on both sides, the left pointer l is incremented.

After the while loop, the array is partitioned into two subarrays, and the function is recursively called on both subarrays: quicksort(arr, l, p) and quicksort(arr, p + 1, j).

The if __name__ == "__main__": block initializes an array arr and calls the quicksort function to sort the array. Finally, the sorted array is printed.

Note: The provided code has a minor issue; the variable p needs to be used in the recursive calls instead of l in the first call. Replace quicksort(arr, l, p) with quicksort(arr, l, p - 1) to fix this issue.

## Time and space complexity
### Time Complexity:

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n^2)

### Space Complexity:

Best Case: O(log n)

Average Case: O(log n)

Worst Case: O(n)
## Real time application
- Search Engines:

Quicksort is employed in the indexing and searching processes of search engines. Efficient sorting is crucial for quickly retrieving relevant search results.

- E-commerce Platforms:

In e-commerce systems, Quicksort can be used for sorting product listings based on various criteria such as price, popularity, or customer ratings.

- Telecommunications:

Quicksort is used in telecommunications for tasks like call routing and managing network data. Sorting helps optimize the routing of calls and the processing of data.

- Flight Scheduling and Air Traffic Control:

In the aviation industry, Quicksort can be utilized to sort and manage flight schedules efficiently. It helps in optimizing air traffic control systems and managing flight data.

## Test Cases
- The unsorted array is {4, 6, 2, 7, 1, 9, 3}
Here's how the quicksort algorithm sorts the given array {4, 6, 2, 7, 1, 9, 3}:

Choose a Pivot: Let's choose the last element, 3, as the pivot.

Partitioning:
Start with two pointers, i and j, initialized at the beginning and end of the array, respectively.
Move i towards the right until we find an element greater than the pivot.
Move j towards the left until we find an element less than the pivot.
Swap the elements at positions i and j if i is less than j.
Continue this process until i crosses j.
Finally, place the pivot element (3) at its correct position such that all elements to its left are less than it, and all elements to its right are greater than it.
After partitioning, the array may look like: {2, 1, 3, 7, 6, 9, 4}. The pivot element, 3, is now in its correct position.

Recursively Apply Quicksort:
Apply the quicksort algorithm recursively to the subarrays formed by partitioning.
For the left subarray {2, 1}, choose the last element (1) as the pivot and partition it. It doesn't need any further partitioning as it's already sorted.
For the right subarray {7, 6, 9, 4}, choose the last element (4) as the pivot and partition it. After partitioning, it may look like: {4, 6, 7, 9}.
The final sorted array is {1, 2, 3, 4, 6, 7, 9}.

- the unsorted array {8, 3, 5, 2, 9, 1, 7, 4}.
Here's how the quicksort algorithm sorts the given array {8, 3, 5, 2, 9, 1, 7, 4}:

Choose a Pivot: Let's choose the last element, 4, as the pivot.

Partitioning:
Start with two pointers, i and j, initialized to the beginning and end of the array, respectively.
Move i towards the right until we find an element greater than the pivot.
Move j towards the left until we find an element less than the pivot.
Swap the elements at positions i and j if i is less than j.
Continue this process until i crosses j.
Finally, place the pivot element (4) at its correct position such that all elements to its left are less than it, and all elements to its right are greater than it.
After partitioning, the array may look like: {3, 2, 1, 4, 9, 5, 7, 8}. The pivot element, 4, is now in its correct position.

Recursively Apply Quicksort:
Apply the quicksort algorithm recursively to the subarrays formed by partitioning.
For the left subarray {3, 2, 1}, choose the last element (1) as the pivot and partition it. After partitioning, it remains the same as it's already sorted.
For the right subarray {9, 5, 7, 8}, choose the last element (8) as the pivot and partition it. After partitioning, it may look like: {5, 7, 8, 9}.
The final sorted array is {1, 2, 3, 4, 5, 7, 8, 9}.
