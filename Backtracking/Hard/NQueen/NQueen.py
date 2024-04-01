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
    n=int(input())
    board,result=getBoard(n)
    VSDsolveboard(board,0,n,result)
    print("-"*30)
    printboard(board,n)
    print("-"*30)
    print(*result,sep=" ")
