<h1>QUEUES CRUD ARRAY</h1>

<h2>Queues</h2>

- Queues are a type of data structure that follows the First-In-First-Out (FIFO) principle.
- Elements are inserted at the rear and removed from the front of the queue.
- Common operations on a queue include enqueue, dequeue, and peek.
- Queues are commonly used in scenarios where the order of processing is important.

<h2>CRUD Operations</h2>

- CRUD stands for Create, Read, Update, and Delete.
- CRUD operations are the basic actions performed on data in a database or system.
- In the context of arrays, CRUD operations refer to the manipulation of elements.
- Create: Adding new elements to the array.
- Read: Accessing and retrieving elements from the array.
- Update: Modifying existing elements in the array.
- Delete: Removing elements from the array.

Arrays can be used to implement queues by utilizing the CRUD operations. Elements can be added to the end of the array, removed from the front of the array, and accessed from the front of the array.

Using arrays to implement queues allows for efficient insertion and removal of elements, making it a commonly used approach in programming.

<h2>INTRODUCTION:</h2>

Queues CRUD Array is a concept that combines the principles of queues and CRUD operations with the use of arrays. This approach leverages the First-In-First-Out (FIFO) principle of queues, where elements are inserted at the rear and removed from the front. The CRUD operations - Create, Read, Update, and Delete - are applied to manipulate elements within the array.

By utilizing arrays to implement queues, efficient insertion and removal of elements can be achieved. This makes the Queues CRUD Array concept a widely used approach in programming, especially in scenarios where the order of processing is crucial.

In this document, we will explore the fundamentals of queues, the CRUD operations, and how arrays can be utilized to implement queues effectively. Let's dive into the world of Queues CRUD Array and discover its practical applications in data structures and systems.

<h2>Code In Python:</h2>

```

# Python program for Queue

# Define the QUEUE class for implementing a basic queue data structure
class QUEUE:
    # Constructor to initialize the queue with the given size
    def __init__(self, size):
        self.queue = []  # List to store the elements of the queue
        self.front = -1  # Pointer indicating the front of the queue
        self.back = -1   # Pointer indicating the back of the queue
        self.size = size - 1  # Maximum size of the queue

    # Enqueue operation on the queue
    def enqueue(self, val):
        # Check if the queue is initially empty
        if self.front == -1:
            self.front += 1
            self.queue.append(val)
            self.back += 1
        elif self.back <= self.size:  # Check if the back pointer is within the allowed size limit
            self.queue.append(val)
            self.back += 1
        else:
            print("QUEUE IS OVER-FLOWN")

    # Dequeue operation on the queue
    def dequeue(self):
        # Check if the queue is initially empty
        if self.front == self.back:
            self.queue.pop(self.front)
            self.front -= 1
            self.back -= 1
        elif self.back > self.front and self.back <= self.size:
            self.queue.pop(self.front)
            self.back -= 1
        else:
            print("QUEUE AS UNDER-FLOWN")

    # Is Underflown function on the queue
    def is_underflown(self):
        if self.front < 0 and self.back < 0:
            print("THE QUEUE IS UNDER-FLOWN")
        else:
            print("THE QUEUE IS NOT UNDER-FLOWN")

    # Is Overflown function on the queue
    def is_overflown(self):
        if self.back > self.size:
            print("THE QUEUE IS OVER-FLOWN")
        else:
            print("THE QUEUE IS NOT OVER-FLOWN")

    # Display function on the queue
    def display(self):
        if self.front == -1 and self.back == -1:
            print("|| EMPTY ||")
        else:
            for i in range(self.back + 1):
                print(f"|| {self.queue[i]} |", end="")
            print()

    # Display front function on the queue
    def display_front(self):
        if self.front == -1:
            print("|| EMPTY ||")
        else:
            print("THE front MOST ELEMENT IN queue IS:", self.queue[self.front])

    # Display back function on the queue
    def display_back(self):
        if self.back == -1:
            print("|| EMPTY ||")
        else:
            print("THE front MOST ELEMENT IN queue IS:", self.queue[self.back])

# Test drive code:

# Create an instance of the QUEUE class with a maximum size of 5
queue = QUEUE(5)
print("------IS UNDER-FLOWN OPERATION ON QUEUE---------")
queue.is_underflown()
queue.display()
print()
print("------------ENQUEUE OPERATION ON QUEUE-------------")
queue.enqueue(10)
print("queue status after enqueue operation")
queue.display()
queue.enqueue(20)
print("queue status after enqueue operation")
queue.display()
queue.enqueue(30)
print("queue status after enqueue operation")
queue.display()
print()
print("--------DISPLAY FRONT OPERATION ON QUEUE---------")
queue.display_front()
queue.display()
print()
print("----------DISPLAY OPERATION ON QUEUE-----------")
queue.display()
print()
print("------------DEQUEUE OPERATION ON QUEUE-------------")
queue.dequeue()
print("queue status after dequeue operation")
queue.display()
queue.dequeue()
print("queue status after dequeue operation")
queue.display()
print()
print("------IS OVER-FLOWN OPERATION ON queue---------")
queue.is_overflown()
queue.display()
print()
print("--------DISPLAY BACK OPERATION ON QUEUE---------")
queue.display_back()
queue.display()
```

