#include <iostream>
#include <vector>
#include <algorithm>

std::vector<std::vector<int>> fourSum(std::vector<int>& num, int target) {
    std::vector<std::vector<int>> res;

    if (num.empty()) {
        std::cout << "Input vector is empty. Returning empty result." << std::endl;
        return res;
    }

    int n = num.size();
    std::sort(num.begin(), num.end());

    for (int i = 0; i < n; i++) {
        // Reduce the problem to finding a 3-sum
        int target_3 = target - num[i];

        for (int j = i + 1; j < n; j++) {
            // Reduce the problem to finding a 2-sum
            int target_2 = target_3 - num[j];

            int front = j + 1;
            int back = n - 1;

            while (front < back) {
                int two_sum = num[front] + num[back];

                if (two_sum < target_2) front++;
                else if (two_sum > target_2) back--;
                else {
                    // Found a valid quadruplet, add to the result
                    std::vector<int> quadruplet(4, 0);
                    quadruplet[0] = num[i];
                    quadruplet[1] = num[j];
                    quadruplet[2] = num[front];
                    quadruplet[3] = num[back];
                    res.push_back(quadruplet);

                    // Processing the duplicates of number 3
                    while (front < back && num[front] == quadruplet[2]) ++front;

                    // Processing the duplicates of number 4
                    while (front < back && num[back] == quadruplet[3]) --back;
                }
            }

            // Processing the duplicates of number 2
            while (j + 1 < n && num[j + 1] == num[j]) ++j;
        }

        // Processing the duplicates of number 1
        while (i + 1 < n && num[i + 1] == num[i]) ++i;
    }

    return res;
}

int main() {
    // Read the array elements from STDIN
    std::vector<int> v;
    int num;
    while (std::cin >> num) {
        v.push_back(num);
    }

    // Check if the input vector is empty
    if (v.empty()) {
        std::cout << "Input vector is empty. Exiting program." << std::endl;
        return 0;
    }

    // Read the target sum from STDIN
    int target;
    std::cin >> target;

    // Find and print the unique quadruplets
    std::vector<std::vector<int>> sum = fourSum(v, target);
    std::cout << "Result:" << std::endl;
    for (int i = 0; i < sum.size(); i++) {
        for (int j = 0; j < sum[i].size(); j++)
            std::cout << sum[i][j] << " ";
        std::cout << std::endl;
    }

    return 0;
}
