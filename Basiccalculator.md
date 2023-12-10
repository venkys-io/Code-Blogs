# Basic Calculator

# Introduction:

This basic calculator program provides a foundation for more advanced calculator applications, which may include additional features, a graphical user interface (GUI), and error handling for a wider range of scenarios.

This basic calculator program allows the user to perform addition, subtraction, multiplication, and division operations on two numbers. It includes input validation to handle division by zero and provides a simple user interface for continuous calculations until the user decides to exit.

# Program in `cpp`:

```python
#include <iostream>
```

```python
using namespace std;
```

```python
// Function to add two numbers
double add(double x, double y) {
return x + y;
}
```

```python
// Function to subtract two numbers
double subtract(double x, double y) {
return x - y;
}
```

```python
// Function to multiply two numbers
double multiply(double x, double y) {
return x * y;
}
```

```python
// Function to divide two numbers
double divide(double x, double y) {
if (y != 0) {
return x / y;
} else {
cout << "Error: Cannot divide by zero!" << endl;
return 0;  // You can customize the return value for division by zero
}
}
```

```python
int main() {
char operation;
double num1, num2, result;
```

```
cout << "Enter operator (+, -, *, /): ";
cin >> operation;

cout << "Enter first number: ";
cin >> num1;

cout << "Enter second number: ";
cin >> num2;

switch (operation) {
    case '+':
        result = add(num1, num2);
        break;
    case '-':
        result = subtract(num1, num2);
        break;
    case '*':
        result = multiply(num1, num2);
        break;
    case '/':
        result = divide(num1, num2);
        break;
    default:
        cout << "Error: Invalid operator" << endl;
        return 1;  // Exit program with an error code
}

cout << "Result: " << result << endl;

return 0;

```

```python
}
```

## Step-By-Step Explanation in:

1. **Header and Namespace:**
    - `#include <iostream>`: Includes the necessary header file for input and output operations.
    - `using namespace std;`: Avoids the need to use `std::` before standard C++ identifiers.
2. **Function Declarations:**
    - Four functions (`add`, `subtract`, `multiply`, and `divide`) are declared to perform basic arithmetic operations.
3. **Function Definitions:**
    - Each function is defined to implement the corresponding arithmetic operation.
4. **Main Function:**
    - `main()`: The entry point of the program.
5. **User Input:**
    - Prompts the user to enter the operator, the first number, and the second number.
6. **Switch Statement:**
    - Uses a switch statement to determine the operation to be performed based on the entered operator.
7. **Perform Calculation:**
    - Calls the appropriate function to perform the calculation.
8. **Error Handling:**
    - Checks for invalid operators and displays an error message.
9. **Display Result:**
    - Outputs the result of the calculation.
10. **Exit Program:**
- Returns 0 to indicate successful program execution.

# Program in `python`:

```python
# Basic Calculator Program

def add(x, y):
    """Addition function"""
    return x + y

def subtract(x, y):
    """Subtraction function"""
    return x - y

def multiply(x, y):
    """Multiplication function"""
    return x * y

def divide(x, y):
    """Division function"""
    if y != 0:
        return x / y
    else:
        return "Cannot divide by zero!"

# Main program loop
while True:
    # User input
    num1 = float(input("Enter first number: "))
    operator = input("Enter operator (+, -, *, /): ")
    num2 = float(input("Enter second number: "))

    # Perform calculation based on the operator
    if operator == '+':
        result = add(num1, num2)
    elif operator == '-':
        result = subtract(num1, num2)
    elif operator == '*':
        result = multiply(num1, num2)
    elif operator == '/':
        result = divide(num1, num2)
    else:
        result = "Invalid operator"

    # Display the result
    print(f"Result: {result}")

    # Ask if the user wants to perform another calculation
    another_calculation = input("Do you want to perform another calculation? (yes/no): ").lower()
    if another_calculation != 'yes':
        break

print("Calculator program terminated.")

```

This basic calculator program allows the user to perform addition, subtraction, multiplication, and division operations on two numbers. It includes input validation to handle division by zero and provides a simple user interface for continuous calculations until the user decides to exit.

## Step-By-Step Explanation:

1. **User Input:**
    - The program starts by taking input from the user. In this case, it prompts the user to enter two numbers and an operator (addition, subtraction, multiplication, or division).
    
    ```python
    num1 = float(input("Enter first number: "))
    operator = input("Enter operator (+, -, *, /): ")
    num2 = float(input("Enter second number: "))
    
    ```
    
2. **Functions for Operations:**
    - The program defines functions for basic arithmetic operations: addition, subtraction, multiplication, and division.
    
    ```python
    def add(x, y):
        return x + y
    
    def subtract(x, y):
        return x - y
    
    def multiply(x, y):
        return x * y
    
    def divide(x, y):
        if y != 0:
            return x / y
        else:
            return "Cannot divide by zero!"
    
    ```
    
