# INTRODUCTION TO REGULAR EXPRESSION MATCHING

Regular expression matching (often referred to as regex or regexp matching) is a powerful and flexible way to search, match, and manipulate text based on patterns. A regular expression is a sequence of characters that defines a search pattern. These patterns can include a variety of elements, such as literals, metacharacters, and quantifiers, allowing for complex and flexible text matching..

# OVERVIEW OF REGULAR EXPRESSION MATCHING

The Regular Expression Matching problem involves determining if a given string matches a specified pattern defined by a regular expression. This problem is commonly encountered in string matching, text processing, and pattern recognition tasks. The regular expression specifies a set of rules that the input string must follow for a match to occur.

Given two strings **S** and **P** where **S** consists of only lowercase English alphabets while **P** consists of lowercase English alphabets as well as special characters ‘**.’** and ‘***’,** the task is to implement a function to test regular expression such that:

- `'.'` Matches any single character.
- `'*'` Matches zero or more of the preceding element.

### **Here's an example to illustrate the Regular Expression Matching problem:**

Let's consider the regular expression **`a*b`**:

- **`a*`**: Zero or more occurrences of the character 'a'.
- **`b`**: The character 'b'.

Now, suppose we have the following strings:

1. Input: **`"b"`**
    - Does **`"b"`** match the pattern **`a*b`**?
    - No, because there are no 'a' characters before 'b'.
2. Input: **`"aaab"`**
    - Does **`"aaab"`** match the pattern **`a*b`**?
    - Yes, because there are zero or more 'a' characters followed by 'b'.
    - 

This problem can be solved using dynamic programming or recursion with memoization. The idea is to build a table or use memoization to store the results of subproblems, avoiding redundant computations.

# CODE

### PYTHON

```python
# Copyrights to venkys.io
# For more information, visit venkys.io
# time Complexity :   O(m * n),
# Space Complexity :  O(m * n),

def is_match(user_s, user_p):
    # Initialize a 2D table to store results of subproblems
    dp = [[False] * (len(user_p) + 1) for _ in range(len(user_s) + 1)]

    # Empty pattern matches empty string
    dp[0][0] = True

    # Handle patterns with '*' at the beginning
    for j in range(1, len(user_p) + 1):
        if user_p[j - 1] == '*':
            dp[0][j] = dp[0][j - 2]

    # Build the table using dynamic programming
    for i in range(1, len(user_s) + 1):
        for j in range(1, len(user_p) + 1):
            if user_p[j - 1] == user_s[i - 1] or user_p[j - 1] == '.':
                dp[i][j] = dp[i - 1][j - 1]
            elif user_p[j - 1] == '*':
                dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] if user_s[i - 1] == user_p[j - 2] or user_p[j - 2] == '.' else False)

    return dp[len(user_s)][len(user_p)]

if __name__ == "__main__":
    # Get input from the user
    user_s = input()
    user_p = input()

    # Test the function with user input
    result = is_match(user_s, user_p)

    # Display the result
    print(result)
```

## Step-by-Step Explanation of the Code

1. The code defines a function is_match that takes two parameters: user_s (the user's input string) and user_p (the user's input pattern).
2. It initializes a 2D table, dp, with dimensions (len(user_s) + 1) x (len(user_p) + 1). This table will store the results of subproblems.
3. It sets dp[0][0] to True, indicating that an empty pattern matches an empty string.
4. It handles patterns with '*' at the beginning by setting dp[0][j] to dp[0][j - 2] if user_p[j - 1] == '*'.
5. It builds the table using dynamic programming. It iterates through user_s and user_p to fill in the table.
6. If user_p[j - 1] matches user_s[i - 1] or user_p[j - 1] is '.', it sets dp[i][j] to dp[i - 1][j - 1].
7. If user_p[j - 1] is '*', it sets dp[i][j] to dp[i][j - 2] or (dp[i - 1][j] if user_s[i - 1] == user_p[j - 2] or user_p[j - 2] == '.' else False).
8. Finally, it returns dp[len(user_s)][len(user_p)], which represents whether the entire string matches the pattern.
9. The code also includes a main block that prompts the user to enter a string and a pattern. It tests the is_match function with the user's input and prints the result.

### JAVA

