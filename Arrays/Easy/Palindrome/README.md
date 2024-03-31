# Exploring Array Algorithms: Palindrome check

Certainly! Let's dive into the realm of array algorithms, with a particular focus on determining whether a given input string is a palindrome. Palindrome checking is a captivating problem that not only offers practical applications but also provides valuable insights into data structures and algorithmic thinking.

## Introduction

A palindrome is a sequence of characters that reads the same forward and backward, disregarding spaces, punctuation, and capitalization. The algorithmic challenge lies in efficiently determining if a given string exhibits this unique property. This problem not only touches upon fundamental string manipulation but also delves into algorithmic optimizations for effective palindrome detection.

## Problem Statement

Given a string, the objective is to ascertain whether it is a palindrome.

## Palindrome

A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward as backward. In the context of a string, a palindrome is symmetric concerning its center. Here are the conditions for a string to be a palindrome:

* Mirror Image
* Character Comparison
* Ignoring Spaces, Punctuation and other non-alphanumeric characters.

**Example:**
"RadaR!"

## overview

The approach followed is based on the fundamental concept of palindrome symmetry, comparing characters from the outer edges toward the center. It employs a two-pointer approach to compare characters from the beginning and end of the string towards the center.

The loop iterates over the first half of the string, comparing characters from the beginning and end, and if any pair of characters are not equal, the string is determined not to be a palindrome. If the loop completes without finding any unequal pairs, the string is considered a palindrome.

## Python Code

```python
# Copyrights to venkys.io
# For more programs visit venkys.io 
# Python program for Palindrome

# Time complexity:O(n)
# Space complexity:O(1)


# function return wether the input string is palindrome or not
# It takes a string as a parameter
def string_palindrome(string):
    cleared_string=''.join(char.lower() for char in string if char.isalnum())
    # length variable stores the length of string  
    length=len(cleared_string)
    # loop iterates half of the length of string 
    for i in range(len(cleared_string)//2):
        # Check if the character at index i is not equal to its corresponding character from the end
        if cleared_string[i]!=cleared_string[length-(i+1)]:
            print("False")
            break
    else:
        # If the loop completes without breaking, it's a palindrome
        print("True")

#test drive code:
string = input()
string_palindrome(string)
```

## Java Code

```java

// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for Palindrom

// time complexity:O(n)
// space complexity:O(1)

import java.util.Scanner;

public class Main {
    // Function to compute reverse of given string and return boolean value by matching it against the original string
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "");
        // Declare an empty string to store the reversed version
        String rev = "";
        // Loop to iterate through the characters of the string in reverse order
        for (int i = cleanedString.length() - 1; i >= 0; i--) {
            // Concatenate each character to the reversed string
            rev += cleanedString.charAt(i);
        }
        // Check if the reversed string is equal to the original string
        return rev.equals(cleanedString);
    }

    public static void main(String args[]) {
        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter a string: ");
        // Read user input
        String s = scanner.nextLine();

        // Calling the palindrome-checking method and storing the result in a boolean variable
        boolean isPal = isPalindrome(s);

        if (isPal) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Close the scanner
        scanner.close();
    }
}
```

let us see the step-by-step process of solving palindrome in **JAVA**.

**1. Define a main class and method to check palindrome:**
     Declare a main class with two methods one is for checking palindrome(VSDispalindrome) and the other is the main method

**2. Cleaning the String and Reversing the String:**
     Create a new string (cleanedString) by removing any characters from the original string (s) that are not alphanumeric (letters or numbers). This ensures that only alphanumeric characters are considered for palindrome checking. initialize an empty string (rev) to store the reversed version of a cleaned string(cleanedString). Then use a loop to iterate through the characters of cleanedString in reverse order and concatenate each character to the rev string. This results in the creation of the reversed string.

**3.  Palindrome Check:**
     This step checks whether the reversed string (rev) is equal to the cleaned string (cleanedString). If they are equal, the function returns true, indicating that the original string is a palindrome. Otherwise, it returns false.

**4. Main Method, and Output:**
In the main method, a test case is set up with a string (s) containing both alphanumeric and non-alphanumeric characters. The VSDispalindrome method is called with this test string, and the result is stored in a boolean variable (b). Finally, the program checks the result and prints whether the original string is a palindrome or not based on the value of b.

## C++ Code

```cpp
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Palindrome

// time complexity:O(n)
// space complexity:O(1)

#include <iostream>
#include <cctype>
using namespace std;

// Function to check if a string is a palindrome
bool checkPalindrome(string str) {
    int len = str.size();
    int i = 0, j = len - 1;

    while (i < j) {
        // Ignore non-alphanumeric characters
        // Ignore non-alphanumeric characters from the beginning of the string
        while (i < len && !isalnum(str[i])) {
            i++;
        }

        // Ignore non-alphanumeric characters from the end of the string
        while (j >= 0 && !isalnum(str[j])) {
            j--;
        }

        // If characters at positions i and j are not equal, the string is not a palindrome
        if (i < j) {
            // Compare characters case-insensitively
            if (tolower(str[i]) != tolower(str[j])) {
                return false;
            }
            // Move the pointers towards the center
            i++;
            j--;
        }
    }
    // If the loop completes without returning false, the string is a palindrome
    return true;
}

int main() {

    string str;

    // Get input from the user
    // cout << "Enter a string: ";
    getline(cin, str);

    // Check if the string is a palindrome using the checkPalindrome function
    if (checkPalindrome(str)) {
        cout << "True"<< endl;
    } else {
        cout << "False" << endl;
    }

    return 0;
}
```

