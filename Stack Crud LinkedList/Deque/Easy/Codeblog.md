# Stack CRUD LinkedList

## Introduction to Stack CRUD LinkedList

This document delves into the implementation of Stack CRUD (Create, Read, Update, Delete) operations using a LinkedList. A stack is a linear data structure that follows a specific order in which operations are performed. This order can either be LIFO (Last In First Out) or FILO (First In Last Out). On the other hand, a LinkedList is a type of data structure that is a sequence of nodes, with each node connected to the next one through a pointer. Utilizing LinkedLists for stack implementation facilitates dynamic sizes and efficient operations.

## Overview of Stack CRUD LinkedList

In a Stack CRUD LinkedList, the stack operations are implemented using a LinkedList. Here, the top of the stack is represented by the head of the LinkedList for efficient O(1) time complexity operations. In this implementation, the 'Create' operation adds a new node to the beginning of the LinkedList, 'Read' operation reads the top element of the stack, 'Update' operation modifies the value of the top node, and 'Delete' operation removes a node from the beginning of the LinkedList. The 'Update' operation is unique to this type of structure as traditional stacks only include Create (Push) and Delete (Pop) operations.

## Code

```python
#copyrights to venkys.io
#python program to perform Stack CRUD operations on linkedlist
#Stable:No
#Inplace: Yes
#Adaptive:No
#Space complexity: O(n)
#Time complexity:O(1)
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class StackLL:
    def __init__(self):
        self.top = None

    def isempty(self):
        #Check if the stack is empty.#
        return not self.top

    def push(self, data):
        #Push a new element onto the stack.
        if not self.top:
            self.top = Node(data)
        else:
            temp = Node(data)
            temp.next = self.top
            self.top = temp

    def pop(self):
        #Pop the top element from the stack and return its value.
        if self.top:
            x = self.top.data
            self.top = self.top.next
            return x
        else:
            print("Stack is empty. Cannot pop.")

    def traverse(self):
        #Traverse and print the elements in the stack.
        head = self.top
        while head:
            print(head.data, end=" ")
            head = head.next
        print()
# Create an instance of StackLL
stack = StackLL()
while True:
    print("\nSelect stack operation:")
    print("1. Push")
    print("2. Pop")
    print("3. Display")
    print("4. Exit")

    choice = input("Enter choice (1/2/3/4): ")

    if choice == '1':
        data = input("Enter data to push onto the stack: ")
        stack.push(data)
        print(f"{data} pushed onto the stack.")
    elif choice == '2':
        popped_element = stack.pop()
        if popped_element is not None:
            print(f"Popped element: {popped_element}")
    elif choice == '3':
        print("Stack elements:")
        stack.traverse()
    elif choice == '4':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please enter a valid option.")


```

## Step-by-Step Explanation

1. We define a class `Node` which will be used to create new nodes in the LinkedList. Each `Node` consists of data and a `next` pointer.
2. We define a class `StackLL` for the stack, with `top` being the top node in the stack.
3. The `isempty` function checks whether the stack is empty by checking if `top` is None.
4. The `push` function is used to add a new node to the stack. If the stack is empty, the new node becomes `top`. If the stack is not empty, the new node is added to the beginning of the LinkedList and becomes `top`.
5. The `pop` function is used to remove a node from the stack. If the stack is not empty, the node pointed to by `top` is removed and `top` becomes the next node.
6. The `traverse` function is used to print all the elements in the stack from `top` to bottom.
7. Finally, we create an instance of `StackLL` and perform a sequence of `push`, `traverse`, and `pop` operations to demonstrate how the stack works based on the user choice using while loop.

## Test Case 1: Empty Stack (null)
- Input:
Choose option 4 (Display) when the stack is empty.
- Expected Output:
The program should print "Stack is empty" as there are no elements in the stack.
## Test Case 2: Push and Pop Operations (true)
- Input:
Choose option 1 (Push) and enter the value 42.
Choose option 1 (Push) and enter the value 17.
Choose option 2 (Pop) to remove the top element.
Choose option 4 (Display) to show the elements.
- Expected Output:
The program should print:
arduino
Copy code
42 pushed onto the stack.
17 pushed onto the stack.
17 popped from the stack.
42->
## Test Case 3: Top Operation on Empty Stack (false)
- Input:
Choose option 3 (Top) when the stack is empty.
- Expected Output:
The program should print "Stack is empty. Cannot get top." since there are no elements in the stack, and it cannot retrieve the top element.

## Code

