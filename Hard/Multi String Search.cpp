#include <iostream>
#include <vector>
#include <algorithm>

/**
 * Performs multi-string search.
 *
 * @param text The input text to search within.
 * @param patterns List of patterns to search for in the text.
 * @return List of patterns found in the text.
 */
std::vector<std::string> multiStringSearch(const std::string& text, const std::vector<std::string>& patterns) {
    std::vector<std::string> result;

    for (const auto& pattern : patterns) {
        // Use std::search to find the pattern in the text
        if (std::search(text.begin(), text.end(), pattern.begin(), pattern.end()) != text.end()) {
            result.push_back(pattern);
        }
    }

    return result;
}

int main() {
    // Sample text and patterns
    std::string text = "This is a sample text for multi-string search.";
    std::vector<std::string> patterns = {"sample", "search", "notfound"};

    // Perform multi-string search
    std::vector<std::string> result = multiStringSearch(text, patterns);

    // Print the found patterns
    std::cout << "Found patterns:";
    for (const auto& pattern : result) {
        std::cout << " " << pattern;
    }
    std::cout << std::endl;

    return 0;
}