```java
// Copyrights to venkys.io
// For more information, visit venkys.io
// time Complexity :   O(m * n),
// Space Complexity :  O(m * n),

import java.util.Scanner;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        // Initialize a 2D table to store results of subproblems
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // Empty pattern matches empty string
        dp[0][0] = true;

        // Handle patterns with '*' at the beginning
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Build the table using dynamic programming
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the string
        // System.out.print("Enter a string: ");
        String userString = scanner.nextLine();

        // Get user input for the pattern
        // System.out.print("Enter a pattern: ");
        String userPattern = scanner.nextLine();

        // Test the function with user input
        boolean result = isMatch(userString, userPattern);

        // Display the result
        System.out.println(result);
    }
}

```

## Step-by-Step Explanation of the Code

1. Import the required libraries and classes. In this case, we are importing the Scanner class from the java.util package.
2. Define a public class named RegularExpressionMatching.
3. Create a static method named isMatch that takes two parameters: s (representing the input string) and p (representing the pattern to match against).
4. Initialize a 2D table named dp (dynamic programming) with dimensions s.length() + 1 and p.length() + 1. This table will store the results of subproblems.
5. Set the value of dp[0][0] to true, as an empty pattern matches an empty string.
6. Handle patterns with '*' at the beginning. Iterate through the characters of the pattern. If the current character is '*', set dp[0][j] to dp[0][j - 2].
7. Build the table using dynamic programming. Iterate through the characters of the string and pattern. For each character, check the following conditions:
    - If the current pattern character is equal to the current string character or it is '.', set dp[i][j] to dp[i - 1][j - 1].
    - If the current pattern character is '*', set dp[i][j] to dp[i][j - 2] (considering the '*' as zero occurrence) or check if the previous character in the pattern matches the current character in the string (s.charAt(i - 1) == p.charAt(j - 2)) or the previous character in the pattern is '.' (p.charAt(j - 2) == '.'), and if so, set dp[i][j] to dp[i - 1][j].
8. Return the value of dp[s.length()][p.length()], which represents whether the entire string matches the pattern.
9. Define a main method. Create a Scanner object named scanner to read user input.
10. Prompt the user to enter a string and store the input in the userString variable.
11. Prompt the user to enter a pattern and store the input in the userPattern variable.
12. Call the isMatch method with userString and userPattern as arguments and store the result in the result variable.
13. Print the value of result, which represents whether the string matches the pattern.

## 

### c++

```cpp
// Copyrights to venkys.io
// For more information, visit venkys.io
// time Complexity :   O(m * n),
// Space Complexity :  O(m * n),

#include <iostream>
#include <vector>

using namespace std;

bool isMatch(const string& s, const string& p) {
    // Initialize a 2D table to store results of subproblems
    vector<vector<bool>> dp(s.length() + 1, vector<bool>(p.length() + 1, false));

    // Empty pattern matches empty string
    dp[0][0] = true;

    // Handle patterns with '*' at the beginning
    for (int j = 1; j <= p.length(); j++) {
        if (p[j - 1] == '*') {
            dp[0][j] = dp[0][j - 2];
        }
    }

    // Build the table using dynamic programming
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {
            if (p[j - 1] == s[i - 1] || p[j - 1] == '.') {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (p[j - 1] == '*') {
                dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'));
            }
        }
    }

    return dp[s.length()][p.length()];
}

int main() {
    // Get input from the user
    string userString, userPattern;
    // cout << "Enter a string: ";
    getline(cin, userString);
    // cout << "Enter a pattern: ";
    getline(cin, userPattern);

    // Test the function with user input
    bool result = isMatch(userString, userPattern);

    // Display the result
    cout << result << endl;

    return 0;
}
```

## Step-by-Step Explanation of the Code

