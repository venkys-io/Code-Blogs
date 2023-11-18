# Arithmetic operations:

In Java, arithmetic operations are operations that involve mathematical calculations. Here are the basic arithmetic operations:

1.**Addition (+):**

           int sum = a + b;

2.**Subtraction (-):**

          int difference = a - b;

3.**Multiplication (*):**

          int product = a * b;

4.**Division (/):**

         int quotient = a / b;

Note: If a and b are integers and you want to get a floating-point result, you might want to use double or float variables.

5.**Modulus (%):**

        int remainder = a % b;

The modulus operation gives the remainder when a is divided by b.

## Two number sum using java:

### code:

```java
import java.util.Scanner;
public class TwoNumberSum{
public static void main(String[]args){
Scanner scanner =new Scanner(System.in);
    System.out.print("Enter the first number: ");
    int num1 = scanner.nextInt();
    System.out.print("Enter the second number: ");
    int num2 = scanner.nextInt();
    scanner.close();
    int sum = num1 + num2;
    System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
  }
}
```

# Step By Step Explanation:

1. I**mport the Scanner Class:**

 javaCopy code
import java.util.Scanner;

Import the scanner class from the java.util package. This class is used for reading input from the console.

1. **Define the Class:**
    
     javaCopy code
    public class TwoNumberSum {
    
    Define a class named TwoNumberSum. This class will contain the main method where the execution of the program begins.
    
2. **Main Method:**
    
    javaCopy code
    public static void main(String[] args) {
    
    Declare the main method. In Java, the execution of a program begins in the main method.
    
3. **Create a Scanner Object:**
    
    javaCopy code
    Scanner scanner = new Scanner([System.in](http://system.in/));
    
    Create a Scanner object named scanner to read input from the console.
    
4. **Prompt for First Number:**
    
    javaCopy code
    System.out.print("Enter the first number: ");
    
    Display a prompt asking the user to enter the first number.
    
5. **Read First Number:**
    
    javaCopy code
    int num1 = scanner.nextInt();
    
    Use the nextInt() method of the Scanner class to read an integer from the console and store it in the variable num1.
    
6. **Prompt for Second Number:**
    
    javaCopy code
    System.out.print("Enter the second number: ");
    
    Display a prompt asking the user to enter the second number.
    
7. **Read Second Number:**
    
    javaCopy code
    int num2 = scanner.nextInt();
    
    Use the nextInt() method again to read the second integer and store it in the variable num2.
    
8. **Close the Scanner:**
    
    javaCopy code
    scanner.close();
    
    Close the Scanner object to avoid resource leaks.
    
9. **Calculate Sum:**
    
    javaCopy code
    int sum = num1 + num2;
    
    Use the addition operator (+) to calculate the sum of num1 and num2 and store the result in the variable sum.
    
10. **Print Result:**
    
    javaCopy code
    System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
    
    Print the result, displaying the sum of the two numbers along with the original numbers.
    

When you run this program, it will interactively ask the user to input two numbers, calculate their sum, and then print the result.

# 

## Two number sum using Python:

### code:

```python
# Take input from the user
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Calculate the sum
sum_result = num1 + num2

# Print the result
print(f"The sum of {num1} and {num2} is: {sum_result}")
```

# Step By Step Explanation:

1. **User Input:**

           num1 = float(input("Enter the first number: "))
           input(”Enter the First Number”)  prompts the user to enter a value, and float() converts the                    entered value to a floating-point number. The result is stored in the variable num1.
           num2 = float(input("Enter the second number: "))
Similarly, the program prompts the user to enter the second number, converts the input to a floating-point number, and stores it in the variable num2.

1. **Calculate the Sum:**
     sum_result = num1 + num2
The sum of num1 and num2 is calculated using the + operator, and the result is stored in the variable sum_result.
2. **Print the Result:**
    print(f"The sum of {num1} and {num2} is: {sum_result}")
The print() function is used to display the result. The f-string format is used to include the values of num1, num2, and sum_result in the printed message.

**Execution Flow:**

- The program starts by asking the user to input two numbers.
- It then converts these inputs to floating-point numbers using float().
- The sum of the two numbers is calculated using the + operator.
- Finally, the program prints the result, displaying the sum along with the original numbers.

## Two number sum using CPP:

### code:

```cpp
#include <iostream>

int main() {
    double num1, num2;

    std::cout << "Enter the first number: ";
    std::cin >> num1;
    std::cout << "Enter the second number: ";
    std::cin >> num2;
    double sum = num1 + num2;
    std::cout << "The sum of " << num1 << " and " << num2 << " is: " << sum << std::endl;

    return 0;
}
```

# Step By Step Explanation:

1. **Include Header File:**
    
    cppCopy code
    #include <iostream>
    
    this line includes the Input/Output Stream Library (iostream) for handling input and output operations.
    
2. **Declare Variables:**
    
    Declare two double-precision floating-point variables to store the numbers.
    
    cppCopy code
    double num1, num2;
    
3. **User Input:**
    
    Prompt the user to enter the first number and read the input using std::cin.
    
    cppCopy code
    std::cout << "Enter the first number: ";
    std::cin >> num1;
    
    Similarly, prompt for and read the second number.
    
    cppCopy code
    std::cout << "Enter the second number: ";
    std::cin >> num2;
    
4. **Calculate Sum:**
    
    Calculate the sum of the two numbers using the **`+`** operator and store the result in the variable sum.
    
    cppCopy code
    double sum = num1 + num2;
    
5. **Print Result:**
    
    Print the result using std::count.
    
    cppCopy code
    std::cout << "The sum of " << num1 << " and " << num2 << " is: " << sum << std::endl;
    

# Time And Space Complexity Analysis

### **Time Complexity:**

- Reading input using the Scanner class takes constant time (o(1)) for each input. The number of inputs (in this case, two numbers) doesn't affect the time complexity significantly
- The addition operation (+) to calculate the sum takes constant time (o(1)) because the size of the numbers does not affect the time it takes to add them.
- Printing the result using System.out.println is also a constant time operation (o(1)).

The overall time complexity of the "Two Number Sum" program is dominated by constant time operations, making it o(1).

### **Space Complexity:**

- The space complexity is mainly influenced by the Scanner object created to read input. The space required for the Scanner object is constant (o(1)).
- The space required for integer variables (num1, num2, and sum) is also constant (o(1). The space used by these variables does not depend on the input size.
- The space complexity for string concatenation (”the sum of”+num1+ “ and “+ num2+” is:” + sum) is also constant, as the length of the string is fixed and does not depend on the input size.

The overall space complexity of the "Two Number Sum" program is constant (o(1)).

In summary, both time and space complexity are constant for this program, making it efficient for any input size.

# Real-World Applications of Two Number Sum Using Java:

While a simple program to calculate the sum of two numbers may seem basic, the concept of adding two numbers is fundamental to a wide range of real-life applications, particularly in the field of software development. Here are some examples:

1. **Financial Calculations:**
    - In financial applications, the sum of two numbers can represent transactions, balances, or the total value of assets and liabilities. For instance, calculating the total value of a user's assets by summing up the values of their different holdings.
2. **Inventory Management:**
    - In inventory systems, the sum of two numbers might represent the total quantity of a particular product after receiving a new shipment. It's fundamental for managing stock levels.
3. **Budgeting Applications:**
    - Budgeting and expense tracking applications often involve calculating the sum of incomes and expenses to determine the overall financial health of an individual or a business.
4. **Gaming:**
    - In game development, adding two numbers is a basic operation that can be used in various scenarios. For example, it could be used to keep track of scores, calculate damage in combat scenarios, or determine the total points earned in a game.
5. **User Authentication:**
    - In some authentication systems, the sum of two numbers might be used as part of a hashing or encryption process to enhance the security of user credentials.
6. **Data Analysis:**
    - In data analysis and statistical applications, adding two numbers may be a part of aggregating data or calculating summary statistics.
7. **Telecommunications:**
    - In networking and telecommunications, the sum of two numbers might be used in calculations related to bandwidth, data transfer rates, or signal processing.
8. **Scientific Computing:**
    - In scientific simulations and calculations, adding two numbers can be a fundamental operation in various mathematical models and algorithms.
9. **Machine Learning:**
    - In machine learning, mathematical operations like addition are used extensively in the implementation of algorithms, neural networks, and optimization processes.
10. **Mobile App Development:**
    - In mobile applications, the sum of two numbers might be used in various contexts, such as calculating distances, processing user inputs, or determining display coordinates.
