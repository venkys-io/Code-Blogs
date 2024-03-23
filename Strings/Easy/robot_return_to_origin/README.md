# **Exploring String Algorithms : Robot return to Origin**

Discover the realm of a particular emphasis on uncovering the robot return to origin problem through the utilization of string algorithm. This intriguing challenge not only captivates but also offers a practical avenue to delve into the intricacies of data structures and foster algorithmic thinking.

# Introduction to String Algorithms

String algorithms, a versatile toolkit for tackling an array of computational challenges. String algorithms, designed for the manipulation and analysis of sequences of characters, are essential in addressing a wide spectrum of problems in computer science. Within this domain, string algorithms prove instrumental in tasks such as pattern matching, substring search, and the optimization of various string-related operations.

As we explore, we'll know much about fundamental string algorithms, examining techniques like string matching, regular expressions, and dynamic programming. Join this journey into the heart of string manipulation, where the algorithms we encounter will become indispensable tools for deciphering, analyzing, and extracting valuable information from the world of characters and text.

One of the fundamental case in string algorithms is Robot return to Origin.

## Robot return to Origin

The "Robot Return to Origin" is a challenge, where a robot follows a sequence of instructions and the goal is to determine if the robot returns to its initial position.

 It involves a robot moving on a 2D plane, following a sequence of instructions represented by the characters 'U' (up), 'D' (down), 'R' (right), and 'L' (left). The task is to determine whether the robot returns to the origin (0, 0) after executing the given instructions.

           U

            |

L — (origin) — R

            |

           D             

## Python Code

```python
#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for robot return to origin

def robot_return_to_origin(input):
    # Initialize the coordinates to (0, 0)
    x = y = 0

    # Iterate through each character in the input string
    for i in input:
        # Update coordinates based on the current direction
        if i == "U": #U denotes "UP" and it moves towards top from the origin(y-axis)
            y += 1
        elif i == "D": #D denotes "DOWN" and it moves bottom from the origin(y-axis)
            y -= 1
        elif i == "R": #R denotes "RIGHT" and it moves right hand side from the origin(x-axis)
            x += 1
        elif i == "L": #L denotes "LEFT" and it moves left hand side from the origin(x-axis)
            x -= 1
        else:
            # Handle invalid input characters other than "R,U,L,D"
            print("Wrong input")

    # Check if the final coordinates are at the origin (0, 0)
    return x == 0 and y == 0

# Get user input for directions (case-insensitive)
z = input()
z = z.upper()  # Convert input to uppercase for case-insensitivity

# Call the function and print the result
print(robot_return_to_origin(z))
#returns True if the robot returns to the origin else returns False
```

### **Step-by-Step Explanation:**

**1. Function Definition:**

- `def robot_return_to_origin(input):`: This line defines a function named `robot_return_to_origin` that takes a string `input` as a parameter. The function is designed to check if a robot, represented by a sequence of directional inputs, returns to the origin (0,0) on a 2D plane.

**2. Initialize Position:**

- `x = y = 0`: Initializes two variables `x` and `y` to zero. These variables represent the current position of the robot on the x-axis and y-axis, respectively.

**3. Iterate Through Input:**

- `for i in input:`: Initiates a loop that iterates through each character (`i`) in the input string. The loop updates the robot's position based on the directional inputs.

**4. Update Position:**

- The `if-elif-else` block inside the loop updates the robot's position based on the current character:
    - `if i == "U": y += 1`: Move up (increment `y`).
    - `elif i == "D": y -= 1`: Move down (decrement `y`).
    - `elif i == "R": x += 1`: Move right (increment `x`).
    - `elif i == "L": x -= 1`: Move left (decrement `x`).
    - `else: print("wrong input")`: Prints an error message if the input contains an invalid character other than “R”,”L”,”U”,”D”.
- The `return x == 0 and y == 0` checks if the final coordinates are at the origin (0, 0).
1. **Convert Input to Uppercase:**
- `z = input("Enter the directions: ")`: Prompts the user to enter the directions for the robot. The input is stored in the variable `z`.
- `z = z.upper()`: Converts the input string to uppercase, ensuring case-insensitivity.

7**. Check and Print Result:**

- `if robot_return_to_origin(z):`: Calls the `robot_return_to_origin` function with the user-input directions and checks if the robot returns to the origin.
- If the robot returns to the origin ,then it returns true orelse it returns false.

In summary, this Python code prompts the user to input a sequence of directions for a robot (U for up, D for down, R for right, L for left), updates the robot's position accordingly, and then checks if the robot returns to the origin. The result is printed to the user.

## C++ Code

