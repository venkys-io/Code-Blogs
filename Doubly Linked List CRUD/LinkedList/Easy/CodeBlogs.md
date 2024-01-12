# Doubly Linked List CRUD

## Introduction to Doubly Linked List

A doubly linked list is a type of data structure that consists of a sequence of nodes, where each node contains a value and two pointers that point to the previous and next nodes in the sequence. Unlike a singly linked list, which only has a pointer to the next node, a doubly linked list allows for traversal in both directions.

The ability to traverse in both directions makes doubly linked lists useful for certain operations, such as insertion and deletion at both the beginning and end of the list. This flexibility comes at the cost of additional memory required to store the extra pointers.

In this section, we will explore the basic operations performed on a doubly linked list, including creating a new list, inserting elements, deleting elements, and searching for elements. These operations form the foundation of many more complex algorithms and data structures.

## Overview of CRUD operations on Doubly Linked List

### Create

To create a doubly linked list, we start with an empty list and gradually add elements to it. Each element is inserted at the beginning or end of the list, or at a specific position.

### Read

To read elements from a doubly linked list, we can traverse the list starting from either the head or tail node. We can access the value of each node and perform any necessary operations.

### Update

To update elements in a doubly linked list, we first need to locate the specific node we want to update. Once we find the node, we can modify its value or any other attributes as needed.

### Delete

To delete elements from a doubly linked list, we first need to locate the node we want to remove. Once we find the node, we can update the pointers of the previous and next nodes to bypass the node to be deleted.

These CRUD operations are fundamental for working with doubly linked lists and allow us to manipulate the data efficiently.

## Code

```python
# Copy rights to venkys.io
# Python program to perform CRUD operations on double linkedlist
# Stable:No
# Inplace: Yes
# Adaptive:No
# Space complexity: O(n)
# Time complexity:O(1)
class Node:
    def __init__(self, val):
        self.prev = None
        self.data = val
        self.next = None

class DLL:
    def __init__(self):
        self.head = None

    # Create Operation: Insert at the Beginning
    def insert_begin(self, val):
        new_node = Node(val)
        if self.head:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = new_node
        else:
            self.head = new_node

    # Create Operation: Insert at the End
    def insert_end(self, val):
        new_node = Node(val)
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            new_node.prev = temp
            temp.next = new_node

    # Create Operation: Insert at a Specific Position
    def insert_pos(self, val, pos):
        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos:
                break
            else:
                temp = temp.next
        new_node = Node(val)
        new_node.prev = temp.prev
        new_node.next = temp
        temp.prev.next = new_node

    # Delete Operation: Delete from the Beginning
    def delete_begin(self):
        if self.head is None:
            print("List is empty.")
        else:
            self.head = self.head.next
            if self.head:
                self.head.prev = None

    # Delete Operation: Delete from the End
    def delete_end(self):
        if self.head is None:
            print("List is empty.")
        elif self.head.next is None:
            self.head = None
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.prev.next = None

    # Delete Operation: Delete from a Specific Position
    def delete_pos(self, pos):
        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos:
                break
            else:
                temp = temp.next
        if temp.next:
            temp.next.prev = temp.prev
            temp.prev.next = temp.next
        else:
            temp.prev.next = None

    # Update Operation: Update Node Value
    def update(self, pval, nval):
        if self.head:
            temp = self.head
            while temp:
                if temp.data == pval:
                    temp.data = nval
                    break
                temp = temp.next

    # Remove Operation: Remove Node with a Specific Value
    def remove(self, val):
        if self.head and self.head.data == val:
            self.head = self.head.next
            if self.head:
                self.head.prev = None
        else:
            temp = self.head
            while temp and temp.next:
                if temp.data == val:
                    temp.next.prev = temp.prev
                    temp.prev.next = temp.next
                    break
                temp = temp.next

    # Display Operation: Display the Doubly Linked List
    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end="<->")
            temp = temp.next
        print("None")


# Example Usage
dll = DLL()

while True:
    print("\n1. Insert at the Beginning")
    print("2. Insert at the End")
    print("3. Insert at a Specific Position")
    print("4. Delete from the Beginning")
    print("5. Delete from the End")
    print("6. Delete from a Specific Position")
    print("7. Update Node Value")
    print("8. Remove Node with a Specific Value")
    print("9. Display")
    print("0. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        val = int(input("Enter value to insert at the beginning: "))
        dll.insert_begin(val)
    elif choice == 2:
        val = int(input("Enter value to insert at the end: "))
        dll.insert_end(val)
    elif choice == 3:
        val = int(input("Enter value to insert: "))
        pos = int(input("Enter position to insert at: "))
        dll.insert_pos(val, pos)
    elif choice == 4:
        dll.delete_begin()
    elif choice == 5:
        dll.delete_end()
    elif choice == 6:
        pos = int(input("Enter position to delete: "))
        dll.delete_pos(pos)
    elif choice == 7:
        pval = int(input("Enter old value to update: "))
        nval = int(input("Enter new value: "))
        dll.update(pval, nval)
    elif choice == 8:
        val = int(input("Enter value to remove: "))
        dll.remove(val)
    elif choice == 9:
        dll.display()
    elif choice == 0:
        print("Exiting...")
        break
    else:
        print("Invalid choice. Please try again.")

```

