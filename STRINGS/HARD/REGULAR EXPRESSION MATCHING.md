# INTRODUCTION TO REGULAR EXPRESSION MATCHING

Regular expression matching (often referred to as regex or regexp matching) is a powerful and flexible way to search, match, and manipulate text based on patterns. A regular expression is a sequence of characters that defines a search pattern. These patterns can include a variety of elements, such as literals, metacharacters, and quantifiers, allowing for complex and flexible text matching..

# OVERVIEW OF  REGULAR EXPRESSION MATCHING

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

  PYTHON

```python
#  Copyrights to venkys.io
#  For more information, visit https://venkys.io

def is_match(s, p):
    # Initialize a 2D table to store results of subproblems
    dp = [[False] * (len(p) + 1) for _ in range(len(s) + 1)]

    # Empty pattern matches empty string
    dp[0][0] = True

    # Handle patterns with '*' at the beginning
    for j in range(1, len(p) + 1):
        if p[j - 1] == '*':
            dp[0][j] = dp[0][j - 2]

    # Build the table using dynamic programming
    for i in range(1, len(s) + 1):
        for j in range(1, len(p) + 1):
            if p[j - 1] == s[i - 1] or p[j - 1] == '.':
                dp[i][j] = dp[i - 1][j - 1]
            elif p[j - 1] == '*':
                dp[i][j] = dp[i][j - 2] or (dp[i - 1][j] if s[i - 1] == p[j - 2] or p[j - 2] == '.' else False)

    return dp[len(s)][len(p)]

# Test cases
print(is_match("aa", "a"))      # Output: False
print(is_match("aa", "a*"))     # Output: True
print(is_match("ab", ".*"))     # Output: True
```

# STEP BY STEP EXPLAINTATION

The provided code is an implementation of regular expression matching using dynamic programming. Here's a step-by-step explanation of how the code works:

1. The code defines a function is_match that takes two strings s and p as input and returns a boolean indicating whether s matches the pattern p.
2. It initializes a 2D table dp with dimensions (len(s) + 1) x (len(p) + 1) to store the results of subproblems. Each cell dp[i][j] represents whether the substring s[:i] matches the pattern p[:j].
3. It sets dp[0][0] to True to handle the case of an empty pattern matching an empty string.
4. It handles patterns with '*' at the beginning. For each index j from 1 to the length of p, if p[j-1] is '*', it checks dp[0][j-2] to see if the pattern without the preceding character matches an empty string. This is because '*' matches zero or more occurrences of the preceding element.
5. It builds the table dp using dynamic programming. For each index i from 1 to the length of s and each index j from 1 to the length of p, it considers three cases:
    - If p[j-1] is equal to s[i-1] or p[j-1] is '.', it means the current characters match. In this case, dp[i][j] is set to dp[i-1][j-1], which indicates that the current substring matches if the previous substrings also match.
    - If p[j-1] is '*', it means the current pattern has a preceding element that can be repeated zero or more times. In this case, dp[i][j] is set to dp[i][j-2] if the preceding element is not used (matches zero occurrences). Otherwise, it checks if s[i-1] matches the preceding element p[j-2] or if p[j-2] is '.'. If either condition is true, it sets dp[i][j] to dp[i-1][j], indicating that the current pattern matches if the preceding element is used and the current substring matches the pattern without the '*' and the preceding element.
    - Otherwise, dp[i][j] is set to False, indicating that the current substring does not match the pattern.
6. Finally, it returns dp[len(s)][len(p)], which represents whether the entire string s matches the pattern p.

The provided code includes some test cases to demonstrate the usage of the is_match function. It tests for different scenarios such as matching a single character, matching zero or more occurrences, and using the '.' metacharacter to match any single character.

# CODE

### JAVA

```java
/*Copyrights to vsdevelopers.io*/
/*For more programs visit vsdevelopers.io */
/*Java program for regular expression matching*/

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
        // Test cases
        System.out.println(isMatch("aa", "a"));      // Output: false
        System.out.println(isMatch("aa", "a*"));     // Output: true
        System.out.println(isMatch("ab", ".*"));     // Output: true
    }
}
```

