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
