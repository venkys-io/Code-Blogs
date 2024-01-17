# **Exploring String Algorithms : Shuffle String**

Dive into the realm of particular emphasis on uncovering the shuffle string problem through the utilization of string algorithm. This intriguing challenge not only captivates but also offers a practical avenue to delve into the intricacies of data structures and foster algorithmic thinking.

# Introduction to String Algorithms

String algorithms, a versatile toolkit for tackling an array of computational challenges. String algorithms, designed for the manipulation and analysis of sequences of characters, are essential in addressing a wide spectrum of problems in computer science. Within this domain, string algorithms prove instrumental in tasks such as pattern matching, substring search, and the optimization of various string-related operations.

As we explore, we'll know much about fundamental string algorithms, examining techniques like string matching, regular expressions, and dynamic programming. Join this journey into the heart of string manipulation, where the algorithms we encounter will become indispensable tools for deciphering, analyzing, and extracting valuable information from the world of characters and text.

One of the case in string algorithms is Shuffle String.

## Shuffle String

Shuffling a string based on a given set of indices is a common algorithmic task. This process involves rearranging the characters of a string according to a specified order provided by a list of indices.The algorithm efficiently shuffles the characters of a string according to the specified indices, providing a versatile solution for scenarios where a custom order of characters is required. It is a linear-time algorithm, making it suitable for practical use cases with moderate-sized strings.

## Python Code

```python
# Define a function named shuffle_string that takes a string and a list of indices as input
def shuffle_string(string, indices):
    # Get the length of the input string
    n = len(string)
    
    # Create a list of n empty spaces
    result = [" "] * n
    
    # Iterate through the indices and assign characters from the input string to the corresponding positions
    for index in range(n):
        result[indices[index]] = string[index]
    
    # Convert the list of characters back to a string and return the result
    return "".join(result)

# Check if the script is being run as the main program
if __name__ == "__main__":
    # Prompt the user to enter a custom string
    custom_string = input("Enter the string: ")
    
    # Prompt the user to enter a list of indices separated by space, convert them to integers, and store in a list
    custom_indices = list(map(int, input("Enter the indices separated by space: ").split()))
    
    # Prompt the user to enter the expected output after shuffling the string
    expected_output = input("Enter the expected output: ")

    # Call the shuffle_string function with the custom string and indices
    custom_output = shuffle_string(custom_string, custom_indices)
    
    # Print the result of the custom example
    print("Custom Example Result:", custom_output)

    # Check if the custom output matches the expected output and provide feedback
    if custom_output == expected_output:
        print("Test case passed.")
    else:
        print("Test case failed.")

# Enter the string: hello
# Enter the indices separated by space: 4 1 3 2 0
# Enter the expected output: oellh
# Custom Example Result: oellh
# Test case passed.
```

### Step-by-Step Explanation

1. **Function Definition (`shuffle_string`):**
    - `shuffle_string` is a function that takes two parameters: `string` (the input string) and `indices` (a list of indices).
    - It creates a list called `result` initialized with spaces, with the same length as the input string.
    - It then iterates over the indices and assigns each character from the input string to the corresponding position in the `result` list.
    - Finally, it joins the characters in the `result` list into a single string and returns that string.
    
        i. **Initialization of `result`:**
    
    ```python
    pythonCopy code
    result = [" "] * n
    ```
    
    - This line creates a list **`result`** containing **`n`** elements, each initialized with a space character (**`" "`**).
    
        ii. **Loop over Indices:**
    
    ```python
    pythonCopy code
    for index in range(n):
    ```
    
    - This line starts a **`for`** loop that iterates over the range of **`n`** (the length of the input string or indices list).
    
        iii. **Assign Characters to Result List:**
    
    ```python
    pythonCopy code
    result[indices[index]] = string[index]
    ```
    
    - Inside the loop, for each **`index`**, it assigns the character at the corresponding position in the **`string`** to the **`result`** list at the index specified by **`indices[index]`**.
    - In other words, it shuffles the characters in the **`string`** to positions determined by the values in the **`indices`** list.
    
        iv. **Join Result List into a String:**
    
    ```python
    pythonCopy code
    return "".join(result)
    ```
    
    - After the loop completes, the function joins the characters in the **`result`** list into a single string.
    - The **`"".join(result)`** expression concatenates all the characters in the **`result`** list without any separator, producing the final shuffled string.
