<h1>MERGE SORT</h1>

Merge sort is a popular sorting algorithm that follows the divide-and-conquer approach. It works by dividing the unsorted list into smaller sublists, sorting those sublists recursively, and then merging them back into a sorted list. This process continues until the entire list is sorted.

<h2>INTRODUCTION</h2>

The merge sort algorithm consists of two main steps: the divide step and the merge step. In the divide step, the unsorted list is divided into two halves until each sublist contains only one element or is empty. This is done recursively until all sublists are sorted.

In the merge step, the sorted sublists are merged back together by comparing the elements from each sublist and placing them in the correct order. This process continues until all sublists are merged into a single sorted list.

One of the key advantages of merge sort is its efficiency and stability. It has a time complexity of O(n log n) in the worst case, making it efficient for sorting large datasets. Additionally, merge sort is a stable sorting algorithm, meaning that it preserves the relative order of equal elements in the sorted list.

Overall, merge sort is a reliable and efficient sorting algorithm that is widely used in various applications. It provides a consistent performance and guarantees a sorted output, making it a valuable tool in computer science and data processing.

<h2>CODE</h2>

<h2>Python</h2>

```
#Copyrights to venkys.io
#For more programs visit venkys.io 
#Python program for Merge sort

def merge_sort(array):
    # Divide strategy
	if len(array) > 1:

		# Finding the mid index of the array
		midx = len(array)//2

		# Dividing the array elements
		Larray = array[:midx]
		Rarray = array[midx:]

		merge_sort(Larray)
		merge_sort(Rarray)
		
    # Conqure strategy
    
		idx1 = 0 # to track left array
		idx2 = 0 # to track right array
		idx = 0 # to track array

		while idx1 < len(Larray) and idx2  < len(Rarray):
			if Larray[idx1] < Rarray[idx2]:
				array[idx] = Larray[idx1]
				idx1 += 1
			else:
				array[idx] = Rarray[idx2]
				idx2 += 1
			idx += 1

		# sorting the remaining elements
		
		while idx1 < len(Larray):
			array[idx] = Larray[idx1]
			idx1 += 1
			idx += 1

		while idx2 < len(Rarray):
			array[idx] = Rarray[idx2]
			idx2 += 1
			idx += 1

# Test drive code
if __name__=="__main__":
    n=7
    array=[34, 2, 12, 96, 456, 899, 24]
    merge_sort(array)
    print(*array)

```
<h2>Step-by-Step Explanation:</h2>

1. The merge_sort function takes an array as input and implements the merge sort algorithm.
2. In the divide strategy, if the length of the array is greater than 1, the algorithm finds the mid index of the array and divides it into two halves.
3. The left half of the array is assigned to the Larray variable, and the right half is assigned to the Rarray variable.
4. The merge_sort function is called recursively for both the left and right halves to further divide them until each sublist contains only one element or is empty.
5. In the conquer strategy, three index variables (idx1, idx2, and idx) are initialized to keep track of the position in the left array, right array, and original array, respectively.
6. While both idx1 and idx2 are less than the lengths of Larray and Rarray respectively, the algorithm compares the elements at the corresponding positions and places the smaller element in the original array.
7. After the previous step, there may be remaining elements in either Larray or Rarray. The algorithm then copies the remaining elements into the original array.
8. Once the merge_sort function completes, the original array will be sorted in ascending order.
9. The test drive code initializes an array with 7 elements and calls the merge_sort function on it.
10. Finally, the sorted array is printed as output.

<h2>JAVA</h2>

