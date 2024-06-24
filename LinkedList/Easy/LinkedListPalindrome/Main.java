import java.util.Scanner;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    // Function to create a linked list from an array of values
    static Node createList(int[] values) {
        Node head = null, temp = null;
        for (int value : values) {
            if (temp == null) {
                temp = new Node(value);
                head = temp;
            } else {
                temp.next = new Node(value);
                temp = temp.next;
            }
        }
        return head;
    }

    // Function to check if a linked list is a palindrome
    static boolean checkPalindrome(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();

        // Push elements of the first half onto the stack
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        // Compare the second half with the elements popped from the stack
        while (temp != null) {
            if (temp.data != stack.pop()) return false;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter values for the linked list
        System.out.print("Enter elements of the linked list separated by spaces: ");
        String userInput = scanner.nextLine();
        String[] valuesString = userInput.split(" ");

        // Convert the input values to integers
        int[] values = new int[valuesString.length];
        for (int i = 0; i < valuesString.length; i++) {
            values[i] = Integer.parseInt(valuesString[i]);
        }

        // Create the linked list
        Node head = createList(values);

        // Check if the linked list is a palindrome
        boolean result = checkPalindrome(head);

        // Print the result
        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
