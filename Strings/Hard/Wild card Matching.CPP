#include <iostream>
#include <vector>

using namespace std;

bool isMatch(const string& input, const string& pattern, int i, int j, vector<vector<int>>& memo) {
    if (i == input.length() && j == pattern.length()) {
        return true;
    }

    if (memo[i][j] != -1) {
        return memo[i][j] == 1;
    }

    if (j < pattern.length() && pattern[j] == '*') {
        int rememberWildcardPosition = j;
        int rememberInputPosition = i;

        while (i < input.length()) {
            if (isMatch(input, pattern, i, j + 1, memo)) {
                memo[rememberInputPosition][rememberWildcardPosition] = 1;
                return true;
            }
            i++;
        }

        j = rememberWildcardPosition;
        i = rememberInputPosition;
    }

    if (i < input.length() && j < pattern.length() && (input[i] == pattern[j] || pattern[j] == '*')) {
        bool result = isMatch(input, pattern, i + 1, j + 1, memo);
        memo[i][j] = result ? 1 : 0;
        return result;
    }

    memo[i][j] = 0;
    return false;
}

bool wildcardMatch(const string& input, const string& pattern) {
    vector<vector<int>> memo(input.length() + 1, vector<int>(pattern.length() + 1, -1));
    return isMatch(input, pattern, 0, 0, memo);
}

int main() {
    string input, pattern;

    cout << "Enter the input string: ";
    cin >> input;

    cout << "Enter the pattern: ";
    cin >> pattern;

    if (wildcardMatch(input, pattern)) {
        cout << "The string \"" << input << "\" matches the pattern \"" << pattern << "\"." << endl;
    } else {
        cout << "No match found for the string \"" << input << "\" and pattern \"" << pattern << "\"." << endl;
    }

    return 0;
}
