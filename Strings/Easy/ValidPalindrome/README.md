# ValidPalindrome

## Introduction
The Valid Palindrome problem is a common programming challenge that involves determining whether a given string is a valid palindrome. A palindrome is a sequence of characters that reads the same forward as backward, ignoring spaces, punctuation, and capitalization.

In the Valid Palindrome problem, the task is to create an algorithm or function that can assess whether a given string, when considered as a sequence of alphanumeric characters, is a valid palindrome. This problem often requires handling non-alphanumeric characters and disregarding case to accurately identify palindromic strings.
## Overview
The Valid Palindrome problem entails designing a solution to determine whether a given string is a valid palindrome, considering only alphanumeric characters and ignoring differences in case. The task involves evaluating whether the string reads the same forward and backward after removing non-alphanumeric characters. This problem is a classic exercise in string manipulation and often requires an efficient algorithm to address various edge cases. The solution involves traversing the string from both ends, comparing corresponding characters, and adjusting for case differences and non-alphanumeric characters. The Valid Palindrome problem is frequently encountered in algorithmic interviews and serves as an essential challenge for honing skills in string processing and logical reasoning.
## Code
```cpp
//Copyrights to venkys.io
//For more programs visit venkys.io 
//Java program for ValidPalindrome
import java.util.Scanner;
public class Main {

    // Function to check if a given string is a palindrome
    static boolean isPalindrome(String s) {
        String rev = "";

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // Check if the character is a lowercase letter (ASCII values 97 to 122)
            if (ch >= 97 && ch <= 122)
                rev += ch + "";
            // Check if the character is an uppercase letter (ASCII values 65 to 90)
            else if (ch >= 65 && ch <= 90)
                // Convert the uppercase letter to lowercase and add it to the 'rev' string
                rev += (char) (ch + 32) + "";
        }

        // Initialize two pointers for comparing characters from both ends of the 'rev' string
        int i = 0, j = rev.length() - 1;

        // Iterate until the pointers meet in the middle
        while (i < j)
            // Compare characters at the current positions, and move the pointers accordingly
            if (rev.charAt(i++) != rev.charAt(j--))
                return false;

        // If the loop completes without finding any mismatches, the string is a palindrome
        return true;
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input from the user
        String inputString = scanner.nextLine();

        // Close the scanner to prevent resource leaks
        scanner.close();


        // Check if the string is a palindrome using the isPalindrome function
        if (isPalindrome(s))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }
}
```

## Step-by-Step Explanation


This Java program, adorned with a copyright notice to "venkys.io," checks whether a given string is a palindrome. The `isPalindrome` function begins by initializing an empty string, `rev`, which will store the cleaned version of the input string. It then iterates through each character in the input string, filtering out non-alphabetic characters and converting uppercase letters to lowercase. The cleaned characters are appended to the `rev` string. Two pointers, `i` and `j`, are initialized at the start and end of the cleaned string, respectively.

The program enters a loop that continues until the pointers meet in the middle of the `rev` string. Within the loop, characters at the current positions pointed to by `i` and `j` are compared. If a mismatch is found, the function returns `false`, indicating that the string is not a palindrome. The pointers are incremented and decremented accordingly. If the loop completes without finding any mismatches, the function returns `true`, indicating that the string is a palindrome.

In the `main` function, an example string, "A man, a plan, a canal: Panama," is provided, and the program prints whether it is a palindrome or not based on the result of the `isPalindrome` function. This Java program effectively checks for palindromes by considering only alphanumeric characters and ignoring case differences.

In the example usage, a string `s` is provided: "A man, a plan, a canal: Panama." The `ispalindrome` function is called with this string, and the result is stored in the variable `a`. Finally, the script prints the result using `print(a)`.

## Code
```python
def ispalindrome(string):
    rev = ""
    for char in string:
        if char.isalpha():
            rev += char.lower()

    low, high = 0, len(rev) - 1
    while low < high:
        if rev[low] != rev[high]:
            return "Not A Palindrome"
        low += 1
        high -= 1
    return "Palindrome"

s = input()
a = ispalindrome(s)
print(a)
```

## Step-by-Step Explanation


The `ispalindrome` function begins by initializing an empty string `rev` to store the cleaned version of the input string. It then iterates through each character in the input string using a `for` loop. Within the loop, it checks if each character is alphabetic using the `isalpha()` method. If the character is alphabetic, it is appended to the `rev` string after converting it to lowercase using the `lower()` method. This process effectively filters out non-alphabetic characters and standardizes the case for comparison.