```
// Copyrights to venkys.io
//For more programs visit venkys.io 
//Java program for Merge sort


public class Main {
	
	
	static void VSDmerge(int[] array,int l, int r)
	{
		if(l<r) {
			int m =l+(r-l)/2;
			//Recursively calling merge method to divide the array
			VSDmerge(array,l,m);
			VSDmerge(array,m+1,r);
			//Combines the divided array pieces in sorted order
			VSDMergesort(array,l,m,r);
		}
	}
	 
   static void VSDMergesort(int[] array,int l, int m, int r){
	   //Assigning sizes for temporary arrays
	   	int n1 = m-l+1;
        int n2 = r-m;
        //Temporary arrays to sort divided elements
        int Left[] = new int[n1];
        int Right[] = new int[n2];
        //Assigning elements
        for (int i=0;i<n1;i++)
            Left[i] = array[l + i];
        for (int j=0;j<n2;j++)
            Right[j] = array[m+1+j];
        //Initial indexes to sort elements using temporary arrays
        int i = 0,j = 0;
        //Index for original array
        int k = l;
        //Comparing elements to arrange them in sorted order in original array
        while (i<n1 && j<n2) {
            if (Left[i]<=Right[j]) {
                array[k]=Left[i];
                i++;
            }
            else {
                array[k]=Right[j];
                j++;
            }
            k++;
        }
        //Arranging remaining elements from left array
        while (i < n1) {
           array[k]=Left[i];
            i++;
            k++;
        }
      //Arranging remaining elements from right array
        while (j < n2) {
            array[k]=Right[j];
            j++;
            k++;
        }
        
    }
   //Function to take user input

//Function to print output
public static void VSDprintOutput(int[] array) {
	System.out.println("The sorted order is:");
	for(int a:array){
        System.out.print(a+" ");
    }
    System.out.println();
}
public static void main(String args[]) {
	int[] array={34, 2, 12, 96, 456, 899, 24};
    int size=array.length;
	VSDmerge(array,0,size-1);//Calling merge for the entire array
	VSDprintOutput(array);//Printing output
}
}

```
<h2>Step-by-Step Explanation:</h2>

1. The Java code provided implements the merge sort algorithm to sort an array of integers.
2. The VSDmerge method is a recursive function that performs the merge sort algorithm. It takes three parameters: the array to be sorted, the left index, and the right index.
3. Inside the VSDmerge method, the middle index m is calculated as l + (r - l) / 2, which represents the midpoint of the array.
4. The VSDmerge method is recursively called on the left half of the array (l to m) and the right half of the array (m+1 to r).
5. The VSDMergesort method is used to merge the divided subarrays in sorted order. It takes four parameters: the array, the left index l, the middle index m, and the right index r.
6. In the VSDMergesort method, two temporary arrays, Left and Right, are created to store the divided elements of the original array.
7. The elements of the divided subarrays are assigned to the Left and Right arrays accordingly.
8. Using three index variables (i, j, and k), the elements from Left and Right arrays are compared and merged back into the original array in sorted order.
9. After merging the elements, any remaining elements in either the Left or Right arrays are appended to the original array.
10. Once the VSDmerge and VSDMergesort methods complete their execution, the original array will be sorted in ascending order.
11. The VSDprintOutput method is used to print the sorted array as output.
12. In the main method, an array of integers is declared and initialized.
13. The VSDmerge method is called with the array and the indices of the first and last elements of the array.
14. Finally, the VSDprintOutput method is called to print the sorted array.

<h2>CPP</h2>

```
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Merge sort

#include<iostream>

using namespace std;

// Merge two subarrays of arr[]
// First subarray is arr[l..m]
// Second subarray is arr[m+1..r]

void VSDmerge(int arr[], int l, int m, int r) {
    // Calculate sizes of the two subarrays
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temporary arrays to store the data of the two subarrays
    int left[n1];
    int right[n2];

    // Copy data to temporary arrays left[] and right[]
    for (int i = 0; i < n1; i++) {
        left[i] = arr[l + i];
    }
    for (int j = 0; j < n2; j++) {
        right[j] = arr[m + 1 + j];
    }

    // Merge the temporary arrays back into arr[l..r]
    int i = 0; // Initial index of the first subarray
    int j = 0; // Initial index of the second subarray
    int k = l; // Initial index of the merged subarray

    // Compare elements of the two subarrays and merge them in ascending order
    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    // Copy the remaining elements of left[], if there are any
    while (i < n1) {
        arr[k] = left[i];
        i++;
        k++;
    }

    // Copy the remaining elements of right[], if there are any
    while (j < n2) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

// Recursive function to perform merge sort on the array
void VSDmergesort(int arr[], int l, int r) {
    if (l < r) {
        // Same as (l+r)/2, but avoids overflow for large l and r
        int m = l + (r - l) / 2;

        // Recursively sort the first and second halves
        VSDmergesort(arr, l, m);
        VSDmergesort(arr, m + 1, r);

        // Merge the sorted halves
        VSDmerge(arr, l, m, r);
    }
}

int main() {
    int n = 7;
    int arr[] = {34, 2, 12, 96, 456, 899, 24};

    // Call the merge sort function
    VSDmergesort(arr, 0, n - 1);

    // Print the sorted array
    cout << "Sorted array: ";
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;

    return 0;
}

```
<h2>Step-by-Step Explanation:</h2>

