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
def isValidParanthesis(string:str)->bool:

    stack=list()

    for char in string:
        if char=="(" or char=="{" or char=="[":
            stack.append(char)
        else:
            if not stack:
                return False
            top=stack.pop()
            if char==")" and top!="(":
                return False
            if char=="}" and top!="{":
                return False
            if char=="]" and top!="[":
                return False
    return len(stack)==0
        
input= input()
print(isValidParanthesis(input))
```
## Code in java
```
// Copyrights to venkys.io
// For more information, visit https://venkys.io
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input from the user
        String inputString = scanner.nextLine();

        // Check if the input string is valid using the isValid function
        boolean isValid = isValid(inputString);

        // Display the result
        if (isValid)
            System.out.println("True");
        else
            System.out.println("False");

        scanner.close();
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

```
## Code in cpp
```
/* Copyrights to venkys.io*/
/* For more information, visit https://venkys.io */

#include <bits/stdc++.h>
using namespace std;


bool VSD_Valid_Parentheses(string str){
    int len=str.length();
	if(str.size()%2 !=0){
		return false;
	}
	else{
		stack<char>stack_VSD;
		unordered_map<char,char> VSD={{'(',')'},{'[',']'},{'{','}'}};
		for(int i=0;i<str.length();i++){
				if(VSD.find(str[i]) != VSD.end()){
					stack_VSD.push(str[i]);
				}
				else if(str[i]==')' || str[i]=='}' || str[i]==']'){
					if(stack_VSD.empty()){
						return false;
					}
					else{
						if(str[i] == VSD[stack_VSD.top()]){
							stack_VSD.pop();
						}
						else{
							return false;
						}
						
					}
					
				}
			
		}
		if(stack_VSD.empty()){
			return true;
		}
		else{
			return false;
		}
	}

}
int main() {
	
    // Read the string input from the user
    std::string str;
    std::getline(std::cin, str);
    if(VSD_Valid_Parentheses(str)) cout<<"True";
    else cout<<"False";
	return 0;
	
}
```
## step by step explanation


#### Function Definition:

isValidParanthesis is a function that takes a string (string) as input and returns a boolean value (True if the parentheses are valid, False otherwise).

#### Initialization:

stack = list(): Initializes an empty list to serve as a stack to keep track of opening parentheses.
#### Iterating Through Characters:

for char in string:: Iterates through each character in the input string.
#### Processing Opening Parentheses:

if char == "(" or char == "{" or char == "[":
If the character is an opening parenthesis ('(', '{', or '['), it is pushed onto the stack.
#### Processing Closing Parentheses:

else:
If the character is a closing parenthesis:
Checks if the stack is empty. If it is, then there is no matching opening parenthesis, so the string is not valid (return False).
Otherwise, pops the top element from the stack and checks if it matches the corresponding opening parenthesis.
#### Checking Validity:

return len(stack) == 0: After processing the entire string, if the stack is empty, the parentheses are valid. Otherwise, there are unmatched opening parentheses, and the string is not valid.
#### Example Usage:

input_str = "()[]{}"
print(isValidParanthesis(input_str)): Calls the function with the input string and prints the result.
#### Example Execution:

##### Input: "()[]{}"
##### Stack: [ (, [, { ]
Stack becomes empty after processing the entire string.
##### Output: 
True (indicating that the parentheses are valid).
This code efficiently uses a stack to track the opening parentheses and ensures that the closing parentheses match their corresponding opening ones. If at any point a mismatch is detected or if there are unmatched opening parentheses at the end, the function returns False.
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

## Test Cases

- Input: "()[]{}"
  Output: True

  Explanation:
  The input string contains valid pairs of parentheses, square brackets, and curly braces.
  Therefore, the output should be True.

- Input: "([)]"
  Output: False

  Explanation:
  The input string contains an invalid pair of parentheses and square brackets.
  Therefore, the output should be False.

- Input: "{[]}"
  Output: True

  Explanation:
  The input string contains valid pairs of parentheses, square brackets, and curly braces.
  Therefore, the output should be True.
