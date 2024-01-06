# Stack CRUD Array

## Introduction to Stack CRUD Array

In computer science, a stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. The CRUD array is a common implementation of a stack that supports four main operations: Create, Read, Update, and Delete.

The Create operation adds a new element to the top of the stack. The Read operation retrieves the element at the top of the stack without modifying the stack. The Update operation modifies the element at the top of the stack. The Delete operation removes the element at the top of the stack.

Using a stack CRUD array allows for efficient management of data, as elements can be easily added or removed from the top of the stack. This makes it a useful data structure in various applications, such as expression evaluation, backtracking algorithms, and browser history management. 

## Overview of Stack CRUD Array

A stack CRUD array is a data structure that follows the Last-In-First-Out (LIFO) principle. It supports four main operations: Create, Read, Update, and Delete.

- Create: Adds a new element to the top of the stack.
- Read: Retrieves the element at the top of the stack without modifying the stack.
- Update: Modifies the element at the top of the stack.
- Delete: Removes the element at the top of the stack.

By using a stack CRUD array, data can be efficiently managed by easily adding or removing elements from the top of the stack. This makes it a valuable data structure in various applications, including expression evaluation, backtracking algorithms, and browser history management.


## CODE:

#### Python

```Python
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

# Python program for performing Stack CRUD Array operations
# Stable: No
# Inplace: yes
# Adaptive: No

# Space complexity: O(n)
# Time complexity: O(1)


class STACK:
    def __init__(self, size):
        self.stack = []
        self.top = -1
        self.size = size - 1

     # push operation on stack  
    def push(self, val):
        self.top += 1
        if self.top <= self.size:
            self.stack.append(val)
        else:
            print("STACK AS OVER-FLOWN")

    # pop operation on stack
    def pop(self):
        if self.top >= 0:
            self.stack.pop(self.top)
            self.top -= 1
        else:
            print("STACK AS UNDER-FLOWN")

    # isunderflown function on stack
    def is_underflown(self):
        if self.top == -1:
            print("THE STACK IS UNDER-FLOWN")
        else:
            print("THE STACK IS NOT UNDER-FLOWN")

     # isoverflown function on stack
    def is_overflown(self):
        if self.top > self.size:
            print("THE STACK IS OVER-FLOWN")
        else:
            print("THE STACK IS NOT OVER-FLOWN")

     # display function on stack
    def display(self):
        if self.top == -1:
            print("|| EMPTY ||")
        else:
            for i in range(self.top + 1):
                print(f"|| {self.stack[i]} ||")

     # Top function on stack
    def display_top(self):
        if self.top == -1:
            print("THE STACK IS EMPTY")
        else:
            print("THE TOP MOST ELEMENT IN STACK IS:", self.stack[self.top])


# Test drive code:

size = int(input("Enter the size of the stack: "))
stack = STACK(size)

print("------IS UNDER-FLOWN OPERATION ON STACK---------")
stack.is_underflown()
stack.display()
print()
print("------------PUSH OPERATION ON STACK-------------")
for _ in range(size):
    element = int(input("Enter element to push onto the stack: "))
    stack.push(element)
    print("Stack status after push operation:")
    stack.display()
    print()

print("----------DISPLAY OPERATION ON STACK-----------")
stack.display()
print()
print("------------POP OPERATION ON STACK-------------")
for _ in range(size):
    stack.pop()
    print("Stack status after pop operation:")
    stack.display()
    print()

print("------IS OVER-FLOWN OPERATION ON STACK---------")
stack.is_overflown()
stack.display()
print()
print("---------TOP OPERATION ON STACK----------")
stack.display_top()
stack.display()
```

**Step-by-Step Explaination**

The code provided implements a stack class in Python. Let's break down the code structure:

1. The **STACK** class is defined with an __init__ method that initializes the stack, top pointer, and size.
2. The **push** method adds an element to the stack if it is not full.
3. The **pop** method removes the top element from the stack if it is not empty.
4. The **is_underflown** method checks if the stack is underflown (empty).
5. The **is_overflown** method checks if the stack is overflown (full).
6. The **display** method shows all the elements in the stack.
7. The **display_top** method returns the topmost element in the stack.
8. Finally, a test drive code is provided to demonstrate the usage of the stack class.


## CODE:

