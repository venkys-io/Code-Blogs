import java.util.Scanner;

public class Main {

    public static void VSDquicksort(int a[], int l, int r) {
        if (l < r) {
            int p = l + (r - l) / 2; // Taking index of pivot as the mid element of array
            int pivot = a[p]; // Taking pivot element
            int i = l, j = r; // Remembering initial array indices

            // Placing pivot at the right place
            while (l < r) {
                if (a[l] >= pivot && a[r] <= pivot) {
                    if (a[l] == pivot)
                        p = r; // When the place of pivot is changed, noting its index
                    if (a[r] == pivot)
                        p = l;
                    VSDswapElementsAt(a, l, r);
                    r--;
                } else if (a[l] > pivot && a[r] > pivot)
                    r--;
                else
                    l++;
            }

            // Recursively sorting remaining elements in the array
            VSDquicksort(a, i, p);
            VSDquicksort(a, p + 1, j);
        }
    }

    // Function to swap the elements of the array
    public static void VSDswapElementsAt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Function to print output
    public static void VSDprintOutput(int[] a) {
        System.out.println("The sorted order is:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.print("Enter the elements separated by space: ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        VSDquicksort(a, 0, n - 1);
        VSDprintOutput(a);
    }
}
