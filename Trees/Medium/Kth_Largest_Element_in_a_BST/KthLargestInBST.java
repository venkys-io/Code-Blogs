/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(H)
//Time complexity: O(H + K)

import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class KthLargestInBST {
    private int count = 0;
    private int result = -1;

    /**
     * Finds the kth largest element in a Binary Search Tree (BST).
     *
     * root -- The root of the BST.
     *  k -- The value of k for finding the kth largest element.
     * return The kth largest element in the BST.
     */
    public int kthLargest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return result;
    }

    /**
     * Performs an inorder traversal of the BST to find the kth largest element.
     *
     * node -- The current node during the traversal.
     */
    private void inorderTraversal(TreeNode node) {
        if (node == null || count == 0) {
            return;
        }

        inorderTraversal(node.right);
        count--;

        if (count == 0) {
            result = node.val;
            return;
        }

        inorderTraversal(node.left);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the values for the tree nodes in a space-separated format (e.g., "5 3 7 2 -1 6 8").
        String[] nodeValues = scanner.nextLine().split(" ");
        TreeNode root = buildTree(nodeValues, 0);

        KthLargestInBST kthLargestInBST = new KthLargestInBST();

        // Input the value of k.
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        int result = kthLargestInBST.kthLargest(root, k);
        System.out.println("The " + k + "th largest element in the BST is: " + result);
    }

    private static TreeNode buildTree(String[] nodeValues, int index) {
        if (index >= nodeValues.length || nodeValues[index].equals("-1")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodeValues[index]));
        root.left = buildTree(nodeValues, 2 * index + 1);
        root.right = buildTree(nodeValues, 2 * index + 2);

        return root;
    }
}

