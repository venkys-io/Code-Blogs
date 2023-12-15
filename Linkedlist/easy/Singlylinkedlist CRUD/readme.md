# Exploring Linked Lists:Singly linked list

A linked list is a data structure that consists of a sequence of elements, where each element points to the next one in the sequence. Unlike arrays, linked lists do not have a fixed size, and elements can be easily inserted or removed without the need to shift other elements.

# Introduction to linked lists

A linked list is a linear data structure consisting of a sequence of elements, where each element points to the next one in the sequence. Unlike arrays, linked lists do not have a fixed size in memory and can dynamically grow or shrink. This makes linked lists a flexible and efficient choice for certain operations, such as inserting or deleting elements, as compared to arrays.

The basic building block of a linked list is a node. Each node contains two fields: a data element (or payload) and a reference (or link) to the next node in the sequence. The last node in the list typically has a null reference, indicating the end of the list.

There are various types of linked lists, with the two most common types being:

1. Singly linked list
2. Doubly linked list

# Singly linked list

A singly linked list is a fundamental data structure in computer science that consists of a sequence of elements, each of which points to the next element in the sequence. Each element in a singly linked list is called a "node," and it contains two parts: the data (or payload) and a reference (or link) to the next node in the sequence. The last node typically has a null reference since there is no next node.

The basic operations on a singly linked list are often referred to as CRUD operations, which stands for Create, Read, Update, and Delete. Here's an introduction to each of these operations:

1. Create
2. Read
3. Update
4. Delete

# Overview of singly linked list

A singly linked list is a linear data structure composed of nodes, each containing a data element and a reference to the next node in the sequence. These linked nodes form a chain, with the last node pointing to null, indicating the end of the list. The list is traversed in one direction, typically from the head (the starting node) to the tail (the last node). Singly linked lists are dynamic in size, enabling elements to be easily added or removed. Insertion and deletion operations are efficient, particularly at the beginning of the list, as they involve updating references rather than shifting elements. However, singly linked lists do not support constant-time random access to elements, requiring traversal for locating specific nodes. This versatile data structure serves as a foundational concept in computer science, underpinning more complex data structures and algorithms.

# Code

## Python code:

```python
# Copyrights to venkys.io for more information, visit https://venkys.io
class Node:
def **init**(self, data):
self.data = data
self.next = None
class SinglyLinkedList:
def **init**(self):
self.head = None
# Create (Insert)
def append(self, data):
    new_node = Node(data)
    if not self.head:
        self.head = new_node
    else:
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

# Read (Traverse)
def display(self):
    current = self.head
    while current:
        print(current.data, end=" ")
        current = current.next
    print()

# Update
def update(self, old_data, new_data):
    current = self.head
    while current:
        if current.data == old_data:
            current.data = new_data
            return
        current = current.next

# Delete
def delete(self, data):
    current = self.head
    if current and current.data == data:
        self.head = current.next
        current = None
        return

    prev = None
    while current and current.data != data:
        prev = current
        current = current.next

    if not current:
        return

    prev.next = current.next
    current = None
#Example Usage
#Create
linked_list = SinglyLinkedList()
Createlinked_list.append(1)
linked_list.append(2)
linked_list.append(3)

#Read
print("Original Linked List:")
linked_list.display()

#Update
linked_list.update(2, 5)
print("\nUpdated Linked List:")
linked_list.display()

#Delete
linked_list.delete(1)
print("\nLinked List after Deletion:")
linked_list.display()

```

## Step-by-Step explanation

### **Step 1: Define the Node Class**

In this step, a node class is defined to represent the basic building block of a linked list.

- Each node has a data field to store the actual information and a next field to reference the next node in the sequence.
- The —init— method initializes a node with the provided data and sets the next reference to none by default.

### **Step 2: Define the SinglyLinkedList Class**

- Here, a singlylinkedlist class is defined to represent the linked list itself.
- The linked list is initialized with a head attribute set to none.

### **Step 3: Create Operation - append Method**

- The append method is defined to add a new node with the given data to the end of the linked list.
- If the list is empty (head is none), the new node becomes the head.
- If the list is not empty, it traverses the list to find the last node and appends the new node to its next reference.

### **Step 4: Read Operation - display and get_at_index Methods**

- The display method prints the elements of the linked list from the head to the end.
- The get_at_index method retrieves the data at a specific index in the linked list. It traverses the list until it reaches the desired index.

### **Step 5: Update Operation - update_at_index Method**

- The update_at_index method updates the data at a specific index in the linked list. It traverses the list until it reaches the desired index and then updates the data field.

