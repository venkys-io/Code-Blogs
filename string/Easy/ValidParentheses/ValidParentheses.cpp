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