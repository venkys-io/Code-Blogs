# Exploring Arrays : ThreeNumberSum

Today, we dive into the fascinating world of arrays and uncover one of their most captivating mysteries in arrays. Get ready to embark on an adventure that will challenge your mind and leave you with newfound insights into the power of arrays!

## Introduction to Arrays

An array is a collection of elements, each identified by an index or a key. The elements are stored in contiguous memory locations.

- **Fixed Size:** Arrays have a fixed size, meaning you must specify the number of elements it can hold when it is declared.
- **Homogeneous Elements:** All elements in an array must be of the same data type (e.g., integers, floating-point numbers, characters).

Arrays are widely used in programming for various operations such as traversal ,Search ,Insertion , Deletion , Sorting , Merging etc.

**Advantages:**

- **Random Access:** Elements can be accessed directly using their indices, providing constant-time access.
- **Memory Efficiency:** Contiguous memory allocation allows for efficient memory usage.

## ThreeNumberSum

The "Three Number Sum" problem is a well-known algorithmic problem that involves finding all unique triplets in an array whose sum equals a given target value. This problem is a variation of the more general "k-Sum" problem, where you are tasked with finding combinations of k elements that add up to a specific target.

### **Key Components:**

1. **Array of Integers:**
    - The input is an array of integers, and the algorithm aims to find three numbers within this array.
2. **Target Sum:**
    - The target sum is the value that the sum of the chosen triplet should equal.
3. **Unique Triplets:**
    - The solution should provide all unique triplets that satisfy the condition. Duplicate triplets should be avoided.

## Overview of Arrays

Arrays are declared by specifying the data type of their elements and the array's name. The syntax varies among programming languages.

Arrays are declared by specifying the data type of their elements and the array's name. The syntax varies among programming languages.

Individual elements are accessed using square brackets and the index.

Arrays support various operations, including reading, writing, searching, and sorting elements. The efficiency of these operations often depends on the programming language and the underlying implementation.

Arrays can have more than one dimension. For example, a 2D array is like a table with rows and columns.

## Code

```python
#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for Three Number Sum

# Twopointer Approach

def VSDthreesum(n,arr,target):
    ans=[]#the variable ans is initialized as an empty list.
    arr.sort()#input array ‘arr’ is sorted in ascending order using the sort() method.  
    for i in range(n-2):
        if (i==0 or (i>0 and arr[i]!=arr[i-1])):
            low=i+1
            high=n-1
            s=target-arr[i]
            while(low<high):
                if arr[low]+arr[high]==s:
                    ans.append([arr[i],arr[low],arr[high]])
                    while(low<high and arr[low]==arr[low+1]):
                        low+=1
                    while(low<high and arr[high]==arr[high-1]):
                        high-=1
                    low+=1
                    high-=1
                elif (arr[low]+arr[high])<s:
                    low+=1
                else:
                    high-=1
    if len(ans)>0:
        print("Resultant Triplets are: ",*ans)           
    else:
        print("No triplets")

if __name__=="__main__":#the function ‘VSDthreesum’ takes three parameters: n (length of the array), arr (the array of integers), and target (the target sum).
    n=int(input())
    arr=int(input())
    target=int(input())
    VSDthreesum(n,arr,target)
```

## Explanation

Now we have the basic understanding of arrays and the concept of ThreeNumberSum.

Let’s dive into the step-by-step process of ThreeNumberSum.

1. **Sort the Array:**
    - In the first step he input array ‘arr’ is sorted in ascending order using the sort() method. Sorting is a crucial step for the two-pointer approach to work efficiently
2. **Main Function:**
    - In this step the function ‘VSDthreesum’ takes three parameters: n (length of the array), arr (the array of integers), and target (the target sum).
3. **Initialize an Empty List (ans):**
    - In this step the variable ans is initialized as an empty list. This list will store the resultant triplets.
4. **Loop Over the Array (for i in range(n-2)):**
    - In this step, we iterate over the array from the first element to the third-to-last element. This ensures that we have enough remaining elements to form a triplet.
5. **Check for Duplicates (if (i==0 or (i>0 and arr[i]!=arr[i-1]))):**
    - We check if the current element is the first element or if it is not equal to the previous element. This avoids considering duplicate triplets.
6. **Initialize Pointers (low=i+1, high=n-1):**
    - We initialize two pointers, low and high, which represent the positions of the leftmost and rightmost elements of the remaining subarray.
