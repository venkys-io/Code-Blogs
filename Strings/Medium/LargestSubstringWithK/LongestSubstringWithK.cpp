#include <iostream>
#include <unordered_map>
using namespace std;

int longestSubstring(string str, int k) {
    // Check if the input string is not empty
    if (str.empty()) {
        return 0;
    }

    // Initialize a counter to track the frequency of characters in the input string
    unordered_map<char, int> freq;
    for (char c : str) {
        freq[c]++;
    }

    // Find the maximum number of distinct characters in the string
    int maxDistinctChars = freq.size();

    // Length of the input string
    int n = str.length();

    // Variable to store the final result
    int longestSubstring = 0;

    // Iterate over all possible number of distinct characters (num)
    for (int num = 1; num <= maxDistinctChars; num++) {
        // Counter for characters within the current window
        unordered_map<char, int> windowFreq;

        // Left pointer for window contraction
        int left = 0;

        // Iterate over the string with the right pointer
        for (int right = 0; right < n; right++) {
            char currentChar = str[right];

            // Update the count of the current character in the window
            windowFreq[currentChar]++;

            // Shrink the window if the number of distinct characters exceeds 'num'
            while (windowFreq.size() > num) {
                char leftChar = str[left];
                windowFreq[leftChar]--;

                // Remove the character if its count becomes 0
                if (windowFreq[leftChar] == 0) {
                    windowFreq.erase(leftChar);
                }

                // Move the left pointer to shrink the window
                left++;
            }

            // Update result if all character counts are at least 'k'
            bool allCountsAtLeastK = true;
            for (auto& charFreq : windowFreq) {
                if (charFreq.second < k) {
                    allCountsAtLeastK = false;
                    break;
                }
            }

            if (allCountsAtLeastK) {
                // Update the length of the longest substring if needed
                longestSubstring = max(longestSubstring, right - left + 1);
            }
        }
    }

    // Return the final result
    return longestSubstring;
}

int main() {
    // Take input string and k from the user
    string str;
    cin >> str;

    int k;
    cin >> k;

    // Print the result of the longestSubstring function
    cout << longestSubstring(str, k) << endl;

    return 0;
}
