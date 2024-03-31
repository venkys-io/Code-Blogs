and the previous element
        arr[i] += arr[i - 1];
    }

    // Print the resulting vector after prefix sum calculation
    for (int num : arr) {
        std::cout << num << " ";
    }

    // Print a new line to separate the output
    std::cout << std::endl;
}

// Main function
int main() {
    // Read the number of elements from the user
    // std::cout << "Enter the number of elements for the array: ";
    int num_elements;
    std::cin >> num_elements;

    // Create a vector named arr with user-input values
    std::vector<int> arr(num_elements);
    // std::cout << "Enter the elements of the array separated by space: ";
    for (int i = 0; i < num_elements; ++i) {
        std::cin >> arr[i];
    }

    // Call the prefixSum function to calculate and print the prefix sum
    prefixSum(arr);

    // Return 0 to indicate successful execution
    return 0;
}