<h3>OUTPUT:</h3>

1 inserted into queue
2 inserted into queue
1 2
1 deleted from queue
2 deleted from queue
Queue underflow
1 inserted into queue
12 inserted into queue
13 inserted into queue
14 inserted into queue
15 inserted into queue
1 12 13 14 15
Queue overflow

<h2>STEP BY STEP EXPLANATION:</h2>

1.Class Definition (QUEUE):

Defines a class named QUEUE to implement a basic queue data structure.

2.Constructor (**init** method):

Initializes the queue with the given size.
Sets up the queue as an empty list (self.queue), and initializes front and back pointers (self.front, self.back) to -1.
self.size is set to the given size minus 1.

3.Enqueue Operation (enqueue method):

Adds an element to the back of the queue.
If the queue is initially empty, adjusts front and back pointers accordingly.
Checks if the back pointer is within the allowed size limit; otherwise, prints an overflow message.

4.Dequeue Operation (dequeue method):

Removes an element from the front of the queue.
Checks if the queue is initially empty, and adjusts front and back pointers accordingly.
Checks if the back pointer is greater than the front pointer and within the allowed size limit; otherwise, prints an underflow message.

[5. Is](http://5.is/) Underflown (is_underflown method):

Checks if the queue is underflown (empty).

[6.Is](http://6.is/) Overflown (is_overflown method):

Checks if the queue is overflown (full).

7.Display Queue (display method):

Displays the elements of the queue.
Handles the case when the queue is initially empty.

8.Display Front Element (display_front method):

Displays the front-most element in the queue.

9.Display Back Element (display_back method):

Displays the back-most element in the queue.

10.Test Drive Code:

Creates an instance of the QUEUE class with a maximum size of 5.
Demonstrates various operations such as enqueue, dequeue, display, and overflow/underflow checks.

<h2>Code In Java:</h2>

```
class Queue {
    private int capacity;
    private int[] queue;
    private int front, rear;

    // Constructor to initialize the queue with the given capacity
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = this.rear = -1;
    }

    // Create/Enqueue operation
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            queue[rear] = item;
            System.out.println("Enqueued: " + item);
        }
    }

    // Read/Display operation
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            int i = front;
            do {
                System.out.print(queue[i] + " ");
                i = (i + 1) % capacity;
            } while (i != (rear + 1) % capacity);
            System.out.println();
        }
    }

    // Update operation (not applicable for a basic queue)

    // Delete/Dequeue operation
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            int removedItem = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            System.out.println("Dequeued: " + removedItem);
        }
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

// Test drive code:

public class Main {
    public static void main(String[] args) {
        // Create a queue with a capacity of 5
        Queue queue = new Queue(5);

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Display the queue
        queue.display();

        // Dequeue elements
        queue.dequeue();
        queue.dequeue();

        // Display the updated queue
        queue.display();
    }
}
```

<h2>STEP BY STEP EXPLANATION:</h2>

1.Class Definition (Queue):

Defines a class named Queue for implementing a basic queue data structure.
2.Constructor (Queue(int capacity)):

Initializes the queue with the given capacity.
Sets up the queue as an array (queue) with the specified capacity and initializes front and rear pointers (front, rear) to -1.

3.Enqueue Operation (enqueue method):

Adds an element to the back of the queue.
Checks if the queue is full. If it is, prints a message indicating that the queue is full and cannot enqueue.
If the queue is initially empty, adjusts front and rear pointers accordingly.
Checks if the rear pointer is within the allowed capacity; otherwise, uses a circular approach to adjust the rear pointer.
Inserts the item at the calculated rear position in the array.

4.Display Operation (display method):

Displays the elements of the queue.
Checks if the queue is empty. If it is, prints a message indicating that the queue is empty.
Uses a loop to traverse the elements in the array and prints each element in the queue.

5.Dequeue Operation (dequeue method):

Removes an element from the front of the queue.
Checks if the queue is empty. If it is, prints a message indicating that the queue is empty and cannot dequeue.
Retrieves the item from the front of the queue.
If the front pointer is equal to the rear pointer, sets both pointers to -1 to indicate an empty queue.
Otherwise, uses a circular approach to adjust the front pointer.

[6.Is](http://6.is/) Empty (isEmpty method):

Checks if the queue is empty.
Returns true if the front pointer is -1; otherwise, returns false.

[7.Is](http://7.is/) Full (isFull method):

Checks if the queue is full.
Returns true if the next position of the rear pointer is equal to the front pointer; otherwise, returns false.

8.Test Drive Code (Main class):

Creates an instance of the Queue class with a capacity of 5.
Enqueues elements (10, 20, 30).
Displays the queue.
Dequeues elements.
Displays the updated queue.
This code provides a simple implementation of a queue with basic operations and includes a test drive section to showcase the functionality.

<h2>Code In C++:</h2>

```
#include <iostream>
using namespace std;

class Queue {
private:
    int capacity;
    int* queue;
    int front, rear;

public:
    // Constructor to initialize the queue with the given capacity
    Queue(int capacity) {
        this->capacity = capacity;
        this->queue = new int[capacity];
        this->front = this->rear = -1;
    }

    // Create/Enqueue operation
    void enqueue(int item) {
        if (isFull()) {
            cout << "Queue is full. Cannot enqueue." << endl;
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % capacity;
            }
            queue[rear] = item;
            cout << "Enqueued: " << item << endl;
        }
    }

    // Read/Display operation
    void display() {
        if (isEmpty()) {
            cout << "Queue is empty." << endl;
        } else {
            cout << "Queue: ";
            int i = front;
            do {
                cout << queue[i] << " ";
                i = (i + 1) % capacity;
            } while (i != (rear + 1) % capacity);
            cout << endl;
        }
    }

    // Update operation (not applicable for a basic queue)

    // Delete/Dequeue operation
    void dequeue() {
        if (isEmpty()) {
            cout << "Queue is empty. Cannot dequeue." << endl;
        } else {
            int removedItem = queue[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            cout << "Dequeued: " << removedItem << endl;
        }
    }

    // Check if the queue is empty
    bool isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    bool isFull() {
        return (rear + 1) % capacity == front;
    }

    // Destructor to free allocated memory
    ~Queue() {
        delete[] queue;
    }
};

// Test drive code:
int main() {
    // Create a queue with a capacity of 5
    Queue queue(5);

    // Enqueue elements
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);

    // Display the queue
    queue.display();

    // Dequeue elements
    queue.dequeue();
    queue.dequeue();

    // Display the updated queue
    queue.display();

    return 0;
}
```

<h2>STEP BY STEP EXPLANATION:</h2>

1.Class Definition (Queue):

Defines a class named Queue for implementing a basic queue data structure.

2.Constructor (Queue(int capacity)):

Initializes the queue with the given capacity.
Sets up the queue as an array (queue) with the specified capacity and initializes front and rear pointers (front, rear) to -1.

3.Enqueue Operation (enqueue method):

Adds an element to the back of the queue.
Checks if the queue is full. If it is, prints a message indicating that the queue is full and cannot enqueue.
If the queue is initially empty, adjusts front and rear pointers accordingly.
Checks if the rear pointer is within the allowed capacity; otherwise, uses a circular approach to adjust the rear pointer.
Inserts the item at the calculated rear position in the array.

4.Display Operation (display method):

Displays the elements of the queue.
Checks if the queue is empty. If it is, prints a message indicating that the queue is empty.
Uses a loop to traverse the elements in the array and prints each element in the queue.

5.Dequeue Operation (dequeue method):

Removes an element from the front of the queue.
Checks if the queue is empty. If it is, prints a message indicating that the queue is empty and cannot dequeue.
Retrieves the item from the front of the queue.
If the front pointer is equal to the rear pointer, sets both pointers to -1 to indicate an empty queue.
Otherwise, uses a circular approach to adjust the front pointer.

[6.Is](http://6.is/) Empty (isEmpty method):

Checks if the queue is empty.
Returns true if the front pointer is -1; otherwise, returns false.

[7.Is](http://7.is/) Full (isFull method):

Checks if the queue is full.
Returns true if the next position of the rear pointer is equal to the front pointer; otherwise, returns false.

8.Destructor (~Queue):

Frees the allocated memory for the dynamic array.

9.Test Drive Code (main function):

Creates an instance of the Queue class with a capacity of 5.
Enqueues elements (10, 20, 30).
Displays the queue.
Dequeues elements.
Displays the updated queue.
This code provides a simple implementation of a queue with basic operations and includes a test drive section to showcase the functionality.

<h2>Time And Space Complexity:</h2>

Time Complexity:

1.Enqueue Operation (enqueue method):

Time complexity is O(1) on average.
Adding an element to the back of the queue involves simple arithmetic operations to update the rear pointer.

2.Display Operation (display method):

Time complexity is O(n), where n is the number of elements in the queue.
Displaying all elements requires traversing the entire array.

3.Dequeue Operation (dequeue method):

Time complexity is O(1) on average.
Removing an element from the front of the queue involves simple arithmetic operations to update the front pointer.

Space Complexity:

1.Storage for Queue Elements:

Space complexity is O(capacity), where capacity is the maximum capacity of the queue.
Memory is allocated for the array to store the elements of the queue.

2.Pointers and Variables:

Space complexity is O(1).
The number of additional variables (front, rear, etc.) used in the implementation is constant.

3.Destructor (~Queue):

Space complexity for the destructor is O(1).
Deallocating the memory for the dynamic array doesn't depend on the size of the array.

Overall:
The overall time complexity for a sequence of enqueue, display, and dequeue operations is determined by the most time-consuming operation, which is displaying the elements (O(n)).
The overall space complexity is O(capacity) since the size of the array is the dominant factor in terms of memory usage.
These complexities assume a basic queue implementation without optimizations for special cases (e.g., dynamic resizing for enqueue operations).

<h2>Real-World Applications:</h2>

1.Print Queue:

In a printer, documents are processed in the order they are sent to the print queue. The first document in the queue is the first to be printed.

2.Task Scheduling:

Operating systems often use queues to manage processes. The ready queue holds processes waiting to be executed, and the CPU scheduler selects the next process to run.

3.Breadth-First Search (BFS) in Graphs:

BFS uses a queue to explore a graph level by level. It starts at the root (or source) and explores all its neighbors before moving on to the next level.

4.Order Processing in Restaurants:

In restaurants, orders are taken in a first-come, first-served manner. The kitchen processes orders in the order they are received.

5.Buffer in Networking:

Queues are used in networking to manage the flow of data between different network devices. For example, in routers, packets are queued and processed in the order they arrive.

6.Call Center Systems:

In call centers, incoming calls are placed in a queue and are directed to available agents based on the order of arrival.

7.Print Job Management in Printers:

In a network printer, multiple users may send print jobs simultaneously. These jobs are placed in a queue, and the printer processes them one by one.

8.Task Management in Operating Systems:

The task scheduling mechanism in operating systems often uses queues. Tasks waiting to be executed are placed in a queue, and the scheduler selects tasks based on priority or other scheduling algorithms.

9.Browsing History in Web Browsers:

Web browsers often use a queue to manage the history of visited pages. When you click on a link, the current page is added to the back of the history queue.

10.Order Fulfillment in Warehouses:

In logistics and e-commerce, orders waiting to be processed and shipped can be organized in a queue. The first order in the queue is typically the first to be fulfilled.
