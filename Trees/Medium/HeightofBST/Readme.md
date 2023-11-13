<h1>FINDING THE HEIGHT OF A BINARY SEARCH TREE</h1>

A Binary Search Tree (BST) is a type of binary tree where each node has at most two children, referred to as the left child and the right child. The key property of a BST is that the value of each node in the left subtree is less than the value of the node itself, and the value of each node in the right subtree is greater than the value of the node itself. The BST is commonly used in computer science and is a fundamental data structure for organizing and retrieving data in a sorted manner.

<h2>INTRODUCTION TO HEIGHT OF BST</h2>

The height of a Binary Search Tree (BST) refers to the maximum number of edges in the longest path from the root node to a leaf node. It represents the depth or level of the tree. The height of a BST is an important factor as it affects the efficiency of various operations performed on the tree, such as search, insertion, and deletion.

A balanced BST, where the heights of the left and right subtrees do not differ by more than 1, ensures optimal performance for these operations. By maintaining a balanced BST, the height is minimized, resulting in faster and more efficient operations.

The height of an empty BST is considered to be -1, while a BST with only one node has a height of 0. As more nodes are added to the tree, the height increases. The worst-case scenario for the height of a BST is when the tree is completely unbalanced, resulting in a height of n-1, where n is the number of nodes in the tree.

<h2>CODE</h2>

```
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

#Space complexity: O(n)
#Time complexity: O(n)

# Define a Node class to represent nodes in a binary tree
class Node:
    def __init__(self, data):
        # Constructor to initialize a node with given data
        self.data = data
        self.left = self.right = None

# Function to calculate the height of a binary search tree (BST)
def heightBST(root):
    # Base case: if the root is None, the height is 0
    if not root:
        return 0
    
    # Recursive case: calculate the height of the left and right subtrees
    # and return the maximum height plus 1 (for the current level)
    return max(heightBST(root.left) + 1, heightBST(root.right) + 1)

# Main block to create a sample BST and print its height
if __name__ == "__main__":
    # Create a sample BST with the given structure
    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(50)
    root.right.left = Node(60)
    root.right.right = Node(70)

    # Print the height of the BST
    print(heightBST(root))

```
JAVA

```
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// Node class to represent nodes in a binary tree
class Node {
    int data;
    Node left = null, right = null;

    // Constructor to initialize a node with the given data
    Node(int data) {
        this.data = data;
    }
}

public class Main {
    // Function to calculate the height of a binary search tree (BST)
    static int heightBST(Node root) {
        // Base case: if the root is null, the height is 0
        if (root == null) return 0;

        // Recursive case: calculate the height of the left and right subtrees
        // and return the maximum height plus 1 (for the current level)
        return Math.max(heightBST(root.left) + 1, heightBST(root.right) + 1);
    }

    public static void main(String[] args) {
        // Create a sample BST with the given structure
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        // Print the height of the BST
        System.out.println(heightBST(root));
    }
}

```
CPP

```
#include<bits/stdc++.h>

// Node class to represent nodes in a binary tree
class Node {
public:
    int data;
    Node *left = NULL;
    Node *right = NULL;

    // Constructor to initialize a node with the given value
    Node(int val) {
        data = val;
    }
};

// Function to calculate the height of a binary search tree (BST)
int heightBST(Node* root) {
    // Base case: if the root is null, the height is 0
    if (!root) return 0;

    // Recursive case: calculate the height of the left and right subtrees
    // and return the maximum height plus 1 (for the current level)
    return std::max(heightBST(root->left) + 1, heightBST(root->right) + 1);
}

int main() {
    // Create a sample BST with the given structure
    Node* root = new Node(10);
    root->left = new Node(20);
    root->right = new Node(30);
    root->left->left = new Node(40);
    root->left->right = new Node(50);
    root->right->left = new Node(60);
    root->right->right = new Node(70);

    // Print the height of the BST
    std::cout << "Height of the BST: " << heightBST(root);
    }

```
<h2>Step-by-Step Explanation (Python)</h2>

1.Define the Node class:

The Node class is defined to represent nodes in a binary tree. Each node has three attributes:
Data: Stores a value associated with the node.
Left: Represents the left child of the node, initialized to None.
Right: Represents the right child of the node, also initialized to None.

2.Define the heightBST function:

The  heightBST function calculates the height of a binary tree rooted at the given root node.
The height of a binary tree is the maximum number of edges on the longest path from the root node to a leaf node.

3.Base Case - Check if root is None:

If the root is None, it means there are no nodes, so the function returns 0. This is the termination condition for the recursion.

4.Recursive Step - Calculate the height:

If the root is not None, the function recursively calculates the height of the left and right subtrees.
It calls heightBST(root.left) to calculate the height of the left subtree and adds 1 to account for the current node.
It also calls heightBST(root.right) to calculate the height of the right subtree and adds 1 to account for the current node.

5.Return the maximum height:

The max function is used to find the maximum height between the left and right subtrees. This step ensures that the height returned represents the longest path from the root.

6.In the if **name** == "**main**": block:

Create a sample Binary Search Tree by creating nodes and connecting them together.
The root node is initialized with a value of 10.
Child nodes are created and connected to root to form the BST structure.

7.Call heightBST function with the root node:

The heightBST function is called with the root node as an argument, which is the topmost node of the BST.

8.Print the calculated height:

The calculated height of the BST is printed using print.

<h2>OUTPUT</h2>

The code calculates the height of the provided BST and prints it. In this case, the BST is balanced, and the height is **3**.
<h2>Time and Space Complexity Analysis</h2>

Time Complexity:
The time complexity of the heightBST function is O(n), where n is the number of nodes in the binary tree. This is because, in the worst case, the function visits every node in the tree once.

Here's why the time complexity is O(n):

The function makes a recursive call for each node in the tree (both left and right children).
The recursion explores the entire tree by visiting each node once.

Space Complexity:
The space complexity of the program is determined by the space used by the call stack during the recursive function calls. Each function call consumes space on the call stack.

In the worst case, when the tree is highly unbalanced (again, a linked list), the space complexity of the program is O(n). This is because the recursive calls can stack up to a depth of n, where n is the number of nodes in the tree.

<h2>Real-World Applications of Binary Search Tree</h2>

**1.Optimizing Search Engines:** Search engines use various data structures to index and retrieve web pages efficiently. The height of these data structures impacts the speed of search and retrieval operations, which is critical for real-time search engines.

**2.Database Indexing and Query Optimization:** In real-time database systems, the height of a BST index can affect the efficiency of data retrieval. A well-balanced tree ensures faster queries as the height is minimized, reducing the number of I/O operations needed to access data.

**3.File Systems:** The height of directory structures in file systems can impact the speed of file and directory lookup operations. In real-time file management, minimizing the height of the directory tree is essential for quick access.

**4.Network Routing:** The height of routing tables in network routers can impact the speed of packet forwarding in real-time networks. Balanced routing tables ensure efficient and low-latency data transmission.
