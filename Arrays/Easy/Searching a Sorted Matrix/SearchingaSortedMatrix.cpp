// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Searching a sorted Matrix

// time complexity:O(m*n)
// space complexity:O(1)

#include<iostream>
#include<vector>

using namespace std;

// Function to perform binary search on a sorted matrix
bool searchMatrix(vector<vector<int>> &matrix, int target) {
    // Get the number of rows in the matrix
    int rows = matrix.size();
    // Get the number of columns in the matrix
    int cols = matrix[0].size();
    // Calculate the total number of elements in the matrix
    int items = rows * cols;
    // Initialize low and high for binary search
    int low = 0;
    int high = items - 1;

    // Perform binary search on the matrix
    while (low <= high) {
        // Calculate the middle index
        int mid = (low + high) / 2;
        // Calculate the element at the middle index in the matrix
        int temp = matrix[mid / cols][mid % cols];

        // Check if the target is equal to the middle element
        if (temp == target) return true;
        // If the target is less than the middle element, update the high index
        else if (target < temp) high = mid - 1;
        // If the target is greater than the middle element, update the low index
        else low = mid + 1;
    }
    // If the target is not found, return false
    return false;
}

// Function to take matrix input from the user
vector<vector<int>> inputMatrix(int rows, int cols) {
    vector<vector<int>> matrix(rows, vector<int>(cols, 0));
    // cout << "Enter the elements of the matrix:" << endl;
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            cin >> matrix[i][j];
        }
    }
    return matrix;
}

// Main method
int main() {
    // Get the number of rows and columns in the matrix from the user
    int rows, cols;
    // cout << "Enter the number of rows in the matrix: ";
    cin >> rows;
    // cout << "Enter the number of columns in the matrix: ";
    cin >> cols;

    // Matrix input
    vector<vector<int>> matrix = inputMatrix(rows, cols);

    // Target input
    int target;
    // cout << "Enter the target integer: ";
    cin >> target;

    // Check if the target is found in the matrix using the searchMatrix function
    if (searchMatrix(matrix, target)) court << "Found";
    else court << "Not Found";

    return 0;
}
