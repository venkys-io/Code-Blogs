/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to add two numbers in a linked list*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: (max(N, M)), where N and M are the lengths of the input linked lists.
//The extra space is used to store the resulting linked list.

//Time Complexity:O(max(N, M)), where N and M are the lengths of the input linked lists.

#include <iostream>
#include <vector>
#include <limits>  // Include the header for numeric_limits

using namespace std;

class Node {
public:
    int data;
    Node* next = NULL;

    Node(int val) {
        data = val;
    }
};

//Function to print the linked list in reverse without arrows
void printReverse(Node* head){
    if (head==NULL){
        return;
    }
    printReverse(head->next);
    cout << head->data << "";
}

/*
// Function to print the linked list
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
    Node* temp = new Node(0);
    Node* head = temp;
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