1. The C++ code provided implements the merge sort algorithm to sort an array of integers.
2. The VSDmerge function is defined to merge two subarrays of the array. It takes four parameters: the array to be sorted, the left index, the middle index, and the right index.
3. Inside the VSDmerge function, the sizes of the two subarrays are calculated: n1 for the left subarray and n2 for the right subarray.
4. Temporary arrays left and right are created to store the elements of the left and right subarrays, respectively.
5. The elements from the original array are copied to the temporary arrays left and right.
6. The elements of the temporary arrays are merged back into the original array in sorted order. The variables i, j, and k are used as indices to compare and merge the elements.
7. Any remaining elements in either the left or right subarray are copied to the original array.
8. The VSDmergesort function is defined to perform the merge sort algorithm recursively. It takes three parameters: the array to be sorted, the left index, and the right index.
9. Inside the VSDmergesort function, if the left index is less than the right index, the middle index m is calculated as l + (r - l) / 2.
10. The VSDmergesort function is recursively called for the left half of the array (l to m) and the right half of the array (m+1 to r).
11. Finally, the main function initializes an array of integers and calls the VSDmergesort function to sort the array. The sorted array is then printed as output.

<h2>OUTPUT</h2>

The sorted order is:  2 12 24 34 96 456 899

<h2>Time and Space complexity analysis:</h2>

The time and space complexity analysis for the merge sort algorithm is as follows:

**Time Complexity:**

- Best Case: O(n log n)
- Average Case: O(n log n)
- Worst Case: O(n log n)

The merge sort algorithm follows the divide-and-conquer approach, where the unsorted list is divided into smaller sublists until each sublist contains only one element or is empty. Then, the sorted sublists are merged back together to form a sorted list.

In each recursive call, the merge sort algorithm divides the list into two halves, which takes O(log n) time. Then, during the merge step, it compares and merges the elements from the sublists, which takes O(n) time in the worst case. Since the list is divided recursively into halves, the overall time complexity of merge sort is O(n log n).

**Space Complexity:**
The space complexity of merge sort is O(n) because it requires auxiliary space to store the temporary subarrays during the merge step. In each recursive call, the merge sort algorithm creates temporary arrays to store the divided elements. The size of these temporary arrays is equal to the size of the original array, resulting in a space complexity of O(n).

Overall, merge sort is an efficient sorting algorithm with a time complexity of O(n log n) and a space complexity of O(n). It provides stable sorting, meaning that it preserves the relative order of equal elements in the sorted list. Merge sort is widely used in various applications where stability and efficiency are important factors.

<h2>Real-World Applications of Merge Sort:</h2>

Merge sort has several real-world applications due to its efficiency, stability, and ability to handle large datasets. Some notable applications of merge sort include:

1. **Sorting Algorithms**: Merge sort is often used as a benchmark for other sorting algorithms due to its consistent performance and efficiency. It is commonly used to sort arrays, lists, and other data structures in programming languages.
2. **External Sorting**: Merge sort's ability to efficiently handle large datasets makes it suitable for external sorting. External sorting is used when the data to be sorted exceeds the available memory. Merge sort's divide-and-conquer approach allows it to efficiently sort data that is too large to fit in memory by using disk-based operations.
3. **File Merge Operations**: Merge sort is used in various file processing operations, such as merging multiple sorted files into a single sorted file. This is commonly seen in database systems, where large datasets are stored in multiple files and need to be merged for efficient querying and analysis.
4. **Inversion Count**: Merge sort is also used to calculate the inversion count of an array. An inversion is a pair of elements in an array that are out of order. By counting the number of inversions, it is possible to measure the similarity between two datasets or to detect anomalies in data.
5. **External Merge Sort**: Merge sort is a key component of external merge sort algorithms, which are used to sort large datasets that do not fit entirely in memory. External merge sort divides the data into smaller chunks, sorts them using merge sort, and then merges the sorted chunks to produce the final sorted result.
6. **Parallel Computing**: Merge sort can be parallelized, making it suitable for parallel computing environments. By dividing the data and sorting the sublists in parallel, merge sort can achieve faster sorting times on systems with multiple processors or cores.

Overall, merge sort's efficiency, stability, and ability to handle large datasets make it a valuable tool in various real-world applications that involve sorting and managing large amounts of data.