1. Import necessary libraries: The code begins by importing the required libraries, including iostream and vector. These libraries will be used for input/output operations and for creating dynamic arrays.
2. Define the isMatch function: The isMatch function takes two input parameters, s and p, which represent the given string and pattern, respectively. It returns a boolean value indicating whether the string matches the pattern.
3. Initialize the dynamic programming table: A 2D vector, dp, is initialized to store the results of subproblems. The dimensions of the table are set to s.length() + 1 and p.length() + 1, and all values are initially set to false.
4. Handle empty pattern and empty string case: The table entry dp[0][0] is set to true since an empty pattern matches an empty string.
5. Handle patterns with '*' at the beginning: A loop iterates through each character of the pattern starting from the second character. If the current character is '*', the table entry dp[0][j] is set to the value of dp[0][j - 2]. This accounts for the case where '*' matches zero occurrences of the preceding character.
6. Build the table using dynamic programming: Nested loops iterate through each character of the string and pattern. If the current characters match or if the pattern character is '.', the table entry dp[i][j] is set to the value of dp[i - 1][j - 1]. If the pattern character is '*', the table entry dp[i][j] is set to the result of logical OR operations between dp[i][j - 2] and (dp[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.')). This accounts for the case where '*' matches zero or more occurrences of the preceding character.
7. Return the result: The function returns the final value of dp[s.length()][p.length()].
8. Main function: The main function prompts the user to enter a string and a pattern. It then calls the isMatch function with the user input as arguments. The resulting boolean value is stored in the result variable.
9. Display the result: Finally, the result is displayed by outputting the value of result.

# TEST CASES

### Example 1 :

**Input :**

Enter a string: "abb"

Enter a pattern: "a.*"

**Output :**

          True

**Explanation :**

replace **.** with b then p becomes ab* now replace * with one preceeding character hence p becomes abb.

### Example 2 :

**Input :**

Enter a string: aaaaaa

Enter a pattern: aaaa

**Output :** 

    False

**Explanation :**

 " aaaa" does not match the entire string "aaaaaa".

### 

### Example 3 :

**Input :**

Enter a string: apple123

Enter a pattern: "[^0-9]+

**Output :** 

           False

**Explanation :**

The regular expression "[^0-9]+" matches sequences without digits, but "apple123" contains numeric characters.

# TIME AND SPACE COMPLEXITY :

The time complexity is `O(m * n)`, where m is the length of the input string **s**, and n is the length of the pattern string **p**. This is because there is a nested loop iterating through the lengths of both strings.

1. The outer loop runs for **m + 1** iterations.
2. The inner loop runs for **n + 1** iterations.

Each iteration involves constant-time operations, so the overall time complexity is O(m * n).

The space complexity is also `O(m * n)` due to the space used by the 2D table .

1. The table has dimensions **(m + 1) x (n + 1)**, where **m** is the length of string **s**, and **n** is the length of pattern **p**.
2. Each entry in the table stores a boolean value.

Therefore, the space complexity is O(m * n).

## 

# REAL-WORLD APPLICATION FOR REGULAR EXPRESSION MATCHING

Regular expression matching has numerous real-world applications across various domains due to its ability to define and search for complex patterns in text data. Here are some common real-world applications :

1. **Text Search and Validation:**
    - **Search Engines:** Search engines use regular expressions to match user queries against a vast amount of text data efficiently.
    - **Text Editors and IDEs:** Text editors and integrated development environments (IDEs) often provide find-and-replace functionality using regular expressions.
2. **Data Validation and Extraction:**
    - **Form Validation:** Regular expressions are commonly used to validate user input in forms, such as email addresses, phone numbers, or ZIP codes.
    - **Log Analysis:** Regular expressions help extract specific information from log files, enabling analysis and troubleshooting.
3. **String Manipulation and Parsing:**
    - **Data Cleaning:** Regular expressions are employed to clean and preprocess textual data by removing or replacing specific patterns.
    - **URL Parsing:** Regular expressions can be used to parse and extract components from URLs, such as extracting the domain or parameters.
4. **Lexical Analysis and Compilers:**
    - **Programming Languages:** Regular expressions play a vital role in lexical analysis, where they are used to define tokens in the source code of programming languages.
    - **Compiler Construction:** Regular expressions are part of the toolkit used in the construction of compilers for parsing and tokenizing code.
5. **Natural Language Processing (NLP):**
    - **Named Entity Recognition:** Regular expressions can be used to define patterns for identifying named entities (e.g., names, locations) in text data.
    - **Text Pattern Matching:** In NLP tasks, regular expressions are applied to match specific linguistic patterns or structures.
6. **Network Security:**
    - **Intrusion Detection Systems (IDS):** Regular expressions are used to define patterns of known attack signatures or suspicious network activities in security systems.
    - **Log Analysis for Security:** Regular expressions aid in extracting relevant information from security logs for analysis and threat detection.
7. **Web Scraping and Data Extraction:**
    - **Web Scraping:** Regular expressions are utilized to extract specific data patterns from HTML or other markup languages.
    - **Data Extraction from Documents:** Regular expressions can be employed to extract structured information from documents in various formats.
8. **Configuration File Parsing:**
    - **Parsing Configuration Files:** Regular expressions are used to parse and extract information from configuration files in software applications.
