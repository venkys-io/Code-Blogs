/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to sort a given array in order using radix sort algorithm. */
// Stable : No
// Inplace : Yes
// Adaptive : No

// Space complexity: O(n+k) where
  // n = number of elements in the input array
  // k = range of input values (number of unique digits)

//Time Complexity: O(d*(n+k)) /O(n+k) in simplified version
  // n=no. of elements 
  // k= range of input values
  // d= no. of digits in maximum value

#include<iostream>
#include<bits/stdc++.h>
using namespace std;

//function to get the maximum value in arr[]
int max(int arr[],int n){
    int maxele=arr[0];
    for(int i=0;i<n;i++){
        if (arr[i]>maxele){
            maxele=arr[i];
        }
    }
    return maxele;
}
//function to do counting sort of arr[] according to the digit represented by exp.
void countingSort(int arr[],int n,int decimalplace){
    int count[10];
    int output[n];
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
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

// driver code to test the above two functions: Counting function and radix sort
int main(){

    int n=7;
    int arr[]={170,45,90,802,24,2,66};
    radixSort(arr,n);
    return 0;
}
