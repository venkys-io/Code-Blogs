import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

class DoubleLinkedList {
    Node head;
    int size = 0;

    // Insertion operation (Create)
    void insert(int data) {
        if (head == null) {
            // If the list is empty, create a new node and set it as the head
            head = new Node(data);
        } else {
            // Otherwise, create a new node, update links, and set it as the new head
            Node temp = new Node(data);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    // Deletion operation (Delete)
    void delete() {
        if (head == null) {
            // If the list is empty, do nothing
            System.out.println("List is empty. Cannot delete.");
        } else {
            // Move the head to the next node, update links, and decrease the size
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            System.out.printl("Node deleted successfully.");
        }
    }

    // Display operation (Read)
    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Size operation (Read)
    void displaySize() {
        System.out.println("Size of the list: " + this.size);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoubleLinkedList doublyLinkedList = new DoubleLinkedList();

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Display Size");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data to insert:");
                    int dataToInsert = scanner.nextInt();
                    doublyLinkedList.insert(dataToInsert);
                    System.out.println("Node inserted successfully.");
                    break;

                case 2:
                    doublyLinkedList.delete();
                    break;

                case 3:
                    System.out.println("Elements in the list:");
                    doublyLinkedList.print();
                    break;

                case 4:
                    doublyLinkedList.displaySize();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
