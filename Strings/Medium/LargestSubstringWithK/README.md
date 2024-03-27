# Largest Substring With K

## Problem Statement
The Largest Substring with K Distinct Characters problem involves finding the longest contiguous substring within a given string that contains at most K distinct characters.

## Introduction

The "LargestSubstringWithK" program is designed to address the challenge of finding the longest contiguous substring within a given string that contains at most K distinct characters. This algorithmic problem is commonly encountered in the realm of string manipulation and is crucial in various applications such as natural language processing and bioinformatics. 

The program employs a sliding window technique, dynamically adjusting the window's boundaries as it iterates through the string. By efficiently keeping track of the unique characters within the window, the algorithm identifies the longest substring meeting the specified criteria. The "LargestSubstringWithK" program showcases the intersection of data structures and algorithmic strategies, providing a robust solution to a problem with practical relevance in diverse computational domains.

## Overview
The problem is efficiently solved using a sliding window technique. The algorithm dynamically adjusts the window's boundaries as it iterates through the string, identifying the longest substring that satisfies the criteria of containing at most K distinct characters. This approach ensures an optimal solution by keeping track of unique characters within the window.

### Sliding Window technique

The sliding window technique for the Largest Substring with K Distinct Characters problem can be broken down into five simple steps:

1. **Initialize Pointers:**
   - Set two pointers, `left` and `right`, to the start of the string.
   - These pointers represent the boundaries of the current substring under consideration.

2. **Expand the Window:**
   - Move the `right` pointer to the right, expanding the window.
   - Keep track of the characters encountered and their frequencies.

3. **Maintain K Distinct Characters:**
   - While expanding the window, ensure that the number of distinct characters within the window does not exceed K.
   - If the count exceeds K, start shrinking the window from the `left` to maintain at most K distinct characters.

4. **Track Maximum Length:**
   - During each iteration, track the length of the current substring.
   - Update the result whenever a longer substring is found.

5. **Repeat until the End:**
   - Continue the process until the `right` pointer reaches the end of the string.
   - The result will be the longest substring with at most K distinct characters.

## Code
### Java 
```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(n)
//Time complexity: O(n^2)

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithK {

    public static int longestSubstring(String s, int k) {
        // Check if the input string is null or empty
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Counter to track the frequency of characters in the input string
        HashMap<Character, Integer> counter = new HashMap<>();

        // Find the maximum number of distinct characters in the string
        int maxDistinctChars = countDistinctChars(s);

        // Length of the input string
        int n = s.length();

        // Variable to store the final result
        int ans = 0;

        // Iterate over the possible number of distinct characters (num)
        for (int num = 1; num <= maxDistinctChars; num++) {
            // Counter for characters within the current window
            HashMap<Character, Integer> charCount = new HashMap<>();

            // Left pointer for window contraction
            int left = 0;

            // Iterate over the string with the right pointer
            for (int right = 0; right < n; right++) {
                char currentChar = s.charAt(right);

                // Update the count of the current character in the window
                charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

                // Shrink the window if the number of distinct characters exceeds 'num'
                while (charCount.size() > num) {
                    char leftChar = s.charAt(left);
                    charCount.put(leftChar, charCount.get(leftChar) - 1);

                    // Remove the character if its count becomes 0
                    if (charCount.get(leftChar) == 0) {
                        charCount.remove(leftChar);
                    }

                    // Move the left pointer to shrink the window
                    left++;
                }

                // Update result if all character counts are at least 'k'
                boolean allCountsAtLeastK = charCount.values().stream().allMatch(count -> count >= k);
                if (allCountsAtLeastK) {
                    // Update the length of the longest substring if needed
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }
        // Return the final result
        return ans;
    }

    // Helper function to count the number of distinct characters in the string
    private static int countDistinctChars(String s) {
        // Counter to track the frequency of characters
        HashMap<Character, Integer> counter = new HashMap<>();

        // Iterate over the string and count distinct characters
        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        // Return the number of distinct characters
        return counter.size();
    }

    // Main method for testing the function
    public static void main(String[] args) {
        // Take input string and k from the user
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        int k = scanner.nextInt();

        // Print the result of the longestSubstring function
        System.out.println(longestSubstring(string, k));
    }
}

```

### Python 
```python
# Copyrights to venkys.io
# For more information, visit https://venkys.io */

# Space complexity: O(n)
# Time complexity: O(n^2)

from collections import Counter, defaultdict

def longestSubstring(string, k):
    # Check if the input string is not empty
    if not string:
        return 0

    # Count the occurrences of each character in the string
    char_count = Counter(string)
    # Determine the maximum number of unique characters
    max_unique_chars = len(char_count)
    n = len(string)
    ans = 0

    # Iterate over the possible number of unique characters (1 to max_unique_chars)
    for num in range(1, max_unique_chars + 1):
        # Counter to keep track of characters in the current window
        counter = defaultdict(int)
        left = 0

        # Iterate over the string with a sliding window
        for right in range(n):
            counter[string[right]] += 1

            # Shrink the window if the number of unique characters exceeds the target (num)
            while len(counter) > num:
                counter[string[left]] -= 1
                if counter[string[left]] == 0:
                    del counter[string[left]]
                left += 1

            # Check if all characters in the current window appear at least k times
            if all(count >= k for key, count in counter.items()):
                ans = max(ans, right - left + 1)

    return ans

def main():
    # Take input from the user
    input_str = input()
    k_value = int(input())
    
    # Call the function and print the result
    result = longestSubstring(input_str, k_value)
    print(result)

if __name__ == "__main__":
    main()


```

