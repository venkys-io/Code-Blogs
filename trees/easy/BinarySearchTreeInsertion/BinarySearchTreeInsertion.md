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
    def __init__(self,data):
        self.data=data 
        self.left=self.right=None 

def insertBST(root,data):

    if root is None:
    
        return Node(data)
    if root.data==data:
        return root 
    elif data<root.data:
        root.left=insertBST(root.left,data)
    else:
        root.right=insertBST(root.right,data)
    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(root.data,end=" ")
        inorder(root.right)


if __name__=="__main__":
    arr = list(map(int, arr_input.split()))
    root=None 
    for i in arr:
        root=insertBST(root,i)
    inorder(root)
``````
## Code in Java
```
// Copyrights to venkys.io
// For more information, visit https://venkys.io
import java.util.Scanner;
   class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}

public class Main{

    static Node insertBST(Node root,int data){
        if(root==null) return new Node(data);
        if(root.data==data) return root;
        else if(data<root.data) root.left=insertBST(root.left,data);
        else root.right=insertBST(root.right,data);
        return root;
    }
    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        // Split the input string into an array of strings
        String[] numbers = input.split(" ");
        
        // Create an array to store the parsed integers
        int[] arr = new int[numbers.length];
        
        // Parse each string into an integer and store it in the array
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        
        Node root=null;
        for(int i:arr){
            root=insertBST(root,i);
        }
        inorder(root);
        // Close the scanner
        scanner.close();
    }
}

``` 
## Code in C++

```
/* Copyrights to venkys.io  */
/* For more information, visit https://venkys.io */
#include<bits/stdc++.h>
#include <iostream>

class Node{
    public:
        int data;
        Node *left=NULL;
        Node *right=NULL;

        Node(int val){
            data=val;
        }
};


Node* insertBST(Node* root,int data){
    if(root==NULL) return new Node(data);
    if(root->data==data) return root;
    else if(data<root->data) root->left=insertBST(root->left,data);
    else root->right=insertBST(root->right,data);
    return root;
}

void inorder(Node* root){
    if(root!=NULL){
        inorder(root->left);
        std::cout<<root->data<<" ";
        inorder(root->right);
    }
}

int main(){
    const int SIZE = 6; // Assuming array size is fixed
    
    int arr[SIZE];
    
    // Input loop to populate the array
    for (int i = 0; i < SIZE; ++i) {
        std::cin >> arr[i];
    }
    
    Node* root=NULL;
    for(int i=0;i<sizeof(arr)/sizeof(arr[0]);i++){
        root=insertBST(root,arr[i]);
    }
    inorder(root);
    return 0;
}

```
## Code explanation 
 ### Node Class:

- Represents a node in the Binary Search Tree (BST).
It has an integer data, and pointers to the left (left) and right (right) children.
insertBST Function:

- Inserts a new node with the given data into the Binary Search Tree.
- If the tree is empty (root == NULL), it creates a new node with the given data.
- If the data to be inserted is equal to the current node's data, it returns the current node.
- If the data is less than the current node's data, it recursively inserts into the left subtree.
- If the data is greater, it recursively inserts into the right subtree.

  Returns the modified root.
inorder Function:

- Performs an inorder traversal of the Binary Search Tree.
Prints the data of each node in ascending order.

- main Function:

  Creates an array arr containing integers.
  Initializes the BST (root) to NULL.
  Iterates through the array and inserts each element into the BST using the insertBST function.
  Prints the inorder traversal of the BST using the inorder function.
  ## Time and space complexity
  ### Time Complexity:

- Worst Case (Unbalanced Tree): O(n)

- Average Case (Balanced Tree): O(log n)

### Space Complexity:

- Worst Case (Unbalanced Tree): O(n)

- Average Case (Balanced Tree): O(log n)

### Real World Applications

- Database Indexing:

  In a database system, indexes are often implemented using BSTs. Each node in the BST corresponds to a record in the database, and the BST is constructed based on a particular field (e.g., primary key, indexed column).
  For example, in a database of student records, if the records are indexed based on student ID, a BST can efficiently store and retrieve records based on their IDs.

- File System Structure:

  File systems often use BSTs for directory structures. Each node represents a directory, and the left child represents a subdirectory with a lower name, while the right child represents a subdirectory with a higher name.
  For instance, in a file system, a directory structure can be represented using a BST, where each directory can have subdirectories arranged in alphabetical order.

- Organizational Hierarchy:
  BSTs can represent organizational hierarchies efficiently. Each node can represent an employee, and the left child can represent a subordinate with a lower rank, while the right child represents a subordinate with a higher rank.
  For instance, in a company's organizational chart, employees can be organized in a BST based on their hierarchical positions, with managers at higher levels and their subordinates at lower levels.

- Dictionary or Phonebook:
  A dictionary or a phonebook can be implemented using a BST, where each node represents a word or a name, and the left child represents a word/name with a lower alphabetical order, while the right child represents a word/name with a higher alphabetical order.
  When searching for a word or a name, the BST allows for efficient retrieval based on alphabetical order.

- Symbol Tables in Compilers:
  BSTs are commonly used to implement symbol tables in compilers. Each node represents a variable or a function, and the left child represents a symbol with a lower identifier, while the right child represents a symbol with a higher identifier.
  Symbol tables are essential for compilers to manage identifiers, such as variables and functions, during the compilation process.

### Test Cases:

- Input: arr_input = "50 20 30 70 40 10"
  Output: 10 20 30 40 50 70

  Explanation:
  The input represents the integers to be inserted into the BST: 50, 20, 30, 70, 40, and 10.
  After insertion, the BST structure becomes:
  
     50
    /  \
  20   70
  / \   
10  30
    \
    40
  Inorder traversal of the BST gives the sorted sequence of nodes' data: 10, 20, 30, 40, 50, 70. So, the expected output is 10 20 30 40 50 70.

- Input: arr_input = "40 20 60 10 30 50 70"
  Output: 10 20 30 40 50 60 70

  Explanation:
  The input represents the integers to be inserted into the BST: 40, 20, 60, 10, 30, 50, and 70.
  After insertion, the BST structure becomes:
  
      40
     /  \
   20    60
  / \    / \
10  30  50  70
  Inorder traversal of the BST gives the sorted sequence of nodes' data: 10, 20, 30, 40, 50, 60, 70. So, the expected output is 10 20 30 40 50 60 70.

