# Binary Search Tree Insertion
 A Binary Search Tree (BST) is a tree data structure where each node has at most two child nodes, typically referred to as the "left" and "right" child. The key property of a BST is that the value of a node in the left subtree is less than or equal to the node's value, and the value of a node in the right subtree is greater than the node's value. This property ensures an efficient search, insert, and delete operations.

- The process of inserting a new element into a Binary Search Tree is known as "BST Insertion." The goal of BST insertion is to maintain the order property of the tree
 ## Overview
Tree while maintaining the ordering property of the tree. In a Binary Search Tree, each node has at most two children, and the values in the left subtree are less than or equal to the value of the node, while the values in the right subtree are greater than the node's value.

Here's an overview of the Binary Search Tree Insertion process:

1. Starting at the Root:

The insertion process begins at the root of the tree.

2. Comparing Values:

Compare the value of the new node to the value of the current node.

3. Moving Left or Right:

If the new node's value is less than the current node's value, move to the left subtree.

If the new node's value is greater than the current node's value, move to the right subtree.

4. Recursive Exploration:

Repeat steps 2-3 recursively until an empty space (a null child) is found in the tree where the new node can be inserted while maintaining the ordering property.

5. Insertion:

Insert the new node at the found position in the tree.
## Code in Python

```
#  Copyrights to venkys.io
#  For more information, visit https://venkys.io

class Node:
    def __init__(self, data):
        # Constructor for the Node class
        self.data = data
        self.left = self.right = None

def insertBST(root, data):
    # Function to insert a node into the Binary Search Tree (BST)
    if root is None:
        # If the tree is empty, create a new node
        return Node(data)
    if root.data == data:
        # If the data is already present, return the current root
        return root
    elif data < root.data:
        # If the data is smaller, go to the left subtree
        root.left = insertBST(root.left, data)
    else:
        # If the data is larger, go to the right subtree
        root.right = insertBST(root.right, data)
    return root

def inorder(root):
    # Function to perform inorder traversal of the BST
    if root:
        inorder(root.left)
        print(root.data, end=" ")
        inorder(root.right)

if __name__ == "__main__":
    root = None
    
    # Taking user input for the BST elements
    user_input = input("Enter elements for the BST (separated by spaces): ")
    arr = list(map(int, user_input.split()))

    # Building the BST using user-provided elements
    for i in arr:
        root = insertBST(root, i)

    # Displaying the inorder traversal of the BST
    print("Inorder traversal of the BST:")
    inorder(root)


``````
## Step by step Code explanation 
- Node Class:

Defines a class Node to represent each node in the Binary Search Tree (BST).
Each node has a data value, a left child (left), and a right child (right).
- insertBST Function:

Recursively inserts a node into the BST based on the provided data value.
If the tree is empty, it creates a new node.
If the data is already present, it returns the current root.
If the data is smaller, it goes to the left subtree; otherwise, it goes to the right subtree.
- inorder Function:

Performs an inorder traversal of the BST, visiting nodes in the order left, root, right.
This results in printing the data of each node in sorted order.
- Main Part of the Program:

Initializes the root of the BST as None.
Takes user input for the elements of the BST, separated by spaces.
Builds the BST using the insertBST function and the user-provided elements.
Displays the inorder traversal of the BST, which should print the elements in sorted order.
## Test cases 1
- Input : None (No element provided)
-  Empty BST
- expected output :

## Test case 2
- Input : 10 5 15 3 7 12 18
- Expected Output : 3 5 7 10 12 15 18
## Test case 3 
- Input : 7 3 10 2 5 8 1  
- Expected Output : 2 3 5 7 8 10 12

## Code in Java
```
// Copyrights to venkys.io
// For more information, visit https://venkys.io
  import java.util.Scanner;

// Definition of the TreeNode class representing a node in the binary tree
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

// Main class that contains the main logic of the program
public class Main {

