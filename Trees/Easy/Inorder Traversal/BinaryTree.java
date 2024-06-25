import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left = null; // Left child reference
    TreeNode right = null; // Right child reference

    // Constructor to create a new TreeNode
    public TreeNode(int data) {
        this.data = data; // Assign the given data to this node
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
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the series of numbers
        System.out.println("Enter a series of numbers separated by spaces:");
        String input = scanner.nextLine();
        String[] values = input.split("\\s+");

        // Convert the string values to integers
        int[] intValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            intValues[i] = Integer.parseInt(values[i]);
        }

        // Build the binary tree using the series of numbers
        TreeNode root = buildBinaryTree(intValues, 0);

        // Printing the message before performing inorder traversal
        System.out.print("Inorder Traversal: ");

        // Calling the inorderTraversal method to perform inorder traversal
        inorderTraversal(root);

        // Close the scanner
        scanner.close();
    }

    // Method to build the binary tree using the series of numbers
    static TreeNode buildBinaryTree(int[] values, int index) {
        TreeNode node = null;
        if (index < values.length) {
            // Create a new node with the current value
            node = new TreeNode(values[index]);

            // Recursively build the left and right subtrees
            node.left = buildBinaryTree(values, 2 * index + 1);
            node.right = buildBinaryTree(values, 2 * index + 2);
        }
        return node;
    }
}
