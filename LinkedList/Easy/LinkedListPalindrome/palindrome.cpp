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