2. **Main Section (`if name == "main":):**
    - This block checks if the script is being run directly (not imported as a module).
3. **User Input for Custom Example:**
    - It prompts the user to enter the input string and indices separated by spaces. The indices are converted to integers using `map` and `int`, and then converted to a list.
4. **Expected Output Input:**
    - It prompts the user to enter the expected output for the custom example.
5. **Test the Custom Example:**
    - It calls the `shuffle_string` function with the custom input and prints the result.
6. **Comparison and Printing Results:**
    - It compares the actual output (`custom_output`) with the expected output. If they match, it prints "test case passed"; otherwise, it prints "test case failed."

## C++ Code

```cpp
#include <iostream>
#include <sstream>
#include <vector>

// Function to shuffle the characters of a string based on provided indices
std::string shufflestring(const std::string& str, const std::vector<int>& indices)
{
    int n = str.length();
    std::string result(n, ' '); // Initialize the result string with spaces

    // Iterate through the indices and assign characters from the input string to
    // the corresponding positions
    for (int index = 0; index < n; ++index)
    {
        result[indices[index]] = str[index];
    }

    return result;
}

int main()
{
    // Custom Example
    std::cout << "Enter the string: ";
    std::string customString;
    std::getline(std::cin, customString);

    std::cout << "Enter the indices separated by space: ";
    std::string indicesInput;
    std::getline(std::cin, indicesInput);

    std::istringstream iss(indicesInput);
    std::vector<int> customIndices;

    // Convert the space-separated string of indices to a vector of integers
    int index;
    while (iss >> index)
    {
        customIndices.push_back(index);
    }

    std::cout << "Enter the expected output: ";
    std::string expectedOutput;
    std::getline(std::cin, expectedOutput);

    // Call the shuffleString function with the custom string and indices
    std::string customOutput = shufflestring(customString, customIndices);
    std::cout << "Custom Example Result: " << customOutput << std::endl;

    // Check if the custom output matches the expected output and provide feedback
    if (customOutput == expectedOutput)
    {
        std::cout << "Test case passed." << std::endl;
    }
    else
    {
        std::cout << "Test case failed." << std::endl;
    }

    return 0;
}

// Enter the string: hello
// Enter the indices separated by space: 4 1 3 2 0
// Enter the expected output: oellh
// Custom Example Result: oellh
// Test case passed.
```

### Step-by-Step Explaination

1. **Header Includes:**
    - This includes the necessary C++ standard library headers for input/output and vector usage.
2. **Function Definition (`shuffleString`):**
    
    ```cpp
    std::string shufflestring(const std::string& str, const std::vector<int>& indices) {
    ```
    
    - This declares a function named `shufflestring` that takes a constant reference to a string (`str`) and a constant reference to a vector of integers (`indices`).
    - The function returns a string.
3. **Variable Declarations:**
    
    ```cpp
        int n = str.length();
        std::vector<char> result(n, ' ');
    ```
    
    - `n` stores the length of the input string.
    - `result` is a vector of characters initialized with `n` spaces.
4. **Loop Over Indices:**
    
    ```cpp
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str[index];
        }
    ```
    
    - This loop iterates over each index in the range [0, n).
    - For each index, it assigns the character at the corresponding position in the `str` to the `result` vector at the index specified by `indices[index]`.
    - Essentially, it shuffles the characters in the `str` to positions determined by the values in the `indices` vector.
5. **Return Shuffled String:**
    
    ```cpp
        return result;
    ```
    
    - After the loop completes, the function returns a string created from the characters in the `result` vector using iterators.

In the `main` function: 

```cpp
int main()
{
    std::cout << "Enter the string: ";
    std::string customString;
    std::getline(std::cin, customString);
```

 i. **User Input - String:**

- The program prompts the user to enter a string.
- **`std::getline(std::cin, customString);`** reads the entire line of user input (including spaces) and stores it in the **`customString`** variable.

```cpp
    std::cout << "Enter the indices separated by space: ";
    std::string indicesInput;
    std::getline(std::cin, indicesInput);
```

  ii. **User Input - Indices:**

- The program prompts the user to enter indices separated by space.
- **`std::getline(std::cin, indicesInput);`** reads the entire line of user input (including spaces) and stores it in the **`indicesInput`** variable.

```cpp
    std::istringstream iss(indicesInput);
    std::vector<int> customIndices;
```

  iii. **String to Vector of Integers Conversion:**

- An **`std::istringstream`** named **`iss`** is created using the input string **`indicesInput`**. This allows us to treat the string as an input stream for easy parsing.
- An empty vector of integers named **`customIndices`** is declared to store the converted indices.

```cpp
        int index;
    while (iss >> index)
    {
        customIndices.push_back(index);
    }
```

   iv. **Parsing and Storing Indices:**

- A **`while`** loop is used to parse the space-separated string of indices using the **`>>`** extraction operator from the **`iss`** stream.
- Each parsed integer is added to the **`customIndices`** vector using **`push_back`**.

    v. **Expected Output Input:**

```cpp
std::cout << "Enter the expected output: ";
std::string expectedOutput;
std::getline(std::cin, expectedOutput);
```

- Prompt the user to enter the expected output for the custom example.

    vi. **Test the Custom Example:**

```cpp
std::string customOutput = shuffleString(customString, customIndices);
std::cout << "Custom Example Result: " << customOutput << std::endl;
```

- Call the `shuffleString` function with the custom input and print the result.

    vii. **Comparison and Printing Results:**

```cpp
if (customOutput == expectedOutput) {
    std::cout << "Test case passed." << std::endl;
} else {
    std::cout << "Test case failed." << std::endl;
}
```

- Compare the actual output (`customOutput`) with the expected output. Print whether the test case passed or failed.

## Java Code

```java
import java.util.Scanner;

public class shufflestring {

    // Function to shuffle the characters of a string based on provided indices
    public static String shuffleString(String str, int[] indices) {
        int n = str.length();
        char[] result = new char[n];

        // Iterate through the indices and assign characters from the input string to
        // the corresponding positions
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str.charAt(index);
        }

        // Convert the character array back to a string and return the result
        return new String(result);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Custom Example
            System.out.print("Enter the string: ");
            String customString = scanner.nextLine();

            System.out.print("Enter the indices separated by space: ");
            String[] indicesInput = scanner.nextLine().split(" ");
            int[] customIndices = new int[indicesInput.length];

            // Convert the array of strings to an array of integers
            for (int i = 0; i < indicesInput.length; i++) {
                customIndices[i] = Integer.parseInt(indicesInput[i]);
            }

            System.out.print("Enter the expected output: ");
            String expectedOutput = scanner.nextLine();

            // Call the shuffleString function with the custom string and indices
            String customOutput = shuffleString(customString, customIndices);
            System.out.println("Custom Example Result: " + customOutput);

            // Check if the custom output matches the expected output and provide feedback
            if (customOutput.equals(expectedOutput)) {
                System.out.println("Test case passed.");
            } else {
                System.out.println("Test case failed.");
            }
        } catch (NumberFormatException e) {
            // Handle NumberFormatException if the user enters non-integer values for
            // indices
            e.printStackTrace();
        }
    }
}