```cpp
//  Copyrights to venkys.io
// For more programs visit venkys.io 
// c++ program for robot return to origin

#include <iostream>
#include <cctype> // For toupper function

bool robotReturnToOrigin(const std::string &input)
{
    // Initialize the coordinates to (0, 0)
    int x = 0, y = 0;

    // Iterate through each character in the input string
    for (char i : input)
    {
        // Update coordinates based on the current direction
        if (i == 'U')
        { // U denotes "UP" and it moves towards top from the origin(y-axis)
            y += 1;
        }
        else if (i == 'D')
        { // D denotes "DOWN" and it moves bottom from the origin(y-axis)
            y -= 1;
        }
        else if (i == 'R')
        { // R denotes "RIGHT" and it moves right hand side from the origin(x-axis)
            x += 1;
        }
        else if (i == 'L')
        { // L denotes "LEFT" and it moves left hand side from the origin(x-axis)
            x -= 1;
        }
        else
        {
            // Handle invalid input characters other than "R,U,L,D"
            std::cout << "Wrong input" << std::endl;
        }
    }

    // Check if the final coordinates are at the origin (0, 0)
    return x == 0 && y == 0;
}

int main()
{
    // Get user input for directions (case-insensitive)
    std::string z;
    // std::cout << "Enter the directions: ";
    std::cin >> z;

    // Convert input to uppercase for case-insensitivity
    for (char &c : z)
    {
        c = std::toupper(c);
    }

    // Call the function and print the result
    std::cout << (robotReturnToOrigin(z) ? "true" : "false") << std::endl; // returns True if the robot returns to the origin else returns False
    return 0;
}
```

### **Step-by-Step Explanation:**

**1. Function Definition:**

- `bool robot_return_to_origin(const string &input)`: This declares a function named `robot_return_to_origin` that takes a constant reference to a string (`const string &input`) as a parameter. The function returns a boolean value (`bool`), indicating whether the robot returns to the origin. The function is designed to process a sequence of directional inputs and determine if the robot returns to the origin (0,0) on a 2D plane.

**2. Initialize Position:**

- `int x = 0, y = 0;`: Initializes two integer variables `x` and `y` to zero. These variables represent the current position of the robot on the x-axis and y-axis, respectively. The initial position is set at the origin (0,0).

**3. Loop Through Input:**

- `for (char i : input)`: Initiates a range-based for loop that iterates through each character (`char i`) in the input string. The loop allows the program to process each directional input.

**4. Update Position:**

- Inside the loop, there is an `if-else` block that updates the robot's position based on the current character:
    - `if (i == 'U')`: Increments `y` to move the robot up.
    - `else if (i == 'D')`: Decrements `y` to move the robot down.
    - `else if (i == 'R')`: Increments `x` to move the robot right.
    - `else if (i == 'L')`: Decrements `x` to move the robot left.
    - `else`: Prints an error message if the input contains an invalid character and returns `false` to indicate an issue with the input.
- The `return x == 0 && y == 0` checks if the final coordinates are at the origin (0, 0).

**5. Convert Input to Uppercase:**

- After processing the directional inputs, the main function converts the entire input string to uppercase:
    - `for (char &c : directions) { c = toupper(c); }`: This loop iterates through each character in the `directions` string and converts it to uppercase using the `toupper` function. This ensures case-insensitive comparison.

**6. Check and Print Result:**

- `if (robot_return_to_origin(directions))`: Calls the `robot_return_to_origin` function with the processed user-input directions and checks if the robot returns to the origin.
- If the robot returns to the origin ,then it returns true orelse it returns false.

In summary, this C++ code prompts the user to input a sequence of directions for a robot (U for up, D for down, R for right, L for left), updates the robot's position accordingly, and then checks if the robot returns to the origin. The result is printed to the user, and the program ensures case-insensitivity by converting all input characters to uppercase.

## Java Code

```java
//  Copyrights to venkys.io
// For more programs visit venkys.io 
// Java program for robot return to origin

import java.util.Scanner;

public class robotreturn {

    public static boolean isRobotReturnToOrigin(String input) {
        int x = 0, y = 0;
        for (char i : input.toCharArray()) {
            if (i == 'U') {
                y += 1;
            } else if (i == 'D') {
                y -= 1;
            } else if (i == 'R') {
                x += 1;
            } else if (i == 'L') {
                x -= 1;
            } else {
                System.out.println("Wrong input");
                return false;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the directions: ");
        String directions = scanner.nextLine().toUpperCase();

        if (isRobotReturnToOrigin(directions)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
```

### **Step-by-Step Explanation:**

**1. Function Definition:**

- `public static boolean isRobotReturnToOrigin(String input)`: This line declares a static function named `isRobotReturnToOrigin` that takes a string `input` as a parameter. The function returns a boolean value (`true` or `false`), indicating whether the robot returns to the origin. The function processes a sequence of directional inputs and checks if the robot, represented by these inputs, returns to the origin (0,0) on a 2D plane.

**2. Initialize Position:**

