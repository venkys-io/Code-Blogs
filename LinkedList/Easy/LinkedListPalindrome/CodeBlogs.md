# Linked List Palindrome

## Introduction to Linked List Palindrome

A Linked List Palindrome refers to a linked list where the sequence of values in the nodes is the same forwards as it is backwards. This concept is often explored in computer science and data structures. It provides an interesting challenge for algorithm design and can be used to understand and practice various techniques for traversing and analyzing linked lists.

## Overview of Linked List Palindrome

A linked list is a data structure in which elements point to the next element in the sequence, forming a chain-like structure. A palindrome is a sequence that reads the same backwards as forwards. Therefore, a linked list palindrome is a linked list that reads the same forwards and backwards. This is usually achieved when the sequence of node values in the linked list is the same when read from the first node to the last, and vice versa. This concept, while simple in theory, can be complex in implementation, and is a common problem presented in computer science and data structures courses.

## Code

```python
# Copy rights to venkys.io
# For more information visit https://venkys.io
# Python program to perform Linked List Palindrome
# Stable:Yes
# Inplace:Yes
# Adaptive:No
# Space complexity: O(1)
# Time complexity:O(n)
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def create_list(llist):
    head = None
    temp = None
    for i in llist:
        if not temp:
            temp = Node(i)
            head = temp
        else:
            temp.next = Node(i)
            temp = temp.next
    return head

def check_palindrome(head):
    temp = head
    stack = []

    # Push elements of the first half onto the stack
    while head:
        stack.append(head.data)
        head = head.next

    # Compare the second half with the elements popped from the stack
    while temp:
        if temp.data != stack.pop():
            return False
        temp = temp.next

    return True

if __name__ == "__main__":
    # Take user input for the linked list
    user_input = input("Enter elements of the linked list separated by spaces: ")
    llist = list(map(int, user_input.split()))

    # Create the linked list
    head = create_list(llist)

    # Check if the linked list is a palindrome
    result = check_palindrome(head)

    # Print the result
    if result:
        print("The linked list is a palindrome.")
    else:
        print("The linked list is not a palindrome.")

```

## Step-by-Step Explanation

