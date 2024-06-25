# Exploring string searching algorithm : 

String searching algorithms are techniques used to find occurrences of a specific pattern within a larger text or string. These algorithms are crucial in various applications, including text processing, data mining, bioinformatics, and many others.

# Introduction to Strings:

A string is a sequence of characters enclosed in double or single quotes. It can contain letters, digits, special symbols, spaces, punctuation.
Strings, an indispensable data type in programming, serve as a versatile container for sequences of characters. One of the distinctive features of strings is their ability to store and process textual information. Whether it's a single word, a sentence, or even a larger body of text, strings provide a means to work with this data programmatically. In most programming languages, strings are typically enclosed within quotation marks, such as single (' ') or double (" ") quotes, allowing the interpreter or compiler to recognize them as string literals. 

# Introduction to the Knuth-Morris-Pratt (KMP) :

The Knuth-Morris-Pratt (KMP) algorithm is a powerful string searching algorithm that efficiently finds occurrences of a pattern within a text. Developed by Donald Knuth, Vaughan Pratt, and James H. Morris, the KMP algorithm was introduced in 1977 as a solution to the problem of searching for a pattern in linear time without unnecessary backtracking.

The primary innovation of the KMP algorithm lies in its ability to preprocess the pattern before searching, creating a "prefix function" that helps determine the optimal positions to resume the search when a mismatch occurs. This preprocessing allows the algorithm to avoid redundant character comparisons, making it more efficient than traditional brute-force methods.

The Knuth-Morris-Pratt algorithm stands out for its ability to achieve linear time complexity, making it a powerful tool for efficient string searching in various applications. 

# Overview of Knuth-Morris-Pratt (KMP) : 

 The KMP algorithm addresses the inefficiencies of brute-force methods by using a clever precomputation technique.

     Compute Prefix Function:
        The prefix function is computed by iterating through the pattern and updating values based on matching prefixes and suffixes.

    Search Using Prefix Function:
        The text is scanned with the pattern, and when a mismatch occurs, the prefix function guides the algorithm to determine the optimal position to resume the search.

    Efficient Backtracking:
        The KMP algorithm efficiently backtracks by using the information stored in the prefix function, eliminating redundant character comparisons.

# PYTHON
# code
```python
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

# python program for Knuth-Morris-Pratt algorithm
#  Stable: Yes
#  Inplace: Yes
#  Adaptive: No 

#  Space complexity:O(m)
#  Time complexity:O(n+m)

def compute_prefix_function(p):
    # Function to compute the prefix function (π) for the pattern 'p'
    m = len(p)
    π = [0] * m  # Initialize an array to store the prefix function values
    k = 0  # Initialize a variable for matching characters

    # Iterate through the pattern to compute the prefix function
    for q in range(1, m):
        # Update the matching character index while it's not zero and characters mismatch
        while k > 0 and p[k] != p[q]:
            k = π[k - 1]
        # If characters match, increment the matching character index
        if p[k] == p[q]:
            k += 1
        # Store the current matching character index in the prefix function array
        π[q] = k

    return π

def kmp_matcher(t, p):
    # Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
    n = len(t)  # Length of the text
    m = len(p)  # Length of the pattern
    π = compute_prefix_function(p)  # Compute the prefix function for the pattern
    q = 0  # Initialize a variable for matching characters

    # Iterate through the text to find occurrences of the pattern
    for i in range(n):
        # Update the matching character index while it's not zero and characters mismatch
        while q > 0 and p[q] != t[i]:
            q = π[q - 1]
        # If characters match, increment the matching character index
        if p[q] == t[i]:
            q += 1
        # If the entire pattern is matched, print the occurrence
        if q == m:
            print(f"Pattern occurs with shift {i - m + 1}")
            q = π[q - 1]  # Look for the next match

# Get user input with null safety
text = input("Enter the text: ")
pattern = input("Enter the pattern: ")

# Check if input is not empty and contains only alphabetical characters
if text and pattern and text.isalpha() and pattern.isalpha():
    kmp_matcher(text, pattern)
else:
    print("Please enter valid text and pattern.")

```
# Code Explanation

