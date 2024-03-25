## Exploring Morse Code Transformation for Word Representation
In this exploration, we delve into a program designed to convert words into Morse code representations and count the number of unique transformations. Let's unravel the details of the provided code and comprehend how it skillfully transforms words into Morse code, ensuring uniqueness in the representations.

## Problem Statement:
Given a list of words, the task is to convert each word into its Morse code representation. The goal is to count the number of unique Morse code representations among the given words.

## Introduction to String 
Strings, within the context of programming, manifest as sequences of text enclosed in quotes. They serve as indispensable tools for managing textual data, offering a versatile platform for manipulating and analyzing words or symbols.

## Word Representation
In this context, "word representation" means expressing a word uniquely using Morse code. Each letter in a word is replaced by its Morse code equivalent from the `morse` list.

For example:
- "a" becomes ".-"
- "b" becomes "-..."
- "c" becomes "-.-."
- and so on...

When dealing with a specific word, the process involves combining the Morse code representations of its individual letters to form a complete Morse code representation for the entire word.

## Overview of Functionality
- Within a given list of words, the objective is to determine the count of unique Morse code representations corresponding to these words. 
- Each letter undergoes replacement by its Morse code representation, with the Morse code for each letter conveniently provided in the `morse` list.
- Consequently, for a given word, the process involves concatenating the Morse code representation of each of its letters to construct the comprehensive Morse code representation of the word. The program then counts the distinct representations.

## Sample Test Cases
```bash
gin zen gig msg
```
```bash
hello
```
```bash
abc def ghi abc jkl
```
## Python Code
```python
# Copyrights to venkys.io
# For more information, visit https://venkys.io 

# Python Program for Unique Morse Code Words
# Stable: Yes
# Inplace: No
# Adaptive: No

# Time Complexity: O(N * M), where N is the number of words and M is the average length of words
# Space Complexity: O(N * M)

# Function to count unique Morse code representations 
def uniqueMorseRepresentations(words: list[str]) -> int:
    # Dictionary to map each lowercase letter to its Morse code representation
    morsedict = dict()
    
    # Predefined Morse code representations for each letter
    morse = [".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."]

    # Mapping lowercase letters to Morse code representations in the dictionary
    j = 0
    for i in range(97, 97 + 26):
        morsedict[chr(i)] = morse[j]
        j += 1
    
    # Set to store unique Morse code representations
    lst = set()
    
    # Iterating through each word in the input list
    for word in words:
        answer = ""
        
        # Constructing the Morse code representation for each letter in the word
        for char in word:
            answer += morsedict[char]
        
        # Adding the complete Morse code representation to the set
        lst.add(answer)
    
    # Returning the count of unique Morse code representations
    return len(lst)

# Test the function
if __name__ == "__main__":
    # Example words = ["gin", "zen", "gig", "msg"]
    words = input("Enter a list of words separated by spaces: ").split()
    if words:
        print(uniqueMorseRepresentations(words))  # Print the result of the function

```
### Step-by-Step Explanation of Python Code

- **Morse Code Dictionary Creation**
   
   A dictionary named `morsedict` is created to map each lowercase letter to its Morse code representation. This is achieved through a loop that iterates over the ASCII values of lowercase letters.

- **Unique Representations Set**
   
   A set named `lst` is established to store unique Morse code representations.

- **Iterating Through Words**
   
   The function iterates through each word in the input list.

- **Building Morse Code Representations**
   
   For each word, the function iterates through its characters, using `morsedict` to find the Morse code representation of each character. These representations are then concatenated to form the complete Morse code representation of the word.

- **Adding to the Set**
   
   The complete Morse code representation is added to the set `lst`.

- **Returning the Count**
   
   The function concludes by returning the length of the set `lst`, providing the count of unique Morse code representations.

## JAVA Code
```JAVA
// Copyrights to venkys.io
// For more information, visit https://venkys.io 

// Java Program for Unique Morse Code Words
// Stable: Yes
// Inplace: No
// Adaptive: No

// Time Complexity: O(N * M), where N is the number of words and M is the average length of words
// Space Complexity: O(N * M)

import java.util.*;

public class Main {

    // Array to store Morse code representations for each lowercase letter
    static String[] morse_code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    // Function to count unique Morse code representations
    static int code(String[] words) {
        // HashSet to store unique Morse code representations
        HashSet<String> lst = new HashSet<>();
        String ans;

        // Iterating through each word in the input array
        for (String word : words) {
            ans = "";

            // Constructing the Morse code representation for each character in the word
            for (char ch : word.toCharArray()) {
                // Mapping the character to its Morse code representation using ASCII values
                ans += morse_code[ch - 97];
            }

            // Adding the complete Morse code representation to the HashSet
            lst.add(ans);
        }

        // Returning the count of unique Morse code representations
        return lst.size();
    }

    public static void main(String[] args) {
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter words separated by spaces
        System.out.print("Enter words separated by spaces: ");

        // Reading the input line and splitting it into an array of words
        String input = scanner.nextLine();
        String[] words = input.split(" ");

        // Calling the 'code' function and printing the result
        System.out.println(code(words));
    }
}
```
### Step-by-Step Explanation of Java Code

