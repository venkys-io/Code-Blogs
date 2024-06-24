#include <iostream>
using namespace std;

/* Node class definition */
class VSDnode {
public:
    int data;
    VSDnode* next;

    VSDnode(int val) {
        data = val;
        next = NULL;
    }
};

/* Function to add a node at the head of the linked list */
void add_head(VSDnode* &head, int val) {
    VSDnode* n = new VSDnode(val);
    n->next = head;
    head = n;
}

/* Function to add a node at the tail of the linked list */
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

/* Function to create a cycle in the linked list at a specified position */
void create_cycle_pos(VSDnode* &head, int pos) {
    VSDnode* temp = head;
    int len = 1;
    VSDnode* ptr;
    while (temp->next != NULL) {
        if (len == pos) {
            ptr = temp;
        }
        temp = temp->next;
        len++;
    }
    temp->next = ptr;
}

/* Function to detect the presence of a cycle in the linked list using Floyd's Tortoise and Hare algorithm */
bool detect_cycle(VSDnode* &head) {
    VSDnode* slow = head;
    VSDnode* fast = head;
    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
        if (fast == slow) {
            return true;  /* Cycle present in the linked list */
        }
    }
    return false;  /* No cycle present in the linked list */
}

/* Function to remove the cycle in the linked list */
void remove_cycle(VSDnode* &head) {
    VSDnode* slow = head;
    VSDnode* fast = head;

    do {
        slow = slow->next;
        fast = fast->next->next;
    } while (slow != fast);

    fast = head;
    while (slow->next != fast->next) {
        slow = slow->next;
        fast = fast->next;
    }
    slow->next = NULL;
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

int main() {
    VSDnode* head = NULL;
    int n;

    cout << "Enter the number of elements in the linked list: ";
    cin >> n;

    cout << "Enter the elements of the linked list:" << endl;
    for (int i = 0; i < n; i++) {
        int element;
        cin >> element;
        add_tail(head, element);
    }

    cout << "Do you want to create a cycle in the linked list? (1 for Yes, 0 for No): ";
    int createCycle;
    cin >> createCycle;

    if (createCycle) {
        cout << "Enter the position to create a cycle: ";
        int pos;
        cin >> pos;
        create_cycle_pos(head, pos);
    }

    cout << "Linked List: ";
    display(head);

    /* Detecting and displaying whether a cycle is present */
    if (detect_cycle(head)) {
        cout << "Cycle present in the linked list" << endl;
        remove_cycle(head);
        cout << "Linked List after removing the cycle: ";
        display(head);
    } else {
        cout << "No cycle present in the linked list" << endl;
    }

    return 0;
}
