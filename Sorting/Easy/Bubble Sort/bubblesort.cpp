/*Copyrights to venkys.io*/
/*For more programs visit venkys.io */
/*C++ program for Bubble sort*/
//Stable: Yes
//Inplace: Yes
//Adaptive: No
//Time Complexity: Best case - O(n), Average and worst case - O(n^2)
//Space Complexity: O(1)

#include <iostream>

using namespace std;

void swap(int array[], int i, int j) //swapping function to swap two elemts when compared adjacently
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

void bubbleSort(int array[], int n) //bubble sort function
{
    for (int i = 0; i < n-1; i++)
    {
        for (int j = 0; j < n - i - 1; j++)
        {
            if (array[j] > array[j + 1])
            {
                swap(array, j, j + 1);
            }
        }
    }
    for (int k = 0; k < n; k++)
    {
        cout << array[k] << " ";
    }
}
int main()
{
    cout << "Enter the size of the array: ";
    int n;
    cin >> n;

    int *array = new int[n];

    cout << "Enter the elements of the array: ";
    for (int i = 0; i < n; i++)
    {
        cin >> array[i];
    }
		bubbleSort(array,n);
		
delete[] array; //freeing allocated memory

    return 0;
}
