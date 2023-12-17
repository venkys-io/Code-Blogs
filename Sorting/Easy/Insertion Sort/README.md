# Introduction to Insertion Sort:

---

Insertion sort is a simple sorting algorithm that builds the final sorted array or list one item at a time. It is an in-place comparison-based algorithm that works by dividing the input list into two parts: the sorted part and the unsorted part. The algorithm iterates over the unsorted part, selecting one element at a time and inserting it into the correct position in the sorted part. This process is repeated until the entire list is sorted.

Due to its simplicity and ease of implementation, insertion sort is commonly used in educational contexts to teach the concept of sorting algorithms and is also utilized in certain scenarios where the dataset is expected to be nearly sorted or very small in size.

# What is an In-place comparison based Sort?

---

An in-place comparison-based algorithm is a sorting algorithm that rearranges the elements of a list using only a constant amount of additional memory space, regardless of the size of the input. In other words, it operates directly on the input data without requiring any auxiliary data structures proportional to the input size. 

In the context of sorting algorithms, "in-place" means that the algorithm doesn't create a separate copy of the input list to perform the sorting. Instead, it rearranges the elements within the original list itself.

# Understanding Insertion Sort through an Example:

---

Let's take the array [5, 2, 4, 6, 1, 3] as an example.

Step 1: Initial State

- Original Array: [5, 2, 4, 6, 1, 3]
- Sorted (Initial): []

No Sorting is needed for element with index 0 as it is the first element.

Step 2: First Pass (i=1)

- We start with the second element (index 1) which is 2.
- We compare 2 with the elements to its left (5 in this case) and swap them if necessary, resulting in [2, 5, 4, 6, 1, 3].
- Here sorted part is [2,5] and unsorted part is [4,6,1,3]; original array is [2,5,4,6,1,3]

Step 3: Second Pass (i=2)

- Now, we consider the third element (index 2) which is 4.
- 4 is compared with 5 and since 4 is less than 5, we shift 5 to the right and insert 4 in its place: [2, 4, 5, 6, 1, 3].
- sorted part [2,4,5], unsorted part [6,1,3], original array [2,4,5,6,1,3]

Step 4: Third Pass (i=3)

- Moving to the next element, which is 6, we find that 6 is greater than its preceding element (5), so no swap is needed at this point: [2, 4, 5, 6, 1, 3].

Step 5: Fourth Pass (i=4)

- Considering the fifth element (index 4) which is 1, we compare 1 with 6, then 5, and finally 4, shifting each one to the right until 1 finds its correct position: [1, 2, 4, 5, 6, 3].
- sorted part [1,2,4,5,6], unsorted part [3]

Step 6: Fifth Pass (i=5)

- Lastly, we evaluate the sixth element (index 5) which is 3. We compare 3 with 6, shift 6, [1,2,4,5,3,6] then compare 3 with 5, shift 5, [1,2,4,3,5,6] and finally compare 3 with 4, resulting in the final sorted array: [1, 2, 3, 4, 5, 6].

After these steps, the array has been sorted using the insertion sort algorithm. Each element was inserted into its correct position within the sorted part of the array.

# Advantages of Insertion Sort:

---

Insertion Sort has several advantages:

1. Simplicity: Insertion Sort is a simple algorithm to understand and implement. It has a straightforward logic that makes it easy to grasp and implement correctly.
2. Efficiency for small lists or partially sorted lists: Insertion Sort performs well when the input list is already partially sorted or contains a small number of elements. In such cases, the algorithm can take advantage of the partially sorted nature, resulting in improved efficiency compared to other sorting algorithms.
3. Space efficiency: Insertion Sort is an in-place sorting algorithm, meaning it sorts the input list by rearranging the elements within the original list itself. It does not require additional memory space proportional to the input size, making it memory-efficient.
4. Adaptive: Insertion Sort is an adaptive algorithm, which means it performs well when the input list is almost sorted or contains elements that are already in the correct order. In such cases, the algorithm requires fewer comparisons and swaps, resulting in improved performance.
5. Online sorting: Insertion Sort is suitable for online sorting scenarios where the input list is continuously updated or new elements are added incrementally. It can efficiently maintain a sorted list by inserting new elements at the appropriate position without the need to re-sort the entire list.
6. Stable sorting: Insertion Sort is stable, meaning it preserves the relative order of elements with equal keys. If there are multiple elements with the same value, their original order will be maintained after sorting.

Despite these advantages, Insertion Sort has a time complexity of O(n^2) in the worst and average case, which makes it less efficient for large input sizes compared to more advanced sorting algorithms like Merge Sort or Quick Sort.

# Disadvantages of Insertion Sort:

---

Insertion Sort also has some disadvantages:

1. Quadratic time complexity: Insertion Sort has a time complexity of O(n^2) in the worst and average case, where n is the number of elements in the input list. This means that the algorithm's runtime grows quadratically with the size of the input. As a result, Insertion Sort becomes inefficient for large lists, making it impractical for sorting large datasets compared to more efficient algorithms like Merge Sort or Quick Sort.
2. Lack of scalability: Due to its quadratic time complexity, Insertion Sort does not scale well with increasing input sizes. As the number of elements grows, the number of comparisons and swaps required by the algorithm increases significantly, leading to longer execution times.
3. Performance sensitivity to initial order: Insertion Sort's performance can be highly dependent on the initial order of the elements. If the input list is already sorted or nearly sorted, Insertion Sort performs efficiently with fewer comparisons and swaps. However, if the list is in reverse order or contains elements that are far from their correct positions, the algorithm requires a larger number of comparisons and swaps, resulting in decreased performance.
4. Lack of parallelism: Insertion Sort does not naturally lend itself to parallelization. Since the algorithm operates by iteratively inserting elements into their correct positions, the order of operations is crucial. It is challenging to parallelize the process effectively, which limits its potential for leveraging parallel computing architectures.
5. Limited use in certain scenarios: While Insertion Sort can be suitable for small lists or partially sorted lists, it may not be the best choice for sorting larger datasets or in scenarios where time efficiency is critical. Other sorting algorithms, such as Merge Sort or Quick Sort, can provide better performance in those cases.

