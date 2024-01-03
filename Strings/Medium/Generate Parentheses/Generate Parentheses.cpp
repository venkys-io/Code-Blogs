#include <iostream>
#include <vector>
#include <string>

void backtrack(std::vector<std::string>& result, std::string& current, int left, int right, int n) {
    if (current.length() == 2 * n) {
        result.push_back(current);
        return;
    }

    if (left < n) {
        current.push_back('(');
        backtrack(result, current, left + 1, right, n);
        current.pop_back();
    }

    if (right < left) {
        current.push_back(')');
        backtrack(result, current, left, right + 1, n);
        current.pop_back();
    }
}

std::vector<std::string> generateParenthesis(int n) {
    std::vector<std::string> result;
    std::string current;
    backtrack(result, current, 0, 0, n);
    return result;
}

int main() {
    int n;
    std::cout << "Enter the number of pairs of parenthese
