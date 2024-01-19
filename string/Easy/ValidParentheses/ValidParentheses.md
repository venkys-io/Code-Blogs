# ValidParentheses
The problem involves checking if a given string containing various types of parentheses (such as parentheses "()", square brackets "[]", and curly braces "{}") is valid, meaning that the parentheses are properly nested and closed.
## Introduction 

 #### Here are the basic rules for a string with valid parentheses:

Each opening parenthesis must have a corresponding closing parenthesis of the same type.
The parentheses must be properly nested; for example, "([])" is valid, but "([)]" is not.
This problem is often used to test a programmer's understanding of stack data structures and their ability to handle nested structures. The solution typically involves using a stack to keep track of the opening parentheses encountered, and then checking if the corresponding closing parentheses match when encountered.

 ## Overview 
ValidParentheses is a program that checks if a given string of parentheses is valid or not. It uses a stack data structure to keep track of the opening and closing parentheses. The program returns true if the parentheses are balanced and false otherwise. It is commonly used in programming interviews and coding challenges to test a candidate's understanding of stack operations and string manipulation.

## Code in python
```
 # Copyrights to venkys.io
# For more information, visit https://venkys.io
def isValidParanthesis(string: str) -> bool:
    stack = list()

    # Loop through each character in the input string
    for char in string:
        # If the character is an opening parenthesis, add it to the stack
        if char == "(" or char == "{" or char == "[":
            stack.append(char)
        else:
            # If the stack is empty and we encounter a closing parenthesis, return False
            if not stack:
                return False
            # Pop the top element from the stack
            top = stack.pop()
            # Check if the current closing parenthesis matches the corresponding opening parenthesis
            if char == ")" and top != "(":
                return False
            if char == "}" and top != "{":
                return False
            if char == "]" and top != "[":
                return False

    # If the stack is empty at the end, the parentheses are balanced
    return len(stack) == 0

# Get user input for the string
user_input = input("Enter a string with parentheses: ")
result = isValidParanthesis(user_input)

# Display the result
if result:
    print("The parentheses are valid.")
else:
    print("The parentheses are not valid.")

```
## Step by step explanation 
- Function Definition: The isValidParanthesis function is defined, which takes a string as input and returns a boolean indicating whether the parentheses in the string are valid or not.

- Stack Initialization: An empty list stack is initialized to serve as a stack. The stack will be used to keep track of opening parentheses.

- Loop Through Characters: The code uses a for loop to iterate through each character in the input string.

- Opening Parenthesis Handling: If the current character is an opening parenthesis ('(', '{', '['), it is appended to the stack.

- Closing Parenthesis Handling: If the current character is a closing parenthesis (')', '}', ']'), the code checks if the stack is empty. If the stack is empty, it means there is no corresponding opening parenthesis, and the function returns False.

- Matching Parentheses: If the stack is not empty, the code pops the top element from the stack and checks if it matches the corresponding opening parenthesis. If not, the function returns False.

- Balanced Parentheses Check: At the end of the loop, the function checks if the stack is empty. If it is, then all opening parentheses had matching closing parentheses, and the function returns True. Otherwise, it returns False.

- User Input: The code uses the input() function to get a string input from the user.

- Function Call: The isValidParanthesis function is called with the user input as an argument, and the result is stored in the result variable.

- Result Display: The code then displays whether the parentheses are valid or not based on the result of the function call.
## Test case 1
- Input: " " (an empty string)
- Expected Output: true 
## Test case 2
- Input: "(){}[]"
- Expected Output : true
## Test case 3
- Input: "{[()]}" 
- Expected Output: false

## Code in java
```
// Copyrights to venkys.io
// For more information, visit https://venkys.io
import java.util.Stack;
import java.util.Scanner;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the string
        System.out.print("Enter a string with parentheses: ");
        String userInput = scanner.nextLine();

        // Call the isValid method with the user input
        boolean result = isValid(userInput);

        // Display the result
        if (result) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }

        // Close the scanner
        scanner.close();
    }

    // Method to check if parentheses are valid
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is an opening parenthesis, push the corresponding closing parenthesis to the stack
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        // If the stack is empty at the end, the parentheses are balanced
        return stack.isEmpty();
    }
}

```
## Step by step code explanation
Import Statements: Import necessary classes from the java.util package, including Stack for stack implementation and Scanner for user input.

Class Declaration: Declare a class named ValidParentheses.

Main Method: The main method is the entry point of the program.

