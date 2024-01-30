                                                              # Wild Card Matching

# Introduction:

Wildcard matching is a pattern-matching technique commonly used in programming and computer science to compare strings with a specified pattern. The wildcard character, often denoted as "*", serves as a placeholder that can represent any sequence of characters (including none) within a string. This allows for more flexible and generalized string comparisons.

Here's a brief introduction to wildcard matching:

1. **Wildcard Characters:**
    - **'*' (asterisk):** Represents zero or more characters.
    - In some cases, other wildcard characters like '?' (question mark) might be used, where '?' represents a single arbitrary character.
2. **Use Cases:**
    - **File Matching:** Wildcards are frequently used in command-line interfaces to match files based on patterns.
    - **Text Search:** They can be used in text processing or search algorithms where a flexible pattern is needed.
    - **Pattern Matching:** In general, any situation where you want to compare strings with a more flexible pattern than exact equality.
3. **Algorithmic Approaches:**
    - **Recursive Approach:** Often, a recursive algorithm is used for wildcard matching, where the comparison is done character by character, and recursion handles wildcard expansions.
    - **Dynamic Programming:** Dynamic programming can be employed to optimize the recursive approach by memoizing intermediate results.
4. **Examples:**
    - `.txt` matches any string ending with ".txt".
    - `file_?.txt` matches "file_1.txt", "file_2.txt", etc., where '?' can be any single character.
    - `abc*def` matches any string that starts with "abc" and ends with "def".
5. **Library Functions:**
    - Many programming languages and libraries provide functions or methods for wildcard matching, making it easier for developers to implement and use this functionality. For example:
        - In Python, the `fnmatch` module provides `fnmatch.fnmatch()` for wildcard matching.
        - In Java, the `java.nio.file.PathMatcher` interface can be used for glob pattern matching.
6. **Performance Considerations:**
    - Depending on the implementation, wildcard matching can have varying time complexities. Efficient algorithms aim to strike a balance between flexibility and performance.

# Algorithm:

Here's a general step-by-step algorithm for wildcard matching:

1. **Initialization:**
    - Initialize two pointers, one for the input string and one for the pattern.
    - Start with the first character of both the input string and the pattern.
2. **Main Loop:**
    - Loop through each character in the input string and the pattern.
3. **Character Matching:**
    - If the current characters in the input string and the pattern match or the pattern character is '*', move to the next characters in both strings.
4. **Wildcard Handling:**
    - If the pattern character is '*', remember its position in the pattern and the current position in the input string.
5. **Mismatch Handling:**
    - If there is a mismatch and there is a wildcard '*', backtrack to the last remembered wildcard position and the corresponding position in the input string.
    - Move the input string pointer to the next position after the last mismatch.
6. **End of String Handling:**
    - If the input string is exhausted, check if there are only '*' characters remaining in the pattern. If yes, consider it a match; otherwise, it's not a match.
7. **End of Pattern Handling:**
    - If the pattern is exhausted, check if the input string is also exhausted. If yes, it's a match; otherwise, it's not a match.

8. **Example (Recursive Pseudocode):**
    
    ```
    function isMatch(input, pattern, i, j):
        if i == length(input) and j == length(pattern):
            return true
    
        if j < length(pattern) and pattern[j] == '*':
            rememberWildcardPosition = j
            rememberInputPosition = i
            while i < length(input):
                if isMatch(input, pattern, i, j + 1):
                    return true
                i++
            j = rememberWildcardPosition
            i = rememberInputPosition
    
        if i < length(input) and j < length(pattern) and (input[i] == pattern[j] or pattern[j] == '*'):
            return isMatch(input, pattern, i + 1, j + 1)
    
        return false
    
    ```
    

# Program in `c++`:

```cpp
#include <iostream>
#include <vector>

using namespace std;

bool isMatch(const string& input, const string& pattern, int i, int j, vector<vector<int>>& memo) {
    if (i == input.length() && j == pattern.length()) {
        return true;
    }

    if (memo[i][j] != -1) {
        return memo[i][j] == 1;
    }

    if (j < pattern.length() && pattern[j] == '*') {
        int rememberWildcardPosition = j;
        int rememberInputPosition = i;

        while (i < input.length()) {
            if (isMatch(input, pattern, i, j + 1, memo)) {
                memo[rememberInputPosition][rememberWildcardPosition] = 1;
                return true;
            }
            i++;
        }

        j = rememberWildcardPosition;
        i = rememberInputPosition;
    }

    if (i < input.length() && j < pattern.length() && (input[i] == pattern[j] || pattern[j] == '*')) {
        bool result = isMatch(input, pattern, i + 1, j + 1, memo);
        memo[i][j] = result ? 1 : 0;
        return result;
    }

    memo[i][j] = 0;
    return false;
}

bool wildcardMatch(const string& input, const string& pattern) {
    vector<vector<int>> memo(input.length() + 1, vector<int>(pattern.length() + 1, -1));
    return isMatch(input, pattern, 0, 0, memo);
}

int main() {
    string input, pattern;

    cout << "Enter the input string: ";
    cin >> input;

    cout << "Enter the pattern: ";
    cin >> pattern;

    if (wildcardMatch(input, pattern)) {
        cout << "The string \"" << input << "\" matches the pattern \"" << pattern << "\"." << endl;
    } else {
        cout << "No match found for the string \"" << input << "\" and pattern \"" << pattern << "\"." << endl;
    }

    return 0;
}
```