#### Java
```Java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Python program for performing Stack CRUD Array operations
// Stable: No
// Inplace: yes
// Adaptive: No

// Space complexity: O(n)
// Time complexity: O(1)

import java.util.Scanner;

class Stack {
    int top = -1;
    int size;
    int[] arr;

    Stack(int size) {
        this.size = size;
        arr = new int[size];
    }

    // push operation on stack  
    void push(int data) {
        if (top == -1) {
            arr[0] = data;
            top = 0;
            return;
        }
        if (top > -1 && top < size) {
            arr[++top] = data;
            return;
        }
        System.out.println("Stack Overflow");
        return;
    }

    // pop operation on stack
    void pop() {
        if (top == -1) {
            System.out.println("Empty Stack");
            return;
        }
        arr[top--] = 0;
    }

    // peek operation on stack
    void peek() {
        if (top == -1)
            return;
        System.out.println(arr[top]);
        return;
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Size of stack
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack s = new Stack(size);

        // no.of elements to push in stack
        System.out.print("Enter the number of elements to push onto the stack: ");
        int numElements = scanner.nextInt();
        // enter elements to be pushed into stack
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element to push onto the stack: ");
            int element = scanner.nextInt();
            s.push(element);
        }
        // Printing top element of stack
        System.out.print("Top element of the stack: ");
        s.peek();
        // printing elments of present stack
        System.out.println("Elements in the stack: ");
        s.print();

        // no.of elements to pop in stack
        System.out.print("Enter the number of elements to pop from the stack: ");
        int numPop = scanner.nextInt();
        for (int i = 0; i < numPop; i++) {
            s.pop();
        }

        // enter elements to be pushed into stack
        System.out.print("Enter the number of elements to push onto the stack: ");
        numElements = scanner.nextInt();
        for (int i = 0; i < numElements; i++) {
            System.out.print("Enter element to push onto the stack: ");
            int element = scanner.nextInt();
            s.push(element);
        }

        // printing elements of stack after operations
        System.out.println("Elements in the stack: ");
        s.print();
    }
}
```

**step by step explaination**

1. The code defines a class named **Stack** which represents a stack data structure implementation. It has instance variables **top**, **size**, and an integer array **arr** to store the stack elements.
2. The constructor **Stack(int size)** initializes the stack size and creates a new integer array of the specified size.
3. The **push(int data)** method adds an element to the stack. If the stack is empty, it assigns the element to the first index and updates the **top** variable. If the stack is not empty and there is space available, it increments **top** and adds the element to the next index. If the stack is full, it prints "Stack Overflow".
4. The **pop()** method removes the top element from the stack. If the stack is empty, it prints "Empty Stack". It assigns 0 to the top element to remove it.
5. The **peek()** method returns the top element of the stack without removing it. If the stack is empty, it does nothing.
6. The **print()** method prints all the elements in the stack from top to bottom.
7. In the **Main** class, an instance of **Stack** is created with a size of 5.
8. The **push()** method is called to add elements 10 and 20 to the stack.
9. The **peek()** method is called to print the top element, which is 20.
10. The **print()** method is called to print all the elements in the stack, which are 10 and 20.
11. The **pop()** method is called twice to remove the elements 20 and 10 from the stack.
12. The **push()** method is called three times to add elements 1, 2, and 3 to the stack.
13. The **print()** method is called to print all the elements in the stack, which are 1, 2, and 3.

This code demonstrates the basic operations of a stack data structure implemented using an array in Java.


## CODE:

#### CPP

```CPP
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Python program for performing Stack CRUD Array operations
// Stable: No
// Inplace: yes
// Adaptive: No

// Space complexity: O(n)
// Time complexity: O(1)

#include <iostream>

using namespace std;

class Stack {
private:
    int *arr;
    int top = -1;
    int max;

public:
    Stack(int size) {
        arr = new int[size];
        max = size;
    }

    // push operation on stack 
    void push(int data) {
        if (top == -1) {
            arr[0] = data;
            top = 0;
            return;
        }
        if (top > -1 && top < max) {
            arr[++top] = data;
            return;
        }
        cout << "Stack overflow" << endl;
        return;
    }

    // pop operation on stack 
    void pop() {
        if (top == -1) {
            cout << "Empty Stack" << endl;
            return;
        }
        arr[top--] = 0;
    }

    // peek operation on stack 
    void peek() {
        if (top == -1)
            return;
        cout << arr[top] << endl;
        return;
    }

    void print() {
        for (int i = 0; i <= top; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        return;
    }
};

int main() {
    int size;
    cout << "Enter the size of the stack: ";
    cin >> size;

    Stack s(size);

    // no.of elements to push in stack
    int numElements;
    cout << "Enter the number of elements to push onto the stack: ";
    cin >> numElements;

    // enter elements to be pushed into stack
    for (int i = 0; i < numElements; i++) {
        int element;
        cout << "Enter element to push onto the stack: ";
        cin >> element;
        s.push(element);
    }

    cout << "Top element of the stack: ";
    s.peek();

    cout << "Elements in the stack: ";
    s.print();

    // no.of elements to pop from stack
    int numPop;
    cout << "Enter the number of elements to pop from the stack: ";
    cin >> numPop;
    for (int i = 0; i < numPop; i++) {
        s.pop();
    }

    // no.of elements to push onto stack
    cout << "Enter the number of elements to push onto the stack: ";
    cin >> numElements;

    // elements to be pushed onto stack
    for (int i = 0; i < numElements; i++) {
        int element;
        cout << "Enter element to push onto the stack: ";
        cin >> element;
        s.push(element);
    }

    // Printing Elements of stack
    cout << "Elements in the stack: ";
    s.print();

    return 0;
}

```

