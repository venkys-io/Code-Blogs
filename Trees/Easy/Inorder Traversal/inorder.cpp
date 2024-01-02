#include <iostream>
#include <memory>

// Definition for a binary tree node
class Node {
public:
    int data;
    Node* left = nullptr;
    Node* right = nullptr;

    // Node constructor initializes data
    Node(int val) : data(val) {}
};

// Recursive Inorder Traversal
void inorder(Node* root) {
    if (root != nullptr) {
        // Traverse the left subtree
        inorder(root->left);

        // Print the value of the current node
        std::cout << root->data << " ";

        // Traverse the right subtree
        inorder(root->right);
    }
}

// Function to build a binary tree interactively based on user input
Node* buildTree() {
    int rootData;
    std::cout << "Enter the value for the current node: ";
    std::cin >> rootData;

    auto root = new Node(rootData);

    char hasLeftChild, hasRightChild;
    
    // Ask user if the current node has a left child
    std::cout << "Does the current node have a left child? (y/n): ";
    std::cin >> hasLeftChild;

    // If yes, recursively build the left subtree
    if (hasLeftChild == 'y') {
        root->left = buildTree();
    }

    // Ask user if the current node has a right child
    std::cout << "Does the current node have a right child? (y/n): ";
    std::cin >> hasRightChild;

    // If yes, recursively build the right subtree
    if (hasRightChild == 'y') {
        root->right = buildTree();
    }

    return root;
}

int main() {
    try {
        std::cout << "Interactive Binary Tree Construction\n";
        Node* root = buildTree();

        std::cout << "\nInorder Traversal: ";
        inorder(root);
        std::cout << std::endl;
    } catch (const std::exception& e) {
        // Handle exceptions, if any
        std::cerr << "Error: " << e.what() << std::endl;
    }

    return 0;
}