## Step By Step Explanation:

### Step 1: Include Headers and Define Namespace

```cpp
#include <iostream>
#include <vector>

using namespace std;

```

These lines include necessary headers for input/output and vector, and they define the usage of the `std` namespace.

### Step 2: Function Declaration for Wildcard Matching

```cpp
bool isMatch(const string& input, const string& pattern, int i, int j, vector<vector<int>>& memo);

```

This line declares the `isMatch` function, which will perform wildcard matching recursively.

### Step 3: Function Definition for Wildcard Matching

```cpp
bool isMatch(const string& input, const string& pattern, int i, int j, vector<vector<int>>& memo) {
    // Function body
}

```

The function `isMatch` is defined, and this is where the actual wildcard matching logic is implemented.

### Step 4: Memoization Initialization

```cpp
if (i == input.length() && j == pattern.length()) {
    return true;
}

if (memo[i][j] != -1) {
    return memo[i][j] == 1;
}

```

These lines handle the base case where both the input and pattern are exhausted. The function also checks if the result for the current state is already memoized and returns it if available.

### Step 5: Handling Wildcard '*' in the Pattern

```cpp
if (j < pattern.length() && pattern[j] == '*') {
    // Wildcard handling
}

```

If the current character in the pattern is '*', the function enters a loop to try different lengths of characters in the input for matching.

### Step 6: Wildcard Loop

```cpp
int rememberWildcardPosition = j;
int rememberInputPosition = i;

while (i < input.length()) {
    // Recursive call with different lengths of characters matched to '*'
    if (isMatch(input, pattern, i, j + 1, memo)) {
        memo[rememberInputPosition][rememberWildcardPosition] = 1;
        return true;
    }
    i++;
}

j = rememberWildcardPosition;
i = rememberInputPosition;

```

Within the loop, the function recursively calls itself with varying lengths of characters matched to '*'. If a match is found, it memoizes the result and returns true. If no match is found, it backtracks.

### Step 7: Matching Characters or Handling Wildcard '*' Recursively

```cpp
if (i < input.length() && j < pattern.length() && (input[i] == pattern[j] || pattern[j] == '*')) {
    // Recursive call for matching characters or handling wildcard '*'
}

```

If the current characters match or the pattern character is '*', the function makes a recursive call to the next positions in both the input and pattern.

### Step 8: Recursive Call

```cpp
bool result = isMatch(input, pattern, i + 1, j + 1, memo);
memo[i][j] = result ? 1 : 0;
return result;

```

The function makes a recursive call for the next positions and memoizes the result. It returns the result of the recursive call.

### Step 9: No Match Found

```cpp
memo[i][j] = 0;
return false;

```

If no match is found for the current state, the function memoizes the result as 0 and returns false.

### Step 10: Wrapper Function for Wildcard Matching

```cpp
bool wildcardMatch(const string& input, const string& pattern) {
    vector<vector<int>> memo(input.length() + 1, vector<int>(pattern.length() + 1, -1));
    return isMatch(input, pattern, 0, 0, memo);
}

```

This function initializes the memoization table and acts as a wrapper for the wildcard matching process.

### Step 11: Main Function

```cpp
int main() {
    string input, pattern;
    // User input and output handling
    return 0;
}

```

The `main` function handles user input and contains the program's entry point.

This step-by-step breakdown focuses on the internal structure and logic of the wildcard matching algorithm, excluding specific input and output interactions.

# Program in `python`:

```python
def is_match(input_str, pattern, i, j, memo):
    if i == len(input_str) and j == len(pattern):
        return True
    
    if memo[i][j] != -1:
        return memo[i][j] == 1
    
    if j < len(pattern) and pattern[j] == '*':
        remember_wildcard_position = j
        remember_input_position = i
        
        while i < len(input_str):
            if is_match(input_str, pattern, i, j + 1, memo):
                memo[remember_input_position][remember_wildcard_position] = 1
                return True
            i += 1
        
        j = remember_wildcard_position
        i = remember_input_position
    
    if i < len(input_str) and j < len(pattern) and (input_str[i] == pattern[j] or pattern[j] == '*'):
        result = is_match(input_str, pattern, i + 1, j + 1, memo)
        memo[i][j] = 1 if result else 0
        return result
    
    memo[i][j] = 0
    return False

def wildcard_match(input_str, pattern):
    memo = [[-1 for _ in range(len(pattern) + 1)] for _ in range(len(input_str) + 1)]
    return is_match(input_str, pattern, 0, 0, memo)

if __name__ == "__main__":
    # User input
    input_str = input("Enter the input string: ")
    pattern = input("Enter the pattern: ")

    # Perform wildcard matching
    if wildcard_match(input_str, pattern):
        print(f'The string "{input_str}" matches the pattern "{pattern}".')
    else:
        print(f'No match found for the string "{input_str}" and pattern "{pattern}".')
```

## Step By Step Explanation:

### Step 1: Define Function for Wildcard Matching

```python
def is_match(input_str, pattern, i, j, memo):
    # Function body

```

This function, `is_match`, will perform wildcard matching recursively. It takes the input string, the pattern, two pointers (`i` for the input string and `j` for the pattern), and a memoization table (`memo`).

### Step 2: Memoization Initialization

```python
    if i == len(input_str) and j == len(pattern):
        return True

    if memo[i][j] != -1:
        return memo[i][j] == 1

```

These lines handle the base case where both the input and pattern are exhausted. The function also checks if the result for the current state is already memoized and returns it if available.

### Step 3: Handling Wildcard '*' in the Pattern

```python
    if j < len(pattern) and pattern[j] == '*':
        # Wildcard handling

```

If the current character in the pattern is '*', the function enters a loop to try different lengths of characters in the input for matching.

### Step 4: Wildcard Loop

```python
        remember_wildcard_position = j
        remember_input_position = i

        while i < len(input_str):
            # Recursive call with different lengths of characters matched to '*'
            if is_match(input_str, pattern, i, j + 1, memo):
                memo[remember_input_position][remember_wildcard_position] = 1
                return True
            i += 1

        j = remember_wildcard_position
        i = remember_input_position

```

Within the loop, the function recursively calls itself with varying lengths of characters matched to '*'. If a match is found, it memoizes the result and returns true. If no match is found, it backtracks.

### Step 5: Matching Characters or Handling Wildcard '*' Recursively

```python
    if i < len(input_str) and j < len(pattern) and (input_str[i] == pattern[j] or pattern[j] == '*'):
        # Recursive call for matching characters or handling wildcard '*'

```

If the current characters match or the pattern character is '*', the function makes a recursive call to the next positions in both the input and pattern.

### Step 6: Recursive Call

```python
        result = is_match(input_str, pattern, i + 1, j + 1, memo)
        memo[i][j] = 1 if result else 0
        return result

```

The function makes a recursive call for the next positions and memoizes the result. It returns the result of the recursive call.

### Step 7: No Match Found

```python
    memo[i][j] = 0
    return False

```

If no match is found for the current state, the function memoizes the result as 0 and returns false.

### Step 8: Wrapper Function for Wildcard Matching

```python
def wildcard_match(input_str, pattern):
    memo = [[-1 for _ in range(len(pattern) + 1)] for _ in range(len(input_str) + 1)]
    return is_match(input_str, pattern, 0, 0, memo)

```

This function initializes the memoization table and acts as a wrapper for the wildcard matching process.

### Step 9: Main Block

```python
if __name__ == "__main__":
    # User input
    input_str = input("Enter the input string: ")
    pattern = input("Enter the pattern: ")

    # Perform wildcard matching
    if wildcard_match(input_str, pattern):
        print(f'The string "{input_str}" matches the pattern "{pattern}".')
    else:
        print(f'No match found for the string "{input_str}" and pattern "{pattern}".')

```

The main block handles user input and calls the `wildcard_match` function to perform the matching, printing the result accordingly.

# Program in `java`:

```java
import java.util.Scanner;

public class WildcardMatching {

    public static boolean isMatch(String input, String pattern, int i, int j, int[][] memo) {
        // Base case
        if (i == input.length() && j == pattern.length()) {
            return true;
        }

        // Check if the result for the current state is already memoized
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        // Handle wildcard '*' in the pattern
        if (j < pattern.length() && pattern.charAt(j) == '*') {
            int rememberWildcardPosition = j;
            int rememberInputPosition = i;

            // Try matching '*' with different lengths of characters in the input
            while (i < input.length()) {
                if (isMatch(input, pattern, i, j + 1, memo)) {
                    memo[rememberInputPosition][rememberWildcardPosition] = 1;
                    return true;
                }
                i++;
            }

            // Backtrack if no match is found
            j = rememberWildcardPosition;
            i = rememberInputPosition;
        }

        // Match characters or handle wildcard '*' recursively
        if (i < input.length() && j < pattern.length() && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '*')) {
            boolean result = isMatch(input, pattern, i + 1, j + 1, memo);
            memo[i][j] = result ? 1 : 0;
            return result;
        }

        // No match found for the current state
        memo[i][j] = 0;
        return false;
    }

    public static boolean wildcardMatch(String input, String pattern) {
        int[][] memo = new int[input.length() + 1][pattern.length() + 1];
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= pattern.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return isMatch(input, pattern, 0, 0, memo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        System.out.print("Enter the input string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the pattern: ");
        String pattern = scanner.nextLine();

        // Perform wildcard matching
        if (wildcardMatch(input, pattern)) {
            System.out.printf("The string \"%s\" matches the pattern \"%s\".%n", input, pattern);
        } else {
            System.out.printf("No match found for the string \"%s\" and pattern \"%s\".%n", input, pattern);
        }
    }
}
```

## Step By Step Explanation:

### Step 1: Import Necessary Packages

```java
import java.util.Scanner;

```

This line imports the `Scanner` class from the `java.util` package for user input.

### Step 2: Define `isMatch` Function

```java
public static boolean isMatch(String input, String pattern, int i, int j, int[][] memo) {
    // Function body
}

```

This function performs wildcard matching recursively. It takes the input string, the pattern, two pointers (`i` for the input string and `j` for the pattern), and a memoization table (`memo`).

### Step 3: Memoization Initialization

```java
    if (i == input.length() && j == pattern.length()) {
        return true;
    }

    if (memo[i][j] != -1) {
        return memo[i][j] == 1;
    }

```

These lines handle the base case where both the input and pattern are exhausted. The function also checks if the result for the current state is already memoized and returns it if available.

### Step 4: Handling Wildcard '*' in the Pattern

```java
    if (j < pattern.length() && pattern.charAt(j) == '*') {
        // Wildcard handling
    }

```

If the current character in the pattern is '*', the function enters a loop to try different lengths of characters in the input for matching.

### Step 5: Wildcard Loop

```java
        int rememberWildcardPosition = j;
        int rememberInputPosition = i;

        while (i < input.length()) {
            // Recursive call with different lengths of characters matched to '*'
            if (isMatch(input, pattern, i, j + 1, memo)) {
                memo[rememberInputPosition][rememberWildcardPosition] = 1;
                return true;
            }
            i++;
        }

        j = rememberWildcardPosition;
        i = rememberInputPosition;

```

Within the loop, the function recursively calls itself with varying lengths of characters matched to '*'. If a match is found, it memoizes the result and returns true. If no match is found, it backtracks.

### Step 6: Matching Characters or Handling Wildcard '*' Recursively

```java
    if (i < input.length() && j < pattern.length() && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '*')) {
        // Recursive call for matching characters or handling wildcard '*'
    }

```

If the current characters match or the pattern character is '*', the function makes a recursive call to the next positions in both the input and pattern.

### Step 7: Recursive Call

```java
        boolean result = isMatch(input, pattern, i + 1, j + 1, memo);
        memo[i][j] = result ? 1 : 0;
        return result;

```

The function makes a recursive call for the next positions and memoizes the result. It returns the result of the recursive call.

### Step 8: No Match Found

```java
    memo[i][j] = 0;
    return false;

```

If no match is found for the current state, the function memoizes the result as 0 and returns false.

### Step 9: Define `wildcardMatch` Function

```java
public static boolean wildcardMatch(String input, String pattern) {
    int[][] memo = new int[input.length() + 1][pattern.length() + 1];
    for (int i = 0; i <= input.length(); i++) {
        for (int j = 0; j <= pattern.length(); j++) {
            memo[i][j] = -1;
        }
    }
    return isMatch(input, pattern, 0, 0, memo);
}

```

This function initializes the memoization table and acts as a wrapper for the wildcard matching process.

### Step 10: Main Method

