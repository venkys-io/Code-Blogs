<h1> LEAF SUM OF BST</h1>
A Binary Search Tree (BST) is a type of binary tree data structure that follows a specific ordering property. In a BST, for every node, all the values in its left subtree are less than the node's value, and all the values in its right subtree are greater than the node's value. This ordering property allows for efficient searching, insertion, and deletion operations. The leaf sum of a BST refers to the sum of all the leaf nodes in the tree. These leaf nodes are the nodes that do not have any children. Computing the leaf sum of a BST can be done by traversing the tree and adding up the values of the leaf nodes.

<h2> INTRODUCTION</h2>

The leaf sum of a Binary Search Tree (BST) is a mathematical concept that refers to the sum of all the leaf nodes in the tree. In a BST, leaf nodes are the nodes that do not have any children. Computing the leaf sum involves traversing the BST and adding up the values of these leaf nodes.

The leaf sum is an important measure as it provides insights into the overall structure and distribution of values in the tree. By calculating the leaf sum of a BST, we can gain a better understanding of its characteristics and make informed decisions based on the resulting sum. It allows us to analyze the distribution of values within the tree and identify patterns or outliers.

The leaf sum can be used to evaluate the efficiency and performance of a BST. A higher leaf sum may indicate a well-balanced tree with evenly distributed values, while a lower leaf sum may suggest an uneven distribution of values or an unbalanced tree. This information can be helpful in optimizing the BST and improving its performance.

Furthermore, the leaf sum can be used to compare different BSTs and determine which one is more suitable for a specific task or problem. By comparing the leaf sums of different trees, we can identify the tree with a higher leaf sum, indicating a larger total value of leaf nodes. This can be advantageous in scenarios where the sum of leaf nodes is of particular interest or importance.

<h2> Code In python: </h2>

```
# Define a Node class representing a node in a binary tree
class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

# Method to perform a Visiting-Subtree-Data (VSD) traversal and calculate leaf sum
def VSDleafsum(root):
    global s  # Global variable to store the leaf sum
    if not root:
        return

    # Check if the current node is a leaf (has no left and right children)
    if not root.left and not root.right:
        s += root.data  # Add the data of the leaf node to the leaf sum

    # Recursively perform VSDleafsum on the left and right subtrees
    VSDleafsum(root.left)
    VSDleafsum(root.right)

# Main block for testing the leaf sum calculation
if __name__ == "__main__":
    # Create a sample binary tree
    root = Node(10)
    root.left = Node(20)
    root.right = Node(30)
    root.left.left = Node(40)
    root.left.right = Node(50)
    root.right.left = Node(60)
    root.right.right = Node(70)

    global s
    s = 0  # Reset the leaf sum variable

    # Calculate leaf sum using VSDleafsum method
    VSDleafsum(root)
```

<h3> OUTPUT: 220</h3>

<h2> STEP BY STEP EXPLANATION </h2>

Define a Node class:

- The code starts by defining a class called Node which represents the nodes of a binary tree.
- Each node has three attributes: data to store the value of the node, and left and right to store references to the left and right children. Initially, both left and right are set to None.
1. Define the VSDleafsum function:
    
    This function is used to calculate the sum of leaf nodes in a binary tree.
    
    It takes the root of the binary tree as an argument.
    
