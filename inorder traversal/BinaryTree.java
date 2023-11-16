class TreeNode {
    int data; 
    // Store integer data
    TreeNode left = null,         
    // Left child reference
             right = null;         
    // Right child reference

    public TreeNode(int data) {   
     // Constructor to create a new TreeNode
        this.data = data;           
    // Assign the given data to this node
    }
}

public class BinaryTree {
// Method for inorder traversal

    static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {

        // Creating a binary tree with root node having data 10
        TreeNode root = new TreeNode(10);

        // Adding nodes to the root of the created binary tree
        // Adding left and right child nodes to the root
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);

        // Adding left and right child nodes to the left child of the root
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);

        // Adding left and right child nodes to the right child of the root
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);

        // Printing the message before performing inorder traversal
        System.out.print("Inorder Traversal: ");

        // Calling the inorderTraversal method to perform inorder traversal
        inorderTraversal(root);
    }
}