```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // User input
    System.out.print("Enter the input string: ");
    String input = scanner.nextLine();

    System.out.print("Enter the pattern: ");
    String pattern = scanner.nextLine();

    // Perform wildcard matching
    if (wildcardMatch(input, pattern)) {
        System.out.printf("The string \\"%s\\" matches the pattern \\"%s\\".%n", input, pattern);
    } else {
        System.out.printf("No match found for the string \\"%s\\" and pattern \\"%s\\".%n", input, pattern);
    }
}

```

The main block handles user input and calls the `wildcardMatch` function to perform the matching, printing the result accordingly.

# Space and Time Complexities:

The time and space complexities of the provided wildcard matching algorithm can be analyzed:

### Time Complexity:

The time complexity of the wildcard matching algorithm is mainly determined by the number of unique subproblems solved during the recursive calls and the memoization table's size. In the worst case, the algorithm may explore many possibilities before finding a match. The time complexity is affected by the length of the input string (`n`) and the length of the pattern (`m`).

- **C++ Code:**
    - The recursive nature and memoization aim to reduce redundant computations, but the worst-case time complexity can still be exponential, particularly if the pattern includes multiple wildcards.
    - Time Complexity: O(2^(min(n, m)))
- **Python Code:**
    - Similar to the C++ code, the recursive approach with memoization leads to exponential time complexity.
    - Time Complexity: O(2^(min(n, m)))
- **Java Code:**
    - The Java code has a similar recursive structure with memoization, resulting in exponential time complexity in the worst case.
    - Time Complexity: O(2^(min(n, m)))

### Space Complexity:

The space complexity is determined by the memoization table, which stores results for subproblems to avoid redundant computations. The space complexity is also affected by the depth of the recursion.

- **C++ Code:**
    - The memoization table's size is `O(n * m)`, where `n` is the length of the input string, and `m` is the length of the pattern.
    - Space Complexity: O(n * m)
- **Python Code:**
    - Similar to the C++ code, the space complexity is influenced by the memoization table's size.
    - Space Complexity: O(n * m)
- **Java Code:**
    - The Java code uses a memoization table of size `O(n * m)` as well.
    - Space Complexity: O(n * m)

# Real Time Applications:

1. **File System Searches:**
    - Wildcard matching is commonly used in file systems when searching for files with a specific pattern or extension. For example, searching for all files with the extension ".txt" in a directory.
2. **Command-Line Interfaces (CLI):**
    - CLI commands often support wildcard characters for flexible input. For instance, using '*' to represent multiple characters or '?' to represent a single character in file or command matching.
3. **Data Retrieval in Databases:**
    - In database queries, wildcard matching can be useful for retrieving data that follows a certain pattern. For instance, searching for customer names starting with "John" or ending with "son" in a customer database.
4. **Text Editors and IDEs:**
    - Many text editors and integrated development environments (IDEs) allow users to perform searches with wildcard patterns. This can be helpful for finding and replacing specific code patterns or text segments.
5. **Network Security and Firewall Rules:**
    - Wildcard matching is used in defining network security rules, allowing administrators to specify patterns for permitted or blocked IP addresses, domain names, or URLs.
6. **Search Engines and Web Crawlers:**
    - Search engines and web crawlers use wildcard-like functionality to match and index web pages based on URL patterns or content matching certain criteria.
7. **Log File Analysis:**
    - Wildcard matching is valuable in analyzing log files, helping to filter and extract relevant information. For example, searching for log entries related to a specific error pattern.
8. **Automation Scripts:**
    - Wildcard matching is often employed in automation scripts for tasks such as file manipulation, data processing, or system monitoring, where patterns need to be matched in an adaptive manner.
9. **Configuration Files:**
    - Configuration files for software applications may use wildcard matching to define rules or settings based on patterns, making it easier to configure complex systems.
10. **Regular Expressions and Pattern Matching Libraries:**
    - Wildcard matching principles are commonly used in regular expressions and pattern matching libraries, providing a powerful and flexible way to search, filter, or manipulate strings in programming.



TEST CASE--1 :

INPUT :

print(isMatch("abcd", "a*d")) 

OUTPUT :
 True

# Explanation: The pattern 'a*d' matches the string 'abcd' because '*' can represent any sequence of characters.

TEST CASE--2 :

INPUT :

print(isMatch("abcde", "a?c*e"))  

OUTPUT :

True

# Explanation: The pattern 'a?c*e' matches the string 'abcde' because '?' can represent any single character, and '*' can represent any sequence of characters.

TEST CASE-3 :

INPUT :

print(isMatch("xyz", "x*y*z"))

 OUTPUT :
 
 True

# Explanation: The pattern 'x*y*z' matches the string 'xyz' because '*' can represent any sequence of characters.