**step by step explaination**

Here is a step-by-step explanation of the code:

1. The code begins by including the necessary header files and declaring the namespace.
2. The **Stack** class is defined, which will implement the stack functionality.
3. The private members of the **Stack** class are declared: **arr** (to store the elements of the stack), **top** (to keep track of the top element), and **max** (to store the maximum capacity of the stack).
4. The constructor of the **Stack** class is defined, which takes the size of the stack as a parameter. It dynamically allocates memory for the stack array and initializes the **top** and **max** variables.
5. The **push()** function is defined to insert an element into the stack. It checks if the stack is empty and inserts the element at the first index. If the stack is not empty and has space, it increments the **top** variable and inserts the element at the corresponding index. If the stack is full, it displays a "Stack overflow" message.
6. The **pop()** function is defined to remove the top element from the stack. It checks if the stack is empty and displays an "Empty Stack" message. Otherwise, it sets the top element to 0, effectively removing it from the stack.
7. The **peek()** function is defined to display the top element of the stack. If the stack is empty, it does nothing. Otherwise, it prints the value of the top element.
8. The **print()** function is defined to display all the elements of the stack. It iterates through the stack array and prints each element.
9. The **main()** function is implemented. It creates an instance of the **Stack** class with a size of 5.
10. Elements are pushed onto the stack using the **push()** function.
11. The **peek()** function is called to display the top element of the stack.
12. The **print()** function is called to display all the elements of the stack.
13. Elements are popped from the stack using the **pop()** function.
14. More elements are pushed onto the stack.
15. The **print()** function is called again to display the updated elements of the stack.

Finally, the program ends with a return statement.


## Time and Space Complexity Analysis

The time and space complexity of the stack CRUD array implementation can be analyzed as follows:

- **Time Complexity:**
    - Create (Push) Operation: The time complexity of adding an element to the top of the stack is O(1) since it only involves inserting the element at the top position.
    - Read (Top) Operation: The time complexity of retrieving the element at the top of the stack is O(1) as it directly accesses the top element.
    - Update Operation: The time complexity of modifying the element at the top of the stack is O(1) since it only involves updating the value at the top position.
    - Delete (Pop) Operation: The time complexity of removing the element at the top of the stack is O(1) as it removes the top element in constant time.
    - Overall, all the stack CRUD operations have a time complexity of O(1) since they involve constant time operations.
- **Space Complexity:**
    - The space complexity of the stack CRUD array is O(n), where n is the maximum size of the stack. This is because the stack uses an array to store its elements, and the space required is proportional to the maximum size of the stack.

It's important to note that the space complexity can vary depending on the implementation and specific requirements of the stack.


## Real-World Applications of Stack CRUD Array

The stack CRUD array data structure has various real-world applications due to its efficient management of data. Some of these applications include:

1. **Expression Evaluation**: Stacks are commonly used to evaluate arithmetic expressions. They can be used to convert infix expressions to postfix or prefix notation and then evaluate them. The LIFO property of stacks allows for easy evaluation of operators and operands.
2. **Backtracking Algorithms**: Backtracking algorithms, such as maze solving or graph traversal, often use stacks to keep track of the path or states. If a certain path or state is not feasible, it can be easily removed from the stack, allowing the algorithm to explore alternative options.
3. **Browser History Management**: Web browsers often use stacks to manage browsing history. Each visited webpage is added to the stack, and when the user clicks the "back" button, the most recent page is popped from the stack, allowing navigation back to the previous page.

These are just a few examples of how the stack CRUD array data structure can be applied in real-world scenarios. Its simplicity and efficiency make it a valuable tool for managing data and solving various computational problems.