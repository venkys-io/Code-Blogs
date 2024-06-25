#include <iostream>
#include <vector>
#include <string>

// Function to compute the prefix function (π) for the pattern 'p'
std::vector<int> compute_prefix_function(const std::string& p) {
    int m = p.length();                    // Length of the pattern
    std::vector<int> π(m, 0);              // Initialize an array to store the prefix function values
    int k = 0;                             // Initialize a variable for matching characters

    // Iterate through the pattern to compute the prefix function
    for (int q = 1; q < m; ++q) {
        // Update the matching character index while it's not zero and characters mismatch
        while (k > 0 && p[k] != p[q]) {
            k = π[k - 1];
        }
        // If characters match, increment the matching character index
        if (p[k] == p[q]) {
            k += 1;
        }
        // Store the current matching character index in the prefix function array
        π[q] = k;
    }

    return π;
}

// Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
void kmp_matcher(const std::string& t, const std::string& p) {
    int n = t.length();                    // Length of the text
    int m = p.length();                    // Length of the pattern
    std::vector<int> π = compute_prefix_function(p);  // Compute the prefix function for the pattern
    int q = 0;                             // Initialize a variable for matching characters

    // Iterate through the text to find occurrences of the pattern
    for (int i = 0; i < n; ++i) {
        // Update the matching character index while it's not zero and characters mismatch
        while (q > 0 && p[q] != t[i]) {
            q = π[q - 1];
        }
        // If characters match, increment the matching character index
        if (p[q] == t[i]) {
            q += 1;
        }
        // If the entire pattern is matched, print the occurrence
        if (q == m) {
            std::cout << "Pattern occurs with shift " << i - m + 1 << std::endl;
            q = π[q - 1];  // Look for the next match
        }
    }
}

int main() {
    // Get user input with null safety
    std::string text, pattern;
    std::cout << "Enter the text: ";
    std::cin >> text;
    std::cout << "Enter the pattern: ";
    std::cin >> pattern;

    // Check if input is not empty and contains only alphabetical characters
    if (!text.empty() && !pattern.empty() && std::isalpha(text[0]) && std::isalpha(pattern[0])) {
        kmp_matcher(text, pattern);
    }
    else {
        std::cout << "Please enter valid alphabetic text and pattern." << std::endl;
    }

    return 0;
}