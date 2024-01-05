# Split a String In Balanced Strings


## Problem Statement

Given a balanced string, split it into some number of substrings such that each substring is balanced.Return the maximum number of balanced strings you can obtain.

## Introduction

The "Split a String in Balanced Strings" program is designed to address the task of dividing a given string into balanced substrings. A balanced string is one that contains an equal number of occurrences of two distinct characters. This algorithm aims to find the maximum number of balanced substrings within the input string. It typically employs a counting mechanism to keep track of the balance between the occurrence of each character. As the program iterates through the string, it identifies points where the balance is achieved, marking the end of a balanced substring. 

The solution to this problem holds relevance in scenarios where maintaining equilibrium between two types of elements in a sequence is crucial, such as in linguistic analysis or code parsing. This program showcases the significance of algorithmic techniques in efficiently solving problems related to string manipulation and pattern recognition.

## Overview 

The "Split a String In Balanced Strings" program is designed to count the maximum number of balanced string segments in a given input string. A balanced string segment is defined as a contiguous substring with an equal number of 'L' and 'R' characters. The program iterates through the input string, maintaining a count of 'L' and 'R' characters encountered. Whenever the counts become equal, a balanced segment is identified, and the count is reset. The objective is to find the maximum number of such balanced segments in the string.This program is particularly relevant in scenarios where the goal is to determine the optimal splitting of a string into segments with equal occurrences of certain characters, a common requirement in various algorithmic and string manipulation tasks.

## Code

### Python

```python
# Copyrights to venkys.io
# For more information, visit https://venkys.io

# Space complexity: O(N)
# Time complexity: O(1)
def balancedStringSplit(string: str) -> int:
    # Initialize counters
    check = answer = 0

    # Iterate through each character in the input string
    for char in string:
        # Update the counter based on the character
        if char == "R":
            check += 1
        else:
            check -= 1

        # Check if the counters are balanced (check equals zero)
        if check == 0:
            answer += 1

    # Return the total count of balanced string segments
    return answer


def main():
    # Take input from the user
    input_str = input("Enter the string: ")
    
    # Example usage
    result = balancedStringSplit(input_str)
    print(result)


if __name__ == "__main__":
    main()


```
### Java

```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */
// Space complexity: O(N)
// Time complexity: O(1)

import java.util.Scanner;
public class Main {

    // Function to count the maximum number of balanced string segments
    static int balanceStringSplit(String s) {
        int check = 0, answer = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            // Update the counter based on the character
            if (ch == 'R') {
                check++;
            } else {
                check--;
            }

            // Check if the counters are balanced (check equals zero)
            if (check == 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();

        // Example usage
        System.out.println(balanceStringSplit(s));
    }
}

```
### CPP
```cpp
/* Copyrights to venkys.io
For more information, visit https://venkys.io
# Space complexity: O(N)
# Time complexity: O(1)
*/

#include <iostream>
using namespace std;

// Function to count the maximum number of balanced string segments
int balancedStringSplit(string s) {
    int check = 0, answer = 0;

    // Iterate through each character in the input string
    for (char ch : s) {
        // Update the counter based on the character
        if (ch == 'R') {
            check++;
        } else {
            check--;
        }

        // Check if the counters are balanced (check equals zero)
        if (check == 0) {
            answer++;
        }
    }

    // Return the total count of balanced string segments
    return answer;
}

int main() {
    // Take input from the user
    cout << "Enter the string: ";
    string s;
    cin >> s;

    // Call the function and print the result
    cout << balancedStringSplit(s) << endl;

    return 0;
}

```
## Step-by-Step Explanation(Common for Python, Java and CPP)



1. **Initialize Counters:**
   - `check` and `answer` are initialized to 0. 
   - `check` keeps track of the balance between 'R' and 'L' characters in the current segment.
   - `answer` counts the total number of balanced string segments.

2. **Iterate Through Each Character:**
   - The code uses a loop to iterate through each character in the input string.

3. **Update Counters:**
   - Inside the loop, the code updates the `check` counter based on the current character.
   - If the character is 'R', increment `check`; otherwise, decrement it.

4. **Check for Balanced Segment:**
   - After updating the counters, the code checks if the counters are balanced (if `check` equals zero).
   - If balanced, it indicates the end of a balanced string segment, and `answer` is incremented.

5. **Return Result:**
   - The function returns the total count of balanced string segments (`answer`).


## Time and Space Complexity Analysis

#### Time Complexity:

  - The time complexity is O(N), where N is the length of the input string. The algorithm iterates through each character once.


#### Space Complexity:

  - The space complexity is O(1). The algorithms use a constant amount of space regardless of the input size, as there are no additional data structures that scale with the input.

This analysis holds for all three implementations (Python, Java, and CPP) of the balanced string splitting algorithm.

## Real-World Applications

1. **Language Parsing:**
   - In compilers and interpreters, this problem can be used to track balanced parentheses, braces, or brackets, ensuring the correctness of code syntax.

2. **HTML/XML Parsing:**
   - When parsing HTML or XML documents, it's crucial to count and validate the opening and closing tags. This problem can be applied to check tag balance.

3. **Mathematical Expression Evaluation:**
   - Evaluating mathematical expressions with balanced parentheses or operators can benefit from this problem. It helps ensure the expression is correctly structured.

4. **Database Query Processing:**
   - Database queries may involve nested conditions or subqueries. Balancing parentheses is vital for creating valid queries and parsing results.

5. **Data Validation:**
   - Input validation for forms and web applications may involve checking if opening and closing tags (e.g., HTML tags) match correctly, preventing potential security vulnerabilities like Cross-Site Scripting (XSS) attacks.

6. **Text Processing and Tokenization:**
   - Natural language processing tasks may require splitting text into sentences, paragraphs, or words while ensuring balanced punctuation, such as quotation marks or parentheses.

These real-world applications demonstrate the importance of balancing elements in sequences across various domains, ensuring the integrity, correctness, and security of processed data and code.
