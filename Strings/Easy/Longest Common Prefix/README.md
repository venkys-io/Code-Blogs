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
    num_strings = int(input())
    input_strings = [input() for i in range(num_strings)]

    result = longest_common_prefix(input_strings)

    if result:
        print(result)
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
    // std::cout << "Enter the number of strings: ";
    std::cin >> numStrings;

    std::vector<std::string> inputStrings;
    inputStrings.reserve(numStrings);

    // Taking user input for a vector of strings
    for (int i = 0; i < numStrings; ++i) {
        std::string inputString;
        // std::cout << "Enter string " << i + 1 << ": ";
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

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(strings);

        // Compare the first and last strings in the sorted array
        String firstString = strings[0];
        String lastString = strings[strings.length - 1];

        StringBuilder prefix = new StringBuilder();
        int minLength = Math.min(firstString.length(), lastString.length());

        for (int i = 0; i < minLength; i++) {
            if (firstString.charAt(i) == lastString.charAt(i)) {
                prefix.append(firstString.charAt(i));
            } else {
                break;
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.print("Enter the number of strings: ");
        int numStrings = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] inputStrings = new String[numStrings];
        for (int i = 0; i < numStrings; i++) {
            inputStrings[i] = scanner.nextLine();
        }

        String result = longestCommonPrefix(inputStrings);

        if (!result.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println("No common prefix.");
        }
    }
}

## Time complexity :

The time complexity of converting a fraction to a recurring decimal is O(log n) where n is the denominator of the fraction. This is because the algorithm involves repeatedly dividing by the denominator until the remainder is less than 1. The number of iterations required is proportional to the number of digits in the numerator, which is at most log n.

## Space complexity :

The space complexity of converting a fraction to recurring decimal is O(1). This is because the conversion involves either storing a fixed size integer representation of the fraction or using a floating point representation that requires a fixed amount of memory, regardless of the size of the input fraction. If you meant to ask about the space complexity of storing recurring decimal to fraction conversion formulas, it would be O(klogk) where k is the precision of the recurring decimal.


## Test Cases
- INPUT :
  ["flower", "flow", "flight"]
  OUTPUT :
  "fl"

  For the input ["flower", "flow", "flight"], the output "fl" is obtained as follows:

  Sorting the list of strings: The list is sorted lexicographically to get ["flight", "flow", "flower"].

  Comparing the first and last strings: The function compares the first string ("flight") with the last string ("flower") character by character.

  At index 0, both "f" and "f" are the same
  At index 1, both "l" and "l" are the same.
  At index 2, "i" and "o" differ, so the loop breaks.
  Returning the prefix: The function returns "fl".

  Hence, the output "fl" represents the longest common prefix among the strings "flower", "flow", and "flight".

- INPUT :
  ["dog", "racecar", "car"]
  OUTPUT :
  ""

  For the input ["dog", "racecar", "car"], the output "" (an empty string) is obtained as follows:

  Sorting the list of strings: The list is sorted lexicographically to get ["car", "dog", "racecar"].

  Comparing the first and last strings: The function compares the first string ("car") with the last string ("racecar") character by character.

  At index 0, both "c" and "r" differ, so the loop breaks immediately.
  Returning the prefix: Since there are no common characters between the first and last strings, the function returns an empty string.

  Hence, the output "" represents the absence of a common prefix among the strings "dog", "racecar", and "car".

- INPUT :
  ["apple"]
  OUTPUT :
  "apple"

  For the input ["apple"], the output "apple" is obtained as follows:

  Sorting the list of strings: Since there's only one string in the list, no sorting is required.

  Comparing the first and last strings: Since there's only one string in the list, the function directly returns the input string "apple".

  Returning the prefix: The function returns "apple" since it's the only string in the list, and it's the longest common prefix by default.

  Hence, the output "apple" represents the longest common prefix among the single string "apple" in the list.


