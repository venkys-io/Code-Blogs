/*Copyrights to venkys.io
For more information, visite https://venkys.io"/

C++ program to sort a given array in order using Shell sort algorithm. */
// Stable : No
// Inplace : Yes
// Adaptive : Yes

// Space complexity: O(1) - sorts in place

//Time Complexity: O(n^2) in the worst-case scenario, and O(n log n) in the average case scenario.

#include<iostream>  
#include<vector> //container to hold elements
#include<string> //String representation for input
#include<sstream> //To convert string input into integer
using namespace std; // Namespace identifies the code is part of the standard library

void shellSort(int arr[],int n){
    int shellsize=8;
    // Iterate through decreasing gap sizes until gap is 1
    while(shellsize>=1){
        for(int i=shellsize,k=0;i<n&&k<shellsize;){
            int key=arr[i];
            int j=i-shellsize;
            // Compare and shift elements to make room for the key
            for(;j>=0;j-=shellsize){
                if(arr[j]>key){
                    arr[j+shellsize]=arr[j];
                }
                else{
                    break;
                }
            }
            // Insert the key at the correct position in the sorted sequence
            arr[j+shellsize]=key;

            // Update indices for the next iteration
            if(i+shellsize>=n){
                k+=1;
                i=k+shellsize;
            }
            else{
                i+=shellsize;
            }
        }
       // Reduce the gap size for the next iteration
        shellsize=shellsize/2;
    }
    // Print the sorted array
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;

}

int main(){
		string input;
    cout << "Enter the elements separated by space: ";
    getline(cin, input);
    
    stringstream ss(input);
    vector<int> elements;
    int num;
    while (ss >> num) {
        elements.push_back(num);
    }
    
    int n = elements.size();
    int arr[n];
    for (int i = 0; i < n; i++) {
        arr[i] = elements[i];
    }
    shellSort(arr,n);

    return 0;
}
