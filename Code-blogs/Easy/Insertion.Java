/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using Insertion sort algorithm.*/

// Stable : Yes
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1)

//Time Complexity:O(n^2) in the worst-case scenario, and O(n) in the best-case scenario.

#include<iostream>
// Include the input/output stream header file


using namespace std;
// Define the standard namespace for input/output operations
void VSDInsertionSort(int arr[],int n)
{
    for(int i=1;i<n;i++)
		{
        int temp=arr[i];
        int j=i;
        while(j>0 && arr[j-1]>temp){
            arr[j]=arr[j-1];
            j--;
        }
        arr[j]=temp;
// Place the value stored in temp at the position j, effectively inserting the value in its correct place
    }
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
// Move to the next line after printing all elements
}

int main(){
    int n=7;
    int arr[]={2,24,12,96, 456, 899,34};
    VSDInsertionSort(arr,n);
// Call the VSDInsertionSort function to sort the array
    return 0;
// Return 0 to indicate successful execution of the program
}
