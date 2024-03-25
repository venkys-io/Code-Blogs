#include<bits/stdc++.h>

using namespace std;

// Function to check if a given string is a palindrome
bool isPalindrome(string s){
    string rev = "";

    // Iterate through each character in the string
    for(char ch : s){
        // Check if the character is a lowercase letter (ASCII values 97 to 122)
        if(ch >= 97 && ch <= 122)
            rev += ch;
        // Check if the character is an uppercase letter (ASCII values 65 to 90)
        else if(ch >= 65 && ch <= 90)
            // Convert the uppercase letter to lowercase and add it to the 'rev' string
            rev += ch + 32;
    }

    // Initialize two pointers for comparing characters from both ends of the 'rev' string
    int i = 0, j = rev.length() - 1;

    // Iterate until the pointers meet in the middle
    while(i < j){
        // Compare characters at the current positions, and move the pointers accordingly
        if(rev[i++] != rev[j--]) return false;
    }

    // If the loop completes without finding any mismatches, the string is a palindrome
    return true;
}

// Main function
int main(){
    
    // Read the string input from the user
    std::string s;
    std::getline(std::cin, s);


    // Check if the string is a palindrome using the isPalindrome function
    if(isPalindrome(s))
        cout << "Palindrome";
    else
        cout << "Not a palindrome";

    return 0;
}
