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
