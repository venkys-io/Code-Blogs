# Exploring String Algorithms:Roman to Integer

Dive into the realm of particular emphasis on uncovering the roman to integer conversion problem through the utilization of string algorithm. This intriguing challenge not only captivates but also offers a practical avenue to delve into the intricacies of data structures and foster algorithmic thinking.

# Introduction to String Algorithms

String algorithms, a versatile toolkit for tackling an array of computational challenges. String algorithms, designed for the manipulation and analysis of sequences of characters, are essential in addressing a wide spectrum of problems in computer science. Within this domain, string algorithms prove instrumental in tasks such as pattern matching, substring search, and the optimization of various string-related operations.

As we explore, we'll know much about fundamental string algorithms, examining techniques like string matching, regular expressions, and dynamic programming. Join this journey into the heart of string manipulation, where the algorithms we encounter will become indispensable tools for deciphering, analyzing, and extracting valuable information from the world of characters and text.

One of the fundamental case in string algorithms is Robot return to Origin.

## Roman numerals to Integer

A Roman numeral to integer algorithm is a method for converting Roman numerals, which are a system of symbols used in ancient Rome to represent numbers, into their corresponding integer values.Roman numerals use a combination of letters from the Latin alphabet (I, V, X, L, C, D, M) to represent numbers.There are two main types of Roman numeral to integer algorithms: subtractive and additive.

Set a variableto 0 to store the final integer value then start from the leftmost character of the Roman numeral string. Compare the current numeral with the next numeral to determine the appropriate operation (addition or subtraction).

If the value of the current numeral is less than the value of the next numeral, subtract the current numeral's value from the result.If the value of the current numeral is greater than or equal to the value of the next numeral, add the current numeral's value to the result.

Here's a simple example:

Roman numeral: XIV

Process: X (10) + (V (5) - I (1))

Result: 14

## Python code

```python
def roman_to_int(s):
    roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
# Define a dictionary mapping Roman numerals to their integer values
    result = 0  # Initialize the result variable to store the total integer value

    # Loop through the Roman numeral string from left to right
    for i in range(len(s)):
        # If the current numeral is smaller than the next numeral, subtract its value
        if i < len(s) - 1 and roman_dict[s[i]] < roman_dict[s[i + 1]]:
            result -= roman_dict[s[i]]
        else:
            result += roman_dict[s[i]]

    return result

# Test the function
roman_numeral = input("Enter a Roman numeral: ")
integer_value = roman_to_int(roman_numeral.upper())
print(f"The integer value of {roman_numeral} is: {integer_value}")
```

### Step-by-Step Explaination

1. **Function Definition:**
    - **`def roman_to_int(s):`**: This line defines a function named **`roman_to_int`** that takes a string **`s`** representing a Roman numeral as its parameter.
2. **Roman Numeral Dictionary:**
    - **`roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}`**: This line creates a dictionary (**`roman_dict`**) that maps Roman numeral characters to their corresponding integer values.
3. **Initialization:**
    - **`result = 0`**: This line initializes a variable **`result`** to store the total integer value, starting with 0.
4. **Loop through the Roman Numeral String:**
    - **`for i in range(len(s)):`**: This line starts a loop that iterates through each character in the input Roman numeral string.
5. **Check for Subtraction Rule:**
    - **`if i < len(s) - 1 and roman_dict[s[i]] < roman_dict[s[i + 1]]:`**: This line checks if the current numeral is smaller than the next numeral. If true, it means that the subtraction rule applies.
6. **Subtract or Add Values:**
    - **`result -= roman_dict[s[i]]`**: If the condition is true, subtract the current numeral's value from the result.
    - **`else: result += roman_dict[s[i]]`**: If the condition is false, add the current numeral's value to the result.
7. **Return Result:**
    - **`return result`**: After the loop completes, the function returns the final calculated integer value.
