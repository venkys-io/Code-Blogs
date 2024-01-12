#include<bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

    Node() {
        data = 0;
        next = NULL;
        prev = NULL;
    }

    Node(int val) {
        data = val;
        next = NULL;
        prev = NULL;
    }
};

class DoubleLinkedList {
private:
    Node* head = NULL;
    int length = 0;

public:

    /* Insertion operation (Create) */
    void insert(int data) {
        if (head == NULL) {
            /* If the list is empty, create a new node and set it as the head*/
            head = new Node(data);
        }
        else {
            /* Otherwise, create a new node, update links, and set it as the new head */
            Node* temp = new Node(data);
            length++;
            temp->next = head;
            head->prev = temp;
            head = temp;
        }
        length++;
    }

    /* Deletion operation (Delete) */
    void del() {
        if (head == NULL) {
            cout << "List is empty. Cannot delete.\n";
            return;
        }
        head = head->next;
        if (head != NULL) {
            head->prev = NULL;
        }
        length--;
        cout << "Node deleted successfully.\n";
    }

    /* Display operation (Read) */
    void print() {
        Node* temp = head;
        while (temp != NULL) {
            cout << temp->data << " ";
            temp = temp->next;
        }
        cout << endl;
    }

    /* Size operation (Read)*/
    void displaySize() {
        cout << "Size of the list: " << length << endl;
    }

    /* Main menu for user interaction */
    void menu() {
        int choice, data;

        while (true) {
            cout << "\nChoose operation:\n";
            cout << "1. Insert\n";
            cout << "2. Delete\n";
            cout << "3. Display\n";
            cout << "4. Display Size\n";
            cout << "5. Exit\n";

            cin >> choice;

            switch (choice) {
            case 1:
                cout << "Enter data to insert: ";
                cin >> data;
                insert(data);
                cout << "Node inserted successfully.\n";
                break;

            case 2:
                del();
                break;

            case 3:
                cout << "Elements in the list: ";
                print();
                break;

            case 4:
                displaySize();
                break;

            case 5:
                cout << "Exiting the program.\n";
                exit(0);

            default:
                cout << "Invalid choice. Please try again.\n";
            }
        }
    }
};

int main() {
    DoubleLinkedList doublyLinkedList;
    doublyLinkedList.menu();

    return 0;
}