### **Step 6: Delete Operation - delete Method**

- The delete method removes a node with a specific data value from the linked list.
- If the node to be deleted is the head, the head is updated to skip the first node.
- Otherwise, it traverses the list to find the node to be deleted, and then it updates the references to skip that node.

### **Step 7: Additional - length Method**

- The length method returns the number of nodes in the linked list by traversing the list and counting the nodes.

### **Step 8: Example Usage**

- In this part, the program demonstrates the usage of the singlylinkedlist class and its methods.
- It creates a linked list, performs various operations (create, read, update, delete), and displays the results.

## Java code:

```java
// Copyrights to venkys.io for more information, visit https://venkys.io
import java.util.*;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    // Create Operation - Append
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Read Operation - Display
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Read Operation - Get at Index
    public int getAtIndex(int index) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException("Index out of range");
    }

    // Update Operation - Update at Index
    public void updateAtIndex(int index, int newData) {
        Node current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                current.data = newData;
                return;
            }
            count++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException("Index out of range");
    }

    // Delete Operation - Delete Node
    public void delete(int data) {
        Node current = head;

        // If the node to be deleted is the head
        if (current != null && current.data == data) {
            head = current.next;
            return;
        }

        // Search for the node to be deleted
        Node prev = null;
        while (current != null && current.data != data) {
            prev = current;
            current = current.next;
        }

        // If the node is not found
        if (current == null) {
            System.out.println(data + " not found in the list.");
            return;
        }

        // Update the references to skip the node to be deleted
        prev.next = current.next;
    }

    // Additional Operation - Get Length
    public int length() {
        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        // Create
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        // Read
        System.out.println("Original linked list:");
        linkedList.display();

        // Update
        linkedList.updateAtIndex(1, 5);
        System.out.println("\nLinked list after updating at index 1:");
        linkedList.display();

        // Read (get data at a specific index)
        int elementAtIndex = linkedList.getAtIndex(2);
        System.out.println("\nElement at index 2: " + elementAtIndex);

        // Delete
        linkedList.delete(5);
        System.out.println("\nLinked list after deleting element 5:");
        linkedList.display();

        // Read (get length of the linked list)
        System.out.println("\nLength of the linked list: " + linkedList.len());
    }
}
```

## Step-by-Step explanation:

### **Step 1: Define the node class**

- In this step, a node class is defined to represent a node in the singly linked list.
- Each node has an int data field to store the actual information and a node next reference to point to the next node in the list.
- The constructor initializes a node with the provided data and sets the next reference to null.

### **Step 2: Define the singlylinkedlist class**

- The singlylinkedlist class is defined with a  attribute representing the starting node of the list.
- The constructor initializes an empty linked list with the head set to null.

### **Step 3: Create Operation -append Method**

- The append method is used to add a new node with the given data to the end of the linked list.
- If the list is empty (head is null), the new node becomes the head.
- If the list is not empty, it traverses the list to find the last node and appends the new node to its next reference.

### **Step 4: Read Operation - display and getatindex Methods**

- The display method prints the elements of the linked list from the head to the end.
- The getatindex method retrieves the data at a specific index in the linked list. It traverses the list until it reaches the desired index.

### **Step 5: Update Operation - updateatindex Method**

- The updateatindex method updates the data at a specific index in the linked list. It traverses the list until it reaches the desired index and then updates the data field.

### **Step 6: Delete Operation - delete Method**

- The delete method removes a node with a specific data value from the linked list.
- If the node to be deleted is the head, the head is updated to skip the first node.
- Otherwise, it traverses the list to find the node to be deleted, and then it updates the references to skip that node.

### **Step 7: Additional Operation - length Method**

- The length method returns the number of nodes in the linked list by traversing the list and counting the nodes.

### **Step 8: Example Usage in the main class**

- In the main class, an instance of singlylinkedlist is created and various operations are performed to demonstrate CRUD operations on the linked list.

Understanding each step will help you comprehend the concepts of singly linked list CRUD operations in Java. Feel free to modify or extend the code based on your specific requirements.

## Cpp Code:

