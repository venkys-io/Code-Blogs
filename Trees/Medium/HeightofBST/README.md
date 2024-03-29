<h1>FINDING THE HEIGHT OF A BINARY SEARCH TREE</h1>

A Binary Search Tree (BST) is a type of binary tree where each node has at most two children, referred to as the left child and the right child. The key property of a BST is that the value of each node in the left subtree is less than the value of the node itself, and the value of each node in the right subtree is greater than the value of the node itself. The BST is commonly used in computer science and is a fundamental data structure for organizing and retrieving data in a sorted manner.

<h2>INTRODUCTION TO HEIGHT OF BST</h2>

The height of a Binary Search Tree (BST) refers to the maximum number of edges in the longest path from the root node to a leaf node. It represents the depth or level of the tree. The height of a BST is an important factor as it affects the efficiency of various operations performed on the tree, such as search, insertion, and deletion.

A balanced BST, where the heights of the left and right subtrees do not differ by more than 1, ensures optimal performance for these operations. By maintaining a balanced BST, the height is minimized, resulting in faster and more efficient operations.

The height of an empty BST is considered to be -1, while a BST with only one node has a height of 0. As more nodes are added to the tree, the height increases. The worst-case scenario for the height of a BST is when the tree is completely unbalanced, resulting in a height of n-1, where n is the number of nodes in the tree.

<h2>CODE</h2>

<h2>Python</h2>

```
#Copyrights to venkys.io
#For more information, visit https://venkys.io 

#Space complexity: O(n)
#Time complexity: O(n)

class Node:
    def __init__(self, key):
        # Constructor to initialize a new node with a given key
        self.key = key
        self.left = None
        self.right = None

def insert(root, key):
    # Function to insert a key into the BST
    if root is None:
        # If the tree is empty, create a new node with the given key
        return Node(key)
    else:
        if root.key < key:
            # If the key is greater than the current node's key, insert into the right subtree
            root.right = insert(root.right, key)
        else:
            # If the key is less than or equal to the current node's key, insert into the left subtree
            root.left = insert(root.left, key)
    return root

def height(root):
    # Function to calculate the height of the BST
    if root is None:
        # Base case: an empty tree has height -1
        return -1
    else:
        # Recursively calculate the height of the left and right subtrees
        left_height = height(root.left)
        right_height = height(root.right)
        # The height of the tree is the maximum of the heights of its left and right subtrees, plus 1
        return 1 + max(left_height, right_height)

def build_tree(num_nodes, values):
    # Function to build a BST from a list of values
    root = None
    for value in values:
        # Insert each value into the BST
        root = insert(root, value)
    return root

if __name__ == "__main__":
    # Input number of nodes in the BST
    num_nodes = int(input())

    # Input values of the nodes
    print()
    values = [int(input()) for _ in range(num_nodes)]

    # Build the BST
    root = build_tree(num_nodes, values)

    # Calculate and print the height of the BST
    bst_height = height(root)
    print( bst_height)

```
<h2>Step-By-Step Explanation</h2>

1.Node Class: Defines a class for a node in the BST with a constructor to initialize a node with a key and pointers to the left and right children.

2.Insert Function: Inserts a key into the BST by recursively navigating the tree based on key values.

3.Height Function: Calculates the height of the BST recursively. The height of an empty tree is -1, and for non-empty trees, it is the maximum height of its left and right subtrees plus 1.

4.Build Tree Function: Constructs a BST by inserting values from a list into the tree.

5.Main Section: Takes user input for the number of nodes and their values, builds the BST, and then calculates and prints the height of the BST.

<h2>JAVA</h2>

```
//Copyrights to venkys.io
//For more information, visit https://venkys.io 

import java.util.Scanner;

// Define a class for a node in the Binary Search Tree (BST)
class Node {
    int key;
    Node left, right;

    // Constructor to initialize a new node with a given key
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BSTHeight {

    // Function to insert a key into the BST
    static Node insert(Node root, int key) {
        if (root == null) {
            // If the tree is empty, create a new node with the given key
            return new Node(key);
        } else {
            if (key > root.key) {
                // If the key is greater than the current node's key, insert into the right subtree
                root.right = insert(root.right, key);
            } else {
                // If the key is less than or equal to the current node's key, insert into the left subtree
                root.left = insert(root.left, key);
            }
            return root;
        }
    }

    // Function to calculate the height of the BST
    static int height(Node root) {
        if (root == null) {
            // Base case: an empty tree has height -1
            return -1;
        } else {
            // Recursively calculate the height of the left and right subtrees
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            // The height of the tree is the maximum of the heights of its left and right subtrees, plus 1
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of nodes in the BST
        // System.out.print("Enter the number of nodes in the BST: ");
        int numNodes = scanner.nextInt();

        Node root = null;

        // Input values of the nodes
        // System.out.println("Enter the values of the nodes:");
        for (int i = 0; i < numNodes; i++) {
            int value = scanner.nextInt();
            // Insert each value into the BST
            root = insert(root, value);
        }

        // Calculate and print the height of the BST
        int bstHeight = height(root);
        System.out.println(bstHeight);
    }
}

```

<h2>Step-By-Step Explanation</h2>

1.Node Class: Defines a class for a node in the BST with a constructor to initialize a node with a key and pointers to the left and right children.

2.Insert Function: Inserts a key into the BST by recursively navigating the tree based on key values.

