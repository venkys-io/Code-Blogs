/*Copyrights to venkys.io*/
/*For more programs visit venkys.io */
/*Java program for Bubble sort*/
//Stable: Yes
//Inplace: Yes
//Adaptive: No
//Time Complexity: Best case - O(n), Average and worst case - O(n^2)
//Space Complexity: O(1)

import java.util.Scanner;
public class bubbleSort 
    {
    //Function to perform Bubble sort
     public static void VSDsort(int n,int[] a) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-i-1;j++) {
				if (a[j]>a[j+1]) 
					VSDswapElementsAt(a,j+1,j);//Swapping to place higher element correctly
			}
		}
    }
    //Function to swap the elements of array
     public static void VSDswapElementsAt(int[] a,int t1,int t2) {
    		   int temp=a[t1];
                 a[t1]=a[t2];
                 a[t2]=temp;
      }
            
    //Function to print output
    public static void VSDprintOutput(int n,int a[]) {
	System.out.println("The sorted order is:");
        	for(int i=0;i<n;i++) {
        		System.out.print(a[i]+" ");
            	}
        	}
		    public static void main(String args[]) {
			Scanner scanner = new Scanner(System.in);
			//Input the size of the array
                        System.out.print("Enter the size of the array: ");
                        int n = scanner.nextInt();

                        int[] a = new int[n];

			//Input the elements of the array
                        System.out.println("Enter the elements of the array:");
                        for (int i = 0; i < n; i++) {
                            a[i] = scanner.nextInt();
                        }
			VSDsort(n,a);//Call to sort the array
			VSDprintOutput(n,a);//Printing output
		}
}
