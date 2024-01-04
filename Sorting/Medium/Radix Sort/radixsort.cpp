/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to sort a given array in order using radix sort algorithm. */
// Stable : Yes
// Inplace : No
// Adaptive : No

// Space complexity: O(n+k) where
  // n = number of elements in the input array
  // k = range of input values (number of unique digits)

//Time Complexity: O(d*(n+k)) /O(n+k) in simplified version
  // n=no. of elements
  // k= range of input values
  // d= no. of digits in maximum value

#include<iostream>
// This line includes the input/output stream header file
using namespace std;
// This line declares that elements from the C++ Standard Library (std).
// Specifically, it allows the usage of elements, such as cout and cin, without needing to prefix them with std::

//function to get the maximum value in arr[]
int max(int arr[],int n){
	# Initialize maxele to the first element of the array
    int maxele=arr[0];
    for(int i=0;i<n;i++){
    	# Check if the current element is greater than the current maxele
        if (arr[i]>maxele){
        	 # If yes, update maxele to the current element
            maxele=arr[i];
        }
    }
    # Return the maximum element found in the array
    return maxele;
}
//function to do counting sort of arr[] according to the digit represented by exp.
void countingSort(int arr[],int n,int decimalplace){
	// Initialize an array to store the count of each digit (0 to 9)
    int count[10];
    
	// Initialize an array to store the sorted output
    int output[n];
    // Initialize count array with zeros
    for(int i=0;i<10;i++){
        count[i]=0;
    }
    //processing count array 
    for(int i=0;i<n;i++){
        int index=arr[i]/decimalplace;
        count[index%10]+=1;
    }
    //cumulative count array
    for(int i=1;i<10;i++){
        count[i]+=count[i-1];
    }
    //Build the output array
    for(int i=n-1;i>=0;i--){
        int index=arr[i]/decimalplace;
        output[count[index%10]-1]=arr[i];
        count[index%10]-=1;
    }

		//Cope the output array to arr[]
    for(int i=0;i<n;i++){
        arr[i]=output[i];
    }
}
//Radix Sort
void radixSort(int arr[],int n){
	//Find maximum number to know number of digits
    int m=max(arr,n);
    int decimalplace=1;
    //Do counting sort for every digit. Instead of passing digit directly, exp is passed.
    //exp is 10^i where i is current digit number. This helps in sorting in (one's, ten's and hundred's digit place)
    while(m/decimalplace>0){
        countingSort(arr,n,decimalplace);
        decimalplace*=10;
    }

		//Print the sorted array
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

// driver code to test the above two functions: Counting function and radix sort
int main(){

    {
        int n;
        // Prompt the user to enter the number of elements in the array
        cout << "Enter no. of elements in array: ";
        // Check if the input for array size is not an integer or non-positive
        if (!(cin >> n) || n <= 0) {
		// Check if the input for array size is not an integer
        cout << "Error: Please enter a valid integer for the array size." << endl;
        return 1;
        // Return 1 to indicate an error       
		 }
        int arr[n];
        // Prompt the user to enter the elements of the array
        cout << "Enter elements in array: ";
        // Iterate through each element of the array and input values from the user
        for (int i = 0; i < n; i++) {
        	// Check if the input for array elements is not an integer
            if (!(cin >> arr[i])) {
            cout << "Error: Please enter valid integers for array elements." << endl;
            return 1; // Return 1 to indicate an error
            }
        }
        // Call the radixSort function to sort the array
        radixSort(arr, n);
    } 
    return 0;  // Return 0 to indicate successful execution of the program
}
