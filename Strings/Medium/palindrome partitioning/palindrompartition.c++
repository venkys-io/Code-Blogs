/* Copyrights to venkys.io
For more information, visit https://venkys.io */

#include <iostream>
#include <vector>
#include <string>

// Function to find all palindrome partitions of a given string
std::vector<std::vector<std::string>> partition(const std::string& str) {
    // Check if the input string is empty
    if (str.empty()) {
        return {{}};
    }

    // Initialize dynamic programming array
    std::vector<std::vector<std::vector<std::string>>> dp(str.size() + 1);

    // Initialize the first state with an empty partition
    dp[0] = {{}};

    // Iterate over each character of the string
    for (size_t j = 1; j <= str.size(); ++j) {
        // Iterate through each previous character
        for (size_t i = 0; i < j; ++i) {
            // Check if the substring is a palindrome
            if (str.substr(i, j - i) == std::string(str.rbegin() + (str.size() - j), str.rend())) {
                // If so, extend the partitions ending at i with the palindrome substring
                for (const auto& each : dp[i]) {
                    dp[j].push_back(each);
                    dp[j].back().push_back(str.substr(i, j - i));
                }
            }
        }
    }

    // Return the final state, which contains all valid partitions
    return dp.back();
}

int main() {
    // Read input from standard input
    std::cout << "Enter a string: ";
    std::string inputString;
    std::getline(std::cin, inputString);

    // Check for empty string
    if (inputString.empty()) {
        std::cout << "Empty input. Exiting." << std::endl;
        return 0;
    }

    // Call the partition function and get the result
    auto result = partition(inputString);

    // Print the result
    std::cout << "Partitions:" << std::endl;
    for (const auto& partitionSet : result) {
        for (const auto& substring : partitionSet) {
            std::cout << substring << " ";
        }
        std::cout << std::endl;
    }

    // Print the count of partitions
    std::cout << "\nNumber of Partitions: " << result.size() << std::endl;

    return 0;
}