```cpp
// Copyrights to venkys.io for more information, visit https://venkys.io
#include <iostream>
using namespace std;

// Node class for the linked list
class VSDnode {
public:
    int data;
    VSDnode* next;

    // Constructor to initialize a node with a given value
    VSDnode(int val) {
        data = val;
        next = NULL;
    }
};

// Function to add a new node at the head of the linked list
void add_head(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    n->next = head;
    head = n;
}

// Function to add a new node at the tail of the linked list
void add_tail(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    if (head == NULL) {
        head = n;
        return;
    }
    VSDnode* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = n;
}

// Function to update a node's value in the linked list
void update_val(VSDnode* &head, int val, int replace) {
    VSDnode* temp = head;
    while (temp != NULL) {
        if (temp->data == val) {
            temp->data = replace;
            return;
        }
        temp = temp->next;
    }
    cout << "The value is not present in the linked list" << endl;
}

// Function to delete the head node of the linked list
void delete_head(VSDnode* &head) {
    if (head == NULL) {
        cout << "Linked list is empty" << endl;
    } else {
        head = head->next;
    }
}

// Function to delete the tail node of the linked list
void delete_tail(VSDnode* &
```

## Step-by-Step Explanation:

### **Step 1: Define the node Class**

- In this step, a node class is defined to represent a node in the singly linked list.
- Each node has an int  field to store the actual information and a node* null pointer to point to the next node in the list.
- The constructor initializes a node with the provided value and sets the next pointer to nullptr.

### **Step 2: Define the singlylinkedlist Class**

- The single class is defined with a node* null pointer representing the starting node of the list.
- The constructor initializes an empty linked list with the head set to nullptr.

### **Step 3: Create Operation - append Method**

- The append method is used to add a new node with the given value to the end of the linked list.
- If the list is empty (head is nullptr), the new node becomes the head.
- If the list is not empty, it traverses the list to find the last node and appends the new node to its next pointer.

### **Step 4: Read Operation - display and getindex Methods**

- The display method prints the elements of the linked list from the head to the end.
- The getatindex method retrieves the data at a specific index in the linked list. It traverses the list until it reaches the desired index.

### **Step 5: Update Operation - updateatindex Method**

- The updateatindex method updates the data at a specific index in the linked list. It traverses the list until it reaches the desired index and then updates the data field.

### **Step 6: Delete Operation - deletenode Method**

- The deletenode method removes a node with a specific data value from the linked list.
- If the node to be deleted is the head, the head is updated to skip the first node, and the memory is freed.
- Otherwise, it traverses the list to find the node to be deleted, updates the pointers to skip that node, and frees the memory.

### **Step 7: Additional Operation - length Method**

- The length method returns the number of nodes in the linked list by traversing the list and counting the nodes.

### **Step 8: Example Usage in the main Function**

## Time and Space complexity analysis

1. **Time Complexity:**
    - **Access/Search:** O(n) - Linear time as you may need to traverse the list.
    - **Insertion/Deletion at the beginning:** O(1) - Constant time as it involves updating pointers.
    - **Insertion/Deletion in the middle:** O(n) - Linear time as you may need to traverse to the specific position.
    - **Insertion/Deletion at the end (with tail pointer):** O(1) - Constant time if a tail pointer is maintained.
2. **Space Complexity:**
    - O(n) - Linear space for n elements since each element requires storage for data and a reference/pointer to the next node.

## Real-world applications of singlylinkedlist:

1. Image viewer – Previous and next images are linked and can be accessed by the next and previous buttons.
2. Previous and next page in a web browser – We can access the previous and next URL searched in a web browser by pressing the back and next buttons since they are linked as a linked list.
3. Music Player – Songs in the music player are linked to the previous and next songs. So you can play songs either from starting or ending of the list.
4. GPS navigation systems- Linked lists can be used to store and manage a list of locations and routes, allowing users to easily navigate to their desired destination.
5. Robotics- Linked lists can be used to implement control systems for robots, allowing them to navigate and interact with their environment.
6. Task Scheduling- Operating systems use linked lists to manage task scheduling, where each process waiting to be executed is represented as a node in the list.
7. Image Processing- Linked lists can be used to represent images, where each pixel is represented as a node in the list.
8. File Systems- File systems use linked lists to represent the hierarchical structure of directories, where each directory or file is represented as a node in the list.
9. Symbol Table- Compilers use linked lists to build a symbol table, which is a data structure that stores information about identifiers used in a program.
10. Undo/Redo Functionality- Many software applications implement undo/redo functionality using linked lists, where each action that can be undone is represented as a node in a doubly linked list.
11. Speech Recognition- Speech recognition software uses linked lists to represent the possible phonetic pronunciations of a word, where each possible pronunciation is represented as a node in the list.
12. Polynomial Representation- Polynomials can be represented using linked lists, where each term in the polynomial is represented as a node in the list.
13. Simulation of Physical Systems- Linked lists can be used to simulate physical systems, where each element in the list represents a discrete point in time and the state of the system at that time
