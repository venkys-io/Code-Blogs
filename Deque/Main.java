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
        try (Scanner scanner = new Scanner(System.in)) {
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
}