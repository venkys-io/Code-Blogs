# **Reverse String**

In programming, reversing a string means changing the order of its characters. For instance, "olleH" would be the result of reversing the string "Hello". In many programming languages, reversing a string is a common task that can be applied to a variety of problems.

## **Introduction to Reverse String**

Reversing a string can be done in a variety of ways, from basic iterative processes to advanced methods. The programming language being used and the demands of the particular challenge may influence the solution that is selected.

One of the main concepts in programming that may help in the development of problem-solving abilities is the ability to reverse a string.

Reversing a string can be done easily by iterating through the characters and appending them to a new string in the opposite order. Depending on the programming language, either a loop or an integrated string manipulation method can be used to do this. Recursion is an alternative strategy in which the function calls itself to reverse the original string's substrings. Both approaches are capable of producing the intended outcome and are implementable in accordance with the particular needs of the current problem.

## **Overview of Reverse String**

Reversing a string involves changing the order of its characters. It is a common task in programming and can be useful in solving various problems. There are multiple approaches to reverse a string, including iterative methods and recursion. The chosen method depends on the programming language and the specific problem requirements. Reversing a string is a fundamental concept in programming and helps in developing problem-solving skills.

## **Code**

### PYTHON

```python

# Copyrights to venkys.io
#  For more information, visit venkys.io
# Write a function that reverses a string. The input string is given as an array of characters s.
# time Complexity :O(n/2),
# Space Complexity :O(1)

# Example 1:

# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]

# Example 2:

# Input: s = ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]

# Function to reverse a string
def reverse_string(input_string):
    # Using slicing to reverse the string
    reversed_string = input_string[::-1]
    return reversed_string

# Getting user input
user_input = input("Enter a string: ")

# Reversing the user input using the reverse_string function
result = reverse_string(user_input)

# Displaying the reversed string
print("Reversed String:", result)

```

### Step-by-Step Explanation

1. The code begins with the definition of a function called reverse_string, which takes an input string as a parameter.
2. Inside the function, the input string is reversed using slicing. The syntax input_string[::-1] reverses the string by accessing its elements in reverse order. The reversed string is stored in the variable reversed_string.
3. The function then returns the reversed string.
4. Next, the code prompts the user to enter a string by using the input() function. The user's input is stored in the variable user_input.
5. The reverse_string function is called with user_input as the argument, and the result is stored in the variable result.
6. Finally, the code displays the reversed string by printing "Reversed String:" followed by the value of result.

This code demonstrates how to reverse a string by modifying the input array in-place, without using any additional memory.

### JAVA

```java
// Copyrights to venkys.io
// For more information, visit - venkys.io
// time Complexity :O(n/2),
// Space Complexity :O(1)

// Example 1:

// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]

import java.util.Scanner;

public class ReverseString {
    // Function to reverse a string
    public static String reverseString(String inputString) {
        // Using StringBuilder to efficiently reverse the string
        StringBuilder reversedString = new StringBuilder(inputString);
        reversedString.reverse();
        return reversedString.toString();
    }

    public static void main(String[] args) {
        // Getting user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Reversing the user input using the reverseString function
        String result = reverseString(userInput);

        // Displaying the reversed string
        System.out.println("Reversed String: " + result);
    }
}
```

### Step-by-Step Explanation

1. The code defines a class named "ReverseString".
2. Inside the "ReverseString" class, there is a function named "reverseString" that takes an input String as a parameter and returns a reversed string.
3. The function uses a StringBuilder to efficiently reverse the inputString. It initializes a StringBuilder object with the inputString and then calls the reverse() method on it. The reversed string is then converted back to a regular string using the toString() method of the StringBuilder class.
4. The main() method is where the program execution starts. It prompts the user to enter a string and reads the input using the Scanner class.
5. The main() method calls the reverseString() function, passing the user input as an argument, and stores the result in a variable named "result".
6. Finally, the program displays the reversed string by printing the "Reversed String: " followed by the value of the "result" variable.
7. The code ends with a closing curly brace for the "ReverseString" 

### C++

```cpp
// Copyrights to venkys.io
// For more information, visit venkys.io
// time Complexity :O(n/2),
// Space Complexity :O(1)

// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]

#include <iostream>
#include <string>

using namespace std;

// Function to reverse a string
void Reverse(const string& inputString) {
    // Loop through the characters in reverse order and print them
    for (int i = inputString.length() - 1; i >= 0; i--) {
        cout << inputString[i];
    }
    cout << endl;  // Print a newline after reversing the string
}

int main() {
    string userString;

    // Get input from the user
    cout << "Enter a string: ";
    getline(cin, userString);

    // Output the original string and its length
    cout << "Original String: " << userString << endl;
    

    // Reverse the string using the Reverse function
    cout << "Reversed String: ";
    Reverse(userString);

    return 0;
}
```

### **Step-by-Step Explanation**

1. The code starts with the necessary header files and includes the iostream and string libraries.
2. The Reverse function is defined, which takes a constant reference to a string as input.
3. Inside the Reverse function, a for loop is used to iterate through the characters of the input string in reverse order. The loop starts from the last character (inputString.length() - 1) and goes till the first character (0).
4. Within the loop, each character of the input string is printed.
5. After the loop, a newline is printed to separate the reversed string from the rest of the output.
6. In the main function, a string variable userString is declared to store user input.
7. The user is prompted to enter a string using the cout statement.
8. The getline function is used to read the input string from the user and store it in the userString variable.
9. The original string is printed using the cout statement.
10. The Reverse function is called with the userString as the argument to reverse the string.
11. Finally, the program returns 0 to indicate successful execution.

# Test Cases

### example 1 :

**Input :**

Enter a string:

**Output :**

    Reversed String:

### example 2 :

**Input :**

 Enter a string: hello

**Output :**

    Reversed String: olleh

### example 1 :

**Input :**

Enter a string: ikol

**Output :**

    Reversed String: loki
****

# **Time And Space Complexity Analysis**

The time complexity of the reverseString  function is O(n/2), where n is the length of the input array. This is because the function iterates through half of the array, swapping the characters at opposite ends. The constant factor of 1/2 is ignored in Big O notation.

## 

The space complexity of the reverseString function is O(1) because it uses only a constant amount of extra memory. The input array is modified in-place, without requiring any additional data structures.

Overall, the time complexity and space complexity of the code are both considered to be optimal.

# **Real-World Applications of Reverse String**

The ability to reverse a string has various real-world applications in programming. Here are some examples:

1. **Text Manipulation**: Reversing a string can be useful for tasks like text encryption, where reversing the characters can provide a form of obfuscation or scrambling.
2. **Palindrome Detection**: Palindromes are words, phrases, or numbers that read the same backward as forward. Reversing a string and comparing it to the original string can help identify palindromes.
3. **String Processing**: In certain scenarios, reversing a string can help in processing and analyzing textual data. For example, in natural language processing, reversing the order of words in a sentence can be used as a technique for data augmentation or language modeling.
4. **User Interface**: Reversing a string can also be utilized in user interface elements, such as displaying text in a mirror or flipped orientation.
5. **String Parsing**: In some cases, reversing a string can assist in parsing and extracting specific information. For instance, reversing a URL can help identify its top-level domain or extract meaningful components from a complex string.