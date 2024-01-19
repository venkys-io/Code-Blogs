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
            // If the data is less than the current node's data, insert into the left
            // subtree
            root.left = insertBST(root.left, data);
        } else {
            // If the data is greater than the current node's data, insert into the right
            // subtree
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
