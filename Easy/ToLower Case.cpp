#include <iostream>

// Function to convert a string to lowercase
// Returns the lowercase version of the input string

std::string toLowerCase(const std::string& s) {
    // Initialize an empty string to store the lowercase result
    std::string result = "";

    // Iterate through each character in the input string
    for (char i : s) {
        // Check if the character is an uppercase letter
        if (i >= 'A' && i <= 'Z') {
            // Convert uppercase to lowercase using ASCII values and append to the result
            result += static_cast<char>(i + 32);
        } else {
            // Keep non-uppercase characters unchanged and append to the result
            result += i;
        }
    }

    // Return the final lowercase result
    return result;
}

int main() {
    // Read the string input from the user
    std::string inputString;
    std::getline(std::cin, inputString);

    // Convert the input string to lowercase by calling the toLowerCase function
    std::string lowercaseString = toLowerCase(inputString);

    // Display the lowercase string
    std::cout << lowercaseString << std::endl;

    return 0;
}
