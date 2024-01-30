#include <iostream>
#include <string>

std::string removeVowels(const std::string& inputString) {
    std::string result;
    for (char ch : inputString) {
        if (tolower(ch) != 'a' && tolower(ch) != 'e' && tolower(ch) != 'i' && tolower(ch) != 'o' && tolower(ch) != 'u') {
            result += ch;
        }
    }
    return result;
}

int main() {
    std::string inputString;
    std::cout << "Enter a string: ";
    std::getline(std::cin, inputString);

    std::string result = removeVowels(inputString);

    std::cout << "String after removing vowels: " << result << std::endl;

    return 0;
}
