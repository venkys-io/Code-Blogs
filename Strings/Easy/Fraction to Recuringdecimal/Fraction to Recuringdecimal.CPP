#include <iostream>
#include <unordered_map>
#include <string>

std::string fraction_to_recurring_decimal(int numerator, int denominator) {
if (numerator == 0) {
return "0";
}std::string result = "";

// Handle the sign
if ((numerator < 0) ^ (denominator < 0)) {
    result += "-";
}

// Convert both numerator and denominator to positive
long long numerator_abs = std::abs(static_cast<long long>(numerator));
long long denominator_abs = std::abs(static_cast<long long>(denominator));

// Calculate the integral part
result += std::to_string(numerator_abs / denominator_abs);
long long remainder = numerator_abs % denominator_abs;

if (remainder == 0) {
    return result;
}

result += ".";

// Use an unordered_map to store the position of each remainder
std::unordered_map<long long, int> remainder_positions;

while (remainder != 0) {
    if (remainder_positions.find(remainder) != remainder_positions.end()) {
        // The remainder repeats, so add parentheses and break the loop
        result.insert(remainder_positions[remainder], 1, '(');
        result += ')';
        break;
    }

    // Store the current remainder position in the result
    remainder_positions[remainder] = result.length();

    remainder *= 10;
    result += std::to_string(remainder / denominator_abs);
    remainder %= denominator_abs;
}

return result;
}
int main() {
int numerator;
int denominator;
std::string result = fraction_to_recurring_decimal(numerator, denominator);
std::cout << numerator << "/" << denominator << " = " << result << std::endl;
return 0;
}
