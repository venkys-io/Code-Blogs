// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for ThreeNumberSum
#include <iostream>
#include <algorithm>
//creating function 
void findThreeNumberSum(int nums[], int size, int target) {
    // Sort the array for easier triplet identification
    std::sort(nums, nums + size);

    // Loop through the array to find triplets
    for (int i = 0; i < size - 2; i++) {
        int left = i + 1;
        int right = size - 1;

        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];

            if (currentSum == target) {
                std::cout << "Triplet found: " << nums[i] << ", " << nums[left] << ", " << nums[right] << std::endl;
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
//the user is prompted to input the size of the array, followed by the array elements.
int main() {
    int size;
    // std::cout << "Enter the size of the array: ";
    //Need to provide or give the array size
    std::cin >> size;

    int nums[size];
    // std::cout << "Enter the elements of the array:" << std::endl;
    //the elements that are pushed into the array
    for (int i = 0; i < size; i++) {
        std::cin >> nums[i];
    }

    int targetSum;
    // std::cout << "Enter the target sum: ";
    //the value or the sum we need
    std::cin >> targetSum;

    std::cout <<  targetSum <<  std::endl;
    findThreeNumberSum(nums, size, targetSum);

    return 0;
}
