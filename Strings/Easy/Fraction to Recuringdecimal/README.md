# Fraction to Recurring Decimal

A fraction can be converted to a recurring decimal by dividing the numerator and denominator by a common factor. This process ensures that the decimal does not go on indefinitely.

## Advantages :

- They can represent ratios more accurately than decimals, they are useful in common measurements such as time and temperature, and they can be manipulated algebraically more easily.
- Decimals and fractions allow for more precise calculations, especially when dealing with very small or very large numbers. Using percentages can lead to rounding errors and imprecise results.

## Disadvantages :

- fractions can be more difficult to work with when they have large numerators or denominators, they can be less intuitive than decimals for some people, and they require certain procedures to compare or add fractions that can be error-prone if not done carefully.

## Code :

## Python code :

def fraction_to_recurring_decimal(numerator, denominator):
if numerator == 0:
return "0"result = ""

# Handle the sign
if (numerator < 0) ^ (denominator < 0):
    result += "-"

# Convert both numerator and denominator to positive
numerator, denominator = abs(numerator), abs(denominator)

# Calculate the integral part
result += str(numerator // denominator)
remainder = numerator % denominator

if remainder == 0:
    return result

result += "."

# Use a dictionary to store the position of each remainder
remainder_positions = {}

while remainder != 0:
    if remainder in remainder_positions:
        # The remainder repeats, so add parentheses and break the loop
        result = result[:remainder_positions[remainder]] + "(" + result[remainder_positions[remainder]:] + ")"
        break

    # Store the current remainder position in the result
    remainder_positions[remainder] = len(result)

    remainder *= 10
    result += str(remainder // denominator)
    remainder %= denominator

return result
numerator = int(input())
denominator = int(input())
result = fraction_to_recurring_decimal(numerator, denominator)
print(f"{numerator}/{denominator} = {result}")

## C++ code :

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
