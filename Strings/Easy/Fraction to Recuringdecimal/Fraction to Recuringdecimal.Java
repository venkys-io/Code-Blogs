import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle the sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Take the absolute values
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Add the integer part
        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> seenRemainders = new HashMap<>();

        while (remainder != 0) {
            if (seenRemainders.containsKey(remainder)) {
                // Recurring part found
                int index = seenRemainders.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

           
