# Exploring Algorithmic Techniques: Solving Sudoku Puzzles
In the realm of algorithmic techniques, we delve into the fascinating world of solving Sudoku puzzles. Embark on this journey as we explore the intricacies of Sudoku solutions and the application of algorithms to conquer this challenging puzzle.

## Introduction to Sudoku Solving Algorithms
Algorithmic techniques play a crucial role in solving complex puzzles, and Sudoku is no exception. Sudoku is a number puzzle where each cell must contain a digit from 1 to 9, following specific rules. The challenge lies in finding a solution that satisfies these rules for the entire grid.

## Sudoku Solution Techniques
Solving Sudoku involves employing various techniques to fill in the grid systematically. One common approach is using a backtracking algorithm. We explore the puzzle space, making decisions at each step, and backtracking when needed.

## Overview of Sudoku Solving
The Sudoku solving process is akin to systematically searching for the correct placement of numbers. Starting with an empty grid, we iteratively make decisions on placing numbers based on the rules of Sudoku. If a conflict arises, we backtrack to explore alternative possibilities until a valid solution is found.

## Sample Test Cases
```bash
. . 2 . 1 . 6 8 7
1 . . . 8 . 2 5 4
. 6 . . 2 . 9 1 3
6 8 5 . 3 . 4 7 9
. . . . . 8 1 . 2
2 . . 7 . . 5 . 8
9 . 6 8 7 . 3 4 5
. . . . 4 . 7 . 6
4 7 3 . . 6 8 . 1
```
```bash
. 3 . 1 8 4 . 6 .
1 . . . 6 . . . 7
9 8 . . . . . 1 5
6 . . . 4 . . . 3
. . 8 . . . 2 . .
4 . . . 5 . . . 8
8 7 . . . . . 2 9
5 . . . 2 . . . 4
. 6 . 4 3 8 . 5 .
```
```bash
. . . 6 7 4 . . .
. 3 4 . . . 7 9 .
7 . . . . . . . 5
. . 6 . 5 . 9 . .
. 8 . 9 . 3 . 7 .
. . 7 . 4 . 5 . .
1 . . . . . . . 3
. 7 8 . . . 2 5 .
. . . 4 8 9 . . .
```