### CPP
```cpp

/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Time complexity: O(n^2)
//Space complexity: O(n)

#include <iostream>
#include <unordered_map>
using namespace std;

int longestSubstring(string str, int k) {
    // Check if the input string is not empty
    if (str.empty()) {
        return 0;
    }

    // Initialize a counter to track the frequency of characters in the input string
    unordered_map<char, int> freq;
    for (char c : str) {
        freq[c]++;
    }

    // Find the maximum number of distinct characters in the string
    int maxDistinctChars = freq.size();

    // Length of the input string
    int n = str.length();

    // Variable to store the final result
    int longestSubstring = 0;

    // Iterate over all possible number of distinct characters (num)
    for (int num = 1; num <= maxDistinctChars; num++) {
        // Counter for characters within the current window
        unordered_map<char, int> windowFreq;

        // Left pointer for window contraction
        int left = 0;

        // Iterate over the string with the right pointer
        for (int right = 0; right < n; right++) {
            char currentChar = str[right];

            // Update the count of the current character in the window
            windowFreq[currentChar]++;

            // Shrink the window if the number of distinct characters exceeds 'num'
            while (windowFreq.size() > num) {
                char leftChar = str[left];
                windowFreq[leftChar]--;

                // Remove the character if its count becomes 0
                if (windowFreq[leftChar] == 0) {
                    windowFreq.erase(leftChar);
                }

                // Move the left pointer to shrink the window
                left++;
            }

            // Update result if all character counts are at least 'k'
            bool allCountsAtLeastK = true;
            for (auto& charFreq : windowFreq) {
                if (charFreq.second < k) {
                    allCountsAtLeastK = false;
                    break;
                }
            }

            if (allCountsAtLeastK) {
                // Update the length of the longest substring if needed
                longestSubstring = max(longestSubstring, right - left + 1);
            }
        }
    }

    // Return the final result
    return longestSubstring;
}

int main() {
    // Take input string and k from the user
    string str;
    cin >> str;

    int k;
    cin >> k;

    // Print the result of the longestSubstring function
    cout << longestSubstring(str, k) << endl;

    return 0;
}

```

## Step-by-Step Explanation(Common for Java, Python and CPP)

### Step 1: Initialize Variables
   **Counter Initialization (Common for Python, Java):**
   - Initialize a counter to track the frequency of characters in the input string using a data structure like HashMap or Counter.

   **Maximum Distinct Characters (Common for Python, Java, C++):**
   - Determine the maximum number of distinct characters in the string.

   **Length of the Input String (Common for Python, Java, C++):**
   - Find the length of the input string.

   **Result Variable Initialization (Common for Python, Java, C++):**
   - Initialize a variable to store the final result.

### Step 2: Iterate for Different Number of Distinct Characters
   **Outer Loop (Common for Python, Java, C++):**
   - Iterate over the possible number of distinct characters (`num`) from 1 to the maximum distinct characters.

### Step 3: Sliding Window
   **Inner Loop (Common for Python, Java, C++):**
   - Iterate over the string using a sliding window approach with left and right pointers.
   - The right pointer expands the window, and the left pointer contracts the window.

   **Character Count Update (Common for Python, Java, C++):**
   - Update the count of the current character in the window.

   **Shrink the Window (Common for Python, Java, C++):**
   - Shrink the window if the number of distinct characters exceeds the current value of `num`.
   - Remove characters from the left until the window satisfies the condition.

   **Check for Valid Substring (Common for Python, Java, C++):**
   - Check if all character counts in the current window are at least `k`.

   **Update Result (Common for Python, Java, C++):**
   - If the current substring is valid and longer than the previous result, update the result.

### Step 4: Return the Final Result
   **Return Result (Common for Python, Java, C++):**
   - After both loops, return the final result representing the length of the longest substring.

## Time and Space Complexity Analysis
**Time Complexity:**

The time complexity of the code is O(n^2), where n is the length of the input string. This is because the outer loop iterates over all possible numbers of distinct characters (num), which can range from 1 to n. Inside the outer loop, the inner loop iterates over the input string, and the window contraction process within the inner loop also takes O(n) time. Therefore, the overall time complexity is O(n^2).

**Space Complexity:**

The space complexity of the code is O(n), where n is the length of the input string. This is because the code uses two HashMaps (or their equivalent data structures in Java and C++): one to track the frequency of characters in the input string (counter) and the other to track the frequency of characters within the current window (charCount). Both HashMaps can grow to a size of n, so the overall space complexity is O(n).

Therefore, the overall time complexity is O(n^2), and the space complexity is O(n).

## Real-World Applications

1. **Genomic Sequencing:**
   - In bioinformatics, genomic data often involves analyzing DNA sequences. Identifying the longest substring with a limited set of distinct characters can help in understanding genetic patterns and variations.

2. **Text Processing and Natural Language Processing (NLP):**
   - In text analysis, finding the longest substring with K distinct characters can be useful for extracting meaningful phrases or entities from a text corpus. This can aid in sentiment analysis, named entity recognition, and other NLP tasks.

3. **Network Traffic Analysis:**
   - Analyzing network logs and packets may involve identifying patterns in communication. The longest substring with K distinct characters can be applied to recognize the longest sequences of specific types of network activities or protocols.

4. **Speech Recognition:**
   - In speech processing, the algorithm can be used to identify the longest segment of speech with a limited set of distinct phonemes. This can be helpful in speech recognition systems to improve accuracy and understanding of spoken language.

5. **Computer Vision:**
   - In image processing, when analyzing pixel data, identifying the longest substring with a specific set of color values can be beneficial. This can be applied in tasks such as object recognition, where identifying consistent patterns in pixel values is crucial.

6. **Data Compression:**
   - The algorithm can be used in data compression techniques to identify repetitive patterns in a dataset. By finding the longest substring with a limited set of distinct elements, compression algorithms can represent data more efficiently.