- Step 1: Create a Scanner object to read user input.
- Step 2: Prompt the user to enter a string with parentheses and store the input in the userInput variable.
- Step 3: Call the isValid method with the user input, and store the result in the result variable.
- Step 4: Display whether the parentheses are valid or not based on the result.
- Step 5: Close the Scanner to release system resources.
isValid Method: This method checks if the parentheses in a given string are valid.

- Step 1: Create a Stack to store opening parentheses.
- Step 2: Loop through each character in the input string.
- Step 3: If the character is an opening parenthesis, push the corresponding closing parenthesis to the stack.
- Step 4: If the character is a closing parenthesis:
If the stack is empty or the popped element from the stack does not match the current closing parenthesis, return false.
- Step 5: If the stack is empty at the end, return true; otherwise, return false.
## Test case 1
- Input: " " (an empty string)
- Expected Output: true 
## Test case 2
- Input: "(){}[]"
- Expected Output : true
## Test case 3
- Input: "{[()]}" 
- Expected Output: false

## Code in cpp
```
/* Copyrights to venkys.io*/
/* For more information, visit https://venkys.io */

#include <bits/stdc++.h>
using namespace std;

// Function to check if the parentheses are valid
bool VSD_Valid_Parentheses(string str) {
    // Check if the length of the string is odd
    if (str.size() % 2 != 0) {
        return false;
    } else {
        stack<char> stack_VSD; // Stack to store opening parentheses
        unordered_map<char, char> VSD = {{'(', ')'}, {'[', ']'}, {'{', '}'}}; // Mapping of opening to closing parentheses

        // Loop through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            // If the character is an opening parenthesis, push it onto the stack
            if (VSD.find(str[i]) != VSD.end()) {
                stack_VSD.push(str[i]);
            } else if (str[i] == ')' || str[i] == '}' || str[i] == ']') {
                // If the character is a closing parenthesis
                if (stack_VSD.empty()) {
                    // If the stack is empty, return false
                    return false;
                } else {
                    if (str[i] == VSD[stack_VSD.top()]) {
                        // If the closing parenthesis matches the corresponding opening parenthesis, pop from the stack
                        stack_VSD.pop();
                    } else {
                        // If the closing parenthesis does not match, return false
                        return false;
                    }
                }
            }
        }

        // If the stack is empty at the end, return true (valid parentheses)
        return stack_VSD.empty();
    }
}

int main() {
    // Get user input for the string
    cout << "Enter a string with parentheses: ";
    string user_input;
    getline(cin, user_input);

    // Call the VSD_Valid_Parentheses function with the user input
    if (VSD_Valid_Parentheses(user_input)) {
        cout << "It is valid Parantheses";
    } else {
        cout << "It is not valid Parantheses";
    }

    return 0;
}

```
## step by step explanation

 Include Statements: Include necessary headers for the C++ standard library.

-  Function Definition (VSD_Valid_Parentheses): This function checks if the parentheses in the input string are valid.

- Step 1: Check if the length of the string is odd. If it is, return false.
- Step 2: Create a stack to store opening parentheses.
- Step 3: Define a mapping of opening to closing parentheses.
- Step 4: Loop through each character in the input string.
Step 5: If the character is an opening parenthesis, push it - onto the stack.
- Step 6: If the character is a closing parenthesis:
If the stack is empty, return false.
If the closing parenthesis matches the corresponding opening parenthesis, pop from the stack.
If it doesn't match, return false.
- Step 7: If the stack is empty at the end, return true (valid parentheses).
- Main Method:

- Step 9: Get user input for the string.
- Step 10: Call the VSD_Valid_Parentheses function with the user input.
- Steps 11: Display whether the parentheses are valid or not based on the result of the function call.
## Test case 1
- Input: " " (an empty string)
- Expected Output: true 
## Test case 2
- Input: "(){}[]"
- Expected Output : true
## Test case 3
- Input: "{[()]}" 
- Expected Output: false
## Time , Space Complextity


- Time Complexity: O(n)
- Space Complexity: O(n)
## Real time application
- Compiler Parsing:

In compilers, parentheses are used to define the order of operations. Validating the correctness of parentheses in expressions is crucial during the parsing phase of the compilation process.
- Syntax Checking in Programming Languages:

When writing code, the IDE or text editor often checks for syntax errors, including mismatched parentheses. This ensures that the code is syntactically correct before compilation.
- HTML and XML Parsing:

In web development and XML processing, nested structures are common. Validating the correctness of tags and their nesting is crucial for ensuring well-formed documents.
- Mathematical Expressions Evaluation:

In applications involving mathematical expressions, parentheses are used to indicate the order of operations. Validating the correctness of parentheses ensures that the expression is evaluated correctly.