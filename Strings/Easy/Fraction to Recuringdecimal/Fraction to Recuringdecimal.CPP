#include <iostream>
#include <unordered_map>
#include <string>

std::string fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
        return "0";
    }

    std::string result;

    // Handle the sign
    if ((numerator < 0) ^ (denominator < 0)) {
        result += "-";
    }

    // Take the absolute values
    long long num = std::abs(static_cast<long long>(numerator));
    long long den = std::abs(static_cast<long long>(denominator));

    // Add the integer part
    result += std::to_string(num / den);
    long long remainder = num % den;

    if (remainder == 0) {
        return result;
    }

    result += ".";

    std::unordered_map<long long, int> seen_remainders;

    while (remainder != 0) {
        if (seen_remainders.find(remainder) != seen_remainders.end()) {
            // Recurring part found
            result.insert(seen_remainders[remainder], 1, '(');
            result += ')';
            break;
        }

        seen_remainders[remainder] = result.length();
        remainder *= 10;
        result += std::to_string(remainder / den);
        remainder %= den;
    }

    return result;
}

int main() {
    int numerator, denominator;

    std::cout << "Enter the numerator: ";
    std::cin >> numerator;

    std::cout << "Enter the denominator: ";
    std::cin >> denominator;

    std::string result = fractionToDecimal(numerator, denominator);

    std::cout << "The recurring decimal representation is: " << result << std::endl;

    return 0;
}
