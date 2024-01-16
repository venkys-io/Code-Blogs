/* Copyrights to venkys.io
For more information, visit https://venkys.io

Space complexity: O(H)
Time complexity: O(H + K) */

#include <iostream>
#include <cstdlib>  // For using NULL
#include <vector>
#include <sstream>
using namespace std;

// Definition of a TreeNode in a Binary Search Tree (BST)
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    // Constructor to initialize a TreeNode with a given value
    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

// Class to find the kth largest element in a BST
class KthLargestInBST {
private:
    int count;   // Counter to keep track of the number of nodes visited
    int result;  // Variable to store the result (kth largest element)

public:
    // Constructor to initialize the count and result
    KthLargestInBST() : count(0), result(-1) {}

    // Function to find the kth largest element in the BST
    int kthLargest(TreeNode* root, int k);

private:
    // Helper function for inorder traversal to find kth largest element
    void inorderTraversal(TreeNode* node);
};

// Function to build a BST from values in a vector
TreeNode* buildBST(const vector<int>& values, size_t& index);

int main() {
    // Prompt the user to enter values for BST nodes and the value of k
    cout << "Enter the values for the BST nodes and the value of k (in a space-separated format):" << endl;

    // Read input line
    string inputLine;
    getline(cin, inputLine);

    // Parse values from the input line
    stringstream ss(inputLine);
    vector<int> values;
    int val;
    while (ss >> val) {
        values.push_back(val);
    }

    // Check if there are enough values to build a BST and get the value of k
    if (values.size() < 2) {
        cout << "Invalid input format. Please enter values for BST nodes and the value of k." << endl;
        return 1;
    }

    // Get the value of k
    int k = values.back();
    values.pop_back();

    // Build the Binary Search Tree (BST) based on the provided values
    size_t index = 0;
    TreeNode* root = buildBST(values, index);

    if (root == NULL) {
        cout << "The BST is empty." << endl;
        return 0;
    }

    // Create an instance of the KthLargestInBST class
    KthLargestInBST kthLargestFinder;

    // Find and display the kth largest element in the BST
    int result = kthLargestFinder.kthLargest(root, k);

    if (result != -1) {
        cout << "The " << k << "th largest element is: " << result << endl;
    } else {
        cout << "Invalid value of k or the BST is not large enough." << endl;
    }

    return 0;
}

// Implementation of the kthLargest function from KthLargestInBST class
int KthLargestInBST::kthLargest(TreeNode* root, int k) {
    if (root == NULL || k <= 0) {
        return -1;  // Invalid input or empty tree
    }

    // Set count to k and perform inorder traversal to find the kth largest element
    count = k;
    inorderTraversal(root);
    return result;
}

// Implementation of the inorderTraversal function for BST traversal
void KthLargestInBST::inorderTraversal(TreeNode* node) {
    // Base case: If the node is null or kth largest element is already found, return
    if (node == NULL || count == 0) {
        return;
    }

    // Traverse the right subtree (reverse order)
    inorderTraversal(node->right);

    // Process the current node
    if (--count == 0) {
        result = node->val;  // Update result when kth largest element is found
        return;
    }

    // Traverse the left subtree
    inorderTraversal(node->left);
}

// Implementation of the buildBST function to construct a BST from values in a vector
TreeNode* buildBST(const vector<int>& values, size_t& index) {
    // Base case: Return null if the index is out of bounds
    if (index >= values.size()) {
        return nullptr;
    }

    // Read the current value from the vector
    int val = values[index++];

    // Return null if the value is -1 (null node)
    if (val == -1) {
        return nullptr;
    }

    // Create a new TreeNode with the current value
    TreeNode* node = new TreeNode(val);

    // Recursively build left and right subtrees
    node->left = buildBST(values, index);
    node->right = buildBST(values, index);

    return node;
}
