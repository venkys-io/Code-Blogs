// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Palindrome

// time complexity:O(n)
// space complexity:O(1)

#include <iostream>
#include <cctype>
using namespace std;

// Function to check if a string is a palindrome
bool checkPalindrome(string str) {
    int len = str.size();
    int i = 0, j = len - 1;

    while (i < j) {
        // Ignore non-alphanumeric characters
        // Ignore non-alphanumeric characters from the beginning of the string
        while (i < len && !isalnum(str[i])) {
            i++;
        }

        // Ignore non-alphanumeric characters from the end of the string
        while (j >= 0 && !isalnum(str[j])) {
            j--;
        }

        // If characters at positions i and j are not equal, the string is not a palindrome
        if (i < j) {
            // Compare characters case-insensitively
            if (tolower(str[i]) != tolower(str[j])) {
                return false;
            }
            // Move the pointers towards the center
            i++;
            j--;
        }
    }
    // If the loop completes without returning false, the string is a palindrome
    return true;
}

int main() {

    string str;

    // Get input from the user
    // cout << "Enter a string: ";
    getline(cin, str);

    // Check if the string is a palindrome using the checkPalindrome function
    if (checkPalindrome(str)) {
        cout << "True"<< endl;
    } else {
        cout << "False" << endl;
    }

    return 0;
}
