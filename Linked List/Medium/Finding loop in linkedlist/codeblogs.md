# Finding Loop In Linked List

## Introduction to Finding Loop In Linked List

Finding a loop in a linked list is a common problem in computer science. A loop occurs in a linked list when a node's next pointer points to a previous node in the list, creating a cycle. This can cause issues as some operations might end up in an infinite loop. Various algorithms exist to detect and handle such loops, and understanding these is fundamental to working with linked lists.

## Overview of Finding Loop In Linked List

Detecting a loop in a linked list involves traversing the nodes and checking if a node has already been visited or not. There are several methods to solve this problem, including Floyd's cycle-finding algorithm also known as the 'tortoise and the hare' approach. This method uses two pointers moving at different speeds, a slow 'tortoise' pointer and a fast 'hare' pointer. If there's a loop, the fast pointer will eventually meet the slow pointer. If there isn't, the fast pointer will reach the end of the list. Understanding these algorithms is crucial especially when optimizing for performance and efficiency in data structure manipulation.

## Code

```python
#Copy rights to venkys.io
#Python program to perform finding loop in linked list
#Stable:Yes
#Inplace: Yes
#Adaptive:No
#Space complexity: O(n)
#Time complexity:O(n)
#loop in a linked list program 
class Node:
    def __init__(self, val):
        self.data = val
        self.next = None

class SLL:
    def __init__(self):
        self.head = None

    def insert_begin(self, val):
        # Insert a new node at the beginning of the linked list
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node

    def insert_end(self, val):
        # Insert a new node at the end of the linked list
        new_node = Node(val)
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node

    def insert_pos(self, val, pos):
        # Insert a new node at a specified position in the linked list
        if pos < 1:
            print("Invalid position for insertion.")
            return

        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos - 1:
                break
            temp = temp.next

        if temp is None:
            print("Invalid position for insertion.")
            return

        new_node = Node(val)
        new_node.next = temp.next
        temp.next = new_node

    def create_loop(self, position, by_value=True):
        # Create a loop in the linked list either by value or position
        count = 0
        temp = self.head
        while temp.next:
            count += 1
            if (by_value and count == position) or (not by_value and count == position - 1):
                loop_node = temp.next
                break
            temp = temp.next

        temp.next = loop_node

    def detect_loop(self):
        # Detect a loop in the linked list using Floyd's Tortoise and Hare algorithm
        slow = self.head
        fast = self.head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                print("Loop detected in the linked list.")
                return slow  # Return the node where the loop starts

        print("No loop found in the linked list.")
        return None

    def remove_loop(self):
        # Remove the loop in the linked list using Floyd's Tortoise and Hare algorithm
        loop_start = self.detect_loop()
        if loop_start:
            slow = self.head
            fast = loop_start

            while slow.next != fast.next:
                slow = slow.next
                fast = fast.next

            fast.next = None

    def display(self):
        # Display the elements of the linked list
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")


# Test drive code with user input:
sll = SLL()

print("------------INSERTION OPERATIONS-------------")
n = int(input("Enter the number of elements to insert at the beginning: "))
for _ in range(n):
    val = int(input("Enter the value to insert at the beginning: "))
    sll.insert_begin(val)
sll.display()

n = int(input("Enter the number of elements to insert at the end: "))
for _ in range(n):
    val = int(input("Enter the value to insert at the end: "))
    sll.insert_end(val)
sll.display()

val = int(input("Enter the value to insert: "))
pos = int(input("Enter the position to insert at: "))
sll.insert_pos(val, pos)
sll.display()

print("------------LOOP CREATION-------------")
pos = int(input("Enter the position for loop creation: "))
sll.create_loop(pos)
sll.display()

print("------------LOOP DETECTION-------------")
sll.detect_loop()

print("------------LOOP REMOVAL-------------")
sll.remove_loop()
sll.display()

```

## Step-by-Step Explanation

The provided Python code starts by defining a Node class, which represents an individual element in a linked list. Each node contains a value (data) and a pointer to the next node (next).

The SLL (Singly Linked List) class is defined next. It starts with a head pointer, and includes several methods to manipulate and interact with the linked list, such as:

