import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int left, int right, int n) {
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        if (left < n) {
            backtrack(result, current + '(', left + 1, right, n);
        }

        if (right < left) {
            backtrack(result, current + ')', left, right + 1, n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of pairs of parentheses: ");
        int n = scanner.nextInt();

        List<String> parenthesesCombinations = generateParenthesis(n);

        System.out.println("Valid parentheses combinations:");
        for (String combination : parenthesesCombinations) {
            System.out.println(combination);
        }
    }
}