    // Function to insert a node into a Binary Search Tree (BST)
    static TreeNode insertBST(TreeNode root, int data) {
        if (root == null) {
            // If the tree is empty, create a new node as the root
            return new TreeNode(data);
        }
        if (root.data == data) {
            // If the data is already present, do nothing
            return root;
        } else if (data < root.data) {
            // If the data is less than the current node's data, insert into the left subtree
            root.left = insertBST(root.left, data);
        } else {
            // If the data is greater than the current node's data, insert into the right subtree
            root.right = insertBST(root.right, data);
        }
        return root;
    }

    // Function to perform an inorder traversal of the BST and print the elements
    static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Main method where the execution of the program starts
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for the number of elements in the BST
        System.out.println("Enter the number of elements in the BST:");
        int n = scanner.nextInt();

        // User input for the elements of the BST
        System.out.println("Enter the elements of the BST:");

        TreeNode root = null;

        // Input loop to insert elements into the BST
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            root = insertBST(root, data);
        }

        // Display the inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        inorder(root);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}



``` 
## Step by step Code explanation
- TreeNode class: Defines a class to represent nodes in the binary tree. Each node has an integer value (data) and pointers to its left and right children.

- insertBST method: A static method to insert a node into a Binary Search Tree (BST). It takes the current root of the tree and the data to be inserted. If the tree is empty, it creates a new node. If the data is already present, it does nothing. Otherwise, it recursively inserts the data into the left or right subtree based on comparisons.

- inorder method: A static method to perform an inorder traversal of the BST. It prints the elements in ascending order. It recursively traverses the left subtree, visits the current node, and then recursively traverses the right subtree.

- main method: The entry point of the program. It uses a Scanner to get user input. It prompts the user to enter the number of elements in the BST and then takes input for each element. The elements are inserted into the BST using the insertBST method. Finally, it displays the inorder traversal of the constructed BST.

- Scanner.close(): Closes the Scanner object to release system resources.

This program demonstrates the creation of a Binary Search Tree, insertion of elements, and the inorder traversal of the tree. The program prints the elements in sorted order.
## Test cases 1
- Input : None (No element provided)
-  Empty BST
- expected output :

## Test case 2
- Input : 10 5 15 3 7 12 18
- Expected Output : 3 5 7 10 12 15 18
## Test case 3 
- Input : 7 3 10 2 5 8 1  
- Expected Output : 2 3 5 7 8 10 12

## Code in C++

```
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

```
## Step by step  Code explanation 
 - Node class: Defines a class to represent nodes in the binary tree. Each node has an integer value (data) and pointers to its left and right children.

- insertBST function: A function to insert a node into a Binary Search Tree (BST). It takes the current root of the tree and the data to be inserted. If the tree is empty, it creates a new node. If the data is already present, it does nothing. Otherwise, it recursively inserts the data into the left or right subtree based on comparisons.

- inorder function: A function to perform an inorder traversal of the BST. It prints the elements in ascending order. It recursively traverses the left subtree, visits the current node, and then recursively traverses the right subtree.

- main function: The entry point of the program. It uses std::cin to get user input. It prompts the user to enter the number of elements in the BST and then takes input for each element. The elements are inserted into the BST using the insertBST function. Finally, it displays the inorder traversal of the constructed BST using the inorder function.
## Test cases 1
- Input : None (No element provided)
-  Empty BST
- expected output :

## Test case 2
- Input : 10 5 15 3 7 12 18
- Expected Output : 3 5 7 10 12 15 18
## Test case 3 
- Input : 7 3 10 2 5 8 1  
- Expected Output : 2 3 5 7 8 10 12

  ## Time and space complexity
  ### Time Complexity:

- Worst Case (Unbalanced Tree): O(n)

- Average Case (Balanced Tree): O(log n)

### Space Complexity:

- Worst Case (Unbalanced Tree): O(n)

- Average Case (Balanced Tree): O(log n)