// Enter the string: hello
// Enter the indices separated by space: 4 1 3 2 0
// Enter the expected output: oellh
// Custom Example Result: oellh
// Test case passed.
```

### Step-by-Step Explaination

1. **Importing Libraries:**
    - This line imports the **`Scanner`** class from the **`java.util`** package, which is used for user input.
2. **Class Declaration:**
    
    ```java
    javaCopy code
    public class shufflestring {
    ```
    
    - This declares a class named **`ShuffleString`**.
3. **Function Definition (`shuffleString`):**
    
    ```java
    javaCopy code
    public static String shuffleString(String str, int[] indices) {
        int n = str.length();
        char[] result = new char[n];
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str.charAt(index);
        }
        return new String(result);
    }
    ```
    
    - This defines a static method **`shuffleString`** that takes a string **`str`** and an array of integers **`indices`** as parameters.
    - It returns a string.
    - Inside the function, it initializes a character array **`result`** of length **`n`** and iterates over the indices, rearranging characters based on the provided indices.
4. **Main Method:**
    
    ```python
       public static void main(String[] args)
    ```
    
    - This is the main method where the program execution starts.
5. **User Input for Custom Example:**
    
    ```java
    javaCopy code
        Scanner scanner = new Scanner(System.in);
    
        // Custom Example
        System.out.print("Enter the string: ");
        String customString = scanner.nextLine();
    
        System.out.print("Enter the indices separated by space: ");
        String[] indicesInput = scanner.nextLine().split(" ");
        int[] customIndices = new int[indicesInput.length];
        for (int i = 0; i < indicesInput.length; i++) {
            customIndices[i] = Integer.parseInt(indicesInput[i]);
        }
    ```
    
    - It creates a **`Scanner`** object for reading user input.
    - It prompts the user to enter the string and indices separated by space.
    - It then splits the entered indices into an array of strings and converts them to integers using a loop.
6. **Expected Output Input:**
    
    ```java
    javaCopy code
        System.out.print("Enter the expected output: ");
        String expectedOutput = scanner.nextLine();
    ```
    
    - It prompts the user to enter the expected output for the custom example.
7. **Test the Custom Example:**
    
    ```java
    javaCopy code
        String customOutput = shuffleString(customString, customIndices);
        System.out.println("Custom Example Result: " + customOutput);
    ```
    
    - It calls the **`shuffleString`** function with the custom input and prints the result.
8. **Comparison and Printing Results:**
    
    ```java
    javaCopy code
        // Test the custom example against the expected output
        if (customOutput.equals(expectedOutput)) {
            System.out.println("Test case passed.");
        } else {
            System.out.println("Test case failed.");
        }
    ```
    
    - It compares the actual output (**`customOutput`**) with the expected output. If they match, it prints "Test case passed"; otherwise, it prints "Test case failed."
9. **Closing Scanner and Class Closing Brace:**
    - It's good practice to close the **`Scanner`** to prevent resource leaks.
    - The closing brace **`}`** marks the end of the class.
    
    ## Time and Space Complexity Analysis
    
    ### Time Complexity :
    
    - The primary operation inside the function is the loop that iterates over the length of the input string, which is **`n`**.
    - The loop has a constant time operation inside it (assignment and character retrieval).
    - Therefore, the time complexity of the code is O(n), where 'n' is the length of the input string.
    
    ### Space Complexity :
    
    - The space complexity is determined by the additional space used by the algorithm.
    - The primary data structure consuming space is the **`result`** array of characters, which has a length of 'n' (the length of the input string).
    - Additionally, there are constant space requirements for variables like **`index`**.
    - Therefore, the space complexity is O(n), where 'n' is the length of the input string.
    
    ## Real world Applications
    
    The code shuffle string shuffles a string based on given indices. While the specific use case may seem simplistic, this type of operation is foundational in various real-world applications. Here are a few examples:
    
    1. **Encryption Algorithms:**
        - Shuffling characters based on a specific pattern or key is a fundamental operation in some encryption algorithms. For example, a simple substitution cipher may involve rearranging characters in a string according to a predefined rule.
    2. **Data Security:**
        - In security-related applications, shuffling data can be part of obfuscation techniques. It makes it more difficult for unauthorized users to understand the structure or patterns in the data, adding a layer of security.
    3. **Data Transmission:**
        - In communication protocols, especially error-correction and channel coding, shuffling bits or symbols can help in ensuring that errors are spread out and not concentrated in one area. This aids in the recovery of corrupted data.
    4. **Password Hashing:**
        - Password hashing algorithms often involve shuffling characters or bits to generate a unique hash for a given password. This adds complexity to the hashing process and enhances security.
    5. **Randomization in Games:**
        - Shuffling elements is a common operation in games, especially card games. The provided code could be adapted to shuffle a deck of cards in a card game simulation.
    6. **Image Processing:**
        - In image processing, shuffling pixel values based on certain criteria can be used for various effects or transformations. This could include scrambling parts of an image for privacy or generating artistic effects.
    7. **Genetic Algorithms:**
        - Genetic algorithms involve evolving solutions based on the principles of natural selection. Shuffling genetic information (chromosomes) is a common operation to introduce diversity in the population and explore different solutions.
    8. **Cryptographic Applications:**
        - Shuffling bits or bytes is used in some cryptographic techniques, such as in the creation of pseudorandom numbers or in stream ciphers.
    9. **Network Routing:**
        - In networking, shuffling can be used in certain routing algorithms to distribute traffic across different paths, optimizing the usage of network resources.
    10. **Code Obfuscation:**
        - Shuffling code instructions or altering the order of statements can be a form of code obfuscation, making it more challenging for reverse engineers to understand the logic of a program.