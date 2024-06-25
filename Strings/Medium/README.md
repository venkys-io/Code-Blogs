### Problem Statement - Longest Palindromic Substring
Given a string str, the task is to find the longest substring which is a palindrome.
### Introduction
The Longest Palindromic Substring problem is a classic challenge in computer science and algorithm design that focuses on finding the longest contiguous substring within a given string that reads the same backward as forward. This problem is of significant importance in various applications, including DNA sequence analysis, data compression, and text processing.

The task involves developing an efficient algorithm to determine the length and identify the actual substring that forms the longest palindromic sequence within the given input string. Solving this problem requires a careful exploration of all possible substrings, evaluating their palindromic nature, and optimizing the algorithm for time and space complexity. Researchers and software engineers frequently encounter this problem in interview settings and competitive programming due to its ability to assess a candidate's proficiency in dynamic programming, string manipulation, and algorithmic optimization. The exploration of solutions to the Longest Palindromic Substring problem provides valuable insights into algorithmic thinking and problem-solving skills.
### Overview
The Longest Palindromic Substring problem involves finding the longest contiguous palindrome within a given string. A palindrome is a sequence of characters that reads the same backward as forward. This problem is fundamental in algorithmic design and has applications in various domains, including genetics, data compression, and text analysis. The challenge is to develop an efficient algorithm that can identify and return the longest palindromic substring along with its length. Solutions often employ dynamic programming or expand-around-center techniques to optimize time and space complexity. The problem is frequently encountered in coding interviews and competitive programming, serving as a valuable test of a programmer's ability to navigate string manipulation and algorithmic optimization.
## Code
### Python
```python
#Copyrights to venkys.io
#For more programs visit venkys.io 
#Python program for LongestPalindromicSubstring
def expandFromCenter(string, left, right):
    global maxlength
    global start
    
    # Keep expanding while the characters at left and right indices are equal
    while left > -1 and right < len(string) and string[left] == string[right]:
        left -= 1
        right += 1
    
    # Update the maximum length and start index if a longer palindrome is found
    if maxlength < right - left - 1:
        maxlength = right - left - 1
        start = left + 1

# Initialize global variables maxlength and start
global maxlength 
maxlength = 0

global start
start = 0

def longestPalindrome(string):
    global maxlength
    global start
    
    # Iterate through each character in the string
    for i in range(len(string)):
        # Find the length of palindrome when the center is a single character
        expandFromCenter(string, i, i)
        
        # Find the length of palindrome when the center is between two characters
        expandFromCenter(string, i, i + 1)
    
    # Return the longest palindrome substring using start and maxlength
    return string[start:start + maxlength]

if __name__ == "__main__":
    # Example usage
    string = input()
    
    # Print the longest palindrome in the given string
    print(longestPalindrome(string))

```
### Step-by-Step Explanation
The provided Python code defines a function to find the longest palindrome substring within a given string. The main function, `longestPalindrome`, employs a helper function named `expandFromCenter` to iterate through the string, treating each character and the gap between two characters as potential centers of palindromes. 

The `expandFromCenter` function takes three parameters: the input string, and the left and right indices. It then expands outward from the center, checking if the characters at the left and right indices are equal. This process continues as long as the characters are equal and the indices are within the bounds of the string. The function updates global variables, `maxlength` and `start`, to keep track of the length and starting index of the longest palindrome found so far.

The `longestPalindrome` function iterates through each character in the input string and calls `expandFromCenter` twice for each character: once considering the character as a single-center and once as part of a double-center. The idea is to cover both odd and even-length palindromes. After the iteration, the function returns the longest palindrome substring using the stored `start` and `maxlength` values.