## Step-by-Step Explanation

Here is a step-by-step explanation of the linked list program with CRUD operations:

1. First, we define a **Node** class with attributes for the previous node, data, and the next node.
2. Then, we define a **DLL** (Doubly Linked List) class with a constructor to initialize the head of the list.
3. The **DLL** class contains various methods for the CRUD operations:
    - **insert_begin(val)**: Inserts a new node at the beginning of the list.
    - **insert_end(val)**: Inserts a new node at the end of the list.
    - **insert_pos(val, pos)**: Inserts a new node at a specific position in the list.
    - **delete_begin()**: Deletes the node at the beginning of the list.
    - **delete_end()**: Deletes the node at the end of the list.
    - **delete_pos(pos)**: Deletes the node at a specific position in the list.
    - **update(pval, nval)**: Updates the value of a specific node.
    - **remove(val)**: Removes a node with the specified value.
    - **display()**: Displays the elements of the linked list.
4. The program demonstrates the usage of the linked list methods.
5. The output of each operation is displayed to show the changes in the linked list.
## Test Case 1:
1. Insert 10
2. Display
   Expected Output: 10
3. Delete
4. Display
   Expected Output: (empty)

## Test Case 2:
1. Insert 5
2. Insert 8
3. Insert 12
4. Display
   Expected Output: 12 8 5
5. Delete
6. Display
   Expected Output: 8 5

## Test Case 3:
1. Delete
   Expected Output: List is empty. Cannot delete.
2. Display
   Expected Output: (empty)

## Code

```java
// Copy rights to venkys.io
// Java program to perform CRUD operations on double linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
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
            System.out.println("Node deleted successfully.");
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

```
## Step-by-Step Explanation

This program implements a simple double linked list in Java. Below is a step-by-step explanation.

1. A class **Node** is defined with three properties: **data**, **next**, and **prev**. **data** stores the integer value of the node. **next** and **prev** are pointers to the next and previous nodes, respectively.
2. A class **DoubleLinkedList** is defined with two properties: **head** and **size**. **head** is a pointer to the first node in the list and **size** keeps track of the number of nodes in the list.
3. The **DoubleLinkedList** class has four methods: **insert**, **delete**, **print**, and **size**.
    **insert** creates a new node with the given data and adds it to the front of the list.
    **delete** removes the node at the front of the list.
    **print** prints the data of all nodes in the list from the front to the end.
    **size** prints the number of nodes in the list.
4. In the **Main** class, a **DoubleLinkedList** is created and several operations are performed. The list is printed after each operation to show its current state.
## Test Case 1:
1. Insert 10
2. Display
   Expected Output: 10
3. Delete
4. Display
   Expected Output: (empty)

## Test Case 2:
1. Insert 5
2. Insert 8
3. Insert 12
4. Display
   Expected Output: 12 8 5
5. Delete
6. Display
   Expected Output: 8 5

## Test Case 3:
1. Delete
   Expected Output: List is empty. Cannot delete.
2. Display
   Expected Output: (empty)

