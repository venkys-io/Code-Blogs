/*Copyrights to venkys.io*/
/*For more programs visit venkys.io */
/*Java program for Bubble sort*/

//Stable: Yes
//Inplace: Yes
//Adaptive: No
//Time Complexity: Best case - O(n), Average and worst case - O(n^2)
//Space Complexity: O(1)

import java.util.InputMismatchException;  // Import the InputMismatchException class for handling input errors
import java.util.Scanner; // Importing the Scanner class from java.util package for user input
public class bubbleSort{// Declaration of the bubbleSort class
    public static void VSDsort(int n,int[] a)
    {
        // Declaration of a static method named VSDsort that takes an integer n and an integer array a as parameters
        // Null check for the array
        if (a == null) {
            System.out.println("Error: Input array is null.");
            return;
        }
        for(int i=0;i<n;i++) {
            // Outer loop: iterating through each element of the array
        	for(int j=0;j<n-i-1;j++) {
		// Inner loop: iterating through the unsorted part of the array
		if (a[j]>a[j+1]) {
		// Checking if the current element is greater than the next element
		VSDswapElementsAt(a,j+1,j);}  // Calling a method to swap elements if necessary 
            }
	}
      }

    // Method to swap elements at two specified positions in the array
     public static void VSDswapElementsAt(int[] a,int t1,int t2)
     {
       {
            int temp = a[t1];
            a[t1] = a[t2];
            a[t2] = temp;
        
      }
    }      
    //Function to print output
    public static void VSDprintOutput(int n,int a[]) {
        // Null check for the array
        if (a == null) {
            System.out.println("Error: Input array is null.");
            return;
        }
	System.out.println("The sorted order is:");
        for(int i=0;i<n;i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);// Create a Scanner object for user input
    	//Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n;
        try {
            n= scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integer for array size.");
            return;
        }
            
        // Edge case: Non-positive array size
        if (n <= 0) {
            System.out.println("Error: Array size must be a positive integer.");
            return;
        }

        int[] a = new int[n];
        //Input the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
                    try {
                        a[i] = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Please enter valid integers for array elements.");
                        return;
        	
            }
        }
        VSDsort(n,a);//Call to sort the array
        VSDprintOutput(n,a);//Printing output
    }
}