3.Height Function: Calculates the height of the BST recursively. The height of an empty tree is -1, and for non-empty trees, it is the maximum height of its left and right subtrees plus 1.

4.Main Section: Takes user input for the number of nodes and their values using Scanner, builds the BST, and then calculates and prints the height of the BST.

<h2>CPP</h2>

```
//Copyrights to venkys.io
//For more information, visit https://venkys.io 

// Include necessary header file for input/output operations
#include <iostream>

// Define a class for a node in the Binary Search Tree (BST)
class Node {
public:
    int key;
    Node* left;
    Node* right;

    // Constructor to initialize a new node with a given key
    Node(int item) {
        key = item;
        left = right = nullptr;
    }
};

// Function to insert a key into the BST
Node* insert(Node* root, int key) {
    if (root == nullptr) {
        // If the tree is empty, create a new node with the given key
        return new Node(key);
    } else {
        if (key > root->key) {
            // If the key is greater than the current node's key, insert into the right subtree
            root->right = insert(root->right, key);
        } else {
            // If the key is less than or equal to the current node's key, insert into the left subtree
            root->left = insert(root->left, key);
        }
        return root;
    }
}

// Function to calculate the height of the BST
int height(Node* root) {
    if (root == nullptr) {
        // Base case: an empty tree has height -1
        return -1;
    } else {
        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(root->left);
        int rightHeight = height(root->right);
        // The height of the tree is the maximum of the heights of its left and right subtrees, plus 1
        return 1 + std::max(leftHeight, rightHeight);
    }
}

// Main function
int main() {
    // Input number of nodes in the BST
    // std::cout << "Enter the number of nodes in the BST: ";
    int numNodes;
    std::cin >> numNodes;

    Node* root = nullptr;

    // Input values of the nodes
    // std::cout << "Enter the values of the nodes:" << std::endl;
    for (int i = 0; i < numNodes; i++) {
        int value;
        std::cin >> value;
        // Insert each value into the BST
        root = insert(root, value);
    }

    // Calculate and print the height of the BST
    int bstHeight = height(root);
    std::cout <<  bstHeight << std::endl;

    return 0;
}

```
<h2>Step-by-Step Explanation</h2>

1.Include Header File: The #include <iostream> statement includes the necessary header file for input/output operations.

2.Node Class Definition: The Node class is defined with public attributes for the key, left child, and right child. The constructor initializes a node with a given key.

3.Insert Function: The insert function inserts a key into the BST by recursively navigating the tree based on key values.

4.Height Function: The height function calculates the height of the BST recursively. The height of an empty tree is -1, and for non-empty trees, it is the maximum height of its left and right subtrees plus 1.

5.Main Function: The main function takes user input for the number of nodes and their values, builds the BST, and then calculates and prints the height of the BST using std::cout and std::cin.

<h2>Time Complexity:</h2>
The time complexity of the heightBST function is O(n), where n is the number of nodes in the binary tree. This is because, in the worst case, the function visits every node in the tree once.

Here's why the time complexity is O(n):

The function makes a recursive call for each node in the tree (both left and right children).
The recursion explores the entire tree by visiting each node once.

<h2>Space Complexity:</h2>
The space complexity of the program is determined by the space used by the call stack during the recursive function calls. Each function call consumes space on the call stack.

In the worst case, when the tree is highly unbalanced (again, a linked list), the space complexity of the program is O(n). This is because the recursive calls can stack up to a depth of n, where n is the number of nodes in the tree.

<h2>Real-World Applications of Binary Search Tree</h2>

**1.Optimizing Search Engines:** Search engines use various data structures to index and retrieve web pages efficiently. The height of these data structures impacts the speed of search and retrieval operations, which is critical for real-time search engines.

**2.Database Indexing and Query Optimization:** In real-time database systems, the height of a BST index can affect the efficiency of data retrieval. A well-balanced tree ensures faster queries as the height is minimized, reducing the number of I/O operations needed to access data.

**3.File Systems:** The height of directory structures in file systems can impact the speed of file and directory lookup operations. In real-time file management, minimizing the height of the directory tree is essential for quick access.

**4.Network Routing:** The height of routing tables in network routers can impact the speed of packet forwarding in real-time networks. Balanced routing tables ensure efficient and low-latency data transmission.

## Test Cases

- Input:
  7
  50
  30
  70
  20
  40
  60
  80

  Output:
  3

  Explanation:
  The provided input constructs a Binary Search Tree (BST) with the following structure:
         50
        /  \
       30   70
      / \   / \
     20 40 60 80
  The height of this BST is calculated as follows:
  The height of the left subtree rooted at 30 is 2 (depth of 20 or 40).
  The height of the right subtree rooted at 70 is 2 (depth of 60 or 80).
  Since the height of the BST is defined as the maximum height of its left and right subtrees, the height of this BST is max(2, 2) + 1 = 3.
  Therefore, the output is 3, indicating the height of the constructed BST.

- Input:
  5
  40
  30
  50
  20
  60
  Output:
  2

  Explanation:
  The provided input constructs a Binary Search Tree (BST) with the following structure:
         40
        /  \
       30   50
      /       \
     20       60
  The height of this BST is calculated as follows:
  The height of the left subtree rooted at 30 is 1 (depth of 20).
  The height of the right subtree rooted at 50 is 1 (depth of 60).
  Since the height of the BST is defined as the maximum height of its left and right subtrees, the height of this BST is max(1, 1) + 1 = 2.
  Therefore, the output is 2, indicating the height of the constructed BST.
