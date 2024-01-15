# Exploring the "Group Anagrams" Problem: Strategy and Complexity Analysis

## introduction

**Grouping anagrams** is a common problem in computer science and involves categorizing words into groups where each group consists of words that are anagrams of each other. Anagrams are words or phrases formed by rearranging the letters of another word or phrase to produce a new word or phrase using all the original letters exactly once. For instance, "listen" and "silent" are anagrams of each other.

The primary goal when grouping anagrams is to efficiently identify and categorize words that share the same set of characters, regardless of the order of those characters. This task often involves creating a data structure that enables the efficient grouping of anagrams together.

One of the typical approaches to solving this problem involves using a data structure like a dictionary or hashmap. The key idea is to map a unique representation of each anagram group to a list of words that belong to that group. A common technique is to sort the characters of each word in the input list. Words with the same sorted characters will fall into the same category or group, as their sorted forms will be identical.

## Grouping anagrams

Grouping anagrams involves categorizing words into groups where each group contains words that are anagrams of each other. Anagrams are words that have the same characters but in a different order. For instance, "listen" and "silent" are anagrams of each other because they use the same letters but in different arrangement.

## overview

**Here's an overview of the approach:**

1. Iterate through the list of words.
2. For each word:
   - Sort its characters to create a unique representation.
   - Use this representation as a key in a dictionary.
   - Append the original word to the list corresponding to this key in the dictionary.
3. Once all words have been categorized, retrieve the values from the dictionary, which will contain lists of words grouped as anagrams.

This approach allows for the efficient grouping of anagrams together. It ensures that words with the same set of characters, even if in different orders, end up in the same group.

The time complexity of this approach typically depends on the length of the words and the total number of words in the input list. Sorting the characters of each word usually takes O(K log K) time, where K is the length of the longest word. The overall time complexity for grouping anagrams from a list of N words is usually O(N * K log K), where N is the number of words in the list.

Efficiently grouping anagrams can be useful in various applications, including spell checking, word games, text processing, and more, where identifying words with similar character sets is required.

## Python Code

```python
# Copyrights to venkys.io
# For more programs visit venkys.io
# Python program for Grouping anagrams

import time  # Import the time module for time-related functions

def groupAnagrams(strings):
    d = dict()  # Initialize an empty dictionary to store anagram groups
    for i in strings:
        string = "".join(sorted(i))  # Sort the characters of the current string
        if string not in d.keys():  # Check if the sorted string is already a key in the dictionary
            d[string] = [i]  # If not, create a new key-value pair with the sorted string as key and a list containing the string as value
        else:
            d[string].append(i)  # If the sorted string is already a key, append the string to the existing list
    return list(d.values())  # Return a list containing all the grouped anagrams

if __name__ == "__main__":
    # Take input from the user at runtime for the number of strings
    num_strings = int(input("Enter the number of strings: "))
    strs = []
    for i in range(num_strings):
        string = input(f"Enter string {i + 1}: ")  # Take input for each string from the user
        strs.append(string)  # Append each string to the list

    # Measure execution time
    start_time = time.time()  # Record the start time
    result = groupAnagrams(strs)  # Call the function with the input strings
    end_time = time.time()  # Record the end time

    # Output the results and execution time
    print("Anagram groups:", result)  # Display the grouped anagrams
    print("Execution time:", end_time - start_time, "seconds")  # Display the execution time
```

## Java Code

```java
// Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for Grouping anagrams

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // Function to group anagrams
    static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        // HashMap to store anagrams
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        // Loop through each string in the input array
        for (String s : strs) {
            StringBuilder sb = new StringBuilder();
            // Convert the string to char array and sort it
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            
            // Create a sorted string for identifying anagrams
            for (char ch : temp)
                sb.append(ch);
            
            // Get the list of anagrams for the current sorted string
            ArrayList<String> x = map.getOrDefault(sb.toString(), new ArrayList<String>());
            
            // Add the current string to its corresponding anagram list
            x.add(s);
            map.put(sb.toString(), x);
        }
        
        // Create an ArrayList to hold all the grouped anagrams
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        // Add each group of anagrams to the final result
        map.forEach((key, value) -> {
            ans.add(value);
        });
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of strings from the user
        System.out.print("Enter the number of strings: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Initialize an array to hold the strings
        String[] strs = new String[numStrings];
        
        // Input strings from the user
        for (int i = 0; i < numStrings; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strs[i] = scanner.nextLine();
        }

        // Measure execution time
        long startTime = System.currentTimeMillis();
        ArrayList<ArrayList<String>> result = groupAnagrams(strs);
        long endTime = System.currentTimeMillis();

        // Display the resulting groups of anagrams
        for (var r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
        
        // Display execution time
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");

        scanner.close();
    }
}
```

## C++ Code