- **insert_begin(val)**: This function inserts a new node at the beginning of the list. It creates a new node and points it to the current head of the list. Then, it updates the head of the list to the newly created node.
- **insert_end(val)**: This function inserts a new node at the end of the list. It creates a new node and iterates through the list until it reaches the last node, then adds the new node at the end.
- **insert_pos(val, pos)**: This function inserts a new node at a specified position in the list. It creates a new node, iterates through the list to the specified position, and inserts the new node there.
- **create_loop(val)** and **create_pos_loop(pos)**: These functions create a loop in the list either at a specific value or position, for testing purposes.
- **detect_loop()**: This function uses Floyd's cycle-finding algorithm to detect if a loop exists in the list. It initializes two pointers at the head of the list, then moves them at different speeds (one node at a time for the slow pointer, and two nodes at a time for the fast pointer). If a loop exists in the list, the fast pointer will eventually "lap" the slow pointer and they'll both point to the same node. If there's no loop, the fast pointer will reach the end of the list.
- **remove_loop()**: This function removes a loop from the list if one exists. It uses a similar two-pointer approach to detect the loop, and then resets one of the pointers to the head of the list. It moves both pointers one node at a time until they meet again, at which point it's able to identify and remove the loop.
- **display()**: This function displays the elements of the list from the head to the end, which is helpful for visualizing the list structure.
## Test Case 1: Null Linked List
- Input:
Enter the number of elements in the linked list: 0
Linked List:
NULL
## Test Case 2: No Cycle
- Input:
Enter the number of elements in the linked list: 5
Enter the elements of the linked list:
1 2 3 4 5
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 0
Linked List: 1->2->3->4->5->NULL
No cycle present in the linked list
## Test Case 3: Cycle Present
- Input:
Enter the number of elements in the linked list: 6
Enter the elements of the linked list:
1 2 3 4 5 6
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 1
Enter the position to create a cycle: 3
Linked List: 1->2->3->4->5->6->(cycle starts here)
Cycle present in the linked list

## Code

```java
//Copy rights to venkys.io
//Java program to perform finding loop in linked list
//Stable:Yes
//Inplace: Yes
//Adaptive:No
//Space complexity: O(n)
//Time complexity:O(n)
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
```

## Step-by-Step Explanation

The provided Java code starts by defining a Node class, which represents an individual element in a linked list. Each node contains a value (data) and a pointer to the next node (next).

The main class, VSDFindingLoopInLinkedList, contains several methods to interact with the linked list:

- **VSDinsert(int element)**: This function inserts a new node at the end of the list. It creates a temporary node with the provided element, checks if the head of the list is null (which would mean the list is currently empty), and if so, sets the head to the new node. If the list is not empty, it iterates through the list to find the last node, then sets that node's 'next' pointer to the new node.
- **VSDfindLoop()**: This function checks if a loop exists in the list. It creates a HashSet to keep track of the nodes it visits as it iterates through the list. If it encounters a node that is already in the HashSet (which would mean we've visited it before), it returns true, indicating that a loop exists. If it reaches the end of the list without revisiting any nodes, it returns false.

In the main method, several nodes are inserted into the list using the VSDinsert method, then a loop is manually created for testing purposes by setting the 'next' pointer of one node to the head of the list. The VSDfindLoop method is then called to check for a loop in the list, and the result is printed.

## Test Case 1: Null Linked List
- Input:
Enter the number of elements in the linked list: 0
Linked List:
NULL
## Test Case 2: No Cycle
- Input:
Enter the number of elements in the linked list: 5
Enter the elements of the linked list:
1 2 3 4 5
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 0
Linked List: 1->2->3->4->5->NULL
No cycle present in the linked list
## Test Case 3: Cycle Present
- Input:
Enter the number of elements in the linked list: 6
Enter the elements of the linked list:
1 2 3 4 5 6
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 1
Enter the position to create a cycle: 3
Linked List: 1->2->3->4->5->6->(cycle starts here)
Cycle present in the linked list


## Code

```cpp
/*Copy rights to venkys.io */
/*CPP program to perform finding loop in linked list*/
/*Stable:Yes */
/*Inplace: Yes */
/*Adaptive:No */
/*Space complexity: O(1)*/
/*Time complexity:O(n)*/
#include <iostream>
using namespace std;

/* Node class definition */
class VSDnode {
public:
    int data;
    VSDnode* next;

    VSDnode(int val) {
        data = val;
        next = NULL;
    }
};

/* Function to add a node at the head of the linked list */
void add_head(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    n->next = head;
    head = n;
}

/* Function to add a node at the tail of the linked list */
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

/* Function to create a cycle in the linked list at a specified position */
void create_cycle_pos(VSDnode* &head, int pos) {
    VSDnode* temp = head;
    int len = 1;
    VSDnode* ptr;
    while (temp->next != NULL) {
        if (len == pos) {
            ptr = temp;
        }
        temp = temp->next;
        len++;
    }
    temp->next = ptr;
}

/* Function to detect the presence of a cycle in the linked list using Floyd's Tortoise and Hare algorithm */
bool detect_cycle(VSDnode* &head) {
    VSDnode* slow = head;
    VSDnode* fast = head;
    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
        if (fast == slow) {
            return true;  /* Cycle present in the linked list */
        }
    }
    return false;  /* No cycle present in the linked list */
}

/* Function to remove the cycle in the linked list */
void remove_cycle(VSDnode* &head) {
    VSDnode* slow = head;
    VSDnode* fast = head;

    do {
        slow = slow->next;
        fast = fast->next->next;
    } while (slow != fast);

    fast = head;
    while (slow->next != fast->next) {
        slow = slow->next;
        fast = fast->next;
    }
    slow->next = NULL;
}

/* Function to display the linked list */
void display(VSDnode* head) {
    VSDnode* temp = head;
    while (temp != NULL) {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

int main() {
    VSDnode* head = NULL;
    int n;

    cout << "Enter the number of elements in the linked list: ";
    cin >> n;

    cout << "Enter the elements of the linked list:" << endl;
    for (int i = 0; i < n; i++) {
        int element;
        cin >> element;
        add_tail(head, element);
    }

    cout << "Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): ";
    int createCycle;
    cin >> createCycle;

    if (createCycle) {
        cout << "Enter the position to create a cycle: ";
        int pos;
        cin >> pos;
        create_cycle_pos(head, pos);
    }

    cout << "Linked List: ";
    display(head);

    /* Detecting and displaying whether a cycle is present */
    if (detect_cycle(head)) {
        cout << "Cycle present in the linked list" << endl;
        remove_cycle(head);
        cout << "Linked List after removing the cycle: ";
        display(head);
    } else {
        cout << "No cycle present in the linked list" << endl;
    }

    return 0;
}

```

## Step-by-Step Explanation

The provided C++ code starts by defining a Node class, which represents an individual element in a linked list. Each node contains a value (data) and a pointer to the next node (next).

The main program contains several functions to interact with the linked list:

- *add_head(VSDnode &head,int val)*and *add_tail(VSDnode &head,int val)*: These functions insert a new node at the beginning or the end of the list respectively. They create a new node with the provided value and adjust the 'next' pointers accordingly to insert the node at the correct position.
- *create_cycle_pos(VSDnode &head,int pos)*: This function creates a loop in the list for testing purposes. It iterates through the list to the specified position and sets the 'next' pointer of the last node in the list to the node at the specified position, creating a loop.
- *detect_cycle(VSDnode &head)*: This function checks if a loop exists in the list. It uses Floyd's cycle-finding algorithm: it initializes two pointers at the head of the list and moves them at different speeds (one node at a time for the slow pointer, and two nodes at a time for the fast pointer). If a loop exists, the fast pointer will eventually catch up with the slow pointer and they'll point to the same node. If there's no loop, the fast pointer will reach the end of the list.
- *remove_cycle(VSDnode &head)*: This function removes a loop from the list if one exists. It uses a similar two-pointer approach to detect the loop, then resets one of the pointers to the head of the list. It moves both pointers one node at a time until they meet again, then sets the 'next' pointer of the slow pointer to NULL to break the loop.
- *display(VSDnode head)*: This function displays the elements of the list from the head to the end, which is helpful for visualizing the list structure.

In the main function, several nodes are inserted into the list using the add_head and add_tail functions, a loop is manually created using the create_cycle_pos function, and the detect_cycle function is called to check for a loop in the list. 
## Test Case 1: Null Linked List
- Input:
Enter the number of elements in the linked list: 0
Linked List:
NULL
## Test Case 2: No Cycle
- Input:
Enter the number of elements in the linked list: 5
Enter the elements of the linked list:
1 2 3 4 5
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 0
Linked List: 1->2->3->4->5->NULL
No cycle present in the linked list
## Test case 3: Cycle Present
- Input:
Enter the number of elements in the linked list: 6
Enter the elements of the linked list:
1 2 3 4 5 6
Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): 1
Enter the position to create a cycle: 3
Linked List: 1->2->3->4->5->6->(cycle starts here)
Cycle present in the linked list


## Time Complexity:

For all the languages, the time complexity for detecting and removing loop in a linked list is O(n), where n is the number of nodes in the list. This is because in the worst-case scenario, we traverse all nodes of the list once.

## Space Complexity:

The space complexity for the Python and Java implementations is O(n), because we use a HashSet to keep track of visited nodes, which in the worst case will hold all n nodes of the list.

The space complexity for the C++ implementation is O(1), because it uses Floyd's cycle-finding algorithm with two pointers and does not use any extra space that scales with the size of the input.

## Real World Applications of Finding Loop In Linked List

Finding loops in linked lists has several real-world applications:

1. **Computer Network Troubleshooting:** In computer networks, packets of data are often sent through a series of routers. If there's a loop in the routing, packets could end up circulating indefinitely. Detecting these loops can help identify and correct routing issues.
2. **Operating System:** In operating systems, processes can form a chain where each process is waiting for a resource held by the next process, leading to a deadlock situation. The operating system can detect these loops to avoid deadlock.
3. **Software Debugging:** In software debugging, linked lists are often used to manage software objects. If there's a loop in the linked list, it may result in infinite loops in the software, causing crashes or consuming excessive resources. Detecting these loops can contribute to more robust and efficient software.
4. **Garbage Collection:** In languages that have a garbage collector, such as Java and Python, detecting loops in the object reference graph (which can be thought of as a linked list) makes it possible to identify and deallocate objects that are no longer in use.
5. **Computer Science Education:** Understanding how to find a loop in a linked list is a fundamental concept in computer science education. It helps students understand the concept of data structure and algorithms, which is crucial for problem-solving in coding and programming.