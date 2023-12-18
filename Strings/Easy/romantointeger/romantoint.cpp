#include <iostream>
#include <unordered_map>

int romanToInt(const std::string &s)
{
    // Define a unordered_map mapping Roman numerals to their integer values
    std::unordered_map<char, int> romanMap{
        {'I', 1},
        {'V', 5},
        {'X', 10},
        {'L', 50},
        {'C', 100},
        {'D', 500},
        {'M', 1000}};

    int result = 0; // Initialize the result variable to store the total integer value

    // Loop through the Roman numeral string from left to right
    for (int i = 0; i < s.length(); ++i)
    {
        // If the current numeral is smaller than the next numeral, subtract its value
        if (i < s.length() - 1 && romanMap[s[i]] < romanMap[s[i + 1]])
        {
            result -= romanMap[s[i]];
        }
        else
        {
            result += romanMap[s[i]];
        }
    }

    return result;
}

int main()
{
    // Test the function
    std::string romanNumeral;
    std::cout << "Enter a Roman numeral: ";
    std::cin >> romanNumeral;

    int integerValue = romanToInt(romanNumeral);
    std::cout << "The integer value of " << romanNumeral << " is: " << integerValue << std::endl;

    return 0;
}
