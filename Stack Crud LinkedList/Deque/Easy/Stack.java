import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Stack {
    Node top;

    // Push operation: Add a new node with the specified data to the top of the stack.
    void push(int data) {
        if (top == null) {
            // If the stack is empty, create the first node.
            top = new Node(data);
        } else {
            // If the stack is not empty, create a new node and update the top.
            Node temp = new Node(data);
            temp.next = top;
            top = temp;
        }
    }

    // Pop operation: Remove the top node from the stack.
    void pop() {
        if (top != null) {
            // If the stack is not empty, update the top to the next node.
            top = top.next;
        }
    }

    // Peek operation: Print the data of the top node without removing it.
    void peek() {
        if (top != null) {
            // If the stack is not empty, print the data of the top node.
            System.out.println("Peek: " + top.data);
        }
    }

    // Recursive print method: Print all elements in the stack from top to bottom.
    void printRecursive(Node temp) {
        if (temp != null) {
            printRecursive(temp.next);
            System.out.print(temp.data + " ");
        }
    }

    // Print operation: Print all the elements in the stack from top to bottom.
    void print() {
        if (top != null) {
            System.out.print("Stack elements: ");
            // Call the recursive print method to print elements.
            printRecursive(top);
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Print");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the value to push:");
                    int pushValue = scanner.nextInt();
                    stack.push(pushValue);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.print();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

