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