- **Importing Java Utilities:**
  
   The `java.util` package, which includes the `Scanner` class for user input and the `HashSet` class for efficiently storing unique Morse code representations.

- **Morse Code Array**

   An array `morse_code` is declared to store Morse code representations for each lowercase letter. The indices of this array correspond to the ASCII values of the lowercase letters.

- **Method to Count Unique Morse Code Representations**
   - The method `code` takes an array of words as input.
   - It initializes a `HashSet` (`lst`) to store unique Morse code representations.
   - It iterates through each word, constructing the Morse code representation for each character and adding it to the set.
   - The method returns the size of the set, representing the count of unique Morse code representations.

- **Main Method for User Interaction**

   The `main` method initializes a `Scanner` object for user input. The program collects a line of words from the user, splits them into an array, converts each word to Morse code, and prints the count of unique representations.

## CPP Code
```CPP
// Copyrights to venkys.io
// For more information, visit https://venkys.io 

// CPP Program for Unique Morse Code Words
// Stable: Yes
// Inplace: No
// Adaptive: No

// Time Complexity: O(N * M), where N is the number of words and M is the average length of words
// Space Complexity: O(N * M)

#include <iostream>      // Standard input/output stream
#include <vector>        // Standard vector container
#include <set>           // Standard set container
#include <sstream>       // String stream for parsing
#include <iterator>      // Iterator functionalities

// Array to store Morse code representations for each lowercase letter
std::string morse_code[26] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

// Function to count unique Morse code representations for a list of words
int countUniqueMorseCodeWords(const std::vector<std::string>& words) {
    // Set to store unique Morse code representations
    std::set<std::string> uniqueMorseCodes;

    // Iterate through each word in the input vector
    for (const std::string& word : words) {
        // String to store the Morse code representation for the current word
        std::string morseCode;

        // Construct the Morse code representation for each character in the word
        for (char ch : word) {
            morseCode += morse_code[ch - 'a'];
        }

        // Add the complete Morse code representation to the set
        uniqueMorseCodes.insert(morseCode);
    }

    // Return the count of unique Morse code representations
    return uniqueMorseCodes.size();
}

int main() {
    // Prompt the user to enter words separated by space
    std::cout << "Enter words separated by space: ";

    // Read the input line
    std::string inputLine;
    std::getline(std::cin, inputLine);

    // Use a string stream to split the input line into a vector of words
    std::istringstream iss(inputLine);
    std::vector<std::string> words(std::istream_iterator<std::string>{iss}, std::istream_iterator<std::string>());

    // Print the result of counting unique Morse code representations for the entered words
    std::cout << "Result: " << countUniqueMorseCodeWords(words) << std::endl;

    return 0;
}
```
### Step-by-Step Explanation of CPP Code

- **Include Statements**

   The code includes necessary C++ libraries for input/output (`iostream`), containers (`vector`, `set`), string stream operations (`sstream`), and iterator functionalities (`iterator`).

- **Morse Code Array**
   
   An array `morse_code` is declared to store Morse code representations for each lowercase letter.

- **Function (`countUniqueMorseCodeWords`)**
   - This function takes a vector of words as input and counts the number of unique Morse code representations.
   - It uses a set (`uniqueMorseCodes`) to store unique representations and iterates through each word to construct and add Morse codes to the set.
   - The function returns the size of the set, indicating the count of unique Morse code representations.

- **Main Function**
   - Prompts the user to enter words separated by space.
   - Reads the input line and uses a string stream to split it into a vector of words.
   - Calls the `countUniqueMorseCodeWords` function with the vector of words and prints the result.
   - Returns 0 to indicate successful program execution.

## Time and Space Complexity
**Time Complexity:**
- The time complexity is O(N * M), where N is the number of words and M is the average length of words.
- The nested loop iterates over each word and each character in the word, performing constant-time operations.

**Space Complexity:** The space complexity is O(N * M).

## Real-World Applications of Unique Morse Code Words

1. **Historical Significance:** Morse code, a classic encoding system of dots and dashes, holds historical importance in early telecommunication, notably in telegraphy.

2. **Efficient Data Handling:** Unique representations, like Morse code, are foundational in data compression, allowing for efficient storage and transmission of information in modern computing.

3. **Enhanced Security:** Transforming data into unique formats is a core principle in cryptography, ensuring secure communication by making messages less susceptible to unauthorized access.

4. **Everyday Convenience:** Barcodes and QR codes exemplify the practical use of unique representations, simplifying tasks in retail, logistics, and daily life by encoding information for quick retrieval.

## Conclusion
The Unique Morse Code Words program efficiently converts words into unique Morse code representations. With a time complexity of O(N * M) and space complexity of O(N * M), it offers a practical solution for encoding words. Its simplicity and versatility make it applicable in communication, cryptography, and education. In summary, this program provides a valuable tool for unique data representation, demonstrating its utility across various domains.