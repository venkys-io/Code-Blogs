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
```

### Step-by-Step Explaination:

1. **`import functools as f`:**
    - Imports the **`functools`** module and aliases it as **`f`**.
2. **`def compare(x, y):`**
    - Defines a custom comparison function named **`compare`**.
    - This function is used to compare two strings (**`x`** and **`y`**) for sorting.
3. **`def largestNumber(nums):`**
    - Defines a function **`largestNumber`** that takes a list of integers (**`nums`**) as input.
    - Converts the integers to strings, sorts them based on a custom comparison, and returns the largest number.
4. **`arr = list(map(str, nums))`:**
    - Converts each integer in the list **`nums`** to a string and stores the result in the list **`arr`**.
5. **`arr.sort(key=f.cmp_to_key(lambda x, y: compare(x + y, y + x)))`:**
    - Sorts the list **`arr`** using a custom comparison function.
    - The **`cmp_to_key`** function is used to convert the **`compare`** function into a key function suitable for sorting.
    - The sorting is based on the concatenated strings, and it's done in a way that maximizes the resulting number.
6. **`return "".join(arr).lstrip("0") or "0"`:**
    - Joins the sorted strings into a single string.
    - Removes leading zeros from the resulting string using **`lstrip("0")`**.
    - If the result is an empty string, it defaults to "0".

## C++ Code

```cpp
#include <bits/stdc++.h>

std::string largestNumber(std::vector<int> &num)
{
    std::vector<std::string> arr;
    for (auto i : num)
        arr.push_back(std::to_string(i));
    sort(begin(arr), end(arr), [](std::string &s1, std::string &s2)
         { return s1 + s2 > s2 + s1; });
    std::string res;
    for (auto s : arr)
        res += s;
    while (res[0] == '0' && res.length() > 1)
        res.erase(0, 1);
    return res;
}

int main()
{
    std::cout << "Enter multiple values separated by space, and press Enter:";
    std::vector<int> arr;
    int num;

    // Read input until a newline character is encountered
    while (std::cin >> num)
    {
        arr.push_back(num);

        // Check for newline character
        if (std::cin.peek() == '\n')
        {
            break;
        }
    }

    std::cout << "The largest number is: " << largestNumber(arr) << std::endl;
    return 0;
}
```

### Step-by-Step Explaination:

1. **`#include <bits/stdc++.h>`**: This is a header that includes most of the standard C++ headers.
2. **`std::string largestNumber(std::vector<int> &num)`**: This function takes a vector of integers and returns the largest number formed by concatenating the elements.
3. **`std::vector<std::string> arr;`**: This vector of strings will store the converted string representations of the input integers.
4. **`for (auto i : num) arr.push_back(std::to_string(i));`**: Converts each integer in the input vector to a string and adds it to the string vector.
5. **`sort(begin(arr), end(arr), [](std::string &s1, std::string &s2) { return s1 + s2 > s2 + s1; });`**: Sorts the string vector based on the concatenated values of the strings in descending order.
6. **`std::string res; for (auto s : arr) res += s;`**: Concatenates the sorted strings to form the result.
7. **`while (res[0] == '0' && res.length() > 1) res.erase(0, 1);`**: Removes leading zeros from the result, except if the result is "0".
8. **`std::cout << "Enter multiple values separated by space, and press Enter:";`**: Prints a prompt message to the console.
9. **`while (std::cin >> num) { ... }`**: Reads input integers from the user until a newline character is encountered.
10. **`std::cout << "The largest number is: " << largestNumber(arr) << std::endl;`**: Calls the function to find the largest number and prints the result.

## Java Code

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class largestnumber {

    // Function to find the largest number by concatenating elements of the array
    static String largestNumber(int[] nums) {
        // Convert the array of integers to an ArrayList of strings
        ArrayList<String> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(String.valueOf(i));
        }

        // Define a custom comparator for sorting strings
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                // Compare strings based on the concatenated values
                return (str2 + str1).compareTo(str1 + str2);
            }
        };

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
        // Example usage with an array of integers
        int[] nums = { 3, 30, 34, 5, 9 };
        System.out.println(largestNumber(nums));
    }
}
```

### Step-by-Step Explaination:

1. **`import java.util.ArrayList;`**, **`import java.util.Collections;`**, **`import java.util.Comparator;`**: Import necessary Java utility classes.
2. **`static String largestNumber(int[] nums) { ... }`**: This is the function to find the largest number. It takes an array of integers as input and returns the largest number formed by concatenating the elements.
3. **`ArrayList<String> arr = new ArrayList<>();`**: Creates an ArrayList to store strings.
4. **`for (int i : nums) { arr.add(String.valueOf(i)); }`**: Converts each integer in the array to a string and adds it to the ArrayList.
5. **`Comparator<String> comp = new Comparator<String>() { ... }`**: Defines a custom comparator for sorting strings. The **`compare`** method compares strings based on their concatenated values.
6. **`Collections.sort(arr, comp);`**: Sorts the ArrayList using the custom comparator. This sorts the strings in a way that maximizes the concatenated values.
7. **`StringBuilder ans = new StringBuilder();`**: Creates a StringBuilder to build the final result.
8. **`arr.forEach((s) -> { if (!s.equals("0")) { ans.append(s); } });`**: Iterates over the sorted ArrayList. For each string that is not "0", it is appended to the StringBuilder.
9. **`return ans.toString();`**: Returns the final result as a string.
10. **`public static void main(String[] args) { ... }`**: The main method where the function is called with an example array of integers (**`nums`**) and the result is printed.
11. **`int[] nums = { 3, 30, 34, 5, 9 };`**: Example array of integers.
12. **`System.out.println(largestNumber(nums));`**: Calls the function and prints the result.

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