/*Copyrights to venkys.io
For more information, visit https://venkys.io"/

Java program to add two numbers in a linked list*/

// Stable : Yes
// Inplace : Yes
// Adaptive :Yes

// Space complexity: (max(N, M)), where N and M are the lengths of the input linked lists.
//The extra space is used to store the resulting linked list.

//Time Complexity:O(max(N, M)), where N and M are the lengths of the input linked lists.

import java.util.Scanner; //Importing scanner class from java.util package for user input

//Node class representing a node in linked list
class Node{
    int data;
    Node next;

    //Constructor to initialize a node with given data
    Node(int data){
        this.data=data;
    }
}

public class Linkedlistsum{
    // Function to print the linked list in reverse order 
	static void printReverse(Node head) {
	// Base case: If the current node is null, return
        if (head == null) {
            return;
        }
        // Recursive call: Move to the next node and print it in reverse order
        printReverse(head.next);
        // Print the data of the current node
        System.out.print(head.data);
    }
    
    /* This function displays the actual data order stored in linked list
		static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println();
    }*/

    // Function to build a linked list from an array
    static Node buildll(int[] arr){
        Node temp=new Node(0); // Create a dummy node to serve as the head of the linked list
        Node head=temp; // Store the reference to the head of the linked list
       
        for(int i=0;i<arr.length;i++){
            temp.next=new Node(arr[i]); //Create a new node with array element and link it
            temp=temp.next; // Move the temporary pointer to newly created node
        }
        return head.next; // Return the actual head of the linked list (skip the dummy node)
    }

    // Function to add two numbers represented as linked lists
    static Node addTwoNumbers(Node l1,Node l2){
        Node temp=new Node(0); //Create a dummy node
        Node head=temp; // Keep a reference to the head of the linked list

        int c=0; // Initialize the carry to 0
        // Continue adding digits until both input linked lists are processed, and there is no carry left
        while(l1!=null || l2!=null || c!=0){
            // Add the current digits of l1, l2, and the carry
            if(l1!=null){
                c+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                c+=l2.data;
                l2=l2.next;
            }
            temp.next=new Node(c%10); //Create a new node with the digit sum and link it
            c=c/10; //Update the carry for the next iteration
            temp=temp.next; //Move the temporary Pointer to the newly created node
        }
        return head.next; //Return the head of the resulting linked list(skipping dummy node)

    }

    public static void main(String[] args) {
	// Input for the first number
	System.out.print("Enter first number:");
	Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        int[] a1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            a1[i] = Integer.parseInt(input1[i]);
        }

        // Input for the second number
        System.out.print("Enter second number:");
        String[] input2 = scanner.nextLine().split(" ");
        int[] a2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            a2[i] = Integer.parseInt(input2[i]);
        }

        // Build linked lists
        Node l1=buildll(a1);
        Node l2=buildll(a2);

        Node ans=addTwoNumbers(l1, l2);
	System.out.print("Sum of two numbers:");
        printReverse(ans);
        System.out.println();
        // Close the scanner
        scanner.close();
    }
}
