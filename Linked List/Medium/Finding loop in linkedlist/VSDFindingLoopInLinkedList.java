import java.util.*;

public class VSDFindingLoopInLinkedList {
    // Class to hold the structure of a node
    private static class VSDNode {
        int data;        // data of node
        VSDNode next;    // pointer to next element in the list

        VSDNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static VSDNode head = null;

    // Function to insert elements into the linked list
    public static void VSDinsert(int element) {
        VSDNode temp = new VSDNode(element); // creating a new node with the given data
        if (head == null)
            head = temp; // inserting the first element as head
        else {
            VSDNode x = head;
            while (x.next != null) {
                x = x.next;
            }
            x.next = temp; // inserting node at the end of the linked list
        }
    }

    // Function to check whether a loop exists in the linked list
    public static boolean VSDfindLoop() {
        VSDNode slow = head;
        VSDNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Move one step at a time
            fast = fast.next.next;    // Move two steps at a time

            if (slow == fast) {
                return true;  // If there is a loop, slow and fast will meet at some point
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the linked list:");

        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            VSDinsert(element);
        }

        // Asking the user whether to create a loop
        System.out.println("Do you want to create a loop in the linked list? (yes/no)");
        String createLoop = scanner.next();

        if (createLoop.equalsIgnoreCase("yes")) {
            // Creating a loop by making the last node point to the head
            VSDNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = head;
        }

        boolean hasLoop = VSDfindLoop();

        if (hasLoop)
            System.out.println("The linked list contains a loop");
        else
            System.out.println("The linked list does not contain a loop");

        scanner.close();
    }
}