## Python Code
```python
# Copyrights to venkys.io
# For more information, visit https://venkys.io 

# Python Program for SudokuSolution
# Stable: Yes
# Inplace: Yes
# Adaptive: No

# Time Complexity: O(9^(n^2) where n is the size of the Sudoku board
# Space Complexity: O(n^2)

# Import Counter from collections module to easily count occurrences of elements in a list
from collections import Counter

# Function to check if a row in the Sudoku board is valid
def validRow(board, row):
    # Count occurrences of elements in the row using Counter
    d = Counter(board[row])
    # Check if any non-empty element is repeated
    for key, values in d.items():
        if key != "." and values > 1:
            return False
    return True

# Function to check if a column in the Sudoku board is valid
def validCol(board, col):
    d = dict()
    # Iterate through rows in the given column
    for row in range(9):
        # Skip empty cells
        if board[row][col] == ".":
            continue
        # Count occurrences of elements in the column
        if board[row][col] not in d.keys():
            d[board[row][col]] = 1
        else:
            d[board[row][col]] += 1
    # Check if any non-empty element is repeated
    for key, value in d.items():
        if value > 1:
            return False
    return True

# Function to check if a 3x3 block in the Sudoku board is valid
def validBlock(board, row, col):
    rowBlock = 3 * (row // 3)
    colBlock = 3 * (col // 3)
    d = dict()
    # Iterate through the 3x3 block
    for row in range(rowBlock, rowBlock + 3):
        for col in range(colBlock, colBlock + 3):
            # Skip empty cells
            if board[row][col] == ".":
                continue
            # Count occurrences of elements in the block
            if board[row][col] in d.keys():
                d[board[row][col]] += 1
            else:
                d[board[row][col]] = 1
    # Check if any non-empty element is repeated
    for key, value in d.items():
        if value > 1:
            return False
    return True

# Function to check if the entire Sudoku board is valid
def validBoard(board):
    # Iterate through each cell in the board
    for row in range(len(board)):
        for col in range(len(board[0])):
            # Check if the row, column, and block are all valid
            if not (validRow(board, row) and validCol(board, col) and validBlock(board, row, col)):
                return False
    return True

# Function to print the Sudoku board
def printBoard(board):
    print("Sudoku solution....")
    print("\n" + ("-" * 50) + "\n")
    for row in range(9):
        for col in range(9):
            print(board[row][col], end=" ")
        print()
    print("\n" + ("-" * 50) + "\n")

# Function to solve the Sudoku puzzle using backtracking
def solveSudoku(board, row, col):
    # If the column exceeds the board size, move to the next row and start from the first column
    if col >= len(board):
        row += 1
        col = 0
    # If the row exceeds the board size, the Sudoku is solved, print the solution and return True
    if row >= len(board):
        printBoard(board)
        return True
    # If the cell is not empty, move to the next column
    if board[row][col] != ".":
        return solveSudoku(board, row, col + 1)
    # Try filling the cell with numbers from 1 to 9
    for i in range(1, 10):
        board[row][col] = str(i)
        # If the board is valid so far, recursively move to the next cell
        if validBoard(board) and solveSudoku(board, row, col + 1):
            return True
        # If the current filling doesn't lead to a solution, backtrack by setting the cell back to "."
        board[row][col] = "."
    # If none of the numbers work in the current cell, backtrack to the previous cell
    return False

# Function to take user input for the Sudoku board
def takeUserInput():
    print("Enter the Sudoku puzzle row-wise. Use '.' for empty cells.")
    board = []
    for i in range(9):
        row = input().split()
        # Validate the length of the input row
        if len(row) != 9:
            print("Invalid input. Please enter exactly 9 values for each row.")
            return None
        board.append(row)
    return board


#     Sudoku board represented as a 2D list as
#     board = [
#     [".", ".", "2", ".", "1", ".", "6", "8", "7"],
#     ["1", ".", ".", ".", "8", ".", "2", "5", "4"],
#     [".", "6", ".", ".", "2", ".", "9", "1", "3"],
#     ["6", "8", "5", ".", "3", ".", "4", "7", "9"],
#     [".", ".", ".", ".", ".", "8", "1", ".", "2"],
#     ["2", ".", ".", "7", ".", ".", "5", ".", "8"],
#     ["9", ".", "6", "8", "7", ".", "3", "4", "5"],
#     [".", ".", ".", ".", "4", ".", "7", ".", "6"],
#     ["4", "7", "3", ".", ".", "6", "8", ".", "1"]
#     ]


if __name__ == "__main__":
    # Take user input for the Sudoku board
    user_board = takeUserInput()

    if user_board:
        # Start solving the Sudoku puzzle from the top-left corner
        solveSudoku(user_board, 0, 0)
```
### Step-by-Step Explanation of Python Code

- **Importing Counter**
   - This line imports the `Counter` class from the `collections` module.
   - `Counter` will be used later to count occurrences of elements in rows.
- **Taking User Input for the Sudoku Board**
   - The new function `takeUserInput()` has been added to prompt the user to enter values row-wise for the Sudoku puzzle.
   - The input is validated to ensure each row has exactly 9 values.
   - If the input is valid, it is then passed to the `solveSudoku()` function for solving the puzzle.

- **Defining the Sudoku Board**
   - The initial state of the Sudoku board is now obtained from user input using the `takeUserInput()` function and is stored as a 9x9 2D list.

- **Function to Check Validity of a Row**
   - `validRow` function checks if a given row is valid.
   - It uses `Counter` to count occurrences of non-empty elements.
   - If any non-empty element is repeated, the function returns `False`.

- **Function to Check Validity of a Column**
   - `validCol` function checks if a given column is valid.
   - It uses a dictionary to count occurrences of non-empty elements.
   - If any non-empty element is repeated, the function returns `False`.

- **Function to Check Validity of a 3x3 Block**
   - `validBlock` function checks if a given 3x3 block is valid.
   - It uses a dictionary to count occurrences of non-empty elements.
   - If any non-empty element is repeated, the function returns `False`.

- **Function to Check Validity of the Entire Board**
   - `validBoard` function iterates through each cell and checks if the row, column, and block are all valid.
   - If any of them is invalid, the function returns `False`.

- **Function to Print the Sudoku Board**
   - `printBoard` function prints the current state of the Sudoku board.

- **Function to Solve Sudoku using Backtracking**
   - `solveSudoku` function is the main solver using a backtracking approach.
   - It starts from the top-left corner and recursively fills cells with numbers from 1 to 9.
   - It backtracks when the current filling doesn't lead to a solution.

