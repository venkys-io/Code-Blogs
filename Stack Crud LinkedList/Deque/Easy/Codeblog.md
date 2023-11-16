# Stack CRUD LinkedList

## Introduction to Stack CRUD LinkedList

This document delves into the implementation of Stack CRUD (Create, Read, Update, Delete) operations using a LinkedList. A stack is a linear data structure that follows a specific order in which operations are performed. This order can either be LIFO (Last In First Out) or FILO (First In Last Out). On the other hand, a LinkedList is a type of data structure that is a sequence of nodes, with each node connected to the next one through a pointer. Utilizing LinkedLists for stack implementation facilitates dynamic sizes and efficient operations.

## Overview of Stack CRUD LinkedList

In a Stack CRUD LinkedList, the stack operations are implemented using a LinkedList. Here, the top of the stack is represented by the head of the LinkedList for efficient O(1) time complexity operations. In this implementation, the 'Create' operation adds a new node to the beginning of the LinkedList, 'Read' operation reads the top element of the stack, 'Update' operation modifies the value of the top node, and 'Delete' operation removes a node from the beginning of the LinkedList. The 'Update' operation is unique to this type of structure as traditional stacks only include Create (Push) and Delete (Pop) operations.

## Code

```python
/*copyrights to venkys.io
For more information visit https://venkys.io*/
// python program to perform Stack CRUD operations on linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
#creation of empty linked list
class Node:
    def __init__(self,data):
        self.data=data 
        self.next=None 
#Stack operations 
class StackLL:
    def __init__(self):
        self.top=None 

    # isempty operation on stack
    def isempty(self):
        return not self.top 
    # push operation to add element on the top of the stack
    def push(self,data):
        if not self.top:
            self.top=Node(data)
        else:
            temp=Node(data)
            temp.next=self.top
            self.top=temp 
    # pop operation to delete the top elements of the stack
    def pop(self):
        if self.top:
            x=self.top.data 
            self.top=self.top.next 
            return x
    # traversing the stack
    def traverse(self):
        head=self.top
        while head:
            print(head.data,end=" ")
            head=head.next 
        print()
    
#providing the inputs to the stack
stack=StackLL()
stack.push(10)
stack.push(20)
stack.push(30)
stack.traverse()
stack.push(40)
stack.push(50)
stack.push(60)
stack.traverse()
stack.pop()
stack.pop()
stack.pop()
stack.traverse()
```

## Step-by-Step Explanation

1. We define a class `Node` which will be used to create new nodes in the LinkedList. Each `Node` consists of data and a `next` pointer.
2. We define a class `StackLL` for the stack, with `top` being the top node in the stack.
3. The `isempty` function checks whether the stack is empty by checking if `top` is None.
4. The `push` function is used to add a new node to the stack. If the stack is empty, the new node becomes `top`. If the stack is not empty, the new node is added to the beginning of the LinkedList and becomes `top`.
5. The `pop` function is used to remove a node from the stack. If the stack is not empty, the node pointed to by `top` is removed and `top` becomes the next node.
6. The `traverse` function is used to print all the elements in the stack from `top` to bottom.
7. Finally, we create an instance of `StackLL` and perform a sequence of `push`, `traverse`, and `pop` operations to demonstrate how the stack works.

## Code

```java
/* Copy rights to venkys.io
For more information visit https://venkys.io*/
// Java program to perform Stack CRUD operations on linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
// cration of linked list and initialising a empty node to store data
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
// creating a class stack to perform stack operations
class Stack {
    Node top;
    // push operations helps in adding elements stack linkedlist
    void push(int data) {
        if (top == null) {
            top = new Node(data);
            return;
        }
        Node temp = new Node(data);
        temp.next = top;
        top = temp;

    }
    // pop operations is used in deleting top element from the stack
    void pop() {
        if (top == null)
            return;
        top = top.next;
    }
    // peek operation is used to return the top most element of the stack
    void peek() {
        if (top == null)
            return;
        System.out.println(top.data);
    }

    void print() {
        Node temp = top;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }
}
// input data to the stack 
class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.peek();
        s.print();
        s.pop();
        s.push(30);
        s.push(40);
        s.peek();
        s.print();

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
7. Finally, in the `main` method, we create a new `Stack` object and demonstrate the `push`, `peek`, `print`, and `pop` operations.

## Code
```cpp
/* Copy rights to venkys.io
For more information visit https://venkys.io*/
// CPP program to perform Stack CRUD operations on linkedlist
// Stable:No
// Inplace: Yes
// Adaptive:No
// Space complexity: O(n)
// Time complexity:O(1)
#include <iostream>
using namespace std;
/* creating class node for creating linkedlist */
class VSDnode{
	
	public:
	int data;
	VSDnode* next;
	
	VSDnode(int val){
		data=val;
		next=NULL;
}

};
/* push opeartion helps to add new elements to the stack crud linkedlist */
void VSDpush(VSDnode* &head,int val){
	VSDnode* n= new VSDnode(val);
	n->next=head;
	head=n;
}
/* pop opeartion helps to delete elements from the stack crud linkedlist */
void VSDpop(VSDnode* &head){
	if(head==NULL){
		cout<<"stack is empty can't pop"<<endl;
	}
	else{
		head=head->next;
	}
}
void VSDtop(VSDnode* &head){
	cout<<"The top of the stack is : "<<head->data<<endl;
}

void VSDdisplay(VSDnode* head){
	
	VSDnode* temp=head;
	while(temp!=NULL){
		cout<<temp->data<<"->";
		temp=temp->next;
	}
	cout<<"NULL"<<endl;
}
/* all the opeartions output are diaplayed here which are performed on stack crud linkedlist */
int main() {
	cout<<"-----empty stack created-----"<<endl;
	VSDnode* head=NULL;
	cout<<"-----pop operation------"<<endl;
	VSDpop(head);
	cout<<"-----push operation------"<<endl;
	VSDpush(head,1);
	cout<<"-----push operation------"<<endl;
	VSDpush(head,2);
	cout<<"-----top operation------"<<endl;
	VSDtop(head);
	cout<<"-----display operation------"<<endl;
	VSDdisplay(head);
	cout<<"-----pop operation------"<<endl;
	VSDpop(head);
	cout<<"-----display operation------"<<endl;
	VSDdisplay(head);
    return 0;
}
```
## Step-by-Step Explanation 

1. The `VSDnode` class is defined first. It contains two fields: `data`, which stores an integer, and `next`, which points to the next node in the stack.
2. The `VSDpush` function adds a node to the top of the stack. It creates a new node with the given value, sets the `next` field of the new node to point to the current top of the stack, and then sets the new node as the top of the stack.
3. The `VSDpop` function removes the top node from the stack. If the stack is not empty, it simply sets the `next` node of the current top node as the new top of the stack.
4. The `VSDtop` function displays the value of the top node of the stack.
5. The `VSDdisplay` function traverses the stack from top to bottom and prints all the nodes.
6. Finally, in the `main` function, a new stack is created and the `VSDpush`, `VSDpop`, `VSDtop`, and `VSDdisplay` operations are demonstrated.

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