# STEP BY STEP EXPLAINTATION

The provided code is an implementation of regular expression matching using dynamic programming. Here's a step-by-step explanation of how the code works:

1. Initialize a 2D table, dp, to store the results of subproblems.
2. Set dp[0][0] to true to indicate that an empty pattern matches an empty string.
3. Handle patterns with '*' at the beginning by setting dp[0][j] to dp[0][j-2] for all indices j where p.charAt(j-1) is '*'.
4. Iterate through the strings s and p using nested loops.
5. If the current characters at indices i and j in s and p are the same, or the current character in p is '.', set dp[i][j] to dp[i-1][j-1].
6. If the current character in p is '*', set dp[i][j] to dp[i][j-2] (ignoring the '*' and the character before it) or (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')) (matching the current character in s with the character before the '*' in p).
7. Return dp[s.length()][p.length()] as the result of the matching.

The provided code includes test cases to demonstrate the functionality of the regular expression matching algorithm.

# CODE

### C++

```cpp

//Copyrights to vsdevelopers.io
//For more programs visit vsdevelopers.io


#include <iostream>
#include <vector>

using namespace std;

bool isMatch(string s, string p) {
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
    // Test cases
    cout << isMatch("aa", "a") << endl;      // Output: false
    cout << isMatch("aa", "a*") << endl;     // Output: true
    cout << isMatch("ab", ".*") << endl;     // Output: true

    return 0;
}

```

## 

# STEP BY STEP EXPLAINTATION

1. We start by including the necessary header files and declaring the isMatch function which takes two strings, s and p, as parameters and returns a boolean value.
2. Inside the isMatch function, we initialize a 2D table dp to store the results of subproblems. The size of the table is s.length() + 1 rows and p.length() + 1 columns. Each entry is initially set to false.
3. We set dp[0][0] to true since an empty pattern matches an empty string.
4. Next, we handle patterns with '*' at the beginning. For each j from 1 to the length of p, if p[j - 1] is '*', we set dp[0][j] to dp[0][j - 2]. This means that the '*' can match zero occurrences of the preceding character.
5. We build the table using dynamic programming. For each i from 1 to the length of s, and for each j from 1 to the length of p, we consider three cases:
    - If p[j - 1] is equal to s[i - 1] or p[j - 1] is '.', we set dp[i][j] to dp[i - 1][j - 1]. This means that the current characters match, and we can move to the next characters.
    - If p[j - 1] is '*', we have two subcases:
        - The '*' matches zero occurrences of the preceding character, so we set dp[i][j] to dp[i][j - 2].
        - The '*' matches one or more occurrences of the preceding character. In this case, we check if s[i - 1] is equal to p[j - 2] or p[j - 2] is '.' and dp[i - 1][j] is true. If either of these conditions is true, we set dp[i][j] to true.
6. Finally, we return dp[s.length()][p.length()], which represents whether the entire string s matches the pattern p.
7. In the main function, we test the isMatch function with three test cases and print the results.

The code uses dynamic programming to solve the regular expression matching problem. It considers all possible combinations of characters in s and p and stores the results in the dp table. By the end, it determines whether s matches p based on the values in the table.

# TIME AND SPACE COMPLEXITY :

The time complexity is `O(m * n)`, where m is the length of the input string **s**, and n is the length of the pattern string **p**. This is because there is a nested loop iterating through the lengths of both strings.

1. The outer loop runs for **m + 1** iterations.
2. The inner loop runs for **n + 1** iterations.

Each iteration involves constant-time operations, so the overall time complexity is O(m * n).

The space complexity is also `O(m * n)` due to the space used by the 2D table .

1. The table has dimensions **(m + 1) x (n + 1)**, where **m** is the length of string **s**, and **n** is the length of pattern **p**.
2. Each entry in the table stores a boolean value.

Therefore, the space complexity is O(m * n).

# REAL-WORLD APPLICATION FOR REGULAR EXPRESSION MATCHING

Regular expression matching has numerous real-world applications across various domains due to its ability to define and search for complex patterns in text data. Here are some common real-world applications:

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