- **Starting the Solver with User Input**
   - The script now includes a call to `takeUserInput()` to get the Sudoku board from the user.
   - If the user input is valid, it is then passed to `solveSudoku(board, 0, 0)` to initiate the Sudoku solver.
   - `solveSudoku(board, 0, 0)` Initiates the Sudoku solver by starting from the top-left corner (row=0, col=0).

## JAVA Code
```java
// Copyrights to venkys.io
// For more information, visit https://venkys.io 

// Java Program for SudokuSolution
// Stable: Yes
// Inplace: Yes
// Adaptive: No

// Time Complexity: O(9^(n^2) where n is the size of the Sudoku board
// Space Complexity: O(n^2)

import java.util.Scanner;

public class Main {
    // Check if the element is correctly placed in terms of Sudoku rules
    public static boolean isSafe(char[][] board, int row, int col, int num) {
        // Check if the number already exists in the same column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (num + '0')) {
                return false;
            }
        }
        // Check if the number already exists in the same row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == (char) (num + '0')) {
                return false;
            }
        }
        // Check if the number already exists in the 3x3 subgrid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (num + '0')) {
                    return false;
                }
            }
        }
        // If the number is not found in the same row, column, or subgrid, it's safe to
        // place
        return true;
    }

    // Helper function for Sudoku solving
    public static boolean helper(char[][] board, int row, int col) {
        // Base case: If we have reached the end of the row, the Sudoku is solved
        if (row == board.length) {
            return true;
        }

        // Determine the next row and column indices
        int nrow = 0;
        int ncol = 0;

        // If we are at the last column, move to the next row (start from the first
        // column)
        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            // Move to the next column in the same row
            nrow = row;
            ncol = col + 1;
        }

        // If the current cell is not empty, move to the next cell
        if (board[row][col] != '.') {
            // Recursively call helper for the next cell
            return helper(board, nrow, ncol);
        } else {
            // checking the value in the empty places
            for (int i = 1; i <= 9; i++) {
                // Try placing numbers 1 to 9 and check if it's safe
                if (isSafe(board, row, col, i)) {
                    // Place the number in the current cell
                    board[row][col] = (char) (i + '0');

                    // Recursively call helper for the next cell
                    if (helper(board, nrow, ncol)) {
                        return true; // If the puzzle is solved, return true
                    } else {
                        // If placing the current number doesn't lead to a solution, backtrack
                        board[row][col] = '.'; // Backtrack by resetting the cell to empty
                    }
                }
            }
        }
        // If no number can be placed in the current cell, backtrack
        return false;
    }

    // Printing the Sudoku board
    public static void sudokoSol(char[][] board) {
        // Start solving the Sudoku using the helper function
        helper(board, 0, 0);

        // Print the solved Sudoku
        System.out.println("Sudoku");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

 // Function to take user input for the initial Sudoku board
    public static char[][] takeUserInput() {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Initialize a 9x9 char array to represent the Sudoku board
        char[][] board = new char[9][9];

        System.out.println("Enter the Sudoku puzzle row-wise. Use '.' for empty cells.");
        // Iterate through each row
        for (int i = 0; i < 9; i++) {
            String inputRow = scanner.nextLine().trim(); // Read the input row as a string and trim any leading or trailing spaces
            
            // Iterate through each column
            for (int j = 0; j < 9; j++) {
                 // Assign the character at the j-th position of the input row to the corresponding cell
                board[i][j] = inputRow.charAt(j);
            }
        }
        return board; // Return the filled Sudoku board
    }
    public static void main(String args[]) {
        // Take user input for the initial Sudoku board configuration
        char[][] board = takeUserInput();

        // Solve and print the Sudoku board
        System.out.println("Sudoku after solving");
        sudokoSol(board);

    }
}
```
### Step-by-Step Explanation of Java Code

- **`isSafe` method**
   - This method checks whether it is safe to place a number `num` at a given position `(row, col)` on the Sudoku board.
   - It checks for the presence of the same number in the current row, current column, and the 3x3 subgrid to ensure Sudoku rules are not violated.

- **`helper` method**
   - This recursive method is the core of the backtracking algorithm.
   - It iterates through each cell of the Sudoku board. If a cell is empty (`'.'`), it tries placing numbers from 1 to 9 using the `isSafe` method.
   - If a number is safe, it places the number in the cell and recursively moves on to the next cell.
   - If placing a number in a cell leads to a solution, the method returns `true`. Otherwise, it backtracks by resetting the cell to `'.'` and tries the next number.