This Python code implements the Knuth-Morris-Pratt (KMP) algorithm, a string searching algorithm used to find occurrences of a pattern within a given text. Here's an explanation for each section of the code:

1. **`compute_prefix_function(p)` Function:**
   - This function computes the prefix function (π) for the given pattern `p`.
   - `m = len(p)`: Calculate the length of the pattern.
   - `π = [0] * m`: Initialize an array `π` to store the prefix function values, and set all values to 0.
   - `k = 0`: Initialize a variable for tracking matching characters.
   - The function iterates through the pattern and updates the prefix function values based on matching prefixes and suffixes.

2. **`kmp_matcher(t, p)` Function:**
   - This function performs pattern matching using the Knuth-Morris-Pratt (KMP) algorithm.
   - `n = len(t)`: Calculate the length of the text.
   - `m = len(p)`: Calculate the length of the pattern.
   - `π = compute_prefix_function(p)`: Compute the prefix function for the pattern.
   - `q = 0`: Initialize a variable for tracking matching characters.

3. **Pattern Matching Loop:**
   - The function iterates through each character in the text.
   - A nested while loop updates the matching character index `q` based on the prefix function values and mismatches between characters in the pattern and text.
   - If characters match, `q` is incremented.
   - If the entire pattern is matched (`q == m`), it prints the occurrence with the shift index and updates `q` to continue looking for the next match.

4. **User Input and Validation:**
   - The code prompts the user to input the text and pattern.
   - It checks if the input is not empty and contains only alphabetical characters using `text.isalpha()` and `pattern.isalpha()`.
   - If the input is valid, it calls the `kmp_matcher` function; otherwise, it prints an error message.

5. **Output:**
   - If the user input is valid and there are pattern occurrences in the text, it prints the positions (shifts) where the pattern is found.

Overall, this code provides a simple and functional implementation of the KMP algorithm, allowing users to find occurrences of a pattern within a given text. The use of functions enhances modularity and readability. 

# C++ 

code
```c++
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// C++ program for Knuth-Morris-Pratt algorithm
// Stable: Yes
// In-Place: Yes
// Adaptive: No
// Space Complexity: O(m)
// Time Complexity: O(n + m)

#include <iostream>
#include <vector>
#include <string>

// Function to compute the prefix function (π) for the pattern 'p'
std::vector<int> compute_prefix_function(const std::string& p) {
    int m = p.length();                    // Length of the pattern
    std::vector<int> π(m, 0);              // Initialize an array to store the prefix function values
    int k = 0;                             // Initialize a variable for matching characters

    // Iterate through the pattern to compute the prefix function
    for (int q = 1; q < m; ++q) {
        // Update the matching character index while it's not zero and characters mismatch
        while (k > 0 && p[k] != p[q]) {
            k = π[k - 1];
        }
        // If characters match, increment the matching character index
        if (p[k] == p[q]) {
            k += 1;
        }
        // Store the current matching character index in the prefix function array
        π[q] = k;
    }

    return π;
}

// Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
void kmp_matcher(const std::string& t, const std::string& p) {
    int n = t.length();                    // Length of the text
    int m = p.length();                    // Length of the pattern
    std::vector<int> π = compute_prefix_function(p);  // Compute the prefix function for the pattern
    int q = 0;                             // Initialize a variable for matching characters

    // Iterate through the text to find occurrences of the pattern
    for (int i = 0; i < n; ++i) {
        // Update the matching character index while it's not zero and characters mismatch
        while (q > 0 && p[q] != t[i]) {
            q = π[q - 1];
        }
        // If characters match, increment the matching character index
        if (p[q] == t[i]) {
            q += 1;
        }
        // If the entire pattern is matched, print the occurrence
        if (q == m) {
            std::cout << "Pattern occurs with shift " << i - m + 1 << std::endl;
            q = π[q - 1];  // Look for the next match
        }
    }
}

int main() {
    // Get user input with null safety
    std::string text, pattern;
    std::cout << "Enter the text: ";
    std::cin >> text;
    std::cout << "Enter the pattern: ";
    std::cin >> pattern;

    // Check if input is not empty and contains only alphabetical characters
    if (!text.empty() && !pattern.empty() && std::isalpha(text[0]) && std::isalpha(pattern[0])) {
        kmp_matcher(text, pattern);
    }
    else {
        std::cout << "Please enter valid alphabetic text and pattern." << std::endl;
    }

    return 0;
}

```
# Code Explanation
Here's an explanation for the provided C++ code that implements the Knuth-Morris-Pratt (KMP) algorithm for string searching:

1. **`compute_prefix_function` Function:**
   - This function computes the prefix function (π) for the given pattern `p`.
   - `int m = p.length();`: Calculate the length of the pattern.
   - `std::vector<int> π(m, 0);`: Initialize a vector to store the prefix function values, and set all values to 0.
   - `int k = 0;`: Initialize a variable for tracking matching characters.
   - The function iterates through the pattern and updates the prefix function values based on matching prefixes and suffixes.

2. **`kmp_matcher` Function:**
   - This function performs pattern matching using the KMP algorithm.
   - `int n = t.length();`: Calculate the length of the text.
   - `int m = p.length();`: Calculate the length of the pattern.
   - `std::vector<int> π = compute_prefix_function(p);`: Compute the prefix function for the pattern.
   - `int q = 0;`: Initialize a variable for tracking matching characters.

3. **Pattern Matching Loop:**
   - The function iterates through each character in the text.
   - A nested while loop updates the matching character index `q` based on the prefix function values and mismatches between characters in the pattern and text.
   - If characters match, `q` is incremented.
   - If the entire pattern is matched (`q == m`), it prints the occurrence with the shift index and updates `q` to continue looking for the next match.

4. **User Input and Validation:**
   - The code prompts the user to input the text and pattern.
   - It checks if the input is not empty and contains only alphabetical characters using `std::isalpha()` similar to the Python code.
   - If the input is valid, it calls the `kmp_matcher` function; otherwise, it prints an error message.

The code is designed to efficiently find occurrences of a pattern within a given text, providing a powerful and widely used string searching algorithm.

# java
# code
```java 
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// C++ program for Knuth-Morris-Pratt algorithm
// Stable: Yes
// In-Place: Yes
// Adaptive: No
// Space Complexity: O(m)
// Time Complexity: O(n + m)

import java.util.Scanner;

public class KMPAlgorithm {

    // Function to compute the prefix function (π) for the pattern 'p'
    public static int[] computePrefixFunction(String p) {
        int m = p.length();
        int[] π = new int[m];   // Initialize an array to store the prefix function values
        int k = 0;              // Initialize a variable for matching characters

        // Iterate through the pattern to compute the prefix function
        for (int q = 1; q < m; ++q) {
            // Update the matching character index while it's not zero and characters mismatch
            while (k > 0 && p.charAt(k) != p.charAt(q)) {
                k = π[k - 1];
            }
            // If characters match, increment the matching character index
            if (p.charAt(k) == p.charAt(q)) {
                k += 1;
            }
            // Store the current matching character index in the prefix function array
            π[q] = k;
        }

        return π;
    }

    // Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
    public static void kmpMatcher(String t, String p) {
        int n = t.length();      // Length of the text
        int m = p.length();      // Length of the pattern
        int[] π = computePrefixFunction(p);  // Compute the prefix function for the pattern
        int q = 0;               // Initialize a variable for matching characters

        // Iterate through the text to find occurrences of the pattern
        for (int i = 0; i < n; ++i) {
            // Update the matching character index while it's not zero and characters mismatch
            while (q > 0 && p.charAt(q) != t.charAt(i)) {
                q = π[q - 1];
            }
            // If characters match, increment the matching character index
            if (p.charAt(q) == t.charAt(i)) {
                q += 1;
            }
            // If the entire pattern is matched, print the occurrence
            if (q == m) {
                System.out.println("Pattern occurs with shift " + (i - m + 1));
                q = π[q - 1];  // Look for the next match
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input with null safety
            System.out.print("Enter the text: ");
            String text = scanner.nextLine();
            System.out.print("Enter the pattern: ");
            String pattern = scanner.nextLine();

            // Check if input is not empty and contains only alphabetical characters
            if (!text.isEmpty() && !pattern.isEmpty() && Character.isLetter(text.charAt(0))
                    && Character.isLetter(pattern.charAt(0))) {
                kmpMatcher(text, pattern);
            } else {
                System.out.println("Please enter valid alphabetic text and pattern.");
            }
        }
    }
}

```
# Code Explanation

