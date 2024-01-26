package Sorting.Hard.MaxHeapSort;

import java.util.Scanner;

public class maxsort {
    // Class to hold the structure of a node in a tree
    public static class Node {
        int data; // Holds the value of the node
        Node left; // Holds the left pointer of the node
        Node right; // Holds the right pointer of the node

        // Default constructor
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Root node
    public static Node root = null;

    // Variable to hold the count of left nodes
    public static int leftcount = 0;

    // Variable to hold the count of right nodes
    public static int rightcount = 0;

    // Variable to maintain the count of nodes in the heap for appropriate deletion
    public static int deletecount = 0;

    // Variable to hold the appropriate child node for deletion
    public static Node deletenode = null;

    // Variable to hold the parent of the child to be deleted
    public static Node parent = null;

    // Method to Build Heap along with maintenance of a complete binary tree
    public static Node VSDbuildHeap(Node root, Node newNode) {
        if (root == null)
            root = newNode; // Null check
        else if (root.left != null && root.right != null) // Checking whether both left and right children are present
                                                            // for the root
        {
            leftcount = VSDsubtreeCount(root.left); // Getting left nodes count from the left of the current root
            rightcount = VSDsubtreeCount(root.right); // Getting right nodes count from the right of the current root

            int height = VSDfindHeight(root); // Getting the height of the tree
            // Checking for the correct position to insert
            if (leftcount < (VSDexpectedCount(height) / 2)) {
                VSDbuildHeap(root.left, newNode);
            } else if (leftcount == rightcount)
                VSDbuildHeap(root.left, newNode);
            else
                VSDbuildHeap(root.right, newNode);
        } else if (root.left == null) {
            root.left = newNode;

        } else if (root.right == null) {
            root.right = newNode;

        }

        return root;
    }

    // Function to maintain max heap properties
    public static Node VSDHeapify(Node current) {
        if (current.left != null)
            current.left = VSDHeapify(current.left);
        if (current.right != null)
            current.right = VSDHeapify(current.right);
        if (current.left != null && current.left.data > current.data) {
            int temp = current.left.data;
            current.left.data = current.data;
            current.data = temp;

        }
        if (current.right != null && current.right.data > current.data) {
            int temp = current.right.data;
            current.right.data = current.data;
            current.data = temp;
        }
        return current;
    }

    // Function to return the expected node count for a given height
    public static int VSDexpectedCount(int h) {
        int count = 0;
        while (h >= 0) {
            count += Math.pow(2, h);
            h--;
        }
        return count;
    }

    // Function to return the node count for a given subtree
    public static int VSDsubtreeCount(Node current) {
        int leftheight = 0; // variable to hold the height of the left subtree
        int rightheight = 0; // variable to hold the height of the right subtree
        // Traversing to the left subtree to find the max height
        if (current.left != null) {
            leftheight = VSDsubtreeCount(current.left);
        }
        // Traversing to the right subtree to find the max height
        if (current.right != null) {
            rightheight = VSDsubtreeCount(current.right);
        }
        // Selecting the maximum height and adding 1 for root's height
        int count = rightheight + leftheight + 1;
        return count;
    }

    // Function to return the height of the tree
    public static int VSDfindHeight(Node current) {
        if (current == null)
            return -1;
        else {
            int lh = VSDfindHeight(current.left);
            int rh = VSDfindHeight(current.right);

            if (lh > rh)
                return (lh + 1);
            else
                return (rh + 1);
        }
    }

    // Function to display elements in max heap using inorder traversal
    public static void VSDinorder(Node root) {
        if (root.left != null)
            VSDinorder(root.left);
        System.out.println(root.data);
        if (root.right != null)
            VSDinorder(root.right);
    }

    /* Function to choose the most recently inserted element based on count */
    public static void VSDchooseNode(Node current, int level, int size) {
        if (current == null) {
            return;
        }
        if (level == 0) {
            deletecount++;
            if (deletecount == size / 2) {
                parent = current;
            }
            if (deletecount == size) {
                deletenode = current;
                return;
            }
        } else if (level > 0) {

            VSDchooseNode(current.left, level - 1, size);
            VSDchooseNode(current.right, level - 1, size);
        }

    }

    // Function to delete the root node from the heap
    public static Node VSDdeleteNode(Node root, int height, int size) {
        // Obtain the correct child node to replace with the root
        for (int i = 0; i <= height; i++) {
            VSDchooseNode(root, i, size);
        }
        int temp = root.data;
        root.data = deletenode.data;
        deletenode.data = temp;
        // Deleting the node
        if (parent.right != null)
            parent.right = null;
        else
            parent.left = null;
        // calling heapify to maintain max heap properties
        root = VSDHeapify(root);
        return root;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the heap:");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements separated by space:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        Node n;
        root = null;
        for (int i = 0; i < arr.length; i++) {
            n = new Node(arr[i]);
            root = VSDbuildHeap(root, n);
            root = VSDHeapify(root); // Calling function to maintain max heap properties
        }

        System.out.println("Insertion");
        VSDinorder(root);

        System.out.println("The descending order is:");
        while (size > 1) {
            deletecount = 0;
            System.out.println(root.data);
            int height = VSDfindHeight(root);
            root = VSDdeleteNode(root, height, size);
            size--;
        }
        System.out.println(root.data);

        scanner.close();
    }
}