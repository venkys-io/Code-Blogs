# Exploring Backtracking Algorithm:N Queen Problem

Today, we dive into the fascinating world of backtracking algorithms and uncover one of their most captivating mysteries – backtracking algorithms. Get ready to embark on an adventure that will challenge your mind and leave you with newfound insights into the power of backtracking!

## **Introduction to Backtracking Algorithm**

The backtracking algorithm is a powerful technique used to solve problems that can be broken down into a series of decisions. It is commonly employed in constraint satisfaction problems, combinatorial optimization, and other algorithmic challenges where exhaustive search is necessary. Backtracking involves a systematic search through the space of all possible solutions.

Problems associated with backtracking can be categorized into 3 categories:

- **Decision Problems:** Here, we search for a feasible solution.
- **Optimization Problems:** For this type of problems, we search for the best solution.
- **Enumeration Problems:** We find set of all possible feasible solutions to the problems of this type.

The backtracking algorithm can be used to solve various problems such as the N-Queens problem, the Sudoku puzzle, graph coloring problems, and other constraint satisfaction problems. Its ability to systematically explore all possible solutions makes it a fundamental technique in the field of algorithm design and optimization. However, it is important to note that the efficiency of the backtracking algorithm depends on the reducing of the search space and the identification of constraints to reduce unnecessary exploration.

## **N Queen Problem**

The N-Queens problem is a classic puzzle that involves placing N chess queens on an N×N chessboard in such a way that no two queens can threaten each other. In chess, a queen can move horizontally, vertically, and diagonally, which means that no two queens should share the same row, column, or diagonal on the chessboard.

The primary goal of the N-Queens problem is to find a placement of N queens on an N×N chessboard so that no two queens can attack each other. This requires a systematic approach to exploring possible configurations while adhering to the constraints imposed by the rules of chess. One of the key challenges is to find an efficient algorithm to solve the problem, especially for larger values of N, as the search space grows exponentially with N.

The N-Queens problem serves as a benchmark for evaluating various algorithms, particularly those involving backtracking, constraint satisfaction, and combinatorial optimization.

Solving the N-Queens problem efficiently demonstrates the ability to design algorithms that can systematically explore and navigate complex search spaces, making it a fundamental problem in the field of algorithm design and optimization.

## Overview Of Backtracking Algorithm

The N-Queens problem algorithm is a classic example of a backtracking algorithm, and it is used to solve the N-Queens puzzle. The goal of the N-Queens puzzle is to place N chess queens on an N×N chessboard in such a way that no two queens can attack each other, i.e., no two queens can share the same row, column, or diagonal. In this section, we will provide an overview of the backtracking algorithm and discuss its implementation.

Backtracking involves constructing a solution incrementally, making a series of choices to build a candidate solution one step at a time.

The algorithm systematically explores the solution space by making a decision at each step and recursively exploring all possible choices, while maintaining a record of the choices made.

At each step, the algorithm checks whether the current partial solution violates any constraints. If the constraints are violated, it abandons that branch of the search space and backtracks to the previous decision point.

Backtracking is typically implemented using recursion. The recursive nature allows the algorithm to go deeper into the search space and backtrack to explore alternative choices when needed.

## Code

```python
#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for NQeens

# Function to take user input
#In the First Step we used **‘getBoard’** function initializes the chessboard as a 2D list of zeros with dimensions ‘n x n’.
def getBoard(n):
    result=[]
    board=[[0 for i in range(n)] for j in range(n)]
    return board,result
# result=[]

# Function to print board
#In this step the **‘printboard’** function is used to print the chessboard with ‘Q’ representing the queens and ‘_’ representing empty spaces.
def printboard(board,n):
    for i in range(n):
        for j in range(n):
            if board[i][j]:
                print("Q",end=" ")
            else:
                print("_",end=" ")
        print()

# Function to check if the given box is safe or not
#The **‘isSafe’** function checks whether it is safe to place a queen at the given row and column by examining the row, column, and both diagonals (upper diagonal and lower diagonal) to ensure no other queen is present.
def isSafe(board,row,col):

    # For same row
    for i in range(col):
        if board[row][i]:
            return False
    
    # For same column
    for i in range(row):
        if board[i][col]:
            return False
    

    # For left upper diagonal
    i=row
    j=col
    while i>=0 and j>=0:
        if board[i][j]:
            return False
        i-=1
        j-=1
    
    # For right upper diagonal
    i=row
    j=col
    while j>=0 and i<len(board):
        if board[i][j]:
            return False
        i+=1
        j-=1
    return True

# Function to solve the board
#the **‘VSDsolveboard’** function is a recursive backtracking function that tries to place queens row by row, calling itself for the next row.
def VSDsolveboard(board,row,n,res):
    if row==n:
        for i in range(n):
            for j in range(n):
                if board[i][j]==1:
                    res.append(j+1)
                
        return True
    
    for col in range(n):
        if isSafe(board,row,col):
            board[row][col]=1
            if VSDsolveboard(board,row+1,n,res):
                return True
            board[row][col]=0

# The Driver Function
if __name__=="__main__":
    n=int(input("Enter the value :"))
    board,result=getBoard(n)
    VSDsolveboard(board,0,n,result)
    print("-"*30)
    printboard(board,n)
    print("-"*30)
    print("The result is ",*result,sep=" ")
```