KMP Algorithm Explanation:

1. **computePrefixFunction Method:** 
    - This method computes the prefix function (π) for the given pattern p.
    - int m = p.length();: Calculate the length of the pattern.
    - int[] π = new int[m];: Initialize an array to store the prefix function values.
    - int k = 0;: Initialize a variable for tracking matching characters.
    - The method iterates through the pattern and updates the prefix function values based on matching prefixes and suffixes.

2. **kmpMatcher Method:**
    - This method performs pattern matching using the KMP algorithm.
    - int n = t.length();: Calculate the length of the text.
    - int m = p.length();: Calculate the length of the pattern.
    - int[] π = computePrefixFunction(p);: Compute the prefix function for the pattern
    - int q = 0;: Initialize a variable for tracking matching characters.

3. **Pattern Matching Loop:**
    - The method iterates through each character in the text.
    - A nested while loop updates the matching character index q based on the prefix function values and mismatches between characters in the pattern and text.
    If characters match, q is incremented.
    - If the entire pattern is matched (q == m), it prints the occurrence with the shift index and updates q to continue looking for the next match.

4. **User Input and Validation:**
    - The main method uses a Scanner to get user input for the text and pattern.
    - It checks if the input is not empty and contains only alphabetical characters using Character.isLetter() similar to the C++ code.
    - If the input is valid, it calls the kmpMatcher method; otherwise, it prints an error message.

Overall, this Java implementation of the KMP algorithm achieves the same goal as the C++ code, providing an efficient way to find occurrences of a pattern within a given text. The core algorithm remains consistent across different programming languages.

**Difference**

Here are some key differences between the provided KMP algorithm implementations in Python, C++, and Java:

### 1. **Syntax and Language Features:**
   - **Python:**
     - Dynamically typed language.
     - Uses indentation for code blocks.
   - **C++:**
     - Statically typed language.
     - Requires explicit type declarations.
     - Uses curly braces for code blocks.
   - **Java:**
     - Statically typed language.
     - Requires explicit type declarations.
     - Uses curly braces for code blocks.

### 2. **Data Structures:**
   - **Python:**
     - Uses lists for arrays.
   - **C++:**
     - Uses `std::vector` for dynamic arrays.
   - **Java:**
     - Uses arrays (`int[]`, `char[]`) for dynamic arrays.

### 3. **Input/Output Handling:**
   - **Python:**
     - Uses `input()` and `print()` for user input/output.
   - **C++:**
     - Uses `std::cin` and `std::cout` for user input/output.
   - **Java:**
     - Uses `Scanner` and `System.out.println` for user input/output.

### 4. **String Handling:**
   - **Python:**
     - Strings are immutable.
     - Indexing starts from 0.
   - **C++:**
     - Uses `std::string` for string handling.
   - **Java:**
     - Uses `String` class for string handling.
     - Strings are immutable.

### 5. **Array Initialization:**
   - **Python:**
     - Uses list comprehension for array initialization.
   - **C++:**
     - Uses `std::vector` and array initialization.
   - **Java:**
     - Uses array initialization (`new int[m]`).

### 6. **Exception Handling:**
   - **Python:**
     - Exception handling is more implicit.
   - **C++:**
     - Uses `try`, `catch` for exception handling.
   - **Java:**
     - Uses `try`, `catch` for exception handling.

### 7. **Type Checking:**
   - **Python:**
     - Dynamically typed; type checking is done at runtime.
   - **C++:**
     - Statically typed; type checking is done at compile time.
   - **Java:**
     - Statically typed; type checking is done at compile time.

