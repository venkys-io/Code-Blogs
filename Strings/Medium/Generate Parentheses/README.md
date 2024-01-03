Generate Parentheses :
Exploring String Algorithms :
Today, we dive into the fascinating world of String algorithms and uncover their most captivating mysteries — Generate Parentheses . Get ready to embark that will challenge your minds and you will come to know about the power of string Algorithms .

Advantages and Disadvantages :
Advantages :
Parentheses are used to enclose incidental or supplemental information or comments.
The parenthetical information or comment may serve to clarify or illustrate, or it may just offer a digression or afterthought.
Parentheses are also used to enclose certain numbers or letters in an outline or list.
Disadvantages :
They can lead to excessive document size and become difficult to read.
Proper placement of parentheses can be challenging, and improper placement can lead to confusion.
Using too many parentheses can be unprofessional and detract from the clarity of the text.
Parentheses can also be seen as unnecessary and distracting, causing some readers to skim over the content.
Overview of Generating Parentheses :
The Generate Parenthesis problem involves generating all valid combinations of parentheses for a given number of pairs of parenthesis.
This problem can be solved using both recursive and iterative approaches, and is a great introduction to backtracking style recursion.
Coding :
Python code :
def generate_parentheses(n): def generate(p, left, right, parens=[]): if left: generate(p + '(', left-1, right) if right > left: generate(p + ')', left, right-1) if not right: parens += p, return parens return generate('', n, n)

print(generate_parentheses(3))

Explanation :
This Python code defines a function called "generate_parentheses" that takes an integer "n" as input. The function uses a helper function called "generate" to recursively create all valid combinations of balanced parentheses pairs.

Within the "generate" function, there are three main conditions being checked:

If there are still "left" parentheses remaining, a "(" is added to the current string, and the "left" count is decremented. The function is then called recursively with the updated string and count.
If there are more remaining "right" parentheses than "left" parentheses, a ")" is added to the current string, and the "right" count is decremented. The function is then called recursively with the updated string and counts.
If there are no remaining "right" parentheses, it means a complete valid combination of parentheses has been formed, and it is added to the list "parens".
The "generate" function continues to call itself recursively until all valid combinations have been identified. The output of the "generate_parentheses" function is a list containing all the valid combinations of balanced parentheses for the given input "n".

Code in C++ :
#include #include using namespace std;

void generate(string s, int left, int right, vector& result) { if (left == 0 && right == 0) { result.push_back(s); return; } if (left > 0) { generate(s + '(', left - 1, right, result); } if (right > left) { generate(s + ')', left, right - 1, result); } }

vector generateParenthesis(int n) { vector result; generate("", n, n, result); return result; }

int main() { int n = 3; // Number of pairs of parentheses vector parentheses = generateParenthesis(n); for (const auto& p : parentheses) { cout << p << endl; } return 0; }

Code in Java :
import java.util.ArrayList; import java.util.List;

public class GenerateParentheses {


Explain
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generate("", n, n, result);
    return result;
}

private void generate(String s, int left, int right, List<String> result) {
    if (left == 0 && right == 0) {
        result.add(s);
        return;
    }
    if (left > 0) {
        generate(s + "(", left - 1, right, result);
    }
    if (right > left) {
        generate(s + ")", left, right - 1, result);
    }
}

public static void main(String[] args) {
    GenerateParentheses generator = new GenerateParentheses();
    int n = 3; // Number of pairs of parentheses
    List<String> parentheses = generator.generateParenthesis(n);
    for (String p : parentheses) {
        System.out.println(p);
    }
}

}

Time Complexity :
The time complexity of the recursive algorithm for generating parentheses is O(4^n / sqrt(n)), where "n" is the number of pairs of parentheses.

The presence of 4^n in the time complexity arises from the fact that at each step, we have 4 choices to make: adding an opening parenthesis if there are still remaining ones to add, or adding a closing parenthesis if the number of closing parentheses added so far is less than the number of opening parentheses. This process is repeated recursively for each subproblem, resulting in a complexity of O(4^n).
The sqrt(n) factor in the time complexity comes from the Catalan number, which bounds the number of recursive calls and is approximately (2n)! / ((n+1)! * n!). This is often simplified to O(4^n / (n^(3/2))).
Space Complexity :
The space complexity of the recursive algorithm is O(4^n / sqrt(n)) as well.

This complexity mainly arises from the space used by the recursive call stack during the generation of all valid combinations of balanced parentheses.
Each recursive call consumes space on the call stack until the base case is reached, and then the space is freed when the function returns. As the number of recursive calls is directly related to the number of valid combinations (the Catalan number), the space complexity is also O(4^n / sqrt(n)).