- **`sudokuSol` method**
   - This method initializes the backtracking process by calling the `helper` method with the initial position `(0, 0)` (top-left corner of the board).
   - Once the `helper` method returns `true` (indicating a solution is found), it prints the solved Sudoku board.

-  **`takeUserInput` Method**
   - This method prompts the user to enter values row-wise for the initial Sudoku board, using '.' to represent empty cells. 
   - It returns a 2D char array representing the filled Sudoku board based on user input.

- **`main` method**
   - Collects user input for the initial Sudoku board configuration using the `takeUserInput` method.
   - It then calls the `sudokuSol` method to solve the Sudoku puzzle and prints the solved Sudoku board.

## CPP Code
```CPP
// Copyrights to venkys.io
// For more information, visit https://venkys.io 

// CPP Program for SudokuSolution
// Stable: Yes
// Inplace: Yes
// Adaptive: No

// Time Complexity: O(9^(n^2) where n is the size of the Sudoku board
// Space Complexity: O(n^2)

// Necessary header files for input/output and vector functionality
#include <iostream>
#include <vector>

// Function to check if placing 'num' at position (row, col) is safe
bool isSafe(std::vector < std::vector <char> > &board, int row, int col, int num) {
    // Check if 'num' is present in the same column 
    for (int i = 1; i < board.size(); i++) {
        if (board[i][col] == static_cast<char>(num + '0')) return false;
    }
    // Check if 'num' is present in the same row 
    for (int j = 1; j < board.size(); j++) {
        if (board[row][j] == static_cast<char>(num + '0')) return false;
    }
    // Check if 'num' is present in the 3x3 subgrid

    int sr = 3 * (row / 3); // Calculate the starting row index of the 3x3 subgrid
    int sc = 3 * (col / 3); // Calculate the starting column index of the 3x3 subgrid
    // Iterate through each cell in the 3x3 subgrid
    for (int i = sr; i < sr + 3; i++) {
        for (int j = sc; j < sc + 3; j++) {
            // Check if the current cell contains the specified number 'num'
            if (board[i][j] == static_cast<char>(num + '0')) return false;
        }
    }
    // If 'num' is not present in the same row, column, or subgrid, it's safe
    return true;
}

// Recursive helper function to solve the Sudoku
bool helper(std::vector<std::vector<char> > &board, int row, int col) {
    // Base case: If we have reached the end of the row, the Sudoku is solved
    if (row == board.size()) return true;

    // Determine the next row and column indices
    int nrow = 0;
    int ncol = 0;

    // If we are at the last column, move to the next row (start from the first column)
    if (col == board.size() - 1) {
        nrow = row + 1;
    } else {
        // Move to the next column in the same row
        nrow = row;
        ncol = col + 1;
    }

    // If the current cell is not empty, move to the next cell
    if (board[row][col] != '.') {
        // Recursively call helper for the next cell
        if (helper(board, nrow, ncol)) return true;
    } else {
        // If the current cell is empty, try placing numbers 1 to 9 and check if it's safe
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, i)) {
                // Place the number in the current cell
                board[row][col] = static_cast<char>(i + '0');

                // Recursively call helper for the next cell
                if (helper(board, nrow, ncol)) return true;
                else board[row][col] = '.';  // If placing the current number doesn't lead to a solution, backtrack
            }
        }
    }

    // If no number can be placed in the current cell, backtrack
    return false;
}

// Function to print the solved Sudoku
void sudokuSol(std::vector<std::vector<char> > &board) {
    // Call the helper function to solve the Sudoku starting from the top-left cell
    helper(board, 0, 0);

    // Iterate through each row of the Sudoku board
    for (int i = 0; i < 9; i++) {
        // Iterate through each column of the Sudoku board
        for (int j = 0; j < 9; j++) {
            // Output the value of the current cell followed by a space
            std::cout << board[i][j] << " ";
        }
        // Move to the next line after printing each row to format the output
        std::cout << std::endl;
    }
}

// Function to take user input for the Sudoku board
std::vector < std::vector <char> > takeUserInput() {
    // Declare a 9x9 vector to represent the Sudoku board
    std::vector < std::vector <char> > board(9, std::vector<char>(9));
    std::cout << "Enter the Sudoku puzzle row-wise. Use '.' for empty cells." << std::endl;

    // Iterate through each row of the Sudoku board
    for (int i = 0; i < 9; i++) {

        // Iterate through each column of the Sudoku board
        for (int j = 0; j < 9; j++) {
            std::cin >> board[i][j]; // Take user input for each cell and store it in the board 
        }
    }
    // Return the filled Sudoku board
    return board;
}


int main() {
    // Example Sudoku board
    std::vector<std::vector<char> > board = takeUserInput();

    std::cout << "Sudoku after solving: " << std::endl;
    // Solve and print the Sudoku
    sudokuSol(board);

    return 0;
}
```
### Example of Input for 9 rows
```bash
. . 2 . 1 . 6 8 7
1 . . . 8 . 2 5 4
. 6 . . 2 . 9 1 3
6 8 5 . 3 . 4 7 9
. . . . . 8 1 . 2
2 . . 7 . . 5 . 8
9 . 6 8 7 . 3 4 5
. . . . 4 . 7 . 6
4 7 3 . . 6 8 . 1
```

