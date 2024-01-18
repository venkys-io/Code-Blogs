/* Copyrights to venkys.io  */
/* For more information, visit https://venkys.io */
#include<bits/stdc++.h>

class Node {
public:
    int data;
    Node* left = NULL;
    Node* right = NULL;

    Node(int val) {
        data = val;
    }
};

// Function to insert a node into a Binary Search Tree (BST)
Node* insertBST(Node* root, int data) {
    if (root == NULL) return new Node(data);
    if (root->data == data) return root;
    else if (data < root->data) root->left = insertBST(root->left, data);
    else root->right = insertBST(root->right, data);
    return root;
}

// Function to perform an inorder traversal of the BST and print the elements
void inorder(Node* root) {
    if (root != NULL) {
        inorder(root->left);
        std::cout << root->data << " ";
        inorder(root->right);
    }
}

int main() {
    // User input for the number of elements in the BST
    std::cout << "Enter the number of elements in the BST: ";
    int n;
    std::cin >> n;

    Node* root = NULL;

    // User input for the elements of the BST
    std::cout << "Enter the elements of the BST:" << std::endl;
    for (int i = 0; i < n; i++) {
        int data;
        std::cin >> data;
        root = insertBST(root, data);
    }

    // Display the inorder traversal of the BST
    std::cout << "Inorder traversal of the BST: ";
    inorder(root);

    return 0;
}