2. Inside the VSDleafsum function:
    
    Check if root is None:
    
    If the root is None, this means we've reached the end of a branch in the tree, so the function returns, as there are no more nodes to process.
    
    Check if root is a leaf node:
    
    If the root has no left and no right child (i.e., it's a leaf node), the value of that leaf node (root.data) is added to the global variable s.
    
    Recursively call VSDleafsum for left and right subtrees:
    
    The function then recursively calls itself on the left and right subtrees of the current root node. This recursion continues until all leaf nodes have been processed.
    
3. Main program:
    
    In the if __ name __ ==”__main__”: block, the main program logic is defined.
    
    You create a binary tree with various nodes and values.
    
    You initialize a global variable s to 0. This variable will be used to accumulate the sum of leaf nodes.
    
4. Calculate the sum of leaf nodes:
    
    You call the VSDleafsum function with the root of the binary tree as the argument. This function will recursively traverse the tree and accumulate the sum of leaf nodes in the global variable s.
    
5. Print the sum of leaf nodes:
    
    After the VSDleafsum function has finished executing, you print the value of the global variable s, which now contains the sum of all the leaf nodes in the binary tree.
    
    When you run this code, it will calculate the sum of leaf nodes in the binary tree you defined in the   main section and print the result, which will be the sum of the values of all the leaf nodes in the tree.
    

<h2>Time And Space Complexity Analysis</h2>


  Time Complexity:

  The VSDleafsum function is called on each node in the tree, including leaf nodes.

The time complexity of the code is determined by the depth-first traversal of the binary tree. In the worst case, the algorithm visits every node exactly once.

The time complexity is O(N), where N is the number of nodes in the binary tree.

Space Complexity:

The space complexity of the code is determined by the call stack during the recursive traversal, and the global variable s.

The call stack will grow with the depth of the tree, and in the worst case, it could be O(N) if the tree is skewed.

Additionally, the global variable s takes a constant amount of space.

The overall space complexity is O(N) in the worst case for both the call stack and the global variable.

In summary:

- Time Complexity: O(N) where N is the number of nodes in the binary tree.
- Space Complexity: O(N) in the worst case, primarily due to the recursive call stack and the global variable.

<h2>Real-World Applications Of Leaf Sum Of BST</h2>

1. File System Analysis:
    
    When analyzing a file system or directory structure, you can construct a tree where leaf nodes represent individual files or directories. Summing up the file sizes in leaf nodes can give you the total size of specific folders or subdirectories.
    
2. Financial Analysis:
    
    In financial applications, decision trees or binary trees can be used for options pricing, risk assessment, or portfolio management. The leaf nodes may represent various financial scenarios or investment choices, and you might want to aggregate values across leaf nodes.
    
3. Database Query Optimization:
    
    In database management systems, query optimization can involve evaluating different query execution plans represented as trees. Calculating the costs associated with leaf nodes can help determine the most efficient query plan.
    
4. Image Processing:
    
    In image processing, quad trees or other tree structures can be used to represent image regions. The sum of pixel values in leaf nodes may be used for tasks such as image compression or feature extraction.
    
5. Network Topology:
    
    When modeling network topologies or hierarchies in telecommunications, leaf nodes can represent individual network devices or endpoints. Summing metrics at leaf nodes can provide information about network performance.
    
6. Resource Allocation in Distributed Systems:
    
    When allocating resources in distributed systems, trees can represent the allocation hierarchy. Leaf nodes may represent individual resources, and calculating their total usage or cost can help manage resource allocation efficiently.
    
    <h2> CODE IN JAVA: </h2>
    
    ```
    // Define a Node class representing a node in a binary tree
    class Node {
        int data;
        Node left, right;
    
        // Constructor to initialize a node with given data and null left and right pointers
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    
    // LeafSumCalculator class contains methods to calculate the leaf sum of a binary tree
    public class LeafSumCalculator {
        // Static variable to store the leaf sum
        static int s = 0;
    
        // Method to perform a Visiting-Subtree-Data (VSD) traversal and calculate leaf sum
        public static void VSDleafsum(Node root) {
            // Base case: if the current node is null, return
            if (root == null) {
                return;
            }
    
            // Check if the current node is a leaf (has no left and right children)
            if (root.left == null && root.right == null) {
                // Add the data of the leaf node to the leaf sum
                s += root.data;
            }
    
            // Recursively perform VSDleafsum on the left and right subtrees
            VSDleafsum(root.left);
            VSDleafsum(root.right);
        }
    
        // Main method for testing the LeafSumCalculator
        public static void main(String[] args) {
            // Create a sample binary tree
            Node root = new Node(10);
            root.left = new Node(20);
            root.right = new Node(30);
            root.left.left = new Node(40);
            root.left.right = new Node(50);
            root.right.left = new Node(60);
            root.right.right = new Node(70);
    
            // Reset the leaf sum variable
            s = 0;
    
            // Calculate leaf sum using VSDleafsum method
            VSDleafsum(root);
    
            // Print the calculated leaf sum
            System.out.println(s);
        }
    }
    ```
    

<h3> OUTPUT: 220 </h3>

<h2> STEP BY STEP EXPLANATION: </h2>

1. Node Class Definition:
    
    Define a Node class to represent the nodes of a binary tree.
    
    Each Node has three attributes: data to store the value of the node, and left and right to store references to the left and right children. Initially, both left and right are set to null.
    
    LeafSumCalculator class and VSDleafsum
    
    Method:
    
    Define a class called LeafSumCalculator where we'll put our main logic.
    
    Inside this class, create a static integer variable s to store the sum of leaf nodes.
    
    Define a static method VSDleafsum to calculate the sum of leaf nodes in a binary tree.
    
    The method takes a Node (the root of the tree) as an argument.
    
    1. Main Program:
    
    In the m**ain** method of the LeafSumCalculator class, we create a binary tree by creating nodes and linking them.
    
      3. Initialize the global variable s to 0. This variable will store the sum of leaf nodes.
    
     Call the VSDleafsum method to calculate the sum of leaf nodes. This function will                                                                       recursively traverse the tree and accumulate the sum in the global variable s.
    
    <h2>Time And Space Complexity Analysis</h2>
    
    Time Complexity:
    
    The VSDleafsum function is called on each node in the tree, including leaf nodes.
    
    The time complexity of the code is determined by the depth-first traversal of the binary tree. In the worst case, the algorithm visits every node exactly once.
    
    The time complexity is O(N), where N is the number of nodes in the binary tree.
    
    Space Complexity:
    
    The space complexity of the code is determined by the call stack during the recursive traversal, and the global variable s.
    
    The call stack will grow with the depth of the tree, and in the worst case, it could be O(N) if the tree is skewed.
    
    Additionally, the global variable s takes a constant amount of space.
    
    The overall space complexity is O(N) in the worst case for both the call stack and the global variable.
    
    In summary:
    
    - Time Complexity: O(N) where N is the number of nodes in the binary tree.
    - Space Complexity: O(N) in the worst case, primarily due to the recursive call stack and the global variable.

<h2>Real-World Applications Of Leaf Sum Of BST:</h2>

1. File System Analysis:
    
    When analyzing a file system or directory structure, you can construct a tree where leaf nodes represent individual files or directories. Summing up the file sizes in leaf nodes can give you the total size of specific folders or subdirectories.
    
2. Financial Analysis:
    
    In financial applications, decision trees or binary trees can be used for options pricing, risk assessment, or portfolio management. The leaf nodes may represent various financial scenarios or investment choices, and you might want to aggregate values across leaf nodes.
    
3. Database Query Optimization:
    
    In database management systems, query optimization can involve evaluating different query execution plans represented as trees. Calculating the costs associated with leaf nodes can help determine the most efficient query plan.
    
4. Image Processing:
    
    In image processing, quad trees or other tree structures can be used to represent image regions. The sum of pixel values in leaf nodes may be used for tasks such as image compression or feature extraction.
    
5. Network Topology:
    
    When modeling network topologies or hierarchies in telecommunications, leaf nodes can represent individual network devices or endpoints. Summing metrics at leaf nodes can provide information about network performance.
    
6. Resource Allocation in Distributed Systems:
    
    When allocating resources in distributed systems, trees can represent the allocation hierarchy. Leaf nodes may represent individual resources, and calculating their total usage or cost can help manage resource allocation efficiently.

<h2> Code In C++: </h2>

``` 
#include <iostream>

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Function to calculate the leaf sum of a BST
int leafSum(TreeNode* root) {
    // If the current node is null, return 0
    if (root == nullptr) {
        return 0;
    }
    
    // If the current node is a leaf, return its value
    if (root->left == nullptr && root->right == nullptr) {
        return root->val;
    }

    // Recursively calculate leaf sum for left and right subtrees
    int leftSum = leafSum(root->left);
    int rightSum = leafSum(root->right);

    // Return the sum of left and right leaf sums
    return leftSum + rightSum;
}

int main() {
    // Example of constructing a BST
    TreeNode* root = new TreeNode(10);
    root->left = new TreeNode(5);
    root->right = new TreeNode(15);
    root->left->left = new TreeNode(3);
    root->left->right = new TreeNode(7);
    root->right->right = new TreeNode(18);

    // Calculate and display the leaf sum
    int result = leafSum(root);
    std::cout << "Leaf Sum of BST: " << result << std::endl;

    // Don't forget to free the allocated memory
    // This is a simplified example; in a real application, you might use smart pointers or other memory management techniques.
    delete root->left->left;
    delete root->left->right;
    delete root->right->right;
    delete root->left;
    delete root->right;
    delete root;

    return 0;
}

```
    
 <h2> STEP BY STEP EXPLANATION: </h2>
    
  1.Include necessary headers:
    
  #include <iostream>: This line includes the Input/Output Stream Library, allowing us to use functions like std::cout for output.
    Define a structure for binary tree nodes:
    
  2.struct TreeNode: Defines a structure named TreeNode to represent nodes in a binary tree.
    int val: Represents the value of the node.
    TreeNode* left and TreeNode* right: Pointers to the left and right children of the node, respectively.
    TreeNode(int x): Constructor for initializing a TreeNode with a given value x.
    Define the function to calculate leaf sum:
    
  3.int leafSum(TreeNode* root): Takes a pointer to the root of a binary tree (BST) as a parameter and returns an integer.
    If the current node is null (base case for recursion), returns 0.
    If the current node is a leaf (has no left and right children), returns its value.
    Recursively calculates the leaf sum for the left and right subtrees using the leafSum function.
    Returns the sum of the left and right leaf sums.
    In the main function:
    
  4.Creates an example Binary Search Tree (BST) by dynamically allocating nodes using the new keyword.
    Calculates the leaf sum of the BST using the leafSum function.
    Prints the result using std::cout.
    Memory Deallocation:
    
   5.delete statements are used to free the dynamically allocated memory to prevent memory leaks.
    In a real application, smart pointers or other memory management techniques might be used for a more robust solution.
    
   6.Return Statement:
    
   return 0;: Indicates successful program execution to the operating system.
    
  <h2>Time And Space Complexity Of BST:</h2>
  
    
  1.Time Complexity:
    
  The time complexity of the leafSum function is O(n), where "n" is the number of nodes in the binary tree.
    The function traverses each node exactly once, and the work done at each node is constant.
    The recursion visits every node in the tree, so the time complexity is linear in terms of the number of nodes.
    
  2.Space Complexity:
    
  The space complexity of the leafSum function is O(h), where "h" is the height of the binary tree.
    In the worst case, the function's call stack would have to store information for each recursive call, and the maximum depth of the call stack is the height of the tree.
    In the average case, for a balanced binary search tree, the height is log(n) where "n" is the number of nodes. Therefore, the space complexity is O(log(n)).
    In the worst case, for an unbalanced binary search tree, the height could be as much as "n," and the space complexity would be O(n).
    The space complexity also depends on the system's memory allocation for function calls and the actual structure of the tree.
    In summary, the time complexity is O(n), and the space complexity is O(h) in the average case and O(n) in the worst case, where "n" is the number of nodes and "h" is the height of the binary tree.
    
   <h2>Real-World Applications Of BST:</h2>
    
     
    
  1. File System Analysis:
        
        When analyzing a file system or directory structure, you can construct a tree where leaf nodes represent individual files or directories. Summing up the file sizes in leaf nodes can give you the total size of specific folders or subdirectories.
        
  2. Financial Analysis:
        
        In financial applications, decision trees or binary trees can be used for options pricing, risk assessment, or portfolio management. The leaf nodes may represent various financial scenarios or investment choices, and you might want to aggregate values across leaf nodes.
        
  3. Database Query Optimization:
        
        In database management systems, query optimization can involve evaluating different query execution plans represented as trees. Calculating the costs associated with leaf nodes can help determine the most efficient query plan.
        
  4. Image Processing:
        
        In image processing, quad trees or other tree structures can be used to represent image regions. The sum of pixel values in leaf nodes may be used for tasks such as image compression or feature extraction.
        
  5. Network Topology:
        
        When modeling network topologies or hierarchies in telecommunications, leaf nodes can represent individual network devices or endpoints. Summing metrics at leaf nodes can provide information about network performance.
        
  6. Resource Allocation in Distributed Systems:
        
        When allocating resources in distributed systems, trees can represent the allocation hierarchy. Leaf nodes may represent individual resources, and calculating their total usage or cost can help manage resource allocation efficiently.
