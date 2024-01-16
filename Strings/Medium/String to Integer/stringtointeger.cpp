#include <iostream>
#include <string>
#include <limits>
#include <optional>

// Function to convert a string to an integer
std::optional<int> atoi(const std::string& s) {
    // Check if the input string is empty
    if (s.empty()) {
        std::cerr << "Error: Input string is empty." << std::endl;
        return std::nullopt;  // Using std::optional to represent the absence of a value
    }

    int num = 0, i = 0, sign = 1;

    // Skip leading whitespaces
    while (i < s.length() && s[i] == ' ') {
        i++;
    }

    // Check for sign
    if (i < s.length() && (s[i] == '-' || s[i] == '+')) {
        // Determine the sign of the number
        sign = (s[i] == '+') ? 1 : -1;
        i++;
    }

    // Process digits
    while (i < s.length() && std::isdigit(s[i])) {
        // Check for overflow
        if ((num > std::numeric_limits<int>::max() / 10) ||
            ((num == std::numeric_limits<int>::max() / 10) && (s[i] - '0' > 7))) {
            std::cerr << "Error: Integer overflow." << std::endl;
            return std::nullopt;
        }

        // Update the result by multiplying by 10 and adding the current digit
        num = ((num * 10) + (s[i] - '0'));
        i++;
    }

    // Return the final result multiplied by the sign
    return num * sign;
}

int main() {
    // Prompt the user for input
    std::string input;
    std::cout << "Enter a string: ";
    std::getline(std::cin, input);

    // Call the atoi function and print the result
    auto result = atoi(input);
    if (result.has_value()) {
        std::cout << "Converted integer: " << result.value() << std::endl;
    }

    return 0;
}
