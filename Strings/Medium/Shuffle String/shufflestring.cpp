#include <iostream>
#include <vector>

std::string shuffleString(const std::string &str, const std::vector<int> &indices)
{
    int n = str.length();
    std::vector<char> result(n, ' ');

    for (int index = 0; index < n; ++index)
    {
        result[indices[index]] = str[index];
    }

    return std::string(result.begin(), result.end());
}

int main()
{
    std::string customString, expectedOutput;
    std::cout << "Enter the string: ";
    std::cin >> customString;

    std::cout << "Enter the indices separated by space: ";
    std::vector<int> customIndices;
    int index;
    while (std::cin >> index)
    {
        customIndices.push_back(index);
    }

    std::cin.clear(); // Clear the error state from cin

    std::cout << "Enter the expected output: ";
    std::cin >> expectedOutput;

    std::string customOutput = shuffleString(customString, customIndices);
    std::cout << "Custom Example Result: " << customOutput << std::endl;

    if (customOutput == expectedOutput)
    {
        std::cout << "Test case passed." << std::endl;
    }
    else
    {
        std::cout << "Test case failed." << std::endl;
    }

    return 0;
}