```java
// Copy rights to venkys.io
// Java program to perform Stack CRUD operations on linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
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

```

## Step-by-Step Explanation 

1. We first define a `Node` class in Java. Each `Node` contains an integer `data` and a `next` field which points to the next node in the stack.
2. We then define a `Stack` class which contains a `Node` `top`, representing the top of the stack.
3. The `push` method is used to add a new node to the stack. If the stack is empty (`top` is null), we create a new `Node` with the given data and set it as `top`. If the stack is not empty, we create a new `Node` with the given data, set its `next` field to the current `top`, and then update `top` to point to the new node.
4. The `pop` method is used to remove the top node from the stack. If the stack is not empty, we simply update `top` to point to the next node.
5. The `peek` method is used to view the data of the top node without removing it from the stack. If the stack is not empty, we print the data of the `top` node.
6. The `print` method is used to print all the data in the stack from top to bottom.
7. Finally, in the `main` method, we create a new `Stack` object and demonstrate the `push`, `peek`, `print`, and `pop` operations are performed based on user choice using while loop.
## Test Case 1: Empty Stack (null)
- Input:
Choose option 4 (Display) when the stack is empty.
- Expected Output:
The program should print "Stack is empty" as there are no elements in the stack.
## Test Case 2: Push and Pop Operations (true)
- Input:
Choose option 1 (Push) and enter the value 42.
Choose option 1 (Push) and enter the value 17.
Choose option 2 (Pop) to remove the top element.
Choose option 4 (Display) to show the elements.
- Expected Output:
The program should print:
arduino
Copy code
42 pushed onto the stack.
17 pushed onto the stack.
17 popped from the stack.
42->
## Test Case 3: Top Operation on Empty Stack (false)
- Input:
Choose option 3 (Top) when the stack is empty.
- Expected Output:
The program should print "Stack is empty. Cannot get top." since there are no elements in the stack, and it cannot retrieve the top element.


## Code
```cpp
/* Copy rights to venkys.io */
/* CPP program to perform Stack CRUD operations on linkedlist*/
/* Stable:No */
/* Inplace: Yes*/
/* Adaptive:No*/
/* Space complexity: O(n)*/
/* Time complexity:O(1) */
#include <iostream>
using namespace std;

class VSDnode {
public:
    int data;
    VSDnode* next;

    VSDnode(int val) {
        data = val;
        next = NULL;
    }
};

/* Function to push a new element onto the stack*/
void VSDpush(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    n->next = head;
    head = n;
}

/* Function to pop the top element from the stack */
void VSDpop(VSDnode* &head) {
    if (head == NULL) {
        cout << "Stack is empty. Cannot pop." << endl;
    } else {
        head = head->next;
    }
}

/* Function to get the top element of the stack */
void VSDtop(VSDnode* &head) {
    if (head != NULL) {
        cout << "The top of the stack is: " << head->data << endl;
    } else {
        cout << "Stack is empty. Cannot get top." << endl;
    }
}

/* Function to display the elements of the stack */
void VSDdisplay(VSDnode* head) {
    VSDnode* temp = head;
    while (temp != NULL) {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

int main() {
    VSDnode* head = NULL;

    while (true) {
        cout << "\nStack Operations:" << endl;
        cout << "1. Push" << endl;
        cout << "2. Pop" << endl;
        cout << "3. Top" << endl;
        cout << "4. Display" << endl;
        cout << "5. Quit" << endl;

        int choice;
        cout << "Enter your choice (1/2/3/4/5): ";
        cin >> choice;

        switch (choice) {
            case 1: {
                int val;
                cout << "Enter the value to push onto the stack: ";
                cin >> val;
                VSDpush(head, val);
                cout << val << " pushed onto the stack." << endl;
                break;
            }
            case 2:
                VSDpop(head);
                break;
            case 3:
                VSDtop(head);
                break;
            case 4:
                VSDdisplay(head);
                break;
            case 5:
                cout << "Quitting the program." << endl;
                return 0;
            default:
                cout << "Invalid choice. Please enter 1, 2, 3, 4, or 5." << endl;
        }
    }

    return 0;
}

```
## Step-by-Step Explanation 