let us see the step-by-step process of solving palindrome in **C++**.

**1. Function to Check Palindrome:**
     Define a function called checkPalindrome that takes a string as input and returns a boolean.
**2. eliminating:**
     Declare variables to store the length of the string (len) and two pointers (i and j) initialized to the beginning and end of the string. The loop continues as long as i is less than j. This loop compares characters from both ends towards the center. Two inner while loops skip non-alphanumeric characters from the beginning and end of the string.
**3. Checking**
     Check if characters at positions i and j are not equal. If they aren't, the function returns false, indicating that the string is not a palindrome. If the characters are equal, move the pointers towards the center of the string.
     If the outer loop completes without returning false, the function returns true, indicating that the string is a palindrome.
**4. Main Function**
     The main function, initializes a test string (str) with both alphanumeric and non-alphanumeric characters. It checks if the string is a palindrome using the checkPalindrome function. The result is printed to the console.

## Time and Space Complexity Analysis

* All three implementations have linear time complexity (O(n)) because they iterate through the input string once, where n is the length of the input string.

* The space complexity is constant (O(1)) for Java, C++, and Python.

These palindrome-checking algorithms are designed to be efficient, with both time and space complexities that do not significantly increase with the size of the input string. They are suitable for checking palindromes across various input lengths without a substantial impact on performance.

## Test Cases for Palindrome Checking Algorithm

### Test Case 1: Basic Palindrome String

**Input:** radar
**Expected Output:** "radar" is a palindrome string
**Explanation:** This is a basic test case with a simple palindrome string. It reads the same forward and backward, so the algorithm should correctly identify it as a palindrome.

### Test Case 2: Palindrome String with Punctuation and Spaces

**Input:** A man, a plan, a canal, Panama!
**Expected Output:** "A man, a plan, a canal, Panama!" is a palindrome string
**Explanation:** This test case contains punctuation, spaces, and mixed cases. The algorithm should ignore these and correctly identify it as a palindrome.

### Test Case 3: Non-Palindrome String

**Input:** Hello world
**Expected Output:** "Hello world" is not a palindrome string
**Explanation:** This test case is a regular string that is not a palindrome. The algorithm should correctly identify it as not being a palindrome.

### Test Case 4: Empty String

**Input:** 
**Expected Output:** "" is a palindrome string
**Explanation:** An empty string is considered a palindrome because there are no characters to violate the palindrome property.

### Test Case 5: Single Character String

**Input:** x
**Expected Output:** "x" is a palindrome string
**Explanation:** A single character string is considered a palindrome as it reads the same forward and backward.

### Test Case 6: String with Non-Alphanumeric Characters Only

**Input:** !@#$%^&*()_+
**Expected Output:** "!@#$%^&*()_+" is a palindrome string
**Explanation:** A string containing only non-alphanumeric characters is considered a palindrome as they are ignored by the algorithm.

### Te**st Case 7: Long Palindrome String

**Input:** Able was I, ere I saw Elba. A man, a plan, a canal, Panama! Was it a car or a cat I saw?
**Expected Output:** "Able was I, ere I saw Elba. A man, a plan, a canal, Panama! Was it a car or a cat I saw?" is a palindrome string
**Explanation:** This test case includes a longer string with various punctuation and spaces. It should correctly identify it as a palindrome.

**Additional Considerations:**

Edge cases: Test cases with very large strings, edge characters, or edge conditions to ensure the algorithm's efficiency and correctness.

Performance testing: Measure the algorithm's performance on large inputs to ensure it executes within acceptable time limits.

By running these test cases against the palindrome checking algorithm, you can validate its accuracy, handling of special characters, empty strings, and different lengths of input strings, ensuring its robustness across various scenarios.

## Real-world Applications

1. **Genomics and DNA Sequencing:**

   * Palindromic DNA sequences are crucial for recognizing cutting sites with restriction enzymes and facilitating genetic research and modification.

2. **Computer Science and Algorithms:**

   * Palindromes are applied in computer science algorithms, aiding tasks like text processing, where they enhance the efficiency of pattern matching and data analysis.
   * Efficient palindrome detection algorithms contribute to improved computational performance in various applications.

3. **Error Detection and Correction:**

    * Palindromic codes are used in error detection and correction, leveraging their symmetry to identify and rectify errors in transmitted data.

4. **Medical Imaging:**

   * Palindromic patterns in medical images contribute to image recognition, enabling the detection of specific structures or abnormalities.
   * Applying palindrome-based algorithms enhances the precision of medical imaging analysis for improved diagnostics.

5. **Speech and Audio Processing:**

   * Palindrome-based algorithms in speech and audio processing leverage palindromic patterns in sound waves, enhancing tasks like speech recognition.

6. **Control Systems and Robotics:**

   * Palindromic sequences aid signal processing and filtering in control systems, improving accuracy by identifying specific patterns in sensor data.

7. **Language and Linguistics:**

   * Palindromes are used in linguistic studies to analyze language patterns, providing insights into phonetics, morphology, and syntax.

8. Cryptographic Hash Functions:

   * Cryptographic hash functions use palindromic properties to create secure hashing algorithms, ensuring unique and random hash values.
   * Palindromic sequences contribute to the robustness of cryptographic techniques, enhancing data encryption and protection.