# Explanation

Now we have the basic understanding of backtracking algorithm and the concept of N queen problem.

Let’s dive into the step-by-step process of placing N queens on a board using backtracking.

1. Function to take user input

In the First Step we used **‘getBoard’** function initializes the chessboard as a 2D list of zeros with dimensions ‘n x n’.

2.To print the board

In this step the **‘printboard’** function is used to print the chessboard with ‘Q’ representing the queens and ‘_’ representing empty spaces.

3.To check if the given box is safe or not

In this step we need to check whether the given box is safe or not. The **‘isSafe’** function checks whether it is safe to place a queen at the given row and column by examining the row, column, and both diagonals (upper diagonal and lower diagonal) to ensure no other queen is present.

4.Function to solve the board

 In this step the **‘VSDsolveboard’** function is a recursive backtracking function that tries to place queens row by row, calling itself for the next row.

5.Driver function 

In this step the main driver function initializes the board, calls the **‘VSDsolveboard’** function, prints the resulting board, and displays the position of the queen in the solution.

## Code

```java

import java.util.Scanner;

public class NQueens {
    private static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the chessboard (N): ");
        N = scanner.nextInt();

        solveNQueens(); // Call the solveNQueens method to find and print the solutions
    }

    private static void solveNQueens() {
        int[][] board = new int[N][N]; // Initialize a 2D array to represent the chessboard
        if (solveNQueensUtil(board, 0)) {
            System.out.println("Solution found:");
            printSolution(board); // If a solution is found, print the chessboard configuration
        } else {
            System.out.println("No solution exists.");
        }
    }

    private static boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= N) {
            return true; // All queens are placed successfully, base case for recursion
        }

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place the queen in the current position

                if (solveNQueensUtil(board, col + 1)) {
                    return true; // Recursively try to place queens in the next column
                }

                board[i][col] = 0; // Backtrack if placing the queen didn't lead to a solution
            }
        }

        return false; // No solution found in this column
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            // Check if there is a queen in the same row, column, or diagonal
            if (board[row][i] == 1 || board[i][col] == 1 || (row - i >= 0 && board[row - i][col - i] == 1) || (row + i < N && board[row + i][col - i] == 1)) {
                return false; // If a conflict is found, return false
            }
        }

        return true; // No conflicts found, it's safe to place a queen in this position
    }

    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " "); // Print the chessboard configuration
            }
            System.out.println();
        }
    }
}
```

## Explanation

Now we have the basic understanding of backtracking algorithm and the concept of N queen problem.

Let’s dive into the step-by-step process of placing N queens on a board using backtracking.

### **1. Import Statements**

This line imports the Scanner class, which is used to take input from the user.

### **2. Class Declaration**

The class is named NQueens.

### **3. Class Variables**

A private static variable N is declared to store the size of the chessboard.

### **4. main Method**

The main method initializes a Scanner object to take input from the user. It prompts the user to enter the size of the chessboard (N) and then calls the solveNQueens method.

### **5. solveNQueens Method**

This method initializes a 2D array (board) representing the chessboard. It then calls the **`solveNQueensUtil`** method to find a solution. If a solution is found, it prints the board; otherwise, it displays a message.

### **6. `solveNQueensUtil` Method**

This recursive method attempts to place queens on the chessboard. If a queen can be placed in the current column (col), it places the queen and makes a recursive call to place queens in the next column. If placing the queen in the current position doesn't lead to a solution, it backtracks.

### **7. isSafe Method**

This method checks if it is safe to place a queen at a given position on the chessboard by examining the row, column, and diagonals.

### **8. printSolution Method**

This method prints the chessboard configuration when a solution is found.

## Code