7. **Calculate the Target Sum (s=target-arr[i]):**
    - We calculate the target sum by subtracting the current element (arr[i]) from the target sum (target).
8. **Two-Pointer Approach (while (low<high)):**
    - We use a two-pointer approach to find pairs of elements that sum up to the target sum. The low pointer starts from the element next to the current element, and the high pointer starts from the last element of the array.
9. **Check the Sum (if arr[low]+arr[high]==s):**
    - We check if the sum of the elements at the current positions of the low and high pointers equals the target sum. If it does, we have found a triplet. We add it to the ans list and move both pointers towards the center.
10. **Avoid Duplicate Elements (while (low<high and arr[low]==arr[low+1]) and while (low<high and arr[high]==arr[high-1])):**
    - We avoid considering duplicate elements by moving the low pointer to the next different element and the high pointer to the previous different element.
11. **Move Pointers (low+=1, high-=1):**
    - After avoiding duplicate elements, we move the low pointer to the next position and the high pointer to the previous position.
12. **Print Result (if len(ans)>0):**
    - Finally, we check if the ans list contains any triplets. If it does, we print the resultant triplets. Otherwise, we print "No triplets".

```java
// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for ThreeNumberSum

import java.util.Arrays;
import java.util.Scanner;

public class TripletSum {//the function tripletsum is defined.
    public static void findTriplets(int[] nums, int target) {
        // Sort the array for easier triplet identification
        Arrays.sort(nums);

        // Loop through the array to find triplets
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    System.out.println("Triplet found: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {//The **main** method initializes a **Scanner** object to take user input.
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the size of the array: ");
        //The size of the array is given.
        int size = scanner.nextInt();

        int[] nums = new int[size];
        // System.out.println("Enter the elements of the array:");
        //The elements to be entered into array.
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        // System.out.print("Enter the target sum: ");
        //The target is to be entered.
        int targetSum = scanner.nextInt();

        System.out.println(targetSum);//It prints the triplet with the sum.
        findTriplets(nums, targetSum);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
```

## Explanation

1. **Import Statements:**
    
    These import statements include the necessary Java classes for working with arrays (**`Arrays`**) and user input (**`Scanner`**).
    
2. **Class Declaration:**
    
    It defines a class named **`TripletSum`**.
    
3. **findTriplets Method:**
    
    This method takes an array of integers (**`nums`**) and a target sum (**`target`**) as parameters. It sorts the array in ascending order, which is a crucial step for efficiently finding triplets.
    
    This is the main logic of finding triplets. The outer loop (**`for`** loop) iterates through the array, and for each element at index **`i`**, it sets two pointers (**`left`** and **`right`**) initially pointing to the next and last elements, respectively.
    
    Inside the **`while`** loop, it calculates the current sum using elements at indices **`i`**, **`left`**, and **`right`**. If the current sum equals the target, it prints the triplet and increments **`left`** while decrementing **`right`**. If the current sum is less than the target, it increments **`left`**; otherwise, it decrements **`right`**.
    
4. **main Method:**
    
    The **`main`** method initializes a **`Scanner`** object to take user input.
    
    It prompts the user to enter the size of the array and then initializes an array **`nums`** with user-provided elements.
    
    It prompts the user to enter the target sum, prints a message indicating the target sum, and then calls the **`findTriplets`** method to find and print triplets with the given target sum. Finally, it closes the **`Scanner`** to avoid resource leaks.
    

```cpp
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for ThreeNumberSum
#include <iostream>
#include <algorithm>
//creating function 
void findThreeNumberSum(int nums[], int size, int target) {
    // Sort the array for easier triplet identification
    std::sort(nums, nums + size);

    // Loop through the array to find triplets
    for (int i = 0; i < size - 2; i++) {
        int left = i + 1;
        int right = size - 1;

        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];

            if (currentSum == target) {
                std::cout << "Triplet found: " << nums[i] << ", " << nums[left] << ", " << nums[right] << std::endl;
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
//the user is prompted to input the size of the array, followed by the array elements.
int main() {
    int size;
    // std::cout << "Enter the size of the array: ";
    //Need to provide or give the array size
    std::cin >> size;

    int nums[size];
    // std::cout << "Enter the elements of the array:" << std::endl;
    //the elements that are pushed into the array
    for (int i = 0; i < size; i++) {
        std::cin >> nums[i];
    }

    int targetSum;
    // std::cout << "Enter the target sum: ";
    //the value or the sum we need
    std::cin >> targetSum;

    std::cout <<  targetSum <<  std::endl;
    findThreeNumberSum(nums, size, targetSum);

    return 0;
}

```