1. **Node Class Definition**: The `Node` class is defined with an initializer that takes a data parameter and sets the `next` attribute to `None`. This class will be used to create nodes for the linked list.
2. **Creating the Linked List**: The `createlist` function takes a list as input and creates a linked list from it. It initializes the `head` and `temp` to `None`. Then, for each element in the input list, it creates a new node and updates `temp` to the new node.
3. **Checking for Palindrome**: The `checkpalindrome` function takes the head of the linked list as input and checks if the linked list is a palindrome. It initializes an empty stack and a `temp` variable pointing to the head. Then, it iterates through the linked list, adding each node's data to the stack. Next, it iterates through the linked list again, this time popping elements from the stack and comparing them with the node data. If a node's data does not match the popped stack element, it returns `False`. If it completes the iteration without finding a mismatch, it returns `True`.
4. **Main Function**: In the main function, a list is defined, and the `createlist` function is called with this list to create a linked list. The `checkpalindrome` function is then called with the head of this linked list, and the result is printed. If the linked list is a palindrome, it prints `Plaindrome`; otherwise, `not palindrome`.
## Test Case 1 :Null Linked List
- Input: user_input = "" (Empty string)
- Output: "The linked list is a palindrome." (Since it's an empty list, it is considered a palindrome.)
## Test Case 2
- Input: user_input = "1 2 3 2 1"
- Output: "The linked list is a palindrome." (The linked list contains a palindrome sequence.)
## Test Case 3 
- Input: user_input = "1 2 3 4 5"
- Output: "The linked list is not a palindrome." (The linked list is not a palindrome as the elements do not read the same backward as forward.)

## Code

```java
//Copy rights to venkys.io
//For more information visit https://venkys.io
// Java program to perform Linked List Palindrome
// Stable:Yes
// Inplace:Yes
// Adaptive:No
// Space complexity: O(1)
// Time complexity:O(n)
import java.util.Scanner;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    // Function to create a linked list from an array of values
    static Node createList(int[] values) {
        Node head = null, temp = null;
        for (int value : values) {
            if (temp == null) {
                temp = new Node(value);
                head = temp;
            } else {
                temp.next = new Node(value);
                temp = temp.next;
            }
        }
        return head;
    }

    // Function to check if a linked list is a palindrome
    static boolean checkPalindrome(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();

        // Push elements of the first half onto the stack
        while (head != null) {
            stack.push(head.data);
            head = head.next;
        }

        // Compare the second half with the elements popped from the stack
        while (temp != null) {
            if (temp.data != stack.pop()) return false;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter values for the linked list
        System.out.print("Enter elements of the linked list separated by spaces: ");
        String userInput = scanner.nextLine();
        String[] valuesString = userInput.split(" ");

        // Convert the input values to integers
        int[] values = new int[valuesString.length];
        for (int i = 0; i < valuesString.length; i++) {
            values[i] = Integer.parseInt(valuesString[i]);
        }

        // Create the linked list
        Node head = createList(values);

        // Check if the linked list is a palindrome
        boolean result = checkPalindrome(head);

        // Print the result
        if (result) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}

```
## Step-by-Step Explanation

1. **Node Class Definition**: The `Node` class is defined with an initializer that accepts a data parameter. This class is used to create nodes for the linked list.
2. **Creating the Linked List**: The `createList` function takes an array as input and creates a linked list from it. It initializes `head` and `temp` to `null`. Then, for each element in the input array, it creates a new node and updates `temp` to the new node.
3. **Checking for Palindrome**: The `chechPalindrome` function takes the head of the linked list as input and checks if the linked list is a palindrome. It initializes an empty stack and a `temp` variable pointing to the head. Then, it goes through the linked list, adding each node's data to the stack. Next, it goes through the linked list again, this time popping elements from the stack and comparing them with the node data. If a node's data does not match the popped stack element, it returns `false`. If it completes the iteration without finding a mismatch, it returns `true`.
4. **Main Function**: In the main function, an array is defined, and the `createList` function is called with this array to create a linked list. The `chechPalindrome` function is then called with the head of this linked list, and the result is printed. If the linked list is a palindrome, it prints `palindrome`; otherwise, it prints `not palindrome`.
## Test Case 1 :Null Linked List
- Input: user_input = "" (Empty string)
- Output: "The linked list is a palindrome." (Since it's an empty list, it is considered a palindrome.)
## Test Case 2
- Input: user_input = "1 2 3 2 1"
- Output: "The linked list is a palindrome." (The linked list contains a palindrome sequence.)
## Test Case 3 
- Input: user_input = "1 2 3 4 5"
- Output: "The linked list is not a palindrome." (The linked list is not a palindrome as the elements do not read the same backward as forward.)
## Code

```cpp
/* Copy rights to venkys.io */
/* CPP program to perform Linked List Palindrome */
/* Stable:Yes */
/* Inplace:Yes */
/* Adaptive:No */
/* Space complexity: O(1) */
/* Time complexity:O(n) */
#include <iostream>
using namespace std;

/* Node class for the linked list */
class VSDnode {
public:
    int data;
    VSDnode* next;

    /* Constructor to initialize node with given value */
    VSDnode(int val) {
        data = val;
        next = NULL;
    }
};

/* Function to add a new node at the head of the linked list */
void add_head(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    n->next = head;
    head = n;
}

/* Function to add a new node at the tail of the linked list */
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

/* Function to display the linked list */
void display(VSDnode* head) {
    VSDnode* temp = head;
    while (temp != NULL) {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << "NULL" << endl;
}

/* Function to reverse the linked list */
VSDnode* reverse(VSDnode* head) {
    VSDnode* prev = NULL;
    VSDnode* curr = head;

    while (curr) {
        VSDnode* next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}

/* Function to check if the linked list is a palindrome */
void is_palindrome(VSDnode* head) {
    VSDnode* new_head = reverse(head);
    VSDnode* temp1 = head;
    VSDnode* temp2 = new_head;

    while (temp1) {
        if (temp1->data != temp2->data) {
            cout << "The linked list is not a palindrome" << endl;
            return;
        }
        temp1 = temp1->next;
        temp2 = temp2->next;
    }
    cout << "The linked list is a palindrome" << endl;
}

int main() {
    cout << "Enter the number of elements in the linked list: ";
    int n;
    cin >> n;

    VSDnode* head = NULL;

    cout << "Enter the elements of the linked list:" << endl;
    for (int i = 0; i < n; ++i) {
        int val;
        cin >> val;
        add_tail(head, val);
    }

    cout << "Linked List:" << endl;
    display(head);

    /* Check if the linked list is a palindrome */
    is_palindrome(head);

    return 0;
}

```

## Step-by-Step Explanation

1. **Node Class Definition**: The `VSDnode` class is defined with an initializer that accepts a data parameter. This class is used to create nodes for the linked list.
2. **Adding Node to Head**: The `add_head` function takes a head reference and a value as inputs. It creates a new node with the given value and adds it to the head of the linked list.
3. **Adding Node to Tail**: The `add_tail` function takes a head reference and a value as inputs. It creates a new node with the given value and adds it to the tail of the linked list.
4. **Displaying the Linked List**: The `display` function takes the head of the linked list as input and prints the linked list.
5. **Reversing the Linked List**: The `reverse` function takes the head of the linked list as input and returns the head of the reversed linked list.
6. **Checking for Palindrome**: The `is_palindrome` function takes the head of the linked list as input and checks if the linked list is a palindrome. It creates a reversed copy of the linked list and then compares each node in the original and reversed linked lists. If a node's data does not match, it prints "is not a palindrome" and returns. If it completes the iteration without finding a mismatch, it prints "is a palindrome".
7. **Main Function**: In the main function, an empty linked list is created, and nodes are added to the head and tail of the linked list using the `add_head` and `add_tail` functions. The linked list is displayed after each addition. The `is_palindrome` function is called to check if the linked list is a palindrome, and the result is printed.
## Test Case 1 :Null Linked List
- Input: user_input = "" (Empty string)
- Output: "The linked list is a palindrome." (Since it's an empty list, it is considered a palindrome.)
## Test Case 2
- Input: user_input = "1 2 3 2 1"
- Output: "The linked list is a palindrome." (The linked list contains a palindrome sequence.)
## Test Case 3 
- Input: user_input = "1 2 3 4 5"
- Output: "The linked list is not a palindrome." (The linked list is not a palindrome as the elements do not read the same backward as forward.)

## Time And Space Complexity Analysis

- For the **Python** solution, the time complexity of the `checkpalindrome` function is O(n), where n is the number of nodes in the linked list. This is because the function traverses the entire linked list twice: once to push the nodes' data onto the stack, and a second time to check for a palindrome. The space complexity is also O(n) due to the additional stack used to hold the nodes' data.
- For the **Java** solution, the time complexity of the `chechPalindrome` function is also O(n) for the same reasons. The space complexity is also O(n) due to the additional stack used to hold the nodes' data.
- The **C++** solution has a slightly different approach. It creates a reversed copy of the linked list for the palindrome check, so the time complexity remains O(n). However, creating a reversed copy increases the space complexity to O(2n), which simplifies to O(n). Note that this is still considered linear space complexity, but it uses twice as much space as the Python and Java solutions.

## Real-World Applications of Linked List Palindrome

Linked List Palindromes, while often seen as an academic or interview question, can have some practical applications in the real world.

1. **Natural Language Processing**: Palindromes are not limited to numbers or characters, they can also be sequences of words. For example, in natural language processing, or when building a language-based AI model, recognizing palindromes can be an interesting and challenging task. A linked list could be used to store a sequence of words, and then a palindrome algorithm could be used to check if the sequence is the same forwards and backwards.
2. **Genome Sequences**: In bioinformatics, palindromic sequences in DNA or RNA strands, which read the same from 5' to 3' on one strand as they do from 5' to 3' on the complementary strand, play an important role in the formation of various secondary structures in the DNA or RNA molecule. Linked list palindrome algorithms could potentially be adapted to handle this kind of analysis.
3. **Data Transmission**: In computer networks, certain data transmission protocols might involve the sending device appending a special sequence to the end of packets that is the reverse of a sequence at the start of the packets. The receiving device could then use a palindrome checking algorithm to verify that the packet has not been corrupted during transmission.
4. **Error Detection and Correction**: Palindrome properties are also used in error detection and correction techniques. For example, the Longitudinal Redundancy Check (LRC) is a form of parity check that groups bits into sequences, which should be palindromic. If these sequences are not palindromic, an error is detected.