After cleaning the input string, the function sets up two pointers, `low` and `high`, initialized to the start and end of the cleaned string, respectively. It enters a `while` loop where it compares characters at the positions pointed to by `low` and `high`. If a mismatch is found, indicating that the string is not a palindrome, the function returns `False`. The pointers continue moving towards each other until they meet in the middle. If the loop completes without finding any mismatches, the function returns `True`, indicating that the string is a palindrome.

In the example usage, a string `s` is provided: "A man, a plan, a canal: Panama." The `ispalindrome` function is called with this string, and the result is stored in the variable `a`. Finally, the script prints the result using `print(a)`.

## Code
```cpp
//Copyrights to venkys.io
//For more programs visit venkys.io 
//CPP program for ValidPalindrome
#include<bits/stdc++.h>

using namespace std;

// Function to check if a given string is a palindrome
bool isPalindrome(string s){
    string rev = "";

    // Iterate through each character in the string
    for(char ch : s){
        // Check if the character is a lowercase letter (ASCII values 97 to 122)
        if(ch >= 97 && ch <= 122)
            rev += ch;
        // Check if the character is an uppercase letter (ASCII values 65 to 90)
        else if(ch >= 65 && ch <= 90)
            // Convert the uppercase letter to lowercase and add it to the 'rev' string
            rev += ch + 32;
    }

    // Initialize two pointers for comparing characters from both ends of the 'rev' string
    int i = 0, j = rev.length() - 1;

    // Iterate until the pointers meet in the middle
    while(i < j){
        // Compare characters at the current positions, and move the pointers accordingly
        if(rev[i++] != rev[j--]) return false;
    }

    // If the loop completes without finding any mismatches, the string is a palindrome
    return true;
}

// Main function
int main(){
    
    // Read the string input from the user
    std::string s;
    std::getline(std::cin, s);


    // Check if the string is a palindrome using the isPalindrome function
    if(isPalindrome(s))
        cout << "Palindrome";
    else
        cout << "Not a palindrome";

    return 0;
}

```

## Step-by-Step Explanation


The provided C++ code aims to determine whether a given string is a palindrome by ignoring non-alphanumeric characters and case differences. The `isPalindrome` function begins by iterating through each character in the input string, filtering out non-alphabetic characters, and converting uppercase letters to lowercase. The cleaned characters are stored in the `rev` string. Two pointers, `i` and `j`, are initialized at the start and end of the cleaned string, respectively. The code then enters a loop that compares characters at the current positions pointed to by `i` and `j`. If a mismatch is found, the function returns `false`. The loop continues until the pointers meet in the middle. If the loop completes without finding mismatches, the function returns `true`, indicating that the string is a palindrome. The main function demonstrates this by checking the example string "A man, a plan, a canal: Panama" and prints whether it is a palindrome or not.


In the example usage, a string `s` is provided: "A man, a plan, a canal: Panama." The `ispalindrome` function is called with this string, and the result is stored in the variable `a`. Finally, the script prints the result using `print(a)`.

## Time Complexity 
The time complexity of the code is O(n), where n is the length of the input string.

## Space Complexity
The space complexity of the code is O(1) since the additional space used is constant.

## Real-World Applications

- **Data Integrity Verification:**
  Palindrome checkers are utilized in systems where ensuring data integrity is paramount. They can be employed to verify the accuracy of transmitted or stored data, detecting potential corruption or errors.

- **Network Communication:**
  In network protocols and communication systems, palindromes can be used as a simple but effective method to validate data integrity during transmission, reducing the risk of data corruption.

- **Coding Interviews and Algorithms:**
  Palindrome-related problems are common in coding interviews. Understanding and implementing palindrome checkers are valuable skills for software developers, and the concepts can be applied to various algorithmic challenges.

- **Crossword Puzzle Validation:**
  Palindrome properties are utilized in crossword puzzles where words need to read the same across and down. Palindrome checkers can assist in validating and generating crossword puzzle solutions.

- **Cryptographic Hash Functions:**
  Some cryptographic hash functions leverage palindrome-like properties to enhance security. Palindromic patterns in hashed data contribute to the unpredictability and complexity of the hash.

## Test Cases

- Input: "A man, a plan, a canal, Panama!"
  Output: Palindrome
  
  Explanation:
  - The input string contains a palindrome sentence ("A man, a plan, a canal, Panama!").
  - After removing non-alphanumeric characters and converting all characters to lowercase, the string remains the same when read backward.
  Therefore, it's a palindrome.

- Input: "Racecar"
  Output: Palindrome
  
  Explanation:
  - The input string is a palindrome ("Racecar").
  - After removing non-alphanumeric characters and converting all characters to lowercase, the string remains the same when read backward.
  Therefore, it's a palindrome.
