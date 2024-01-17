#include <iostream>
#include <sstream>
#include <vector>

// Function to shuffle the characters of a string based on provided indices
std::string shuffleString(const std::string &str, const std::vector<int> &indices)
{
    int n = str.length();
    std::string result(n, ' '); // Initialize the result string with spaces

    // Iterate through the indices and assign characters from the input string to
    // the corresponding positions
    for (int index = 0; index < n; ++index)
    {
        result[indices[index]] = str[index];
    }

    return result;
}

int main()
{
    // Custom Example
    std::cout << "Enter the string: ";
    std::string customString;
    std::getline(std::cin, customString);

    std::cout << "Enter the indices separated by space: ";
    std::string indicesInput;
    std::getline(std::cin, indicesInput);

    std::istringstream iss(indicesInput);
    std::vector<int> customIndices;

    // Convert the space-separated string of indices to a vector of integers
    int index;
    while (iss >> index)
    {
        customIndices.push_back(index);
    }

    std::cout << "Enter the expected output: ";
    std::string expectedOutput;
    std::getline(std::cin, expectedOutput);

    // Call the shuffleString function with the custom string and indices
    std::string customOutput = shuffleString(customString, customIndices);
    std::cout << "Custom Example Result: " << customOutput << std::endl;

    // Check if the custom output matches the expected output and provide feedback
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

// Enter the string: hello
// Enter the indices separated by space: 4 1 3 2 0
// Enter the expected output: oellh
// Custom Example Result: oellh
// Test case passed.