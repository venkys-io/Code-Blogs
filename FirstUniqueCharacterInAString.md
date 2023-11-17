# FirstUniqueCharacterInAString
The "First Unique Character in a String" problem is a common programming problem that often appears in coding interviews. The goal is to find the first non-repeating character in a given string and return its index.
## Approach
One common approach to solving this problem involves using a hash map to store the frequency of each character in the string. The algorithm typically involves two passes through the string:
1. **First Pass:**
    - Create a hash map to store the frequency of each character.
    - Iterate through the string, updating the frequency in the hash map.
2. **Second Pass:**
    - Iterate through the string again.
    - Check the frequency of each character in the hash map.
    - Return the index of the first character with a frequency of 1.
## Code(Python)
```
def firstUniqueChar(s):
    # First pass to count character frequencies
    char_count = {}
    for char in s:
        char_count[char] = char_count.get(char, 0) + 1
    
    # Second pass to find the first unique character
    for i, char in enumerate(s):
        if char_count[char] == 1:
            return i
    
    # If no unique character is found
    return -1

# Example usage
input_string = "example"
result = firstUniqueChar(input_string)
print(result)
#output : 1
```
# Step-by-step Explanation of python code

1. **Function Definition:**
    - **`def firstUniqueChar(s):`** defines a function named **`firstUniqueChar`** that takes a string **`s`** as input.
2. **Initialize Dictionary:**
    - **`char_count = {}`** initializes an empty dictionary **`char_count`** that will be used to store the frequency of each character.
3. **First Pass: Counting Frequencies:**
    - **`for char in s:`** iterates through each character in the input string **`s`**.
    - **`char_count[char] = char_count.get(char, 0) + 1`** updates the frequency count for the current character. If the character is not in the dictionary, it sets the count to 1; otherwise, it increments the existing count by 1.
    
    **Second Pass: Finding the First Unique Character:**
    
    - **`for i, char in enumerate(s):`** iterates through each character in the input string along with its index using the **`enumerate`** function.
    - **`if char_count[char] == 1:`** checks if the current character has a frequency of 1 in the **`char_count`** dictionary.
    - **`return i`** returns the index of the first unique character.
    
    **Default Return:**
    
    - If no unique character is found in the second pass, the function returns **`1`** to indicate that there is no unique character in the string.
## Code(Java)
```
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static int firstUniqueChar(String s) {
        // First pass to count character frequencies
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Second pass to find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character is found
        return -1;
    }

    public static void main(String[] args) {
        String inputString = "example";
        int result = firstUniqueChar(inputString);
        System.out.println(result);
    }
}
//output : 1
```
# Step-by-step explanation for java code

1. **Import Statements:**
    - **`import java.util.HashMap;`** and **`import java.util.Map;`** import the necessary classes for using a HashMap.
2. **Class Definition:**
    - **`public class FirstUniqueCharacter {`** defines a class named **`FirstUniqueCharacter`**.
3. **Method Definition:**
    - **`public static int firstUniqueChar(String s) {`** defines a static method named **`firstUniqueChar`** that takes a string **`s`** as a parameter and returns an integer.
4. **Initialize HashMap:**
    - **`Map<Character, Integer> charCount = new HashMap<>();`** creates a HashMap called **`charCount`** to store the frequency of each character.
5. **First Pass: Counting Frequencies:**
    - **`for (char c : s.toCharArray()) {`** iterates through each character in the string **`s`** by converting it to a char array.
    - **`charCount.put(c, charCount.getOrDefault(c, 0) + 1);`** updates the frequency count for the current character. If the character is not in the map, it sets the count to 1; otherwise, it increments the existing count by 1.
    
    **Second Pass: Finding the First Unique Character:**
    
    - **`for (int i = 0; i < s.length(); i++) {`** iterates through each index of the string.
    - **`if (charCount.get(s.charAt(i)) == 1) {`** checks if the current character has a frequency of 1 in the **`charCount`** map.
    - **`return i;`** returns the index of the first unique character.
    
    **Default Return and Main Method:**
    
    - **`return -1;`** is reached if no unique character is found during the second pass.
    - **`public static void main(String[] args) {`** defines the **`main`** method where an example string "leetcode" is used as input to the **`firstUniqueChar`** method, and the result is printed to the console.
    
    This Java code essentially follows the same logic as the Python code, using a HashMap to count character frequencies and two passes through the string to find the first unique character. The output will be **`0`**, indicating that the first unique character in the string "example" is at index 1
## Code(C++)
```
#include <iostream>
#include <unordered_map>

int firstUniqueChar(std::string s) {
    // First pass to count character frequencies
    std::unordered_map<char, int> charCount;
    for (char c : s) {
        charCount[c]++;
    }

    // Second pass to find the first unique character
    for (int i = 0; i < s.length(); i++) {
        if (charCount[s[i]] == 1) {
            return i;
        }
    }

    // If no unique character is found
    return -1;
}

int main() {
    std::string inputString = "example";
    int result = firstUniqueChar(inputString);
    std::cout << result << std::endl;

    return 0;
}
//output : 1
```
# Step-by-step explanation for c++ code

1. **Include Statements:**
    - **`#include <iostream>`** and **`#include <unordered_map>`** include the necessary libraries for input/output and using an unordered map.
2. **Function Definition:**
    - **`int firstUniqueChar(std::string s) {`** defines a function named **`firstUniqueChar`** that takes a string **`s`** as a parameter and returns an integer.
3. **Initialize Unordered Map:**
    - **`std::unordered_map<char, int> charCount;`** creates an unordered map called **`charCount`** to store the frequency of each character.
4. **First Pass: Counting Frequencies:**
    - **`for (char c : s) {`** iterates through each character in the string **`s`**.
    - **`charCount[c]++;`** increments the frequency count for the current character.
    
    **Second Pass: Finding the First Unique Character:**
    
    - **`for (int i = 0; i < s.length(); i++) {`** iterates through each index of the string.
    - **`if (charCount[s[i]] == 1) {`** checks if the frequency of the character at the current index is 1 in the **`charCount`** map.
    - **`return i;`** returns the index of the first unique character.
    
    **Default Return and Main Function:**
    
    - **`return -1;`** is reached if no unique character is found during the second pass.
    - **`int main() {`** defines the **`main`** function where an example string "leetcode" is used as input to the **`firstUniqueChar`** function, and the result is printed to the console using **`std::cout`**.
    
    This C++ code follows the same logic as the Python and Java codes, using an unordered map to count character frequencies and two passes through the string to find the first unique character. The output will be **`0`**, indicating that the first unique character in the string "example" is at index 1.
