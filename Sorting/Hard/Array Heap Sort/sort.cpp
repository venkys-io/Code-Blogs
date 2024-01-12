#include<iostream>
using namespace std;

/* Function to swap elements at indices i and j in the array */
void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

/* Function to print the elements of an array */
void printarray(int arr[], int n) {
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

/* Function to maintain max heap properties*/
void VSDmaxheapify(int arr[], int n, int i) {
    int large = i;
    int leftchild = (2 * i) + 1;
    int rightchild = (2 * i) + 2;

    if (leftchild < n && arr[i] < arr[leftchild])
        large = leftchild;
    if (rightchild < n && arr[large] < arr[rightchild])
        large = rightchild;
    if (large != i) {
        swap(arr, i, large);
        VSDmaxheapify(arr, n, large);
    }
}

/* Function to maintain min heap properties */
void VSDminheapify(int arr[], int n, int i) {
    int small = i;
    int leftchild = (2 * i) + 1;
    int rightchild = (2 * i) + 2;

    if (leftchild < n && arr[i] > arr[leftchild]) {
        small = leftchild;
    }
    if (rightchild < n && arr[small] > arr[rightchild]) {
        small = rightchild;
    }
    if (small != i) {
        swap(arr, small, i);
        VSDminheapify(arr, n, small);
    }
}

/* Function to perform max heap sort */
void VSDMaxheapsort(int arr[], int n) {
    /* Build max heap */
    for (int i = (n / 2) - 1; i >= 0; i--) {
        VSDmaxheapify(arr, n, i);
    }

    /* Extract elements one by one */
    for (int i = n - 1; i > 0; i--) {
        swap(arr, i, 0);
        VSDmaxheapify(arr, i, 0);
    }
}

/* Function to perform min heap sort */
void VSDMinheapsort(int arr[], int n) {
    /* Build min heap */
    for (int i = (n / 2) - 1; i >= 0; i--) {
        VSDminheapify(arr, n, i);
    }

    /* Extract elements one by one */
    for (int i = n - 1; i > 0; i--) {
        swap(arr, i, 0);
        VSDminheapify(arr, i, 0);
    }
}

int main() {
    /* Taking user input for the number of elements */
    cout << "Enter the number of elements: ";
    int n;
    cin >> n;

    /* Taking user input for the array */
    int arr[n];
    cout << "Enter the elements: ";
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    /* Sorting in ascending order using max heap sort */
    VSDMaxheapsort(arr, n);
    cout << "Sorted array in ascending order: ";
    printarray(arr, n);

    /* Sorting in descending order using min heap sort */
    VSDMinheapsort(arr, n);
    cout << "Sorted array in descending order: ";
    printarray(arr, n);

    return 0;
}