In the example usage section, the code demonstrates finding the longest palindrome in the string "badab" and prints the result. The provided implementation has a time complexity of O(n^2), where n is the length of the input string, as each expansion process takes linear time. This efficient algorithm allows for the identification of palindromic substrings within a given string.
### Java
```java
#Copyrights to venkys.io
#For more programs visit venkys.io 
#Java program for LongestPalindromicSubstring
import java.util.Scanner;

public class Main {

    // Function to find the longest palindrome in the given string
    static String longestPalindrome(String s) {
        // Initialize start and end indices for the longest palindrome found
        int start = 0, end = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            // Find the length of palindrome when the center is a single character
            int len1 = expandAroundCenter(s, i, i);
            
            // Find the length of palindrome when the center is between two characters
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Find the maximum length between len1 and len2
            int len = Math.max(len1, len2);

            // If the current palindrome is longer than the previous one, update start and end indices
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindrome substring
        return s.substring(start, end + 1);
    }

    // Function to expand around the center and find the length of the palindrome
    static int expandAroundCenter(String s, int left, int right) {
        // Initialize left and right pointers
        int L = left, R = right;

        // Keep expanding while the characters at left and right indices are equal
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        // Return the length of the palindrome found
        return R - L - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage
         Scanner scanner = new Scanner(System.in);
        
        // System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        
        // Print the longest palindrome in the given string
        System.out.println(longestPalindrome(s));
    }
}

```
### Step-by-Step Explanation
The provided Java code defines a program to find the longest palindrome substring within a given string. The main function, `longestPalindrome`, initializes indices `start` and `end` to keep track of the current longest palindrome found. It iterates through each character in the input string, treating the character as a potential center of a palindrome, and calls the `expandAroundCenter` function twice for each character. The `expandAroundCenter` function is responsible for expanding outward from the center indices, checking if the characters at the left and right indices are equal, and returning the length of the palindrome found.

Within the main loop of `longestPalindrome`, the lengths `len1` and `len2` are calculated for the palindromes with single and double centers, respectively. The maximum length between these two is determined using `Math.max(len1, len2)`. If the current palindrome is longer than the previously recorded one, the `start` and `end` indices are updated accordingly.

After the iteration, the function returns the substring of the input string that corresponds to the longest palindrome, using the updated `start` and `end` indices. In the example usage section, the code demonstrates finding the longest palindrome in the string "badab" and prints the result. The time complexity of the algorithm is O(n^2), where n is the length of the input string, as each expansion process takes linear time. The provided implementation efficiently identifies palindromic substrings within the given string.
### CPP
```cpp
#Copyrights to venkys.io
#For more programs visit venkys.io 
#cpp program for LongestPalindromicSubstring
#include<bits/stdc++.h>
using namespace std;

// Function to expand around the center and find the length of the palindrome
int expandFromCenter(std::string& string, int left, int right) {
    // Keep expanding while the characters at left and right indices are equal
    while (left > -1 && right < string.length() && string[left] == string[right]) {
        left--;
        right++;
    }
    // Return the length of the palindrome found
    return right - left - 1;
}

// Function to find the longest palindrome in a given string
string longestPalindrome(std::string& string) {
    // Initialize start and end indices for the longest palindrome found
    int start = 0, end = 0;

    // Iterate through each character in the string
    for (int i = 0; i < string.length(); i++) {
        // Find the length of palindrome when the center is a single character
        int len1 = expandFromCenter(string, i, i);
        // Find the length of palindrome when the center is between two characters
        int len2 = expandFromCenter(string, i, i + 1);

        // Find the maximum length between len1 and len2
        int len = std::max(len1, len2);

        // If the current palindrome is longer than the previous one, update start and end indices
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    
    // Return the longest palindrome substring
    return string.substr(start, end + 1);
}

int main() {
    // Example usage
    string str;
    
    // cout << "Enter a string: ";
    getline(cin, str);
    
    // Print the longest palindrome in the given string
    cout << longestPalindrome(str);
    
    return 0;
}

```
### Step-by-Step Explanation
The provided C++ program is designed to find the longest palindromic substring in a given string using an efficient algorithm. The `expandFromCenter` function is defined to handle the expansion around a center, taking a string and two indices as input. It iteratively expands outwards from the center indices while the characters at the left and right indices are equal, and it returns the length of the palindrome found.