```cpp
// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for NQeens

#include<bits/stdc++.h>

using namespace std;

bool isSafe(int row,int col,vector<vector<char>> &board){//the ‘isSafe’ checks whether placing a queen at a given position is safe, considering the row, column, and both diagonals.
  for(int j=0;j<board.size();j++){
    if(board[row][j] == 'Q'){
      return false;
    }
  }
  for (int i=0;i<board[0].size();i++){
    if(board[i][col] == 'Q'){
      return false;
    }
  }

  for (int c = col,r=row;c >=0  && r>=0; c--,r--){
      if(board[r][c] == 'Q'){
        return false;
      }
  }

  for(int r=row,c=col;c>=0 && r< board.size();c--,r++){
    if(board[r][c] == 'Q') return false;
  }
  return true;

}

void saveBoard(vector<vector<char>> board,vector<vector<string>> allBoards){//the ‘saveBoard’ prints the current chessboard configuration and saves it in a list.
  string row;
  vector<string> newBoard;
  for(int i=0;i<board.size();i++){
    row="";
    for(int j=0;j<board[0].size();j++){
      if(board[i][j] == 'Q'){
        row+='Q';
        cout<<"Q ";
      }
      else{
        row+=".";
        cout<<"_ ";
      }
    }
    cout<<endl;
    newBoard.push_back(row);
  }
  allBoards.push_back(newBoard);
  cout<<"------------------------------"<<endl;
}

void helper(vector<vector<char>> board,vector<vector<string>> allBoards,int col){
  if(col == board.size()){
    saveBoard(board,allBoards);
    return ;
  }
  for(int row=0;row<board.size();row++){
    if(isSafe(row,col,board)){
      board[row][col]='Q';
      helper(board,allBoards,col+1);
      board[row][col]='.';
    }
  }
}

vector<vector<string>> solveQueens(int n){//the ‘solveQueen’ initializes the chessboard and calls the ‘helper’ function to find all valid configurations.
  vector<vector<string>> allBoards;
  vector<vector<char>> board(n,vector<char>(n,'.'));
  helper(board,allBoards,0);
  return allBoards;

}

int main(){//the program sets the size of the chessboard and then calls ‘solveQueens’.

  int n;
  cout << "Enter the size of the chessboard : ";
  cin >> n;
  vector<vector<string>> lst = solveQueens(n);
  cout<<"Queen can be placed in chess board by the following code"<<endl;
  return 0;
}
```

## **Explanation**

Now we have the basic understanding of backtracking algorithm and the concept of N queen problem.

Let’s dive into the step-by-step process of placing N queens on a board using backtracking.

1.isSafe Function

In the first step the ‘isSafe’ function checks whether placing a queen at a given position is safe, considering the row, column, and both diagonals.

2.saveBoard Function

In this step the ‘saveBoard’ function prints the current chessboard configuration and saves it in a list.
3.helper Function

In this step the ‘helper’ function is a recursive backtracking function that tries to place queens column-wise, ensuring that they do not attack each other. It calls ‘saveBoard’ when a valid placement is found.

4.solveQueens Function

In this step the ‘solveQueen’ function initializes the chessboard and calls the ‘helper’ function to find all valid configurations.

5.main Function

In the ‘main’ function, the program sets ‘n’ to 4 (you can change it to solve for different board sizes) and then calls ‘solveQueens’. The resulting configurations are not printed directly, and there's a comment indicating that queens can be placed on the chessboard.

## Time Complexity and Space Complexity

The time complexity of the N-Queens backtracking algorithm is often denoted as O(N!), where N is the size of the chessboard. 

The recursive backtracking function **‘VSDsolveboard’** explores all possible placements of queens, and for each placement, it recursively explores all possible configurations. In the worst case, it explores N possibilities for each of the N rows, resulting in O(N^N) configurations. However, due to pruning and backtracking, the actual number of recursive calls is considerably less than N^N, leading to an average time complexity of O(N!).

The space complexity of the program is primarily determined by the space required for the chessboard and the result list. The chessboard is represented as a 2D list of size N×N, contributing O(N^2) space. The result list stores the column positions of queens in each solution.

The space complexity can be expressed as O(N^2 + N), where O(N^2) is the space required for the chessboard, and O(N) is the space required for the result list.

In Summary:

- **Time Complexity:** O(N!)
- **Space Complexity:** O(N^2 + N)

## Real-world Applications

While the N-Queens problem is a classic puzzle and a common benchmark for algorithmic solutions, its direct real-world applications are somewhat limited. In this section we will see some ways in which the principles derived from the N-Queens problem can be applied in the real world scenarios:

1. **Scheduling Problems:**
    - The N-Queens problem is analogous to certain scheduling problems where entities (queens) need to be scheduled in time slots (chessboard) without conflicts. This can be seen in job scheduling, meeting scheduling, or task assignment scenarios.
2. **Resource Allocation:**
    - In resource allocation problems, such as assigning resources (queens) to tasks or projects (chessboard), constraints similar to the N-Queens problem may arise. The goal is to allocate resources efficiently without conflicts.
3. **Circuit Board Layout:**
    - Designing an optimal layout for components on a circuit board without any interference or conflicts is crucial. The goal is to arrange components so that no electrical interference occurs.
4. **Placement of Antennas or Sensors:**
    - In wireless communication or sensor network planning, the placement of antennas or sensors without interference is crucial. The principles of the N-Queens problem can be adapted to find optimal placements.
5. **Robotics Path Planning:**
- In robotics, particularly when planning the movement of multiple robots in an environment, the N-Queens problem's principles can be adapted to ensure collision-free paths