## Code
```
/* Copy rights to venkys.io */
/* CPP program to perform CRUD operations on double linkedlist*/
/* Stable:No*/
/* Inplace: Yes */
/* Adaptive:No */
/* Space complexity: O(n) */
/* Time complexity:O(1) */
#include<bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node() {
        data = 0;
        next = NULL;
        prev = NULL;
    }

    Node(int val) {
        data = val;
        next = NULL;
        prev = NULL;
    }
};

class DoubleLinkedList {
private:
    Node* head = NULL;
    int length = 0;

public:

    /* Insertion operation (Create) */
    void insert(int data) {
        if (head == NULL) {
            /* If the list is empty, create a new node and set it as the head*/
            head = new Node(data);
        }
        else {
            /* Otherwise, create a new node, update links, and set it as the new head */
            Node* temp = new Node(data);
            length++;
            temp->next = head;
            head->prev = temp;
            head = temp;
        }
        length++;
    }

    /* Deletion operation (Delete) */
    void del() {
        if (head == NULL) {
            cout << "List is empty. Cannot delete.\n";
            return;
        }
        head = head->next;
        if (head != NULL) {
            head->prev = NULL;
        }
        length--;
        cout << "Node deleted successfully.\n";
    }

    /* Display operation (Read) */
    void print() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    /* Size operation (Read)*/
    void displaySize() {
        cout << "Size of the list: " << length << endl;
    }

    /* Main menu for user interaction */
    void menu() {
        int choice, data;

        while (true) {
            cout << "\nChoose operation:\n";
            cout << "1. Insert\n";
            cout << "2. Delete\n";
            cout << "3. Display\n";
            cout << "4. Display Size\n";
            cout << "5. Exit\n";

            cin >> choice;

            switch (choice) {
            case 1:
                cout << "Enter data to insert: ";
                cin >> data;
                insert(data);
                cout << "Node inserted successfully.\n";
                break;

            case 2:
                del();
                break;

            case 3:
                cout << "Elements in the list: ";
                print();
                break;

            case 4:
                displaySize();
                break;

            case 5:
                cout << "Exiting the program.\n";
                exit(0);

            default:
                cout << "Invalid choice. Please try again.\n";
            }
        }
    }
};

int main() {
    DoubleLinkedList doublyLinkedList;
    doublyLinkedList.menu();

    return 0;
}

```
## step-by-step Explanation
This program implements a simple double linked list in C++. Here's a step-by-step explanation.
1. A class **Node** is defined with three properties: **data**, **next**, and **prev**. **data** stores the integer value of the node. **next** and **prev** are pointers to the next and previous nodes, respectively.
2. A class **DoubleLinkedList** is defined with two properties: **head** and **length**. **head** is a pointer to the first node in the list, and **length** keeps track of the number of nodes in the list.
3. The **DoubleLinkedList** class has four methods: **insert**, **del**, **print**, and **size**.
    **insert** creates a new node with the given data and adds it to the front of the list.
    **del** removes the node at the front of the list.
    **print** prints the data of all nodes in the list from the front to the end.
    *8size** prints the number of nodes in the list.
4. In the **main** function, a **DoubleLinkedList** is created, and several operations are performed. The list is printed after each operation to show its current state.
## Test Case 1:
1. Insert 10
2. Display
   Expected Output: 10
3. Delete
4. Display
   Expected Output: (empty)

## Test Case 2:
1. Insert 5
2. Insert 8
3. Insert 12
4. Display
   Expected Output: 12 8 5
5. Delete
6. Display
   Expected Output: 8 5

## Test Case 3:
1. Delete
   Expected Output: List is empty. Cannot delete.
2. Display
   Expected Output: (empty)
## Time and Space Complexity Analysis

### Time Complexity

The time complexity of various operations on a doubly linked list can be analyzed as follows:

- Insertion at the beginning: O(1)
- Insertion at the end: O(n)
- Insertion at a specific position: O(n)
- Deletion at the beginning: O(1)
- Deletion at the end: O(n)
- Deletion at a specific position: O(n)
- Updating a node: O(n)
- Searching for a node: O(n)

### Space Complexity

The space complexity of a doubly linked list depends on the number of nodes in the list. In the worst case, the space complexity is O(n), where n is the number of nodes in the list.

It's important to note that these time and space complexities are based on the provided implementation. Other implementations may have different time and space complexities.

Please note that the code provided is in two different programming languages, Python and Java. Each programming language has its own syntax and conventions for implementing doubly linked lists.

## Real World Applications of Doubly Linked List

Doubly linked lists have several real-world applications in computer science. Here are a few examples:

1. **Text Editors**: Doubly linked lists are commonly used to implement text editors. Each character in the text can be represented by a node in the list, and the pointers allow for efficient insertion, deletion, and navigation through the text.
2. **Browser History**: Doubly linked lists are used to implement browser history functionality. Each visited webpage can be stored as a node in the list, and the backward and forward navigation is facilitated by the previous and next pointers.
3. **Undo/Redo Functionality**: Doubly linked lists are useful for implementing undo and redo functionality in applications. Each action performed by the user can be stored as a node in the list, and the pointers allow for traversing back and forth through the actions.
4. **Cache Implementation**: Doubly linked lists are used in cache implementation, such as the LRU (Least Recently Used) cache. The most recently used items are moved to the front of the list, while the least recently used items are moved to the end. This allows for efficient eviction of the least used items when the cache is full.

These are just a few examples of how doubly linked lists can be used in real-world applications. Their ability to support efficient insertion, deletion, and traversal in both directions makes them a valuable data structure in various scenarios.