- `int x = 0, y = 0;`: Initializes two integer variables `x` and `y` to zero. These variables represent the current position of the robot on the x-axis and y-axis, respectively. The initial position is set at the origin (0,0).

**3. Loop Through Input:**

- `for (char i : input.toCharArray()) { }`: Initiates a enhanced for loop that iterates through each character (`char i`) in the input string. The `toCharArray()` method converts the input string to an array of characters.

**4. Update Position:**

- Inside the loop, there is an `if-else` block that updates the robot's position based on the current character:
    - `if (i == 'U')`: Increments `y` to move the robot up.
    - `else if (i == 'D')`: Decrements `y` to move the robot down.
    - `else if (i == 'R')`: Increments `x` to move the robot right.
    - `else if (i == 'L')`: Decrements `x` to move the robot left.
    - `else`: Prints an error message if the input contains an invalid character and returns `false` to indicate an issue with the input.
- The `return x == 0 and y == 0` checks if the final coordinates are at the origin (0, 0).

**5. Convert Input to Uppercase:**

- `String directions = scanner.nextLine().toUpperCase();`: Reads the user input using a `Scanner` and converts the entire input string to uppercase using the `toUpperCase()` method. This ensures case-insensitive comparison.

**6. Check and Print Result:**

- `if (isRobotReturnToOrigin(directions)) { }`: Calls the `isRobotReturnToOrigin` function with the processed user-input directions and checks if the robot returns to the origin.
- If the robot returns to the origin,then it returns true or else it returns false.

## **Time and Space Complexity Analysis**

**Time Complexity:**

- The function iterates through each character in the input string exactly once, performing constant-time operations for each character.
- Therefore, the time complexity is O(n), where n is the length of the input string.

**Space Complexity:**

- The function uses only a constant amount of extra space, regardless of the size of the input string. The extra space is used for the integer variables **`x`** and **`y`**.
- Therefore, the space complexity is O(1), indicating constant space usage.

In summary, the robot return to origin algorithm has a time complexity of O(n) and a space complexity of O(1), where n is the length of the input string.

## Real world Applications

The robot return to origin algorithm is a fundamental technique in robotics that allows a robot to navigate back to its starting point without getting lost. It is used in a variety of real-world applications, including:

- **Autonomous exploration:** Robots that are exploring new environments often use the return to origin algorithm to make sure they can always find their way back to a safe starting point.
- **Mapping and surveying:** Robots that are mapping or surveying an area can use the return to origin algorithm to make sure they cover the entire area without getting lost.
- **Search and rescue:** Robots that are searching for people or objects in a disaster zone can use the return to origin algorithm to make sure they don't get lost and can always find their way back to their base station.
- **Delivery and logistics:** Robots that are delivering goods or performing other logistical tasks can use the return to origin algorithm to make sure they always return to their starting point.
- **Home automation:** Robots that are performing tasks in the home, such as cleaning or vacuuming, can use the return to origin algorithm to make sure they always return to their charging station.

The return to origin algorithm is a versatile and powerful tool that can be used for a wide variety of robotic tasks. It is a fundamental technique that is essential for the development of autonomous robots.

The specific implementation of the return to origin algorithm will vary depending on the specific application. However, the general principles are the same: the robot must keep track of its position and orientation, and it must use this information to plan a path back to its starting point.

The return to origin algorithm can be implemented using a variety of different techniques, such as:

- **Dead reckoning:** This is the simplest method, and it involves keeping track of the robot's position and orientation by estimating its movement. However, dead reckoning is not very accurate, and it can accumulate errors over time.
- **Landmark navigation:** This method involves using landmarks in the environment to help the robot navigate. The robot can store a map of the landmarks, and it can use this map to plan a path back to its starting point.
- **SLAM (Simultaneous Localization and Mapping):** This is the most sophisticated method, and it involves simultaneously building a map of the environment and estimating the robot's position within that map. SLAM is very accurate, but it is also computationally expensive.

The choice of which method to use will depend on the specific application and the available resources.

## Test Cases

- Input: "UDLRUDDLLUURRR"
  Output: False

  Explanation:

  - The robot moves up, down, left, right, up, down, down, left, left, left, up, up, right, right, right.
  - The final coordinates are (2, -1), not at the origin.
  Therefore, the output is False.

- Input: "UDRLUD"
  Output: True

  Explanation:

  We start at the origin (0, 0).
  For each character in the input string:
  - "U" (Up): Move one unit up, so the position becomes (0, 1).
  - "D" (Down): Move one unit down, so the position becomes (0, 0).
  - "R" (Right): Move one unit to the right, so the position becomes (1, 0).
  - "L" (Left): Move one unit to the left, so the position becomes (0, 0).
  - "U" (Up): Move one unit up, so the position becomes (0, 1).
  - "D" (Down): Move one unit down, so the position becomes (0, 0).
  After executing all the movements, the robot returns to the origin (0, 0). Therefore, the output is True.
