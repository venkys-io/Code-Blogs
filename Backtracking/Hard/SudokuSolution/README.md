# Exploring Algorithmic Techniques: Solving Sudoku Puzzles
In the realm of algorithmic techniques, we delve into the fascinating world of solving Sudoku puzzles. Embark on this journey as we explore the intricacies of Sudoku solutions and the application of algorithms to conquer this challenging puzzle.

## Introduction to Sudoku Solving Algorithms
Algorithmic techniques play a crucial role in solving complex puzzles, and Sudoku is no exception. Sudoku is a number puzzle where each cell must contain a digit from 1 to 9, following specific rules. The challenge lies in finding a solution that satisfies these rules for the entire grid.

## Sudoku Solution Techniques
Solving Sudoku involves employing various techniques to fill in the grid systematically. One common approach is using a backtracking algorithm. We explore the puzzle space, making decisions at each step, and backtracking when needed.

## Overview of Sudoku Solving
The Sudoku solving process is akin to systematically searching for the correct placement of numbers. Starting with an empty grid, we iteratively make decisions on placing numbers based on the rules of Sudoku. If a conflict arises, we backtrack to explore alternative possibilities until a valid solution is found.

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

# Sudoku board represented as a 2D list
board = [
    [".", ".", "2", ".", "1", ".", "6", "8", "7"],
    ["1", ".", ".", ".", "8", ".", "2", "5", "4"],
    [".", "6", ".", ".", "2", ".", "9", "1", "3"],
    ["6", "8", "5", ".", "3", ".", "4", "7", "9"],
    [".", ".", ".", ".", ".", "8", "1", ".", "2"],
    ["2", ".", ".", "7", ".", ".", "5", ".", "8"],
    ["9", ".", "6", "8", "7", ".", "3", "4", "5"],
    [".", ".", ".", ".", "4", ".", "7", ".", "6"],
    ["4", "7", "3", ".", ".", "6", "8", ".", "1"]
]

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

# Start solving the Sudoku puzzle from the top-left corner
solveSudoku(board, 0, 0)
```
### Step-by-Step Explanation of Python Code
- **Importing Counter**
   - This line imports the `Counter` class from the `collections` module.
   - `Counter` will be used later to count occurrences of elements in rows.

- **Defining the Sudoku Board**
   - The initial state of the Sudoku board is represented as a 9x9 2D list.

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

- **Function to Check Validity of the Entire Board:**
   - `validBoard` function iterates through each cell and checks if the row, column, and block are all valid.
   - If any of them is invalid, the function returns `False`.

- **Function to Print the Sudoku Board:**
   - `printBoard` function prints the current state of the Sudoku board.

- **Function to Solve Sudoku using Backtracking:**
   - `solveSudoku` function is the main solver using a backtracking approach.
   - It starts from the top-left corner and recursively fills cells with numbers from 1 to 9.
   - It backtracks when the current filling doesn't lead to a solution.

- **Starting the Solver:**
   - `solveSudoku(board, 0, 0)` Initiates the Sudoku solver by starting from the top-left corner (row=0, col=0).


