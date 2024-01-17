# **Exploring String Algorithms : Largest Number**

Dive into the realm of particular emphasis on uncovering the largest number problem through the utilization of string algorithm. This intriguing challenge not only captivates but also offers a practical avenue to delve into the intricacies of data structures and foster algorithmic thinking.

# Introduction to String Algorithms

String algorithms, a versatile toolkit for tackling an array of computational challenges. String algorithms, designed for the manipulation and analysis of sequences of characters, are essential in addressing a wide spectrum of problems in computer science. Within this domain, string algorithms prove instrumental in tasks such as pattern matching, substring search, and the optimization of various string-related operations.

As we explore, we'll know much about fundamental string algorithms, examining techniques like string matching, regular expressions, and dynamic programming. Join this journey into the heart of string manipulation, where the algorithms we encounter will become indispensable tools for deciphering, analyzing, and extracting valuable information from the world of characters and text.

One of the case in string algorithms is Largest number.

## Largest Number

The provided Python code aims to find the largest number that can be formed by concatenating a list of integers. This is achieved through a custom comparison function used in the sorting process. The goal is to arrange the integers in a way that, when concatenated, results in the maximum possible numerical value.

## Python Code

```python
import functools as f

# Custom comparison function for sorting strings
def compare(x, y):
    return (x < y) - (x > y)

# Function to find the largest number by concatenating elements of the list
def largestNumber(nums):
    # Convert the list of integers to a list of strings
    arr = list(map(str, nums))
    
    # Sort the list of strings using a custom comparison function
    arr.sort(key=f.cmp_to_key(lambda x, y: compare(x + y, y + x)))

    # Join the sorted strings, remove leading zeros, or return "0" if the result is empty
    return "".join(arr).lstrip("0") or "0"

# Main block
if __name__ == "__main__":
    # Convert the input string to a list of integers
    nums=[int(x) for x in input("Enter multiple value: ").split(" ")]
    # print the list
    print(nums)
    # Call the function and print the result
    result = largestNumber(nums)
    print(f"The largest number is: {result}")

# Enter multiple value: 21 23 43 56 9 98
# [21, 23, 43, 56, 9, 98]
# The largest number is: 99856432321
```

### Step-by-Step Explaination:

1. **Import Statement:**
    
    ```python
    import functools as f
    ```
    
    This line imports the **`functools`** module and aliases it as **`f`** for brevity.
    
2. **Custom Comparison Function:**
    
    ```python
    def compare(x, y):
        return (x < y) - (x > y)
    ```
    
    The **`compare`** function is a custom comparison function that returns **`-1`** if **`x`** is less than **`y`**, **`0`** if they are equal, and **`1`** if **`x`** is greater than **`y`**.
    
3. **`largestNumber` Function:**
    
    ```python
    def largestNumber(nums):
    ```
    
    This function takes a list of integers (**`nums`**) as input and returns a string representing the largest number formed by concatenating the elements.
    
    ```python
            arr = list(map(str, nums))
    ```
    
    The list comprehension converts each integer in **`nums`** to a string, creating a new list **`arr`** of strings.
    
    ```python
        arr.sort(key=f.cmp_to_key(lambda x, y: compare(x + y, y + x)))
    ```
    
    The **`sort`** method is used to sort the list of strings using a custom key function. The key function, created using **`cmp_to_key`**, compares the concatenation of **`x + y`** and **`y + x`**, ensuring the list is sorted in a way that maximizes the concatenated value.
    
    ```python
        return "".join(arr).lstrip("0") or "0"
    ```
    
    The sorted strings are joined into a single string, leading zeros are removed using **`lstrip("0")`**, and if the result is empty, "0" is returned.
    
4. **Main Block:**
    
    ```python
    if __name__ == "__main__":
    ```
    
    This conditional statement checks if the script is being run as the main program.
    
    ```python
        nums = [int(x) for x in input("Enter multiple values: ").split(" ")]
    ```
    
    The user is prompted to enter multiple values separated by spaces. The input string is then split into a list of integers.
    
    ```python
        print(nums)
    ```
    
    The list of integers is printed to the console.
    
    ```python
        result = largestNumber(nums)
        print(f"The largest number is: {result}")
    ```
    
    The **`largestNumber`** function is called with the list of integers, and the result is printed to the console.
    

## C++ Code