### Step-by-Step Explanation of CPP Code

- **Include Header Files**
   - `#include <iostream>`: Includes the standard input/output stream header.
   - `#include <vector>`: Includes the vector header for using dynamic arrays.

- **Function `isSafe`**
   - Takes a reference to the Sudoku `board`, current `row`, `col`, and the number `num`.
   - Checks if `num` violates Sudoku rules in the same row, column, or 3x3 subgrid.
   - Returns `true` if placing `num` is valid, otherwise returns `false`.

- **Function `helper`**
   - This recursive function is the core of the backtracking algorithm.
   - It iterates through each cell of the Sudoku board. If a cell is empty (`'.'`), it tries placing numbers from 1 to 9 using the `isSafe` function.
   - If placing a number in a cell leads to a solution, the function returns `true`. Otherwise, it backtracks by resetting the cell to `'.'` and tries the next number.

- **Function `sudokuSol`**
   - This function initializes the backtracking process by calling the `helper` function with the initial position `(0, 0)` (top-left corner of the board).
   - This code block uses nested loops to iterate over each cell of the Sudoku board (represented by a 2D vector `board`).
   - The outer loop (`for(int i = 0; i < 9; i++)`) iterates over the rows, and the inner loop (`for(int j = 0; j < 9; j++)`) iterates over the columns.
   - Inside the inner loop, it prints the value of each cell followed by a space.
   - After completing each row, it inserts a newline (`cout << endl;`), creating a formatted output to display the Sudoku board.

- **Function `takeUserInput`**
   - Takes user input to initialize the Sudoku board.
   - Declares a 9x9 vector, prompts the user for values row-wise, and stores input in the board.

- **Main Function**
   - Initializes a 9x9 Sudoku board with user input using `takeUserInput`.
   - Prints the original Sudoku puzzle.
   - Calls `sudokuSol` to solve the puzzle and prints the solved Sudoku board.

- **Output**
   - The program prints the original Sudoku board and then prints the solved Sudoku board.

## Time and Space Complexity
**Time Complexity:** Exponential due to backtracking exploration of all possible combinations for each empty cell (O(9<sup>n<sup>2</sup></sup>)).

**Space Complexity:** Proportional to the maximum recursion depth, corresponding to the number of empty cells (O(n<sup>2</sup>)).

## Real-World Applications of Sudoku Solution

1. **Educational Software:**
   The Sudoku solver can be incorporated into educational software to teach students about problem-solving, logic, and algorithms.

2. **Game Development:**
   The code can be adapted for game development, where Sudoku puzzles are a popular feature. 

3. **Mobile Applications:**
   Sudoku is a popular puzzle game on mobile devices. The solver can be integrated into Sudoku apps to provide users with hints or to automatically solve puzzles for them, making the game more accessible to a wider audience.

4. **Algorithmic Challenges:**
   The Sudoku solver can be used as a coding challenge or interview question to assess a programmer's understanding of backtracking algorithms and problem-solving skills. 

5. **Automation in Data Entry:**
   In scenarios where Sudoku-like grids are used for data entry, the solver could be adapted to validate and complete partially filled grids. 

## Conclusion
The Sudoku solution presented here demonstrates the power of backtracking algorithms in solving complex puzzles efficiently. Mastering backtracking, as showcased in this Sudoku solver, is a valuable skill with broad applications in various fields, including educational software, game development, mobile applications, algorithmic challenges, and data entry verification. Understanding and implementing backtracking algorithms is a versatile tool that can be applied to solve diverse real-world problems in computer science and beyond.
