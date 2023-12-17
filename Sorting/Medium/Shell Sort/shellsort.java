/*Copyrights to venkys.io*/
/*For more programs visit venkys.io */
/*Java program for Shell sort*/
// Stable : No
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1) 

//Time Complexity:  O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

import java.util.Scanner;
import java.util.ArrayList;

public class Shellsort 
    {
        static int n;//size of array
        static int arr[];//array of numbers to be sorted
            
        //Function to perform shell sort
        public static void VSDSort() 
            {
                int shellsize=8;
		            while(shellsize>=1)
                	{
        			for(int i=shellsize,k=0;i<n&&k<shellsize;){
        				int key=arr[i];
					  int j=i-shellsize;
					for(;j>=0;j-=shellsize){
						if(arr[j]>key){
							arr[j+shellsize]=arr[j];
						}
						else{
							break;
						}
					}
					arr[j+shellsize]=key;
					if(i+shellsize>=n){
						k+=1;
						i=k+shellsize;
					}
					else{
						i+=shellsize;
					}
				}
				shellsize=shellsize/2;
			}
	    }

	
	//Function to print output
	public static void VSDprintOutput() {
		System.out.println("The sorted order is:");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i] +" ");
				
			}
			System.out.println();
		}

	public static void main(String args[])
        	{
        	    Scanner scanner = new Scanner(System.in);
                    System.out.print("Enter the elements separated by space: ");
                    String input = scanner.nextLine();
                    String[] elements = input.split(" ");
                    n = elements.length;
                    arr = new int[n];
                    for (int i = 0; i < n; i++) {
                          arr[i] = Integer.parseInt(elements[i]);
                     }
                   scanner.close();
        	VSDSort();
        	VSDprintOutput();
	}
}
