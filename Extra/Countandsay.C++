#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    // Function to generate the Count and Say sequence for a given n
    string countAndSay(int n) {
        // Base case: if n is 1, return the base sequence "1"
        if (n == 1) {
            return "1";
        }

        // Recursively call countAndSay for (n - 1)
        string prev = countAndSay(n - 1);
        string result = ""; // Initialize the result string
        int count = 1;      // Initialize count of consecutive digits

        // Loop through the previous sequence to generate the current sequence
        for (int i = 1; i < prev.size(); ++i) {
            // Compare current digit with the previous one
            if (prev[i] == prev[i - 1]) {
                // If the current digit is the same as the previous one, increase the count
                count++;
            } else {
                // If it's different, append the count and the digit to the result, then reset the count
                result += to_string(count) + prev[i - 1];
                count = 1; // Reset count for the new digit
            }
        }

        // Add the count and the last digit after the loop ends
        result += to_string(count) + prev[prev.size() - 1];
        return result;
    }
};

int main() {
    Solution solution;
    int n;

    cout << "Enter a value for n: ";
    cin >> n;

    // Generate the Count and Say sequence for input n and print the result
    string output = solution.countAndSay(n);
    cout << "Result: " << output << endl;

    return 0;
}