The `longestPalindrome` function initializes `start` and `end` indices to keep track of the current longest palindrome found. It iterates through each character in the input string, calling `expandFromCenter` twice for each character: once considering the character as a single center and once as part of a double center. The lengths of the palindromes, `len1` and `len2`, are calculated, and the maximum length between them is determined using `std::max(len1, len2)`. If the current palindrome is longer than the previously recorded one, the `start` and `end` indices are updated accordingly.

In the `main` function, an example string "badab" is provided, and the `longestPalindrome` function is called to find and print the longest palindromic substring in the given string. The algorithm has a time complexity of O(n^2), where n is the length of the input string, as each expansion process takes linear time. The provided C++ implementation is a concise and effective way to identify and output the longest palindromic substring within a given string. The program includes copyright information and directs users to venkys.io for more programs.

## Time and Space Complexity Analysis
### Time complexity analysis:

The time complexity of the provided algorithm is O(n^2), where n is the length of the input string. This is because, for each character in the string, the algorithm expands from the center in two ways: once considering the center as a single character, and once considering the center between two characters. In the worst case, the expansion process may take O(n) time, and since we do this for each of the n characters in the string, the overall time complexity is O(n^2).

### Space complexity analysis:

The space complexity of the algorithm is O(1) because it uses a constant amount of extra space, regardless of the size of the input string. The only variables that are used and do not depend on the input size are `maxlength` and `start`, and they are used to keep track of the length and starting index of the longest palindrome found so far. The other variables like `left`, `right`, and the loop index `i` are temporary and do not contribute to the space complexity in a significant way.

## Real-World Applications
1. **Genomic Sequence Analysis:**
   - Identifying the longest palindromic substring is crucial in bioinformatics, especially in genomic sequence analysis. DNA sequences often exhibit palindromic structures, and finding the longest palindromic substring can provide insights into potential functional elements or repeated patterns within the genome.

2. **Data Compression:**
   - Palindromic substrings can be utilized in data compression algorithms. Detecting and encoding repeated palindromic patterns in a string can lead to more efficient compression, reducing the overall size of the data representation.

3. **Image Processing:**
   - In image processing, detecting palindromic structures can be useful for recognizing symmetrical patterns within images. This can be applied in computer vision for tasks such as object recognition, where identifying symmetric features can improve the accuracy of the recognition process.

4. **Speech Signal Processing:**
   - Palindromic patterns may be present in certain speech signals, especially in phonetic or tonal aspects. Analyzing the longest palindromic substrings in speech signals can contribute to speech processing tasks, such as detecting repeated phonemes or patterns in spoken language.

5. **String Matching and DNA Analysis:**
   - Longest palindromic substrings can be employed in string matching algorithms, helping to identify similarities or repetitions in text data. In DNA analysis, palindromic sequences are significant in restriction enzyme recognition sites, which are crucial in genetic engineering and molecular biology techniques like PCR (Polymerase Chain Reaction).


## Test Cases

Test Case 1:

Input:
babad

Output:
bab

Explanation:
The program prompts the user to input a string.
The longestPalindrome function is called with the input string.
Inside the longestPalindrome function, for each character in the string, the expandFromCenter function is called to find the longest palindrome centered at that character.
The expandFromCenter function expands outward from the center (either a single character or between two characters) to find the longest palindrome substring.
The longest palindrome substring "bab" is found and returned as output.

Test Case 2:

Input:
cbbd

Output:
bb

Explanation:
The program prompts the user to input a string "cbbd".
The longestPalindrome function is called with the input string.
Inside the longestPalindrome function, for each character in the string, the expandFromCenter function is called to find the longest palindrome centered at that character.
The expandFromCenter function expands outward from the center (either a single character or between two characters) to find the longest palindrome substring.
The longest palindrome substring "bb" is found and returned as output.
