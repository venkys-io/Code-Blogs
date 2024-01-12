import java.util.Scanner;

public class Main {

    // Function to swap elements at indices i and j in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to maintain max heap properties
    static void VSDmaxheapify(int[] arr, int n, int i) {
        int large = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[i] < arr[leftChild]) {
            large = leftChild;
        }

        if (rightChild < n && arr[large] < arr[rightChild]) {
            large = rightChild;
        }

        if (large != i) {
            swap(arr, i, large);
            VSDmaxheapify(arr, n, large);
        }
    }

    // Function to maintain min heap properties
    static void VSDminheapify(int[] arr, int n, int i) {
        int small = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && arr[i] > arr[leftChild]) {
            small = leftChild;
        }

        if (rightChild < n && arr[small] > arr[rightChild]) {
            small = rightChild;
        }

        if (small != i) {
            swap(arr, i, small);
            VSDminheapify(arr, n, small);
        }
    }

    // Function to perform max heap sort
    static void VSDMaxheapsort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            VSDmaxheapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            VSDmaxheapify(arr, i, 0);
        }
    }

    // Function to perform min heap sort
    static void VSDMinheapsort(int[] arr) {
        int n = arr.length;

        // Build min heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            VSDminheapify(arr, n, i);
        }

        // Extract elements one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, i, 0);
            VSDminheapify(arr, i, 0);
        }
    }

    // Function to print array
    static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        printArray(arr);

        // Sorting in ascending order using max heap sort
        VSDMaxheapsort(arr);
        System.out.println("Sorted array in ascending order:");
        printArray(arr);

        // Sorting in descending order using min heap sort
        VSDMinheapsort(arr);
        System.out.println("Sorted array in descending order:");
        printArray(arr);
    }
}