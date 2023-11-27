# **COUNTING SORT**

In this article, we will explore the counting sort algorithm, its importance, and applications. We will provide a step-by-step explanation of how counting sort works and present an example to illustrate its effectiveness.


## **Introduction**

Counting Sort is an efficient, non-comparative sorting algorithm that is used to sort integers or objects with a small range of key values. It works by counting the number of elements with distinct key values (often called "counting" the occurrences) and then using this information to determine the final sorted order of the elements. Counting Sort is particularly effective when the range of possible input values is known in advance.

## **Overview of Counting Sort Algorithm**

Counting sort is a non-comparative integer sorting algorithm that sorts elements based on their frequencies. It works by counting the occurrences of each element and using that information to determine their positions in the sorted output.

### **Counting Sort Algorithm**

The algorithm assumes that each element in the list is an integer between a minimum and maximum value. It creates a count array with a size equal to the range of values in the input list, and then iterates through the input list, incrementing the count array at the index corresponding to each element. Finally, it iterates through the count array and outputs the sorted list.

here is an example of counting sort with a step-by-step explanation:

**Step 1: Create a count array**

The count array will have one element for each possible value in the input array. In this example, the input array is `[5, 3, 2, 1, 4]`, so the count array will have six elements, one for each value from 0 to 5.

The count array will have six elements, one for each value from 0 to 5:

`count_array = [0, 0, 0, 0, 0, 0]`

**Step 2: Initialize the count array**

Set all of the elements in the count array to 0.

`count_array = [0, 0, 0, 0, 0, 0]`

**Step 3: Iterate through the input array and increment the corresponding element in the count array for each value that we encounter**

For each element in the input array, increment the corresponding element in the count array. In this example, we will increment the first element in the count array because the first element in the input array is 5. We will then increment the second element in the count array because the second element in the input array is 3, and so on.

For each element in the input array, increment the corresponding element in the count array:

`count_array = [1, 1, 1, 1, 1, 0]`

**Step 4: Iterate through the count array and place the elements in the input array in their correct sorted positions based on their counts**

Starting at the beginning of the input array, place each element in the input array at the position indicated by the corresponding element in the count array. For example, we will place the first element in the input array at position 5 because the first element in the count array is 5. We will then place the second element in the input array at position 3 because the second element in the count array is 3, and so on.

`sorted_array = [5, 3, 2, 1, 4]`

## **CODE**
### PYTHON
```PYTHON
# Copyrights to venkys.io
#For more information, visit https://venkys.io 
# python code for the counting sort 

#Function to get maximum element in the array
def VSDmax(a):
    maxele=0
    for i in a:
        if i>maxele:
            maxele=i
    return maxele
    # or return max(a)

#Function to perform counting sort

def VSDCountingSort(max:int,n,a):
    count=[0 for i in range(max+1)]    
    output=[None for i in range(n)]
    for j in range(n):
        count[a[j]]+=1
    for i in range(1,len(count)):        
        count[i]+=count[i-1]
       
    for i in reversed(range(n)) :      
        output[count[a[i]]-1]=a[i]
        count[a[i]]-=1 
    
    print(*output,sep=" ")   

if __name__ == "__main__":
    arr=[2,24,12,96, 456, 899,34,1,1,2,3,4,5,4,3]
    n=len(arr)
    max=VSDmax(arr) 
    VSDCountingSort(max,n,arr)

```

## **Step-by-Step Explanation** 

**VSDmax Function**: This function finds the maximum element in the input array **a**. It iterates through the elements of the array and keeps track of the maximum element it encounters.

- It initializes **maxele** to 0.
- It loops through the elements of the input array **a**.
- If the current element **i** is greater than the current maximum **maxele**, it updates **maxele**.
- Finally, it returns the maximum element found in the array.

**VSDCountingSort Function**: This function performs the Counting Sort algorithm. It takes as input the maximum value (**max**), the length of the array (**n**), and the array itself (**a**).

- It first creates an array **count** of size **max + 1** and initializes all its elements to 0. This array will be used to count the occurrences of each element in the input array.
- It initializes an output array with the same size as the input array, initially filled with **None**.
- It then goes through the input array **a** and counts the occurrences of each element, storing the counts in the **count** array.
- Next, it performs cumulative counting. It calculates the cumulative counts by adding the current count to the previous count for each value in the **count** array. This step helps determine the correct positions for each element in the sorted output.
- Finally, it iterates through the input array in reverse order. For each element, it finds its position in the sorted output using the **count** array and places it in the **output** array at the correct position.
- After sorting, it prints the sorted array with elements separated by spaces.

**Main Section**: In the main section of the code, an example array **arr** is defined, and the **VSDmax** function is called to find the maximum element. Then, the **VSDCountingSort** function is called to sort the array.

