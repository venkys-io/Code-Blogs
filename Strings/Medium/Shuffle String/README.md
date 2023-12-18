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
def shuffle_string(string, indices):
    n = len(string)
    result = [" "] * n
    for index in range(n):
        result[indices[index]] = string[index]
    return "".join(result)

if __name__ == "__main__":

    custom_string = input("Enter the string: ")
    custom_indices = list(map(int, input("Enter the indices separated by space: ").split()))

    expected_output = input("Enter the expected output: ")

    custom_output = shuffle_string(custom_string, custom_indices)
    print("Custom Example Result:", custom_output)

    if custom_output == expected_output:
        print("test case passed.")
    else:
        print("test case failed.")
```

### Step-by-Step Explaination

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
#include <vector>

std::string shuffleString(const std::string &str, const std::vector<int> &indices)
{
    int n = str.length();
    std::vector<char> result(n, ' ');

    for (int index = 0; index < n; ++index)
    {
        result[indices[index]] = str[index];
    }

    return std::string(result.begin(), result.end());
}

int main()
{
    std::string customString, expectedOutput;
    std::cout << "Enter the string: ";
    std::cin >> customString;

    std::cout << "Enter the indices separated by space: ";
    std::vector<int> customIndices;
    int index;
    while (std::cin >> index)
    {
        customIndices.push_back(index);
    }

    std::cin.clear(); // Clear the error state from cin

    std::cout << "Enter the expected output: ";
    std::cin >> expectedOutput;

    std::string customOutput = shuffleString(customString, customIndices);
    std::cout << "Custom Example Result: " << customOutput << std::endl;

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
```

### Step-by-Step Explaination

1. **Header Includes:**
    - This includes the necessary C++ standard library headers for input/output and vector usage.
2. **Function Definition (`shuffleString`):**
    
    ```cpp
    std::string shuffleString(const std::string& str, const std::vector<int>& indices) {
    ```
    
    - This declares a function named `shuffleString` that takes a constant reference to a string (`str`) and a constant reference to a vector of integers (`indices`).
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
        return std::string(result.begin(), result.end());
    ```
    
    - After the loop completes, the function returns a string created from the characters in the `result` vector using iterators.

In the `main` function:

    i. **Variable Declarations:**

```cpp
std::string customString, expectedOutput;
```

- Declare two strings to store the custom input string and the expected output.

    ii. **User Input for Custom Example:**

```cpp
std::cout << "Enter the string: ";
std::cin >> customString;

std::cout << "Enter the indices separated by space: ";
std::vector<int> customIndices;
int index;
while (std::cin >> index) {
    customIndices.push_back(index);
}
```

- Prompt the user to enter the input string and indices separated by spaces. Use a while loop to read indices until the user enters something other than an integer.

    iii. **Clearing Input Buffer:**

```cpp
std::cin.clear();  // Clear the error state from cin
```

- Clear the error state from `std::cin` to ensure proper input handling.

    iv. **Expected Output Input:**

```cpp
std::cout << "Enter the expected output: ";
std::cin >> expectedOutput;
```

- Prompt the user to enter the expected output for the custom example.

    v. **Test the Custom Example:**

```cpp
std::string customOutput = shuffleString(customString, customIndices);
std::cout << "Custom Example Result: " << customOutput << std::endl;
```

- Call the `shuffleString` function with the custom input and print the result.

    vi. **Comparison and Printing Results:**

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

    public static String shuffleString(String str, int[] indices) {
        int n = str.length();
        char[] result = new char[n];
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str.charAt(index);
        }
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
            for (int i = 0; i < indicesInput.length; i++) {
                customIndices[i] = Integer.parseInt(indicesInput[i]);
            }

            System.out.print("Enter the expected output: ");
            String expectedOutput = scanner.nextLine();

            String customOutput = shuffleString(customString, customIndices);
            System.out.println("Custom Example Result: " + customOutput);

            if (customOutput.equals(expectedOutput)) {
                System.out.println("Test case passed.");
            } else {
                System.out.println("Test case failed.");
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
```

### Step-by-Step Explaination

1. **Importing Libraries:**
    - This line imports the **`Scanner`** class from the **`java.util`** package, which is used for user input.
2. **Class Declaration:**
    
    ```java
    javaCopy code
    public class ShuffleString {
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