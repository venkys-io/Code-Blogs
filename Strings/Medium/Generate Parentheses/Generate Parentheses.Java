public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    generate("", n, n, result);
    return result;
}

private void generate(String s, int left, int right, List<String> result) {
    if (left == 0 && right == 0) {
        result.add(s);
        return;
    }
    if (left > 0) {
        generate(s + "(", left - 1, right, result);
    }
    if (right > left) {
        generate(s + ")", left, right - 1, result);
    }
}

public static void main(String[] args) {
    GenerateParentheses generator = new GenerateParentheses();
    int n; // Number of pairs of parentheses
    List<String> parentheses = generator.generateParenthesis(n);
    for (String p : parentheses) {
        System.out.println(p);
    }
}