```cpp
#include <iostream>
#include <vector>
#include <algorithm>
#include <string> // Add this line to include the necessary header for to_string

std::string largestnumber(std::vector<int> &num)
{
    // Convert each integer to a string and store in a vector
    std::vector<std::string> arr;
    for (auto i : num)
        arr.push_back(std::to_string(i));

    // Sort the strings in descending order based on their concatenated values
    std::sort(begin(arr), end(arr), [](const std::string &s1, const std::string &s2)
              { return s1 + s2 > s2 + s1; });

    // Concatenate the sorted strings to form the largest number
    std::string res;
    for (auto s : arr)
        res += s;

    // Remove leading zeros, except when the result is "0"
    while (res[0] == '0' && res.length() > 1)
        res.erase(0, 1);

    // Return the result as a string
    return res;
}

int main()
{
    // Prompt the user to enter multiple values separated by space
    std::cout << "Enter multiple values separated by space, and press Enter:";

    // Create a vector to store the input numbers
    std::vector<int> arr;
    int num;

    // Read input until a newline character is encountered
    while (std::cin >> num)
    {
        // Add the entered number to the vector
        arr.push_back(num);

        // Check for newline character
        if (std::cin.peek() == '\n')
        {
            break;
        }
    }

    // Find and display the largest number
    std::cout << "The largest number is: " << largestnumber(arr) << std::endl;

    // Return 0 to indicate successful execution
    return 0;
}

// Enter multiple values separated by space, and press Enter:21 23 34 54 9 98 987
// The largest number is: 99898754342321
```

### Step-by-Step Explaination:

1. **`<iostream>`**: This header file provides functionality for input and output operations using streams. It includes declarations for **`cin`** (standard input stream) and **`cout`** (standard output stream), among other things.**`<vector>`**: This header file includes declarations for the C++ Standard   Template Library (STL) vector container. Vectors are dynamic arrays that can grow or shrink in size, making them useful for storing sequences of elements.**`<algorithm>`**: This header file includes declarations for various template functions that operate on ranges of elements, such as sorting, searching, and manipulating algorithms. In this code, it is used for the **`std::sort`** function
2. **`largestNumber` Function:**

      **Function Signature:**

```cpp
std::string largestNumber(std::vector<int>& num)
```

This function takes a reference to a vector of integers and returns a string.

   **Conversion to Strings:**

```cpp
std::vector<std::string> arr;
for (auto i : num)
    arr.push_back(std::to_string(i));
```

It converts each integer in the input vector (**`num`**) to a string and stores them in a new vector (**`arr`**).

    **Sorting:**

```cpp
std::sort(begin(arr), end(arr), [](const std::string& s1, const std::string& s2)
    { return s1 + s2 > s2 + s1; });
```

The strings in the **`arr`** vector are sorted in descending order based on their concatenated values. This custom sorting is achieved using a lambda function as the comparison criterion.

    **Concatenation:**

```cpp
std::string res;
for (auto s : arr)
    res += s;
```

The sorted strings are concatenated to form a single string (**`res`**), representing the largest number.

    **Leading Zeros Removal:**

```cpp
while (res[0] == '0' && res.length() > 1)
    res.erase(0, 1);
```

Leading zeros are removed from the resulting string, except when the result is "0".

    **Return Statement:**

```cpp
return res;
```

The final result, representing the largest number, is returned as a string.

1. **`main` Function:**

    **User Input:**

```cpp
std::vector<int> arr;
int num;
while (std::cin >> num)
{
    arr.push_back(num);
    if (std::cin.peek() == '\n')
    {
        break;
    }
}
```

The program prompts the user to enter multiple values separated by space and reads these values into a vector (**`arr`**). It continues reading until a newline character is encountered.

    **Function Call and Output:**

```cpp
std::cout << "The largest number is: " << largestNumber(arr) << std::endl;
```

The **`largestNumber`** function is called with the vector of input numbers (**`arr`**), and the result (largest number) is displayed to the console.

    **Return Statement:**

```cpp
return 0;
```

The **`main`** function returns 0 to indicate successful program execution.

## Java Code

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class largestnumber {

    // Function to find the largest number by concatenating elements of the array
    static String largestNumber(int[] nums) {
        // Convert the array of integers to an ArrayList of strings
        ArrayList<String> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(String.valueOf(i));
        }

        // Define a custom comparator for sorting strings
        Comparator<String> comp = (str1, str2) -> (str2 + str1).compareTo(str1 + str2);

        // Sort the ArrayList using the custom comparator
        Collections.sort(arr, comp);

        // Build the result by appending non-zero strings
        StringBuilder ans = new StringBuilder();
        arr.forEach((s) -> {
            if (!s.equals("0")) {
                ans.append(s);
            }
        });

        // Return the result as a string
        return ans.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Prompt the user to enter the size of the array
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            // Prompt the user to enter elements of the array
            System.out.println("Enter the elements of the array:");

            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }

            // Find and display the largest number
            System.out.println("The largest number is: " + largestNumber(nums));
        } catch (Exception e) {
            // Handle exceptions such as non-integer input
            e.printStackTrace();
        }
    }
}

