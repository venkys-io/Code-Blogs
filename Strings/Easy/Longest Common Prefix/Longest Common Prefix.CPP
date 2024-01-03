#include <iostream>
#include <vector>
#include <algorithm>

std::string longestCommonPrefix(const std::vector<std::string>& strings) {
    if (strings.empty()) {
        return "";
    }

    // Sort the strings to get the lexicographically smallest and largest strings
    std::vector<std::string> sortedStrings = strings;
    std::sort(sortedStrings.begin(), sortedStrings.end());

    // Compare the first and last strings in the sorted list
    std::string prefix = "";
    const std::string& firstString = sortedStrings.front();
    const std::string& lastString = sortedStrings.back();

    for (size_t i = 0; i < firstString.length(); ++i) {
        if (firstString[i] == lastString[i]) {
            prefix += firstString[i];
        } else {
            break;
        }
    }

    return prefix;
}

int main() {
    int numStrings;
    std::cout << "Enter the number of strings: ";
    std::cin >> numStrings;

    std::vector<std::string> inputStrings;
    inputStrings.reserve(numStrings);

    // Taking user input for a vector of strings
    for (int i = 0; i < numStrings; ++i) {
        std::string inputString;
        std::cout << "Enter string " << i + 1 << ": ";
        std::cin >> inputString;
        inputStrings.push_back(inputString);
    }

    std::string result = longestCommonPrefix(inputStrings);

    if (!result.empty()) {
        std::cout << "Longest common prefix: " << result << std::endl;
    } else {
        std::cout << "No common prefix." << std::endl;
    }

    return 0;
}
