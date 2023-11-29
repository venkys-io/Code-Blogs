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
/* Copy rights to venkys.io
For more information visit https://venkys.io*/
// Python program to perform CRUD operations on double linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
#Double linked list program with CRUD operations
class Node:
    
    def __init__(self,val):
        self.prev=None
        self.data=val
        self.next=None

class DLL:

    def __init__(self):
        self.head = None

    # Now 'C' create functions of linked list
        
    def insert_begin(self,val):
        newnode=Node(val)
        if self.head :
            self.head.prev = newnode
            newnode.next = self.head
            self.head = newnode
        else:
            self.head = newnode
        
    def insert_end(self,val):
        newnode=Node(val)
        if self.head is None:
            self.head=newnode
        else:
            temp=self.head
            while temp.next:
                temp=temp.next
            newnode.prev = temp
            temp.next = newnode
            
    def insert_pos(self,val,pos):
        count=0
        temp=self.head
        while temp:
            count+=1
            if count==pos:
                break
            else:
                temp=temp.next
        newnode=Node(val)
        newnode.prev=temp.prev
        newnode.next=temp
        temp.prev.next = newnode
        
    # Now delete functions of linked list
    
    def delete_begin(self):
        if self.head is None:
            return
        else:
            self.head=self.head.next
            self.head.prev = None

    def delete_end(self):
        if self.head is None:
            delete_begin()
        elif self.head.next is None:
            self.head=None
        else:
            temp=self.head
            while temp.next:
                temp=temp.next
            temp.prev.next = None
            
    def delete_pos(self,pos):
        count=0
        temp=self.head
        while temp:
            count+=1
            if count==pos:
                break
            else:
                temp=temp.next
        if temp.next :
            temp.next.prev = temp.prev
            temp.prev.next = temp.next
        else:
            temp.prev.next = None
        

    # NOW 'U' update function of linked list

    def update(self,pval,nval):
        if self.head :
            temp=self.head
            while temp :
                if temp.data == pval:
                    temp.data = nval
                    break
                temp=temp.next

     # NOW 'R' remove function of linked list

    def remove(self,val):
        if self.head.data == val:
            self.head = self.head.next
            if self.head :
                self.head.prev = None
        else:
            temp=self.head
            while temp.next :
                if temp.data == val :
                    if temp.next :
                        temp.next.prev = temp.prev
                        temp.prev.next = temp.next
                    else:
                        temp.prev.next = None
                    break
                temp=temp.next
                    
    # NOW 'D' display function of linked list

    def display(self):
        temp=self.head
        while temp:
            print(temp.data,end="<->")
            temp=temp.next
        print("None")
        

# Test drive code:
dll=DLL()
print("------------INSERTION OPERATIONS-------------")
print("Insert begin")
dll.insert_begin(1)
dll.display()
print("Insert begin")
dll.insert_begin(0)
dll.display()
print("Insert end")
dll.insert_end(2)
dll.display()
print("Insert end")
dll.insert_end(4)
dll.display()
print("Insert position")
dll.insert_pos(3,4)
dll.display()
print()
print("------------DELETION OPERATIONS-------------")
print("Delete begin")
dll.delete_begin()
dll.display()
print("Delete position")
dll.delete_pos(3)
dll.display()
print("Delete end")
dll.delete_end()
dll.display()
print()
print("-------------UPDATE OPERATION--------------")
dll.update(3,2)
dll.display()
dll.update(1,0)
dll.display()
dll.update(2,1)
dll.display()
print()
print("-------------REMOVE OPERATION--------------")
dll.remove(0)
dll.display()
dll.remove(1)
dll.display()
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
4. The program includes a test drive code that demonstrates the usage of the linked list methods.
5. The output of each operation is displayed to show the changes in the linked list.
You can copy the provided code and run it in a Python environment to see the results of each operation.

## Code

```java
/* Copy rights to venkys.io
For more information visit https://venkys.io*/
// Java program to perform CRUD operations on double linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
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

    void insert(int data) {
        if (head == null) {
            head = new Node(data);

            size++;
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head.prev = temp;
        head = temp;
        size++;
        return;
    }

    void delete() {
        if (head == null)
            return;
        head = head.next;
        head.prev = null;
        size--;
        return;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void size() {
        System.out.println(this.size);
    }
}

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList d = new DoubleLinkedList();
        d.insert(10);
        d.insert(20);
        d.print();
        d.delete();
        d.print();
        d.insert(30);
        d.insert(40);
        d.print();
        d.size();
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
    First, 10 and 20 are inserted to the list, making the list [20, 10].
    Then, the front node is deleted, making the list [10].
    30 and 40 are inserted to the list, making the list [40, 30, 10].
    Finally, the size of the list is printed, which is 3.

## Code
```
/* Copy rights to venkys.io
For more information visit https://venkys.io*/
// CPP program to perform CRUD operations on double linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
#include<bits/stdc++.h>
using namespace std;
class Node{
    public:
        int data;
        Node* next;
        Node* prev;

        Node(){
            data=0;
            next=NULL;
            prev=NULL;
        }
        Node(int val){
            data=val;
            next=NULL;
            prev=NULL;
        }
};

class DoubleLinkedList{
    private:
        Node* head=NULL;
        int length=0;
    
    public:
        

        void insert(int data){
            if(head == NULL){
                head= new Node(data);
                length++;
                return;
            }
            Node* temp=new Node(data);
            length++;
            temp->next=head;
            head->prev=temp;
            head=temp;
            return;

        }

        void del(){
            if(head == NULL) return;
            head=head->next;
            head->prev = NULL;
            length--;
            return;
        }

        void print(){
            Node* temp = head;
            while(temp != NULL){
                cout<<temp->data<<" ";
                temp=temp->next;
            }
            cout<<endl;
        }

        void size(){
            cout<<length<<endl;
        }
};

int main(){
    DoubleLinkedList s;
    s.insert(10);
    s.insert(20);
    s.print();
    s.del();
    s.print();
    s.insert(30);
    s.insert(40);
    s.print();
    s.size();
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
    First, 10 and 20 are inserted into the list, making the list [20, 10].
    Then, the front node is deleted, making the list [10].
    30 and 40 are inserted into the list, making the list [40, 30, 10].
Finally, the size of the list is printed, which is 3.
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