3. **Calculation:**
    - Based on the user's input, the program performs the corresponding calculation using the defined functions.
    
    ```python
    if operator == '+':
        result = add(num1, num2)
    elif operator == '-':
        result = subtract(num1, num2)
    elif operator == '*':
        result = multiply(num1, num2)
    elif operator == '/':
        result = divide(num1, num2)
    else:
        result = "Invalid operator"
    
    ```
    
4. **Display Result:**
    - The program then displays the result of the calculation.
    
    ```python
    print(f"Result: {result}")
    
    ```
    
5. **User Interaction Loop:**
    - The program uses a loop to allow the user to perform multiple calculations without restarting the program.
    
    ```python
    while True:
        # ...
        # Code for calculation and result display
        # ...
        another_calculation = input("Do you want to perform another calculation? (yes/no): ").lower()
        if another_calculation != 'yes':
            break
    
    ```
    
6. **Error Handling:**
    - The division function includes a simple error check to prevent division by zero.
    
    ```python
    def divide(x, y):
        if y != 0:
            return x / y
        else:
            return "Cannot divide by zero!"
    
    ```
    
7. **Termination:**
    - The program terminates when the user chooses not to perform another calculation.
    
    ```python
    print("Calculator program terminated.")
    
    ```
    

# Program in `java`:

```java
import java.util.Scanner;

public class BasicCalculator {

    // Function to add two numbers
    public static double add(double x, double y) {
        return x + y;
    }

    // Function to subtract two numbers
    public static double subtract(double x, double y) {
        return x - y;
    }

    // Function to multiply two numbers
    public static double multiply(double x, double y) {
        return x * y;
    }

    // Function to divide two numbers
    public static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Error: Cannot divide by zero!");
            return 0;  // You can customize the return value for division by zero
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt the user for the operator
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        // Step 2: Prompt the user for the first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Step 3: Prompt the user for the second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;

        // Step 4: Perform the selected operation using a switch statement
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                result = divide(num1, num2);
                break;
            default:
                // Step 5: Handle invalid operator
                System.out.println("Error: Invalid operator");
                return;  // Exit program
        }

        // Step 6: Display the result
        System.out.println("Result: " + result);

        // Step 7: Close the scanner
        scanner.close();
    }
}

```

# **Step-by-step explanation:**

1. **Import Statement:**
    - `import java.util.Scanner;`: Imports the `Scanner` class for user input.
2. **Function Declarations:**
    - Four functions (`add`, `subtract`, `multiply`, and `divide`) are declared to perform basic arithmetic operations.
3. **Main Method:**
    - `public static void main(String[] args)`: The entry point of the program.
4. **Scanner Initialization:**
    - `Scanner scanner = new Scanner(System.in);`: Creates a `Scanner` object to read user input.
5. **User Input:**
    - Prompts the user to enter the operator, the first number, and the second number.
6. **Switch Statement:**
    - Uses a switch statement to determine the operation to be performed based on the entered operator.
7. **Perform Calculation:**
    - Calls the appropriate function to perform the calculation.
8. **Error Handling:**
    - Checks for invalid operators and displays an error message.
9. **Display Result:**
    - Outputs the result of the calculation.
10. **Close Scanner:**
    - `scanner.close();`: Closes the scanner to prevent resource leaks.

This Java program provides a basic structure for a console-based calculator, allowing the user to perform simple arithmetic calculations.

# Time and Space Complexities:

### C++:

**Time Complexity:**

- The time complexity of this basic calculator program is primarily determined by the arithmetic operations. These operations generally have constant time complexity.
- In this case, the arithmetic operations (add, subtract, multiply, divide) are simple and can be considered O(1) or constant time.

**Space Complexity:**

- The space complexity is also minimal. It mainly involves the storage of variables, input values, and a few function calls.
- The space complexity is O(1), as it doesn't depend on the input size but rather on the fixed number of variables used.

### Python:

**Time Complexity:**

- Similar to C++, the arithmetic operations have constant time complexity.
- Python's arithmetic operations also have constant time complexity, and their implementation is optimized for efficiency.

**Space Complexity:**

- Python may have a slightly higher space complexity due to its dynamic typing and additional memory required for managing objects.
- The space complexity is still relatively low and can be considered O(1) for the basic calculator program.

### Java:

**Time Complexity:**

- Like C++ and Python, the time complexity is primarily determined by the arithmetic operations, which have constant time complexity.

**Space Complexity:**

- Java, being a compiled language, has a bit more overhead than Python or C++. It involves managing objects and additional memory for the Java Virtual Machine (JVM).
- The space complexity is still low and considered O(1) for the basic calculator program.

In summary, the time complexity is primarily determined by the arithmetic operations, all of which have constant time complexity. The space complexity is minimal, with O(1) being a reasonable approximation for the basic calculator programs in C++, Python, and Java.
