#include <iostream>
#include <vector>
using namespace std;

void generate(string s, int left, int right, vector<string>& result) {
if (left == 0 && right == 0) {
result.push_back(s);
return;
}
if (left > 0) {
generate(s + '(', left - 1, right, result);
}
if (right > left) {
generate(s + ')', left, right - 1, result);
}
}

vector<string> generateParenthesis(int n) {
vector<string> result;
generate("", n, n, result);
return result;
}

int main() {
int n = 3; // Number of pairs of parentheses
vector<string> parentheses = generateParenthesis(n);
for (const auto& p : parentheses) {
cout << p << endl;
}
return 0;
}