### 8. **Memory Management:**
   - **Python:**
     - Automatic memory management (garbage collection).
   - **C++:**
     - Manual memory management using `new` and `delete`.
   - **Java:**
     - Automatic memory management (garbage collection).

### 9. **Exception Handling for User Input:**
   - **Python:**
     - Uses `try`, `except` blocks for error handling.
   - **C++ and Java:**
     - Use `try`, `catch` blocks for error handling.

### 10. **Array Indexing:**
   - **Python and Java:**
     - Indexing starts from 0.
   - **C++:**
     - Indexing starts from 0.

These differences highlight the specific syntax and language features of each programming language. While the core logic of the KMP algorithm remains consistent, the implementation details vary to accommodate the unique aspects of each language.

# Time and Space Complexity:

The time and space complexity of the Knuth-Morris-Pratt (KMP) algorithm are crucial factors that determine its efficiency in solving the string matching problem.

### Time Complexity:

The time complexity of the KMP algorithm is O(n + m), where:
- n is the length of the text,
- m is the length of the pattern.

This linear time complexity is achieved because, in the worst case, the algorithm only needs to iterate through each character in the text and the pattern once. The preprocessing step, which involves computing the prefix function, takes O(m) time. The actual pattern matching then takes O(n) time in the worst case.

### Space Complexity:

The space complexity of the KMP algorithm is O(m), where m is the length of the pattern. This space complexity is due to the storage requirements of the prefix function array (π) used during the pattern matching process. The array is of size m and is used to store information about the longest proper prefix that is also a suffix at each position in the pattern.

In summary:
- Time Complexity: O(n + m)
- Space Complexity: O(m)

These complexities make the KMP algorithm an efficient choice for string matching, particularly when the length of the pattern is significantly smaller than the length of the text. The linear time complexity ensures that the algorithm remains practical for large datasets.

# Real-World Applications of KMP algorithm

The Knuth-Morris-Pratt (KMP) algorithm, known for its efficient string matching capabilities, finds applications in various real-world scenarios. Some notable applications include:

1. **Text Search Engines:**
   - KMP is used in text search engines to quickly locate patterns within large documents or text corpora. Search engines often need to efficiently find occurrences of keywords or phrases in documents, and KMP aids in speeding up this process.

2. **Code Editors and IDEs:**
   - Integrated Development Environments (IDEs) and code editors use string matching algorithms like KMP to implement features such as code highlighting, code completion, and refactoring tools. These features often involve identifying patterns within source code efficiently.

3. **Data Compression:**
   - KMP can be applied in certain data compression algorithms, particularly those that involve searching for repeated patterns within the data. By efficiently identifying and compressing repeated patterns, data compression algorithms can achieve higher compression ratios.

4. **Bioinformatics:**
   - In bioinformatics, DNA and protein sequence analysis may involve searching for specific patterns or motifs. KMP can be utilized to efficiently find occurrences of these patterns within biological sequences, aiding researchers in genetic analysis.

5. **Network Security:**
   - KMP is used in network security applications for pattern matching in intrusion detection systems. It helps in quickly identifying specific patterns associated with malicious activities or known attack signatures in network traffic.

6. **Spell Checking:**
   - Spell-checking algorithms use string matching techniques to identify and suggest corrections for misspelled words. KMP can be employed to efficiently search for similar patterns within a dictionary of correctly spelled words.

7. **Data Mining and Pattern Recognition:**
   - KMP can be employed in data mining applications for identifying recurring patterns or trends within large datasets. It aids in efficiently searching for specific patterns of interest in data streams.

8. **Genome Sequencing:**
   - In genomics, the KMP algorithm can be used to search for specific genetic sequences or motifs within large DNA datasets. This is valuable for tasks such as genome sequencing and identifying genes associated with certain traits or diseases.

9. **Compilers:**
   - Compilers use string matching algorithms for lexical analysis, where they identify and tokenize specific patterns in the source code. KMP can contribute to efficient pattern matching during this phase of compilation.

The KMP algorithm's efficiency in handling pattern matching makes it a versatile tool in various fields where finding occurrences of specific patterns in large datasets is a fundamental task. Its linear time complexity ensures practical applicability in scenarios involving sizable datasets.