```c++
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Grouping anagrams

#include<bits/stdc++.h> // Include necessary libraries

// Function to group anagrams in the input vector of strings
void groupAnagrams(std::vector<std::string>& strs) {
    std::map<std::string, std::vector<std::string>> map; // Create a map to store anagrams

    for (std::string s : strs) { // Iterate through each string in the input vector
        std::string prev = s; // Store the original string
        sort(s.begin(), s.end()); // Sort the characters of the string

        // Check if the sorted string is present in the map
        if (map.find(s) == map.end()) { // If not present, create a new vector and map it
            std::vector<std::string> temp{ prev }; // Create a vector with the original string
            map[s] = temp; // Map the sorted string to the vector
        } else { // If sorted string is present in the map, append the original string to its vector
            map[s].push_back(prev);
        }
    }

    // Output the grouped anagrams
    for (auto& it : map) { // Iterate through the map
        std::vector<std::string> temp{ it.second }; // Retrieve the vector of anagrams
        for (int i = 0; i < temp.size(); i++) // Output each word in the anagram group
            std::cout << temp[i] << " ";
        std::cout << std::endl;
    }
}

int main() {
    std::vector<std::string> strs; // Initialize a vector to store strings

    // Input number of strings and the strings themselves
    int numStrings;
    std::cout << "Enter the number of strings: ";
    std::cin >> numStrings;
    std::cin.ignore(); // Ignore the newline character after inputting the number

    std::cout << "Enter the strings:\n";
    for (int i = 0; i < numStrings; i++) {
        std::string input;
        std::getline(std::cin, input); // Input each string
        strs.push_back(input); // Add the string to the vector
    }

    // Measure execution time
    auto start = std::chrono::high_resolution_clock::now();
    groupAnagrams(strs); // Group the anagrams
    auto end = std::chrono::high_resolution_clock::now();
    std::chrono::duration<double> duration = end - start; // Calculate duration

    std::cout << "Execution time: " << duration.count() << " seconds" << std::endl; // Output execution time

    return 0;
}
```

The time complexity of the algorithm used to group anagrams is a crucial factor in understanding its efficiency, especially when dealing with larger inputs. Let's analyze the time complexity for the provided algorithm:

## Approach Overview

The approach involves iterating through a list of words and categorizing them into groups based on their sorted character representations. It uses a hashmap/dictionary to efficiently store and retrieve the grouped anagrams.

## Test Cases for groupingAnagrams

1. **Basic Test Case:**
   - Input:
     - Number of strings: 5
     - Strings: "eat", "tea", "tan", "ate", "nat", "bat"
   - Expected Output:
     - Anagram groups: [ ["eat","tea","ate"], ["tan","nat"], ["bat"] ]
   - Explanation: Strings "eat", "tea", and "ate" are anagrams of each other; "tan" and "nat" are anagrams of each other; "bat" has no anagrams in the input set.

2. **Empty Input Test Case:**
   - Input:
     - Number of strings: 0
   - Expected Output:
     - Anagram groups: [ ]
   - Explanation: There are no strings to the group, so the output should be an empty list.

3. **All Unique Strings Test Case:**
   - Input:
     - Number of strings: 4
     - Strings: "hello", "world", "open", "ai"
   - Expected Output:
     - Anagram groups: [ ["hello"], ["world"], ["open"], ["ai"] ]
   - Explanation: Each string is unique and has no anagrams in the input set.

4. **Duplicate Anagrams Test Case:**
   - Input:
     - Number of strings: 6
     - Strings: "listen", "silent", "debitcard", "badcredit", "elbow", "below"
   - Expected Output:
     - Anagram groups: [ ["listen","silent"], ["debitcard","badcredit"], ["elbow","below"] ]
   - Explanation: "listen" and "silent" are anagrams, as well as "debitcard" and "badcredit", while "elbow" and "below" are anagrams.

5. **Long Strings Test Case:**
   - Input:
     - Number of strings: 3
     - Strings: "astronomer", "moonstarer", "astronomre"
   - Expected Output:
     - Anagram groups: [ ["astronomer","moonstarer","astronomre"] ]
   - Explanation: All three strings are anagrams of each other.

These test cases cover scenarios with varying numbers of input strings, different lengths of strings, cases with no anagrams, and cases with multiple anagram groups. They can help validate the correctness and efficiency of the provided code for grouping anagrams.

## Time Complexity Analysis

1. **Iterating through the list of words:**
   - This step contributes O(N), where N is the number of words in the input list.

2. **Sorting characters of each word:**
   - Sorting typically takes O(K log K) time, where K is the length of the longest word.
   - For each of the N words, sorting takes O(K log K) time.

3. **Hashmap operations:**
   - For each word, adding to the hashmap or retrieving the value for a key takes average-case constant time, often denoted as O(1).

## Overall Time Complexity

- Iterating through N words and sorting each word (O(N * K log K)) is the primary factor in determining the time complexity of the algorithm.
- The other operations (hashmap operations) are comparatively less significant.
  
## Real-time applications

1. **Natural Language Processing (NLP):**

    - Spell Checking: Grouping anagrams can help identify potential misspellings by comparing the groups of words with similar letter arrangements.
    - Word Sense Disambiguation: Analyzing anagrams can aid in determining the correct meaning of a word based on its context.

2. **Data Cleaning and Deduplication:**

    - Data Cleansing: In databases, anagrams can be used to identify and clean duplicate records or entries with similar but differently arranged information.
    - Duplicate Detection: Anagram grouping can be applied to identify and merge duplicate entities, reducing redundancy in datasets.

3. **Cryptography:**

    - Cryptanalysis: Anagram analysis can be used in cryptanalysis to explore possible combinations of letters in encrypted messages, assisting in breaking codes or ciphers.

4. **Biomedical Research:**

    - Genetic Sequencing: Anagrams can be employed to analyze and compare genetic sequences, helping researchers identify similarities and differences in DNA or RNA sequences.

5. **Marketing and Search Engine Optimization (SEO):**

    - Keyword Analysis: Anagrams can be used in SEO to discover alternative keyword arrangements that users might use in search queries, improving content optimization and search engine rankings.

6. **Puzzle and Game Development:**

    - Word Games: Anagram grouping is commonly used in word games and puzzles to challenge players to rearrange letters to form meaningful words.

7. **Product Naming and Branding:**

    - Brand Name Creation: Companies may use anagram analysis to generate creative and unique brand names by rearranging letters from relevant words or phrases.