- **arr** is defined with some example integer values.
- The length of the array **n** is calculated.
- The **VSDmax** function is called to find the maximum element and store it in the **max** variable.
- Finally, the **VSDCountingSort** function is called to sort the array and print the sorted result.

When you run the code, it will sort the input array using Counting Sort and display the sorted array as the output.

## CODE
### JAVA 
```java

/* Copyrights to venkys.io
For more information, visit https://venkys.io  */
/*Java program for Counting sort*/

import java.util.Scanner;
public class Main {
	
	static int output[];

	//Function to perform counting sort
	public static void VSDsort(int n,int a[],int max)
     {
		int count[]=new int[max+1];
        
		output=new int[n];
		for(int i=0;i<count.length;i++)
			count[i]=0;
		
        //Storing the count of occurances of each element from input array to count array

		for(int i=0;i<n;i++)
			count[a[i]]++;
		for(int i=1;i<count.length;i++)
			count[i]+=count[i-1];
		//For every element in input array find the cumulative sum from the respective index of count array
		//And insert theinput element in output array at index of cumulative sum-1
		for(int i=n-1;i>=0;i--)
			{
				output[count[a[i]]-1]=a[i];
				count[a[i]]--;
			}
	}

	//Function to get maximum element in the array

		public static int VSDMax(int n,int[] a)
         {
			int max=0;
			for(int i=0;i<n;i++) {
				if(a[i]>max) {
					max=a[i];
				}
			}
			return max;
		}
	
	//Function to print the output

		public static void VSDprintOutput()
         {
			System.out.println("The sorted array is:");
			for(int i=0;i<output.length;i++)
				System.out.print(output[i]+" ");
			
			System.out.println();
		}
	
        public static void main(String args[])
         {

	        int[] a={1, 2, 53, 12, 45, 11, 56,3,8,3,4,};
	        int n=a.length;
	        int max=VSDMax(n,a);
	        VSDsort(n,a,max);
	        VSDprintOutput();
        }
}

```
## **Step-by-Step Explanation** 
Here is a step-by-step explanation of the Counting Sort Java code that you provided, with more details:

1. **Create a temporary array called count[] to store the count of each element in the input array.**
    
    The count[] array will have one element for each possible value in the input array. The size of the count[] array is determined by the maximum value in the input array. In the example you provided, the input array contains values from 1 to 56, so the count[] array will have 57 elements.
    
2. **Initialize all the elements of the count[]array to 0.**
    
    This ensures that each element in the count[] array will accurately reflect the number of times that the corresponding element appears in the input array.
    
3. **Iterate through the input array and increment the corresponding element in the count[] array for each element that it encounters.**
    
    For each element in the input array, the program increments the corresponding element in the count[] array. This means that for each element in the input array, the count[] array will store the number of times that that element appears in the input array.
    
4. **Compute the cumulative sum from the count[] array.**
    
    The cumulative sum of the count[] array is an array that contains the sum of all the elements in the count[] array up to that point. For example, the cumulative sum of the count[] array in the example you provided would be:
    
    `[1, 3, 6, 10, 22, 35, 57]`
    
    The cumulative sum of the count[] array is used to determine the position of each element in the sorted output array.
    
5. **Iterate through the input array again and insert each element into the output array at the index indicated by the corresponding cumulative sum in the count[] array.**
    
    Starting from the end of the input array, the program inserts each element in the input array into the output array at the index indicated by the corresponding cumulative sum in the count[] array. This ensures that the elements in the output array will be sorted in ascending order.
    
6. **Print the sorted output array.**
    
    Once the program has inserted all of the elements from the input array into the output array, it prints the output array to the console.
    

Here is an example of how the program would work to sort the input array `[1, 2, 53, 12, 45, 11, 56, 3, 8, 3, 4]`.

## CODE
### C++

```cpp

//Copyrights to venkys.io
//For more information, visit https://venkys.io 


#include<iostream>

using namespace std;

void countingSort(int max,int n,int arr[],int output[])
{
	// Find the maximum element in the array
    int count[max+1]; 
    for(int i=0;i<=max;i++){
        count[i]=0;
    }
    // int output[n];
    for(int j=0;j<n;j++){
        count[arr[j]]+=1;
    }
	// Modify the counting array to store cumulative counts
    for(int i=1;i<=max;i++){
        count[i]+=count[i-1];
    }

    for(int i=0;i<n;i++){
        output[count[arr[i]]-1]=arr[i];
    }
// Place the elements in their sorted order
    for(int i=n-1;i>0;i--){
        output[count[arr[i]]-1]=arr[i];
        count[arr[i]]--;

    }
    

}
//the maximum element in the input array.
int VSDmax(int arr[],int n){
    int maxele=arr[0];
    for(int i=0;i<n;i++){
        if(arr[i]>maxele){
            maxele=arr[i];
        }
    }
    return maxele;
}
int main(){
    int n=7;
    int arr[]={2,24,12,96, 456, 899,34};
    int max=VSDmax(arr,n);
    int output[n];
    countingSort(max,n,arr,output);
    for(int i=0;i<n;i++)
                cout<<output[i];
    return 0;
}
```
## **Step-by-Step Explanation** 
Here is a step-by-step explanation of the Counting Sort Java code that you provided, with more details:

1. **Create a temporary array called count[] to store the count of each element in the input array.**

The count[] array will have one element for each possible value in the input array. The size of the count[] array is determined by the maximum value in the input array. In the example you provided, the input array contains values from 1 to 56, so the count[] array will have 57 elements.

1. **Initialize all the elements of the count[] array to 0.**

This ensures that each element in the count[] array will accurately reflect the number of times that the corresponding element appears in the input array.

1. **Iterate through the input array and increment the corresponding element in the count[] array for each element that it encounters.**

For each element in the input array, the program increments the corresponding element in the count[] array. This means that for each element in the input array, the count[] array will store the number of times that that element appears in the input array.

1. **Compute the cumulative sum from the count[] array.**

The cumulative sum of the count[] array is an array that contains the sum of all the elements in the count[] array up to that point. For example, the cumulative sum of the count[] array in the example you provided would be:

`[1, 3, 6, 10, 22, 35, 57]`

The cumulative sum of the count[] array is used to determine the position of each element in the sorted output array.

1. **Iterate through the input array again and insert each element into the output array at the index indicated by the corresponding cumulative sum in the count[] array.**

Starting from the end of the input array, the program inserts each element in the input array into the output array at the index indicated by the corresponding cumulative sum in the count[] array. This ensures that the elements in the output array will be sorted in ascending order.

1. **Print the sorted output array.**

Once the program has inserted all of the elements from the input array into the output array, it prints the output array to the console.

Here is an example of how the program would work to sort the input array `[1, 2, 53, 12, 45, 11, 56, 3, 8, 3, 4]`.

## **Time and Space Complexity Analysis**

Counting Sort has a time complexity of O(n+k) and a space complexity of O(n+k). Where n is the number of elements in the input array and k is the range of the values in the input array. This makes it efficient and a great choice for sorting large amounts of data.

n the worst case, when the range of values (k) is much larger than the number of elements (n), the space complexity can be dominated by the **count** array

## **real-time applications**

Counting Sort is a simple and efficient sorting algorithm that is well-suited for specific real-time applications where certain conditions are met. Its effectiveness is primarily dependent on the range of input values. Here are some real-time applications where Counting Sort can be useful:

1. **Integer Sorting with Small Range:**
Counting Sort is most efficient when the range of input values is relatively small compared to the number of elements. It can be used in applications where you need to sort integers with a limited range, such as sorting grades (e.g., A, B, C, D, F) or ages (e.g., 0-100) in educational systems.
2. **Radix Sort Implementation:**
Counting Sort is a key component of the Radix Sort algorithm. Radix Sort is used in real-time applications, particularly when sorting large datasets with integer keys, such as sorting records in databases or managing network traffic based on IP addresses.
3. **Data Preprocessing for Histograms:**
Counting Sort is useful for preparing data for histogram generation, which is commonly used in data analysis and visualization. It can efficiently count the occurrences of data points within a specific range or category.
4. **Digital Signal Processing (DSP):**
In real-time DSP applications, you may need to sort data points within a predefined range, such as audio signal amplitudes or pixel values in image processing. Counting Sort can be applied to efficiently process and sort this type of data.
5. **Parallel Processing and GPU Computing:**
Counting Sort can be easily parallelized, making it suitable for GPU (Graphics Processing Unit) computing. In real-time applications like image processing, GPU-accelerated Counting Sort can significantly speed up the sorting process.
6. **Efficient Sorting in Limited Memory Environments:**
Counting Sort can be valuable in real-time systems with limited memory resources, such as embedded systems, IoT devices, or microcontrollers. Its memory-efficient nature can be advantageous in such contexts.
7. **Color Sorting in Computer Vision:**
In computer vision applications, colors are often represented as RGB or HSV values. Counting Sort can be applied to sort colors by their individual components (e.g., sorting by hue) or other numeric properties.
8. **Resource Scheduling in Real-Time Operating Systems (RTOS):**
In RTOS environments, tasks or processes can be sorted based on their priority levels or execution times using Counting Sort. This aids in efficient task scheduling.
9. **Data Streaming and Packet Sorting:**
In network packet processing, data streams can be sorted by packet attributes like source IP address or packet size. Counting Sort can help optimize the handling of incoming data packets.
10. **Sorting Events or Timestamps:**
Counting Sort can be used to sort events or timestamps in various real-time applications, such as log file analysis, event-driven systems, and financial trading platforms.

Remember that Counting Sort's suitability depends on the specific requirements of your real-time application, and it may not be the best choice for all sorting scenarios. It excels when you have a limited range of integer values to sort and can be an excellent choice in the right context.