Overall, while Insertion Sort has its advantages in terms of simplicity, space efficiency, and adaptivity, its quadratic time complexity and limited scalability make it less preferable for large-scale sorting tasks.

# Real Scenarios of Insertion Sort:

---

Insertion Sort, despite its limitations, can still find practical uses in certain real-world scenarios. Here are a few examples:

1. Small or partially sorted lists: Insertion Sort performs well when the input list is small or already partially sorted. In scenarios where the list size is relatively small or the data is already partially ordered, Insertion Sort can be a reasonable choice due to its simplicity and efficiency in such cases. This could apply to tasks like sorting a small number of names, sorting a deck of cards, or maintaining a sorted list as new elements are added incrementally.
2. Online sorting: Insertion Sort is suitable for scenarios where elements are added to a list incrementally, and the list needs to remain sorted in real-time. For example, in applications that involve continuously receiving and sorting incoming data streams, such as log processing or event-driven systems, Insertion Sort can efficiently maintain the sorted order as new elements arrive.
3. Partial sorting or selection algorithms: Insertion Sort can be used as a component or subroutine in more complex algorithms. For example, in algorithms like Quick Select or Introselect, which are used to find the kth smallest element in a list, Insertion Sort can be employed as part of the partitioning process for small sublists. In these cases, Insertion Sort's efficiency for small lists can contribute to overall algorithmic performance.
4. Teaching and learning purposes: Due to its simplicity and ease of implementation, Insertion Sort is often used as a teaching tool to introduce the concepts of sorting algorithms. It helps students understand the basic principles of sorting and serves as a foundation for learning more advanced sorting algorithms.

It's important to note that while Insertion Sort has its practical applications, there are generally more efficient sorting algorithms available for most real-world scenarios involving larger datasets. However, in specific contexts where the characteristics of the data align with the strengths of Insertion Sort, it can still be a viable option.

# Python code for Insertion Sort:

---

```python
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
```

Explanation:

1.  Begin a loop iterating through each element in the array, starting from the second element (index 1) and ending at the last element (index n-1).
2.  Store the value of the current element being evaluated in a temporary variable called temp.
3.  Set up a pointer j to keep track of the current position in the array.(index)
4.  Start a while loop that continues as long as j is greater than 0 and the previous element (arr[j-1]) is greater than the value stored in temp.
5.  Shift the element at position j-1 to the position j.
6.  Decrement the value of j by 1 to continue comparing with the previous elements.
7. Place the value stored in temp at the position j, effectively inserting the value in its correct place.
8.  Print the sorted array, separated by spaces.

# C++ code for Insertion Sort:

---

```cpp
/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to sort a given array in order using Insertion sort algorithm.*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1)

//Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

#include<iostream>
// Include the input/output stream header file

using namespace std;
// Define the standard namespace for input/output operations
void VSDInsertionSort(int arr[],int n)
{
    for(int i=1;i<n;i++)
		{
        int temp=arr[i];
        int j=i;
        while(j>0 && arr[j-1]>temp){
            arr[j]=arr[j-1];
            j--;
        }
        arr[j]=temp;
// Place the value stored in temp at the position j, effectively inserting the value in its correct place
    }
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
// Move to the next line after printing all elements
}

int main(){
    int n;

    cout << "Enter the size of the array: ";
    cin >> n;

    int arr[n];

    cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    VSDInsertionSort(arr, n);
// Call the VSDInsertionSort function to sort the array
    return 0;
// Return 0 to indicate successful execution of the program
}
```

In summary, the program defines an "VSDInsertionSort" function to implement the insertion sort algorithm and a "main" function that initializes an array, calls the "VSDInsertionSort" function to sort the array, and then prints the sorted array.

This C++ program uses an iterative approach to implement the insertion sort algorithm, sorting the array in ascending order and outputting the sorted array to the console.

The "VSDInsertionSort" function sorts the elements of the array using the insertion sort algorithm and then prints the sorted array.

The "main" function initializes an array, calls the "VSDInsertionSort" function to sort the array, and returns 0 to signify successful completion of the program.

# Java code for insertion sort:

---

```java
/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

Java program to sort a given array in order using Insertion sort algorithm.*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1)

//Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

import java.util.Scanner;
public class insertionsort{
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i]; //key-> temporary variable,stores value of the current element being compared
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void printArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
				System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        insertionSort(array);
        printArray(array);
    }
}
```

1. Insertion Sort Method:
    - The "insertionSort" method implements the insertion sort algorithm to sort an array of integers in ascending order.
2. Print Array Method:
    - The "printArray" method is responsible for printing the elements of an array to the console.
3. Main Method:
    - The "main" method initializes an array of integers, calls the "insertionSort" method to sort the array, and then prints the sorted array using the "printArray" method.
