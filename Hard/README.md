# MULTISTRINGSEARCH

The process involves preprocessing the patterns or texts and constructing data structures that facilitate efficient pattern matching. Once the data structures are built, these algorithms enable rapid retrieval of patterns within the given text(s).

- Components of Multistring Search:
Algorithms often involve a preprocessing phase to construct data structures that facilitate quick and efficient pattern matching. These structures aim to accelerate the search process, making it faster than traditional linear scanning methods.

- Pattern Matching Techniques:
        Trie Structures: Suitable for searching multiple fixed strings within a text.
        Suffix Trees: Efficient for searching multiple strings of variable lengths.
        Hashing: Utilized for rapid comparison and matching of patterns.
        Search Process:
        Once the data structures are constructed, the search process involves navigating through the text(s) to locate occurrences of the specified patterns efficiently.

--> Step-by-Step Algorithm:

        (1) Create a trie data structure from the set of patterns (strings) you want to search for. Each node in the trie represents a character in the patterns.
        (2) Initialize a pointer to the root of the trie and another pointer to the current character in the text being searched.
        (3) Starting from the root of the trie, traverse it using the characters in the text.
                Move the trie pointer down the trie based on the characters in the text.
        (4) At each step of the traversal, check if the current character in the text matches a character represented by a trie node.
                If there is a match, continue traversing down the trie. If not, reset the trie pointer to the root.
        (5) When reaching the end of a pattern in the trie, mark that pattern as found in the text.
                Continue the search for other patterns.
        (6) Move the text pointer to the next character and repeat the trie traversal.
        (7) Continue the process until the text pointer reaches the end of the text.
        (8) Collect the positions or indices in the text where each pattern was found.

# Practical Applications:
       - Text Processing:
        Search Engines: Identifying multiple keywords in search queries.
        Document Analysis: Detecting phrases, terms, or patterns within texts or documents.
      - Bioinformatics:
        Genomic Analysis: Locating DNA sequences, identifying gene patterns, and comparing genetic information.
       - Data Mining:
        Log Analysis: Searching for multiple keywords in logs for error detection or pattern recognition.
        Information Retrieval: Efficiently finding relevant data in large datasets or databases.

# Algorithmic Variations:
        Boyer-Moore Algorithm: Efficient for searching multiple fixed strings.
        Aho-Corasick Algorithm: Particularly useful for searching multiple patterns in a text simultaneously.
        Rabin-Karp Algorithm: Utilizes hashing for pattern matching.

# Exploration:
        Multistring search algorithms aim to efficiently locate multiple patterns within a text or a set of texts. Different algorithms and data structures, such as trie structures, suffix trees, and hashing techniques, are utilized to optimize the search process.


# Time complexities:
        The time complexity of multistring search algorithms varies based on the chosen technique. Some algorithms offer sublinear or linear time complexities, while others might operate in O(n * m) time, where n is the length of the text and m is the total length of the patterns.

#    PYTHON Code    


```python
def multi_string_search(text, patterns):
    result = []

    for pattern in patterns:
        # Use the built-in find method to check if the pattern is present in the text
        if text.find(pattern) != -1:
            result.append(pattern)

    return result


if __name__ == "__main__":
    # Sample text and patterns
    text = "This is a sample text for multi-string search."
    patterns = ["sample", "search", "notfound"]

    # Perform multi-string search
    result = multi_string_search(text, patterns)

    # Print the found patterns
    print("Found patterns:", *result)

```
### Output
![Alt text](../Outputs/MSSPY.png)

## Explanation:
        - multi_string_search is a function that takes two parameters: text (the text to search within) and patterns (a list of patterns to find within the text).
        - It initializes an empty list result to store the patterns found in the text.
        - It iterates through each pattern in the patterns list.
        - For each pattern, it checks if the pattern exists in the text using the find() method, which returns the index of the pattern in the text. If the pattern is not found, find() returns -1.
        - If the pattern is found (i.e., find() doesn't return -1), the pattern is appended to the result list.
        - Finally, it returns the list of found patterns.


#    C++ Code    

```c++

#include <iostream>
#include <vector>
#include <algorithm>

// Function to perform multi-string search
// Returns a vector containing patterns found in the text

std::vector<std::string> multiStringSearch(const std::string& text, const std::vector<std::string>& patterns) {
    std::vector<std::string> result;

    for (const auto& pattern : patterns) {
        // Use std::search to find the pattern in the text
        if (std::search(text.begin(), text.end(), pattern.begin(), pattern.end()) != text.end()) {
            result.push_back(pattern);
        }
    }

    return result;
}

int main() {
    // Sample text and patterns
    std::string text = "This is a sample text for multi-string search.";
    std::vector<std::string> patterns = {"sample", "search", "notfound"};

    // Perform multi-string search
    std::vector<std::string> result = multiStringSearch(text, patterns);

    // Print the found patterns
    std::cout << "Found patterns:";
    for (const auto& pattern : result) {
        std::cout << " " << pattern;
    }
    std::cout << std::endl;

    return 0;
}
```
### Output
![Alt text](../Outputs/MSSC++.png)

# Explanation:
        - multiStringSearch is a function that takes two parameters: text (the text to search within) and patterns (a vector of strings containing the patterns to find within the text).
        - It initializes an empty vector result to store the patterns found in the text.
        - It iterates through each pattern in the patterns vector.
        - For each pattern, it uses std::search to find the occurrence of the pattern in the text. std::search searches for a range of elements within another range and returns an iterator to the first occurrence of the pattern within the text or text.end() if not found.
        - If the pattern is found (i.e., std::search doesn't return text.end()), it adds the pattern to the result vector.
        - Finally, it returns the result vector containing the found patterns.


#    JAVA Code    


```java
import java.util.ArrayList;
import java.util.List;

public class MultiStringSearch {

    // Function to perform multi-string search
    // Returns a list containing patterns found in the text

    public static List<String> multiStringSearch(String text, List<String> patterns) {
        List<String> result = new ArrayList<>();

        // Iterate through each pattern
        for (String pattern : patterns) {
            // Use String.contains to check if the pattern is present in the text
            if (text.contains(pattern)) {
                result.add(pattern);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Sample text and patterns
        String text = "This is a sample text for multi-string search.";
        List<String> patterns = List.of("sample", "search", "notfound");

        // Perform multi-string search
        List<String> result = multiStringSearch(text, patterns);

        // Print the found patterns
        System.out.print("Found patterns:");
        for (String pattern : result) {
            System.out.print(" " + pattern);
        }
        System.out.println();
    }
}
```

### Output
![Alt text](../Outputs/MSSJAVA.png)

# Explanation:
        - multiStringSearch is a static method that takes two parameters: text (the text to search within) and patterns (a list of strings containing the patterns to find within the text).
        - It initializes an empty ArrayList called result to store the patterns found in the text.
        - The function iterates through each pattern in the patterns list using an enhanced for-loop.
        - For each pattern, it uses the String.contains method to check if the pattern is present in the text. If found, it adds the pattern to the result list.
        - Finally, it returns the result list containing the found patterns.



# Advantages of Multistring Search:
       -  Efficiency: Designed to handle multiple patterns concurrently, optimizing search times even when dealing with numerous patterns or large texts.
       -  Flexibility: Works with various text lengths and patterns, accommodating both fixed and variable-length strings.
       -  Optimized Processing: Enables quicker retrieval of patterns by employing specialized data structures and algorithms.

## Drawbacks : 
        Memory Overhead
        Complexity
        Not Always Optimal

## Uses : 
        Spell Checking
        Code Editors
        Text Processing
        Network Security
        DNA Sequencing
