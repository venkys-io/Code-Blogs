# Fraction to Recurring Decimal

A fraction can be converted to a recurring decimal by dividing the numerator and denominator by a common factor. This process ensures that the decimal does not go on indefinitely.

## Advantages :

- They can represent ratios more accurately than decimals, they are useful in common measurements such as time and temperature, and they can be manipulated algebraically more easily.
- Decimals and fractions allow for more precise calculations, especially when dealing with very small or very large numbers. Using percentages can lead to rounding errors and imprecise results.

## Disadvantages :

- fractions can be more difficult to work with when they have large numerators or denominators, they can be less intuitive than decimals for some people, and they require certain procedures to compare or add fractions that can be error-prone if not done carefully.

## Code :

## Python code :


def longest_common_prefix(strings):
    if not strings:
        return ""

    # Sort the list to get the lexicographically smallest and largest strings
    strings.sort()

    # Compare the first and last strings in the sorted list
    prefix = ""
    for char1, char2 in zip(strings[0], strings[-1]):
        if char1 == char2:
            prefix += char1
        else:
            break

    return prefix

if __name__ == "__main__":
    # Taking user input for a list of strings
    num_strings = int(input("Enter the number of strings: "))
    input_strings = [input(f"Enter string {i + 1}: ") for i in range(num_strings)]

    result = longest_common_prefix(input_strings)

    if result:
        print("Longest common prefix:", result)
    else:
        print("No common prefix.")


## C++ code :

#include <iostream>
#include <vector>
#include <algorithm>

std::string longestCommonPrefix(const std::vector<std::string>& strings) {
    if (strings.empty()) {
        return "";
    }

    // Sort the strings to get the lexicographically smallest and largest strings
    std::vector<std::string> sortedStrings = strings;
    std::sort(sortedStrings.begin(), sortedStrings.end());

    // Compare the first and last strings in the sorted list
    std::string prefix = "";
    const std::string& firstString = sortedStrings.front();
    const std::string& lastString = sortedStrings.back();

    for (size_t i = 0; i < firstString.length(); ++i) {
        if (firstString[i] == lastString[i]) {
            prefix += firstString[i];
        } else {
            break;
        }
    }

    return prefix;
}

int main() {
    int numStrings;
    std::cout << "Enter the number of strings: ";
    std::cin >> numStrings;

    std::vector<std::string> inputStrings;
    inputStrings.reserve(numStrings);

    // Taking user input for a vector of strings
    for (int i = 0; i < numStrings; ++i) {
        std::string inputString;
        std::cout << "Enter string " << i + 1 << ": ";
        std::cin >> inputString;
        inputStrings.push_back(inputString);
    }

    std::string result = longestCommonPrefix(inputStrings);

    if (!result.empty()) {
        std::cout << "Longest common prefix: " << result << std::endl;
    } else {
        std::cout << "No common prefix." << std::endl;
    }

    return 0;
}


## Java Code :

import java.util.HashMap;
import java.util.Map;

public class RecurringDecimalConverter {public static String fractionToRecurringDecimal(int numerator, int denominator) {
    if (numerator == 0) {
        return "0";
    }

    StringBuilder result = new StringBuilder();

    // Handle the sign
    if ((numerator < 0) ^ (denominator < 0)) {
        result.append("-");
    }

    // Convert both numerator and denominator to positive
    long numeratorAbs = Math.abs((long) numerator);
    long denominatorAbs = Math.abs((long) denominator);

    // Calculate the integral part
    result.append(numeratorAbs / denominatorAbs);
    long remainder = numeratorAbs % denominatorAbs;

    if (remainder == 0) {
        return result.toString();
    }

    result.append(".");

    // Use a map to store the position of each remainder
    Map<Long, Integer> remainderPositions = new HashMap<>();

    while (remainder != 0) {
        if (remainderPositions.containsKey(remainder)) {
            // The remainder repeats, so add parentheses and break the loop
            result.insert(remainderPositions.get(remainder), "(");
            result.append(")");
            break;
        }

        // Store the current remainder position in the result
        remainderPositions.put(remainder, result.length());

        remainder *= 10;
        result.append(remainder / denominatorAbs);
        remainder %= denominatorAbs;
    }

    return result.toString();
}

public static void main(String[] args) {
    int numerator = 1;
    int denominator = 3;
    String result = fractionToRecurringDecimal(numerator, denominator);
    System.out.println(numerator + "/" + denominator + " = " + result);
}

}

## Time complexity :

The time complexity of converting a fraction to a recurring decimal is O(log n) where n is the denominator of the fraction. This is because the algorithm involves repeatedly dividing by the denominator until the remainder is less than 1. The number of iterations required is proportional to the number of digits in the numerator, which is at most log n.

## Space complexity :

The space complexity of converting a fraction to recurring decimal is O(1). This is because the conversion involves either storing a fixed size integer representation of the fraction or using a floating point representation that requires a fixed amount of memory, regardless of the size of the input fraction. If you meant to ask about the space complexity of storing recurring decimal to fraction conversion formulas, it would be O(klogk) where k is the precision of the recurring decimal.
