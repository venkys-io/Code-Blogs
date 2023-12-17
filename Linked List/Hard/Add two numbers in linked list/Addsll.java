/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

Java program to add two numbers in a linked list*/

// Stable : Yes
// Inplace : Yes
// Adaptive :Yes

// Space complexity: (max(N, M)), where N and M are the lengths of the input linked lists.
//The extra space is used to store the resulting linked list.

//Time Complexity:O(max(N, M)), where N and M are the lengths of the input linked lists.

import java.util.Scanner;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
    }
}

public class addSLL{

		// Function to print the linked list in reverse order 
		static void printReverse(Node head) {
        if (head == null) {
            return;
        }
        printReverse(head.next);
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
        Node temp=new Node(0);
        Node head=temp;
        for(int i=0;i<arr.length;i++){
            temp.next=new Node(arr[i]);
            temp=temp.next;
        }
        return head.next;
    }

    // Function to add two numbers represented as linked lists
    static Node addTwoNumbers(Node l1,Node l2){
        Node temp=new Node(0);
        Node head=temp;

        int c=0;
        while(l1!=null || l2!=null || c!=0){
            if(l1!=null){
                c+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                c+=l2.data;
                l2=l2.next;
            }
            temp.next=new Node(c%10);
            c=c/10;
            temp=temp.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
	// Input for the first number
	Scanner scanner = new Scanner(System.in);
       String[] input1 = scanner.nextLine().split(" ");
        int[] a1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            a1[i] = Integer.parseInt(input1[i]);
        }

        // Input for the second number
       
        String[] input2 = scanner.nextLine().split(" ");
        int[] a2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            a2[i] = Integer.parseInt(input2[i]);
        }

        // Build linked lists
        Node l1=buildll(a1);
        Node l2=buildll(a2);

        Node ans=addTwoNumbers(l1, l2);
        printReverse(ans);
        System.out.println();
        // Close the scanner
        scanner.close();
    }
}