1. The `VSDnode` class is defined first. It contains two fields: `data`, which stores an integer, and `next`, which points to the next node in the stack.
2. The `VSDpush` function adds a node to the top of the stack. It creates a new node with the given value, sets the `next` field of the new node to point to the current top of the stack, and then sets the new node as the top of the stack.
3. The `VSDpop` function removes the top node from the stack. If the stack is not empty, it simply sets the `next` node of the current top node as the new top of the stack.
4. The `VSDtop` function displays the value of the top node of the stack.
5. The `VSDdisplay` function traverses the stack from top to bottom and prints all the nodes.
6. Finally, in the `main` function, a new stack is created and the `VSDpush`, `VSDpop`, `VSDtop`, and `VSDdisplay` operations are demonstrated using switch case based on users choice.
## Test Case 1: Empty Stack (null)
- Input:
Choose option 4 (Display) when the stack is empty.
- Expected Output:
The program should print "Stack is empty" as there are no elements in the stack.
## Test Case 2: Push and Pop Operations (true)
- Input:
Choose option 1 (Push) and enter the value 42.
Choose option 1 (Push) and enter the value 17.
Choose option 2 (Pop) to remove the top element.
Choose option 4 (Display) to show the elements.
- Expected Output:
The program should print:
arduino
Copy code
42 pushed onto the stack.
17 pushed onto the stack.
17 popped from the stack.
42->
## Test Case 3: Top Operation on Empty Stack (false)
- Input:
Choose option 3 (Top) when the stack is empty.
- Expected Output:
The program should print "Stack is empty. Cannot get top." since there are no elements in the stack, and it cannot retrieve the top element.


## Time and Space Complexity Analysis

When it comes to analyzing the time and space complexity of Stack CRUD operations implemented using LinkedList, it's important to note that these operations are quite efficient.

- **Push Operation (Create):** The push operation involves adding a new element to the top of the stack. Since this operation does not involve any traversal and only a constant amount of work (creating a new node and adjusting a pointer) is done, the time complexity is O(1). The space complexity is also O(1) as only a single new node is created each time this operation is performed.
- **Pop Operation (Delete):** The pop operation involves removing an element from the top of the stack. Similar to the push operation, it does not involve any traversal and only a constant amount of work (adjusting a pointer) is done. Hence, the time complexity is O(1). As we are only deleting existing nodes and not creating any new space, the space complexity is O(1).
- **Peek/Top Operation (Read):** The peek or top operation involves retrieving the element at the top of the stack without removing it. Since this operation also involves no traversal and only a constant amount of work (returning the value of the top node), the time complexity is O(1). As no additional space is created during this operation, the space complexity is O(1).
- **Update Operation:** The update operation involves modifying the value of the top node. This operation also involves no traversal and only a constant amount of work (changing the value of the top node), hence the time complexity is O(1). The space complexity is O(1) as no additional space is created during this operation.
- **IsEmpty Operation:** This operation checks whether the stack is empty by checking if the top pointer is null. Since it involves only a constant amount of work, the time complexity is O(1). The space complexity is also O(1) as no additional space is created during this operation.

In terms of space complexity, a stack implemented using LinkedLists will have a space complexity of O(n), where n is the number of elements in the stack. This is because each element in the stack is stored as a separate node in the LinkedList.

Therefore, using LinkedList to implement a stack is quite efficient, resulting in time complexities of O(1) for all operations and a space complexity of O(n) for storing n elements in the stack.

## Real World Applications of Stack CRUD LinkedList

Stacks and their operations (Create, Read, Update, Delete) using LinkedLists have a wide range of real-world applications. Here are a few examples:

1. **Browser History:** Web browsers use a stack to manage the history of visited websites. When a user visits a new page, the address is pushed onto the stack. The 'back' button pops the address off the top of the stack, and the 'forward' button pushes it back on.
2. **Undo Functionality:** Many software applications, like word processors or graphics editors, use a stack to implement the undo functionality. Every operation is pushed onto the stack, and when the user wants to undo an action, the most recent operation is popped from the stack and reversed.
3. **Function Call Stack:** In programming languages, a stack is used to manage function calls. When a function is called, a new frame is pushed onto the stack with the return address and local variables. When the function returns, its frame is popped from the stack.
4. **Syntax Parsing:** Stacks are used in compilers and calculators to parse expressions and check if the syntax of brackets or parentheses is correct.
5. **Backtracking Problems:** In algorithms, stacks are used for backtracking problems. For instance, they are used in maze solving problems, where each move is pushed onto the stack and if a dead-end is reached, moves are popped off the stack until a new path is found.
6. **Memory Management:** In operating systems, stacks are used for memory management, managing the execution of threads, and more.
The use of LinkedList in implementing a stack is advantageous because it allows for dynamic resizing and efficient operations, which can be crucial in real-time applications.