## Explanation

#include <iostream>#include <algorithm>

These lines include necessary C++ libraries for input/output (iostream) and algorithms (algorithm), specifically the sort function that will be used later.

This function findThreeNumberSum takes three parameters: an array of integers (nums), the size of the array (size), and the target sum (target). It sorts the array in ascending order using **`std::sort`**. Then, it uses a nested loop to iterate through the array and find triplets whose sum equals the target.

The outer loop (**`for (int i = 0; i < size - 2; i++)`**) iterates through the array up to the third-to-last element. This is because the algorithm checks triplets, and the last two elements will be covered in the nested loop.

The inner **`while`** loop employs two pointers (**`left`** and **`right`**) to iterate towards each other. It calculates the current sum of the triplet at indices **`i`**, **`left`**, and **`right`**. If the sum equals the target, it prints the triplet and increments **`left`** and decrements **`right`**. If the sum is less than the target, it increments **`left`**; otherwise, it decrements **`right`**.

In the **`main`** function, the user is prompted to input the size of the array, followed by the array elements. Then, the user is asked to input the target sum. Finally, the **`findThreeNumberSum`** function is called with the provided array and target sum, and the triplets are printed.

## Time Complexities and Space Complexities

### **Time Complexity:**

The dominant factor in the time complexity is typically the sorting step. Let *n* be the length of the input array.

1. **Sorting:**
    - The sorting step takes *O*(*n*log*n*) time using algorithms like quicksort or mergesort.
2. **Two-Pointer Technique:**
    - The two-pointer technique involves a linear pass through the sorted array, which takes *O*(*n*) time.
3. **Total Time Complexity:**
    - The overall time complexity is *O*(*n*log*n*)+*O*(*n*)=*O*(*n*log*n*).

### **Space Complexity:**

1. **Sorting:**
    - The sorting step is typically an in-place operation, so it doesn't contribute to the space complexity.
2. **Other Variables:**
    - The additional space used for variables like pointers and temporary arrays is constant, *O*(1).
3. **Resultant Triplets:**
    - The space needed to store the resultant triplets is *O*(*m*), where *m* is the number of valid triplets.
4. **Total Space Complexity:**
    - The overall space complexity is *O*(1)+*O*(*m*)=*O*(*m*).
        
        

## Real World Applications

The ThreeNumberSum algorithm can be used in various real-world applications. For example, it can be applied in the field of finance to find three numbers in an array that add up to a specific target value, which can help identify investment opportunities or analyze market trends. Additionally, this algorithm can be used in data analysis to find combinations of three variables that satisfy certain conditions, aiding in the discovery of patterns or correlations.

The ThreeNumberSum algorithm can also be used in the field of computational biology to identify gene networks or protein interactions. By finding three genes or proteins that interact with each other, researchers can gain insights into the underlying mechanisms of diseases or biological processes. Furthermore, this algorithm can be applied in social network analysis to identify groups of three individuals with strong connections, which can help in understanding social dynamics and influence patterns. Overall, the ThreeNumberSum algorithm has versatile applications across different domains.

## Test Cases

Test Case 1:
**Input:**
```
6
[-1, 0, 1, 2, -1, -4]
0
```

**Output:**
```
Resultant Triplets are:  [-1, -1, 2] [-1, 0, 1]
```

**Explanation:**
- The program takes the input array `[-1, 0, 1, 2, -1, -4]`, target `0`, and `n = 6`.
- It sorts the input array in ascending order: `[-4, -1, -1, 0, 1, 2]`.
- It then iterates through the array to find triplets such that their sum equals the target.
- In this case, it finds two unique triplets: `[-1, -1, 2]` and `[-1, 0, 1]`.
- The program prints the resultant triplets.

Test Case 2:
**Input:**
```
8
[-2, -1, 0, 0, 1, 2, 3, 4]
0
```

**Output:**
```
Resultant Triplets are:  [-2, 0, 2] [-1, 0, 1]
```

**Explanation:**
- The program takes the input array `[-2, -1, 0, 0, 1, 2, 3, 4]`, target `0`, and `n = 8`.
- It sorts the input array in ascending order: `[-2, -1, 0, 0, 1, 2, 3, 4]`.
- It then iterates through the array to find triplets such that their sum equals the target.
- In this case, it finds two unique triplets: `[-2, 0, 2]` and `[-1, 0, 1]`.
- The program prints the resultant triplets.
