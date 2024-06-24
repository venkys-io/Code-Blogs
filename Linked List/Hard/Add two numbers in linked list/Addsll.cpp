/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to add two numbers in a linked list*/// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: (max(N, M)), where N and M are the lengths of the input linked lists.
//The extra space is used to store the resulting linked list.

//Time Complexity:O(max(N, M)), where N and M are the lengths of the input linked lists.

#include <iostream> // It is a standard C++ header file that includes declarations for the standard input/output stream objects like cout, cin, etc.
#include <vector> // Includes the Standard Template Library (STL) vector header for dynamic arrays.
#include <limits>  // Include the header for numeric_limits

using namespace std; // Using the standard namespace for simplifying code

// Node class representing a node in a linked list
class Node {
public:
    int data;
    Node* next = NULL; // Pointer to the next node in the linked list, initially set to NULL

	// Constructor to initialize a node with the given value
    Node(int val) {
        data = val;
    }
};

//Function to print the linked list in reverse without arrows
void printReverse(Node* head){
	// Base case: If the current node is NULL (end of the list), return
    if (head==NULL){
        return;
    }
    // Recursive call: Move to the next node in the list
    printReverse(head->next);
    // Print the data of the current node
    cout << head->data << "";
}

/*// Function to print the linked list
void print(Node* head) {
    Node* temp = head;
    while (temp != NULL) {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << endl;
}
*/

// Function to build a linked list with a single node
Node* buildSingleNode(int val) {
    return new Node(val);
}

// Function to add two numbers represented as linked lists
Node* addTwoNumbers(Node* l1, Node* l2) {
	// Create a temporary node to serve as the dummy head of the result linked list
    Node* temp = new Node(0);
    // Pointer to the head of the result linked list
    Node* head = temp;
     // Variable to store the carry during addition
    int c = 0;

    // Loop until there are elements in either l1 or l2, or there is a carry
    while (l1 != NULL || l2 != NULL || c != 0) {
        // Add corresponding digits from l1 and l2, along with the carry
        if (l1 != NULL) {
            c += l1->data;
            l1 = l1->next;
        }
        if (l2 != NULL) {
            c += l2->data;
            l2 = l2->next;
        }

        // Create a new node with the sum % 10 and update carry
        temp->next = new Node(c % 10);
        c = c / 10;
        temp = temp->next;
    }
    // Return the result linked list starting from the second node (as the first node is the dummy head)
    return head->next;
}

int main() {
    int num1, num2;

    // Input the first number
    cout << "Enter the first number: ";
    cin >> num1;

    // Input the second number
    cout << "Enter the second number: ";
    cin >> num2;

    // Create linked lists with a single node for each number
    Node* l1 = buildSingleNode(num1);
    Node* l2 = buildSingleNode(num2);

    // Add the two numbers and print the result
    Node* ans = addTwoNumbers(l1, l2);
    cout << "Sum of the two numbers: ";
    printReverse(ans);
    cout << endl;

    // Cleanup: Release memory
    delete l1;
    delete l2;
    delete ans;

    return 0;
}