// Enter the size of the array: 5
// Enter the elements of the array:
// 21 23 43 9 98
// The largest number is: 998432321
```

### Step-by-Step Explaination:

1. **Import Statements:**
    
    ```java
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.Scanner;
    ```
    
    These lines import necessary classes for working with ArrayLists, sorting, custom comparators, and user input.
    
2. **Class Declaration:**
    
    ```java
    public class largestnumber {
    ```
    
    This line declares a class named **`largestnumber`**.
    
3. **`largestNumber` Method:**
    
    ```java
    static String largestNumber(int[] nums) {
    ```
    
    This method takes an array of integers as input and returns a string representing the largest number formed by concatenating the elements.
    
    ```java
        ArrayList<String> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(String.valueOf(i));
        }
    ```
    
    The method starts by converting the array of integers into an ArrayList of strings.
    
    ```java
        Comparator<String> comp = (str1, str2) -> (str2 + str1).compareTo(str1 + str2);
    ```
    
    Next, a custom comparator (**`comp`**) is defined using a lambda expression. This comparator is used to sort the strings in a way that maximizes their concatenated value.
    
    ```java
        Collections.sort(arr, comp);
    ```
    
    The ArrayList of strings is then sorted using the custom comparator.
    
    ```java
        StringBuilder ans = new StringBuilder();
        arr.forEach((s) -> {
            if (!s.equals("0")) {
                ans.append(s);
            }
        });
    ```
    
    A **`StringBuilder`** (**`ans`**) is used to build the result by appending non-zero strings from the sorted ArrayList.
    
    ```java
        return ans.toString();
    ```
    
    The final result is converted to a string and returned.
    
4. **`main` Method:**
    
    ```java
    public static void main(String[] args) {
    ```
    
    The main method is the entry point of the program.
    
    ```java
        try (Scanner scanner = new Scanner(System.in)) {
    ```
    
    The **`try`** block initializes a **`Scanner`** for user input.
    
    ```java
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
    ```
    
    The user is prompted to enter the size of the array, and the input is stored in the variable **`size`**.
    
    ```java
            System.out.println("Enter the elements of the array:");
    ```
    
    The user is prompted to enter the elements of the array.
    
    ```java
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = scanner.nextInt();
            }
    ```
    
    An array **`nums`** is created with the specified size, and the user is prompted to enter each element, which is stored in the array.
    
    ```java
            System.out.println("The largest number is: " + largestNumber(nums));
    ```
    
    The **`largestNumber`** method is called with the array as an argument, and the result is printed to the console.
    
    ```java
        } catch (Exception e) {
            e.printStackTrace();
        }
    ```
    
    The **`catch`** block catches any exceptions that might occur during user input and prints the stack trace.
    

## Time and Space Complexity Analysis

### Time Complexity :

- The dominant factor contributing to the time complexity is the sorting operation.
- The **`sort`** method uses a variant of TimSort, which is a hybrid sorting algorithm derived from merge sort and insertion sort.
- The time complexity for sorting is O(n log n), where n is the number of elements in the input array.

### Space Complexity :

- Additional space is used for the ArrayList **`arr`** to store string representations of integers.
- The space complexity is O(n), where n is the number of elements in the input array.

In summary, the time complexity for sorting in all three languages is O(n log n), and the space complexity is O(n).

## Real world Applications

This type of problem has various real-world applications, especially in scenarios where arranging numbers in a specific way is crucial. Here are some examples:

1. **Financial Transactions:**
    - In finance, when dealing with currency or stock prices, arranging numbers to form the largest or smallest possible value can be important. This can impact decisions related to investments, trading, or financial analysis.
2. **Telecommunications:**
    - In telecommunications, phone numbers often need to be sorted or arranged in a specific order. The largest possible arrangement might be important for certain applications or services.
3. **Job Scheduling:**
    - In job scheduling or task optimization, arranging tasks based on certain criteria can be crucial. For example, scheduling jobs based on their execution time or priority can be seen as arranging numbers to achieve optimal results.
4. **Version Numbers:**
    - When working with software version numbers, arranging them in a way that reflects the latest or highest version is common. This is relevant in software development and release management.
5. **Genetic Sequencing:**
    - In bioinformatics, when working with genetic sequences represented as numbers, arranging them in a certain way may have significance for analysis or comparison.
6. **Database Sorting:**
    - Sorting or arranging records in databases is a common operation. In some cases, sorting based on a combination of fields, similar to concatenating strings, can be important.
7. **Digital Marketing:**
    - When dealing with metrics like click-through rates or conversion rates in digital marketing, arranging or sorting these numbers in a certain order can be valuable for analysis and decision-making.
8. **Supply Chain Management:**
    - In logistics and supply chain management, arranging shipments or orders based on criteria like cost, delivery time, or priority can be essential for efficient operations.
9. **Data Analytics:**
    - In data analytics, arranging data points based on specific criteria can help identify trends, outliers, or patterns more effectively.
10. **Mobile Number Formatting:**
    - In telecommunications and contact management applications, arranging mobile numbers in a way that reflects a standardized or optimal format can be useful.

These are just a few examples, and the applicability of the code depends on specific use cases where arranging or sorting numbers is an important aspect of the problem at hand.