8. **Test the Function:**
    - **`roman_numeral = input("Enter a Roman numeral: ")`**: This line prompts the user to enter a Roman numeral.
    - **`integer_value = roman_to_int(roman_numeral.upper())`**: The function is called with the input Roman numeral (converted to uppercase for case-insensitivity), and the result is stored in **`integer_value`**.
    - **`print(f"The integer value of {roman_numeral} is: {integer_value}")`**: The program prints the final result.
    
    ## C++ code
    
    ```cpp
    #include <iostream>
    #include <unordered_map>
    
    int romanToInt(const std::string &s)
    {
        // Define a unordered_map mapping Roman numerals to their integer values
        std::unordered_map<char, int> romanMap{
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}};
    
        int result = 0; // Initialize the result variable to store the total integer value
    
        // Loop through the Roman numeral string from left to right
        for (int i = 0; i < s.length(); ++i)
        {
            // If the current numeral is smaller than the next numeral, subtract its value
            if (i < s.length() - 1 && romanMap[s[i]] < romanMap[s[i + 1]])
            {
                result -= romanMap[s[i]];
            }
            else
            {
                result += romanMap[s[i]];
            }
        }
    
        return result;
    }
    
    int main()
    {
        // Test the function
        std::string romanNumeral;
        std::cout << "Enter a Roman numeral: ";
        std::cin >> romanNumeral;
    
        int integerValue = romanToInt(romanNumeral);
        std::cout << "The integer value of " << romanNumeral << " is: " << integerValue << std::endl;
    
        return 0;
    }
    ```
    
    ### Step-by-Step explaination
    
    1. **Include Headers:**
        - **`#include <iostream>`**: This line includes the input/output stream library, which is needed for input and output operations.
        - **`#include <unordered_map>`**: This line includes the unordered map library, which is used to define the mapping of Roman numerals to integers.
    2. **Function Definition:**
        - **`int romanToInt(const std::string &s)`**: This line defines a function named **`romanToInt`** that takes a constant reference to a string **`s`** as its parameter and returns an integer.
    3. **Roman Numeral Dictionary:**
        - **`std::unordered_map<char, int> romanMap{ ... }`**: This line creates an unordered_map (**`romanMap`**) that maps Roman numeral characters to their corresponding integer values.
    4. **Initialization:**
        - **`int result = 0;`**: This line initializes a variable **`result`** to store the total integer value, starting with 0.
    5. **Loop through the Roman Numeral String:**
        - **`for (int i = 0; i < s.length(); ++i)`**: This line starts a loop that iterates through each character in the input Roman numeral string.
    6. **Check for Subtraction Rule:**
        - **`if (i < s.length() - 1 && romanMap[s[i]] < romanMap[s[i + 1]])`**: This line checks if the current numeral is smaller than the next numeral. If true, it means that the subtraction rule applies.
    7. **Subtract or Add Values:**
        - **`result -= romanMap[s[i]];`**: If the condition is true, subtract the current numeral's value from the result.
        - **`else: result += romanMap[s[i]];`**: If the condition is false, add the current numeral's value to the result.
    8. **User Input and Function Call:**
        - **`std::string romanNumeral;`**: This line declares a string variable to store the user's input.
        - **`std::cout << "Enter a Roman numeral: ";`**: This line prints a prompt asking the user to enter a Roman numeral.
        - **`std::cin >> romanNumeral;`**: This line takes user input and stores it in the **`romanNumeral`** variable.
        - **`int integerValue = romanToInt(romanNumeral);`**: The **`romanToInt`** function is called with the input Roman numeral, and the result is stored in the **`integerValue`** variable.
        
        ## Java code
        
        ```java
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;
        
        public class romantoint {
        
            public static int romanToInt(String s) {
                // Define a map mapping Roman numerals to their integer values
                Map<Character, Integer> romanMap = new HashMap<>();
                romanMap.put('I', 1);
                romanMap.put('V', 5);
                romanMap.put('X', 10);
                romanMap.put('L', 50);
                romanMap.put('C', 100);
                romanMap.put('D', 500);
                romanMap.put('M', 1000);
        
                int result = 0; // Initialize the result variable to store the total integer value
        
                // Loop through the Roman numeral string from left to right
                for (int i = 0; i < s.length(); i++) {
                    // If the current numeral is smaller than the next numeral, subtract its value
                    if (i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                        result -= romanMap.get(s.charAt(i));
                    } else {
                        result += romanMap.get(s.charAt(i));
                    }
                }
        
                return result;
            }
        
            public static void main(String[] args) {
                try (// Test the function
                        Scanner scanner = new Scanner(System.in)) {
                    System.out.print("Enter a Roman numeral: ");
                    String romanNumeral = scanner.nextLine();
        
                    int integerValue = romanToInt(romanNumeral.toUpperCase());
                    System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);
                }
            }
        }
        ```
        
        ### Step-by-Step explaination
        
        1. **Import Statements:**
            - **`import java.util.HashMap;`**: Import the **`HashMap`** class from the **`java.util`** package for creating a map.
            - **`import java.util.Map;`**: Import the **`Map`** interface for working with maps.
            - **`import java.util.Scanner;`**: Import the **`Scanner`** class for taking user input.
        2. **Class Declaration:**
            - **`public class romantoint { ... }`**: Define a class named **`romantoint`**.
        3. **Function Definition:**
            - **`public static int romanToInt(String s) { ... }`**: Define a function named **`romanToInt`** that takes a string **`s`** as a parameter and returns an integer.
        4. **Roman Numeral Map:**
            - **`Map<Character, Integer> romanMap = new HashMap<>();`**: Create a map (**`romanMap`**) mapping Roman numeral characters to their corresponding integer values.
        5. **Initialization:**
            - **`int result = 0;`**: Initialize a variable **`result`** to store the total integer value, starting with 0.
        6. **Loop through the Roman Numeral String:**
            - **`for (int i = 0; i < s.length(); i++) { ... }`**: Loop through each character in the input Roman numeral string.
        7. **Check for Subtraction Rule:**
            - **`if (i < s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) { ... }`**: Check if the current numeral is smaller than the next numeral. If true, it means that the subtraction rule applies.
        8. **Subtract or Add Values:**
            - **`result -= romanMap.get(s.charAt(i));`**: If the condition is true, subtract the current numeral's value from the result.
            - **`else: result += romanMap.get(s.charAt(i));`**: If the condition is false, add the current numeral's value to the result.
        9. **Return Result:**
            - **`return result;`**: After the loop completes, the function returns the final calculated integer value.
        10. **Main Method:**
        - **`public static void main(String[] args) { ... }`**: Define the main method, the entry point of the program.
        1. **Try-with-Resources and User Input:**
            - **`try (Scanner scanner = new Scanner(System.in)) { ... }`**: Use try-with-resources to automatically close the **`Scanner`** after it is used.
            - **`System.out.print("Enter a Roman numeral: ");`**: Print a prompt asking the user to enter a Roman numeral.
            - **`String romanNumeral = scanner.nextLine();`**: Take user input and store it in the **`romanNumeral`** variable.
        2. **Function Call and Result Output:**
            - **`int integerValue = romanToInt(romanNumeral.toUpperCase());`**: Call the **`romanToInt`** function with the input Roman numeral (converted to uppercase for consistency).
            - **`System.out.println("The integer value of " + romanNumeral + " is: " + integerValue);`**: Print the final result.
            
            ## **Time and Space Complexity Analysis**
            
            ### **Python Code:**
            
            **Time Complexity:**
            
            - The time complexity of the code is O(n), where n is the length of the input Roman numeral string. The algorithm iterates through the string once.
            
            **Space Complexity:**
            
            - The space complexity is O(1). The additional space used is constant regardless of the input size, as there is no dynamic data structure that grows with the input.
            
            ### **C++ Code:**
            
            **Time Complexity:**
            
            - Similar to the Python code, the time complexity is O(n), where n is the length of the input Roman numeral string. The algorithm iterates through the string once.
            
            **Space Complexity:**
            
            - The space complexity is O(1), as it uses a fixed amount of space for the result variable and the loop index. The **`std::unordered_map`** used for mapping Roman numerals to integers has a constant number of entries.
            
            ### **Java Code:**
            
            **Time Complexity:**
            
            - Again, the time complexity is O(n), where n is the length of the input Roman numeral string. The algorithm iterates through the string once.
            
            **Space Complexity:**
            
            - Similar to the other implementations, the space complexity is O(1). The space used is constant, except for the map (**`HashMap`**), which has a constant number of entries.
            
            The time complexity for all implementations is O(n), and the space complexity is O(1) because the additional space used is constant and does not depend on the input size. The key factor contributing to the linear time complexity is the single loop that iterates through the input Roman numeral string. The space complexity remains constant because the additional memory used is fixed, regardless of the size of the input.
            
            ## Real world Applications
            
            While the Roman to integer algorithm may not have direct real-life applications for general end-users, it plays a role in software development and certain specialized areas. Here are a few scenarios where the Roman to integer algorithm might be applied:
            
            1. **Historical Data Processing:**
                - In historical research or data analysis involving ancient documents or artifacts, Roman numerals might be used. Converting Roman numerals to integers can help researchers perform quantitative analyses or comparisons.
            2. **Library Cataloging Systems:**
                - Some library cataloging systems or databases might use Roman numerals for classification or organization. Converting Roman numerals to integers can facilitate sorting and searching algorithms.
            3. **Educational Software:**
                - Educational software or games that involve Roman numerals may use the algorithm to check the correctness of a user's input or to provide feedback on Roman numeral-related exercises.
            4. **Financial Systems:**
                - In financial applications, especially those dealing with historical financial records, Roman numerals might be encountered. Converting these numerals to integers can assist in performing financial calculations or analyses.
            5. **Legal Documents:**
                - Certain legal or official documents, especially those with a traditional or formal tone, may use Roman numerals for section numbering or other purposes. Converting them to integers can be helpful in automated document processing.
            6. **Parsing and Data Extraction:**
                - In text processing applications, the algorithm can be used to extract and convert Roman numerals from textual data. This could be useful in data parsing or natural language processing tasks.
            7. **Quiz and Game Applications:**
                - Educational quizzes, games, or trivia apps that involve questions related to Roman numerals may use the algorithm to validate user responses.
            8. **Symbolic Representations in Software Development:**
                - In certain programming contexts, Roman numerals might be used symbolically, and the algorithm could be employed for internal data processing within the software.
            
            While the direct application of the Roman to integer algorithm might be limited in day-to-day activities, it serves as a foundational component in various software-related tasks, historical research, and specific academic or niche areas where Roman numerals are still relevant.